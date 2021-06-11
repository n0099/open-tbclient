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
    public final String f71230a;

    /* renamed from: b  reason: collision with root package name */
    public final i f71231b;

    /* renamed from: c  reason: collision with root package name */
    public final int f71232c;

    /* renamed from: d  reason: collision with root package name */
    public long f71233d;

    /* renamed from: e  reason: collision with root package name */
    public long f71234e;

    public b(String str, i iVar) throws IOException {
        this.f71230a = str;
        this.f71232c = iVar.b();
        this.f71231b = iVar;
    }

    public boolean a() {
        return e.o0(this.f71232c);
    }

    public boolean b() {
        return e.F(this.f71232c, this.f71231b.a(Util.ACCEPT_RANGES));
    }

    public String c() {
        return this.f71231b.a(Util.ETAG);
    }

    public String d() {
        return this.f71231b.a("Content-Type");
    }

    public String e() {
        return this.f71231b.a("Content-Range");
    }

    public String f() {
        String W = e.W(this.f71231b, Headers.LAST_MODIFIED);
        return TextUtils.isEmpty(W) ? e.W(this.f71231b, "Last-Modified") : W;
    }

    public String g() {
        return e.W(this.f71231b, "Cache-Control");
    }

    public long h() {
        if (this.f71233d <= 0) {
            this.f71233d = e.d(this.f71231b);
        }
        return this.f71233d;
    }

    public boolean i() {
        if (d.o.a.e.b.l.a.a(8)) {
            return e.s0(this.f71231b);
        }
        return e.c0(h());
    }

    public long j() {
        if (this.f71234e <= 0) {
            if (!i()) {
                String a2 = this.f71231b.a("Content-Range");
                if (!TextUtils.isEmpty(a2)) {
                    this.f71234e = e.T(a2);
                }
            } else {
                this.f71234e = -1L;
            }
        }
        return this.f71234e;
    }

    public long k() {
        return e.N0(g());
    }
}
