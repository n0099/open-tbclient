package kotlin.random.a;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public final class a extends kotlin.random.a {
    @Override // kotlin.random.a
    public Random dJo() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        q.i(current, "ThreadLocalRandom.current()");
        return current;
    }

    @Override // kotlin.random.d
    public int eq(int i, int i2) {
        return ThreadLocalRandom.current().nextInt(i, i2);
    }
}
