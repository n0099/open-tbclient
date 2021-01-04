package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    Context f9378a;

    /* renamed from: b  reason: collision with root package name */
    int f9379b;
    long c;
    File d;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f9380a;

        /* renamed from: b  reason: collision with root package name */
        private int f9381b = 1;
        private long c = 100;
        private File d;

        public a(Context context) {
            this.f9380a = context.getApplicationContext();
        }

        public a a(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("appVersion <= 0");
            }
            this.f9381b = i;
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
            bVar.f9378a = this.f9380a;
            bVar.f9379b = this.f9381b;
            bVar.c = this.c;
            bVar.d = this.d;
            return bVar;
        }
    }

    private b() {
    }
}
