package com.google.common.primitives;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.g.b;
import java.util.Comparator;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator implements Comparator<byte[]> {
    public static final /* synthetic */ UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1642395811, "Lcom/google/common/primitives/UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1642395811, "Lcom/google/common/primitives/UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator;");
                return;
            }
        }
        UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator unsignedBytes$LexicographicalComparatorHolder$PureJavaComparator = new UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator("INSTANCE", 0);
        INSTANCE = unsignedBytes$LexicographicalComparatorHolder$PureJavaComparator;
        $VALUES = new UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[]{unsignedBytes$LexicographicalComparatorHolder$PureJavaComparator};
    }

    public UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator(String str, int i2) {
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

    public static UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator) Enum.valueOf(UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator.class, str) : (UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator) invokeL.objValue;
    }

    public static UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[]) $VALUES.clone() : (UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "UnsignedBytes.lexicographicalComparator() (pure Java version)" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2)) == null) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int b2 = b.b(bArr[i2], bArr2[i2]);
                if (b2 != 0) {
                    return b2;
                }
            }
            return bArr.length - bArr2.length;
        }
        return invokeLL.intValue;
    }
}
