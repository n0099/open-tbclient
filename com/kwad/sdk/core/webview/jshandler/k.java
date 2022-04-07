package com.kwad.sdk.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbConfig;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;
    public int b = 0;

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int a;
        public String b;
        public AdTemplate c;
        public int d;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("actionType");
            this.d = jSONObject.optInt("refreshType");
            this.b = jSONObject.optString("payload");
            try {
                String string = jSONObject.getString("adTemplate");
                if (this.c == null) {
                    this.c = new AdTemplate();
                }
                this.c.parseJson(new JSONObject(string));
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.b(e);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.a(jSONObject, "actionType", this.a);
            com.kwad.sdk.utils.t.a(jSONObject, "payload", this.b);
            com.kwad.sdk.utils.t.a(jSONObject, "refreshType", this.d);
            com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", this.c);
            return jSONObject;
        }
    }

    public k(com.kwad.sdk.core.webview.a aVar) {
        this.a = aVar;
    }

    private AdTemplate b(@NonNull a aVar) {
        return aVar.c != null ? aVar.c : this.a.a();
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
            if (aVar.c != null) {
                aVar2 = new p.a();
                aVar2.h = aVar.b;
                aVar2.o = this.b;
                a2 = aVar.c;
            } else {
                aVar2 = new p.a();
                aVar2.h = aVar.b;
                a2 = this.a.a();
            }
            com.kwad.sdk.core.report.a.a(a2, (JSONObject) null, aVar2);
        } else if (aVar.a != 2) {
            if (aVar.a == 12006) {
                com.kwad.sdk.core.report.d.a(b(aVar), aVar.d, this.b);
            } else {
                com.kwad.sdk.core.report.a.a(b(aVar), aVar.a, this.a.c, aVar.b);
            }
        } else {
            AdBaseFrameLayout adBaseFrameLayout = this.a.b;
            p.a aVar3 = new p.a();
            aVar3.o = this.b;
            if (adBaseFrameLayout != null) {
                com.kwad.sdk.core.report.a.a(b(aVar), this.a.c, aVar3, adBaseFrameLayout.getTouchCoords(), aVar.b);
            } else {
                com.kwad.sdk.core.report.a.a(b(aVar), this.a.c, aVar3, aVar.b);
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
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
            cVar.a(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
    }
}
