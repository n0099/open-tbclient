package d.a.m.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes.dex */
public final class h implements Printer {

    /* renamed from: c  reason: collision with root package name */
    public f f63843c;

    /* renamed from: e  reason: collision with root package name */
    public final Context f63845e;

    /* renamed from: a  reason: collision with root package name */
    public long f63841a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f63842b = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63844d = false;

    public h(f fVar, Context context) {
        this.f63843c = null;
        this.f63843c = fVar;
        this.f63845e = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.f63844d) {
            this.f63841a = System.currentTimeMillis();
            this.f63842b = SystemClock.currentThreadTimeMillis();
            this.f63844d = true;
            if (com.baidu.crabsdk.a.c.b(this.f63845e).f4658b != null) {
                com.baidu.crabsdk.a.c.b(this.f63845e).f4658b.c();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f63844d = false;
        if (currentTimeMillis - this.f63841a >= ((long) com.baidu.crabsdk.a.a.f4642g)) {
            com.baidu.crabsdk.c.a.b("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + "-" + this.f63841a + "=" + (currentTimeMillis - this.f63841a) + " >= " + com.baidu.crabsdk.a.a.f4642g);
            com.baidu.crabsdk.a.j.b().post(new i(this, this.f63841a, currentTimeMillis, this.f63842b, SystemClock.currentThreadTimeMillis()));
        }
        if (com.baidu.crabsdk.a.c.b(this.f63845e).f4658b != null) {
            com.baidu.crabsdk.a.c.b(this.f63845e).f4658b.d();
        }
    }
}
