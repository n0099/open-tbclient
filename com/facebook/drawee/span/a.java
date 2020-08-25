package com.facebook.drawee.span;
/* loaded from: classes6.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b nqg;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.nqg = bVar;
    }

    public void onAttach() {
        this.nqg.onAttach();
    }

    public void onDetach() {
        this.nqg.onDetach();
    }

    public com.facebook.drawee.view.b dQW() {
        return this.nqg;
    }
}
