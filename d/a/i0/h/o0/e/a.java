package d.a.i0.h.o0.e;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class a extends d.a.i0.h.d.c.b {
    @V8JavascriptField
    public int errCode;

    public a(int i2, String str) {
        this.errCode = i2;
        this.errMsg = str;
    }

    public String toString() {
        return "DesktopCommonResult{errCode=" + this.errCode + ", errMsg='" + this.errMsg + "'}";
    }
}
