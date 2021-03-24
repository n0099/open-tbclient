package d.b.n.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes2.dex */
public final class h implements Printer {

    /* renamed from: c  reason: collision with root package name */
    public f f64126c;

    /* renamed from: e  reason: collision with root package name */
    public final Context f64128e;

    /* renamed from: a  reason: collision with root package name */
    public long f64124a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f64125b = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64127d = false;

    public h(f fVar, Context context) {
        this.f64126c = null;
        this.f64126c = fVar;
        this.f64128e = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.f64127d) {
            this.f64124a = System.currentTimeMillis();
            this.f64125b = SystemClock.currentThreadTimeMillis();
            this.f64127d = true;
            if (com.baidu.crabsdk.a.c.b(this.f64128e).f4657b != null) {
                com.baidu.crabsdk.a.c.b(this.f64128e).f4657b.c();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f64127d = false;
        if (currentTimeMillis - this.f64124a >= ((long) com.baidu.crabsdk.a.a.f4642g)) {
            com.baidu.crabsdk.c.a.b("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + "-" + this.f64124a + "=" + (currentTimeMillis - this.f64124a) + " >= " + com.baidu.crabsdk.a.a.f4642g);
            com.baidu.crabsdk.a.j.b().post(new i(this, this.f64124a, currentTimeMillis, this.f64125b, SystemClock.currentThreadTimeMillis()));
        }
        if (com.baidu.crabsdk.a.c.b(this.f64128e).f4657b != null) {
            com.baidu.crabsdk.a.c.b(this.f64128e).f4657b.d();
        }
    }
}
