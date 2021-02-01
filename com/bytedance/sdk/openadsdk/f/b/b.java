package com.bytedance.sdk.openadsdk.f.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.a.e;
import com.bytedance.sdk.openadsdk.f.a.f;
import com.bytedance.sdk.openadsdk.f.a.q;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends e<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private String f7161a;

    /* renamed from: b  reason: collision with root package name */
    private x f7162b;

    public b(String str, x xVar) {
        this.f7162b = xVar;
        this.f7161a = str;
    }

    public static void a(q qVar, x xVar) {
        qVar.a("appInfo", new b("appInfo", xVar));
        qVar.a("adInfo", new b("adInfo", xVar));
        qVar.a("playable_style", new b("playable_style", xVar));
        qVar.a("getTemplateInfo", new b("getTemplateInfo", xVar));
        qVar.a("getTeMaiAds", new b("getTeMaiAds", xVar));
        qVar.a("isViewable", new b("isViewable", xVar));
        qVar.a("getScreenSize", new b("getScreenSize", xVar));
        qVar.a("getCloseButtonInfo", new b("getCloseButtonInfo", xVar));
        qVar.a("getVolume", new b("getVolume", xVar));
        qVar.a("removeLoading", new b("removeLoading", xVar));
        qVar.a("sendReward", new b("sendReward", xVar));
        qVar.a("subscribe_app_ad", new b("subscribe_app_ad", xVar));
        qVar.a("download_app_ad", new b("download_app_ad", xVar));
        qVar.a("cancel_download_app_ad", new b("cancel_download_app_ad", xVar));
        qVar.a("unsubscribe_app_ad", new b("unsubscribe_app_ad", xVar));
        qVar.a("landscape_click", new b("landscape_click", xVar));
        qVar.a("clickEvent", new b("clickEvent", xVar));
        qVar.a("renderDidFinish", new b("renderDidFinish", xVar));
        qVar.a("dynamicTrack", new b("dynamicTrack", xVar));
        qVar.a("skipVideo", new b("skipVideo", xVar));
        qVar.a("muteVideo", new b("muteVideo", xVar));
        qVar.a("changeVideoState", new b("changeVideoState", xVar));
        qVar.a("getCurrentVideoState", new b("getCurrentVideoState", xVar));
        qVar.a("send_temai_product_ids", new b("send_temai_product_ids", xVar));
        qVar.a("getMaterialMeta", new b("getMaterialMeta", xVar));
        qVar.a("endcard_load", new b("endcard_load", xVar));
        qVar.a("pauseWebView", new b("pauseWebView", xVar));
        qVar.a("pauseWebViewTimers", new b("pauseWebViewTimers", xVar));
        qVar.a("webview_time_track", new b("webview_time_track", xVar));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.f.a.e
    @Nullable
    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull f fVar) throws Exception {
        x.a aVar = new x.a();
        aVar.f6863a = NotificationCompat.CATEGORY_CALL;
        aVar.c = this.f7161a;
        aVar.d = jSONObject;
        JSONObject a2 = this.f7162b.a(aVar, 3);
        if (i.c().u()) {
            Log.d("OldBridgeSyncMethod", "[JSB-RSP] version: 3 data=" + a2.toString());
        }
        return a2;
    }
}
