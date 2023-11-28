package com.kwad.components.core.webview.jshandler;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class x implements com.kwad.sdk.core.webview.c.a {
    public final com.kwad.sdk.core.webview.b VP;
    public int Wb;
    public boolean Wc;
    public final boolean Wd;
    public boolean We;
    public List<com.kwad.components.core.e.d.c> Wf;
    public boolean Wg;
    @Nullable
    public com.kwad.sdk.core.webview.d.a.a cR;
    @Nullable
    public DialogInterface.OnDismissListener xA;

    public void K(int i) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    public void jf() {
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, 0, false, false);
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, int i) {
        this(bVar, cVar, aVar, false, 1, false, false);
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, int i, boolean z) {
        this(bVar, cVar, null, false, 2, z, false);
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.xA = onDismissListener;
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.We = true;
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z, int i, boolean z2, boolean z3) {
        this.Wc = false;
        this.Wf = new ArrayList();
        this.Wc = z;
        this.VP = bVar;
        this.Wb = i;
        if (cVar != null) {
            cVar.aq(1);
            this.Wf.add(cVar);
        }
        this.cR = aVar;
        this.Wd = z2;
        this.Wg = z3;
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable List<com.kwad.components.core.e.d.c> list, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, null, aVar, false, 0, false, false);
        if (list != null) {
            this.Wf.addAll(list);
        }
    }

    public static boolean aA(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.b.e.dK(adTemplate) == 13) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean a(x xVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    public static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar.Xn == 1) {
            return true;
        }
        return false;
    }

    @Nullable
    public final com.kwad.components.core.e.d.c F(long j) {
        List<com.kwad.components.core.e.d.c> list = this.Wf;
        if (list == null) {
            return null;
        }
        if (j < 0 && list.size() == 1) {
            return this.Wf.get(0);
        }
        for (com.kwad.components.core.e.d.c cVar : this.Wf) {
            if (com.kwad.sdk.core.response.b.e.dZ(cVar.nS()) == j) {
                return cVar;
            }
        }
        return null;
    }

    @NonNull
    public y.b a(com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        com.kwad.sdk.core.webview.d.b.c cVar;
        int i;
        com.kwad.sdk.core.report.j jVar = new com.kwad.sdk.core.report.j();
        com.kwad.sdk.core.webview.d.b.c cVar2 = aVar.Xo;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.Xd)) {
            jVar.dO(aVar.Xo.Xd);
        }
        com.kwad.sdk.core.webview.d.b.c cVar3 = aVar.Xo;
        if (cVar3 != null && (i = cVar3.aDL) != 0) {
            jVar.cM(i);
        }
        if (aA(adTemplate) && (cVar = aVar.Xo) != null && cVar.aDM != null) {
            ac.a aVar2 = new ac.a();
            com.kwad.sdk.core.webview.d.b.b bVar = aVar.Xo.aDM;
            aVar2.g((float) bVar.x, (float) bVar.y);
            com.kwad.sdk.core.webview.d.b.b bVar2 = aVar.Xo.aDM;
            aVar2.f((float) bVar2.x, (float) bVar2.y);
            com.kwad.sdk.core.webview.d.b.b bVar3 = aVar.Xo.aDM;
            aVar2.B(bVar3.width, bVar3.height);
            jVar.d(aVar2);
        } else {
            com.kwad.sdk.widget.e eVar = this.VP.aCG;
            if (eVar != null) {
                jVar.d(eVar.getTouchCoords());
            }
        }
        jVar.a(adTemplate, null, null, null);
        return jVar.Dz();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        if (this.VP.FE() && aVar.adTemplate == null) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        if (this.VP.aCI && !aVar.aDJ) {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.x.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    TKAdLiveShopItemInfo tKAdLiveShopItemInfo;
                    com.kwad.sdk.core.webview.b bVar = x.this.VP;
                    if (!bVar.aCJ) {
                        return;
                    }
                    com.kwad.sdk.core.webview.d.b.a aVar2 = aVar;
                    AdTemplate adTemplate = aVar2.adTemplate;
                    if (adTemplate != null) {
                        x.this.Wf.add(new com.kwad.components.core.e.d.c(adTemplate));
                    } else if (aVar2.creativeId >= 0) {
                        List<AdTemplate> FD = bVar.FD();
                        com.kwad.sdk.core.webview.d.b.a aVar3 = aVar;
                        adTemplate = com.kwad.sdk.core.response.b.e.a(FD, aVar3.creativeId, aVar3.adStyle);
                    } else {
                        adTemplate = bVar.getAdTemplate();
                        aVar.creativeId = com.kwad.sdk.core.response.b.e.dZ(adTemplate);
                        aVar.adStyle = com.kwad.sdk.core.response.b.e.dK(adTemplate);
                    }
                    com.kwad.components.core.e.d.c F = x.this.F(aVar.creativeId);
                    if (x.this.xA != null && F != null) {
                        F.setOnDismissListener(x.this.xA);
                    }
                    String str2 = null;
                    if (!TextUtils.isEmpty(aVar.KM)) {
                        try {
                            str2 = com.kwad.components.core.e.b.a.t(Long.parseLong(aVar.KM));
                        } catch (Exception unused) {
                            str2 = aVar.KM;
                        }
                    } else if (adTemplate != null && (tKAdLiveShopItemInfo = adTemplate.tkLiveShopItemInfo) != null) {
                        str2 = tKAdLiveShopItemInfo.itemId;
                    }
                    a.C0644a am = new a.C0644a(x.this.VP.Ov.getContext()).aq(adTemplate).b(F).af(str2).ao(x.a(x.this, aVar)).ap(x.this.Wc).c(x.this.VP.mReportExtData).an(aVar.Xn).al(aVar.aDI).am(aVar.kk);
                    if (!x.this.Wd && !aVar.KC) {
                        z = false;
                    } else {
                        z = true;
                    }
                    x.this.K(com.kwad.components.core.e.d.a.a(am.aq(z).ap(x.this.Wb).al(x.this.Wg).a(x.this.a(aVar, adTemplate)).as(x.this.We).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.x.1.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            x.this.jf();
                            if (x.this.cR != null) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (!aVar.aDK) {
                                    x.this.cR.a(aVar);
                                }
                            }
                        }
                    })));
                }
            });
        } else if (this.cR != null) {
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.x.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (x.this.cR != null && !aVar.aDK) {
                        x.this.cR.a(aVar);
                    }
                }
            });
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.cR = null;
    }
}
