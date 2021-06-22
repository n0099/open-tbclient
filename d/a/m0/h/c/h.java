package d.a.m0.h.c;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50984a = k.f46983a;

    public h(JsObject jsObject) {
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null) {
            a(G, false, b("internal error"));
            return;
        }
        try {
            boolean n = G.n("mixWithOther", false);
            i2.J().h("key_audio_is_mix_with_other", Boolean.valueOf(n));
            if (f50984a) {
                Log.d("InnerAudioOptionApi", "Audio Mix Changed to " + n);
            }
            a(G, true, "setInnerAudioOption:ok");
        } catch (Exception unused) {
            d.a.m0.a.e0.d.b("InnerAudioOptionApi", "set swanApp global var error");
            a(G, false, b("internal error"));
        }
    }

    public final void a(d.a.m0.a.y.b.a aVar, boolean z, String str) {
        d.a.m0.h.d.c.b bVar = new d.a.m0.h.d.c.b();
        bVar.errMsg = str;
        d.a.m0.h.m0.c.a(aVar, z, bVar);
    }

    public final String b(String str) {
        return String.format("setInnerAudioOption:fail %s", str);
    }
}
