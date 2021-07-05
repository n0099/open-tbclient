package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.o;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k implements com.kwad.sdk.core.c<o.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k() {
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
    @Override // com.kwad.sdk.core.c
    public JSONObject a(o.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "photoPlaySecond", aVar.f36553a);
            com.kwad.sdk.utils.o.a(jSONObject, "itemClickType", aVar.f36554b);
            com.kwad.sdk.utils.o.a(jSONObject, "itemCloseType", aVar.f36555c);
            com.kwad.sdk.utils.o.a(jSONObject, "elementType", aVar.f36556d);
            com.kwad.sdk.utils.o.a(jSONObject, "payload", aVar.f36558f);
            com.kwad.sdk.utils.o.a(jSONObject, "deeplinkType", aVar.f36559g);
            com.kwad.sdk.utils.o.a(jSONObject, "downloadSource", aVar.f36560h);
            com.kwad.sdk.utils.o.a(jSONObject, "isPackageChanged", aVar.f36561i);
            com.kwad.sdk.utils.o.a(jSONObject, "installedFrom", aVar.j);
            com.kwad.sdk.utils.o.a(jSONObject, "downloadFailedReason", aVar.k);
            com.kwad.sdk.utils.o.a(jSONObject, "isChangedEndcard", aVar.l);
            com.kwad.sdk.utils.o.a(jSONObject, "serverPackageName", aVar.m);
            com.kwad.sdk.utils.o.a(jSONObject, "installedPackageName", aVar.n);
            com.kwad.sdk.utils.o.a(jSONObject, "closeButtonImpressionTime", aVar.o);
            com.kwad.sdk.utils.o.a(jSONObject, "closeButtonClickTime", aVar.p);
            com.kwad.sdk.utils.o.a(jSONObject, "downloadStatus", aVar.q);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(o.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.f36553a = jSONObject.optInt("photoPlaySecond");
        aVar.f36554b = jSONObject.optInt("itemClickType");
        aVar.f36555c = jSONObject.optInt("itemCloseType");
        aVar.f36556d = jSONObject.optInt("elementType");
        aVar.f36558f = jSONObject.optString("payload");
        aVar.f36559g = jSONObject.optInt("deeplinkType");
        aVar.f36560h = jSONObject.optInt("downloadSource");
        aVar.f36561i = jSONObject.optInt("isPackageChanged");
        aVar.j = jSONObject.optString("installedFrom");
        aVar.k = jSONObject.optString("downloadFailedReason");
        aVar.l = jSONObject.optInt("isChangedEndcard");
        aVar.m = jSONObject.optString("serverPackageName");
        aVar.n = jSONObject.optString("installedPackageName");
        aVar.o = jSONObject.optInt("closeButtonImpressionTime");
        aVar.p = jSONObject.optInt("closeButtonClickTime");
        aVar.q = jSONObject.optInt("downloadStatus");
    }
}
