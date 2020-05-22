package com.facebook.drawee.span;
/* loaded from: classes5.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b mqU;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.mqU = bVar;
    }

    public void onAttach() {
        this.mqU.onAttach();
    }

    public void onDetach() {
        this.mqU.onDetach();
    }

    public com.facebook.drawee.view.b dwQ() {
        return this.mqU;
    }
}
