package com.fun.ad.sdk.internal.api.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class FormedParams extends RequestParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormedParams() {
        super(ContentType.FORMED);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ContentType) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new HashMap();
    }

    @Override // com.fun.ad.sdk.internal.api.http.RequestParams
    public byte[] flatToBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? flatToString().getBytes(Charset.forName("UTF-8")) : (byte[]) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.http.RequestParams
    public String flatToString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            for (String str : this.d.keySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(str);
                String str2 = this.d.get(str);
                if (str2 != null) {
                    sb.append("=");
                    try {
                        sb.append(URLEncoder.encode(str2, "UTF-8"));
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.http.RequestParams
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ContentType.FORMED.toString() : (String) invokeV.objValue;
    }

    public void put(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.d.put(str, str2);
        }
    }

    public void put(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
            this.d.putAll(map);
        }
    }
}
