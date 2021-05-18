package d.a.i0.h.u;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.l0.c f47520a;

    public b(d.a.i0.a.l0.c cVar) {
        this.f47520a = cVar;
    }

    public final void a(String str, String str2) {
        d.a.i0.a.l0.c cVar = this.f47520a;
        if (cVar == null || cVar.p() == null || !this.f47520a.p().hasEventListener(str2)) {
            return;
        }
        d.a.i0.h.u.d.a aVar = new d.a.i0.h.u.d.a();
        aVar.value = str;
        JSEvent jSEvent = new JSEvent(str2);
        jSEvent.data = aVar;
        this.f47520a.p().dispatchEvent(jSEvent);
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
