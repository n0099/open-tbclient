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
    public final i f65915a;

    /* renamed from: b  reason: collision with root package name */
    public final j f65916b;

    /* renamed from: c  reason: collision with root package name */
    public h0 f65917c;

    /* renamed from: d  reason: collision with root package name */
    public h0 f65918d;

    /* renamed from: e  reason: collision with root package name */
    public String f65919e;

    /* renamed from: f  reason: collision with root package name */
    public long f65920f;

    /* renamed from: g  reason: collision with root package name */
    public int f65921g;

    /* renamed from: h  reason: collision with root package name */
    public long f65922h = -1;
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
        this.f65916b = jVar;
        this.f65915a = iVar;
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
        o.f66052e = System.currentTimeMillis();
        return o;
    }

    public synchronized Bundle b(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.f65915a.B() && i() && j - this.f65920f > j2) {
            bundle = new Bundle();
            bundle.putInt("session_no", this.k);
            int i = this.f65921g + 1;
            this.f65921g = i;
            bundle.putInt("send_times", i);
            bundle.putLong("current_duration", (j - this.f65920f) / 1000);
            bundle.putString("session_start_time", z.c(this.f65922h));
            this.f65920f = j;
        }
        return bundle;
    }

    public synchronized f0 c() {
        return this.m;
    }

    public final synchronized void d(z zVar, ArrayList<z> arrayList, boolean z) {
        long j = zVar instanceof b ? -1L : zVar.f66052e;
        this.f65919e = UUID.randomUUID().toString();
        n = this.f65915a.b();
        this.f65922h = j;
        this.i = z;
        this.j = 0L;
        if (r0.f66004b) {
            r0.a("startSession, " + this.f65919e + ", hadUi:" + z + " data:" + zVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            if (TextUtils.isEmpty(this.l)) {
                this.l = this.f65915a.w();
                this.k = this.f65915a.y();
            }
            if (!str.equals(this.l)) {
                this.l = str;
                this.k = 1;
            } else {
                this.k++;
            }
            this.f65915a.s(str, this.k);
            this.f65921g = 0;
        }
        if (j != -1) {
            f0 f0Var = new f0();
            f0Var.f66054g = this.f65919e;
            f0Var.f66053f = a(this.f65915a);
            f0Var.f66052e = this.f65922h;
            f0Var.n = this.f65916b.m();
            f0Var.m = this.f65916b.l();
            if (this.f65915a.R()) {
                f0Var.i = d.c.b.a.c();
                f0Var.j = d.c.b.a.d();
            }
            arrayList.add(f0Var);
            this.m = f0Var;
            if (r0.f66004b) {
                r0.a("gen launch, " + f0Var.f66054g + ", hadUi:" + z, null);
            }
        }
    }

    public boolean f(z zVar, ArrayList<z> arrayList) {
        boolean z = zVar instanceof h0;
        boolean e2 = e(zVar);
        boolean z2 = true;
        if (this.f65922h == -1) {
            d(zVar, arrayList, e(zVar));
        } else if (!this.i && e2) {
            d(zVar, arrayList, true);
        } else {
            long j = this.j;
            if (j != 0 && zVar.f66052e > j + this.f65915a.T()) {
                d(zVar, arrayList, e2);
            } else if (this.f65922h > zVar.f66052e + MainTabActivity.SERVICE_BETWEEN_TIME) {
                d(zVar, arrayList, e2);
            } else {
                z2 = false;
            }
        }
        if (z) {
            h0 h0Var = (h0) zVar;
            if (h0Var.p()) {
                this.f65920f = zVar.f66052e;
                this.j = 0L;
                arrayList.add(zVar);
                if (TextUtils.isEmpty(h0Var.n)) {
                    h0 h0Var2 = this.f65918d;
                    if (h0Var2 != null && (h0Var.f66052e - h0Var2.f66052e) - h0Var2.m < 500) {
                        h0Var.n = h0Var2.o;
                    } else {
                        h0 h0Var3 = this.f65917c;
                        if (h0Var3 != null && (h0Var.f66052e - h0Var3.f66052e) - h0Var3.m < 500) {
                            h0Var.n = h0Var3.o;
                        }
                    }
                }
            } else {
                Bundle b2 = b(zVar.f66052e, 0L);
                if (b2 != null) {
                    d.c.b.a.q("play_session", b2);
                }
                this.f65920f = 0L;
                this.j = h0Var.f66052e;
                arrayList.add(zVar);
                if (h0Var.q()) {
                    this.f65917c = h0Var;
                } else {
                    this.f65918d = h0Var;
                    this.f65917c = null;
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
            zVar.f66055h = this.f65916b.q();
            zVar.f66054g = this.f65919e;
            zVar.f66053f = a(this.f65915a);
            if (this.f65915a.R()) {
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
