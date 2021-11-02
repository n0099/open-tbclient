package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class MethodCall {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object arguments;
    public final String method;

    public MethodCall(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.method = str;
        this.arguments = obj;
    }

    @Nullable
    public <T> T argument(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Object obj = this.arguments;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Map) {
                return (T) ((Map) obj).get(str);
            }
            if (obj instanceof JSONObject) {
                return (T) ((JSONObject) obj).opt(str);
            }
            throw new ClassCastException();
        }
        return (T) invokeL.objValue;
    }

    public <T> T arguments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (T) this.arguments : (T) invokeV.objValue;
    }

    public boolean hasArgument(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Object obj = this.arguments;
            if (obj == null) {
                return false;
            }
            if (obj instanceof Map) {
                return ((Map) obj).containsKey(str);
            }
            if (obj instanceof JSONObject) {
                return ((JSONObject) obj).has(str);
            }
            throw new ClassCastException();
        }
        return invokeL.booleanValue;
    }
}
