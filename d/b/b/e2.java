package d.b.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tieba.tblauncher.MainTabActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
/* loaded from: classes6.dex */
public class e2 {
    public static long n;
    public static b o;

    /* renamed from: a  reason: collision with root package name */
    public final i f68835a;

    /* renamed from: b  reason: collision with root package name */
    public final j f68836b;

    /* renamed from: c  reason: collision with root package name */
    public h0 f68837c;

    /* renamed from: d  reason: collision with root package name */
    public h0 f68838d;

    /* renamed from: e  reason: collision with root package name */
    public String f68839e;

    /* renamed from: f  reason: collision with root package name */
    public long f68840f;

    /* renamed from: g  reason: collision with root package name */
    public int f68841g;

    /* renamed from: h  reason: collision with root package name */
    public long f68842h = -1;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f68843i;
    public long j;
    public int k;
    public String l;
    public f0 m;

    /* loaded from: classes6.dex */
    public static class b extends j0 {
        public b() {
        }
    }

    public e2(j jVar, i iVar) {
        this.f68836b = jVar;
        this.f68835a = iVar;
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
        o.f68977e = System.currentTimeMillis();
        return o;
    }

    public synchronized Bundle b(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.f68835a.B() && i() && j - this.f68840f > j2) {
            bundle = new Bundle();
            bundle.putInt("session_no", this.k);
            int i2 = this.f68841g + 1;
            this.f68841g = i2;
            bundle.putInt("send_times", i2);
            bundle.putLong("current_duration", (j - this.f68840f) / 1000);
            bundle.putString("session_start_time", z.c(this.f68842h));
            this.f68840f = j;
        }
        return bundle;
    }

    public synchronized f0 c() {
        return this.m;
    }

    public final synchronized void d(z zVar, ArrayList<z> arrayList, boolean z) {
        long j = zVar instanceof b ? -1L : zVar.f68977e;
        this.f68839e = UUID.randomUUID().toString();
        n = this.f68835a.b();
        this.f68842h = j;
        this.f68843i = z;
        this.j = 0L;
        if (r0.f68927b) {
            r0.a("startSession, " + this.f68839e + ", hadUi:" + z + " data:" + zVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            if (TextUtils.isEmpty(this.l)) {
                this.l = this.f68835a.w();
                this.k = this.f68835a.y();
            }
            if (!str.equals(this.l)) {
                this.l = str;
                this.k = 1;
            } else {
                this.k++;
            }
            this.f68835a.s(str, this.k);
            this.f68841g = 0;
        }
        if (j != -1) {
            f0 f0Var = new f0();
            f0Var.f68979g = this.f68839e;
            f0Var.f68978f = a(this.f68835a);
            f0Var.f68977e = this.f68842h;
            f0Var.n = this.f68836b.m();
            f0Var.m = this.f68836b.l();
            if (this.f68835a.R()) {
                f0Var.f68981i = d.b.b.a.c();
                f0Var.j = d.b.b.a.d();
            }
            arrayList.add(f0Var);
            this.m = f0Var;
            if (r0.f68927b) {
                r0.a("gen launch, " + f0Var.f68979g + ", hadUi:" + z, null);
            }
        }
    }

    public boolean f(z zVar, ArrayList<z> arrayList) {
        boolean z = zVar instanceof h0;
        boolean e2 = e(zVar);
        boolean z2 = true;
        if (this.f68842h == -1) {
            d(zVar, arrayList, e(zVar));
        } else if (!this.f68843i && e2) {
            d(zVar, arrayList, true);
        } else {
            long j = this.j;
            if (j != 0 && zVar.f68977e > j + this.f68835a.T()) {
                d(zVar, arrayList, e2);
            } else if (this.f68842h > zVar.f68977e + MainTabActivity.SERVICE_BETWEEN_TIME) {
                d(zVar, arrayList, e2);
            } else {
                z2 = false;
            }
        }
        if (z) {
            h0 h0Var = (h0) zVar;
            if (h0Var.p()) {
                this.f68840f = zVar.f68977e;
                this.j = 0L;
                arrayList.add(zVar);
                if (TextUtils.isEmpty(h0Var.n)) {
                    h0 h0Var2 = this.f68838d;
                    if (h0Var2 != null && (h0Var.f68977e - h0Var2.f68977e) - h0Var2.m < 500) {
                        h0Var.n = h0Var2.o;
                    } else {
                        h0 h0Var3 = this.f68837c;
                        if (h0Var3 != null && (h0Var.f68977e - h0Var3.f68977e) - h0Var3.m < 500) {
                            h0Var.n = h0Var3.o;
                        }
                    }
                }
            } else {
                Bundle b2 = b(zVar.f68977e, 0L);
                if (b2 != null) {
                    d.b.b.a.q("play_session", b2);
                }
                this.f68840f = 0L;
                this.j = h0Var.f68977e;
                arrayList.add(zVar);
                if (h0Var.q()) {
                    this.f68837c = h0Var;
                } else {
                    this.f68838d = h0Var;
                    this.f68837c = null;
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
            zVar.f68980h = this.f68836b.q();
            zVar.f68979g = this.f68839e;
            zVar.f68978f = a(this.f68835a);
            if (this.f68835a.R()) {
                zVar.f68981i = d.b.b.a.c();
                zVar.j = d.b.b.a.d();
            }
        }
    }

    public boolean h() {
        return this.f68843i;
    }

    public boolean i() {
        return h() && this.j == 0;
    }
}
