package com.bytedance.sdk.openadsdk.f.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.f.a.q;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends com.bytedance.sdk.openadsdk.f.a.d<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<x> f29977a;

    public c(x xVar) {
        this.f29977a = new WeakReference<>(xVar);
    }

    public static void a(q qVar, final x xVar) {
        qVar.a("newClickEvent", new d.b() { // from class: com.bytedance.sdk.openadsdk.f.b.c.1
            @Override // com.bytedance.sdk.openadsdk.f.a.d.b
            public com.bytedance.sdk.openadsdk.f.a.d a() {
                return new c(x.this);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.f.a.d
    public void a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.f.a.f fVar) throws Exception {
        if (com.bytedance.sdk.openadsdk.core.i.d().w()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[JSB-REQ] version: 3 data=");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            Log.d("DoNewClickEventMethod", sb.toString());
        }
        x xVar = this.f29977a.get();
        if (xVar == null) {
            Log.e("DoNewClickEventMethod", "invoke error");
            c();
            return;
        }
        xVar.c(jSONObject);
    }
}
