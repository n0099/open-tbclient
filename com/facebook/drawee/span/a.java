package com.facebook.drawee.span;
/* loaded from: classes6.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b nAw;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.nAw = bVar;
    }

    public void onAttach() {
        this.nAw.onAttach();
    }

    public void onDetach() {
        this.nAw.onDetach();
    }

    public com.facebook.drawee.view.b dVd() {
        return this.nAw;
    }
}
