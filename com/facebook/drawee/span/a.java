package com.facebook.drawee.span;
/* loaded from: classes5.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b lXa;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.lXa = bVar;
    }

    public void onAttach() {
        this.lXa.onAttach();
    }

    public void onDetach() {
        this.lXa.onDetach();
    }

    public com.facebook.drawee.view.b dpy() {
        return this.lXa;
    }
}
