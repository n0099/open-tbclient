package com.facebook.drawee.span;
/* loaded from: classes6.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b mWq;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.mWq = bVar;
    }

    public void onAttach() {
        this.mWq.onAttach();
    }

    public void onDetach() {
        this.mWq.onDetach();
    }

    public com.facebook.drawee.view.b dEX() {
        return this.mWq;
    }
}
