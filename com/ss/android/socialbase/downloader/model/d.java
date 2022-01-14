package com.ss.android.socialbase.downloader.model;

import android.net.http.Headers;
import android.text.TextUtils;
import com.baidu.searchbox.bddownload.core.Util;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;
/* loaded from: classes3.dex */
public class d {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final g f60229b;

    /* renamed from: c  reason: collision with root package name */
    public final int f60230c;

    /* renamed from: d  reason: collision with root package name */
    public long f60231d;

    /* renamed from: e  reason: collision with root package name */
    public long f60232e;

    public d(String str, g gVar) throws IOException {
        this.a = str;
        this.f60230c = gVar.b();
        this.f60229b = gVar;
    }

    public boolean a() {
        return f.c(this.f60230c);
    }

    public boolean b() {
        return f.a(this.f60230c, this.f60229b.a(Util.ACCEPT_RANGES));
    }

    public String c() {
        return this.f60229b.a(Util.ETAG);
    }

    public String d() {
        return this.f60229b.a("Content-Type");
    }

    public String e() {
        return f.b(this.f60229b, "Content-Range");
    }

    public String f() {
        String b2 = f.b(this.f60229b, Headers.LAST_MODIFIED);
        return TextUtils.isEmpty(b2) ? f.b(this.f60229b, "Last-Modified") : b2;
    }

    public String g() {
        return f.b(this.f60229b, "Cache-Control");
    }

    public long h() {
        if (this.f60231d <= 0) {
            this.f60231d = f.a(this.f60229b);
        }
        return this.f60231d;
    }

    public boolean i() {
        if (com.ss.android.socialbase.downloader.i.a.a(8)) {
            return f.c(this.f60229b);
        }
        return f.b(h());
    }

    public long j() {
        if (this.f60232e <= 0) {
            if (!i()) {
                String e2 = e();
                if (!TextUtils.isEmpty(e2)) {
                    this.f60232e = f.b(e2);
                }
            } else {
                this.f60232e = -1L;
            }
        }
        return this.f60232e;
    }

    public long k() {
        return f.i(g());
    }
}
