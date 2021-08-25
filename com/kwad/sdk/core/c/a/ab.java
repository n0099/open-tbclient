package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.n;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ab implements com.kwad.sdk.core.d<n.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ab() {
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
    public void a(n.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.f72035a = jSONObject.optInt("photoPlaySecond");
        aVar.f72036b = jSONObject.optInt("itemClickType");
        aVar.f72037c = jSONObject.optInt("itemCloseType");
        aVar.f72038d = jSONObject.optInt("elementType");
        aVar.f72040f = jSONObject.optString("payload");
        aVar.f72041g = jSONObject.optInt("deeplinkType");
        aVar.f72042h = jSONObject.optInt("downloadSource");
        aVar.f72043i = jSONObject.optInt("isPackageChanged");
        aVar.f72044j = jSONObject.optString("installedFrom");
        aVar.k = jSONObject.optString("downloadFailedReason");
        aVar.l = jSONObject.optInt("isChangedEndcard");
        aVar.m = jSONObject.optInt("adAggPageSource");
        aVar.n = jSONObject.optString("serverPackageName");
        aVar.o = jSONObject.optString("installedPackageName");
        aVar.p = jSONObject.optInt("closeButtonImpressionTime");
        aVar.q = jSONObject.optInt("closeButtonClickTime");
        aVar.r = jSONObject.optLong("landingPageLoadedDuration");
        aVar.s = jSONObject.optInt("downloadStatus");
        aVar.t = jSONObject.optInt("downloadCardType");
        aVar.u = jSONObject.optInt("landingPageType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(n.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "photoPlaySecond", aVar.f72035a);
            com.kwad.sdk.utils.q.a(jSONObject, "itemClickType", aVar.f72036b);
            com.kwad.sdk.utils.q.a(jSONObject, "itemCloseType", aVar.f72037c);
            com.kwad.sdk.utils.q.a(jSONObject, "elementType", aVar.f72038d);
            com.kwad.sdk.utils.q.a(jSONObject, "payload", aVar.f72040f);
            com.kwad.sdk.utils.q.a(jSONObject, "deeplinkType", aVar.f72041g);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadSource", aVar.f72042h);
            com.kwad.sdk.utils.q.a(jSONObject, "isPackageChanged", aVar.f72043i);
            com.kwad.sdk.utils.q.a(jSONObject, "installedFrom", aVar.f72044j);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadFailedReason", aVar.k);
            com.kwad.sdk.utils.q.a(jSONObject, "isChangedEndcard", aVar.l);
            com.kwad.sdk.utils.q.a(jSONObject, "adAggPageSource", aVar.m);
            com.kwad.sdk.utils.q.a(jSONObject, "serverPackageName", aVar.n);
            com.kwad.sdk.utils.q.a(jSONObject, "installedPackageName", aVar.o);
            com.kwad.sdk.utils.q.a(jSONObject, "closeButtonImpressionTime", aVar.p);
            com.kwad.sdk.utils.q.a(jSONObject, "closeButtonClickTime", aVar.q);
            com.kwad.sdk.utils.q.a(jSONObject, "landingPageLoadedDuration", aVar.r);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadStatus", aVar.s);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadCardType", aVar.t);
            com.kwad.sdk.utils.q.a(jSONObject, "landingPageType", aVar.u);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
