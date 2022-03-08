package com.kwad.sdk.core.diskcache.a;

import android.content.Context;
import java.io.File;
/* loaded from: classes7.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f54227b;

    /* renamed from: c  reason: collision with root package name */
    public long f54228c;

    /* renamed from: d  reason: collision with root package name */
    public File f54229d;

    /* loaded from: classes7.dex */
    public static class a {
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public int f54230b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f54231c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f54232d;

        public a(Context context) {
            this.a = context.getApplicationContext();
        }

        public a a(int i2) {
            if (i2 > 0) {
                this.f54230b = i2;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j2) {
            if (j2 > 0) {
                this.f54231c = j2;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f54232d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.a = this.a;
            bVar.f54227b = this.f54230b;
            bVar.f54228c = this.f54231c;
            bVar.f54229d = this.f54232d;
            return bVar;
        }
    }

    public b() {
    }
}
