package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    Context f9081a;

    /* renamed from: b  reason: collision with root package name */
    int f9082b;
    long c;
    File d;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f9083a;

        /* renamed from: b  reason: collision with root package name */
        private int f9084b = 1;
        private long c = 100;
        private File d;

        public a(Context context) {
            this.f9083a = context.getApplicationContext();
        }

        public a a(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("appVersion <= 0");
            }
            this.f9084b = i;
            return this;
        }

        public a a(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("maxSize <= 0");
            }
            this.c = j;
            return this;
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f9081a = this.f9083a;
            bVar.f9082b = this.f9084b;
            bVar.c = this.c;
            bVar.d = this.d;
            return bVar;
        }
    }

    private b() {
    }
}
