package com.kwad.sdk.core.diskcache.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.diskcache.b.c;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f34225a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.diskcache.a.a f34226b;

    /* renamed from: c  reason: collision with root package name */
    public Context f34227c;

    public static a a() {
        if (f34225a == null) {
            synchronized (a.class) {
                if (f34225a == null) {
                    f34225a = new a();
                }
            }
        }
        return f34225a;
    }

    private boolean d() {
        if (this.f34226b == null) {
            com.kwad.sdk.core.d.a.d("DiskCache", "diskLruCache should be init before use");
            return true;
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public void a(b bVar) {
        if (this.f34226b != null) {
            return;
        }
        try {
            this.f34227c = bVar.f34228a;
            if (!bVar.f34231d.exists()) {
                bVar.f34231d.mkdirs();
            }
            this.f34226b = com.kwad.sdk.core.diskcache.a.a.a(bVar.f34231d, bVar.f34229b, 1, bVar.f34230c * 1024 * 1024);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public void a(String str) {
        if (d() || TextUtils.isEmpty(str)) {
            return;
        }
        c.a(this.f34226b, str, d.a(str));
    }

    public boolean a(String str, c.a aVar) {
        File b2;
        return (d() || TextUtils.isEmpty(str) || !c.a(this.f34226b, str, d.a(str), aVar) || (b2 = b(str)) == null || !b2.exists()) ? false : true;
    }

    public boolean a(String str, @NonNull String str2, c.a aVar) {
        File b2;
        return (d() || TextUtils.isEmpty(str) || !c.a(this.f34226b, str, d.a(str2), aVar) || (b2 = b(str2)) == null || !b2.exists()) ? false : true;
    }

    public File b() {
        return this.f34226b.a();
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
            this.f34226b.c();
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public boolean c(String str) {
        try {
            d.a(str, "cacheKey is not allowed empty");
            return this.f34226b.b(d.a(str));
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return false;
        }
    }
}
