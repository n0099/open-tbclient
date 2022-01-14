package com.kwad.sdk.core.diskcache.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.diskcache.a.c;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class a {
    public static a a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.diskcache.kwai.a f55663b;

    /* renamed from: c  reason: collision with root package name */
    public Context f55664c;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private boolean d() {
        if (this.f55663b == null) {
            com.kwad.sdk.core.d.a.e("DiskCache", "diskLruCache should be init before use");
            return true;
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public void a(b bVar) {
        if (this.f55663b != null) {
            return;
        }
        try {
            this.f55664c = bVar.a;
            if (!bVar.f55667d.exists()) {
                bVar.f55667d.mkdirs();
            }
            this.f55663b = com.kwad.sdk.core.diskcache.kwai.a.a(bVar.f55667d, bVar.f55665b, 1, bVar.f55666c * 1024 * 1024);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    public void a(String str) {
        if (d() || TextUtils.isEmpty(str)) {
            return;
        }
        c.a(this.f55663b, str, d.a(str));
    }

    public void a(String str, Object obj) {
        if (d() || obj == null) {
            return;
        }
        d.a(str, "key is not allowed empty");
        e.a(this.f55663b, d.a(str), obj);
    }

    public boolean a(String str, c.a aVar) {
        File b2;
        return (d() || TextUtils.isEmpty(str) || !c.a(this.f55663b, str, d.a(str), aVar) || (b2 = b(str)) == null || !b2.exists()) ? false : true;
    }

    public boolean a(String str, @NonNull String str2, c.a aVar) {
        File b2;
        return (d() || TextUtils.isEmpty(str) || !c.a(this.f55663b, str, d.a(str2), aVar) || (b2 = b(str2)) == null || !b2.exists()) ? false : true;
    }

    public File b() {
        return this.f55663b.a();
    }

    @Nullable
    public File b(String str) {
        if (d() || TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(b(), d.a(str));
    }

    public Object c(String str) {
        if (d()) {
            return null;
        }
        d.a(str, "key is not allowed empty");
        return e.a(this.f55663b, d.a(str));
    }

    public void c() {
        try {
            this.f55663b.c();
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public boolean d(String str) {
        try {
            d.a(str, "cacheKey is not allowed empty");
            return this.f55663b.c(d.a(str));
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return false;
        }
    }
}
