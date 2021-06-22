package com.kwad.sdk.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbConfig;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f35109a;

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f35110a;

        /* renamed from: b  reason: collision with root package name */
        public String f35111b;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f35110a = jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE);
            this.f35111b = jSONObject.optString("payload");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, LightInvokerImpl.VOICE_ACTIONTYPE, this.f35110a);
            com.kwad.sdk.utils.o.a(jSONObject, "payload", this.f35111b);
            return jSONObject;
        }
    }

    public j(com.kwad.sdk.core.webview.a aVar) {
        this.f35109a = aVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private void a(@NonNull a aVar) {
        if (aVar.f35110a == 1) {
            com.kwad.sdk.core.d.a.b("WebCardLogHandler", "handleH5Log actionType is AD_ITEM_IMPRESSION");
        } else if (aVar.f35110a != 2) {
            com.kwad.sdk.core.report.b.a(this.f35109a.f35027b, aVar.f35110a, this.f35109a.f35029d, aVar.f35111b);
        } else {
            com.kwad.sdk.core.webview.a aVar2 = this.f35109a;
            AdBaseFrameLayout adBaseFrameLayout = aVar2.f35028c;
            if (adBaseFrameLayout != null) {
                com.kwad.sdk.core.report.b.a(aVar2.f35027b, aVar2.f35029d, adBaseFrameLayout.getTouchCoords(), aVar.f35111b);
            } else {
                com.kwad.sdk.core.report.b.a(aVar2.f35027b, aVar2.f35029d, aVar.f35111b);
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
        if (this.f35109a.f35027b == null) {
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
