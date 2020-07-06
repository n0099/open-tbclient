package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dQO();

    @Override // kotlin.random.d
    public int La(int i) {
        return e.dU(dQO().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dQO().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dQO().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dQO().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dQO().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dQO().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dQO().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] ay(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        dQO().nextBytes(bArr);
        return bArr;
    }
}
