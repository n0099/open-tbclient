package com.bytedance.sdk.openadsdk.f.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.f.a.f;
import com.bytedance.sdk.openadsdk.f.a.q;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.bytedance.sdk.openadsdk.f.a.d<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<x> f7456a;

    public static void a(q qVar, final x xVar) {
        qVar.a("getNetworkData", new d.b() { // from class: com.bytedance.sdk.openadsdk.f.b.a.1
            @Override // com.bytedance.sdk.openadsdk.f.a.d.b
            public com.bytedance.sdk.openadsdk.f.a.d a() {
                return new a(x.this);
            }
        });
    }

    public a(x xVar) {
        this.f7456a = new WeakReference<>(xVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.f.a.d
    public void a(@NonNull JSONObject jSONObject, @NonNull f fVar) throws Exception {
        if (i.c().u()) {
            Log.d("DoGetAdsFromNetwork", "[JSB-REQ] version: 3 data=" + (jSONObject != null ? jSONObject.toString() : ""));
        }
        x xVar = this.f7456a.get();
        if (xVar == null) {
            Log.e("DoGetAdsFromNetwork", "invoke error");
            c();
            return;
        }
        xVar.a(jSONObject, new com.bytedance.sdk.openadsdk.g.c() { // from class: com.bytedance.sdk.openadsdk.f.b.a.2
            @Override // com.bytedance.sdk.openadsdk.g.c
            public void a(boolean z, List<l> list) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!z) {
                        a.this.a((a) jSONObject2);
                    } else {
                        jSONObject2.put("creatives", x.b(list));
                        a.this.a((a) jSONObject2);
                    }
                    if (i.c().u()) {
                        Log.d("DoGetAdsFromNetwork", "[JSB-RSP] version: 3 data=" + jSONObject2.toString());
                    }
                } catch (Throwable th) {
                    Log.e("DoGetAdsFromNetwork", "onAdLoaded error", th);
                }
            }
        });
    }
}
