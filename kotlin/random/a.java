package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class a extends d {
    public abstract Random dMe();

    @Override // kotlin.random.d
    public int JT(int i) {
        return e.dL(dMe().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return dMe().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return dMe().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return dMe().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return dMe().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return dMe().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return dMe().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] aw(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        dMe().nextBytes(bArr);
        return bArr;
    }
}
