package com.bytedance.sdk.openadsdk.e.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.e.a.d;
import com.bytedance.sdk.openadsdk.e.a.q;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends com.bytedance.sdk.openadsdk.e.a.d<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<x> f4761a;

    public static void a(q qVar, final x xVar) {
        qVar.a("newClickEvent", new d.b() { // from class: com.bytedance.sdk.openadsdk.e.b.c.1
            @Override // com.bytedance.sdk.openadsdk.e.a.d.b
            public com.bytedance.sdk.openadsdk.e.a.d a() {
                return new c(x.this);
            }
        });
    }

    public c(x xVar) {
        this.f4761a = new WeakReference<>(xVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.e.a.d
    public void a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.e.a.f fVar) throws Exception {
        if (com.bytedance.sdk.openadsdk.core.i.d().v()) {
            Log.d("DoNewClickEventMethod", "[JSB-REQ] version: 3 data=" + (jSONObject != null ? jSONObject.toString() : ""));
        }
        x xVar = this.f4761a.get();
        if (xVar == null) {
            Log.e("DoNewClickEventMethod", "invoke error");
            c();
            return;
        }
        xVar.c(jSONObject);
    }
}
