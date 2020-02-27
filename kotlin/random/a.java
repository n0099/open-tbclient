package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dKx();

    @Override // kotlin.random.d
    public int NG(int i) {
        return e.eu(dKx().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dKx().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dKx().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dKx().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dKx().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dKx().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dKx().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] aK(byte[] bArr) {
        q.j(bArr, "array");
        dKx().nextBytes(bArr);
        return bArr;
    }
}
