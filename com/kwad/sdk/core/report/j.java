package com.kwad.sdk.core.report;

import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
/* loaded from: classes10.dex */
public final class j {
    public y.b avC = new y.b();

    private void DA() {
        y.b bVar = this.avC;
        if (bVar.axK == null) {
            bVar.axK = new y.a();
        }
    }

    public final y.b Dz() {
        return this.avC;
    }

    public final j a(y.a aVar) {
        this.avC.axK = aVar;
        return this;
    }

    public final j ai(long j) {
        this.avC.vy = j;
        return this;
    }

    public final j cA(int i) {
        this.avC.kk = i;
        return this;
    }

    public final j cB(int i) {
        this.avC.axm = i;
        return this;
    }

    public final j cC(int i) {
        this.avC.axn = i;
        return this;
    }

    public final j cD(int i) {
        this.avC.downloadSource = i;
        return this;
    }

    public final j cE(int i) {
        this.avC.avQ = i;
        return this;
    }

    public final j cF(int i) {
        this.avC.axD = i;
        return this;
    }

    public final j cG(int i) {
        this.avC.axE = i;
        return this;
    }

    public final j cH(int i) {
        this.avC.axs = i;
        return this;
    }

    public final j cI(int i) {
        this.avC.axL = i;
        return this;
    }

    public final j cJ(int i) {
        this.avC.axQ = i;
        return this;
    }

    public final j cK(int i) {
        this.avC.cP(i);
        return this;
    }

    public final j cL(int i) {
        this.avC.axS = i;
        return this;
    }

    public final j cM(int i) {
        this.avC.axT = i;
        return this;
    }

    public final j cN(int i) {
        this.avC.axU = i;
        return this;
    }

    public final j cO(int i) {
        this.avC.axt = i;
        return this;
    }

    public final j d(ac.a aVar) {
        this.avC.km = aVar;
        return this;
    }

    public final j dO(String str) {
        this.avC.Xd = str;
        return this;
    }

    public final j dP(String str) {
        this.avC.axB = str;
        return this;
    }

    public final j dQ(String str) {
        this.avC.axC = str;
        return this;
    }

    public final j dR(String str) {
        this.avC.axO = str;
        return this;
    }

    public final j l(double d) {
        this.avC.kn = d;
        return this;
    }

    public final j a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
        AdTrackLog adTrackLog;
        DA();
        this.avC.axK.e(adTemplate, str, str2);
        if (aVar != null && (adTrackLog = this.avC.axK.axj) != null) {
            aVar.accept(adTrackLog);
        }
        return this;
    }

    public final j x(int i, int i2) {
        this.avC.axo = i + "," + i2;
        return this;
    }
}
