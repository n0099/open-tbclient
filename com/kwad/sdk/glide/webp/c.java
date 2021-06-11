package com.kwad.sdk.glide.webp;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f36509a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36510b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36511c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36512d;

    /* renamed from: e  reason: collision with root package name */
    public final int f36513e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36514f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f36515g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f36516h;

    public c(int i2, WebpFrame webpFrame) {
        this.f36509a = i2;
        this.f36510b = webpFrame.getXOffest();
        this.f36511c = webpFrame.getYOffest();
        this.f36512d = webpFrame.getWidth();
        this.f36513e = webpFrame.getHeight();
        this.f36514f = webpFrame.getDurationMs();
        this.f36515g = webpFrame.isBlendWithPreviousFrame();
        this.f36516h = webpFrame.shouldDisposeToBackgroundColor();
    }

    public String toString() {
        return "frameNumber=" + this.f36509a + ", xOffset=" + this.f36510b + ", yOffset=" + this.f36511c + ", width=" + this.f36512d + ", height=" + this.f36513e + ", duration=" + this.f36514f + ", blendPreviousFrame=" + this.f36515g + ", disposeBackgroundColor=" + this.f36516h;
    }
}
