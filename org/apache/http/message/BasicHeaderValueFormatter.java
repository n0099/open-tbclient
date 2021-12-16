package org.apache.http.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;
@Deprecated
/* loaded from: classes4.dex */
public class BasicHeaderValueFormatter implements HeaderValueFormatter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BasicHeaderValueFormatter DEFAULT = null;
    public static final String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    public static final String UNSAFE_CHARS = "\"\\";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1046368948, "Lorg/apache/http/message/BasicHeaderValueFormatter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1046368948, "Lorg/apache/http/message/BasicHeaderValueFormatter;");
        }
    }

    public BasicHeaderValueFormatter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public static final String formatElements(HeaderElement[] headerElementArr, boolean z, HeaderValueFormatter headerValueFormatter) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{headerElementArr, Boolean.valueOf(z), headerValueFormatter})) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeCommon.objValue;
    }

    public static final String formatHeaderElement(HeaderElement headerElement, boolean z, HeaderValueFormatter headerValueFormatter) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{headerElement, Boolean.valueOf(z), headerValueFormatter})) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeCommon.objValue;
    }

    public static final String formatNameValuePair(NameValuePair nameValuePair, boolean z, HeaderValueFormatter headerValueFormatter) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{nameValuePair, Boolean.valueOf(z), headerValueFormatter})) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeCommon.objValue;
    }

    public static final String formatParameters(NameValuePair[] nameValuePairArr, boolean z, HeaderValueFormatter headerValueFormatter) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{nameValuePairArr, Boolean.valueOf(z), headerValueFormatter})) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeCommon.objValue;
    }

    public void doFormatValue(CharArrayBuffer charArrayBuffer, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, charArrayBuffer, str, z) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public int estimateElementsLen(HeaderElement[] headerElementArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headerElementArr)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.intValue;
    }

    public int estimateHeaderElementLen(HeaderElement headerElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, headerElement)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.intValue;
    }

    public int estimateNameValuePairLen(NameValuePair nameValuePair) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, nameValuePair)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.intValue;
    }

    public int estimateParametersLen(NameValuePair[] nameValuePairArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, nameValuePairArr)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.intValue;
    }

    public boolean isSeparator(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Character.valueOf(c2)})) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeCommon.booleanValue;
    }

    public boolean isUnsafe(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Character.valueOf(c2)})) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeCommon.booleanValue;
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatElements(CharArrayBuffer charArrayBuffer, HeaderElement[] headerElementArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, charArrayBuffer, headerElementArr, z)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (CharArrayBuffer) invokeLLZ.objValue;
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatHeaderElement(CharArrayBuffer charArrayBuffer, HeaderElement headerElement, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, charArrayBuffer, headerElement, z)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (CharArrayBuffer) invokeLLZ.objValue;
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatNameValuePair(CharArrayBuffer charArrayBuffer, NameValuePair nameValuePair, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, charArrayBuffer, nameValuePair, z)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (CharArrayBuffer) invokeLLZ.objValue;
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatParameters(CharArrayBuffer charArrayBuffer, NameValuePair[] nameValuePairArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, charArrayBuffer, nameValuePairArr, z)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (CharArrayBuffer) invokeLLZ.objValue;
    }
}
