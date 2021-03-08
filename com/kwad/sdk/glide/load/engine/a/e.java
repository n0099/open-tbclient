package com.kwad.sdk.glide.load.engine.a;

import android.util.Log;
import com.kwad.sdk.glide.a.a;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e implements a {
    private final File b;
    private final long c;
    private com.kwad.sdk.glide.a.a e;
    private final c d = new c();

    /* renamed from: a  reason: collision with root package name */
    private final j f6725a = new j();

    @Deprecated
    protected e(File file, long j) {
        this.b = file;
        this.c = j;
    }

    private synchronized com.kwad.sdk.glide.a.a a() {
        if (this.e == null) {
            this.e = com.kwad.sdk.glide.a.a.a(this.b, 1, 1, this.c);
        }
        return this.e;
    }

    public static a a(File file, long j) {
        return new e(file, j);
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a
    public File a(com.kwad.sdk.glide.load.c cVar) {
        String a2 = this.f6725a.a(cVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + a2 + " for for Key: " + cVar);
        }
        try {
            a.d a3 = a().a(a2);
            if (a3 != null) {
                return a3.a(0);
            }
            return null;
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
                return null;
            }
            return null;
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a
    public void a(com.kwad.sdk.glide.load.c cVar, a.b bVar) {
        com.kwad.sdk.glide.a.a a2;
        String a3 = this.f6725a.a(cVar);
        this.d.a(a3);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + a3 + " for for Key: " + cVar);
            }
            try {
                a2 = a();
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
            if (a2.a(a3) != null) {
                return;
            }
            a.b b = a2.b(a3);
            if (b == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + a3);
            }
            try {
                if (bVar.a(b.a(0))) {
                    b.a();
                }
            } finally {
                b.c();
            }
        } finally {
            this.d.b(a3);
        }
    }
}
