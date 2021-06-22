package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes7.dex */
public class c implements l {

    /* renamed from: a  reason: collision with root package name */
    public final b f36256a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final h<a, Bitmap> f36257b = new h<>();

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class a implements m {

        /* renamed from: a  reason: collision with root package name */
        public final b f36258a;

        /* renamed from: b  reason: collision with root package name */
        public int f36259b;

        /* renamed from: c  reason: collision with root package name */
        public int f36260c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap.Config f36261d;

        public a(b bVar) {
            this.f36258a = bVar;
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f36258a.a(this);
        }

        public void a(int i2, int i3, Bitmap.Config config) {
            this.f36259b = i2;
            this.f36260c = i3;
            this.f36261d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f36259b == aVar.f36259b && this.f36260c == aVar.f36260c && this.f36261d == aVar.f36261d;
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.f36259b * 31) + this.f36260c) * 31;
            Bitmap.Config config = this.f36261d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.c(this.f36259b, this.f36260c, this.f36261d);
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class b extends d<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: a */
        public a b() {
            return new a(this);
        }

        public a a(int i2, int i3, Bitmap.Config config) {
            a c2 = c();
            c2.a(i2, i3, config);
            return c2;
        }
    }

    public static String c(int i2, int i3, Bitmap.Config config) {
        return PreferencesUtil.LEFT_MOUNT + i2 + "x" + i3 + "], " + config;
    }

    public static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public Bitmap a() {
        return this.f36257b.a();
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return this.f36257b.a((h<a, Bitmap>) this.f36256a.a(i2, i3, config));
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public void a(Bitmap bitmap) {
        this.f36257b.a(this.f36256a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public String b(int i2, int i3, Bitmap.Config config) {
        return c(i2, i3, config);
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
        return "AttributeStrategy:\n  " + this.f36257b;
    }
}
