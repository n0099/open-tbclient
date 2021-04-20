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
    public static final Unsafe f31117e;

    /* renamed from: f  reason: collision with root package name */
    public static final long f31118f;

    /* renamed from: g  reason: collision with root package name */
    public static final long f31119g;
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
        public static final Unsafe f31120b;

        /* renamed from: c  reason: collision with root package name */
        public static final long f31121c;

        /* renamed from: a  reason: collision with root package name */
        public volatile long f31122a;

        static {
            try {
                Unsafe a2 = Striped64.a();
                f31120b = a2;
                f31121c = a2.objectFieldOffset(b.class.getDeclaredField("a"));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        public b(long j) {
            this.f31122a = j;
        }

        public final boolean a(long j, long j2) {
            return f31120b.compareAndSwapLong(this, f31121c, j, j2);
        }
    }

    static {
        try {
            Unsafe a2 = a();
            f31117e = a2;
            f31118f = a2.objectFieldOffset(Striped64.class.getDeclaredField(SchemeCollecter.CLASSIFY_BASE));
            f31119g = f31117e.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
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
        return f31117e.compareAndSwapLong(this, f31118f, j, j2);
    }

    public final boolean casBusy() {
        return f31117e.compareAndSwapInt(this, f31119g, 0, 1);
    }

    public abstract long fn(long j, long j2);

    public final void internalReset(long j) {
        b[] bVarArr = this.cells;
        this.base = j;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    bVar.f31122a = j;
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
        int i;
        int[] iArr2;
        boolean z2;
        int length;
        boolean z3;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            threadHashCode.set(iArr2);
            i = rng.nextInt();
            if (i == 0) {
                i = 1;
            }
            iArr2[0] = i;
        } else {
            i = iArr[0];
            iArr2 = iArr;
        }
        int i2 = i;
        boolean z4 = false;
        boolean z5 = z;
        while (true) {
            b[] bVarArr = this.cells;
            if (bVarArr != null && (length = bVarArr.length) > 0) {
                b bVar = bVarArr[(length - 1) & i2];
                if (bVar == null) {
                    if (this.busy == 0) {
                        b bVar2 = new b(j);
                        if (this.busy == 0 && casBusy()) {
                            try {
                                b[] bVarArr2 = this.cells;
                                if (bVarArr2 != null && (length2 = bVarArr2.length) > 0) {
                                    int i3 = (length2 - 1) & i2;
                                    if (bVarArr2[i3] == null) {
                                        bVarArr2[i3] = bVar2;
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
                    long j2 = bVar.f31122a;
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
                                    for (int i4 = 0; i4 < length; i4++) {
                                        bVarArr3[i4] = bVarArr[i4];
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
                int i5 = i2 ^ (i2 << 13);
                int i6 = i5 ^ (i5 >>> 17);
                i2 = i6 ^ (i6 << 5);
                iArr2[0] = i2;
            } else if (this.busy == 0 && this.cells == bVarArr && casBusy()) {
                try {
                    if (this.cells == bVarArr) {
                        b[] bVarArr4 = new b[2];
                        bVarArr4[i2 & 1] = new b(j);
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
