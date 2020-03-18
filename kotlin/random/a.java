package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dLa();

    @Override // kotlin.random.d
    public int NM(int i) {
        return e.ev(dLa().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dLa().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dLa().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dLa().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dLa().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dLa().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dLa().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] aK(byte[] bArr) {
        q.j(bArr, "array");
        dLa().nextBytes(bArr);
        return bArr;
    }
}
