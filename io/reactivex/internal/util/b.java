package io.reactivex.internal.util;

import com.google.android.exoplayer2.Format;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public final class b {
    public static long ae(long j, long j2) {
        long j3 = j + j2;
        if (j3 < 0) {
            return Format.OFFSET_SAMPLE_RELATIVE;
        }
        return j3;
    }

    public static long af(long j, long j2) {
        long j3 = j * j2;
        if (((j | j2) >>> 31) != 0 && j3 / j != j2) {
            return Format.OFFSET_SAMPLE_RELATIVE;
        }
        return j3;
    }

    public static long a(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == Format.OFFSET_SAMPLE_RELATIVE) {
                return Format.OFFSET_SAMPLE_RELATIVE;
            }
        } while (!atomicLong.compareAndSet(j2, ae(j2, j)));
        return j2;
    }

    public static long b(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j2 == Format.OFFSET_SAMPLE_RELATIVE) {
                return Format.OFFSET_SAMPLE_RELATIVE;
            }
        } while (!atomicLong.compareAndSet(j2, ae(j2, j)));
        return j2;
    }

    public static long c(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == Format.OFFSET_SAMPLE_RELATIVE) {
                return Format.OFFSET_SAMPLE_RELATIVE;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                io.reactivex.e.a.onError(new IllegalStateException("More produced than requested: " + j3));
                j3 = 0;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }

    public static long d(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j2 == Format.OFFSET_SAMPLE_RELATIVE) {
                return Format.OFFSET_SAMPLE_RELATIVE;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                io.reactivex.e.a.onError(new IllegalStateException("More produced than requested: " + j3));
                j3 = 0;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }
}
