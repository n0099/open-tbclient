package com.google.common.hash;

import androidx.core.view.InputDeviceCompat;
import c.i.d.d.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.Longs;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public abstract class LittleEndianByteArray$JavaLittleEndianBytes {
    public static final /* synthetic */ LittleEndianByteArray$JavaLittleEndianBytes[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LittleEndianByteArray$JavaLittleEndianBytes INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(830070240, "Lcom/google/common/hash/LittleEndianByteArray$JavaLittleEndianBytes;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(830070240, "Lcom/google/common/hash/LittleEndianByteArray$JavaLittleEndianBytes;");
                return;
            }
        }
        LittleEndianByteArray$JavaLittleEndianBytes littleEndianByteArray$JavaLittleEndianBytes = new LittleEndianByteArray$JavaLittleEndianBytes("INSTANCE", 0) { // from class: com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes.1
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

            @Override // com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, bArr, i2)) == null) ? Longs.d(bArr[i2 + 7], bArr[i2 + 6], bArr[i2 + 5], bArr[i2 + 4], bArr[i2 + 3], bArr[i2 + 2], bArr[i2 + 1], bArr[i2]) : invokeLI.longValue;
            }

            @Override // com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes
            public void putLongLittleEndian(byte[] bArr, int i2, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                    long j3 = 255;
                    for (int i3 = 0; i3 < 8; i3++) {
                        bArr[i2 + i3] = (byte) ((j2 & j3) >> (i3 * 8));
                        j3 <<= 8;
                    }
                }
            }
        };
        INSTANCE = littleEndianByteArray$JavaLittleEndianBytes;
        $VALUES = new LittleEndianByteArray$JavaLittleEndianBytes[]{littleEndianByteArray$JavaLittleEndianBytes};
    }

    public LittleEndianByteArray$JavaLittleEndianBytes(String str, int i2) {
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

    public static LittleEndianByteArray$JavaLittleEndianBytes valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (LittleEndianByteArray$JavaLittleEndianBytes) Enum.valueOf(LittleEndianByteArray$JavaLittleEndianBytes.class, str) : (LittleEndianByteArray$JavaLittleEndianBytes) invokeL.objValue;
    }

    public static LittleEndianByteArray$JavaLittleEndianBytes[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (LittleEndianByteArray$JavaLittleEndianBytes[]) $VALUES.clone() : (LittleEndianByteArray$JavaLittleEndianBytes[]) invokeV.objValue;
    }

    public abstract /* synthetic */ long getLongLittleEndian(byte[] bArr, int i2);

    public abstract /* synthetic */ void putLongLittleEndian(byte[] bArr, int i2, long j2);

    public /* synthetic */ LittleEndianByteArray$JavaLittleEndianBytes(String str, int i2, h hVar) {
        this(str, i2);
    }
}
