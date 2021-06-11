package d.a.g0.a.d;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f43614a;

    /* renamed from: b  reason: collision with root package name */
    public V8ExceptionInfo f43615b;

    /* renamed from: c  reason: collision with root package name */
    public int f43616c;

    public b(int i2, V8ExceptionInfo v8ExceptionInfo, long j) {
        this.f43614a = j;
        this.f43615b = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
        this.f43616c = i2;
    }

    public V8ExceptionInfo a() {
        return this.f43615b;
    }

    public String toString() {
        return "StuckScreenExceptionInfo{mLastOnScreenHappenedTime=" + this.f43614a + ", mV8ExceptionInfo=" + this.f43615b + ", type=" + this.f43616c + '}';
    }
}
