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
    public final String f66715a;

    /* renamed from: b  reason: collision with root package name */
    public final i f66716b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66717c;

    /* renamed from: d  reason: collision with root package name */
    public long f66718d;

    /* renamed from: e  reason: collision with root package name */
    public long f66719e;

    public b(String str, i iVar) throws IOException {
        this.f66715a = str;
        this.f66717c = iVar.b();
        this.f66716b = iVar;
    }

    public boolean a() {
        return e.o0(this.f66717c);
    }

    public boolean b() {
        return e.F(this.f66717c, this.f66716b.a(Util.ACCEPT_RANGES));
    }

    public String c() {
        return this.f66716b.a(Util.ETAG);
    }

    public String d() {
        return this.f66716b.a("Content-Type");
    }

    public String e() {
        return this.f66716b.a("Content-Range");
    }

    public String f() {
        String W = e.W(this.f66716b, Headers.LAST_MODIFIED);
        return TextUtils.isEmpty(W) ? e.W(this.f66716b, "Last-Modified") : W;
    }

    public String g() {
        return e.W(this.f66716b, "Cache-Control");
    }

    public long h() {
        if (this.f66718d <= 0) {
            this.f66718d = e.d(this.f66716b);
        }
        return this.f66718d;
    }

    public boolean i() {
        if (d.o.a.e.b.l.a.a(8)) {
            return e.s0(this.f66716b);
        }
        return e.c0(h());
    }

    public long j() {
        if (this.f66719e <= 0) {
            if (!i()) {
                String a2 = this.f66716b.a("Content-Range");
                if (!TextUtils.isEmpty(a2)) {
                    this.f66719e = e.T(a2);
                }
            } else {
                this.f66719e = -1L;
            }
        }
        return this.f66719e;
    }

    public long k() {
        return e.N0(g());
    }
}
