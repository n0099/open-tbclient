package com.google.common.primitives;

import b.h.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes11.dex */
public final class SignedBytes {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class LexicographicalComparator implements Comparator<byte[]> {
        public static final /* synthetic */ LexicographicalComparator[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LexicographicalComparator INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-450163176, "Lcom/google/common/primitives/SignedBytes$LexicographicalComparator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-450163176, "Lcom/google/common/primitives/SignedBytes$LexicographicalComparator;");
                    return;
                }
            }
            LexicographicalComparator lexicographicalComparator = new LexicographicalComparator("INSTANCE", 0);
            INSTANCE = lexicographicalComparator;
            $VALUES = new LexicographicalComparator[]{lexicographicalComparator};
        }

        public LexicographicalComparator(String str, int i2) {
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

        public static LexicographicalComparator valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LexicographicalComparator) Enum.valueOf(LexicographicalComparator.class, str) : (LexicographicalComparator) invokeL.objValue;
        }

        public static LexicographicalComparator[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LexicographicalComparator[]) $VALUES.clone() : (LexicographicalComparator[]) invokeV.objValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SignedBytes.lexicographicalComparator()" : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2)) == null) {
                int min = Math.min(bArr.length, bArr2.length);
                for (int i2 = 0; i2 < min; i2++) {
                    int b2 = SignedBytes.b(bArr[i2], bArr2[i2]);
                    if (b2 != 0) {
                        return b2;
                    }
                }
                return bArr.length - bArr2.length;
            }
            return invokeLL.intValue;
        }
    }

    public static byte a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65536, null, j)) == null) {
            byte b2 = (byte) j;
            n.h(((long) b2) == j, "Out of range: %s", j);
            return b2;
        }
        return invokeJ.byteValue;
    }

    public static int b(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) ? b2 - b3 : invokeCommon.intValue;
    }
}
