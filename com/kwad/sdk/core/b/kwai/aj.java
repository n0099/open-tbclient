package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.p;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class aj implements com.kwad.sdk.core.d<p.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public aj() {
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
    public void a(p.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("photoPlaySecond");
        aVar.f57681b = jSONObject.optInt("itemClickType");
        aVar.f57682c = jSONObject.optInt("itemCloseType");
        aVar.f57683d = jSONObject.optInt("elementType");
        aVar.f57684e = jSONObject.optInt("impFailReason");
        aVar.f57685f = jSONObject.optInt("winEcpm");
        aVar.f57687h = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            aVar.f57687h = "";
        }
        aVar.f57688i = jSONObject.optInt("deeplinkType");
        aVar.f57689j = jSONObject.optInt("downloadSource");
        aVar.f57690k = jSONObject.optInt("isPackageChanged");
        aVar.l = jSONObject.optString("installedFrom");
        if (jSONObject.opt("installedFrom") == JSONObject.NULL) {
            aVar.l = "";
        }
        aVar.m = jSONObject.optString("downloadFailedReason");
        if (jSONObject.opt("downloadFailedReason") == JSONObject.NULL) {
            aVar.m = "";
        }
        aVar.n = jSONObject.optInt("isChangedEndcard");
        aVar.o = jSONObject.optInt("adAggPageSource");
        aVar.p = jSONObject.optString("serverPackageName");
        if (jSONObject.opt("serverPackageName") == JSONObject.NULL) {
            aVar.p = "";
        }
        aVar.q = jSONObject.optString("installedPackageName");
        if (jSONObject.opt("installedPackageName") == JSONObject.NULL) {
            aVar.q = "";
        }
        aVar.r = jSONObject.optInt("closeButtonImpressionTime");
        aVar.s = jSONObject.optInt("closeButtonClickTime");
        aVar.t = jSONObject.optLong("landingPageLoadedDuration");
        aVar.u = jSONObject.optInt("downloadStatus");
        aVar.v = jSONObject.optInt("downloadCardType");
        aVar.w = jSONObject.optInt("landingPageType");
        aVar.x = jSONObject.optLong("playedDuration");
        aVar.y = jSONObject.optInt("playedRate");
        aVar.z = jSONObject.optInt("adOrder");
        aVar.A = jSONObject.optInt("adInterstitialSource");
        aVar.B = jSONObject.optDouble("splashShakeAcceleration");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(p.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "photoPlaySecond", aVar.a);
            com.kwad.sdk.utils.t.a(jSONObject, "itemClickType", aVar.f57681b);
            com.kwad.sdk.utils.t.a(jSONObject, "itemCloseType", aVar.f57682c);
            com.kwad.sdk.utils.t.a(jSONObject, "elementType", aVar.f57683d);
            com.kwad.sdk.utils.t.a(jSONObject, "impFailReason", aVar.f57684e);
            com.kwad.sdk.utils.t.a(jSONObject, "winEcpm", aVar.f57685f);
            com.kwad.sdk.utils.t.a(jSONObject, "payload", aVar.f57687h);
            com.kwad.sdk.utils.t.a(jSONObject, "deeplinkType", aVar.f57688i);
            com.kwad.sdk.utils.t.a(jSONObject, "downloadSource", aVar.f57689j);
            com.kwad.sdk.utils.t.a(jSONObject, "isPackageChanged", aVar.f57690k);
            com.kwad.sdk.utils.t.a(jSONObject, "installedFrom", aVar.l);
            com.kwad.sdk.utils.t.a(jSONObject, "downloadFailedReason", aVar.m);
            com.kwad.sdk.utils.t.a(jSONObject, "isChangedEndcard", aVar.n);
            com.kwad.sdk.utils.t.a(jSONObject, "adAggPageSource", aVar.o);
            com.kwad.sdk.utils.t.a(jSONObject, "serverPackageName", aVar.p);
            com.kwad.sdk.utils.t.a(jSONObject, "installedPackageName", aVar.q);
            com.kwad.sdk.utils.t.a(jSONObject, "closeButtonImpressionTime", aVar.r);
            com.kwad.sdk.utils.t.a(jSONObject, "closeButtonClickTime", aVar.s);
            com.kwad.sdk.utils.t.a(jSONObject, "landingPageLoadedDuration", aVar.t);
            com.kwad.sdk.utils.t.a(jSONObject, "downloadStatus", aVar.u);
            com.kwad.sdk.utils.t.a(jSONObject, "downloadCardType", aVar.v);
            com.kwad.sdk.utils.t.a(jSONObject, "landingPageType", aVar.w);
            com.kwad.sdk.utils.t.a(jSONObject, "playedDuration", aVar.x);
            com.kwad.sdk.utils.t.a(jSONObject, "playedRate", aVar.y);
            com.kwad.sdk.utils.t.a(jSONObject, "adOrder", aVar.z);
            com.kwad.sdk.utils.t.a(jSONObject, "adInterstitialSource", aVar.A);
            com.kwad.sdk.utils.t.a(jSONObject, "splashShakeAcceleration", aVar.B);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
