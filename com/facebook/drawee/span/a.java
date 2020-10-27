package com.facebook.drawee.span;
/* loaded from: classes6.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b oHi;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.oHi = bVar;
    }

    public void onAttach() {
        this.oHi.onAttach();
    }

    public void onDetach() {
        this.oHi.onDetach();
    }

    public com.facebook.drawee.view.b eiM() {
        return this.oHi;
    }
}
