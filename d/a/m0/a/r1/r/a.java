package d.a.m0.a.r1.r;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.xiaomi.mipush.sdk.Constants;
import d.a.m0.a.a2.d;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a implements d.a.m0.a.r1.r.c.a, d.a.m0.a.f1.f.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f48348b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<c> f48349c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownTimer f48350d;

    /* renamed from: d.a.m0.a.r1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class CountDownTimerC0871a extends CountDownTimer {
        public CountDownTimerC0871a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (d.a.m0.a.f1.f.a.f45636a) {
                Log.d("SwanPerformance", "count down onFinish");
            }
            a.this.c(true);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Iterator it = a.this.f48349c.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                boolean z = ((long) (5000 - cVar.e())) >= j;
                if (!cVar.g() && z) {
                    cVar.h(true);
                    d.a.m0.a.r1.r.c.a f2 = cVar.f();
                    if (d.a.m0.a.f1.f.a.f45636a) {
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
        public static final a f48352a = new a(null);
    }

    /* loaded from: classes3.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public d.a.m0.a.r1.r.c.a f48353a;

        /* renamed from: b  reason: collision with root package name */
        public int f48354b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f48355c;

        public /* synthetic */ c(a aVar, d.a.m0.a.r1.r.c.a aVar2, int i2, CountDownTimerC0871a countDownTimerC0871a) {
            this(aVar, aVar2, i2);
        }

        public final int e() {
            return this.f48354b;
        }

        @NonNull
        public final d.a.m0.a.r1.r.c.a f() {
            return this.f48353a;
        }

        public final boolean g() {
            return this.f48355c;
        }

        public final void h(boolean z) {
            this.f48355c = z;
        }

        public c(@NonNull a aVar, d.a.m0.a.r1.r.c.a aVar2, int i2) {
            this.f48355c = false;
            this.f48353a = aVar2;
            this.f48354b = i2;
        }
    }

    public /* synthetic */ a(CountDownTimerC0871a countDownTimerC0871a) {
        this();
    }

    public static a f() {
        return b.f48352a;
    }

    @Override // d.a.m0.a.r1.r.c.a
    public void a(String str) {
        if (d.a.m0.a.f1.f.a.f45636a) {
            Log.e("SwanPerformance", "triggerFcp, url = " + str);
        }
        Iterator<c> it = this.f48349c.iterator();
        while (it.hasNext()) {
            it.next().f().a(str);
        }
    }

    @Override // d.a.m0.a.r1.r.c.a
    public void b() {
        if (this.f48349c.isEmpty()) {
            return;
        }
        if (d.a.m0.a.f1.f.a.f45636a) {
            Log.e("SwanPerformance", "triggerDestroy");
        }
        j();
        Iterator<c> it = this.f48349c.iterator();
        while (it.hasNext()) {
            it.next().f().b();
        }
        this.f48348b = false;
    }

    @Override // d.a.m0.a.r1.r.c.a
    public void c(boolean z) {
        if (this.f48348b) {
            return;
        }
        this.f48348b = true;
        j();
        if (this.f48349c.isEmpty()) {
            return;
        }
        if (d.a.m0.a.f1.f.a.f45636a) {
            Log.e("SwanPerformance", "triggerFmp, timeout = " + z);
        }
        Iterator<c> it = this.f48349c.iterator();
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
        d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
        d.a.m0.a.v1.c.c cVar = new d.a.m0.a.v1.c.c(23, bundle);
        cVar.f(true);
        e2.h(cVar);
    }

    @Override // d.a.m0.a.r1.r.c.a
    @UiThread
    public void d(String str) {
        this.f48348b = false;
        if (this.f48349c.isEmpty()) {
            return;
        }
        if (d.a.m0.a.f1.f.a.f45636a) {
            Log.e("SwanPerformance", "triggerLaunch, source = " + str);
        }
        Iterator<c> it = this.f48349c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            next.h(false);
            next.f().d(str);
        }
        j();
        i();
    }

    public boolean g(d.a.m0.a.r1.r.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        Iterator<c> it = this.f48349c.iterator();
        while (it.hasNext()) {
            if (aVar.equals(it.next().f())) {
                return true;
            }
        }
        return false;
    }

    @Override // d.a.m0.a.r1.r.c.a
    public String getName() {
        return "SwanLaunchTriggerMgr";
    }

    public void h(d.a.m0.a.r1.r.c.a aVar, int i2) {
        if (this.f48348b || aVar == null) {
            return;
        }
        if (i2 > 5000) {
            i2 = 5000;
        }
        if (g(aVar)) {
            return;
        }
        this.f48349c.add(new c(this, aVar, i2, null));
        if (d.a.m0.a.f1.f.a.f45636a) {
            Log.e("SwanPerformance", "register, task name = " + aVar.getName() + " ; timeout = " + i2);
        }
    }

    public final void i() {
        try {
            this.f48350d.start();
        } catch (Throwable th) {
            if (d.a.m0.a.f1.f.a.f45636a) {
                Log.d("SwanPerformance", "start timer exception = " + th.getMessage());
            }
        }
    }

    public final void j() {
        try {
            this.f48350d.cancel();
        } catch (Throwable th) {
            if (d.a.m0.a.f1.f.a.f45636a) {
                Log.d("SwanPerformance", "stop timer exception = " + th.getMessage());
            }
        }
    }

    public a() {
        this.f48348b = false;
        this.f48349c = new CopyOnWriteArrayList<>();
        this.f48350d = new CountDownTimerC0871a(5000L, 500L);
    }
}
