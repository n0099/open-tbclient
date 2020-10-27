package kotlin.random;

import java.util.Random;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
final class KotlinRandom extends Random {
    private final d impl;

    public KotlinRandom(d dVar) {
        q.n(dVar, "impl");
        this.impl = dVar;
    }

    public final d getImpl() {
        return this.impl;
    }

    @Override // java.util.Random
    protected int next(int i) {
        return this.impl.QZ(i);
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.impl.nextInt();
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        return this.impl.nextInt(i);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.impl.nextLong();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.impl.nextFloat();
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.impl.nextDouble();
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bArr) {
        q.n(bArr, "bytes");
        this.impl.az(bArr);
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }
}
