package com.squareup.wire;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class WireType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final WireType END_GROUP;
    public static final /* synthetic */ WireType[] ENUM$VALUES;
    public static final WireType FIXED32;
    public static final WireType FIXED64;
    public static final int FIXED_32_SIZE = 4;
    public static final int FIXED_64_SIZE = 8;
    public static final WireType LENGTH_DELIMITED;
    public static final WireType START_GROUP;
    public static final int TAG_TYPE_BITS = 3;
    public static final int TAG_TYPE_MASK = 7;
    public static final WireType VARINT;
    public transient /* synthetic */ FieldHolder $fh;
    public final int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2094146129, "Lcom/squareup/wire/WireType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2094146129, "Lcom/squareup/wire/WireType;");
                return;
            }
        }
        VARINT = new WireType("VARINT", 0, 0);
        FIXED64 = new WireType("FIXED64", 1, 1);
        LENGTH_DELIMITED = new WireType("LENGTH_DELIMITED", 2, 2);
        START_GROUP = new WireType("START_GROUP", 3, 3);
        END_GROUP = new WireType("END_GROUP", 4, 4);
        WireType wireType = new WireType("FIXED32", 5, 5);
        FIXED32 = wireType;
        ENUM$VALUES = new WireType[]{VARINT, FIXED64, LENGTH_DELIMITED, START_GROUP, END_GROUP, wireType};
    }

    public WireType(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = i2;
    }

    public static WireType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (WireType) Enum.valueOf(WireType.class, str) : (WireType) invokeL.objValue;
    }

    public static WireType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            WireType[] wireTypeArr = ENUM$VALUES;
            int length = wireTypeArr.length;
            WireType[] wireTypeArr2 = new WireType[length];
            System.arraycopy(wireTypeArr, 0, wireTypeArr2, 0, length);
            return wireTypeArr2;
        }
        return (WireType[]) invokeV.objValue;
    }

    public int value() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }

    public static WireType valueOf(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            int i2 = i & 7;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 == 5) {
                                    return FIXED32;
                                }
                                throw new IllegalArgumentException("No WireType for value " + i);
                            }
                            return END_GROUP;
                        }
                        return START_GROUP;
                    }
                    return LENGTH_DELIMITED;
                }
                return FIXED64;
            }
            return VARINT;
        }
        return (WireType) invokeI.objValue;
    }
}
