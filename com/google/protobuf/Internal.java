package com.google.protobuf;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
/* loaded from: classes10.dex */
public class Internal {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* loaded from: classes10.dex */
    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i2);
    }

    public Internal() {
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

    public static ByteString bytesDefaultValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                return ByteString.copyFrom(str.getBytes("ISO-8859-1"));
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Java VM does not support a standard character set.", e2);
            }
        }
        return (ByteString) invokeL.objValue;
    }

    public static boolean isValidUtf8(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, byteString)) == null) ? byteString.isValidUtf8() : invokeL.booleanValue;
    }

    public static String stringDefaultValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return new String(str.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Java VM does not support a standard character set.", e2);
            }
        }
        return (String) invokeL.objValue;
    }
}
