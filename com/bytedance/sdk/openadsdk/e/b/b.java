package com.bytedance.sdk.openadsdk.e.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.e.a.d;
import com.bytedance.sdk.openadsdk.e.a.q;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.bytedance.sdk.openadsdk.e.a.d<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<x> f4758a;

    public static void a(q qVar, final x xVar) {
        qVar.a("getNetworkData", new d.b() { // from class: com.bytedance.sdk.openadsdk.e.b.b.1
            @Override // com.bytedance.sdk.openadsdk.e.a.d.b
            public com.bytedance.sdk.openadsdk.e.a.d a() {
                return new b(x.this);
            }
        });
    }

    public b(x xVar) {
        this.f4758a = new WeakReference<>(xVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.e.a.d
    public void a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.e.a.f fVar) throws Exception {
        if (com.bytedance.sdk.openadsdk.core.i.d().v()) {
            Log.d("DoGetAdsFromNetwork", "[JSB-REQ] version: 3 data=" + (jSONObject != null ? jSONObject.toString() : ""));
        }
        x xVar = this.f4758a.get();
        if (xVar == null) {
            Log.e("DoGetAdsFromNetwork", "invoke error");
            c();
            return;
        }
        xVar.a(jSONObject, new com.bytedance.sdk.openadsdk.f.c() { // from class: com.bytedance.sdk.openadsdk.e.b.b.2
            @Override // com.bytedance.sdk.openadsdk.f.c
            public void a(boolean z, List<l> list) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!z) {
                        b.this.a((b) jSONObject2);
                    } else {
                        jSONObject2.put("creatives", x.b(list));
                        b.this.a((b) jSONObject2);
                    }
                    if (com.bytedance.sdk.openadsdk.core.i.d().v()) {
                        Log.d("DoGetAdsFromNetwork", "[JSB-RSP] version: 3 data=" + jSONObject2.toString());
                    }
                } catch (Throwable th) {
                    Log.e("DoGetAdsFromNetwork", "onAdLoaded error", th);
                }
            }
        });
    }
}
