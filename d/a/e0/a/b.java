package d.a.e0.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import d.a.e0.a.d.c;
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public boolean f40659c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f40660d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f40661e;

    /* renamed from: f  reason: collision with root package name */
    public int f40662f;

    @Override // d.a.e0.a.d.c
    public synchronized void a(int i2, V8ExceptionInfo v8ExceptionInfo) {
        if (this.f40661e == null && v8ExceptionInfo != null) {
            this.f40661e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.f40662f = i2;
            if (this.f40673b != null) {
                this.f40673b.a();
            }
        }
    }

    public final void d() {
        this.f40661e = null;
        this.f40660d = 0L;
        this.f40662f = -1;
    }

    public synchronized void e() {
        if (this.f40659c) {
            return;
        }
        if (this.f40673b != null && this.f40660d > 0 && this.f40661e != null) {
            if (System.currentTimeMillis() - this.f40661e.exceptionTime > this.f40672a && this.f40661e.exceptionTime > this.f40660d) {
                this.f40673b.b(new d.a.e0.a.d.b(this.f40662f, this.f40661e, this.f40660d));
                d();
            }
            return;
        }
        Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
    }

    public synchronized void f(boolean z, long j) {
        this.f40659c = z;
        if (z) {
            this.f40660d = j;
            this.f40661e = null;
        }
    }
}
