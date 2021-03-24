package d.b.b.e.n.h;

import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.n.m.j;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f41917a;
    public String o;
    public String r;
    public j v;

    /* renamed from: b  reason: collision with root package name */
    public StringBuffer f41918b = new StringBuffer();

    /* renamed from: c  reason: collision with root package name */
    public StringBuffer f41919c = new StringBuffer();

    /* renamed from: d  reason: collision with root package name */
    public StringBuffer f41920d = new StringBuffer();

    /* renamed from: e  reason: collision with root package name */
    public int f41921e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f41922f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f41923g = 0;

    /* renamed from: h  reason: collision with root package name */
    public long f41924h = 0;
    public long i = 0;
    public long j = 0;
    public long k = 0;
    public long l = 0;
    public long m = 0;
    public long n = 0;
    public boolean p = false;
    public boolean q = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;

    public a(j jVar) {
        this.v = jVar;
    }

    public static String g(String str) {
        return ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) ? "error" : str;
    }

    public boolean A() {
        return this.s;
    }

    public boolean B() {
        return this.u;
    }

    public boolean C() {
        return this.q;
    }

    public boolean D() {
        return this.t;
    }

    public boolean E() {
        return this.p;
    }

    public void F(long j) {
        this.n = j;
    }

    public void G(long j) {
        this.l = j;
    }

    public void H(long j) {
        this.m = j;
    }

    public void I(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f41917a = str;
    }

    public void J(boolean z) {
        this.u = z;
    }

    public void K(boolean z) {
        this.t = z;
    }

    public void L(long j) {
        this.k = j;
    }

    public synchronized void a(d.b.b.e.n.a aVar) {
        if (aVar != null) {
            try {
                this.f41918b.append(aVar.toString());
                this.f41918b.append(Part.CRLF);
                this.f41921e++;
            } catch (Exception e2) {
                BdLog.e(e2);
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
            }
        }
        if (this.v != null) {
            this.v.a(this);
        }
        this.f41924h = System.currentTimeMillis();
    }

    public synchronized void b(d.b.b.e.n.a aVar) {
        if (aVar != null) {
            try {
                this.f41919c.append(aVar.toString());
                this.f41919c.append(Part.CRLF);
                this.f41922f++;
            } catch (Exception e2) {
                BdLog.e(e2);
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
            }
        }
        if (this.v != null) {
            this.v.a(this);
        }
        this.i = System.currentTimeMillis();
    }

    public synchronized void c(d.b.b.e.n.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.f() != null) {
                    this.f41920d.append(aVar.f().c().toString());
                    this.f41920d.append(Part.CRLF);
                    this.f41923g++;
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
            }
        }
        if (this.v != null) {
            this.v.a(this);
        }
        this.j = System.currentTimeMillis();
    }

    public synchronized void d() {
        this.f41918b = new StringBuffer();
        this.f41921e = 0;
        this.l = 0L;
    }

    public synchronized void e() {
        this.f41919c = new StringBuffer();
        this.f41922f = 0;
        this.m = 0L;
    }

    public synchronized void f() {
        this.f41920d = new StringBuffer();
        this.f41923g = 0;
        this.n = 0L;
    }

    public String h() {
        return this.o;
    }

    public long i() {
        return this.f41924h;
    }

    public long j() {
        return this.i;
    }

    public long k() {
        return this.j;
    }

    public int l() {
        return this.f41923g;
    }

    public int m() {
        return this.f41921e;
    }

    public int n() {
        return this.f41922f;
    }

    public String o() {
        return this.f41917a;
    }

    public String p() {
        return "omp";
    }

    public String q() {
        return "track";
    }

    public String r() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.o);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public String s() {
        if (TextUtils.isEmpty(this.r)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.o);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.r = sb.toString();
        }
        return this.r;
    }

    public long t() {
        return this.l;
    }

    public long u() {
        return this.m;
    }

    public long v() {
        return this.n;
    }

    public long w() {
        return this.k;
    }

    public StringBuffer x() {
        return this.f41918b;
    }

    public StringBuffer y() {
        return this.f41919c;
    }

    public StringBuffer z() {
        return this.f41920d;
    }
}
