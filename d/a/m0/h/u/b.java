package d.a.m0.h.u;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.l0.c f51478a;

    public b(d.a.m0.a.l0.c cVar) {
        this.f51478a = cVar;
    }

    public final void a(String str, String str2) {
        d.a.m0.a.l0.c cVar = this.f51478a;
        if (cVar == null || cVar.p() == null || !this.f51478a.p().hasEventListener(str2)) {
            return;
        }
        d.a.m0.h.u.d.a aVar = new d.a.m0.h.u.d.a();
        aVar.value = str;
        JSEvent jSEvent = new JSEvent(str2);
        jSEvent.data = aVar;
        this.f51478a.p().dispatchEvent(jSEvent);
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
