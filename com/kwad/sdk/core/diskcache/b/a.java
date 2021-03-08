package com.kwad.sdk.core.diskcache.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.diskcache.b.c;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f6036a;
    private com.kwad.sdk.core.diskcache.a.a b;
    private Context c;

    private a() {
    }

    public static a a() {
        if (f6036a == null) {
            synchronized (a.class) {
                if (f6036a == null) {
                    f6036a = new a();
                }
            }
        }
        return f6036a;
    }

    private boolean d() {
        if (this.b == null) {
            com.kwad.sdk.core.d.a.d("DiskCache", "diskLruCache should be init before use");
            return true;
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public void a(b bVar) {
        if (this.b != null) {
            return;
        }
        try {
            this.c = bVar.f6037a;
            if (!bVar.d.exists()) {
                bVar.d.mkdirs();
            }
            this.b = com.kwad.sdk.core.diskcache.a.a.a(bVar.d, bVar.b, 1, bVar.c * 1024 * 1024);
        } catch (IOException e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    public void a(String str) {
        if (d() || TextUtils.isEmpty(str)) {
            return;
        }
        c.a(this.b, str, d.a(str));
    }

    public boolean a(String str, c.a aVar) {
        File b;
        return (d() || TextUtils.isEmpty(str) || !c.a(this.b, str, d.a(str), aVar) || (b = b(str)) == null || !b.exists()) ? false : true;
    }

    public boolean a(String str, @NonNull String str2, c.a aVar) {
        File b;
        return (d() || TextUtils.isEmpty(str) || !c.a(this.b, str, d.a(str2), aVar) || (b = b(str2)) == null || !b.exists()) ? false : true;
    }

    public File b() {
        return this.b.a();
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
            this.b.c();
        } catch (IOException e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    public boolean c(String str) {
        try {
            d.a(str, "cacheKey is not allowed empty");
            return this.b.b(d.a(str));
        } catch (IOException e) {
            com.kwad.sdk.core.d.a.a(e);
            return false;
        }
    }
}
