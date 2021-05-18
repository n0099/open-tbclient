package d.a.i0.h.y.d;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class c {
    @V8JavascriptField
    public String filePath;
    @V8JavascriptField
    public int statusCode;
    @V8JavascriptField
    public String tempFilePath;

    public String toString() {
        return "ResponseData{statusCode=" + this.statusCode + ",tempFilePath=" + this.tempFilePath + ",filePath=" + this.filePath + "}";
    }
}
