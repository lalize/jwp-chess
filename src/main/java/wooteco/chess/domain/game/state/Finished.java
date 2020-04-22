package wooteco.chess.domain.game.state;

import wooteco.chess.domain.game.Board;
import wooteco.chess.domain.game.Score;
import wooteco.chess.domain.game.Status;
import wooteco.chess.domain.game.Turn;
import wooteco.chess.domain.piece.Color;
import wooteco.chess.domain.piece.Position;

public class Finished implements State {
	private Board board;
	private Turn turn;

	public Finished(Board board, Turn turn) {
		this.board = board;
		this.turn = turn;
	}

	private Score score(Color color) {
		return Score.calculate(board.findPiecesByColor(color));
	}

	@Override
	public State start() {
		throw new UnsupportedOperationException();
	}

	@Override
	public State end() {
		throw new UnsupportedOperationException();
	}

	@Override
	public State move(Position source, Position target) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Board board() {
		return board;
	}

	@Override
	public Turn turn() {
		return turn;
	}

	@Override
	public boolean isFinished() {
		return true;
	}

	@Override
	public Status status() {
		Color winner = Color.WHITE;
		if (board.hasKing(Color.BLACK)) {
			winner = Color.BLACK;
		}
		return new Status(score(Color.WHITE), score(Color.BLACK), winner);
	}

	@Override
	public String toString() {
		return "FINISHED";
	}
}
