package com.qq.e.comm.managers.setting;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final Object a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f75685a.opt(str) : invokeL.objValue;
    }

    public final Object a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            JSONObject optJSONObject = this.f75685a.optJSONObject("ps");
            JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
            if (optJSONObject2 != null) {
                return optJSONObject2.opt(str);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public final void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) {
            try {
                this.f75685a.putOpt(str, obj);
            } catch (JSONException unused) {
                GDTLogger.d("Exception while update setting");
            }
        }
    }

    public final void a(String str, Object obj, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, obj, str2) == null) {
            try {
                JSONObject optJSONObject = this.f75685a.optJSONObject("ps");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    this.f75685a.putOpt("ps", optJSONObject);
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                    optJSONObject.putOpt(str2, optJSONObject2);
                }
                if (obj == null) {
                    optJSONObject2.remove(str);
                } else {
                    optJSONObject2.putOpt(str, obj);
                }
            } catch (JSONException unused) {
                GDTLogger.d("Exception while update setting");
            }
        }
    }
}
