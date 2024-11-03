package javajigi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    }

//    @Test
//    void match_1등() {
//        List<Integer> userLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
//        assertThat(LottoGame.match(userLotto, winningLotto)).isEqualTo(1);
//    }
//
//    @Test
//    void match_2등() {
//        List<Integer> userLotto = Arrays.asList(1, 2, 3, 4, 5, 7);
//        assertThat(LottoGame.match(userLotto, winningLotto)).isEqualTo(2);
//    }

    @Test
    void match_1등() {
        assertThat(LottoGame.rank(6, false)).isEqualTo(1);
    }

    @Test
    void match_2등() {
        assertThat(LottoGame.rank(5, true)).isEqualTo(2);
    }
}