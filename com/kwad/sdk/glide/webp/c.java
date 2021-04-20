package com.kwad.sdk.glide.webp;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f36100a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36101b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36102c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36103d;

    /* renamed from: e  reason: collision with root package name */
    public final int f36104e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36105f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f36106g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f36107h;

    public c(int i, WebpFrame webpFrame) {
        this.f36100a = i;
        this.f36101b = webpFrame.getXOffest();
        this.f36102c = webpFrame.getYOffest();
        this.f36103d = webpFrame.getWidth();
        this.f36104e = webpFrame.getHeight();
        this.f36105f = webpFrame.getDurationMs();
        this.f36106g = webpFrame.isBlendWithPreviousFrame();
        this.f36107h = webpFrame.shouldDisposeToBackgroundColor();
    }

    public String toString() {
        return "frameNumber=" + this.f36100a + ", xOffset=" + this.f36101b + ", yOffset=" + this.f36102c + ", width=" + this.f36103d + ", height=" + this.f36104e + ", duration=" + this.f36105f + ", blendPreviousFrame=" + this.f36106g + ", disposeBackgroundColor=" + this.f36107h;
    }
}
