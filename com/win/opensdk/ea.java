package com.win.opensdk;

import android.text.TextUtils;
/* loaded from: classes14.dex */
public class ea implements bh {
    public final /* synthetic */ ed qmd;

    public ea(ed edVar) {
        this.qmd = edVar;
    }

    @Override // com.win.opensdk.bh
    public void a() {
        bh bhVar = this.qmd.qmg.qmi;
        if (bhVar != null) {
            bhVar.a();
        }
    }

    @Override // com.win.opensdk.bh
    public void a(int i, String str) {
        bh bhVar = this.qmd.qmg.qmi;
        if (bhVar != null) {
            bhVar.a(i, str);
        }
    }

    @Override // com.win.opensdk.bh
    public void a(Object obj) {
        n fq = el.fq(((ep) obj).c);
        eh ehVar = this.qmd.qmg;
        bh bhVar = ehVar.qmi;
        if (bhVar != null) {
            if (fq != null) {
                if (TextUtils.isEmpty(ehVar.b) || !this.qmd.qmg.b.equalsIgnoreCase(fq.a())) {
                    this.qmd.qmg.qmi.a(2003, "");
                    return;
                } else {
                    this.qmd.qmg.qmi.a(fq);
                    return;
                }
            }
            bhVar.a(101, "");
        }
    }
}
