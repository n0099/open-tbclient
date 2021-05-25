package d.a.n0.h0.f.a;

import android.webkit.JsPromptResult;
/* loaded from: classes4.dex */
public class b implements d.a.n0.h0.b {
    @Override // d.a.n0.h0.b
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        if (b().equals(str)) {
            try {
                d.a.n0.h0.a.f().h(str2);
            } catch (Throwable unused) {
                d.a.n0.h0.a.f().e();
            }
        }
    }

    @Override // d.a.n0.h0.b
    public String b() {
        return "showH5Dialog";
    }
}
