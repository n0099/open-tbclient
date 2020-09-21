package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes5.dex */
public abstract class a extends d {
    public abstract Random ekt();

    @Override // kotlin.random.d
    public int OC(int i) {
        return e.ei(ekt().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return ekt().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return ekt().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return ekt().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return ekt().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return ekt().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return ekt().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] az(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        ekt().nextBytes(bArr);
        return bArr;
    }
}
