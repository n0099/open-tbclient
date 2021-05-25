package d.a.g0.a.d;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f39933a;

    /* renamed from: b  reason: collision with root package name */
    public V8ExceptionInfo f39934b;

    /* renamed from: c  reason: collision with root package name */
    public int f39935c;

    public b(int i2, V8ExceptionInfo v8ExceptionInfo, long j) {
        this.f39933a = j;
        this.f39934b = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
        this.f39935c = i2;
    }

    public V8ExceptionInfo a() {
        return this.f39934b;
    }

    public String toString() {
        return "StuckScreenExceptionInfo{mLastOnScreenHappenedTime=" + this.f39933a + ", mV8ExceptionInfo=" + this.f39934b + ", type=" + this.f39935c + '}';
    }
}
