package d.p.a.e.b.n;

import android.net.http.Headers;
import android.text.TextUtils;
import com.baidu.searchbox.bddownload.core.Util;
import d.p.a.e.b.l.e;
import d.p.a.e.b.o.i;
import java.io.IOException;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f68339a;

    /* renamed from: b  reason: collision with root package name */
    public final i f68340b;

    /* renamed from: c  reason: collision with root package name */
    public final int f68341c;

    /* renamed from: d  reason: collision with root package name */
    public long f68342d;

    /* renamed from: e  reason: collision with root package name */
    public long f68343e;

    public b(String str, i iVar) throws IOException {
        this.f68339a = str;
        this.f68341c = iVar.b();
        this.f68340b = iVar;
    }

    public boolean a() {
        return e.o0(this.f68341c);
    }

    public boolean b() {
        return e.F(this.f68341c, this.f68340b.a(Util.ACCEPT_RANGES));
    }

    public String c() {
        return this.f68340b.a(Util.ETAG);
    }

    public String d() {
        return this.f68340b.a("Content-Type");
    }

    public String e() {
        return this.f68340b.a("Content-Range");
    }

    public String f() {
        String W = e.W(this.f68340b, Headers.LAST_MODIFIED);
        return TextUtils.isEmpty(W) ? e.W(this.f68340b, "Last-Modified") : W;
    }

    public String g() {
        return e.W(this.f68340b, "Cache-Control");
    }

    public long h() {
        if (this.f68342d <= 0) {
            this.f68342d = e.d(this.f68340b);
        }
        return this.f68342d;
    }

    public boolean i() {
        if (d.p.a.e.b.l.a.a(8)) {
            return e.s0(this.f68340b);
        }
        return e.c0(h());
    }

    public long j() {
        if (this.f68343e <= 0) {
            if (!i()) {
                String a2 = this.f68340b.a("Content-Range");
                if (!TextUtils.isEmpty(a2)) {
                    this.f68343e = e.T(a2);
                }
            } else {
                this.f68343e = -1L;
            }
        }
        return this.f68343e;
    }

    public long k() {
        return e.N0(g());
    }
}
