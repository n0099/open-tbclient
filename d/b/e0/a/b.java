package d.b.e0.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import d.b.e0.a.d.c;
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public boolean f42759c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f42760d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f42761e;

    /* renamed from: f  reason: collision with root package name */
    public int f42762f;

    @Override // d.b.e0.a.d.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.f42761e == null && v8ExceptionInfo != null) {
            this.f42761e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.f42762f = i;
            if (this.f42773b != null) {
                this.f42773b.b();
            }
        }
    }

    public final void d() {
        this.f42761e = null;
        this.f42760d = 0L;
        this.f42762f = -1;
    }

    public synchronized void e() {
        if (this.f42759c) {
            return;
        }
        if (this.f42773b != null && this.f42760d > 0 && this.f42761e != null) {
            if (System.currentTimeMillis() - this.f42761e.exceptionTime > this.f42772a && this.f42761e.exceptionTime > this.f42760d) {
                this.f42773b.a(new d.b.e0.a.d.b(this.f42762f, this.f42761e, this.f42760d));
                d();
            }
            return;
        }
        Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
    }

    public synchronized void f(boolean z, long j) {
        this.f42759c = z;
        if (z) {
            this.f42760d = j;
            this.f42761e = null;
        }
    }
}
