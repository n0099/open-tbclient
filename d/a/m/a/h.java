package d.a.m.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes.dex */
public final class h implements Printer {

    /* renamed from: c  reason: collision with root package name */
    public f f63304c;

    /* renamed from: e  reason: collision with root package name */
    public final Context f63306e;

    /* renamed from: a  reason: collision with root package name */
    public long f63302a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f63303b = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63305d = false;

    public h(f fVar, Context context) {
        this.f63304c = null;
        this.f63304c = fVar;
        this.f63306e = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.f63305d) {
            this.f63302a = System.currentTimeMillis();
            this.f63303b = SystemClock.currentThreadTimeMillis();
            this.f63305d = true;
            if (com.baidu.crabsdk.a.c.b(this.f63306e).f4804b != null) {
                com.baidu.crabsdk.a.c.b(this.f63306e).f4804b.c();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f63305d = false;
        if (currentTimeMillis - this.f63302a >= ((long) com.baidu.crabsdk.a.a.f4788g)) {
            com.baidu.crabsdk.c.a.b("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + "-" + this.f63302a + "=" + (currentTimeMillis - this.f63302a) + " >= " + com.baidu.crabsdk.a.a.f4788g);
            com.baidu.crabsdk.a.j.b().post(new i(this, this.f63302a, currentTimeMillis, this.f63303b, SystemClock.currentThreadTimeMillis()));
        }
        if (com.baidu.crabsdk.a.c.b(this.f63306e).f4804b != null) {
            com.baidu.crabsdk.a.c.b(this.f63306e).f4804b.d();
        }
    }
}
