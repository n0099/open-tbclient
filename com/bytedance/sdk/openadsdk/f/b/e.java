package com.bytedance.sdk.openadsdk.f.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.e.a;
import com.bytedance.sdk.openadsdk.f.a.q;
import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e extends com.bytedance.sdk.openadsdk.f.a.e<JSONObject, JSONObject> {
    public static void a(q qVar) {
        qVar.a("getDownloadStatus", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new e());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.f.a.e
    @Nullable
    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.f.a.f fVar) throws Exception {
        return a(jSONObject);
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            a(jSONObject2, 1, "params is null", 1, 1);
            return jSONObject2;
        }
        try {
            String optString = jSONObject.optString("ad_down_load_id");
            if (TextUtils.isEmpty(optString)) {
                a(jSONObject2, 1, "ad_down_load_id is null", 1, 1);
                return jSONObject2;
            }
            u.b("GetDownloadStatusMethod", "GetDownloadStatusMethod analysisJson downloadId " + optString);
            JSONObject a2 = a.C0321a.a(optString);
            u.b("GetDownloadStatusMethod", "GetDownloadStatusMethod analysisJson downloadJson " + a2.toString());
            return a2;
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    public static void a(JSONObject jSONObject, int i, String str, int i2, int i3) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("code", i);
            jSONObject.put("codeMsg", str);
            jSONObject.put("downloadStatus", i2);
            jSONObject.put("downloadProcessRate", i3);
        } catch (Exception unused) {
            u.b("GetDownloadStatusMethod", str);
        }
    }
}
