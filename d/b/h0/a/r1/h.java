package d.b.h0.a.r1;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import d.b.h0.a.r1.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public interface h {
    public static final Set<String> I0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    String getAppId();

    int h();

    void i(d.b.h0.a.i2.u0.b<i.a> bVar);

    void j(Bundle bundle, String str);

    SwanAppCores k();

    void l(String str, Bundle bundle);

    String m(String... strArr);

    SwanAppActivity n();

    d.b.h0.a.p.a o();

    void p(d.b.h0.a.i2.u0.b<i.a> bVar);

    d.b.h0.a.n1.c.e.a q();

    void r(String str);

    e s();

    void t(i.a aVar);

    void u(SwanAppActivity swanAppActivity);

    void v();

    void w(SwanAppActivity swanAppActivity);

    boolean x();
}
