package com.google.common.hash;

import c.i.d.d.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import sun.misc.Unsafe;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public abstract class LittleEndianByteArray$UnsafeByteArray {
    public static final /* synthetic */ LittleEndianByteArray$UnsafeByteArray[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final int BYTE_ARRAY_BASE_OFFSET;
    public static final LittleEndianByteArray$UnsafeByteArray UNSAFE_BIG_ENDIAN;
    public static final LittleEndianByteArray$UnsafeByteArray UNSAFE_LITTLE_ENDIAN;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1500486029, "Lcom/google/common/hash/LittleEndianByteArray$UnsafeByteArray;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1500486029, "Lcom/google/common/hash/LittleEndianByteArray$UnsafeByteArray;");
                return;
            }
        }
        UNSAFE_LITTLE_ENDIAN = new LittleEndianByteArray$UnsafeByteArray("UNSAFE_LITTLE_ENDIAN", 0) { // from class: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10, null);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (h) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.google.common.hash.LittleEndianByteArray$UnsafeByteArray
            public long getLongLittleEndian(byte[] bArr, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, bArr, i2)) == null) ? LittleEndianByteArray$UnsafeByteArray.theUnsafe.getLong(bArr, i2 + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET) : invokeLI.longValue;
            }

            @Override // com.google.common.hash.LittleEndianByteArray$UnsafeByteArray
            public void putLongLittleEndian(byte[] bArr, int i2, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                    LittleEndianByteArray$UnsafeByteArray.theUnsafe.putLong(bArr, i2 + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, j2);
                }
            }
        };
        LittleEndianByteArray$UnsafeByteArray littleEndianByteArray$UnsafeByteArray = new LittleEndianByteArray$UnsafeByteArray("UNSAFE_BIG_ENDIAN", 1) { // from class: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10, null);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (h) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.google.common.hash.LittleEndianByteArray$UnsafeByteArray
            public long getLongLittleEndian(byte[] bArr, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, bArr, i2)) == null) ? Long.reverseBytes(LittleEndianByteArray$UnsafeByteArray.theUnsafe.getLong(bArr, i2 + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET)) : invokeLI.longValue;
            }

            @Override // com.google.common.hash.LittleEndianByteArray$UnsafeByteArray
            public void putLongLittleEndian(byte[] bArr, int i2, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                    LittleEndianByteArray$UnsafeByteArray.theUnsafe.putLong(bArr, i2 + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, Long.reverseBytes(j2));
                }
            }
        };
        UNSAFE_BIG_ENDIAN = littleEndianByteArray$UnsafeByteArray;
        $VALUES = new LittleEndianByteArray$UnsafeByteArray[]{UNSAFE_LITTLE_ENDIAN, littleEndianByteArray$UnsafeByteArray};
        Unsafe unsafe = getUnsafe();
        theUnsafe = unsafe;
        BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
        if (theUnsafe.arrayIndexScale(byte[].class) != 1) {
            throw new AssertionError();
        }
    }

    public LittleEndianByteArray$UnsafeByteArray(String str, int i2) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
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

    public static LittleEndianByteArray$UnsafeByteArray valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? (LittleEndianByteArray$UnsafeByteArray) Enum.valueOf(LittleEndianByteArray$UnsafeByteArray.class, str) : (LittleEndianByteArray$UnsafeByteArray) invokeL.objValue;
    }

    public static LittleEndianByteArray$UnsafeByteArray[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (LittleEndianByteArray$UnsafeByteArray[]) $VALUES.clone() : (LittleEndianByteArray$UnsafeByteArray[]) invokeV.objValue;
    }

    public abstract /* synthetic */ long getLongLittleEndian(byte[] bArr, int i2);

    public abstract /* synthetic */ void putLongLittleEndian(byte[] bArr, int i2, long j2);

    public /* synthetic */ LittleEndianByteArray$UnsafeByteArray(String str, int i2, h hVar) {
        this(str, i2);
    }
}
