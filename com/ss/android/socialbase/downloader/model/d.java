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
    public final g f62591b;

    /* renamed from: c  reason: collision with root package name */
    public final int f62592c;

    /* renamed from: d  reason: collision with root package name */
    public long f62593d;

    /* renamed from: e  reason: collision with root package name */
    public long f62594e;

    public d(String str, g gVar) throws IOException {
        this.a = str;
        this.f62592c = gVar.b();
        this.f62591b = gVar;
    }

    public boolean a() {
        return f.c(this.f62592c);
    }

    public boolean b() {
        return f.a(this.f62592c, this.f62591b.a(Util.ACCEPT_RANGES));
    }

    public String c() {
        return this.f62591b.a(Util.ETAG);
    }

    public String d() {
        return this.f62591b.a("Content-Type");
    }

    public String e() {
        return f.b(this.f62591b, "Content-Range");
    }

    public String f() {
        String b2 = f.b(this.f62591b, Headers.LAST_MODIFIED);
        return TextUtils.isEmpty(b2) ? f.b(this.f62591b, "Last-Modified") : b2;
    }

    public String g() {
        return f.b(this.f62591b, "Cache-Control");
    }

    public long h() {
        if (this.f62593d <= 0) {
            this.f62593d = f.a(this.f62591b);
        }
        return this.f62593d;
    }

    public boolean i() {
        if (com.ss.android.socialbase.downloader.i.a.a(8)) {
            return f.c(this.f62591b);
        }
        return f.b(h());
    }

    public long j() {
        if (this.f62594e <= 0) {
            if (!i()) {
                String e2 = e();
                if (!TextUtils.isEmpty(e2)) {
                    this.f62594e = f.b(e2);
                }
            } else {
                this.f62594e = -1L;
            }
        }
        return this.f62594e;
    }

    public long k() {
        return f.i(g());
    }
}
