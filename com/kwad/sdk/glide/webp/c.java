package com.kwad.sdk.glide.webp;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f36195a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36196b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36197c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36198d;

    /* renamed from: e  reason: collision with root package name */
    public final int f36199e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36200f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f36201g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f36202h;

    public c(int i, WebpFrame webpFrame) {
        this.f36195a = i;
        this.f36196b = webpFrame.getXOffest();
        this.f36197c = webpFrame.getYOffest();
        this.f36198d = webpFrame.getWidth();
        this.f36199e = webpFrame.getHeight();
        this.f36200f = webpFrame.getDurationMs();
        this.f36201g = webpFrame.isBlendWithPreviousFrame();
        this.f36202h = webpFrame.shouldDisposeToBackgroundColor();
    }

    public String toString() {
        return "frameNumber=" + this.f36195a + ", xOffset=" + this.f36196b + ", yOffset=" + this.f36197c + ", width=" + this.f36198d + ", height=" + this.f36199e + ", duration=" + this.f36200f + ", blendPreviousFrame=" + this.f36201g + ", disposeBackgroundColor=" + this.f36202h;
    }
}
