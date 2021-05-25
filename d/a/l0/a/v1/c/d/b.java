package d.a.l0.a.v1.c.d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.l0.a.k;
import d.a.l0.a.v1.c.f.c;
import d.a.l0.a.v1.c.f.e;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45310a = k.f43199a;

    public static void a(@Nullable Bundle bundle, @NonNull Class<? extends d.a.l0.a.v1.a.a.a> cls) {
        Iterator<c> it = e.k().q().iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.H()) {
                b(next.f45331f, bundle, cls, null);
            }
        }
    }

    public static void b(SwanAppProcessInfo swanAppProcessInfo, @Nullable Bundle bundle, @NonNull Class<? extends d.a.l0.a.v1.a.a.a> cls, @Nullable d.a.l0.a.v1.a.b.c.c cVar) {
        if (f45310a) {
            Log.d("SwanAppMessageChannel", "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 125);
        obtain.replyTo = e.k().f45342d;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.b());
            d.a.l0.a.v1.a.b.b.a.b().e(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        obtain.obj = bundle2;
        d.a.l0.a.v1.c.a e2 = d.a.l0.a.v1.c.a.e();
        d.a.l0.a.v1.c.c cVar2 = new d.a.l0.a.v1.c.c(obtain);
        cVar2.b(swanAppProcessInfo);
        e2.h(cVar2);
    }

    public static void c(@Nullable Bundle bundle, @NonNull Class<? extends d.a.l0.a.v1.a.a.a> cls, @Nullable d.a.l0.a.v1.a.b.c.c cVar) {
        d.a.l0.a.v1.c.e.a.E().L(bundle, cls, cVar);
    }
}
