package com.bytedance.sdk.openadsdk.e.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.e.a.q;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.bytedance.sdk.openadsdk.e.a.e<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<x> f4763a;

    public static void a(q qVar, x xVar) {
        qVar.a("getAppManage", (com.bytedance.sdk.openadsdk.e.a.e<?, ?>) new d(xVar));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.e.a.e
    @Nullable
    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.e.a.f fVar) throws Exception {
        return a(jSONObject);
    }

    public d(x xVar) {
        this.f4763a = new WeakReference<>(xVar);
    }

    public JSONObject a(JSONObject jSONObject) {
        x xVar;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.f4763a != null && (xVar = this.f4763a.get()) != null) {
                JSONObject k = xVar.k();
                try {
                    u.b("GetAppManageModelMethod", "GetAppManageModelMethod analysisJson resultJsonObject " + k.toString());
                    return k;
                } catch (Throwable th) {
                    return k;
                }
            }
            return jSONObject2;
        } catch (Throwable th2) {
            return jSONObject2;
        }
    }
}
