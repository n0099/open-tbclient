package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes20.dex */
public abstract class a extends d {
    public abstract Random egn();

    @Override // kotlin.random.d
    public int NX(int i) {
        return e.ee(egn().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return egn().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return egn().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return egn().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return egn().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return egn().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return egn().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] az(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        egn().nextBytes(bArr);
        return bArr;
    }
}
