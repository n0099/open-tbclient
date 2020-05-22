package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dLQ();

    @Override // kotlin.random.d
    public int JR(int i) {
        return e.dL(dLQ().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dLQ().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dLQ().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dLQ().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dLQ().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dLQ().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dLQ().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] aw(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        dLQ().nextBytes(bArr);
        return bArr;
    }
}
