package d.a.g0.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import d.a.g0.a.d.c;
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public boolean f43604c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f43605d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f43606e;

    /* renamed from: f  reason: collision with root package name */
    public int f43607f;

    @Override // d.a.g0.a.d.c
    public synchronized void a(int i2, V8ExceptionInfo v8ExceptionInfo) {
        if (this.f43606e == null && v8ExceptionInfo != null) {
            this.f43606e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.f43607f = i2;
            if (this.f43618b != null) {
                this.f43618b.a();
            }
        }
    }

    public final void d() {
        this.f43606e = null;
        this.f43605d = 0L;
        this.f43607f = -1;
    }

    public synchronized void e() {
        if (this.f43604c) {
            return;
        }
        if (this.f43618b != null && this.f43605d > 0 && this.f43606e != null) {
            if (System.currentTimeMillis() - this.f43606e.exceptionTime > this.f43617a && this.f43606e.exceptionTime > this.f43605d) {
                this.f43618b.b(new d.a.g0.a.d.b(this.f43607f, this.f43606e, this.f43605d));
                d();
            }
            return;
        }
        Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
    }

    public synchronized void f(boolean z, long j) {
        this.f43604c = z;
        if (z) {
            this.f43605d = j;
            this.f43606e = null;
        }
    }
}
