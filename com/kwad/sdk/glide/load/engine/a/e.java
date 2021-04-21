package com.kwad.sdk.glide.load.engine.a;

import android.util.Log;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.kwad.sdk.glide.a.a;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public class e implements a {

    /* renamed from: b  reason: collision with root package name */
    public final File f35810b;

    /* renamed from: c  reason: collision with root package name */
    public final long f35811c;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.a.a f35813e;

    /* renamed from: d  reason: collision with root package name */
    public final c f35812d = new c();

    /* renamed from: a  reason: collision with root package name */
    public final j f35809a = new j();

    @Deprecated
    public e(File file, long j) {
        this.f35810b = file;
        this.f35811c = j;
    }

    private synchronized com.kwad.sdk.glide.a.a a() {
        if (this.f35813e == null) {
            this.f35813e = com.kwad.sdk.glide.a.a.a(this.f35810b, 1, 1, this.f35811c);
        }
        return this.f35813e;
    }

    public static a a(File file, long j) {
        return new e(file, j);
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a
    public File a(com.kwad.sdk.glide.load.c cVar) {
        String a2 = this.f35809a.a(cVar);
        if (Log.isLoggable(DiskLruCacheWrapper.TAG, 2)) {
            Log.v(DiskLruCacheWrapper.TAG, "Get: Obtained: " + a2 + " for for Key: " + cVar);
        }
        try {
            a.d a3 = a().a(a2);
            if (a3 != null) {
                return a3.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (Log.isLoggable(DiskLruCacheWrapper.TAG, 5)) {
                Log.w(DiskLruCacheWrapper.TAG, "Unable to get from disk cache", e2);
                return null;
            }
            return null;
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a
    public void a(com.kwad.sdk.glide.load.c cVar, a.b bVar) {
        com.kwad.sdk.glide.a.a a2;
        String a3 = this.f35809a.a(cVar);
        this.f35812d.a(a3);
        try {
            if (Log.isLoggable(DiskLruCacheWrapper.TAG, 2)) {
                Log.v(DiskLruCacheWrapper.TAG, "Put: Obtained: " + a3 + " for for Key: " + cVar);
            }
            try {
                a2 = a();
            } catch (IOException e2) {
                if (Log.isLoggable(DiskLruCacheWrapper.TAG, 5)) {
                    Log.w(DiskLruCacheWrapper.TAG, "Unable to put to disk cache", e2);
                }
            }
            if (a2.a(a3) != null) {
                return;
            }
            a.b b2 = a2.b(a3);
            if (b2 == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + a3);
            }
            try {
                if (bVar.a(b2.a(0))) {
                    b2.a();
                }
                b2.c();
            } catch (Throwable th) {
                b2.c();
                throw th;
            }
        } finally {
            this.f35812d.b(a3);
        }
    }
}
