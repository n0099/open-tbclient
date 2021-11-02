package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bx implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadPara> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bx() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, preLoadPara, jSONObject) == null) || jSONObject == null) {
            return;
        }
        preLoadPara.spreadTime = jSONObject.optLong("spreadTime");
        preLoadPara.isValidReturned = jSONObject.optInt("isValidReturned");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(SplashPreloadManager.PreLoadPara preLoadPara, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, preLoadPara, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "spreadTime", preLoadPara.spreadTime);
            com.kwad.sdk.utils.q.a(jSONObject, "isValidReturned", preLoadPara.isValidReturned);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
