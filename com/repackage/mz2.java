package com.repackage;

import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.optimization.quotasaver.QuotaSaver;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import com.kwad.v8.NodeJS;
import com.repackage.lz2;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class mz2 extends gz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile hz2 l;
    public final cw2 m;
    public SwanAppActivity n;
    public boolean o;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(mz2 mz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (mz2.p) {
                    Log.w("SwanImpl", "kill process myself");
                }
                Process.killProcess(Process.myPid());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755482068, "Lcom/repackage/mz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755482068, "Lcom/repackage/mz2;");
                return;
            }
        }
        p = rf1.a;
    }

    public mz2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = new cw2(this);
        this.o = false;
    }

    public static String S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.equals(jSONObject.optString("token"), "swanubc")) {
                    return jSONObject.toString();
                }
            } catch (JSONException e) {
                if (p) {
                    e.printStackTrace();
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.kz2
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? r().D() : invokeV.booleanValue;
    }

    @Override // com.repackage.kz2
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            o("flag_finish_activity", "flag_remove_task");
            bd3.a0(new a(this));
        }
    }

    @Override // com.repackage.gz2
    public o84 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new s22(this) : (o84) invokeV.objValue;
    }

    @Override // com.repackage.gz2
    public r13 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new s13(this) : (r13) invokeV.objValue;
    }

    @Override // com.repackage.gz2
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            QuotaSaver.l.n(this);
        }
    }

    public final boolean T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? kz2.e0.contains(str) : invokeL.booleanValue;
    }

    public final boolean U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? TextUtils.equals("update_tag_by_app_launch", str) : invokeL.booleanValue;
    }

    public final boolean V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals("update_tag_by_prefetch", str) : invokeL.booleanValue;
    }

    public final void W(@NonNull Bundle bundle, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = bundle.getLong("launch_time");
            long j2 = currentTimeMillis - j;
            long millis = TimeUnit.SECONDS.toMillis(10L);
            boolean z2 = false;
            z2 = (bundle.getBoolean("should_ignore_launch_time", false) || j <= 1 || j2 > millis) ? true : true;
            if (z2) {
                bundle.putLong("launch_time", currentTimeMillis);
                j = currentTimeMillis;
            }
            long j3 = bundle.getLong("start_activity_time");
            if (z2 || j3 < 1) {
                j3 = j;
            }
            long j4 = bundle.getLong("receive_launch_intent_time");
            long j5 = (z2 || j4 < 1) ? j3 : j4;
            HybridUbcFlow p2 = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("naStart");
            ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent.h(j);
            p2.F(ubcFlowEvent);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_last_start");
            ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent2.h(j);
            p2.F(ubcFlowEvent2);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("na_launch_activity");
            ubcFlowEvent3.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent3.h(j3);
            p2.F(ubcFlowEvent3);
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("na_receive_intent");
            ubcFlowEvent4.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent4.h(j5);
            p2.F(ubcFlowEvent4);
            p2.D("process", String.valueOf(SwanAppProcessInfo.current()));
            p2.D("reuse", z ? "1" : "0");
            long j6 = bundle.getLong("veloce_start_time", 0L);
            if (j6 > 0) {
                UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("na_veloce_start");
                ubcFlowEvent5.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                ubcFlowEvent5.h(j6);
                p2.F(ubcFlowEvent5);
            }
            long j7 = bundle.getLong("t7_loading_start", -1L);
            int i = (j7 > 0L ? 1 : (j7 == 0L ? 0 : -1));
            if (i > 0) {
                UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("na_t7_load_start");
                ubcFlowEvent6.h(j7);
                p2.F(ubcFlowEvent6);
            }
            long j8 = bundle.getLong("t7_loading_end", -1L);
            if (i > 0) {
                UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("na_t7_load_end");
                ubcFlowEvent7.h(j8);
                p2.F(ubcFlowEvent7);
            }
            Bundle bundle2 = bundle.getBundle("mExtraData");
            if (bundle2 != null) {
                String S = S(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
                if (!TextUtils.isEmpty(S)) {
                    p2.D(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, S);
                }
                p2.D("abtest", bundle2.getString("aiapp_abtest_info", ""));
                long j9 = bundle2.getLong("click_time", -1L);
                if (j9 > 0) {
                    HybridUbcFlow p3 = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
                    UbcFlowEvent ubcFlowEvent8 = new UbcFlowEvent("user_action");
                    ubcFlowEvent8.h(j9);
                    p3.F(ubcFlowEvent8);
                }
            }
            ms2.n();
            this.l.V().G1(j3);
            this.l.V().B0(j3);
            us2.j().b(j);
            bu2.g().e("updateLaunchInfo");
            d63.d();
            long j10 = bundle.getLong("launch_flag_for_statistic");
            long j11 = bundle.getLong("page_display_flag_for_statistic");
            if (j10 < 1 || j11 < 1 || currentTimeMillis - j10 > millis || currentTimeMillis - j11 > millis) {
                bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
                bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
            }
        }
    }

    @Override // com.repackage.kz2
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l == null ? "" : this.l.getAppId() : (String) invokeV.objValue;
    }

    @Override // com.repackage.kz2
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? r().l() : invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072 A[Catch: all -> 0x01aa, TryCatch #0 {, blocks: (B:6:0x000b, B:10:0x0013, B:12:0x005a, B:14:0x0060, B:22:0x0072, B:23:0x008d, B:25:0x0093, B:28:0x009b, B:30:0x00a7, B:32:0x00b1, B:34:0x00b7, B:36:0x00bd, B:37:0x00c0, B:41:0x00d3, B:43:0x00d9, B:44:0x00dd, B:46:0x00ef, B:49:0x00f7, B:50:0x00fd, B:52:0x0111, B:55:0x0127, B:56:0x0137, B:58:0x013b, B:63:0x0147, B:65:0x015f, B:69:0x016a, B:71:0x017b, B:74:0x0184, B:76:0x018e, B:77:0x019e, B:17:0x0067), top: B:86:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x016a A[Catch: all -> 0x01aa, TryCatch #0 {, blocks: (B:6:0x000b, B:10:0x0013, B:12:0x005a, B:14:0x0060, B:22:0x0072, B:23:0x008d, B:25:0x0093, B:28:0x009b, B:30:0x00a7, B:32:0x00b1, B:34:0x00b7, B:36:0x00bd, B:37:0x00c0, B:41:0x00d3, B:43:0x00d9, B:44:0x00dd, B:46:0x00ef, B:49:0x00f7, B:50:0x00fd, B:52:0x0111, B:55:0x0127, B:56:0x0137, B:58:0x013b, B:63:0x0147, B:65:0x015f, B:69:0x016a, B:71:0x017b, B:74:0x0184, B:76:0x018e, B:77:0x019e, B:17:0x0067), top: B:86:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017b A[Catch: all -> 0x01aa, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x000b, B:10:0x0013, B:12:0x005a, B:14:0x0060, B:22:0x0072, B:23:0x008d, B:25:0x0093, B:28:0x009b, B:30:0x00a7, B:32:0x00b1, B:34:0x00b7, B:36:0x00bd, B:37:0x00c0, B:41:0x00d3, B:43:0x00d9, B:44:0x00dd, B:46:0x00ef, B:49:0x00f7, B:50:0x00fd, B:52:0x0111, B:55:0x0127, B:56:0x0137, B:58:0x013b, B:63:0x0147, B:65:0x015f, B:69:0x016a, B:71:0x017b, B:74:0x0184, B:76:0x018e, B:77:0x019e, B:17:0x0067), top: B:86:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x018e A[Catch: all -> 0x01aa, TryCatch #0 {, blocks: (B:6:0x000b, B:10:0x0013, B:12:0x005a, B:14:0x0060, B:22:0x0072, B:23:0x008d, B:25:0x0093, B:28:0x009b, B:30:0x00a7, B:32:0x00b1, B:34:0x00b7, B:36:0x00bd, B:37:0x00c0, B:41:0x00d3, B:43:0x00d9, B:44:0x00dd, B:46:0x00ef, B:49:0x00f7, B:50:0x00fd, B:52:0x0111, B:55:0x0127, B:56:0x0137, B:58:0x013b, B:63:0x0147, B:65:0x015f, B:69:0x016a, B:71:0x017b, B:74:0x0184, B:76:0x018e, B:77:0x019e, B:17:0x0067), top: B:86:0x000b }] */
    @Override // com.repackage.kz2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m(Bundle bundle, String str) {
        boolean z;
        long j;
        long j2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean C0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, bundle, str) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                if (bundle == null) {
                    return;
                }
                String string = bundle.getString("mAppId");
                hw1.k("SwanImpl", "updateSwanApp updateTag:" + str + ",old appId:" + getAppId() + ",new appId:" + string);
                String string2 = bundle.getString("launch_id");
                ht2.update(string2);
                HybridUbcFlow p2 = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
                boolean z5 = false;
                if (!jt2.b() ? p2.N(string2) : p2.u() && p2.N(string2)) {
                    z = false;
                    if (z) {
                        ms2.r(NodeJS.STARTUP_SCRIPT_NAME);
                        p2 = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("resetFlow");
                        ubcFlowEvent.a(true);
                        p2.F(ubcFlowEvent);
                        p2.N(string2);
                    }
                    if (!V(str) && !U(str)) {
                        boolean T = T(str);
                        if (!TextUtils.isEmpty(string) || (TextUtils.equals(string, getAppId()) && !yw1.d())) {
                            j = 0;
                            j2 = 0;
                            z2 = false;
                            z3 = false;
                        } else {
                            if (yw1.d()) {
                                yw1.e(str);
                            }
                            j = System.currentTimeMillis();
                            boolean z6 = !TextUtils.isEmpty(o(new String[0]));
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (z6) {
                                z53.d(3);
                            }
                            this.l = new hz2(this, string);
                            z2 = z6;
                            j2 = currentTimeMillis2;
                            T = true;
                            z3 = true;
                        }
                        if (D()) {
                            if (T) {
                                SwanLauncher.g(bundle);
                                W(bundle, z2);
                            }
                            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_start");
                            ubcFlowEvent2.h(currentTimeMillis);
                            ubcFlowEvent2.a(true);
                            p2.F(ubcFlowEvent2);
                            if (j > 0) {
                                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_update_reset_start");
                                ubcFlowEvent3.h(j);
                                ubcFlowEvent3.a(true);
                                p2.F(ubcFlowEvent3);
                            }
                            long j3 = j2;
                            if (j3 > 0) {
                                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_update_reset_ok");
                                ubcFlowEvent4.h(j3);
                                ubcFlowEvent4.a(true);
                                p2.F(ubcFlowEvent4);
                            }
                            hz2 hz2Var = this.l;
                            if (!z3 && this.l.H()) {
                                z4 = false;
                                C0 = hz2Var.C0(bundle, str, z4);
                                this.l.H0(str);
                                UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("swan_app_update_end");
                                ubcFlowEvent5.a(true);
                                p2.F(ubcFlowEvent5);
                                if (!C0 && this.l.H()) {
                                    z5 = true;
                                }
                                if (z5) {
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("app_update_tag", str);
                                    w("event_on_app_updated", bundle2);
                                }
                            }
                            z4 = true;
                            C0 = hz2Var.C0(bundle, str, z4);
                            this.l.H0(str);
                            UbcFlowEvent ubcFlowEvent52 = new UbcFlowEvent("swan_app_update_end");
                            ubcFlowEvent52.a(true);
                            p2.F(ubcFlowEvent52);
                            if (!C0) {
                                z5 = true;
                            }
                            if (z5) {
                            }
                        }
                        if (z3) {
                            b62.U().P(z2);
                        }
                        return;
                    }
                    if (!TextUtils.equals(string, getAppId())) {
                        o("flag_not_unregister");
                        this.l = new hz2(this, string);
                    }
                    this.l.J0(bundle);
                    this.l.H0(str);
                }
                z = true;
                if (z) {
                }
                if (!V(str)) {
                    boolean T2 = T(str);
                    if (TextUtils.isEmpty(string)) {
                    }
                    j = 0;
                    j2 = 0;
                    z2 = false;
                    z3 = false;
                    if (D()) {
                    }
                    if (z3) {
                    }
                    return;
                }
                if (!TextUtils.equals(string, getAppId())) {
                }
                this.l.J0(bundle);
                this.l.H0(str);
            }
        }
    }

    @Override // com.repackage.kz2
    public SwanAppCores n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? r().n() : (SwanAppCores) invokeV.objValue;
    }

    @Override // com.repackage.kz2
    public synchronized String o(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, strArr)) == null) {
            synchronized (this) {
                if (this.o) {
                    return "";
                }
                this.o = true;
                String str = "";
                if (this.l != null && this.l.D()) {
                    str = this.l.B0(strArr);
                    this.l = null;
                    A((lz2.a) new lz2.a("event_on_app_reseted").A("event_params_reset_flags", strArr));
                    if (strArr == null || !Sets.newHashSet(strArr).contains("flag_not_unregister")) {
                        xv2.e().h(new zv2(2));
                    }
                }
                this.o = false;
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.kz2
    @NonNull
    public hz2 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.l == null) {
                synchronized (this) {
                    if (this.l == null) {
                        this.l = new hz2(this, "");
                    }
                }
            }
            return this.l;
        }
        return (hz2) invokeV.objValue;
    }

    @Override // com.repackage.kz2
    public void s(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, swanAppActivity) == null) {
            this.n = null;
        }
    }

    @Override // com.repackage.kz2
    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.l != null && this.l.D()) {
            this.l.t();
            F();
        }
    }

    @Override // com.repackage.kz2
    public void u(SwanAppActivity swanAppActivity) {
        SwanAppActivity swanAppActivity2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, swanAppActivity) == null) || swanAppActivity == null || (swanAppActivity2 = this.n) == swanAppActivity) {
            return;
        }
        if (swanAppActivity2 != null) {
            s(swanAppActivity2);
        }
        this.n = swanAppActivity;
    }

    @Override // com.repackage.kz2
    public SwanAppActivity x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.n : (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.repackage.kz2
    @Nullable
    public cw2 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.m : (cw2) invokeV.objValue;
    }
}
