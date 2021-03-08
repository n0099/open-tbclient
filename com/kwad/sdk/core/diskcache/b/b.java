package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    Context f6037a;
    int b;
    long c;
    File d;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f6038a;
        private int b = 1;
        private long c = 100;
        private File d;

        public a(Context context) {
            this.f6038a = context.getApplicationContext();
        }

        public a a(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("appVersion <= 0");
            }
            this.b = i;
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
            bVar.f6037a = this.f6038a;
            bVar.b = this.b;
            bVar.c = this.c;
            bVar.d = this.d;
            return bVar;
        }
    }

    private b() {
    }
}
