package d.b.g0.a.n1.c.d;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import d.b.g0.a.k;
import d.b.g0.a.n1.c.c;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45765a = k.f45443a;

    public static void a(Message message) {
        Bundle bundle;
        if (f45765a) {
            Log.e("ChannelMsgProcessor", "MSG_TYPE_CS_DELEGATION");
        }
        int i = message.arg1;
        Bundle bundle2 = (Bundle) message.obj;
        String str = "";
        String str2 = null;
        if (bundle2 != null) {
            str2 = bundle2.getString("ai_apps_delegation_name", null);
            str = bundle2.getString("ai_apps_observer_id", "");
            bundle = bundle2.getBundle("ai_apps_data");
        } else {
            bundle = null;
        }
        d.b.g0.a.n1.a.a.b.a(i, str2, str, bundle);
    }

    public static void b(Message message) {
        Bundle bundle;
        Bundle bundle2 = (Bundle) message.obj;
        String str = "";
        String str2 = null;
        if (bundle2 != null) {
            str2 = bundle2.getString("ai_apps_delegation_name", null);
            str = bundle2.getString("ai_apps_observer_id", "");
            bundle = bundle2.getBundle("ai_apps_data");
        } else {
            bundle = null;
        }
        d.b.g0.a.n1.a.a.b.a(-1000, str2, str, bundle);
    }

    public static void c(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            if (f45765a) {
                throw new RuntimeException("delegation msg obj is not a bundle");
            }
            return;
        }
        Bundle bundle = (Bundle) obj;
        d.b.g0.a.n1.a.b.a.b bVar = new d.b.g0.a.n1.a.b.a.b(bundle.getString("key_observer_id", ""));
        bVar.b(bundle.getBundle("key_result_data"));
        d.b.g0.a.n1.a.b.b.a.b().c(bVar);
    }

    public static void d(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            if (f45765a) {
                throw new RuntimeException("delegation msg obj is not a bundle");
            }
            return;
        }
        Bundle bundle = (Bundle) obj;
        d.b.g0.a.n1.a.b.a.b bVar = new d.b.g0.a.n1.a.b.a.b(bundle.getString("key_observer_id", ""));
        bVar.b(bundle.getBundle("key_result_data"));
        d.b.g0.a.n1.a.b.b.a.b().c(bVar);
    }

    public static void e(int i, Bundle bundle) {
        d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
        c cVar = new c(126, bundle);
        cVar.a(i);
        e2.h(cVar);
    }

    public static void f(Bundle bundle) {
        d.b.g0.a.n1.c.a.e().h(new c(21, bundle));
    }
}
