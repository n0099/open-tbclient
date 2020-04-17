package com.facebook.drawee.span;
/* loaded from: classes5.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b lWW;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.lWW = bVar;
    }

    public void onAttach() {
        this.lWW.onAttach();
    }

    public void onDetach() {
        this.lWW.onDetach();
    }

    public com.facebook.drawee.view.b dpA() {
        return this.lWW;
    }
}
