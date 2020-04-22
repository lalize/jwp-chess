package wooteco.chess.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wooteco.chess.domain.piece.Color;

class TurnTest {
	@Test
	@DisplayName("새로운 턴 반환")
	void next() {
		assertThat(Turn.from(Color.WHITE).next()).isEqualTo(Turn.from(Color.BLACK));
	}
}
