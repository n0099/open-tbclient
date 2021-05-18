package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f32163a;

    /* renamed from: b  reason: collision with root package name */
    public int f32164b;

    /* renamed from: c  reason: collision with root package name */
    public long f32165c;

    /* renamed from: d  reason: collision with root package name */
    public File f32166d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f32167a;

        /* renamed from: b  reason: collision with root package name */
        public int f32168b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f32169c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f32170d;

        public a(Context context) {
            this.f32167a = context.getApplicationContext();
        }

        public a a(int i2) {
            if (i2 > 0) {
                this.f32168b = i2;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j) {
            if (j > 0) {
                this.f32169c = j;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f32170d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f32163a = this.f32167a;
            bVar.f32164b = this.f32168b;
            bVar.f32165c = this.f32169c;
            bVar.f32166d = this.f32170d;
            return bVar;
        }
    }

    public b() {
    }
}
