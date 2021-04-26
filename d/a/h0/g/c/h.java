package d.a.h0.g.c;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46148a = k.f43101a;

    public h(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null) {
            a(F, false, b("internal error"));
            return;
        }
        try {
            boolean n = F.n("mixWithOther", false);
            h2.H().h("key_audio_is_mix_with_other", Boolean.valueOf(n));
            if (f46148a) {
                Log.d("InnerAudioOptionApi", "Audio Mix Changed to " + n);
            }
            a(F, true, "setInnerAudioOption:ok");
        } catch (Exception unused) {
            d.a.h0.a.c0.c.b("InnerAudioOptionApi", "set swanApp global var error");
            a(F, false, b("internal error"));
        }
    }

    public final void a(d.a.h0.g.e.d.c cVar, boolean z, String str) {
        d.a.h0.g.e.d.b bVar = new d.a.h0.g.e.d.b();
        bVar.errMsg = str;
        d.a.h0.g.i0.b.a(cVar, z, bVar);
    }

    public final String b(String str) {
        return String.format("setInnerAudioOption:fail %s", str);
    }
}
