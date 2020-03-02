package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dKz();

    @Override // kotlin.random.d
    public int NG(int i) {
        return e.eu(dKz().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dKz().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dKz().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dKz().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dKz().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dKz().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dKz().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] aK(byte[] bArr) {
        q.j(bArr, "array");
        dKz().nextBytes(bArr);
        return bArr;
    }
}
