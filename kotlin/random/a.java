package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes20.dex */
public abstract class a extends d {
    public abstract Random egw();

    @Override // kotlin.random.d
    public int NX(int i) {
        return e.ee(egw().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return egw().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return egw().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return egw().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return egw().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return egw().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return egw().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] az(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        egw().nextBytes(bArr);
        return bArr;
    }
}
