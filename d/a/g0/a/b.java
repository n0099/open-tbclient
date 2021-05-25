package d.a.g0.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import d.a.g0.a.d.c;
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public boolean f39923c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f39924d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f39925e;

    /* renamed from: f  reason: collision with root package name */
    public int f39926f;

    @Override // d.a.g0.a.d.c
    public synchronized void a(int i2, V8ExceptionInfo v8ExceptionInfo) {
        if (this.f39925e == null && v8ExceptionInfo != null) {
            this.f39925e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.f39926f = i2;
            if (this.f39937b != null) {
                this.f39937b.a();
            }
        }
    }

    public final void d() {
        this.f39925e = null;
        this.f39924d = 0L;
        this.f39926f = -1;
    }

    public synchronized void e() {
        if (this.f39923c) {
            return;
        }
        if (this.f39937b != null && this.f39924d > 0 && this.f39925e != null) {
            if (System.currentTimeMillis() - this.f39925e.exceptionTime > this.f39936a && this.f39925e.exceptionTime > this.f39924d) {
                this.f39937b.b(new d.a.g0.a.d.b(this.f39926f, this.f39925e, this.f39924d));
                d();
            }
            return;
        }
        Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
    }

    public synchronized void f(boolean z, long j) {
        this.f39923c = z;
        if (z) {
            this.f39924d = j;
            this.f39925e = null;
        }
    }
}
