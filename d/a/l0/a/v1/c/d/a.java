package d.a.l0.a.v1.c.d;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import d.a.l0.a.k;
import d.a.l0.a.v1.c.c;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48983a = k.f46875a;

    public static void a(Message message) {
        Bundle bundle;
        if (f48983a) {
            Log.e("ChannelMsgProcessor", "MSG_TYPE_CS_DELEGATION");
        }
        int i2 = message.arg1;
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
        d.a.l0.a.v1.a.a.b.a(i2, str2, str, bundle);
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
        d.a.l0.a.v1.a.a.b.a(-1000, str2, str, bundle);
    }

    public static void c(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            if (f48983a) {
                throw new RuntimeException("delegation msg obj is not a bundle");
            }
            return;
        }
        Bundle bundle = (Bundle) obj;
        d.a.l0.a.v1.a.b.a.b bVar = new d.a.l0.a.v1.a.b.a.b(bundle.getString("key_observer_id", ""));
        bVar.b(bundle.getBundle("key_result_data"));
        d.a.l0.a.v1.a.b.b.a.b().c(bVar);
    }

    public static void d(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            if (f48983a) {
                throw new RuntimeException("delegation msg obj is not a bundle");
            }
            return;
        }
        Bundle bundle = (Bundle) obj;
        d.a.l0.a.v1.a.b.a.b bVar = new d.a.l0.a.v1.a.b.a.b(bundle.getString("key_observer_id", ""));
        bVar.b(bundle.getBundle("key_result_data"));
        d.a.l0.a.v1.a.b.b.a.b().c(bVar);
    }

    public static void e(int i2, Bundle bundle) {
        d.a.l0.a.v1.c.a e2 = d.a.l0.a.v1.c.a.e();
        c cVar = new c(126, bundle);
        cVar.a(i2);
        e2.h(cVar);
    }

    public static void f(Bundle bundle) {
        d.a.l0.a.v1.c.a.e().h(new c(21, bundle));
    }
}
