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
    public final String f67199a;

    /* renamed from: b  reason: collision with root package name */
    public final i f67200b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67201c;

    /* renamed from: d  reason: collision with root package name */
    public long f67202d;

    /* renamed from: e  reason: collision with root package name */
    public long f67203e;

    public b(String str, i iVar) throws IOException {
        this.f67199a = str;
        this.f67201c = iVar.b();
        this.f67200b = iVar;
    }

    public boolean a() {
        return e.o0(this.f67201c);
    }

    public boolean b() {
        return e.F(this.f67201c, this.f67200b.a(Util.ACCEPT_RANGES));
    }

    public String c() {
        return this.f67200b.a(Util.ETAG);
    }

    public String d() {
        return this.f67200b.a("Content-Type");
    }

    public String e() {
        return this.f67200b.a("Content-Range");
    }

    public String f() {
        String W = e.W(this.f67200b, Headers.LAST_MODIFIED);
        return TextUtils.isEmpty(W) ? e.W(this.f67200b, "Last-Modified") : W;
    }

    public String g() {
        return e.W(this.f67200b, "Cache-Control");
    }

    public long h() {
        if (this.f67202d <= 0) {
            this.f67202d = e.d(this.f67200b);
        }
        return this.f67202d;
    }

    public boolean i() {
        if (d.o.a.e.b.l.a.a(8)) {
            return e.s0(this.f67200b);
        }
        return e.c0(h());
    }

    public long j() {
        if (this.f67203e <= 0) {
            if (!i()) {
                String a2 = this.f67200b.a("Content-Range");
                if (!TextUtils.isEmpty(a2)) {
                    this.f67203e = e.T(a2);
                }
            } else {
                this.f67203e = -1L;
            }
        }
        return this.f67203e;
    }

    public long k() {
        return e.N0(g());
    }
}
