package com.kwad.sdk.core.diskcache.a;

import android.content.Context;
import java.io.File;
/* loaded from: classes5.dex */
public class b {
    public Context a;
    public int b;
    public long c;
    public File d;

    /* loaded from: classes5.dex */
    public static class a {
        public Context a;
        public int b = 1;
        public long c = 100;
        public File d;

        public a(Context context) {
            this.a = context.getApplicationContext();
        }

        public a a(int i) {
            if (i > 0) {
                this.b = i;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j) {
            if (j > 0) {
                this.c = j;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.a = this.a;
            bVar.b = this.b;
            bVar.c = this.c;
            bVar.d = this.d;
            return bVar;
        }
    }

    public b() {
    }
}
