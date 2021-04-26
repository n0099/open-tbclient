package d.a.e0.a.d;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f40669a;

    /* renamed from: b  reason: collision with root package name */
    public V8ExceptionInfo f40670b;

    /* renamed from: c  reason: collision with root package name */
    public int f40671c;

    public b(int i2, V8ExceptionInfo v8ExceptionInfo, long j) {
        this.f40669a = j;
        this.f40670b = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
        this.f40671c = i2;
    }

    public V8ExceptionInfo a() {
        return this.f40670b;
    }

    public String toString() {
        return "StuckScreenExceptionInfo{mLastOnScreenHappenedTime=" + this.f40669a + ", mV8ExceptionInfo=" + this.f40670b + ", type=" + this.f40671c + '}';
    }
}
