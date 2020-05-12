package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dDW();

    @Override // kotlin.random.d
    public int Jg(int i) {
        return e.dG(dDW().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dDW().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dDW().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dDW().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dDW().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dDW().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dDW().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] ap(byte[] bArr) {
        q.j(bArr, com.baidu.fsg.base.statistics.b.j);
        dDW().nextBytes(bArr);
        return bArr;
    }
}
