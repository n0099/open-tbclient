package com.facebook.drawee.span;
/* loaded from: classes5.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b mse;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.mse = bVar;
    }

    public void onAttach() {
        this.mse.onAttach();
    }

    public void onDetach() {
        this.mse.onDetach();
    }

    public com.facebook.drawee.view.b dxe() {
        return this.mse;
    }
}
