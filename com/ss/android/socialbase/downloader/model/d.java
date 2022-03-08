package com.ss.android.socialbase.downloader.model;

import android.net.http.Headers;
import android.text.TextUtils;
import com.baidu.searchbox.bddownload.core.Util;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;
/* loaded from: classes8.dex */
public class d {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final g f58791b;

    /* renamed from: c  reason: collision with root package name */
    public final int f58792c;

    /* renamed from: d  reason: collision with root package name */
    public long f58793d;

    /* renamed from: e  reason: collision with root package name */
    public long f58794e;

    public d(String str, g gVar) throws IOException {
        this.a = str;
        this.f58792c = gVar.b();
        this.f58791b = gVar;
    }

    public boolean a() {
        return f.c(this.f58792c);
    }

    public boolean b() {
        return f.a(this.f58792c, this.f58791b.a(Util.ACCEPT_RANGES));
    }

    public String c() {
        return this.f58791b.a(Util.ETAG);
    }

    public String d() {
        return this.f58791b.a("Content-Type");
    }

    public String e() {
        return f.b(this.f58791b, "Content-Range");
    }

    public String f() {
        String b2 = f.b(this.f58791b, Headers.LAST_MODIFIED);
        return TextUtils.isEmpty(b2) ? f.b(this.f58791b, "Last-Modified") : b2;
    }

    public String g() {
        return f.b(this.f58791b, "Cache-Control");
    }

    public long h() {
        if (this.f58793d <= 0) {
            this.f58793d = f.a(this.f58791b);
        }
        return this.f58793d;
    }

    public boolean i() {
        if (com.ss.android.socialbase.downloader.i.a.a(8)) {
            return f.c(this.f58791b);
        }
        return f.b(h());
    }

    public long j() {
        if (this.f58794e <= 0) {
            if (!i()) {
                String e2 = e();
                if (!TextUtils.isEmpty(e2)) {
                    this.f58794e = f.b(e2);
                }
            } else {
                this.f58794e = -1L;
            }
        }
        return this.f58794e;
    }

    public long k() {
        return f.i(g());
    }
}
