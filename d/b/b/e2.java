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
    public final i f65000a;

    /* renamed from: b  reason: collision with root package name */
    public final j f65001b;

    /* renamed from: c  reason: collision with root package name */
    public h0 f65002c;

    /* renamed from: d  reason: collision with root package name */
    public h0 f65003d;

    /* renamed from: e  reason: collision with root package name */
    public String f65004e;

    /* renamed from: f  reason: collision with root package name */
    public long f65005f;

    /* renamed from: g  reason: collision with root package name */
    public int f65006g;

    /* renamed from: h  reason: collision with root package name */
    public long f65007h = -1;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f65008i;
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
        this.f65001b = jVar;
        this.f65000a = iVar;
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
        o.f65142e = System.currentTimeMillis();
        return o;
    }

    public synchronized Bundle b(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.f65000a.B() && i() && j - this.f65005f > j2) {
            bundle = new Bundle();
            bundle.putInt("session_no", this.k);
            int i2 = this.f65006g + 1;
            this.f65006g = i2;
            bundle.putInt("send_times", i2);
            bundle.putLong("current_duration", (j - this.f65005f) / 1000);
            bundle.putString("session_start_time", z.c(this.f65007h));
            this.f65005f = j;
        }
        return bundle;
    }

    public synchronized f0 c() {
        return this.m;
    }

    public final synchronized void d(z zVar, ArrayList<z> arrayList, boolean z) {
        long j = zVar instanceof b ? -1L : zVar.f65142e;
        this.f65004e = UUID.randomUUID().toString();
        n = this.f65000a.b();
        this.f65007h = j;
        this.f65008i = z;
        this.j = 0L;
        if (r0.f65092b) {
            r0.a("startSession, " + this.f65004e + ", hadUi:" + z + " data:" + zVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            if (TextUtils.isEmpty(this.l)) {
                this.l = this.f65000a.w();
                this.k = this.f65000a.y();
            }
            if (!str.equals(this.l)) {
                this.l = str;
                this.k = 1;
            } else {
                this.k++;
            }
            this.f65000a.s(str, this.k);
            this.f65006g = 0;
        }
        if (j != -1) {
            f0 f0Var = new f0();
            f0Var.f65144g = this.f65004e;
            f0Var.f65143f = a(this.f65000a);
            f0Var.f65142e = this.f65007h;
            f0Var.n = this.f65001b.m();
            f0Var.m = this.f65001b.l();
            if (this.f65000a.R()) {
                f0Var.f65146i = d.b.b.a.c();
                f0Var.j = d.b.b.a.d();
            }
            arrayList.add(f0Var);
            this.m = f0Var;
            if (r0.f65092b) {
                r0.a("gen launch, " + f0Var.f65144g + ", hadUi:" + z, null);
            }
        }
    }

    public boolean f(z zVar, ArrayList<z> arrayList) {
        boolean z = zVar instanceof h0;
        boolean e2 = e(zVar);
        boolean z2 = true;
        if (this.f65007h == -1) {
            d(zVar, arrayList, e(zVar));
        } else if (!this.f65008i && e2) {
            d(zVar, arrayList, true);
        } else {
            long j = this.j;
            if (j != 0 && zVar.f65142e > j + this.f65000a.T()) {
                d(zVar, arrayList, e2);
            } else if (this.f65007h > zVar.f65142e + MainTabActivity.SERVICE_BETWEEN_TIME) {
                d(zVar, arrayList, e2);
            } else {
                z2 = false;
            }
        }
        if (z) {
            h0 h0Var = (h0) zVar;
            if (h0Var.p()) {
                this.f65005f = zVar.f65142e;
                this.j = 0L;
                arrayList.add(zVar);
                if (TextUtils.isEmpty(h0Var.n)) {
                    h0 h0Var2 = this.f65003d;
                    if (h0Var2 != null && (h0Var.f65142e - h0Var2.f65142e) - h0Var2.m < 500) {
                        h0Var.n = h0Var2.o;
                    } else {
                        h0 h0Var3 = this.f65002c;
                        if (h0Var3 != null && (h0Var.f65142e - h0Var3.f65142e) - h0Var3.m < 500) {
                            h0Var.n = h0Var3.o;
                        }
                    }
                }
            } else {
                Bundle b2 = b(zVar.f65142e, 0L);
                if (b2 != null) {
                    d.b.b.a.q("play_session", b2);
                }
                this.f65005f = 0L;
                this.j = h0Var.f65142e;
                arrayList.add(zVar);
                if (h0Var.q()) {
                    this.f65002c = h0Var;
                } else {
                    this.f65003d = h0Var;
                    this.f65002c = null;
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
            zVar.f65145h = this.f65001b.q();
            zVar.f65144g = this.f65004e;
            zVar.f65143f = a(this.f65000a);
            if (this.f65000a.R()) {
                zVar.f65146i = d.b.b.a.c();
                zVar.j = d.b.b.a.d();
            }
        }
    }

    public boolean h() {
        return this.f65008i;
    }

    public boolean i() {
        return h() && this.j == 0;
    }
}
