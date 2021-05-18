package com.bytedance.sdk.openadsdk.f.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.f.a.q;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h extends com.bytedance.sdk.openadsdk.f.a.e<JSONObject, JSONObject> {
    private int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("video".equals(str)) {
            return 2;
        }
        return "canvas".equals(str) ? 3 : 0;
    }

    private l c() {
        String e2 = k.e();
        if (TextUtils.isEmpty(e2)) {
            return null;
        }
        try {
            return com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(e2));
        } catch (Throwable unused) {
            u.f("ReportPlayableScreenshotMethod", "ReportPlayableScreenshotMethod materialMeta is null ");
            return null;
        }
    }

    public static void a(q qVar) {
        qVar.a("reportPlayableScreenshot", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.f.a.e
    @Nullable
    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.f.a.f fVar) throws Exception {
        return a(jSONObject);
    }

    private JSONObject a(JSONObject jSONObject) {
        String optString;
        Bitmap a2;
        u.b("ReportPlayableScreenshotMethod", "reportPlayableScreenshot ");
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            a(jSONObject2, 1, "params is null");
            return jSONObject2;
        }
        try {
            String optString2 = jSONObject.optString("image");
            optString = jSONObject.optString("type");
            a2 = com.bytedance.sdk.openadsdk.utils.f.a(optString2);
        } catch (Throwable unused) {
        }
        if (a2 == null) {
            a(jSONObject2, 1, "imageBase64 to Bitmap error");
            return jSONObject2;
        }
        l c2 = c();
        if (c2 == null) {
            a(jSONObject2, 1, "materialMeta is null");
            return jSONObject2;
        }
        al.a(p.a(), c2, "rewarded_video", "playable_show_status", com.bytedance.sdk.openadsdk.utils.f.a(a2, a2.getWidth() / 6, a2.getHeight() / 6), true, b(optString));
        return jSONObject2;
    }

    private void a(JSONObject jSONObject, int i2, String str) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("code", i2);
            jSONObject.put("codeMsg", str);
        } catch (Exception unused) {
            u.b("ReportPlayableScreenshotMethod", str);
        }
    }
}
