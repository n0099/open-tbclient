package d.b.b;

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
    public final i f64271a;

    /* renamed from: b  reason: collision with root package name */
    public final j f64272b;

    /* renamed from: c  reason: collision with root package name */
    public h0 f64273c;

    /* renamed from: d  reason: collision with root package name */
    public h0 f64274d;

    /* renamed from: e  reason: collision with root package name */
    public String f64275e;

    /* renamed from: f  reason: collision with root package name */
    public long f64276f;

    /* renamed from: g  reason: collision with root package name */
    public int f64277g;

    /* renamed from: h  reason: collision with root package name */
    public long f64278h = -1;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f64279i;
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
        this.f64272b = jVar;
        this.f64271a = iVar;
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
        o.f64413e = System.currentTimeMillis();
        return o;
    }

    public synchronized Bundle b(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.f64271a.B() && i() && j - this.f64276f > j2) {
            bundle = new Bundle();
            bundle.putInt("session_no", this.k);
            int i2 = this.f64277g + 1;
            this.f64277g = i2;
            bundle.putInt("send_times", i2);
            bundle.putLong("current_duration", (j - this.f64276f) / 1000);
            bundle.putString("session_start_time", z.c(this.f64278h));
            this.f64276f = j;
        }
        return bundle;
    }

    public synchronized f0 c() {
        return this.m;
    }

    public final synchronized void d(z zVar, ArrayList<z> arrayList, boolean z) {
        long j = zVar instanceof b ? -1L : zVar.f64413e;
        this.f64275e = UUID.randomUUID().toString();
        n = this.f64271a.b();
        this.f64278h = j;
        this.f64279i = z;
        this.j = 0L;
        if (r0.f64363b) {
            r0.a("startSession, " + this.f64275e + ", hadUi:" + z + " data:" + zVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            if (TextUtils.isEmpty(this.l)) {
                this.l = this.f64271a.w();
                this.k = this.f64271a.y();
            }
            if (!str.equals(this.l)) {
                this.l = str;
                this.k = 1;
            } else {
                this.k++;
            }
            this.f64271a.s(str, this.k);
            this.f64277g = 0;
        }
        if (j != -1) {
            f0 f0Var = new f0();
            f0Var.f64415g = this.f64275e;
            f0Var.f64414f = a(this.f64271a);
            f0Var.f64413e = this.f64278h;
            f0Var.n = this.f64272b.m();
            f0Var.m = this.f64272b.l();
            if (this.f64271a.R()) {
                f0Var.f64417i = d.b.b.a.c();
                f0Var.j = d.b.b.a.d();
            }
            arrayList.add(f0Var);
            this.m = f0Var;
            if (r0.f64363b) {
                r0.a("gen launch, " + f0Var.f64415g + ", hadUi:" + z, null);
            }
        }
    }

    public boolean f(z zVar, ArrayList<z> arrayList) {
        boolean z = zVar instanceof h0;
        boolean e2 = e(zVar);
        boolean z2 = true;
        if (this.f64278h == -1) {
            d(zVar, arrayList, e(zVar));
        } else if (!this.f64279i && e2) {
            d(zVar, arrayList, true);
        } else {
            long j = this.j;
            if (j != 0 && zVar.f64413e > j + this.f64271a.T()) {
                d(zVar, arrayList, e2);
            } else if (this.f64278h > zVar.f64413e + MainTabActivity.SERVICE_BETWEEN_TIME) {
                d(zVar, arrayList, e2);
            } else {
                z2 = false;
            }
        }
        if (z) {
            h0 h0Var = (h0) zVar;
            if (h0Var.p()) {
                this.f64276f = zVar.f64413e;
                this.j = 0L;
                arrayList.add(zVar);
                if (TextUtils.isEmpty(h0Var.n)) {
                    h0 h0Var2 = this.f64274d;
                    if (h0Var2 != null && (h0Var.f64413e - h0Var2.f64413e) - h0Var2.m < 500) {
                        h0Var.n = h0Var2.o;
                    } else {
                        h0 h0Var3 = this.f64273c;
                        if (h0Var3 != null && (h0Var.f64413e - h0Var3.f64413e) - h0Var3.m < 500) {
                            h0Var.n = h0Var3.o;
                        }
                    }
                }
            } else {
                Bundle b2 = b(zVar.f64413e, 0L);
                if (b2 != null) {
                    d.b.b.a.q("play_session", b2);
                }
                this.f64276f = 0L;
                this.j = h0Var.f64413e;
                arrayList.add(zVar);
                if (h0Var.q()) {
                    this.f64273c = h0Var;
                } else {
                    this.f64274d = h0Var;
                    this.f64273c = null;
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
            zVar.f64416h = this.f64272b.q();
            zVar.f64415g = this.f64275e;
            zVar.f64414f = a(this.f64271a);
            if (this.f64271a.R()) {
                zVar.f64417i = d.b.b.a.c();
                zVar.j = d.b.b.a.d();
            }
        }
    }

    public boolean h() {
        return this.f64279i;
    }

    public boolean i() {
        return h() && this.j == 0;
    }
}
