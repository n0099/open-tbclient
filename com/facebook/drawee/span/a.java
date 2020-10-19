package com.facebook.drawee.span;
/* loaded from: classes6.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b nPP;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.nPP = bVar;
    }

    public void onAttach() {
        this.nPP.onAttach();
    }

    public void onDetach() {
        this.nPP.onDetach();
    }

    public com.facebook.drawee.view.b dYO() {
        return this.nPP;
    }
}
