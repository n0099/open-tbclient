package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.item.InsertScreenConfigItem;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class az implements com.kwad.sdk.core.d<InsertScreenConfigItem.InsertScreenConfig> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public az() {
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
    public void a(InsertScreenConfigItem.InsertScreenConfig insertScreenConfig, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, insertScreenConfig, jSONObject) == null) || jSONObject == null) {
            return;
        }
        insertScreenConfig.firstPosition = jSONObject.optInt("firstPosition", new Integer("1").intValue());
        insertScreenConfig.interval = jSONObject.optInt("interval", new Integer("3").intValue());
        insertScreenConfig.threshold = jSONObject.optInt("threshold", new Integer("2").intValue());
        insertScreenConfig.preRequestCount = jSONObject.optInt("preRequestCount", new Integer("2").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(InsertScreenConfigItem.InsertScreenConfig insertScreenConfig, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, insertScreenConfig, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "firstPosition", insertScreenConfig.firstPosition);
            com.kwad.sdk.utils.q.a(jSONObject, "interval", insertScreenConfig.interval);
            com.kwad.sdk.utils.q.a(jSONObject, "threshold", insertScreenConfig.threshold);
            com.kwad.sdk.utils.q.a(jSONObject, "preRequestCount", insertScreenConfig.preRequestCount);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
