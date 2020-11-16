package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes9.dex */
public abstract class a extends d {
    public abstract Random eBU();

    @Override // kotlin.random.d
    public int RX(int i) {
        return e.eu(eBU().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return eBU().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return eBU().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return eBU().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return eBU().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return eBU().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return eBU().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] az(byte[] bArr) {
        q.n(bArr, com.baidu.fsg.base.statistics.b.j);
        eBU().nextBytes(bArr);
        return bArr;
    }
}
