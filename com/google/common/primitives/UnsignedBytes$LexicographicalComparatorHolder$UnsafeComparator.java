package com.google.common.primitives;

import androidx.core.view.InputDeviceCompat;
import c.i.d.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import sun.misc.Unsafe;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator implements Comparator<byte[]> {
    public static final /* synthetic */ UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final boolean BIG_ENDIAN;
    public static final int BYTE_ARRAY_BASE_OFFSET;
    public static final UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator INSTANCE;
    public static final Unsafe theUnsafe;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1686827023, "Lcom/google/common/primitives/UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1686827023, "Lcom/google/common/primitives/UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator;");
                return;
            }
        }
        UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator unsignedBytes$LexicographicalComparatorHolder$UnsafeComparator = new UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator("INSTANCE", 0);
        INSTANCE = unsignedBytes$LexicographicalComparatorHolder$UnsafeComparator;
        $VALUES = new UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[]{unsignedBytes$LexicographicalComparatorHolder$UnsafeComparator};
        BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
        Unsafe unsafe = getUnsafe();
        theUnsafe = unsafe;
        BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
        if (!WebKitFactory.OS_64.equals(System.getProperty("sun.arch.data.model")) || BYTE_ARRAY_BASE_OFFSET % 8 != 0 || theUnsafe.arrayIndexScale(byte[].class) != 1) {
            throw new Error();
        }
    }

    public UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Unsafe getUnsafe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
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

    public static UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator) Enum.valueOf(UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.class, str) : (UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator) invokeL.objValue;
    }

    public static UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[]) $VALUES.clone() : (UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2)) == null) {
            int min = Math.min(bArr.length, bArr2.length);
            int i2 = min & (-8);
            int i3 = 0;
            while (i3 < i2) {
                long j2 = i3;
                long j3 = theUnsafe.getLong(bArr, BYTE_ARRAY_BASE_OFFSET + j2);
                long j4 = theUnsafe.getLong(bArr2, BYTE_ARRAY_BASE_OFFSET + j2);
                if (j3 != j4) {
                    if (BIG_ENDIAN) {
                        return UnsignedLongs.a(j3, j4);
                    }
                    int numberOfTrailingZeros = Long.numberOfTrailingZeros(j3 ^ j4) & (-8);
                    return ((int) ((j3 >>> numberOfTrailingZeros) & 255)) - ((int) ((j4 >>> numberOfTrailingZeros) & 255));
                }
                i3 += 8;
            }
            while (i3 < min) {
                int b2 = b.b(bArr[i3], bArr2[i3]);
                if (b2 != 0) {
                    return b2;
                }
                i3++;
            }
            return bArr.length - bArr2.length;
        }
        return invokeLL.intValue;
    }
}
