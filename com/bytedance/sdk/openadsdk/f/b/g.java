package com.bytedance.sdk.openadsdk.f.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.f.a.q;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g extends com.bytedance.sdk.openadsdk.f.a.e<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<SSWebView> f29341a;

    public g(SSWebView sSWebView) {
        this.f29341a = new WeakReference<>(sSWebView);
    }

    public static void a(q qVar, SSWebView sSWebView) {
        qVar.a("preventTouchEvent", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new g(sSWebView));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.f.a.e
    @Nullable
    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.f.a.f fVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean optBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = this.f29341a.get();
            if (sSWebView != null) {
                sSWebView.setIsPreventTouchEvent(optBoolean);
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        } catch (Throwable th) {
            Log.e("PreventTouchEventMethod", "invoke error", th);
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
