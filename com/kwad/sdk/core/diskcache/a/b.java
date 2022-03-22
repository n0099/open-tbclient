package com.kwad.sdk.core.diskcache.a;

import android.content.Context;
import java.io.File;
/* loaded from: classes7.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f39362b;

    /* renamed from: c  reason: collision with root package name */
    public long f39363c;

    /* renamed from: d  reason: collision with root package name */
    public File f39364d;

    /* loaded from: classes7.dex */
    public static class a {
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public int f39365b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f39366c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f39367d;

        public a(Context context) {
            this.a = context.getApplicationContext();
        }

        public a a(int i) {
            if (i > 0) {
                this.f39365b = i;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j) {
            if (j > 0) {
                this.f39366c = j;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f39367d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.a = this.a;
            bVar.f39362b = this.f39365b;
            bVar.f39363c = this.f39366c;
            bVar.f39364d = this.f39367d;
            return bVar;
        }
    }

    public b() {
    }
}
