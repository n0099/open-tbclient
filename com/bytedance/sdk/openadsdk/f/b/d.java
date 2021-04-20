package com.bytedance.sdk.openadsdk.f.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.a.q;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends com.bytedance.sdk.openadsdk.f.a.e<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<x> f29078a;

    public d(x xVar) {
        this.f29078a = new WeakReference<>(xVar);
    }

    public JSONObject c() {
        x xVar;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f29078a == null || (xVar = this.f29078a.get()) == null) {
                return jSONObject;
            }
            jSONObject = xVar.k();
            u.b("GetAppManageModelMethod", "GetAppManageModelMethod analysisJson resultJsonObject " + jSONObject.toString());
            return jSONObject;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public static void a(q qVar, x xVar) {
        qVar.a("getAppManage", (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new d(xVar));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.f.a.e
    @Nullable
    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.f.a.f fVar) throws Exception {
        return c();
    }
}
