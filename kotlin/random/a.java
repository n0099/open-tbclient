package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dDZ();

    @Override // kotlin.random.d
    public int Jg(int i) {
        return e.dG(dDZ().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dDZ().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dDZ().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dDZ().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dDZ().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dDZ().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dDZ().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] ap(byte[] bArr) {
        q.j(bArr, com.baidu.fsg.base.statistics.b.j);
        dDZ().nextBytes(bArr);
        return bArr;
    }
}
