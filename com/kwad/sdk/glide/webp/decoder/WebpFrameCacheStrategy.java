package com.kwad.sdk.glide.webp.decoder;
/* loaded from: classes7.dex */
public final class WebpFrameCacheStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f36615a = new a().a().d();

    /* renamed from: b  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f36616b = new a().c().d();

    /* renamed from: c  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f36617c = new a().b().d();

    /* renamed from: d  reason: collision with root package name */
    public CacheControl f36618d;

    /* renamed from: e  reason: collision with root package name */
    public int f36619e;

    /* loaded from: classes7.dex */
    public enum CacheControl {
        CACHE_NONE,
        CACHE_LIMITED,
        CACHE_AUTO,
        CACHE_ALL
    }

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public CacheControl f36620a;

        /* renamed from: b  reason: collision with root package name */
        public int f36621b;

        public a a() {
            this.f36620a = CacheControl.CACHE_NONE;
            return this;
        }

        public a b() {
            this.f36620a = CacheControl.CACHE_ALL;
            return this;
        }

        public a c() {
            this.f36620a = CacheControl.CACHE_AUTO;
            return this;
        }

        public WebpFrameCacheStrategy d() {
            return new WebpFrameCacheStrategy(this);
        }
    }

    public WebpFrameCacheStrategy(a aVar) {
        this.f36618d = aVar.f36620a;
        this.f36619e = aVar.f36621b;
    }

    public boolean a() {
        return this.f36618d == CacheControl.CACHE_NONE;
    }

    public boolean b() {
        return this.f36618d == CacheControl.CACHE_ALL;
    }

    public int c() {
        return this.f36619e;
    }
}
