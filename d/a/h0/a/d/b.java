package d.a.h0.a.d;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f43776a;

    /* renamed from: b  reason: collision with root package name */
    public V8ExceptionInfo f43777b;

    /* renamed from: c  reason: collision with root package name */
    public int f43778c;

    public b(int i2, V8ExceptionInfo v8ExceptionInfo, long j) {
        this.f43776a = j;
        this.f43777b = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
        this.f43778c = i2;
    }

    public V8ExceptionInfo a() {
        return this.f43777b;
    }

    public String toString() {
        return "StuckScreenExceptionInfo{mLastOnScreenHappenedTime=" + this.f43776a + ", mV8ExceptionInfo=" + this.f43777b + ", type=" + this.f43778c + '}';
    }
}
