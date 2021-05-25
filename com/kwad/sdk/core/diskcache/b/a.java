package com.kwad.sdk.core.diskcache.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.diskcache.b.c;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f32089a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.diskcache.a.a f32090b;

    /* renamed from: c  reason: collision with root package name */
    public Context f32091c;

    public static a a() {
        if (f32089a == null) {
            synchronized (a.class) {
                if (f32089a == null) {
                    f32089a = new a();
                }
            }
        }
        return f32089a;
    }

    private boolean d() {
        if (this.f32090b == null) {
            com.kwad.sdk.core.d.a.e("DiskCache", "diskLruCache should be init before use");
            return true;
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public void a(b bVar) {
        if (this.f32090b != null) {
            return;
        }
        try {
            this.f32091c = bVar.f32092a;
            if (!bVar.f32095d.exists()) {
                bVar.f32095d.mkdirs();
            }
            this.f32090b = com.kwad.sdk.core.diskcache.a.a.a(bVar.f32095d, bVar.f32093b, 1, bVar.f32094c * 1024 * 1024);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public void a(String str) {
        if (d() || TextUtils.isEmpty(str)) {
            return;
        }
        c.a(this.f32090b, str, d.a(str));
    }

    public boolean a(String str, c.a aVar) {
        File b2;
        return (d() || TextUtils.isEmpty(str) || !c.a(this.f32090b, str, d.a(str), aVar) || (b2 = b(str)) == null || !b2.exists()) ? false : true;
    }

    public boolean a(String str, @NonNull String str2, c.a aVar) {
        File b2;
        return (d() || TextUtils.isEmpty(str) || !c.a(this.f32090b, str, d.a(str2), aVar) || (b2 = b(str2)) == null || !b2.exists()) ? false : true;
    }

    public File b() {
        return this.f32090b.a();
    }

    @Nullable
    public File b(String str) {
        if (d() || TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(b(), d.a(str));
    }

    public void c() {
        try {
            this.f32090b.c();
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public boolean c(String str) {
        try {
            d.a(str, "cacheKey is not allowed empty");
            return this.f32090b.b(d.a(str));
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return false;
        }
    }
}
