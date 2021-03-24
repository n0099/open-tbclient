package com.kwad.sdk.glide.webp;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f35810a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35811b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35812c;

    /* renamed from: d  reason: collision with root package name */
    public final int f35813d;

    /* renamed from: e  reason: collision with root package name */
    public final int f35814e;

    /* renamed from: f  reason: collision with root package name */
    public final int f35815f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f35816g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f35817h;

    public c(int i, WebpFrame webpFrame) {
        this.f35810a = i;
        this.f35811b = webpFrame.getXOffest();
        this.f35812c = webpFrame.getYOffest();
        this.f35813d = webpFrame.getWidth();
        this.f35814e = webpFrame.getHeight();
        this.f35815f = webpFrame.getDurationMs();
        this.f35816g = webpFrame.isBlendWithPreviousFrame();
        this.f35817h = webpFrame.shouldDisposeToBackgroundColor();
    }

    public String toString() {
        return "frameNumber=" + this.f35810a + ", xOffset=" + this.f35811b + ", yOffset=" + this.f35812c + ", width=" + this.f35813d + ", height=" + this.f35814e + ", duration=" + this.f35815f + ", blendPreviousFrame=" + this.f35816g + ", disposeBackgroundColor=" + this.f35817h;
    }
}
