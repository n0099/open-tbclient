package com.facebook.drawee.span;
/* loaded from: classes6.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b mWo;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.mWo = bVar;
    }

    public void onAttach() {
        this.mWo.onAttach();
    }

    public void onDetach() {
        this.mWo.onDetach();
    }

    public com.facebook.drawee.view.b dEW() {
        return this.mWo;
    }
}
