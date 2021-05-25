package com.bytedance.sdk.openadsdk.f.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.live.interfaces.DI;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.a.q;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends com.bytedance.sdk.openadsdk.f.a.e<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public String f29154a;

    /* renamed from: b  reason: collision with root package name */
    public x f29155b;

    public f(String str, x xVar) {
        this.f29155b = xVar;
        this.f29154a = str;
    }

    public static void a(q qVar, x xVar) {
        qVar.a(DI.APP_INFO_NAME, (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f(DI.APP_INFO_NAME, xVar));
        qVar.a("adInfo", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("adInfo", xVar));
        qVar.a("playable_style", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("playable_style", xVar));
        qVar.a("getTemplateInfo", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("getTemplateInfo", xVar));
        qVar.a("getTeMaiAds", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("getTeMaiAds", xVar));
        qVar.a("isViewable", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("isViewable", xVar));
        qVar.a("getScreenSize", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("getScreenSize", xVar));
        qVar.a("getCloseButtonInfo", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("getCloseButtonInfo", xVar));
        qVar.a("getVolume", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("getVolume", xVar));
        qVar.a("removeLoading", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("removeLoading", xVar));
        qVar.a("sendReward", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("sendReward", xVar));
        qVar.a("subscribe_app_ad", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("subscribe_app_ad", xVar));
        qVar.a("download_app_ad", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("download_app_ad", xVar));
        qVar.a("cancel_download_app_ad", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("cancel_download_app_ad", xVar));
        qVar.a("unsubscribe_app_ad", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("unsubscribe_app_ad", xVar));
        qVar.a("landscape_click", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("landscape_click", xVar));
        qVar.a("clickEvent", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("clickEvent", xVar));
        qVar.a("renderDidFinish", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("renderDidFinish", xVar));
        qVar.a("dynamicTrack", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("dynamicTrack", xVar));
        qVar.a("skipVideo", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("skipVideo", xVar));
        qVar.a("muteVideo", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("muteVideo", xVar));
        qVar.a("changeVideoState", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("changeVideoState", xVar));
        qVar.a("getCurrentVideoState", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("getCurrentVideoState", xVar));
        qVar.a("send_temai_product_ids", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("send_temai_product_ids", xVar));
        qVar.a("getMaterialMeta", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("getMaterialMeta", xVar));
        qVar.a("endcard_load", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("endcard_load", xVar));
        qVar.a("pauseWebView", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("pauseWebView", xVar));
        qVar.a("pauseWebViewTimers", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("pauseWebViewTimers", xVar));
        qVar.a("webview_time_track", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new f("webview_time_track", xVar));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.f.a.e
    @Nullable
    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.f.a.f fVar) throws Exception {
        x.a aVar = new x.a();
        aVar.f28803a = NotificationCompat.CATEGORY_CALL;
        aVar.f28805c = this.f29154a;
        aVar.f28806d = jSONObject;
        JSONObject a2 = this.f29155b.a(aVar, 3);
        if (com.bytedance.sdk.openadsdk.core.i.d().w()) {
            Log.d("OldBridgeSyncMethod", "[JSB-RSP] version: 3 data=" + a2.toString());
        }
        return a2;
    }
}
