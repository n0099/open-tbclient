package com.bytedance.sdk.openadsdk.e.b;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.e.a.d;
import com.bytedance.sdk.openadsdk.e.a.q;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.bytedance.sdk.openadsdk.e.a.d<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<x> f4756a;

    public static void a(q qVar, final x xVar) {
        qVar.a("immersiveVideoPageBack", new d.b() { // from class: com.bytedance.sdk.openadsdk.e.b.a.1
            @Override // com.bytedance.sdk.openadsdk.e.a.d.b
            public com.bytedance.sdk.openadsdk.e.a.d a() {
                return new a(x.this);
            }
        });
    }

    public a(x xVar) {
        this.f4756a = new WeakReference<>(xVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.e.a.d
    public void a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.e.a.f fVar) throws Exception {
        if (this.f4756a != null && this.f4756a.get() != null) {
            x xVar = this.f4756a.get();
            if (xVar == null) {
                c();
            } else {
                xVar.b();
            }
        }
    }
}
