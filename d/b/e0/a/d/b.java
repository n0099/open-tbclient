package d.b.e0.a.d;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f42769a;

    /* renamed from: b  reason: collision with root package name */
    public V8ExceptionInfo f42770b;

    /* renamed from: c  reason: collision with root package name */
    public int f42771c;

    public b(int i, V8ExceptionInfo v8ExceptionInfo, long j) {
        this.f42769a = j;
        this.f42770b = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
        this.f42771c = i;
    }

    public V8ExceptionInfo a() {
        return this.f42770b;
    }

    public String toString() {
        return "StuckScreenExceptionInfo{mLastOnScreenHappenedTime=" + this.f42769a + ", mV8ExceptionInfo=" + this.f42770b + ", type=" + this.f42771c + '}';
    }
}
