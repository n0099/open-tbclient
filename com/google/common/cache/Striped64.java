package com.google.common.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;
/* loaded from: classes3.dex */
public abstract class Striped64 extends Number {
    public static /* synthetic */ Interceptable $ic;
    public static final int NCPU;
    public static final Unsafe UNSAFE;
    public static final long baseOffset;
    public static final long busyOffset;
    public static final Random rng;
    public static final ThreadLocal<int[]> threadHashCode;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile transient long base;
    public volatile transient int busy;
    public volatile transient b[] cells;

    /* loaded from: classes3.dex */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a */
        public Unsafe run() throws Exception {
            InterceptResult invokeV;
            Field[] declaredFields;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
            return (Unsafe) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final Unsafe f54708b;

        /* renamed from: c  reason: collision with root package name */
        public static final long f54709c;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile long a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1655823011, "Lcom/google/common/cache/Striped64$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1655823011, "Lcom/google/common/cache/Striped64$b;");
                    return;
                }
            }
            try {
                Unsafe unsafe = Striped64.getUnsafe();
                f54708b = unsafe;
                f54709c = unsafe.objectFieldOffset(b.class.getDeclaredField("a"));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        public b(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = j2;
        }

        public final boolean a(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? f54708b.compareAndSwapLong(this, f54709c, j2, j3) : invokeCommon.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-506750373, "Lcom/google/common/cache/Striped64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-506750373, "Lcom/google/common/cache/Striped64;");
                return;
            }
        }
        threadHashCode = new ThreadLocal<>();
        rng = new Random();
        NCPU = Runtime.getRuntime().availableProcessors();
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField(SchemeCollecter.CLASSIFY_BASE));
            busyOffset = UNSAFE.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    public Striped64() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Unsafe getUnsafe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                try {
                    return Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    return (Unsafe) AccessController.doPrivileged(new a());
                }
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }
        return (Unsafe) invokeV.objValue;
    }

    public final boolean casBase(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? UNSAFE.compareAndSwapLong(this, baseOffset, j2, j3) : invokeCommon.booleanValue;
    }

    public final boolean casBusy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1) : invokeV.booleanValue;
    }

    public abstract long fn(long j2, long j3);

    public final void internalReset(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            b[] bVarArr = this.cells;
            this.base = j2;
            if (bVarArr != null) {
                for (b bVar : bVarArr) {
                    if (bVar != null) {
                        bVar.a = j2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x00f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0027 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void retryUpdate(long j2, int[] iArr, boolean z) {
        int i2;
        int[] iArr2;
        boolean z2;
        int length;
        boolean z3;
        int length2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), iArr, Boolean.valueOf(z)}) != null) {
            return;
        }
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
                        b bVar2 = new b(j2);
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
                    long j3 = bVar.a;
                    if (bVar.a(j3, fn(j3, j2))) {
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
                        bVarArr4[i3 & 1] = new b(j2);
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
                long j4 = this.base;
                if (casBase(j4, fn(j4, j2))) {
                    return;
                }
            }
        }
    }
}
