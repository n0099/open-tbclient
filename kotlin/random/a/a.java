package kotlin.random.a;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes8.dex */
public final class a extends kotlin.random.a {
    @Override // kotlin.random.a
    public Random dUk() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        q.l((Object) current, "ThreadLocalRandom.current()");
        return current;
    }

    @Override // kotlin.random.d
    public int dV(int i, int i2) {
        return ThreadLocalRandom.current().nextInt(i, i2);
    }
}
