package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.b Lk;
    public Handler Ll;
    public int Lm;
    public boolean Ln;
    public final boolean Lo;
    public List<com.kwad.components.core.c.a.c> Lp;
    @Nullable
    public com.kwad.sdk.core.webview.a.kwai.a bJ;

    public f(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar) {
        this(bVar, cVar, aVar, false, 0, false);
    }

    public f(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar, int i) {
        this(bVar, cVar, aVar, false, 1, false);
    }

    public f(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar, int i, boolean z) {
        this(bVar, cVar, null, false, 2, z);
    }

    public f(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar, boolean z, int i, boolean z2) {
        this.Ln = false;
        this.Lp = new ArrayList();
        this.Ln = z;
        this.Ll = new Handler(Looper.getMainLooper());
        this.Lk = bVar;
        this.Lm = i;
        if (cVar != null) {
            cVar.ah(1);
            this.Lp.add(cVar);
        }
        this.bJ = aVar;
        this.Lo = z2;
    }

    public f(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable List<com.kwad.components.core.c.a.c> list, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar) {
        this(bVar, null, aVar, false, 0, false);
        if (list != null) {
            this.Lp.addAll(list);
        }
    }

    public static boolean S(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.bL(adTemplate) == 13;
    }

    public static /* synthetic */ boolean a(f fVar, com.kwad.sdk.core.webview.a.a.a aVar) {
        return b(aVar);
    }

    public static boolean b(com.kwad.sdk.core.webview.a.a.a aVar) {
        return aVar.Mx == 1;
    }

    @NonNull
    public u.b a(com.kwad.sdk.core.webview.a.a.a aVar, AdTemplate adTemplate) {
        com.kwad.sdk.core.webview.a.a.c cVar;
        int i;
        u.b bVar = new u.b();
        com.kwad.sdk.core.webview.a.a.c cVar2 = aVar.My;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.Mn)) {
            bVar.Mn = aVar.My.Mn;
        }
        com.kwad.sdk.core.webview.a.a.c cVar3 = aVar.My;
        if (cVar3 != null && (i = cVar3.agq) != 0) {
            bVar.acg = i;
        }
        if (!S(adTemplate) || (cVar = aVar.My) == null || cVar.agr == null) {
            com.kwad.sdk.widget.e eVar = this.Lk.agd;
            if (eVar != null) {
                bVar.gL = eVar.getTouchCoords();
            }
        } else {
            aa.a aVar2 = new aa.a();
            com.kwad.sdk.core.webview.a.a.b bVar2 = aVar.My.agr;
            aVar2.f((float) bVar2.x, (float) bVar2.y);
            com.kwad.sdk.core.webview.a.a.b bVar3 = aVar.My.agr;
            aVar2.e((float) bVar3.x, (float) bVar3.y);
            com.kwad.sdk.core.webview.a.a.b bVar4 = aVar.My.agr;
            aVar2.q(bVar4.width, bVar4.height);
            bVar.gL = aVar2;
        }
        return bVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Handler handler;
        Runnable runnable;
        if (this.Lk.wh()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.a.a.a aVar = new com.kwad.sdk.core.webview.a.a.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
        if (!this.Lk.agf) {
            if (this.bJ != null) {
                handler = this.Ll;
                runnable = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.f.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (f.this.bJ != null) {
                            f.this.bJ.a(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.Ll;
        runnable = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.f.1
            @Override // java.lang.Runnable
            public final void run() {
                AdTemplate adTemplate;
                com.kwad.sdk.core.webview.b bVar = f.this.Lk;
                if (bVar.agg) {
                    if (aVar.creativeId >= 0) {
                        List<AdTemplate> wg = bVar.wg();
                        com.kwad.sdk.core.webview.a.a.a aVar2 = aVar;
                        adTemplate = com.kwad.sdk.core.response.a.d.a(wg, aVar2.creativeId, aVar2.adStyle);
                    } else {
                        adTemplate = bVar.getAdTemplate();
                    }
                    com.kwad.components.core.c.a.a.a(new a.C0619a(f.this.Lk.Gl.getContext()).L(adTemplate).b(f.this.s(aVar.creativeId)).aj(f.a(f.this, aVar)).ak(f.this.Ln).c(f.this.Lk.mReportExtData).ae(aVar.Mx).al(f.this.Lo || aVar.DZ).ag(f.this.Lm).a(f.this.a(aVar, adTemplate)).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.f.1.1
                        @Override // com.kwad.components.core.c.a.a.b
                        public final void onAdClicked() {
                            f.this.ik();
                            if (f.this.bJ != null) {
                                f.this.bJ.a(aVar);
                            }
                        }
                    }));
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    public void ik() {
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.Ll.removeCallbacksAndMessages(null);
        this.bJ = null;
    }

    @Nullable
    public final com.kwad.components.core.c.a.c s(long j) {
        List<com.kwad.components.core.c.a.c> list = this.Lp;
        if (list == null) {
            return null;
        }
        if (j >= 0 || list.size() != 1) {
            for (com.kwad.components.core.c.a.c cVar : this.Lp) {
                if (com.kwad.sdk.core.response.a.d.ca(cVar.mQ()) == j) {
                    return cVar;
                }
            }
            return null;
        }
        return this.Lp.get(0);
    }
}
