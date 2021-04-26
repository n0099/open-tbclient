package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f32918a;

    /* renamed from: b  reason: collision with root package name */
    public int f32919b;

    /* renamed from: c  reason: collision with root package name */
    public long f32920c;

    /* renamed from: d  reason: collision with root package name */
    public File f32921d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f32922a;

        /* renamed from: b  reason: collision with root package name */
        public int f32923b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f32924c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f32925d;

        public a(Context context) {
            this.f32922a = context.getApplicationContext();
        }

        public a a(int i2) {
            if (i2 > 0) {
                this.f32923b = i2;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j) {
            if (j > 0) {
                this.f32924c = j;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f32925d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f32918a = this.f32922a;
            bVar.f32919b = this.f32923b;
            bVar.f32920c = this.f32924c;
            bVar.f32921d = this.f32925d;
            return bVar;
        }
    }

    public b() {
    }
}
