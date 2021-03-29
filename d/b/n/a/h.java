package d.b.n.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes.dex */
public final class h implements Printer {

    /* renamed from: c  reason: collision with root package name */
    public f f64127c;

    /* renamed from: e  reason: collision with root package name */
    public final Context f64129e;

    /* renamed from: a  reason: collision with root package name */
    public long f64125a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f64126b = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64128d = false;

    public h(f fVar, Context context) {
        this.f64127c = null;
        this.f64127c = fVar;
        this.f64129e = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.f64128d) {
            this.f64125a = System.currentTimeMillis();
            this.f64126b = SystemClock.currentThreadTimeMillis();
            this.f64128d = true;
            if (com.baidu.crabsdk.a.c.b(this.f64129e).f4658b != null) {
                com.baidu.crabsdk.a.c.b(this.f64129e).f4658b.c();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f64128d = false;
        if (currentTimeMillis - this.f64125a >= ((long) com.baidu.crabsdk.a.a.f4643g)) {
            com.baidu.crabsdk.c.a.b("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + "-" + this.f64125a + "=" + (currentTimeMillis - this.f64125a) + " >= " + com.baidu.crabsdk.a.a.f4643g);
            com.baidu.crabsdk.a.j.b().post(new i(this, this.f64125a, currentTimeMillis, this.f64126b, SystemClock.currentThreadTimeMillis()));
        }
        if (com.baidu.crabsdk.a.c.b(this.f64129e).f4658b != null) {
            com.baidu.crabsdk.a.c.b(this.f64129e).f4658b.d();
        }
    }
}
