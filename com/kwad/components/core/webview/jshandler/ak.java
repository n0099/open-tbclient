package com.kwad.components.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ak implements com.kwad.sdk.core.webview.c.a {
    public final com.kwad.sdk.core.webview.b VP;
    public int Xb = 0;
    public a Xc;

    /* loaded from: classes10.dex */
    public interface a {
        void onAdShow();
    }

    public void a(com.kwad.sdk.core.report.j jVar) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return LocalFilesFilterKt.FILTER_NAME_LOG;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    /* loaded from: classes10.dex */
    public static final class b extends com.kwad.sdk.core.report.c implements com.kwad.sdk.core.b {
        public String Jw;
        public String Xd;
        public int Xe;
        public int actionType;
        public AdTemplate adTemplate;

        public final int getActionType() {
            return this.actionType;
        }

        public final String mJ() {
            return this.Jw;
        }

        public final String sd() {
            return this.Xd;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "actionType", this.actionType);
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", this.Xd);
            com.kwad.sdk.utils.t.putValue(jSONObject, "refreshType", this.Xe);
            com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.Jw);
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.actionType = jSONObject.optInt("actionType");
            this.Xe = jSONObject.optInt("refreshType");
            this.Xd = jSONObject.optString("payload");
            this.Jw = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            }
            if (this.adTemplate == null && jSONObject.has("adCacheId")) {
                this.adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.at(jSONObject.optInt("adCacheId")), this.Jw);
            }
        }
    }

    public ak(com.kwad.sdk.core.webview.b bVar) {
        this.VP = bVar;
    }

    private AdTemplate c(@NonNull b bVar) {
        if (bVar.adTemplate == null) {
            return this.VP.cH(bVar.Jw);
        }
        return bVar.adTemplate;
    }

    public final void a(a aVar) {
        this.Xc = aVar;
    }

    @SuppressLint({"SwitchIntDef"})
    public void a(@NonNull b bVar) {
        com.kwad.sdk.core.e.c.d("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.actionType);
        if (bVar.actionType == 1) {
            com.kwad.sdk.core.report.j dO = new com.kwad.sdk.core.report.j().dO(bVar.Xd);
            a aVar = this.Xc;
            if (aVar != null) {
                aVar.onAdShow();
            }
            if (bVar.adTemplate != null) {
                dO.cE(this.Xb);
                b(true, bVar.adTemplate, null, dO);
            } else if (bg.isNullString(bVar.mJ())) {
                b(true, this.VP.getAdTemplate(), null, dO);
            } else {
                for (AdTemplate adTemplate : this.VP.FD()) {
                    if (bg.isEquals(bVar.mJ(), String.valueOf(com.kwad.sdk.core.response.b.e.dZ(adTemplate)))) {
                        b(false, adTemplate, null, dO);
                        return;
                    }
                }
            }
        } else if (bVar.actionType == 2) {
            com.kwad.sdk.widget.e eVar = this.VP.aCG;
            com.kwad.sdk.core.report.j dO2 = new com.kwad.sdk.core.report.j().cE(this.Xb).dO(bVar.Xd);
            if (eVar != null) {
                dO2.d(eVar.getTouchCoords());
            }
            a(dO2);
            com.kwad.sdk.core.report.a.a(c(bVar), dO2, this.VP.mReportExtData);
        } else if (bVar.actionType == 12006) {
            com.kwad.components.core.o.a.pX().b(c(bVar), bVar.Xe, this.Xb);
        } else if (bVar.actionType == 140) {
            com.kwad.sdk.core.report.a.d(c(bVar), this.VP.mReportExtData, new com.kwad.sdk.core.report.j().dO(bVar.Xd));
        } else if (bVar.actionType == 141) {
            com.kwad.sdk.core.report.a.e(c(bVar), this.VP.mReportExtData, new com.kwad.sdk.core.report.j().dO(bVar.Xd));
        } else {
            com.kwad.sdk.core.report.a.a(c(bVar), bVar.actionType, this.VP.mReportExtData, bVar.Xd);
            com.kwad.components.core.webview.tachikoma.d.a.sO().aP(bVar.Xd);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            if (c(bVar) == null) {
                cVar.onError(-1, "native adTemplate is null");
            }
            a(bVar);
            cVar.a(null);
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    public void b(boolean z, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.report.j jVar) {
        com.kwad.components.core.s.b.qL().a(adTemplate, null, jVar);
    }
}
