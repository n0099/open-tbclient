package d.a.l0.a.r1.r;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.xiaomi.mipush.sdk.Constants;
import d.a.l0.a.a2.d;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a implements d.a.l0.a.r1.r.c.a, d.a.l0.a.f1.f.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f44566b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<c> f44567c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownTimer f44568d;

    /* renamed from: d.a.l0.a.r1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class CountDownTimerC0812a extends CountDownTimer {
        public CountDownTimerC0812a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (d.a.l0.a.f1.f.a.f41852a) {
                Log.d("SwanPerformance", "count down onFinish");
            }
            a.this.c(true);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Iterator it = a.this.f44567c.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                boolean z = ((long) (5000 - cVar.e())) >= j;
                if (!cVar.g() && z) {
                    cVar.h(true);
                    d.a.l0.a.r1.r.c.a f2 = cVar.f();
                    if (d.a.l0.a.f1.f.a.f41852a) {
                        Log.e("SwanPerformance", "triggerFmp, timeout = " + cVar.e() + ", trigger = " + f2.getName());
                    }
                    f2.c(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44570a = new a(null);
    }

    /* loaded from: classes3.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public d.a.l0.a.r1.r.c.a f44571a;

        /* renamed from: b  reason: collision with root package name */
        public int f44572b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f44573c;

        public /* synthetic */ c(a aVar, d.a.l0.a.r1.r.c.a aVar2, int i2, CountDownTimerC0812a countDownTimerC0812a) {
            this(aVar, aVar2, i2);
        }

        public final int e() {
            return this.f44572b;
        }

        @NonNull
        public final d.a.l0.a.r1.r.c.a f() {
            return this.f44571a;
        }

        public final boolean g() {
            return this.f44573c;
        }

        public final void h(boolean z) {
            this.f44573c = z;
        }

        public c(@NonNull a aVar, d.a.l0.a.r1.r.c.a aVar2, int i2) {
            this.f44573c = false;
            this.f44571a = aVar2;
            this.f44572b = i2;
        }
    }

    public /* synthetic */ a(CountDownTimerC0812a countDownTimerC0812a) {
        this();
    }

    public static a f() {
        return b.f44570a;
    }

    @Override // d.a.l0.a.r1.r.c.a
    public void a(String str) {
        if (d.a.l0.a.f1.f.a.f41852a) {
            Log.e("SwanPerformance", "triggerFcp, url = " + str);
        }
        Iterator<c> it = this.f44567c.iterator();
        while (it.hasNext()) {
            it.next().f().a(str);
        }
    }

    @Override // d.a.l0.a.r1.r.c.a
    public void b() {
        if (this.f44567c.isEmpty()) {
            return;
        }
        if (d.a.l0.a.f1.f.a.f41852a) {
            Log.e("SwanPerformance", "triggerDestroy");
        }
        j();
        Iterator<c> it = this.f44567c.iterator();
        while (it.hasNext()) {
            it.next().f().b();
        }
        this.f44566b = false;
    }

    @Override // d.a.l0.a.r1.r.c.a
    public void c(boolean z) {
        if (this.f44566b) {
            return;
        }
        this.f44566b = true;
        j();
        if (this.f44567c.isEmpty()) {
            return;
        }
        if (d.a.l0.a.f1.f.a.f41852a) {
            Log.e("SwanPerformance", "triggerFmp, timeout = " + z);
        }
        Iterator<c> it = this.f44567c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!next.g()) {
                next.h(true);
                next.f().c(z);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_timeout", z);
        bundle.putString(Constants.APP_ID, d.g().getAppId());
        d.a.l0.a.v1.c.a e2 = d.a.l0.a.v1.c.a.e();
        d.a.l0.a.v1.c.c cVar = new d.a.l0.a.v1.c.c(23, bundle);
        cVar.f(true);
        e2.h(cVar);
    }

    @Override // d.a.l0.a.r1.r.c.a
    @UiThread
    public void d(String str) {
        this.f44566b = false;
        if (this.f44567c.isEmpty()) {
            return;
        }
        if (d.a.l0.a.f1.f.a.f41852a) {
            Log.e("SwanPerformance", "triggerLaunch, source = " + str);
        }
        Iterator<c> it = this.f44567c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            next.h(false);
            next.f().d(str);
        }
        j();
        i();
    }

    public boolean g(d.a.l0.a.r1.r.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        Iterator<c> it = this.f44567c.iterator();
        while (it.hasNext()) {
            if (aVar.equals(it.next().f())) {
                return true;
            }
        }
        return false;
    }

    @Override // d.a.l0.a.r1.r.c.a
    public String getName() {
        return "SwanLaunchTriggerMgr";
    }

    public void h(d.a.l0.a.r1.r.c.a aVar, int i2) {
        if (this.f44566b || aVar == null) {
            return;
        }
        if (i2 > 5000) {
            i2 = 5000;
        }
        if (g(aVar)) {
            return;
        }
        this.f44567c.add(new c(this, aVar, i2, null));
        if (d.a.l0.a.f1.f.a.f41852a) {
            Log.e("SwanPerformance", "register, task name = " + aVar.getName() + " ; timeout = " + i2);
        }
    }

    public final void i() {
        try {
            this.f44568d.start();
        } catch (Throwable th) {
            if (d.a.l0.a.f1.f.a.f41852a) {
                Log.d("SwanPerformance", "start timer exception = " + th.getMessage());
            }
        }
    }

    public final void j() {
        try {
            this.f44568d.cancel();
        } catch (Throwable th) {
            if (d.a.l0.a.f1.f.a.f41852a) {
                Log.d("SwanPerformance", "stop timer exception = " + th.getMessage());
            }
        }
    }

    public a() {
        this.f44566b = false;
        this.f44567c = new CopyOnWriteArrayList<>();
        this.f44568d = new CountDownTimerC0812a(5000L, 500L);
    }
}
