package com.dxmpay.apollon.restnet.converter;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.rest.e;
import com.dxmpay.apollon.utils.FileCopyUtils;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.LogUtil;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class GsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    public static /* synthetic */ Interceptable $ic;
    public static final Charset a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-653396124, "Lcom/dxmpay/apollon/restnet/converter/GsonHttpMessageConverter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-653396124, "Lcom/dxmpay/apollon/restnet/converter/GsonHttpMessageConverter;");
                return;
            }
        }
        a = Charset.forName("UTF-8");
    }

    public GsonHttpMessageConverter() {
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

    private Charset a(com.dxmpay.apollon.restnet.http.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            if (aVar != null && !TextUtils.isEmpty(aVar.d())) {
                return Charset.forName(aVar.d());
            }
            return a;
        }
        return (Charset) invokeL.objValue;
    }

    @Override // com.dxmpay.apollon.restnet.converter.AbstractHttpMessageConverter
    public Object b(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, eVar)) == null) {
            InputStreamReader inputStreamReader = new InputStreamReader(eVar.b(), a(eVar.c()));
            String copyToString = FileCopyUtils.copyToString(inputStreamReader);
            a(copyToString);
            if (ApollonConstants.DEBUG) {
                int length = copyToString.length();
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 2000;
                    LogUtil.i("ServerResponse", i3 > length ? copyToString.substring(i2) : copyToString.substring(i2, i3));
                    i2 = i3;
                }
            }
            try {
                Object fromJson = JsonUtils.fromJson(copyToString, cls);
                inputStreamReader.close();
                return fromJson;
            } catch (JSONException e2) {
                throw new RestRuntimeException("Could not read JSON: " + e2.getMessage(), e2);
            }
        }
        return invokeLL.objValue;
    }
}
