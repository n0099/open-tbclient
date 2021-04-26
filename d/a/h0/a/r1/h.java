package d.a.h0.a.r1;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import d.a.h0.a.r1.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public interface h {
    public static final Set<String> I0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    String getAppId();

    int j();

    void k(Bundle bundle, String str);

    SwanAppCores l();

    String m(String... strArr);

    void n(d.a.h0.a.i2.u0.b<i.a> bVar);

    void o(String str);

    e p();

    void q(SwanAppActivity swanAppActivity);

    void r();

    void s(SwanAppActivity swanAppActivity);

    void t(d.a.h0.a.i2.u0.b<i.a> bVar);

    void u(String str, Bundle bundle);

    SwanAppActivity v();

    d.a.h0.a.p.a w();

    d.a.h0.a.n1.c.e.a x();

    void y(i.a aVar);

    boolean z();
}
