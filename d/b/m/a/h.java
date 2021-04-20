package d.b.m.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes.dex */
public final class h implements Printer {

    /* renamed from: c  reason: collision with root package name */
    public f f64731c;

    /* renamed from: e  reason: collision with root package name */
    public final Context f64733e;

    /* renamed from: a  reason: collision with root package name */
    public long f64729a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f64730b = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64732d = false;

    public h(f fVar, Context context) {
        this.f64731c = null;
        this.f64731c = fVar;
        this.f64733e = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.f64732d) {
            this.f64729a = System.currentTimeMillis();
            this.f64730b = SystemClock.currentThreadTimeMillis();
            this.f64732d = true;
            if (com.baidu.crabsdk.a.c.b(this.f64733e).f4693b != null) {
                com.baidu.crabsdk.a.c.b(this.f64733e).f4693b.c();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f64732d = false;
        if (currentTimeMillis - this.f64729a >= ((long) com.baidu.crabsdk.a.a.f4678g)) {
            com.baidu.crabsdk.c.a.b("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + "-" + this.f64729a + "=" + (currentTimeMillis - this.f64729a) + " >= " + com.baidu.crabsdk.a.a.f4678g);
            com.baidu.crabsdk.a.j.b().post(new i(this, this.f64729a, currentTimeMillis, this.f64730b, SystemClock.currentThreadTimeMillis()));
        }
        if (com.baidu.crabsdk.a.c.b(this.f64733e).f4693b != null) {
            com.baidu.crabsdk.a.c.b(this.f64733e).f4693b.d();
        }
    }
}
