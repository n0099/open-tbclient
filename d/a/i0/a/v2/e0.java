package d.a.i0.a.v2;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
/* loaded from: classes3.dex */
public class e0 {
    public static void a(SwanAppActivity swanAppActivity) {
        Intent intent;
        if (swanAppActivity == null || (intent = swanAppActivity.getIntent()) == null) {
            return;
        }
        if (d.a.i0.a.u1.a.a.C()) {
            d.a.i0.a.e0.f.d.f.k().s();
        }
        Bundle bundle = new Bundle();
        bundle.putAll(intent.getExtras());
        bundle.putBoolean("should_ignore_launch_time", true);
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 == null) {
            bundle2 = new Bundle();
            bundle.putBundle("mExtraData", bundle2);
        }
        bundle2.putLong("launch_flag_for_statistic", System.currentTimeMillis());
        bundle2.putLong("page_display_flag_for_statistic", System.currentTimeMillis());
        d.a.i0.a.a2.d.g().o(new String[0]);
        bundle.remove("pms_db_info_onload");
        bundle.remove("pms_db_info_updated");
        bundle.remove("mPage");
        bundle.putString("launch_id", SwanLauncher.h());
        d.a.i0.a.a2.d.g().m(bundle, "update_tag_by_activity_on_relaunch");
    }
}
