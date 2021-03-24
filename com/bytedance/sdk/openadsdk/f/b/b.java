package com.bytedance.sdk.openadsdk.f.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.f.a.q;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.bytedance.sdk.openadsdk.f.a.d<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<x> f29387a;

    public b(x xVar) {
        this.f29387a = new WeakReference<>(xVar);
    }

    public static void a(q qVar, final x xVar) {
        qVar.a("getNetworkData", new d.b() { // from class: com.bytedance.sdk.openadsdk.f.b.b.1
            @Override // com.bytedance.sdk.openadsdk.f.a.d.b
            public com.bytedance.sdk.openadsdk.f.a.d a() {
                return new b(x.this);
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
            Log.d("DoGetAdsFromNetwork", sb.toString());
        }
        x xVar = this.f29387a.get();
        if (xVar == null) {
            Log.e("DoGetAdsFromNetwork", "invoke error");
            c();
            return;
        }
        xVar.a(jSONObject, new com.bytedance.sdk.openadsdk.g.c() { // from class: com.bytedance.sdk.openadsdk.f.b.b.2
            @Override // com.bytedance.sdk.openadsdk.g.c
            public void a(boolean z, List<l> list) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!z) {
                        b.this.a((b) jSONObject2);
                    } else {
                        jSONObject2.put("creatives", x.b(list));
                        b.this.a((b) jSONObject2);
                    }
                    if (com.bytedance.sdk.openadsdk.core.i.d().w()) {
                        Log.d("DoGetAdsFromNetwork", "[JSB-RSP] version: 3 data=" + jSONObject2.toString());
                    }
                } catch (Throwable th) {
                    Log.e("DoGetAdsFromNetwork", "onAdLoaded error", th);
                }
            }
        });
    }
}
