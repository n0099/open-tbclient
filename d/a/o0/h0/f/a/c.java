package d.a.o0.h0.f.a;

import android.webkit.JsPromptResult;
/* loaded from: classes4.dex */
public class c implements d.a.o0.h0.b {
    @Override // d.a.o0.h0.b
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        if (b().equals(str)) {
            try {
                d.a.o0.h0.a.f().i(str2, str3);
            } catch (Throwable unused) {
                d.a.o0.h0.a.f().e();
            }
        }
    }

    @Override // d.a.o0.h0.b
    public String b() {
        return "showNativeDialog";
    }
}
