package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public abstract class a extends d {
    public abstract Random eye();

    @Override // kotlin.random.d
    public int QZ(int i) {
        return e.eq(eye().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return eye().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return eye().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return eye().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return eye().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return eye().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return eye().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] az(byte[] bArr) {
        q.n(bArr, com.baidu.fsg.base.statistics.b.j);
        eye().nextBytes(bArr);
        return bArr;
    }
}
