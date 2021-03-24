package d.b.e0.a.d;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f42768a;

    /* renamed from: b  reason: collision with root package name */
    public V8ExceptionInfo f42769b;

    /* renamed from: c  reason: collision with root package name */
    public int f42770c;

    public b(int i, V8ExceptionInfo v8ExceptionInfo, long j) {
        this.f42768a = j;
        this.f42769b = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
        this.f42770c = i;
    }

    public V8ExceptionInfo a() {
        return this.f42769b;
    }

    public String toString() {
        return "StuckScreenExceptionInfo{mLastOnScreenHappenedTime=" + this.f42768a + ", mV8ExceptionInfo=" + this.f42769b + ", type=" + this.f42770c + '}';
    }
}
