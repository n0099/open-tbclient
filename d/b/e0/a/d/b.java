package d.b.e0.a.d;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f43425a;

    /* renamed from: b  reason: collision with root package name */
    public V8ExceptionInfo f43426b;

    /* renamed from: c  reason: collision with root package name */
    public int f43427c;

    public b(int i, V8ExceptionInfo v8ExceptionInfo, long j) {
        this.f43425a = j;
        this.f43426b = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
        this.f43427c = i;
    }

    public V8ExceptionInfo a() {
        return this.f43426b;
    }

    public String toString() {
        return "StuckScreenExceptionInfo{mLastOnScreenHappenedTime=" + this.f43425a + ", mV8ExceptionInfo=" + this.f43426b + ", type=" + this.f43427c + '}';
    }
}
