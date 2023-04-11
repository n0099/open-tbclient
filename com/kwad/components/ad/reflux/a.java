package com.kwad.components.ad.reflux;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.c.b;
import com.kwad.components.core.c.a.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class a extends com.kwad.sdk.core.download.kwai.a {
    public int itemType;
    @Nullable
    public b kW;
    public int kX;
    public String kY;
    public String kZ;
    public String la;
    public String lb;
    public String lc;
    public boolean ld = false;
    public int le = -1;
    public int lf;
    public int lg;
    public InterfaceC0563a lh;
    public c mApkDownloadHelper;
    public String title;

    /* renamed from: com.kwad.components.ad.reflux.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0563a {
        void eF();
    }

    public a(@Nullable b bVar) {
        this.kW = bVar;
    }

    public static a a(b bVar) {
        AdTemplate adTemplate = bVar.getAdTemplate();
        AdInfo bQ = d.bQ(adTemplate);
        a aVar = new a(bVar);
        aVar.K(0);
        aVar.ld = com.kwad.sdk.core.response.a.a.am(bQ);
        aVar.kX = adTemplate.type;
        aVar.title = com.kwad.sdk.core.response.a.a.ad(bQ);
        aVar.kZ = com.kwad.sdk.core.response.a.a.J(bQ);
        aVar.lc = com.kwad.sdk.core.response.a.a.al(bQ);
        aVar.lb = com.kwad.sdk.core.response.a.a.ad(bQ);
        aVar.la = com.kwad.sdk.core.response.a.a.bl(bQ);
        aVar.kY = com.kwad.sdk.core.response.a.a.bn(bQ);
        return aVar;
    }

    public static List<a> b(List<b> list, List<c> list2) {
        ArrayList arrayList = null;
        if (list != null && list.size() != 0 && list2.size() != 0) {
            if (list.size() != list2.size()) {
                return null;
            }
            arrayList = new ArrayList();
            int i = 0;
            for (b bVar : list) {
                a a = a(bVar);
                a.setApkDownloadHelper(list2.get(i));
                a.le = i;
                arrayList.add(a);
                i++;
            }
        }
        return arrayList;
    }

    private void eU() {
        InterfaceC0563a interfaceC0563a = this.lh;
        if (interfaceC0563a != null) {
            interfaceC0563a.eF();
        }
    }

    private void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public final void K(int i) {
        this.itemType = i;
    }

    public final void a(InterfaceC0563a interfaceC0563a) {
        this.lh = interfaceC0563a;
    }

    public final b eJ() {
        return this.kW;
    }

    public final void eK() {
        c cVar;
        if (!eP() || (cVar = this.mApkDownloadHelper) == null) {
            return;
        }
        cVar.b(this);
    }

    public final String eL() {
        return this.kY;
    }

    public final String eM() {
        return this.la;
    }

    public final String eN() {
        return this.lb;
    }

    public final String eO() {
        return this.kZ;
    }

    public final boolean eP() {
        return this.ld;
    }

    public final int eQ() {
        return this.le;
    }

    public final int eR() {
        int i = this.itemType;
        return i == 0 ? this.kX : i;
    }

    public final int eS() {
        return this.lf;
    }

    public final int eT() {
        return this.lg;
    }

    public final AdTemplate getAdTemplate() {
        b bVar = this.kW;
        if (bVar != null) {
            return bVar.getAdTemplate();
        }
        return null;
    }

    public final c getApkDownloadHelper() {
        return this.mApkDownloadHelper;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        this.lf = 11;
        eU();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        this.lf = 8;
        eU();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        this.lf = 0;
        this.lg = 0;
        eU();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        this.lf = 12;
        eU();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i) {
        this.lf = 2;
        this.lg = i;
        eU();
    }
}
