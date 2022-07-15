package com.kwad.sdk.core.diskcache.a;

import android.content.Context;
import com.kwad.sdk.utils.aj;
import java.io.File;
/* loaded from: classes5.dex */
public final class b {
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

        public final a a(int i) {
            this.b = 1;
            return this;
        }

        public final a a(long j) {
            this.c = 200L;
            return this;
        }

        public final a a(File file) {
            aj.a(file, "directory is not allow null");
            this.d = file;
            return this;
        }

        public final b a() {
            b bVar = new b((byte) 0);
            bVar.a = this.a;
            bVar.b = this.b;
            bVar.c = this.c;
            bVar.d = this.d;
            return bVar;
        }
    }

    public b() {
    }

    public /* synthetic */ b(byte b) {
        this();
    }
}
