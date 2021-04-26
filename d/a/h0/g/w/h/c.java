package d.a.h0.g.w.h;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class c {
    @V8JavascriptField
    public int progress;
    @V8JavascriptField
    public long totalBytesExpectedToSend;
    @V8JavascriptField
    public long totalBytesSent;

    public c(int i2, long j, long j2) {
        this.progress = i2;
        this.totalBytesExpectedToSend = j;
        this.totalBytesSent = j2;
    }

    public String toString() {
        return "TaskProgressData{progress=" + this.progress + ", fileTotalBytes=" + this.totalBytesExpectedToSend + ", totalBytesExpectedToSend=" + this.totalBytesSent + '}';
    }
}
