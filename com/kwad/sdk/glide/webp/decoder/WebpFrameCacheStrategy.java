package com.kwad.sdk.glide.webp.decoder;
/* loaded from: classes6.dex */
public final class WebpFrameCacheStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f35818a = new a().a().d();

    /* renamed from: b  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f35819b = new a().c().d();

    /* renamed from: c  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f35820c = new a().b().d();

    /* renamed from: d  reason: collision with root package name */
    public CacheControl f35821d;

    /* renamed from: e  reason: collision with root package name */
    public int f35822e;

    /* loaded from: classes6.dex */
    public enum CacheControl {
        CACHE_NONE,
        CACHE_LIMITED,
        CACHE_AUTO,
        CACHE_ALL
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public CacheControl f35823a;

        /* renamed from: b  reason: collision with root package name */
        public int f35824b;

        public a a() {
            this.f35823a = CacheControl.CACHE_NONE;
            return this;
        }

        public a b() {
            this.f35823a = CacheControl.CACHE_ALL;
            return this;
        }

        public a c() {
            this.f35823a = CacheControl.CACHE_AUTO;
            return this;
        }

        public WebpFrameCacheStrategy d() {
            return new WebpFrameCacheStrategy(this);
        }
    }

    public WebpFrameCacheStrategy(a aVar) {
        this.f35821d = aVar.f35823a;
        this.f35822e = aVar.f35824b;
    }

    public boolean a() {
        return this.f35821d == CacheControl.CACHE_NONE;
    }

    public boolean b() {
        return this.f35821d == CacheControl.CACHE_ALL;
    }

    public int c() {
        return this.f35822e;
    }
}
