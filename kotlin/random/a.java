package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dKA();

    @Override // kotlin.random.d
    public int NG(int i) {
        return e.eu(dKA().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dKA().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dKA().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dKA().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dKA().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dKA().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dKA().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] aK(byte[] bArr) {
        q.j(bArr, "array");
        dKA().nextBytes(bArr);
        return bArr;
    }
}
