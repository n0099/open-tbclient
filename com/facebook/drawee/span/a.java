package com.facebook.drawee.span;
/* loaded from: classes6.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b oQB;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.oQB = bVar;
    }

    public void onAttach() {
        this.oQB.onAttach();
    }

    public void onDetach() {
        this.oQB.onDetach();
    }

    public com.facebook.drawee.view.b emB() {
        return this.oQB;
    }
}
