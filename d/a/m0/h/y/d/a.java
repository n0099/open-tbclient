package d.a.m0.h.y.d;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class a {
    @V8JavascriptField
    public int progress;
    @V8JavascriptField
    public long totalBytesExpectedToWrite;
    @V8JavascriptField
    public long totalBytesWritten;

    public a(int i2, long j, long j2) {
        this.progress = i2;
        this.totalBytesExpectedToWrite = j;
        this.totalBytesWritten = j2;
    }

    public String toString() {
        return "TaskProgressData{progress=" + this.progress + ", totalBytesExpectedToWrite=" + this.totalBytesExpectedToWrite + ", totalBytesWritten=" + this.totalBytesWritten + '}';
    }
}
