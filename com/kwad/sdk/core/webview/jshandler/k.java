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
    public int f58615b = 0;

    /* loaded from: classes3.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f58616b;

        /* renamed from: c  reason: collision with root package name */
        public AdTemplate f58617c;

        /* renamed from: d  reason: collision with root package name */
        public int f58618d;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE);
            this.f58618d = jSONObject.optInt("refreshType");
            this.f58616b = jSONObject.optString("payload");
            try {
                String string = jSONObject.getString("adTemplate");
                if (this.f58617c == null) {
                    this.f58617c = new AdTemplate();
                }
                this.f58617c.parseJson(new JSONObject(string));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.a(jSONObject, LightInvokerImpl.VOICE_ACTIONTYPE, this.a);
            com.kwad.sdk.utils.t.a(jSONObject, "payload", this.f58616b);
            com.kwad.sdk.utils.t.a(jSONObject, "refreshType", this.f58618d);
            com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", this.f58617c);
            return jSONObject;
        }
    }

    public k(com.kwad.sdk.core.webview.a aVar) {
        this.a = aVar;
    }

    private AdTemplate b(@NonNull a aVar) {
        return aVar.f58617c != null ? aVar.f58617c : this.a.a();
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
            if (aVar.f58617c != null) {
                aVar2 = new p.a();
                aVar2.f58268h = aVar.f58616b;
                aVar2.o = this.f58615b;
                a2 = aVar.f58617c;
            } else {
                aVar2 = new p.a();
                aVar2.f58268h = aVar.f58616b;
                a2 = this.a.a();
            }
            com.kwad.sdk.core.report.a.a(a2, (JSONObject) null, aVar2);
        } else if (aVar.a != 2) {
            if (aVar.a == 12006) {
                com.kwad.sdk.core.report.d.a(b(aVar), aVar.f58618d, this.f58615b);
            } else {
                com.kwad.sdk.core.report.a.a(b(aVar), aVar.a, this.a.f58537c, aVar.f58616b);
            }
        } else {
            AdBaseFrameLayout adBaseFrameLayout = this.a.f58536b;
            p.a aVar3 = new p.a();
            aVar3.o = this.f58615b;
            if (adBaseFrameLayout != null) {
                com.kwad.sdk.core.report.a.a(b(aVar), this.a.f58537c, aVar3, adBaseFrameLayout.getTouchCoords(), aVar.f58616b);
            } else {
                com.kwad.sdk.core.report.a.a(b(aVar), this.a.f58537c, aVar3, aVar.f58616b);
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
