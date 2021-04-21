package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
/* loaded from: classes6.dex */
public class c implements l {

    /* renamed from: a  reason: collision with root package name */
    public final b f35856a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final h<a, Bitmap> f35857b = new h<>();

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class a implements m {

        /* renamed from: a  reason: collision with root package name */
        public final b f35858a;

        /* renamed from: b  reason: collision with root package name */
        public int f35859b;

        /* renamed from: c  reason: collision with root package name */
        public int f35860c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap.Config f35861d;

        public a(b bVar) {
            this.f35858a = bVar;
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f35858a.a(this);
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.f35859b = i;
            this.f35860c = i2;
            this.f35861d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f35859b == aVar.f35859b && this.f35860c == aVar.f35860c && this.f35861d == aVar.f35861d;
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.f35859b * 31) + this.f35860c) * 31;
            Bitmap.Config config = this.f35861d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.c(this.f35859b, this.f35860c, this.f35861d);
        }
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class b extends d<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: a */
        public a b() {
            return new a(this);
        }

        public a a(int i, int i2, Bitmap.Config config) {
            a c2 = c();
            c2.a(i, i2, config);
            return c2;
        }
    }

    public static String c(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    public static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public Bitmap a() {
        return this.f35857b.a();
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f35857b.a((h<a, Bitmap>) this.f35856a.a(i, i2, config));
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public void a(Bitmap bitmap) {
        this.f35857b.a(this.f35856a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public String b(int i, int i2, Bitmap.Config config) {
        return c(i, i2, config);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public String b(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public int c(Bitmap bitmap) {
        return com.kwad.sdk.glide.g.k.a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f35857b;
    }
}
