package com.kwad.sdk.pngencrypt;
/* loaded from: classes10.dex */
public final class p {
    public final e aID;
    public int aJj;
    public int aJm;
    public int aJn;
    public int aJo;
    public int aJp;
    public final k aJz;
    public final boolean aKb;
    public int aKc;
    public int aKd;
    public int aKe;
    public int aKf;
    public int aKg;
    public int aKh;
    public int aKi;
    public byte[] buf;

    public p(k kVar, e eVar) {
        boolean z;
        this.aJz = kVar;
        this.aID = eVar;
        if (eVar != null) {
            z = true;
        } else {
            z = false;
        }
        this.aKb = z;
    }

    public final void h(byte[] bArr, int i) {
        this.buf = bArr;
        this.aKi = i;
    }

    public final void update(int i) {
        this.aKc = i;
        if (this.aKb) {
            this.aJj = this.aID.Ir();
            e eVar = this.aID;
            this.aJn = eVar.aJn;
            this.aJm = eVar.aJm;
            this.aJp = eVar.aJp;
            this.aJo = eVar.aJo;
            this.aKd = eVar.Iq();
            this.aKe = this.aID.Ip();
            this.aKf = this.aID.Is();
            int It = this.aID.It();
            this.aKg = It;
            this.aKh = ((this.aJz.aJJ * It) + 7) / 8;
            return;
        }
        this.aJj = 1;
        this.aJm = 1;
        this.aJn = 1;
        this.aJo = 0;
        this.aJp = 0;
        this.aKe = i;
        this.aKd = i;
        k kVar = this.aJz;
        this.aKf = kVar.aJk;
        this.aKg = kVar.aJl;
        this.aKh = kVar.aJL;
    }
}
