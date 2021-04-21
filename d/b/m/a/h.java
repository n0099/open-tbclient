package d.b.m.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes.dex */
public final class h implements Printer {

    /* renamed from: c  reason: collision with root package name */
    public f f64995c;

    /* renamed from: e  reason: collision with root package name */
    public final Context f64997e;

    /* renamed from: a  reason: collision with root package name */
    public long f64993a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f64994b = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64996d = false;

    public h(f fVar, Context context) {
        this.f64995c = null;
        this.f64995c = fVar;
        this.f64997e = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.f64996d) {
            this.f64993a = System.currentTimeMillis();
            this.f64994b = SystemClock.currentThreadTimeMillis();
            this.f64996d = true;
            if (com.baidu.crabsdk.a.c.b(this.f64997e).f4693b != null) {
                com.baidu.crabsdk.a.c.b(this.f64997e).f4693b.c();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f64996d = false;
        if (currentTimeMillis - this.f64993a >= ((long) com.baidu.crabsdk.a.a.f4678g)) {
            com.baidu.crabsdk.c.a.b("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + "-" + this.f64993a + "=" + (currentTimeMillis - this.f64993a) + " >= " + com.baidu.crabsdk.a.a.f4678g);
            com.baidu.crabsdk.a.j.b().post(new i(this, this.f64993a, currentTimeMillis, this.f64994b, SystemClock.currentThreadTimeMillis()));
        }
        if (com.baidu.crabsdk.a.c.b(this.f64997e).f4693b != null) {
            com.baidu.crabsdk.a.c.b(this.f64997e).f4693b.d();
        }
    }
}
