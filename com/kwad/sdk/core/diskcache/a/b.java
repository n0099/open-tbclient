package com.kwad.sdk.core.diskcache.a;

import android.content.Context;
import java.io.File;
/* loaded from: classes3.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f57856b;

    /* renamed from: c  reason: collision with root package name */
    public long f57857c;

    /* renamed from: d  reason: collision with root package name */
    public File f57858d;

    /* loaded from: classes3.dex */
    public static class a {
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public int f57859b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f57860c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f57861d;

        public a(Context context) {
            this.a = context.getApplicationContext();
        }

        public a a(int i2) {
            if (i2 > 0) {
                this.f57859b = i2;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j2) {
            if (j2 > 0) {
                this.f57860c = j2;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f57861d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.a = this.a;
            bVar.f57856b = this.f57859b;
            bVar.f57857c = this.f57860c;
            bVar.f57858d = this.f57861d;
            return bVar;
        }
    }

    public b() {
    }
}
