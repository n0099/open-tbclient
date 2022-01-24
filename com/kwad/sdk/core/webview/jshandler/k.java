package com.kwad.sdk.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbConfig;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public int f56449b = 0;

    /* loaded from: classes3.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f56450b;

        /* renamed from: c  reason: collision with root package name */
        public AdTemplate f56451c;

        /* renamed from: d  reason: collision with root package name */
        public int f56452d;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE);
            this.f56452d = jSONObject.optInt("refreshType");
            this.f56450b = jSONObject.optString("payload");
            try {
                String string = jSONObject.getString("adTemplate");
                if (this.f56451c == null) {
                    this.f56451c = new AdTemplate();
                }
                this.f56451c.parseJson(new JSONObject(string));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.a(jSONObject, LightInvokerImpl.VOICE_ACTIONTYPE, this.a);
            com.kwad.sdk.utils.t.a(jSONObject, "payload", this.f56450b);
            com.kwad.sdk.utils.t.a(jSONObject, "refreshType", this.f56452d);
            com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", this.f56451c);
            return jSONObject;
        }
    }

    public k(com.kwad.sdk.core.webview.a aVar) {
        this.a = aVar;
    }

    private AdTemplate b(@NonNull a aVar) {
        return aVar.f56451c != null ? aVar.f56451c : this.a.a();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return TbConfig.TMP_LOG_DIR_NAME;
    }

    @SuppressLint({"SwitchIntDef"})
    public void a(@NonNull a aVar) {
        p.a aVar2;
        AdTemplate a2;
        com.kwad.sdk.core.d.a.a("WebCardLogHandler", "handleH5Log actionType actionType" + aVar.a);
        if (aVar.a == 1) {
            if (aVar.f56451c != null) {
                aVar2 = new p.a();
                aVar2.f56112h = aVar.f56450b;
                aVar2.o = this.f56449b;
                a2 = aVar.f56451c;
            } else {
                aVar2 = new p.a();
                aVar2.f56112h = aVar.f56450b;
                a2 = this.a.a();
            }
            com.kwad.sdk.core.report.a.a(a2, (JSONObject) null, aVar2);
        } else if (aVar.a != 2) {
            if (aVar.a == 12006) {
                com.kwad.sdk.core.report.d.a(b(aVar), aVar.f56452d, this.f56449b);
            } else {
                com.kwad.sdk.core.report.a.a(b(aVar), aVar.a, this.a.f56373c, aVar.f56450b);
            }
        } else {
            AdBaseFrameLayout adBaseFrameLayout = this.a.f56372b;
            p.a aVar3 = new p.a();
            aVar3.o = this.f56449b;
            if (adBaseFrameLayout != null) {
                com.kwad.sdk.core.report.a.a(b(aVar), this.a.f56373c, aVar3, adBaseFrameLayout.getTouchCoords(), aVar.f56450b);
            } else {
                com.kwad.sdk.core.report.a.a(b(aVar), this.a.f56373c, aVar3, aVar.f56450b);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (this.a.c()) {
            cVar.a(-1, "native adTemplate is null");
        }
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            a(aVar);
            cVar.a(null);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            cVar.a(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
    }
}
