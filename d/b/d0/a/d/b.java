package d.b.d0.a.d;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f43161a;

    /* renamed from: b  reason: collision with root package name */
    public V8ExceptionInfo f43162b;

    /* renamed from: c  reason: collision with root package name */
    public int f43163c;

    public b(int i, V8ExceptionInfo v8ExceptionInfo, long j) {
        this.f43161a = j;
        this.f43162b = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
        this.f43163c = i;
    }

    public V8ExceptionInfo a() {
        return this.f43162b;
    }

    public String toString() {
        return "StuckScreenExceptionInfo{mLastOnScreenHappenedTime=" + this.f43161a + ", mV8ExceptionInfo=" + this.f43162b + ", type=" + this.f43163c + '}';
    }
}
