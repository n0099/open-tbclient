package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.webview.jshandler.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements com.kwad.sdk.core.d<b.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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
    public void a(b.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.f57987b = jSONObject.optBoolean("clickActionButton");
        aVar.f57988c = jSONObject.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
        b.C2032b c2032b = new b.C2032b();
        aVar.f57989d = c2032b;
        c2032b.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.f57990e = jSONObject.optLong("creativeId", new Long("-1").longValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(b.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "clickActionButton", aVar.f57987b);
            com.kwad.sdk.utils.t.a(jSONObject, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, aVar.f57988c);
            com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.f57989d);
            com.kwad.sdk.utils.t.a(jSONObject, "creativeId", aVar.f57990e);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
