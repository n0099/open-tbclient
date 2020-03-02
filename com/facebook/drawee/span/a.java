package com.facebook.drawee.span;
/* loaded from: classes5.dex */
public class a extends com.facebook.e.a.a.a {
    private final com.facebook.drawee.view.b mDraweeHolder;

    public a(com.facebook.drawee.view.b bVar, int i) {
        super(bVar.getTopLevelDrawable(), i);
        this.mDraweeHolder = bVar;
    }

    public void onAttach() {
        this.mDraweeHolder.onAttach();
    }

    public void onDetach() {
        this.mDraweeHolder.onDetach();
    }

    public com.facebook.drawee.view.b dnh() {
        return this.mDraweeHolder;
    }
}
