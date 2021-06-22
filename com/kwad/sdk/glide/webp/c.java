package com.kwad.sdk.glide.webp;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f36607a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36608b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36609c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36610d;

    /* renamed from: e  reason: collision with root package name */
    public final int f36611e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36612f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f36613g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f36614h;

    public c(int i2, WebpFrame webpFrame) {
        this.f36607a = i2;
        this.f36608b = webpFrame.getXOffest();
        this.f36609c = webpFrame.getYOffest();
        this.f36610d = webpFrame.getWidth();
        this.f36611e = webpFrame.getHeight();
        this.f36612f = webpFrame.getDurationMs();
        this.f36613g = webpFrame.isBlendWithPreviousFrame();
        this.f36614h = webpFrame.shouldDisposeToBackgroundColor();
    }

    public String toString() {
        return "frameNumber=" + this.f36607a + ", xOffset=" + this.f36608b + ", yOffset=" + this.f36609c + ", width=" + this.f36610d + ", height=" + this.f36611e + ", duration=" + this.f36612f + ", blendPreviousFrame=" + this.f36613g + ", disposeBackgroundColor=" + this.f36614h;
    }
}
