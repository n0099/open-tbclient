package d.b.h0.g.s;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g.i.b f49283a;

    public b(d.b.h0.g.i.b bVar) {
        this.f49283a = bVar;
    }

    public final void a(String str, String str2) {
        d.b.h0.g.i.b bVar = this.f49283a;
        if (bVar == null || bVar.t() == null || !this.f49283a.t().hasEventListener(str2)) {
            return;
        }
        d.b.h0.g.s.d.a aVar = new d.b.h0.g.s.d.a();
        aVar.value = str;
        JSEvent jSEvent = new JSEvent(str2);
        jSEvent.data = aVar;
        this.f49283a.t().dispatchEvent(jSEvent);
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
