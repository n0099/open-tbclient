package com.facebook.drawee.span;
/* loaded from: classes6.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b oSe;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.oSe = bVar;
    }

    public void onAttach() {
        this.oSe.onAttach();
    }

    public void onDetach() {
        this.oSe.onDetach();
    }

    public com.facebook.drawee.view.b emz() {
        return this.oSe;
    }
}
