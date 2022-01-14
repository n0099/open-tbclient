package com.kwad.sdk.core.diskcache.a;

import android.content.Context;
import java.io.File;
/* loaded from: classes3.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f55665b;

    /* renamed from: c  reason: collision with root package name */
    public long f55666c;

    /* renamed from: d  reason: collision with root package name */
    public File f55667d;

    /* loaded from: classes3.dex */
    public static class a {
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public int f55668b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f55669c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f55670d;

        public a(Context context) {
            this.a = context.getApplicationContext();
        }

        public a a(int i2) {
            if (i2 > 0) {
                this.f55668b = i2;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j2) {
            if (j2 > 0) {
                this.f55669c = j2;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f55670d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.a = this.a;
            bVar.f55665b = this.f55668b;
            bVar.f55666c = this.f55669c;
            bVar.f55667d = this.f55670d;
            return bVar;
        }
    }

    public b() {
    }
}
