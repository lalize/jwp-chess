package wooteco.chess.domain.game.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wooteco.chess.domain.game.Board;
import wooteco.chess.domain.game.Status;
import wooteco.chess.domain.game.Turn;
import wooteco.chess.domain.piece.Position;

public class FinishedTest {
	private State state = new Finished(Board.EMPTY, Turn.WHITE);

	@Test
	@DisplayName("피니시드 생성")
	void constructor() {
		assertThat(state).isInstanceOf(Finished.class);
	}

	@Test
	@DisplayName("게임 종료 후 시작시 예외 발생")
	void start() {
		assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> state.start());
	}

	@Test
	@DisplayName("게임 종료 후 종료 시 예외 발생")
	void end() {
		assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> state.end());
	}

	@Test
	@DisplayName("게임 종료 후 이동시 예외 발생")
	void move() {
		assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(
				() -> state.move(Position.from("a2"), Position.from("a3")));
	}

	@Test
	@DisplayName("게임 종료 후 체스판 확인")
	void board() {
		assertThat(state.board()).isInstanceOf(Board.class);
	}

	@Test
	@DisplayName("게임 종료 후 결과 확인")
	void status() {
		assertThat(state.status()).isInstanceOf(Status.class);
	}

	@Test
	@DisplayName("게임 종료 상태는 참이다")
	void isFinished() {
		assertThat(state.isFinished()).isTrue();
	}
}
