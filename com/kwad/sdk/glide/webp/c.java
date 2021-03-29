package com.kwad.sdk.glide.webp;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f35811a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35812b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35813c;

    /* renamed from: d  reason: collision with root package name */
    public final int f35814d;

    /* renamed from: e  reason: collision with root package name */
    public final int f35815e;

    /* renamed from: f  reason: collision with root package name */
    public final int f35816f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f35817g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f35818h;

    public c(int i, WebpFrame webpFrame) {
        this.f35811a = i;
        this.f35812b = webpFrame.getXOffest();
        this.f35813c = webpFrame.getYOffest();
        this.f35814d = webpFrame.getWidth();
        this.f35815e = webpFrame.getHeight();
        this.f35816f = webpFrame.getDurationMs();
        this.f35817g = webpFrame.isBlendWithPreviousFrame();
        this.f35818h = webpFrame.shouldDisposeToBackgroundColor();
    }

    public String toString() {
        return "frameNumber=" + this.f35811a + ", xOffset=" + this.f35812b + ", yOffset=" + this.f35813c + ", width=" + this.f35814d + ", height=" + this.f35815e + ", duration=" + this.f35816f + ", blendPreviousFrame=" + this.f35817g + ", disposeBackgroundColor=" + this.f35818h;
    }
}
