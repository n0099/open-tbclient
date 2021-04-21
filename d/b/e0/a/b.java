package d.b.e0.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import d.b.e0.a.d.c;
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public boolean f43415c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f43416d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f43417e;

    /* renamed from: f  reason: collision with root package name */
    public int f43418f;

    @Override // d.b.e0.a.d.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.f43417e == null && v8ExceptionInfo != null) {
            this.f43417e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.f43418f = i;
            if (this.f43429b != null) {
                this.f43429b.b();
            }
        }
    }

    public final void d() {
        this.f43417e = null;
        this.f43416d = 0L;
        this.f43418f = -1;
    }

    public synchronized void e() {
        if (this.f43415c) {
            return;
        }
        if (this.f43429b != null && this.f43416d > 0 && this.f43417e != null) {
            if (System.currentTimeMillis() - this.f43417e.exceptionTime > this.f43428a && this.f43417e.exceptionTime > this.f43416d) {
                this.f43429b.a(new d.b.e0.a.d.b(this.f43418f, this.f43417e, this.f43416d));
                d();
            }
            return;
        }
        Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
    }

    public synchronized void f(boolean z, long j) {
        this.f43415c = z;
        if (z) {
            this.f43416d = j;
            this.f43417e = null;
        }
    }
}
