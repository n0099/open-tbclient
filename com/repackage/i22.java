package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i22 extends h22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean F;
    public transient /* synthetic */ FieldHolder $fh;
    public final hz2 D;
    public final f02 E;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755670424, "Lcom/repackage/i22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755670424, "Lcom/repackage/i22;");
                return;
            }
        }
        F = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i22(hz2 hz2Var) {
        super(hz2Var.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hz2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = hz2Var;
        this.E = new f02();
    }

    public static void I0(ek2 ek2Var, ab3 ab3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, ek2Var, ab3Var) == null) || ek2Var == null) {
            return;
        }
        k63 k63Var = new k63();
        k63Var.a = a63.n(ek2Var.G());
        k63Var.f = ek2Var.H();
        k63Var.c = ek2Var.T();
        k63Var.b = "launch";
        k63Var.e = "success";
        k63Var.a("status", "1");
        if (ab3Var != null) {
            k63Var.a("errcode", String.valueOf(ab3Var.a()));
            k63Var.a("msg", ab3Var.g().toString());
        }
        k63Var.d(ek2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        k63Var.j(ek2Var);
        a63.onEvent(k63Var);
        HybridUbcFlow d = ms2.d(NodeJS.STARTUP_SCRIPT_NAME);
        if (d != null) {
            d.E("value", "na_success");
        }
    }

    @Override // com.repackage.h22, com.repackage.a74
    public void D(z74 z74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z74Var) == null) {
            super.D(z74Var);
            if (F) {
                Log.e("PkgSyncDownloadCallback", "onFetchError: " + z74Var.toString());
            }
            M0(z74Var);
            ab3 ab3Var = new ab3();
            ab3Var.k(10L);
            ab3Var.c(z74Var);
            if (z22.j(z74Var) && oi2.T().a(oi2.c(), this.o, ab3Var)) {
                u0(false, ab3Var);
                I0(this.D.V(), ab3Var);
            } else if (z74Var != null && z74Var.a == 1020) {
                u0(false, ab3Var);
                I0(this.D.V(), ab3Var);
            } else {
                u0(true, ab3Var);
            }
        }
    }

    @Override // com.repackage.h22, com.repackage.a74
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            K0();
            ms2.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("aps_start_req"));
            super.E();
        }
    }

    @Override // com.repackage.h22, com.repackage.a74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            ms2.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("aps_end_req"));
            L0();
        }
    }

    @Override // com.repackage.a74
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.G();
            if (this.n != null) {
                v0();
            }
            ab3 ab3Var = new ab3();
            ab3Var.k(10L);
            ab3Var.i(2901L);
            ab3Var.d("同步获取-> Server无包");
            u0(true, ab3Var);
        }
    }

    @Override // com.repackage.h22, com.repackage.a74
    public void H(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nc4Var) == null) {
            ms2.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("aps_start_download"));
            super.H(nc4Var);
        }
    }

    @Override // com.repackage.a74
    public void I(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            super.I(str, i);
            k84 a = k84.a(str);
            if (a == null) {
                return;
            }
            boolean b = mc4.b(a.c());
            hw1.i("PkgSyncDownloadCallback", "resetCore: " + b + ";statusCode:" + i);
            if (b) {
                xv2 e = xv2.e();
                zv2 zv2Var = new zv2(129);
                zv2Var.f(true);
                e.h(zv2Var);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0017 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // com.repackage.a74
    public void J(String str, String str2, JSONObject jSONObject) {
        String jSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (F) {
            String str3 = 0;
            str3 = 0;
            try {
                try {
                    jSONObject2 = jSONObject.toString(4);
                    str3 = new StringBuilder();
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject2 = jSONObject.toString();
                    str3 = new StringBuilder();
                }
                str3.append("onStatRecord: url:");
                str3.append(str);
                str3.append(" networkStatRecord:\n");
                str3.append(jSONObject2);
                Log.i("PkgSyncDownloadCallback", str3.toString());
            } catch (Throwable th) {
                Log.i("PkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + str3);
                throw th;
            }
        }
        long optLong = jSONObject.optLong("stat_recode_start_time", System.currentTimeMillis());
        long optLong2 = jSONObject.optLong("dnsEndTime", optLong);
        long optLong3 = jSONObject.optLong("dnsStartTime", optLong);
        long optLong4 = jSONObject.optLong("connectedTime", optLong);
        long optLong5 = jSONObject.optLong(FetchLog.START_TIME, optLong);
        HybridUbcFlow p = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("pms_network_start");
        ubcFlowEvent.h(optLong5);
        p.F(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("pms_network_conn");
        ubcFlowEvent2.h(optLong4);
        p.F(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("pms_dns_start");
        ubcFlowEvent3.h(optLong3);
        p.F(ubcFlowEvent3);
        UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("pms_dns_end");
        ubcFlowEvent4.h(optLong2);
        p.F(ubcFlowEvent4);
        UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("pms_network_response");
        ubcFlowEvent5.h(jSONObject.optLong("responseTime", optLong));
        p.F(ubcFlowEvent5);
        UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("pms_send_header");
        ubcFlowEvent6.h(jSONObject.optLong("sendHeaderTime", optLong));
        p.F(ubcFlowEvent6);
        UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("pms_receive_header");
        ubcFlowEvent7.h(jSONObject.optLong("receiveHeaderTime", optLong));
        p.F(ubcFlowEvent7);
        hw1.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
        hw1.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
    }

    public ek2 J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D.V() : (ek2) invokeV.objValue;
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.D.l() == 1) {
            return;
        }
        this.E.f();
    }

    @Override // com.repackage.l22
    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.D.l() == 1) {
            return;
        }
        this.E.g();
        if (F) {
            Log.d("PkgSyncDownloadCallback", "PMS CS协议信息获取成功");
        }
    }

    public final void M0(z74 z74Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, z74Var) == null) || z74Var == null) {
            return;
        }
        try {
            PMSAppInfo a = mc4.a(new JSONObject(z74Var.c));
            a.appId = a.appKey;
            gz2.J().r().M0(a);
            hw1.i("PkgSyncDownloadCallback", "onFetchError: pms info:" + a.toString());
        } catch (Exception e) {
            if (F) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.repackage.h22
    public int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 200;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.h22
    public PMSDownloadType l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? PMSDownloadType.SYNC : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.a74, com.repackage.y64
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, bundle, set)) == null) {
            Bundle m = super.m(bundle, set);
            if (set.contains("get_launch_id")) {
                m.putString("launch_id", this.D.V().V());
            }
            return m;
        }
        return (Bundle) invokeLL.objValue;
    }

    @Override // com.repackage.a74, com.repackage.x64
    public void n(String str, String str2) {
        List<UbcFlowEvent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            super.n(str, str2);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 53647) {
                if (hashCode == 54608 && str.equals("770")) {
                    c = 1;
                }
            } else if (str.equals("670")) {
                c = 0;
            }
            if (c == 0) {
                ms2.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent(str2));
            } else if (c == 1 && (list = this.p) != null) {
                list.add(new UbcFlowEvent(str2));
            }
        }
    }

    @Override // com.repackage.h22
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.w0();
            if (F) {
                Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
            }
            HybridUbcFlow p = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
            p.F(new UbcFlowEvent("aps_end_download"));
            p.E("type", "0");
            mh2.d("0");
            this.p.add(new UbcFlowEvent("na_start_update_db"));
            ab3 G0 = G0();
            this.p.add(new UbcFlowEvent("na_end_update_db"));
            if (G0 == null) {
                if (F) {
                    Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
                }
                ek2 J0 = J0();
                c84 c84Var = this.l;
                if (c84Var != null && c84Var.h == 0) {
                    J0.Z0(m83.e(0));
                    J0.E(1);
                }
                c84 c84Var2 = this.l;
                if (c84Var2 != null && c84Var2.h == 1) {
                    J0.Z0(m83.e(1));
                    J0.E(1);
                }
                a84 a84Var = this.m;
                if (a84Var != null && a84Var.h == 0) {
                    J0.C0(q92.c(0));
                    J0.E(2);
                }
                a84 a84Var2 = this.m;
                if (a84Var2 != null && a84Var2.h == 1) {
                    J0.C0(q92.c(1));
                    J0.E(2);
                }
                f84 f84Var = this.q;
                if (f84Var != null) {
                    J0.F0(f84Var.r);
                    J0.V0(this.q.p);
                }
                t0(this.n);
                B0("main_download", "0");
                return;
            }
            if (F) {
                Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
            }
            u0(true, G0);
        }
    }

    @Override // com.repackage.h22
    public void x0(Throwable th) {
        ab3 ab3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
                if (F) {
                    Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
                }
                ab3Var = pkgDownloadError.getErrCode();
            } else {
                if (F) {
                    Log.e("PkgSyncDownloadCallback", "未知错误");
                }
                ab3Var = new ab3();
                ab3Var.k(10L);
                ab3Var.i(2900L);
                ab3Var.d("包下载过程未知错误");
            }
            u0(true, ab3Var);
        }
    }
}
