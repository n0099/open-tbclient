package com.bytedance.sdk.openadsdk.i.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.q;
import com.bytedance.sdk.openadsdk.core.w;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g extends com.bytedance.sdk.component.a.e<JSONObject, JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f31235a;

    /* renamed from: b  reason: collision with root package name */
    public w f31236b;

    public g(String str, w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, wVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31236b = wVar;
        this.f31235a = str;
    }

    public static void a(q qVar, w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, qVar, wVar) == null) {
            qVar.a(DI.APP_INFO_NAME, (com.bytedance.sdk.component.a.e<?, ?>) new g(DI.APP_INFO_NAME, wVar));
            qVar.a("adInfo", (com.bytedance.sdk.component.a.e<?, ?>) new g("adInfo", wVar));
            qVar.a("playable_style", (com.bytedance.sdk.component.a.e<?, ?>) new g("playable_style", wVar));
            qVar.a("getTemplateInfo", (com.bytedance.sdk.component.a.e<?, ?>) new g("getTemplateInfo", wVar));
            qVar.a("getTeMaiAds", (com.bytedance.sdk.component.a.e<?, ?>) new g("getTeMaiAds", wVar));
            qVar.a("isViewable", (com.bytedance.sdk.component.a.e<?, ?>) new g("isViewable", wVar));
            qVar.a("getScreenSize", (com.bytedance.sdk.component.a.e<?, ?>) new g("getScreenSize", wVar));
            qVar.a("getCloseButtonInfo", (com.bytedance.sdk.component.a.e<?, ?>) new g("getCloseButtonInfo", wVar));
            qVar.a("getVolume", (com.bytedance.sdk.component.a.e<?, ?>) new g("getVolume", wVar));
            qVar.a("removeLoading", (com.bytedance.sdk.component.a.e<?, ?>) new g("removeLoading", wVar));
            qVar.a("sendReward", (com.bytedance.sdk.component.a.e<?, ?>) new g("sendReward", wVar));
            qVar.a("subscribe_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new g("subscribe_app_ad", wVar));
            qVar.a("download_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new g("download_app_ad", wVar));
            qVar.a("cancel_download_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new g("cancel_download_app_ad", wVar));
            qVar.a("unsubscribe_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new g("unsubscribe_app_ad", wVar));
            qVar.a("landscape_click", (com.bytedance.sdk.component.a.e<?, ?>) new g("landscape_click", wVar));
            qVar.a("clickEvent", (com.bytedance.sdk.component.a.e<?, ?>) new g("clickEvent", wVar));
            qVar.a("renderDidFinish", (com.bytedance.sdk.component.a.e<?, ?>) new g("renderDidFinish", wVar));
            qVar.a("dynamicTrack", (com.bytedance.sdk.component.a.e<?, ?>) new g("dynamicTrack", wVar));
            qVar.a("skipVideo", (com.bytedance.sdk.component.a.e<?, ?>) new g("skipVideo", wVar));
            qVar.a("muteVideo", (com.bytedance.sdk.component.a.e<?, ?>) new g("muteVideo", wVar));
            qVar.a("changeVideoState", (com.bytedance.sdk.component.a.e<?, ?>) new g("changeVideoState", wVar));
            qVar.a("getCurrentVideoState", (com.bytedance.sdk.component.a.e<?, ?>) new g("getCurrentVideoState", wVar));
            qVar.a("send_temai_product_ids", (com.bytedance.sdk.component.a.e<?, ?>) new g("send_temai_product_ids", wVar));
            qVar.a("getMaterialMeta", (com.bytedance.sdk.component.a.e<?, ?>) new g("getMaterialMeta", wVar));
            qVar.a("endcard_load", (com.bytedance.sdk.component.a.e<?, ?>) new g("endcard_load", wVar));
            qVar.a("pauseWebView", (com.bytedance.sdk.component.a.e<?, ?>) new g("pauseWebView", wVar));
            qVar.a("pauseWebViewTimers", (com.bytedance.sdk.component.a.e<?, ?>) new g("pauseWebViewTimers", wVar));
            qVar.a("webview_time_track", (com.bytedance.sdk.component.a.e<?, ?>) new g("webview_time_track", wVar));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.a.e
    @Nullable
    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.a.f fVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, fVar)) == null) {
            w.a aVar = new w.a();
            aVar.f30634a = NotificationCompat.CATEGORY_CALL;
            aVar.f30636c = this.f31235a;
            aVar.f30637d = jSONObject;
            JSONObject a2 = this.f31236b.a(aVar, 3);
            if (com.bytedance.sdk.openadsdk.core.h.d().x()) {
                Log.d("OldBridgeSyncMethod", "[JSB-RSP] version: 3 data=" + a2.toString());
            }
            return a2;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
