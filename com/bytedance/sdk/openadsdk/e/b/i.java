package com.bytedance.sdk.openadsdk.e.b;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.e.a.d;
import com.bytedance.sdk.openadsdk.e.a.q;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i extends com.bytedance.sdk.openadsdk.e.a.d<JSONObject, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<x> f4766a;

    public static void a(q qVar, final x xVar) {
        qVar.a("showAppDetailOrPrivacyDialog", new d.b() { // from class: com.bytedance.sdk.openadsdk.e.b.i.1
            @Override // com.bytedance.sdk.openadsdk.e.a.d.b
            public com.bytedance.sdk.openadsdk.e.a.d a() {
                return new i(x.this);
            }
        });
    }

    public i(x xVar) {
        this.f4766a = new WeakReference<>(xVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.e.a.d
    public void a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.e.a.f fVar) throws Exception {
        if (com.bytedance.sdk.openadsdk.core.i.d().v()) {
            u.b("ShowAppDetailOrPrivacyDialogMethod", "[JSB-REQ] version: 3 data=" + (jSONObject != null ? jSONObject.toString() : ""));
        }
        if (this.f4766a != null) {
            x xVar = this.f4766a.get();
            if (xVar == null) {
                c();
            } else if (jSONObject != null) {
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
}
