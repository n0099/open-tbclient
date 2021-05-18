package com.kwad.sdk.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbConfig;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f32956a;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f32957a;

        /* renamed from: b  reason: collision with root package name */
        public String f32958b;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32957a = jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE);
            this.f32958b = jSONObject.optString("payload");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, LightInvokerImpl.VOICE_ACTIONTYPE, this.f32957a);
            com.kwad.sdk.utils.o.a(jSONObject, "payload", this.f32958b);
            return jSONObject;
        }
    }

    public j(com.kwad.sdk.core.webview.a aVar) {
        this.f32956a = aVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private void a(@NonNull a aVar) {
        if (aVar.f32957a == 1) {
            com.kwad.sdk.core.d.a.c("WebCardLogHandler", "handleH5Log actionType is AD_ITEM_IMPRESSION");
        } else if (aVar.f32957a != 2) {
            com.kwad.sdk.core.report.b.a(this.f32956a.f32867b, aVar.f32957a, this.f32956a.f32869d, aVar.f32958b);
        } else {
            com.kwad.sdk.core.webview.a aVar2 = this.f32956a;
            AdBaseFrameLayout adBaseFrameLayout = aVar2.f32868c;
            if (adBaseFrameLayout != null) {
                com.kwad.sdk.core.report.b.a(aVar2.f32867b, aVar2.f32869d, adBaseFrameLayout.getTouchCoords(), aVar.f32958b);
            } else {
                com.kwad.sdk.core.report.b.a(aVar2.f32867b, aVar2.f32869d, aVar.f32958b);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return TbConfig.TMP_LOG_DIR_NAME;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        if (this.f32956a.f32867b == null) {
            cVar.a(-1, "native adTemplate is null");
        }
        try {
            a aVar = new a();
            aVar.a(new JSONObject(str));
            a(aVar);
            cVar.a(null);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            cVar.a(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
