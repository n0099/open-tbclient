package com.facebook.drawee.span;
/* loaded from: classes6.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b nqy;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.nqy = bVar;
    }

    public void onAttach() {
        this.nqy.onAttach();
    }

    public void onDetach() {
        this.nqy.onDetach();
    }

    public com.facebook.drawee.view.b dRf() {
        return this.nqy;
    }
}
