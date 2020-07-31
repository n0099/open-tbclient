package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dUk();

    @Override // kotlin.random.d
    public int Lu(int i) {
        return e.dW(dUk().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dUk().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dUk().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dUk().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dUk().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dUk().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dUk().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] ay(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        dUk().nextBytes(bArr);
        return bArr;
    }
}
