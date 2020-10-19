package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public abstract class a extends d {
    public abstract Random eog();

    @Override // kotlin.random.d
    public int Pi(int i) {
        return e.ei(eog().nextInt(), i);
    }

    @Override // kotlin.random.d
    public int nextInt() {
        return eog().nextInt();
    }

    @Override // kotlin.random.d
    public int nextInt(int i) {
        return eog().nextInt(i);
    }

    @Override // kotlin.random.d
    public long nextLong() {
        return eog().nextLong();
    }

    @Override // kotlin.random.d
    public boolean nextBoolean() {
        return eog().nextBoolean();
    }

    @Override // kotlin.random.d
    public double nextDouble() {
        return eog().nextDouble();
    }

    @Override // kotlin.random.d
    public float nextFloat() {
        return eog().nextFloat();
    }

    @Override // kotlin.random.d
    public byte[] az(byte[] bArr) {
        q.n(bArr, com.baidu.fsg.base.statistics.b.j);
        eog().nextBytes(bArr);
        return bArr;
    }
}
