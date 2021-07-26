package d.a.o0.a.n0.j.d;

import android.text.TextUtils;
import android.util.Pair;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.t.j;
import java.io.File;
/* loaded from: classes7.dex */
public class e implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String[] f46757a;

    /* renamed from: b  reason: collision with root package name */
    public final Pair<String, String>[] f46758b;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46757a = new String[]{"searchbox_webapps_sp", "swan_app_pms_sp", "key_pms_sp_name", "swan_config_sp_name", "swan_clean_stratey", "swan_preload_package", "updatecore_node_ceres", "updatecore_node_host", "swan_host_info_config_sp_name", "updatecore_node_tipmsgs", "swan_launch_tips_config_sp_name", "aiapps_favorite", "searchbox_sconsole_sp", "swan_about_page_sp", "aiapps_guide_dialog_sp", "swan.publisher", "sp_launch_behavior", "swan_app_debug", "swan_debug_feature", "light_info_debug", "swan_method_trace"};
        this.f46758b = new Pair[]{new Pair<>("aiapp_", ""), new Pair<>("aiapp_setting_", ""), new Pair<>("", "_domain_config")};
    }

    @Override // d.a.o0.a.n0.j.d.a
    public ArraySet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            arraySet.addAll((ArraySet<? extends String>) d());
            arraySet.addAll((ArraySet<? extends String>) c());
            arraySet.addAll((ArraySet<? extends String>) b());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    public final ArraySet<String> b() {
        InterceptResult invokeV;
        Pair<String, String>[] pairArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            File file = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/");
            File file2 = new File(j.e());
            ArraySet<String> arraySet = new ArraySet<>();
            for (Pair<String, String> pair : this.f46758b) {
                arraySet.addAll((ArraySet<? extends String>) d.a.o0.a.n0.e.e(file, (String) pair.first, ((String) pair.second) + "shared_prefs/", null, true));
                arraySet.addAll((ArraySet<? extends String>) d.a.o0.a.n0.e.e(file2, (String) pair.first, ((String) pair.second) + ".kv", null, true));
            }
            d.a.o0.a.e0.d.h("SwanSpCollector", "recovery renameAppsSp:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    public final ArraySet<String> c() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            File file = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/");
            String e2 = j.e();
            ArraySet<String> arraySet = new ArraySet<>();
            for (String str : this.f46757a) {
                String I = d.a.o0.t.d.I(new File(e2, str + ".kv"));
                if (!TextUtils.isEmpty(I)) {
                    arraySet.add(I);
                }
                String I2 = d.a.o0.t.d.I(new File(file, str + ActivityChooserModel.HISTORY_FILE_EXTENSION));
                if (!TextUtils.isEmpty(I2)) {
                    arraySet.add(I2);
                }
            }
            d.a.o0.a.e0.d.h("SwanSpCollector", "recovery renameFrameSp:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    public final ArraySet<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            String I = d.a.o0.t.d.I(new File(d.a.o0.a.k2.h.c.A()));
            if (!TextUtils.isEmpty(I)) {
                arraySet.add(I);
            }
            d.a.o0.a.e0.d.h("SwanSpCollector", "recovery renameSwanKVRoot:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }
}
