package d.b.g0.g.s;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.b f48954a;

    public b(d.b.g0.g.i.b bVar) {
        this.f48954a = bVar;
    }

    public final void a(String str, String str2) {
        d.b.g0.g.i.b bVar = this.f48954a;
        if (bVar == null || bVar.t() == null || !this.f48954a.t().hasEventListener(str2)) {
            return;
        }
        d.b.g0.g.s.d.a aVar = new d.b.g0.g.s.d.a();
        aVar.value = str;
        JSEvent jSEvent = new JSEvent(str2);
        jSEvent.data = aVar;
        this.f48954a.t().dispatchEvent(jSEvent);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        a(str, "keyboardcomplete");
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        a(str, "keyboardconfirm");
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        a(str, "keyboardinput");
    }
}
