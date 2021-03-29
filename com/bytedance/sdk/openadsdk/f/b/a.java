package com.bytedance.sdk.openadsdk.f.b;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.f.a.q;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.bytedance.sdk.openadsdk.f.a.d<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<x> f29386a;

    public a(x xVar) {
        this.f29386a = new WeakReference<>(xVar);
    }

    public static void a(q qVar, final x xVar) {
        qVar.a("immersiveVideoPageBack", new d.b() { // from class: com.bytedance.sdk.openadsdk.f.b.a.1
            @Override // com.bytedance.sdk.openadsdk.f.a.d.b
            public com.bytedance.sdk.openadsdk.f.a.d a() {
                return new a(x.this);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.f.a.d
    public void a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.f.a.f fVar) throws Exception {
        WeakReference<x> weakReference = this.f29386a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        x xVar = this.f29386a.get();
        if (xVar == null) {
            c();
        } else {
            xVar.b();
        }
    }
}
