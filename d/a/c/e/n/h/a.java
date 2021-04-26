package d.a.c.e.n.h;

import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.n.m.j;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f39860a;
    public String o;
    public String r;
    public j v;

    /* renamed from: b  reason: collision with root package name */
    public StringBuffer f39861b = new StringBuffer();

    /* renamed from: c  reason: collision with root package name */
    public StringBuffer f39862c = new StringBuffer();

    /* renamed from: d  reason: collision with root package name */
    public StringBuffer f39863d = new StringBuffer();

    /* renamed from: e  reason: collision with root package name */
    public int f39864e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f39865f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f39866g = 0;

    /* renamed from: h  reason: collision with root package name */
    public long f39867h = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f39868i = 0;
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
        this.f39860a = str;
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

    public synchronized void a(d.a.c.e.n.a aVar) {
        if (aVar != null) {
            try {
                this.f39861b.append(aVar.toString());
                this.f39861b.append(Part.CRLF);
                this.f39864e++;
            } catch (Exception e2) {
                BdLog.e(e2);
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
            }
        }
        if (this.v != null) {
            this.v.a(this);
        }
        this.f39867h = System.currentTimeMillis();
    }

    public synchronized void b(d.a.c.e.n.a aVar) {
        if (aVar != null) {
            try {
                this.f39862c.append(aVar.toString());
                this.f39862c.append(Part.CRLF);
                this.f39865f++;
            } catch (Exception e2) {
                BdLog.e(e2);
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
            }
        }
        if (this.v != null) {
            this.v.a(this);
        }
        this.f39868i = System.currentTimeMillis();
    }

    public synchronized void c(d.a.c.e.n.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.f() != null) {
                    this.f39863d.append(aVar.f().c().toString());
                    this.f39863d.append(Part.CRLF);
                    this.f39866g++;
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
        this.f39861b = new StringBuffer();
        this.f39864e = 0;
        this.l = 0L;
    }

    public synchronized void e() {
        this.f39862c = new StringBuffer();
        this.f39865f = 0;
        this.m = 0L;
    }

    public synchronized void f() {
        this.f39863d = new StringBuffer();
        this.f39866g = 0;
        this.n = 0L;
    }

    public String h() {
        return this.o;
    }

    public long i() {
        return this.f39867h;
    }

    public long j() {
        return this.f39868i;
    }

    public long k() {
        return this.j;
    }

    public int l() {
        return this.f39866g;
    }

    public int m() {
        return this.f39864e;
    }

    public int n() {
        return this.f39865f;
    }

    public String o() {
        return this.f39860a;
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
        return this.f39861b;
    }

    public StringBuffer y() {
        return this.f39862c;
    }

    public StringBuffer z() {
        return this.f39863d;
    }
}
