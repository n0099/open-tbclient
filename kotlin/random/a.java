package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dUl();

    @Override // kotlin.random.d
    public int Lu(int i) {
        return e.dW(dUl().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dUl().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dUl().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dUl().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dUl().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dUl().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dUl().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] ay(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        dUl().nextBytes(bArr);
        return bArr;
    }
}
