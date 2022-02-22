package com.ss.android.socialbase.downloader.model;

import android.net.http.Headers;
import android.text.TextUtils;
import com.baidu.searchbox.bddownload.core.Util;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;
/* loaded from: classes4.dex */
public class d {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final g f60441b;

    /* renamed from: c  reason: collision with root package name */
    public final int f60442c;

    /* renamed from: d  reason: collision with root package name */
    public long f60443d;

    /* renamed from: e  reason: collision with root package name */
    public long f60444e;

    public d(String str, g gVar) throws IOException {
        this.a = str;
        this.f60442c = gVar.b();
        this.f60441b = gVar;
    }

    public boolean a() {
        return f.c(this.f60442c);
    }

    public boolean b() {
        return f.a(this.f60442c, this.f60441b.a(Util.ACCEPT_RANGES));
    }

    public String c() {
        return this.f60441b.a(Util.ETAG);
    }

    public String d() {
        return this.f60441b.a("Content-Type");
    }

    public String e() {
        return f.b(this.f60441b, "Content-Range");
    }

    public String f() {
        String b2 = f.b(this.f60441b, Headers.LAST_MODIFIED);
        return TextUtils.isEmpty(b2) ? f.b(this.f60441b, "Last-Modified") : b2;
    }

    public String g() {
        return f.b(this.f60441b, "Cache-Control");
    }

    public long h() {
        if (this.f60443d <= 0) {
            this.f60443d = f.a(this.f60441b);
        }
        return this.f60443d;
    }

    public boolean i() {
        if (com.ss.android.socialbase.downloader.i.a.a(8)) {
            return f.c(this.f60441b);
        }
        return f.b(h());
    }

    public long j() {
        if (this.f60444e <= 0) {
            if (!i()) {
                String e2 = e();
                if (!TextUtils.isEmpty(e2)) {
                    this.f60444e = f.b(e2);
                }
            } else {
                this.f60444e = -1L;
            }
        }
        return this.f60444e;
    }

    public long k() {
        return f.i(g());
    }
}
