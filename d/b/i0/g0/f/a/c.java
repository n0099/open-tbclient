package d.b.i0.g0.f.a;

import android.webkit.JsPromptResult;
/* loaded from: classes4.dex */
public class c implements d.b.i0.g0.b {
    @Override // d.b.i0.g0.b
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        if (b().equals(str)) {
            try {
                d.b.i0.g0.a.f().i(str2, str3);
            } catch (Throwable unused) {
                d.b.i0.g0.a.f().e();
            }
        }
    }

    @Override // d.b.i0.g0.b
    public String b() {
        return "showNativeDialog";
    }
}
