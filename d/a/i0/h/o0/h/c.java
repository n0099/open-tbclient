package d.a.i0.h.o0.h;

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

    @Override // d.a.i0.h.o0.h.b
    @NonNull
    public String toString() {
        return "GameWebViewErrorResult{url=" + this.url + ", errMsg='" + this.errMsg + "'}";
    }
}
