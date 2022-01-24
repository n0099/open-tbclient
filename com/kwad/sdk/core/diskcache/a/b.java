package com.kwad.sdk.core.diskcache.a;

import android.content.Context;
import java.io.File;
/* loaded from: classes3.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f55710b;

    /* renamed from: c  reason: collision with root package name */
    public long f55711c;

    /* renamed from: d  reason: collision with root package name */
    public File f55712d;

    /* loaded from: classes3.dex */
    public static class a {
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public int f55713b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f55714c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f55715d;

        public a(Context context) {
            this.a = context.getApplicationContext();
        }

        public a a(int i2) {
            if (i2 > 0) {
                this.f55713b = i2;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j2) {
            if (j2 > 0) {
                this.f55714c = j2;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f55715d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.a = this.a;
            bVar.f55710b = this.f55713b;
            bVar.f55711c = this.f55714c;
            bVar.f55712d = this.f55715d;
            return bVar;
        }
    }

    public b() {
    }
}
