package d.c.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tieba.tblauncher.MainTabActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
/* loaded from: classes5.dex */
public class e2 {
    public static long n;
    public static b o;

    /* renamed from: a  reason: collision with root package name */
    public final i f64975a;

    /* renamed from: b  reason: collision with root package name */
    public final j f64976b;

    /* renamed from: c  reason: collision with root package name */
    public h0 f64977c;

    /* renamed from: d  reason: collision with root package name */
    public h0 f64978d;

    /* renamed from: e  reason: collision with root package name */
    public String f64979e;

    /* renamed from: f  reason: collision with root package name */
    public long f64980f;

    /* renamed from: g  reason: collision with root package name */
    public int f64981g;

    /* renamed from: h  reason: collision with root package name */
    public long f64982h = -1;
    public volatile boolean i;
    public long j;
    public int k;
    public String l;
    public f0 m;

    /* loaded from: classes5.dex */
    public static class b extends j0 {
        public b() {
        }
    }

    public e2(j jVar, i iVar) {
        this.f64976b = jVar;
        this.f64975a = iVar;
    }

    public static long a(i iVar) {
        long j = n + 1;
        n = j;
        if (j % 1000 == 0) {
            iVar.r(j + 1000);
        }
        return n;
    }

    public static boolean e(z zVar) {
        if (zVar instanceof h0) {
            return ((h0) zVar).p();
        }
        return false;
    }

    public static b j() {
        if (o == null) {
            o = new b();
        }
        o.f65112e = System.currentTimeMillis();
        return o;
    }

    public synchronized Bundle b(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.f64975a.B() && i() && j - this.f64980f > j2) {
            bundle = new Bundle();
            bundle.putInt("session_no", this.k);
            int i = this.f64981g + 1;
            this.f64981g = i;
            bundle.putInt("send_times", i);
            bundle.putLong("current_duration", (j - this.f64980f) / 1000);
            bundle.putString("session_start_time", z.c(this.f64982h));
            this.f64980f = j;
        }
        return bundle;
    }

    public synchronized f0 c() {
        return this.m;
    }

    public final synchronized void d(z zVar, ArrayList<z> arrayList, boolean z) {
        long j = zVar instanceof b ? -1L : zVar.f65112e;
        this.f64979e = UUID.randomUUID().toString();
        n = this.f64975a.b();
        this.f64982h = j;
        this.i = z;
        this.j = 0L;
        if (r0.f65064b) {
            r0.a("startSession, " + this.f64979e + ", hadUi:" + z + " data:" + zVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            if (TextUtils.isEmpty(this.l)) {
                this.l = this.f64975a.w();
                this.k = this.f64975a.y();
            }
            if (!str.equals(this.l)) {
                this.l = str;
                this.k = 1;
            } else {
                this.k++;
            }
            this.f64975a.s(str, this.k);
            this.f64981g = 0;
        }
        if (j != -1) {
            f0 f0Var = new f0();
            f0Var.f65114g = this.f64979e;
            f0Var.f65113f = a(this.f64975a);
            f0Var.f65112e = this.f64982h;
            f0Var.n = this.f64976b.m();
            f0Var.m = this.f64976b.l();
            if (this.f64975a.R()) {
                f0Var.i = d.c.b.a.c();
                f0Var.j = d.c.b.a.d();
            }
            arrayList.add(f0Var);
            this.m = f0Var;
            if (r0.f65064b) {
                r0.a("gen launch, " + f0Var.f65114g + ", hadUi:" + z, null);
            }
        }
    }

    public boolean f(z zVar, ArrayList<z> arrayList) {
        boolean z = zVar instanceof h0;
        boolean e2 = e(zVar);
        boolean z2 = true;
        if (this.f64982h == -1) {
            d(zVar, arrayList, e(zVar));
        } else if (!this.i && e2) {
            d(zVar, arrayList, true);
        } else {
            long j = this.j;
            if (j != 0 && zVar.f65112e > j + this.f64975a.T()) {
                d(zVar, arrayList, e2);
            } else if (this.f64982h > zVar.f65112e + MainTabActivity.SERVICE_BETWEEN_TIME) {
                d(zVar, arrayList, e2);
            } else {
                z2 = false;
            }
        }
        if (z) {
            h0 h0Var = (h0) zVar;
            if (h0Var.p()) {
                this.f64980f = zVar.f65112e;
                this.j = 0L;
                arrayList.add(zVar);
                if (TextUtils.isEmpty(h0Var.n)) {
                    h0 h0Var2 = this.f64978d;
                    if (h0Var2 != null && (h0Var.f65112e - h0Var2.f65112e) - h0Var2.m < 500) {
                        h0Var.n = h0Var2.o;
                    } else {
                        h0 h0Var3 = this.f64977c;
                        if (h0Var3 != null && (h0Var.f65112e - h0Var3.f65112e) - h0Var3.m < 500) {
                            h0Var.n = h0Var3.o;
                        }
                    }
                }
            } else {
                Bundle b2 = b(zVar.f65112e, 0L);
                if (b2 != null) {
                    d.c.b.a.q("play_session", b2);
                }
                this.f64980f = 0L;
                this.j = h0Var.f65112e;
                arrayList.add(zVar);
                if (h0Var.q()) {
                    this.f64977c = h0Var;
                } else {
                    this.f64978d = h0Var;
                    this.f64977c = null;
                }
            }
        } else if (!(zVar instanceof b)) {
            arrayList.add(zVar);
        }
        g(zVar);
        return z2;
    }

    public void g(z zVar) {
        if (zVar != null) {
            zVar.f65115h = this.f64976b.q();
            zVar.f65114g = this.f64979e;
            zVar.f65113f = a(this.f64975a);
            if (this.f64975a.R()) {
                zVar.i = d.c.b.a.c();
                zVar.j = d.c.b.a.d();
            }
        }
    }

    public boolean h() {
        return this.i;
    }

    public boolean i() {
        return h() && this.j == 0;
    }
}
