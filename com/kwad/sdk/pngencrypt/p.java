package com.kwad.sdk.pngencrypt;
/* loaded from: classes5.dex */
public final class p {
    public final e ajN;
    public final k akJ;
    public int akt;
    public int akw;
    public int akx;
    public int aky;
    public int akz;
    public final boolean all;
    public int alm;
    public int aln;
    public int alo;
    public int alp;
    public int alq;
    public int alr;
    public int als;
    public byte[] buf;

    public p(k kVar, e eVar) {
        this.akJ = kVar;
        this.ajN = eVar;
        this.all = eVar != null;
    }

    public final void h(byte[] bArr, int i) {
        this.buf = bArr;
        this.als = i;
    }

    public final void update(int i) {
        this.alm = i;
        if (!this.all) {
            this.akt = 1;
            this.akw = 1;
            this.akx = 1;
            this.aky = 0;
            this.akz = 0;
            this.alo = i;
            this.aln = i;
            k kVar = this.akJ;
            this.alp = kVar.aku;
            this.alq = kVar.akv;
            this.alr = kVar.akV;
            return;
        }
        this.akt = this.ajN.yo();
        e eVar = this.ajN;
        this.akx = eVar.akx;
        this.akw = eVar.akw;
        this.akz = eVar.akz;
        this.aky = eVar.aky;
        this.aln = eVar.yn();
        this.alo = this.ajN.ym();
        this.alp = this.ajN.yp();
        int yq = this.ajN.yq();
        this.alq = yq;
        this.alr = ((this.akJ.akT * yq) + 7) / 8;
    }
}
