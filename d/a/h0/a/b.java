package d.a.h0.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import d.a.h0.a.d.c;
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public boolean f43766c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f43767d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f43768e;

    /* renamed from: f  reason: collision with root package name */
    public int f43769f;

    @Override // d.a.h0.a.d.c
    public synchronized void a(int i2, V8ExceptionInfo v8ExceptionInfo) {
        if (this.f43768e == null && v8ExceptionInfo != null) {
            this.f43768e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.f43769f = i2;
            if (this.f43780b != null) {
                this.f43780b.a();
            }
        }
    }

    public final void d() {
        this.f43768e = null;
        this.f43767d = 0L;
        this.f43769f = -1;
    }

    public synchronized void e() {
        if (this.f43766c) {
            return;
        }
        if (this.f43780b != null && this.f43767d > 0 && this.f43768e != null) {
            if (System.currentTimeMillis() - this.f43768e.exceptionTime > this.f43779a && this.f43768e.exceptionTime > this.f43767d) {
                this.f43780b.b(new d.a.h0.a.d.b(this.f43769f, this.f43768e, this.f43767d));
                d();
            }
            return;
        }
        Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
    }

    public synchronized void f(boolean z, long j) {
        this.f43766c = z;
        if (z) {
            this.f43767d = j;
            this.f43768e = null;
        }
    }
}
