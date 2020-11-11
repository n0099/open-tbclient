package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public abstract class a extends d {
    public abstract Random eBT();

    @Override // kotlin.random.d
    public int Ru(int i) {
        return e.et(eBT().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return eBT().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return eBT().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return eBT().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return eBT().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return eBT().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return eBT().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] az(byte[] bArr) {
        q.n(bArr, com.baidu.fsg.base.statistics.b.j);
        eBT().nextBytes(bArr);
        return bArr;
    }
}
