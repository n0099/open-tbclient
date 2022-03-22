package com.ss.android.socialbase.downloader.model;

import android.net.http.Headers;
import android.text.TextUtils;
import com.baidu.searchbox.bddownload.core.Util;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;
/* loaded from: classes7.dex */
public class d {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final g f43484b;

    /* renamed from: c  reason: collision with root package name */
    public final int f43485c;

    /* renamed from: d  reason: collision with root package name */
    public long f43486d;

    /* renamed from: e  reason: collision with root package name */
    public long f43487e;

    public d(String str, g gVar) throws IOException {
        this.a = str;
        this.f43485c = gVar.b();
        this.f43484b = gVar;
    }

    public boolean a() {
        return f.c(this.f43485c);
    }

    public boolean b() {
        return f.a(this.f43485c, this.f43484b.a(Util.ACCEPT_RANGES));
    }

    public String c() {
        return this.f43484b.a(Util.ETAG);
    }

    public String d() {
        return this.f43484b.a("Content-Type");
    }

    public String e() {
        return f.b(this.f43484b, "Content-Range");
    }

    public String f() {
        String b2 = f.b(this.f43484b, Headers.LAST_MODIFIED);
        return TextUtils.isEmpty(b2) ? f.b(this.f43484b, com.baidubce.http.Headers.LAST_MODIFIED) : b2;
    }

    public String g() {
        return f.b(this.f43484b, com.baidubce.http.Headers.CACHE_CONTROL);
    }

    public long h() {
        if (this.f43486d <= 0) {
            this.f43486d = f.a(this.f43484b);
        }
        return this.f43486d;
    }

    public boolean i() {
        if (com.ss.android.socialbase.downloader.i.a.a(8)) {
            return f.c(this.f43484b);
        }
        return f.b(h());
    }

    public long j() {
        if (this.f43487e <= 0) {
            if (!i()) {
                String e2 = e();
                if (!TextUtils.isEmpty(e2)) {
                    this.f43487e = f.b(e2);
                }
            } else {
                this.f43487e = -1L;
            }
        }
        return this.f43487e;
    }

    public long k() {
        return f.i(g());
    }
}
