package com.kwad.sdk.glide.webp.decoder;
/* loaded from: classes3.dex */
public final class WebpFrameCacheStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f10366a = new a().a().d();

    /* renamed from: b  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f10367b = new a().c().d();
    public static final WebpFrameCacheStrategy c = new a().b().d();
    private CacheControl d;
    private int e;

    /* loaded from: classes3.dex */
    public enum CacheControl {
        CACHE_NONE,
        CACHE_LIMITED,
        CACHE_AUTO,
        CACHE_ALL
    }

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private CacheControl f10368a;

        /* renamed from: b  reason: collision with root package name */
        private int f10369b;

        public a a() {
            this.f10368a = CacheControl.CACHE_NONE;
            return this;
        }

        public a b() {
            this.f10368a = CacheControl.CACHE_ALL;
            return this;
        }

        public a c() {
            this.f10368a = CacheControl.CACHE_AUTO;
            return this;
        }

        public WebpFrameCacheStrategy d() {
            return new WebpFrameCacheStrategy(this);
        }
    }

    private WebpFrameCacheStrategy(a aVar) {
        this.d = aVar.f10368a;
        this.e = aVar.f10369b;
    }

    public boolean a() {
        return this.d == CacheControl.CACHE_NONE;
    }

    public boolean b() {
        return this.d == CacheControl.CACHE_ALL;
    }

    public int c() {
        return this.e;
    }
}
