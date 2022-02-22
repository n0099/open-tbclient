package com.kwad.sdk.core.diskcache.a;

import android.content.Context;
import java.io.File;
/* loaded from: classes4.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f55877b;

    /* renamed from: c  reason: collision with root package name */
    public long f55878c;

    /* renamed from: d  reason: collision with root package name */
    public File f55879d;

    /* loaded from: classes4.dex */
    public static class a {
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public int f55880b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f55881c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f55882d;

        public a(Context context) {
            this.a = context.getApplicationContext();
        }

        public a a(int i2) {
            if (i2 > 0) {
                this.f55880b = i2;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j2) {
            if (j2 > 0) {
                this.f55881c = j2;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f55882d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.a = this.a;
            bVar.f55877b = this.f55880b;
            bVar.f55878c = this.f55881c;
            bVar.f55879d = this.f55882d;
            return bVar;
        }
    }

    public b() {
    }
}
