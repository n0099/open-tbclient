package d.a.e0.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import d.a.e0.a.d.c;
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public boolean f39904c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f39905d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f39906e;

    /* renamed from: f  reason: collision with root package name */
    public int f39907f;

    @Override // d.a.e0.a.d.c
    public synchronized void a(int i2, V8ExceptionInfo v8ExceptionInfo) {
        if (this.f39906e == null && v8ExceptionInfo != null) {
            this.f39906e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.f39907f = i2;
            if (this.f39918b != null) {
                this.f39918b.a();
            }
        }
    }

    public final void d() {
        this.f39906e = null;
        this.f39905d = 0L;
        this.f39907f = -1;
    }

    public synchronized void e() {
        if (this.f39904c) {
            return;
        }
        if (this.f39918b != null && this.f39905d > 0 && this.f39906e != null) {
            if (System.currentTimeMillis() - this.f39906e.exceptionTime > this.f39917a && this.f39906e.exceptionTime > this.f39905d) {
                this.f39918b.b(new d.a.e0.a.d.b(this.f39907f, this.f39906e, this.f39905d));
                d();
            }
            return;
        }
        Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
    }

    public synchronized void f(boolean z, long j) {
        this.f39904c = z;
        if (z) {
            this.f39905d = j;
            this.f39906e = null;
        }
    }
}
