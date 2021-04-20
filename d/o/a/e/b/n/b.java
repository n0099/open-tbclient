package d.o.a.e.b.n;

import android.net.http.Headers;
import android.text.TextUtils;
import com.baidu.searchbox.bddownload.core.Util;
import d.o.a.e.b.l.e;
import d.o.a.e.b.o.i;
import java.io.IOException;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f68192a;

    /* renamed from: b  reason: collision with root package name */
    public final i f68193b;

    /* renamed from: c  reason: collision with root package name */
    public final int f68194c;

    /* renamed from: d  reason: collision with root package name */
    public long f68195d;

    /* renamed from: e  reason: collision with root package name */
    public long f68196e;

    public b(String str, i iVar) throws IOException {
        this.f68192a = str;
        this.f68194c = iVar.b();
        this.f68193b = iVar;
    }

    public boolean a() {
        return e.o0(this.f68194c);
    }

    public boolean b() {
        return e.F(this.f68194c, this.f68193b.a(Util.ACCEPT_RANGES));
    }

    public String c() {
        return this.f68193b.a(Util.ETAG);
    }

    public String d() {
        return this.f68193b.a("Content-Type");
    }

    public String e() {
        return this.f68193b.a("Content-Range");
    }

    public String f() {
        String W = e.W(this.f68193b, Headers.LAST_MODIFIED);
        return TextUtils.isEmpty(W) ? e.W(this.f68193b, "Last-Modified") : W;
    }

    public String g() {
        return e.W(this.f68193b, "Cache-Control");
    }

    public long h() {
        if (this.f68195d <= 0) {
            this.f68195d = e.d(this.f68193b);
        }
        return this.f68195d;
    }

    public boolean i() {
        if (d.o.a.e.b.l.a.a(8)) {
            return e.s0(this.f68193b);
        }
        return e.c0(h());
    }

    public long j() {
        if (this.f68196e <= 0) {
            if (!i()) {
                String a2 = this.f68193b.a("Content-Range");
                if (!TextUtils.isEmpty(a2)) {
                    this.f68196e = e.T(a2);
                }
            } else {
                this.f68196e = -1L;
            }
        }
        return this.f68196e;
    }

    public long k() {
        return e.N0(g());
    }
}
