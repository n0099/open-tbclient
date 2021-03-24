package d.b.g0.g.k0.g;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class a extends d.b.g0.g.e.d.b {
    @V8JavascriptField
    public int errCode;

    public a(int i, String str) {
        this.errCode = i;
        this.errMsg = str;
    }

    public String toString() {
        return "DesktopCommonResult{errCode=" + this.errCode + ", errMsg='" + this.errMsg + "'}";
    }
}
