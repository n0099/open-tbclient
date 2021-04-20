package com.kwad.sdk.glide.webp.decoder;
/* loaded from: classes6.dex */
public final class WebpFrameCacheStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f36108a = new a().a().d();

    /* renamed from: b  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f36109b = new a().c().d();

    /* renamed from: c  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f36110c = new a().b().d();

    /* renamed from: d  reason: collision with root package name */
    public CacheControl f36111d;

    /* renamed from: e  reason: collision with root package name */
    public int f36112e;

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
        public CacheControl f36113a;

        /* renamed from: b  reason: collision with root package name */
        public int f36114b;

        public a a() {
            this.f36113a = CacheControl.CACHE_NONE;
            return this;
        }

        public a b() {
            this.f36113a = CacheControl.CACHE_ALL;
            return this;
        }

        public a c() {
            this.f36113a = CacheControl.CACHE_AUTO;
            return this;
        }

        public WebpFrameCacheStrategy d() {
            return new WebpFrameCacheStrategy(this);
        }
    }

    public WebpFrameCacheStrategy(a aVar) {
        this.f36111d = aVar.f36113a;
        this.f36112e = aVar.f36114b;
    }

    public boolean a() {
        return this.f36111d == CacheControl.CACHE_NONE;
    }

    public boolean b() {
        return this.f36111d == CacheControl.CACHE_ALL;
    }

    public int c() {
        return this.f36112e;
    }
}
