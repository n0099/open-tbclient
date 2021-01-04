package com.bytedance.sdk.openadsdk.f.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.f.a.e;
import com.bytedance.sdk.openadsdk.f.a.f;
import com.bytedance.sdk.openadsdk.f.a.q;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends e<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<SSWebView> f7460a;

    public static void a(q qVar, SSWebView sSWebView) {
        qVar.a("preventTouchEvent", new c(sSWebView));
    }

    public c(SSWebView sSWebView) {
        this.f7460a = new WeakReference<>(sSWebView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.f.a.e
    @Nullable
    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull f fVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean optBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = this.f7460a.get();
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
