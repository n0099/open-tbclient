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
    public final i f68731a;

    /* renamed from: b  reason: collision with root package name */
    public final j f68732b;

    /* renamed from: c  reason: collision with root package name */
    public h0 f68733c;

    /* renamed from: d  reason: collision with root package name */
    public h0 f68734d;

    /* renamed from: e  reason: collision with root package name */
    public String f68735e;

    /* renamed from: f  reason: collision with root package name */
    public long f68736f;

    /* renamed from: g  reason: collision with root package name */
    public int f68737g;

    /* renamed from: h  reason: collision with root package name */
    public long f68738h = -1;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f68739i;
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
        this.f68732b = jVar;
        this.f68731a = iVar;
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
        o.f68873e = System.currentTimeMillis();
        return o;
    }

    public synchronized Bundle b(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.f68731a.B() && i() && j - this.f68736f > j2) {
            bundle = new Bundle();
            bundle.putInt("session_no", this.k);
            int i2 = this.f68737g + 1;
            this.f68737g = i2;
            bundle.putInt("send_times", i2);
            bundle.putLong("current_duration", (j - this.f68736f) / 1000);
            bundle.putString("session_start_time", z.c(this.f68738h));
            this.f68736f = j;
        }
        return bundle;
    }

    public synchronized f0 c() {
        return this.m;
    }

    public final synchronized void d(z zVar, ArrayList<z> arrayList, boolean z) {
        long j = zVar instanceof b ? -1L : zVar.f68873e;
        this.f68735e = UUID.randomUUID().toString();
        n = this.f68731a.b();
        this.f68738h = j;
        this.f68739i = z;
        this.j = 0L;
        if (r0.f68823b) {
            r0.a("startSession, " + this.f68735e + ", hadUi:" + z + " data:" + zVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            if (TextUtils.isEmpty(this.l)) {
                this.l = this.f68731a.w();
                this.k = this.f68731a.y();
            }
            if (!str.equals(this.l)) {
                this.l = str;
                this.k = 1;
            } else {
                this.k++;
            }
            this.f68731a.s(str, this.k);
            this.f68737g = 0;
        }
        if (j != -1) {
            f0 f0Var = new f0();
            f0Var.f68875g = this.f68735e;
            f0Var.f68874f = a(this.f68731a);
            f0Var.f68873e = this.f68738h;
            f0Var.n = this.f68732b.m();
            f0Var.m = this.f68732b.l();
            if (this.f68731a.R()) {
                f0Var.f68877i = d.b.b.a.c();
                f0Var.j = d.b.b.a.d();
            }
            arrayList.add(f0Var);
            this.m = f0Var;
            if (r0.f68823b) {
                r0.a("gen launch, " + f0Var.f68875g + ", hadUi:" + z, null);
            }
        }
    }

    public boolean f(z zVar, ArrayList<z> arrayList) {
        boolean z = zVar instanceof h0;
        boolean e2 = e(zVar);
        boolean z2 = true;
        if (this.f68738h == -1) {
            d(zVar, arrayList, e(zVar));
        } else if (!this.f68739i && e2) {
            d(zVar, arrayList, true);
        } else {
            long j = this.j;
            if (j != 0 && zVar.f68873e > j + this.f68731a.T()) {
                d(zVar, arrayList, e2);
            } else if (this.f68738h > zVar.f68873e + MainTabActivity.SERVICE_BETWEEN_TIME) {
                d(zVar, arrayList, e2);
            } else {
                z2 = false;
            }
        }
        if (z) {
            h0 h0Var = (h0) zVar;
            if (h0Var.p()) {
                this.f68736f = zVar.f68873e;
                this.j = 0L;
                arrayList.add(zVar);
                if (TextUtils.isEmpty(h0Var.n)) {
                    h0 h0Var2 = this.f68734d;
                    if (h0Var2 != null && (h0Var.f68873e - h0Var2.f68873e) - h0Var2.m < 500) {
                        h0Var.n = h0Var2.o;
                    } else {
                        h0 h0Var3 = this.f68733c;
                        if (h0Var3 != null && (h0Var.f68873e - h0Var3.f68873e) - h0Var3.m < 500) {
                            h0Var.n = h0Var3.o;
                        }
                    }
                }
            } else {
                Bundle b2 = b(zVar.f68873e, 0L);
                if (b2 != null) {
                    d.b.b.a.q("play_session", b2);
                }
                this.f68736f = 0L;
                this.j = h0Var.f68873e;
                arrayList.add(zVar);
                if (h0Var.q()) {
                    this.f68733c = h0Var;
                } else {
                    this.f68734d = h0Var;
                    this.f68733c = null;
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
            zVar.f68876h = this.f68732b.q();
            zVar.f68875g = this.f68735e;
            zVar.f68874f = a(this.f68731a);
            if (this.f68731a.R()) {
                zVar.f68877i = d.b.b.a.c();
                zVar.j = d.b.b.a.d();
            }
        }
    }

    public boolean h() {
        return this.f68739i;
    }

    public boolean i() {
        return h() && this.j == 0;
    }
}
