package com.repackage;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.repackage.l03;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public interface k03 {
    public static final Set<String> e0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(l03.a aVar);

    r23 B();

    boolean E();

    void G();

    String getAppId();

    int k();

    void l(Bundle bundle, String str);

    SwanAppCores m();

    String n(String... strArr);

    void o(af3<l03.a> af3Var);

    void p(String str);

    h03 q();

    void r(SwanAppActivity swanAppActivity);

    void s();

    void t(SwanAppActivity swanAppActivity);

    void u(af3<l03.a> af3Var);

    void v(String str, Bundle bundle);

    SwanAppActivity w();

    kh1 x();

    cx2 y();
}
