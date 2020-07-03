package com.facebook.drawee.span;
/* loaded from: classes5.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b mOc;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.mOc = bVar;
    }

    public void onAttach() {
        this.mOc.onAttach();
    }

    public void onDetach() {
        this.mOc.onDetach();
    }

    public com.facebook.drawee.view.b dBG() {
        return this.mOc;
    }
}
