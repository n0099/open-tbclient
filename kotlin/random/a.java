package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public abstract class a extends d {
    public abstract Random dJq();

    @Override // kotlin.random.d
    public int ND(int i) {
        return e.er(dJq().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dJq().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dJq().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dJq().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dJq().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dJq().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dJq().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] aF(byte[] bArr) {
        q.j(bArr, "array");
        dJq().nextBytes(bArr);
        return bArr;
    }
}
