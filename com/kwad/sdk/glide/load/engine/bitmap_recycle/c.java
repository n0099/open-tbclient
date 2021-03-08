package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final b f6740a = new b();
    private final h<a, Bitmap> b = new h<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f6741a;
        private int b;
        private int c;
        private Bitmap.Config d;

        public a(b bVar) {
            this.f6741a = bVar;
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f6741a.a(this);
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.b = i;
            this.c = i2;
            this.d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
            }
            return false;
        }

        public int hashCode() {
            return (this.d != null ? this.d.hashCode() : 0) + (((this.b * 31) + this.c) * 31);
        }

        public String toString() {
            return c.c(this.b, this.c, this.d);
        }
    }

    @VisibleForTesting
    /* loaded from: classes3.dex */
    static class b extends d<a> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: a */
        public a b() {
            return new a(this);
        }

        a a(int i, int i2, Bitmap.Config config) {
            a c = c();
            c.a(i, i2, config);
            return c;
        }
    }

    static String c(int i, int i2, Bitmap.Config config) {
        return "[" + i + Config.EVENT_HEAT_X + i2 + "], " + config;
    }

    private static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public Bitmap a() {
        return this.b.a();
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.b.a((h<a, Bitmap>) this.f6740a.a(i, i2, config));
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public void a(Bitmap bitmap) {
        this.b.a(this.f6740a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
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
        return "AttributeStrategy:\n  " + this.b;
    }
}
