package d.a.l0.a.n0.j.d;

import android.text.TextUtils;
import android.util.Pair;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.collection.ArraySet;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.t.j;
import java.io.File;
/* loaded from: classes3.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f47297a = {"searchbox_webapps_sp", "swan_app_pms_sp", "key_pms_sp_name", "swan_config_sp_name", "swan_clean_stratey", "swan_preload_package", "updatecore_node_ceres", "updatecore_node_host", "swan_host_info_config_sp_name", "updatecore_node_tipmsgs", "swan_launch_tips_config_sp_name", "aiapps_favorite", "searchbox_sconsole_sp", "swan_about_page_sp", "aiapps_guide_dialog_sp", "swan.publisher", "sp_launch_behavior", "swan_app_debug", "swan_debug_feature", "light_info_debug", "swan_method_trace"};

    /* renamed from: b  reason: collision with root package name */
    public final Pair<String, String>[] f47298b = {new Pair<>("aiapp_", ""), new Pair<>("aiapp_setting_", ""), new Pair<>("", "_domain_config")};

    @Override // d.a.l0.a.n0.j.d.a
    public ArraySet<String> a() {
        ArraySet<String> arraySet = new ArraySet<>();
        arraySet.addAll((ArraySet<? extends String>) d());
        arraySet.addAll((ArraySet<? extends String>) c());
        arraySet.addAll((ArraySet<? extends String>) b());
        return arraySet;
    }

    public final ArraySet<String> b() {
        Pair<String, String>[] pairArr;
        File file = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/");
        File file2 = new File(j.e());
        ArraySet<String> arraySet = new ArraySet<>();
        for (Pair<String, String> pair : this.f47298b) {
            arraySet.addAll((ArraySet<? extends String>) d.a.l0.a.n0.e.e(file, (String) pair.first, ((String) pair.second) + "shared_prefs/", null, true));
            arraySet.addAll((ArraySet<? extends String>) d.a.l0.a.n0.e.e(file2, (String) pair.first, ((String) pair.second) + ".kv", null, true));
        }
        d.a.l0.a.e0.d.h("SwanSpCollector", "recovery renameAppsSp:" + arraySet.toString());
        return arraySet;
    }

    public final ArraySet<String> c() {
        String[] strArr;
        File file = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/");
        String e2 = j.e();
        ArraySet<String> arraySet = new ArraySet<>();
        for (String str : this.f47297a) {
            String I = d.a.l0.t.d.I(new File(e2, str + ".kv"));
            if (!TextUtils.isEmpty(I)) {
                arraySet.add(I);
            }
            String I2 = d.a.l0.t.d.I(new File(file, str + ActivityChooserModel.HISTORY_FILE_EXTENSION));
            if (!TextUtils.isEmpty(I2)) {
                arraySet.add(I2);
            }
        }
        d.a.l0.a.e0.d.h("SwanSpCollector", "recovery renameFrameSp:" + arraySet.toString());
        return arraySet;
    }

    public final ArraySet<String> d() {
        ArraySet<String> arraySet = new ArraySet<>();
        String I = d.a.l0.t.d.I(new File(d.a.l0.a.k2.h.c.A()));
        if (!TextUtils.isEmpty(I)) {
            arraySet.add(I);
        }
        d.a.l0.a.e0.d.h("SwanSpCollector", "recovery renameSwanKVRoot:" + arraySet.toString());
        return arraySet;
    }
}
