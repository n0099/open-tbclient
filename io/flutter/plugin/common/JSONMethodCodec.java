package io.flutter.plugin.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class JSONMethodCodec implements MethodCodec {
    public static /* synthetic */ Interceptable $ic;
    public static final JSONMethodCodec INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(764670854, "Lio/flutter/plugin/common/JSONMethodCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(764670854, "Lio/flutter/plugin/common/JSONMethodCodec;");
                return;
            }
        }
        INSTANCE = new JSONMethodCodec();
    }

    public JSONMethodCodec() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // io.flutter.plugin.common.MethodCodec
    public Object decodeEnvelope(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) {
            try {
                Object decodeMessage = JSONMessageCodec.INSTANCE.decodeMessage(byteBuffer);
                if (decodeMessage instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) decodeMessage;
                    if (jSONArray.length() == 1) {
                        return unwrapNull(jSONArray.opt(0));
                    }
                    if (jSONArray.length() == 3) {
                        Object obj = jSONArray.get(0);
                        Object unwrapNull = unwrapNull(jSONArray.opt(1));
                        Object unwrapNull2 = unwrapNull(jSONArray.opt(2));
                        if ((obj instanceof String) && (unwrapNull == null || (unwrapNull instanceof String))) {
                            throw new FlutterException((String) obj, (String) unwrapNull, unwrapNull2);
                        }
                    }
                }
                throw new IllegalArgumentException("Invalid envelope: " + decodeMessage);
            } catch (JSONException e2) {
                throw new IllegalArgumentException("Invalid JSON", e2);
            }
        }
        return invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    public MethodCall decodeMethodCall(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer)) == null) {
            try {
                Object decodeMessage = JSONMessageCodec.INSTANCE.decodeMessage(byteBuffer);
                if (decodeMessage instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) decodeMessage;
                    Object obj = jSONObject.get("method");
                    Object unwrapNull = unwrapNull(jSONObject.opt("args"));
                    if (obj instanceof String) {
                        return new MethodCall((String) obj, unwrapNull);
                    }
                }
                throw new IllegalArgumentException("Invalid method call: " + decodeMessage);
            } catch (JSONException e2) {
                throw new IllegalArgumentException("Invalid JSON", e2);
            }
        }
        return (MethodCall) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    public ByteBuffer encodeErrorEnvelope(String str, String str2, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, obj)) == null) ? JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(str).put(JSONUtil.wrap(str2)).put(JSONUtil.wrap(obj))) : (ByteBuffer) invokeLLL.objValue;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    public ByteBuffer encodeErrorEnvelopeWithStacktrace(String str, String str2, Object obj, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, str2, obj, str3)) == null) ? JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(str).put(JSONUtil.wrap(str2)).put(JSONUtil.wrap(obj)).put(JSONUtil.wrap(str3))) : (ByteBuffer) invokeLLLL.objValue;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    public ByteBuffer encodeMethodCall(MethodCall methodCall) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, methodCall)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("method", methodCall.method);
                jSONObject.put("args", JSONUtil.wrap(methodCall.arguments));
                return JSONMessageCodec.INSTANCE.encodeMessage(jSONObject);
            } catch (JSONException e2) {
                throw new IllegalArgumentException("Invalid JSON", e2);
            }
        }
        return (ByteBuffer) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    public ByteBuffer encodeSuccessEnvelope(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(JSONUtil.wrap(obj))) : (ByteBuffer) invokeL.objValue;
    }

    public Object unwrapNull(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == JSONObject.NULL) {
                return null;
            }
            return obj;
        }
        return invokeL.objValue;
    }
}
