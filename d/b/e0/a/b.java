package d.b.e0.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import d.b.e0.a.d.c;
/* loaded from: classes3.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public boolean f42758c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f42759d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f42760e;

    /* renamed from: f  reason: collision with root package name */
    public int f42761f;

    @Override // d.b.e0.a.d.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.f42760e == null && v8ExceptionInfo != null) {
            this.f42760e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.f42761f = i;
            if (this.f42772b != null) {
                this.f42772b.b();
            }
        }
    }

    public final void d() {
        this.f42760e = null;
        this.f42759d = 0L;
        this.f42761f = -1;
    }

    public synchronized void e() {
        if (this.f42758c) {
            return;
        }
        if (this.f42772b != null && this.f42759d > 0 && this.f42760e != null) {
            if (System.currentTimeMillis() - this.f42760e.exceptionTime > this.f42771a && this.f42760e.exceptionTime > this.f42759d) {
                this.f42772b.a(new d.b.e0.a.d.b(this.f42761f, this.f42760e, this.f42759d));
                d();
            }
            return;
        }
        Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
    }

    public synchronized void f(boolean z, long j) {
        this.f42758c = z;
        if (z) {
            this.f42759d = j;
            this.f42760e = null;
        }
    }
}
