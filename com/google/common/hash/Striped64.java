package com.google.common.hash;

import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;
/* loaded from: classes6.dex */
public abstract class Striped64 extends Number {

    /* renamed from: e  reason: collision with root package name */
    public static final Unsafe f32191e;

    /* renamed from: f  reason: collision with root package name */
    public static final long f32192f;

    /* renamed from: g  reason: collision with root package name */
    public static final long f32193g;
    public volatile transient long base;
    public volatile transient int busy;
    public volatile transient b[] cells;
    public static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    public static final Random rng = new Random();
    public static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* loaded from: classes6.dex */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a */
        public Unsafe run() throws Exception {
            Field[] declaredFields;
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: b  reason: collision with root package name */
        public static final Unsafe f32194b;

        /* renamed from: c  reason: collision with root package name */
        public static final long f32195c;

        /* renamed from: a  reason: collision with root package name */
        public volatile long f32196a;

        static {
            try {
                Unsafe a2 = Striped64.a();
                f32194b = a2;
                f32195c = a2.objectFieldOffset(b.class.getDeclaredField("a"));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        public b(long j) {
            this.f32196a = j;
        }

        public final boolean a(long j, long j2) {
            return f32194b.compareAndSwapLong(this, f32195c, j, j2);
        }
    }

    static {
        try {
            Unsafe a2 = a();
            f32191e = a2;
            f32192f = a2.objectFieldOffset(Striped64.class.getDeclaredField(SchemeCollecter.CLASSIFY_BASE));
            f32193g = f32191e.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    public static Unsafe a() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new a());
        }
    }

    public final boolean casBase(long j, long j2) {
        return f32191e.compareAndSwapLong(this, f32192f, j, j2);
    }

    public final boolean casBusy() {
        return f32191e.compareAndSwapInt(this, f32193g, 0, 1);
    }

    public abstract long fn(long j, long j2);

    public final void internalReset(long j) {
        b[] bVarArr = this.cells;
        this.base = j;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    bVar.f32196a = j;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void retryUpdate(long j, int[] iArr, boolean z) {
        int i2;
        int[] iArr2;
        boolean z2;
        int length;
        boolean z3;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            threadHashCode.set(iArr2);
            i2 = rng.nextInt();
            if (i2 == 0) {
                i2 = 1;
            }
            iArr2[0] = i2;
        } else {
            i2 = iArr[0];
            iArr2 = iArr;
        }
        int i3 = i2;
        boolean z4 = false;
        boolean z5 = z;
        while (true) {
            b[] bVarArr = this.cells;
            if (bVarArr != null && (length = bVarArr.length) > 0) {
                b bVar = bVarArr[(length - 1) & i3];
                if (bVar == null) {
                    if (this.busy == 0) {
                        b bVar2 = new b(j);
                        if (this.busy == 0 && casBusy()) {
                            try {
                                b[] bVarArr2 = this.cells;
                                if (bVarArr2 != null && (length2 = bVarArr2.length) > 0) {
                                    int i4 = (length2 - 1) & i3;
                                    if (bVarArr2[i4] == null) {
                                        bVarArr2[i4] = bVar2;
                                        z3 = true;
                                        if (!z3) {
                                            return;
                                        }
                                    }
                                }
                                z3 = false;
                                if (!z3) {
                                }
                            } finally {
                            }
                        }
                    }
                    z4 = false;
                } else if (z5) {
                    long j2 = bVar.f32196a;
                    if (bVar.a(j2, fn(j2, j))) {
                        return;
                    }
                    if (length < NCPU && this.cells == bVarArr) {
                        if (!z4) {
                            z4 = true;
                        } else if (this.busy == 0 && casBusy()) {
                            try {
                                if (this.cells == bVarArr) {
                                    b[] bVarArr3 = new b[length << 1];
                                    for (int i5 = 0; i5 < length; i5++) {
                                        bVarArr3[i5] = bVarArr[i5];
                                    }
                                    this.cells = bVarArr3;
                                }
                                this.busy = 0;
                                z4 = false;
                            } finally {
                            }
                        }
                    }
                    z4 = false;
                } else {
                    z5 = true;
                }
                int i6 = i3 ^ (i3 << 13);
                int i7 = i6 ^ (i6 >>> 17);
                i3 = i7 ^ (i7 << 5);
                iArr2[0] = i3;
            } else if (this.busy == 0 && this.cells == bVarArr && casBusy()) {
                try {
                    if (this.cells == bVarArr) {
                        b[] bVarArr4 = new b[2];
                        bVarArr4[i3 & 1] = new b(j);
                        this.cells = bVarArr4;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                } finally {
                }
            } else {
                long j3 = this.base;
                if (casBase(j3, fn(j3, j))) {
                    return;
                }
            }
        }
    }
}
