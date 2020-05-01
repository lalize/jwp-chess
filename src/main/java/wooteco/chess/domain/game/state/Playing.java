package wooteco.chess.domain.game.state;

import wooteco.chess.domain.game.Board;
import wooteco.chess.domain.game.Score;
import wooteco.chess.domain.game.Status;
import wooteco.chess.domain.game.Turn;
import wooteco.chess.domain.game.exception.InvalidTurnException;
import wooteco.chess.domain.piece.Color;
import wooteco.chess.domain.piece.Piece;
import wooteco.chess.domain.piece.Position;

public class Playing implements State {
	private Board board;
	private Turn turn;

	public Playing(Board board, Turn turn) {
		this.board = board;
		this.turn = turn;
	}

	@Override
	public State start() {
		throw new UnsupportedOperationException();
	}

	@Override
	public State end() {
		return new Finished(board, turn);
	}

	@Override
	public State move(Position source, Position target) {
		Piece sourcePiece = board.findPiece(source);
		Piece targetPiece = board.findPiece(target);
		validateTurn(sourcePiece);
		sourcePiece.move(targetPiece);
		if (board.isKingDead()) {
			return end();
		}
		nextTurn();
		return this;
	}

	private void validateTurn(Piece piece) {
		if (piece.isDifferentColor(turn.getColor())) {
			throw new InvalidTurnException(turn);
		}
	}

	private void nextTurn() {
		turn = turn.next();
	}

	@Override
	public Board board() {
		return board;
	}

	private Score score(Color color) {
		return Score.calculate(board.findPiecesByColor(color));
	}

	@Override
	public Turn turn() {
		return turn;
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public Status status() {
		Score whiteScore = score(Color.WHITE);
		Score blackScore = score(Color.BLACK);
		Color winner = Color.NONE;
		if (whiteScore.isOverThan(blackScore)) {
			winner = Color.WHITE;
		}
		if (blackScore.isOverThan(whiteScore)) {
			winner = Color.BLACK;
		}
		return new Status(whiteScore, blackScore, winner);
	}

	@Override
	public String toString() {
		return "PLAYING";
	}
}
