package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public abstract class a extends d {
    public abstract Random dJo();

    @Override // kotlin.random.d
    public int ND(int i) {
        return e.er(dJo().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dJo().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dJo().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dJo().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dJo().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dJo().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dJo().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] aF(byte[] bArr) {
        q.j(bArr, "array");
        dJo().nextBytes(bArr);
        return bArr;
    }
}
