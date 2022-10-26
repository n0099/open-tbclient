package com.squareup.wire2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.ProtocolException;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class FieldEncoding {
    public static final /* synthetic */ FieldEncoding[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FieldEncoding FIXED32;
    public static final FieldEncoding FIXED64;
    public static final FieldEncoding LENGTH_DELIMITED;
    public static final FieldEncoding VARINT;
    public transient /* synthetic */ FieldHolder $fh;
    public final int value;

    /* loaded from: classes8.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(265940048, "Lcom/squareup/wire2/FieldEncoding$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(265940048, "Lcom/squareup/wire2/FieldEncoding$a;");
                    return;
                }
            }
            int[] iArr = new int[FieldEncoding.values().length];
            a = iArr;
            try {
                iArr[FieldEncoding.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FieldEncoding.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FieldEncoding.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1604190739, "Lcom/squareup/wire2/FieldEncoding;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1604190739, "Lcom/squareup/wire2/FieldEncoding;");
                return;
            }
        }
        VARINT = new FieldEncoding("VARINT", 0, 0);
        FIXED64 = new FieldEncoding("FIXED64", 1, 1);
        LENGTH_DELIMITED = new FieldEncoding("LENGTH_DELIMITED", 2, 2);
        FieldEncoding fieldEncoding = new FieldEncoding("FIXED32", 3, 5);
        FIXED32 = fieldEncoding;
        $VALUES = new FieldEncoding[]{VARINT, FIXED64, LENGTH_DELIMITED, fieldEncoding};
    }

    public FieldEncoding(String str, int i, int i2) {
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

    public static FieldEncoding get(int i) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 5) {
                            return FIXED32;
                        }
                        throw new ProtocolException("Unexpected FieldEncoding: " + i);
                    }
                    return LENGTH_DELIMITED;
                }
                return FIXED64;
            }
            return VARINT;
        }
        return (FieldEncoding) invokeI.objValue;
    }

    public static FieldEncoding valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (FieldEncoding) Enum.valueOf(FieldEncoding.class, str);
        }
        return (FieldEncoding) invokeL.objValue;
    }

    public static FieldEncoding[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (FieldEncoding[]) $VALUES.clone();
        }
        return (FieldEncoding[]) invokeV.objValue;
    }

    public ProtoAdapter rawProtoAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = a.a[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return ProtoAdapter.BYTES;
                        }
                        throw new AssertionError();
                    }
                    return ProtoAdapter.FIXED64;
                }
                return ProtoAdapter.FIXED32;
            }
            return ProtoAdapter.UINT64;
        }
        return (ProtoAdapter) invokeV.objValue;
    }
}
