package javajigi;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    void create() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto1).isEqualTo(new Lotto("1,2,3,4,5,6"));

        Lotto lotto2 = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto2).isEqualTo(new Lotto("1,2,3,4,5,6"));

        Lotto lotto3 = new Lotto(Sets.set(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));
        assertThat(lotto3).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}