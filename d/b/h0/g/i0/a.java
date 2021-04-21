package d.b.h0.g.i0;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
/* loaded from: classes3.dex */
public class a {
    public static void a(SwanAppActivity swanAppActivity) {
        Intent intent;
        if (swanAppActivity == null || (intent = swanAppActivity.getIntent()) == null) {
            return;
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
        d.b.h0.a.r1.d.e().m(new String[0]);
        bundle.remove("pms_db_info_onload");
        bundle.remove("pms_db_info_updated");
        bundle.putString("launch_id", SwanLauncher.h());
        d.b.h0.a.r1.d.e().j(bundle, "update_tag_by_activity_on_relaunch");
    }
}
