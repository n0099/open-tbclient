package d.b.d0.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import d.b.d0.a.d.c;
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public boolean f43151c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f43152d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f43153e;

    /* renamed from: f  reason: collision with root package name */
    public int f43154f;

    @Override // d.b.d0.a.d.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.f43153e == null && v8ExceptionInfo != null) {
            this.f43153e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.f43154f = i;
            if (this.f43165b != null) {
                this.f43165b.b();
            }
        }
    }

    public final void d() {
        this.f43153e = null;
        this.f43152d = 0L;
        this.f43154f = -1;
    }

    public synchronized void e() {
        if (this.f43151c) {
            return;
        }
        if (this.f43165b != null && this.f43152d > 0 && this.f43153e != null) {
            if (System.currentTimeMillis() - this.f43153e.exceptionTime > this.f43164a && this.f43153e.exceptionTime > this.f43152d) {
                this.f43165b.a(new d.b.d0.a.d.b(this.f43154f, this.f43153e, this.f43152d));
                d();
            }
            return;
        }
        Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
    }

    public synchronized void f(boolean z, long j) {
        this.f43151c = z;
        if (z) {
            this.f43152d = j;
            this.f43153e = null;
        }
    }
}
