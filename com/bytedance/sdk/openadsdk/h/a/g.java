package com.bytedance.sdk.openadsdk.h.a;

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
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.openadsdk.core.w;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g extends com.bytedance.sdk.component.a.e<JSONObject, JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f68218a;

    /* renamed from: b  reason: collision with root package name */
    public w f68219b;

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
        this.f68219b = wVar;
        this.f68218a = str;
    }

    public static void a(r rVar, w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, rVar, wVar) == null) {
            rVar.a(DI.APP_INFO_NAME, (com.bytedance.sdk.component.a.e<?, ?>) new g(DI.APP_INFO_NAME, wVar));
            rVar.a("adInfo", (com.bytedance.sdk.component.a.e<?, ?>) new g("adInfo", wVar));
            rVar.a("playable_style", (com.bytedance.sdk.component.a.e<?, ?>) new g("playable_style", wVar));
            rVar.a("getTemplateInfo", (com.bytedance.sdk.component.a.e<?, ?>) new g("getTemplateInfo", wVar));
            rVar.a("getTeMaiAds", (com.bytedance.sdk.component.a.e<?, ?>) new g("getTeMaiAds", wVar));
            rVar.a("isViewable", (com.bytedance.sdk.component.a.e<?, ?>) new g("isViewable", wVar));
            rVar.a("getScreenSize", (com.bytedance.sdk.component.a.e<?, ?>) new g("getScreenSize", wVar));
            rVar.a("getCloseButtonInfo", (com.bytedance.sdk.component.a.e<?, ?>) new g("getCloseButtonInfo", wVar));
            rVar.a("getVolume", (com.bytedance.sdk.component.a.e<?, ?>) new g("getVolume", wVar));
            rVar.a("removeLoading", (com.bytedance.sdk.component.a.e<?, ?>) new g("removeLoading", wVar));
            rVar.a("sendReward", (com.bytedance.sdk.component.a.e<?, ?>) new g("sendReward", wVar));
            rVar.a("subscribe_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new g("subscribe_app_ad", wVar));
            rVar.a("download_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new g("download_app_ad", wVar));
            rVar.a("cancel_download_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new g("cancel_download_app_ad", wVar));
            rVar.a("unsubscribe_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new g("unsubscribe_app_ad", wVar));
            rVar.a("landscape_click", (com.bytedance.sdk.component.a.e<?, ?>) new g("landscape_click", wVar));
            rVar.a("clickEvent", (com.bytedance.sdk.component.a.e<?, ?>) new g("clickEvent", wVar));
            rVar.a("renderDidFinish", (com.bytedance.sdk.component.a.e<?, ?>) new g("renderDidFinish", wVar));
            rVar.a("dynamicTrack", (com.bytedance.sdk.component.a.e<?, ?>) new g("dynamicTrack", wVar));
            rVar.a("skipVideo", (com.bytedance.sdk.component.a.e<?, ?>) new g("skipVideo", wVar));
            rVar.a("muteVideo", (com.bytedance.sdk.component.a.e<?, ?>) new g("muteVideo", wVar));
            rVar.a("changeVideoState", (com.bytedance.sdk.component.a.e<?, ?>) new g("changeVideoState", wVar));
            rVar.a("getCurrentVideoState", (com.bytedance.sdk.component.a.e<?, ?>) new g("getCurrentVideoState", wVar));
            rVar.a("send_temai_product_ids", (com.bytedance.sdk.component.a.e<?, ?>) new g("send_temai_product_ids", wVar));
            rVar.a("getMaterialMeta", (com.bytedance.sdk.component.a.e<?, ?>) new g("getMaterialMeta", wVar));
            rVar.a("endcard_load", (com.bytedance.sdk.component.a.e<?, ?>) new g("endcard_load", wVar));
            rVar.a("pauseWebView", (com.bytedance.sdk.component.a.e<?, ?>) new g("pauseWebView", wVar));
            rVar.a("pauseWebViewTimers", (com.bytedance.sdk.component.a.e<?, ?>) new g("pauseWebViewTimers", wVar));
            rVar.a("webview_time_track", (com.bytedance.sdk.component.a.e<?, ?>) new g("webview_time_track", wVar));
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
            aVar.f67548a = NotificationCompat.CATEGORY_CALL;
            aVar.f67550c = this.f68218a;
            aVar.f67551d = jSONObject;
            return this.f68219b.a(aVar, 3);
        }
        return (JSONObject) invokeLL.objValue;
    }
}
