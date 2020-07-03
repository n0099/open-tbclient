package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dQK();

    @Override // kotlin.random.d
    public int La(int i) {
        return e.dU(dQK().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dQK().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dQK().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dQK().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dQK().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dQK().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dQK().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] ay(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        dQK().nextBytes(bArr);
        return bArr;
    }
}
