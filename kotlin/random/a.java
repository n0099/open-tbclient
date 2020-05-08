package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dDV();

    @Override // kotlin.random.d
    public int Jg(int i) {
        return e.dG(dDV().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dDV().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dDV().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dDV().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dDV().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dDV().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dDV().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] ap(byte[] bArr) {
        q.j(bArr, com.baidu.fsg.base.statistics.b.j);
        dDV().nextBytes(bArr);
        return bArr;
    }
}
