package d.a.o0.a.a2;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import d.a.o0.a.a2.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public interface h {
    public static final Set<String> g0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(i.a aVar);

    d.a.o0.a.c2.f.g0.a B();

    boolean C();

    String getAppId();

    int l();

    void m(Bundle bundle, String str);

    SwanAppCores n();

    String o(String... strArr);

    void p(d.a.o0.a.v2.e1.b<i.a> bVar);

    void q(String str);

    e r();

    void s(SwanAppActivity swanAppActivity);

    void t();

    void u(SwanAppActivity swanAppActivity);

    void v(d.a.o0.a.v2.e1.b<i.a> bVar);

    void w(String str, Bundle bundle);

    SwanAppActivity x();

    d.a.o0.a.p.a y();

    d.a.o0.a.v1.c.e.a z();
}
