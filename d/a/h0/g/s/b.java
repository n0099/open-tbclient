package d.a.h0.g.s;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.i.b f46778a;

    public b(d.a.h0.g.i.b bVar) {
        this.f46778a = bVar;
    }

    public final void a(String str, String str2) {
        d.a.h0.g.i.b bVar = this.f46778a;
        if (bVar == null || bVar.o() == null || !this.f46778a.o().hasEventListener(str2)) {
            return;
        }
        d.a.h0.g.s.d.a aVar = new d.a.h0.g.s.d.a();
        aVar.value = str;
        JSEvent jSEvent = new JSEvent(str2);
        jSEvent.data = aVar;
        this.f46778a.o().dispatchEvent(jSEvent);
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
