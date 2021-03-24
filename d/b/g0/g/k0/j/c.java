package d.b.g0.g.k0.j;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class c extends b {
    @V8JavascriptField
    public String errCode;
    @V8JavascriptField
    public String errMsg;

    public c(String str, String str2, String str3) {
        super(str);
        this.errCode = str2;
        this.errMsg = str3;
    }

    @Override // d.b.g0.g.k0.j.b
    @NonNull
    public String toString() {
        return "GameWebViewErrorResult{url=" + this.url + ", errMsg='" + this.errMsg + "'}";
    }
}
