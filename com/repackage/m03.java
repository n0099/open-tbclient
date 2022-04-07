package com.repackage;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.repackage.n03;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public interface m03 {
    public static final Set<String> e0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(n03.a aVar);

    t23 B();

    boolean D();

    void F();

    String getAppId();

    int l();

    void m(Bundle bundle, String str);

    SwanAppCores n();

    String o(String... strArr);

    void p(cf3<n03.a> cf3Var);

    void q(String str);

    j03 r();

    void s(SwanAppActivity swanAppActivity);

    void t();

    void u(SwanAppActivity swanAppActivity);

    void v(cf3<n03.a> cf3Var);

    void w(String str, Bundle bundle);

    SwanAppActivity x();

    mh1 y();

    ex2 z();
}
