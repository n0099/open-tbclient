package com.bytedance.sdk.openadsdk.f.b;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.f.a.q;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i extends com.bytedance.sdk.openadsdk.f.a.d<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<x> f29396a;

    public i(x xVar) {
        this.f29396a = new WeakReference<>(xVar);
    }

    public static void a(q qVar, final x xVar) {
        qVar.a("showAppDetailOrPrivacyDialog", new d.b() { // from class: com.bytedance.sdk.openadsdk.f.b.i.1
            @Override // com.bytedance.sdk.openadsdk.f.a.d.b
            public com.bytedance.sdk.openadsdk.f.a.d a() {
                return new i(x.this);
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
            u.b("ShowAppDetailOrPrivacyDialogMethod", sb.toString());
        }
        WeakReference<x> weakReference = this.f29396a;
        if (weakReference == null) {
            return;
        }
        x xVar = weakReference.get();
        if (xVar == null) {
            c();
        } else if (jSONObject == null) {
        } else {
            int optInt = jSONObject.optInt("show_dialog_style");
            if (optInt == 1) {
                xVar.j();
                u.b("ShowAppDetailOrPrivacyDialogMethod", "ShowAppDetailOrPrivacyDialogMethod showAppDetailDialog ");
            } else if (optInt == 2) {
                xVar.i();
                u.b("ShowAppDetailOrPrivacyDialogMethod", "ShowAppDetailOrPrivacyDialogMethod showAppPrivacyDialog ");
            }
        }
    }
}
