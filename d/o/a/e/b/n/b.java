package d.o.a.e.b.n;

import android.net.http.Headers;
import android.text.TextUtils;
import com.baidu.searchbox.bddownload.core.Util;
import d.o.a.e.b.l.e;
import d.o.a.e.b.o.i;
import java.io.IOException;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f67401a;

    /* renamed from: b  reason: collision with root package name */
    public final i f67402b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67403c;

    /* renamed from: d  reason: collision with root package name */
    public long f67404d;

    /* renamed from: e  reason: collision with root package name */
    public long f67405e;

    public b(String str, i iVar) throws IOException {
        this.f67401a = str;
        this.f67403c = iVar.b();
        this.f67402b = iVar;
    }

    public boolean a() {
        return e.o0(this.f67403c);
    }

    public boolean b() {
        return e.F(this.f67403c, this.f67402b.a(Util.ACCEPT_RANGES));
    }

    public String c() {
        return this.f67402b.a(Util.ETAG);
    }

    public String d() {
        return this.f67402b.a("Content-Type");
    }

    public String e() {
        return this.f67402b.a("Content-Range");
    }

    public String f() {
        String W = e.W(this.f67402b, Headers.LAST_MODIFIED);
        return TextUtils.isEmpty(W) ? e.W(this.f67402b, "Last-Modified") : W;
    }

    public String g() {
        return e.W(this.f67402b, "Cache-Control");
    }

    public long h() {
        if (this.f67404d <= 0) {
            this.f67404d = e.d(this.f67402b);
        }
        return this.f67404d;
    }

    public boolean i() {
        if (d.o.a.e.b.l.a.a(8)) {
            return e.s0(this.f67402b);
        }
        return e.c0(h());
    }

    public long j() {
        if (this.f67405e <= 0) {
            if (!i()) {
                String a2 = this.f67402b.a("Content-Range");
                if (!TextUtils.isEmpty(a2)) {
                    this.f67405e = e.T(a2);
                }
            } else {
                this.f67405e = -1L;
            }
        }
        return this.f67405e;
    }

    public long k() {
        return e.N0(g());
    }
}
