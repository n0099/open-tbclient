package com.repackage;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.repackage.wz2;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public interface vz2 {
    public static final Set<String> e0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(wz2.a aVar);

    c23 B();

    boolean E();

    void G();

    String getAppId();

    int l();

    void m(Bundle bundle, String str);

    SwanAppCores n();

    String o(String... strArr);

    void p(le3<wz2.a> le3Var);

    void q(String str);

    sz2 r();

    void s(SwanAppActivity swanAppActivity);

    void t();

    void u(SwanAppActivity swanAppActivity);

    void v(le3<wz2.a> le3Var);

    void w(String str, Bundle bundle);

    SwanAppActivity x();

    vg1 y();

    nw2 z();
}
