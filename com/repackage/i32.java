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
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i32 extends h32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean F;
    public transient /* synthetic */ FieldHolder $fh;
    public final h03 D;
    public final f12 E;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755669463, "Lcom/repackage/i32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755669463, "Lcom/repackage/i32;");
                return;
            }
        }
        F = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i32(h03 h03Var) {
        super(h03Var.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h03Var};
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
        this.D = h03Var;
        this.E = new f12();
    }

    public static void H0(el2 el2Var, ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, el2Var, ac3Var) == null) || el2Var == null) {
            return;
        }
        k73 k73Var = new k73();
        k73Var.a = a73.n(el2Var.G());
        k73Var.f = el2Var.H();
        k73Var.c = el2Var.T();
        k73Var.b = "launch";
        k73Var.e = "success";
        k73Var.a("status", "1");
        if (ac3Var != null) {
            k73Var.a("errcode", String.valueOf(ac3Var.a()));
            k73Var.a("msg", ac3Var.g().toString());
        }
        k73Var.d(el2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        k73Var.j(el2Var);
        a73.onEvent(k73Var);
        HybridUbcFlow d = mt2.d("startup");
        if (d != null) {
            d.E("value", "na_success");
        }
    }

    @Override // com.repackage.h32, com.repackage.a84
    public void C(z84 z84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z84Var) == null) {
            super.C(z84Var);
            if (F) {
                Log.e("PkgSyncDownloadCallback", "onFetchError: " + z84Var.toString());
            }
            L0(z84Var);
            ac3 ac3Var = new ac3();
            ac3Var.k(10L);
            ac3Var.c(z84Var);
            if (z32.j(z84Var) && oj2.T().a(oj2.c(), this.o, ac3Var)) {
                t0(false, ac3Var);
                H0(this.D.W(), ac3Var);
            } else if (z84Var != null && z84Var.a == 1020) {
                t0(false, ac3Var);
                H0(this.D.W(), ac3Var);
            } else {
                t0(true, ac3Var);
            }
        }
    }

    @Override // com.repackage.h32, com.repackage.a84
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            J0();
            mt2.p("startup").F(new UbcFlowEvent("aps_start_req"));
            super.D();
        }
    }

    @Override // com.repackage.h32, com.repackage.a84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            mt2.p("startup").F(new UbcFlowEvent("aps_end_req"));
            K0();
        }
    }

    @Override // com.repackage.a84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.F();
            if (this.n != null) {
                u0();
            }
            ac3 ac3Var = new ac3();
            ac3Var.k(10L);
            ac3Var.i(2901L);
            ac3Var.d("同步获取-> Server无包");
            t0(true, ac3Var);
        }
    }

    @Override // com.repackage.h32, com.repackage.a84
    public void G(nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nd4Var) == null) {
            mt2.p("startup").F(new UbcFlowEvent("aps_start_download"));
            super.G(nd4Var);
        }
    }

    @Override // com.repackage.a84
    public void H(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            super.H(str, i);
            k94 a = k94.a(str);
            if (a == null) {
                return;
            }
            boolean b = md4.b(a.c());
            hx1.i("PkgSyncDownloadCallback", "resetCore: " + b + ";statusCode:" + i);
            if (b) {
                xw2 e = xw2.e();
                zw2 zw2Var = new zw2(129);
                zw2Var.f(true);
                e.h(zw2Var);
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
    @Override // com.repackage.a84
    public void I(String str, String str2, JSONObject jSONObject) {
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
        HybridUbcFlow p = mt2.p("startup");
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
        hx1.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
        hx1.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
    }

    public el2 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D.W() : (el2) invokeV.objValue;
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.D.k() == 1) {
            return;
        }
        this.E.f();
    }

    @Override // com.repackage.l32
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.D.k() == 1) {
            return;
        }
        this.E.g();
        if (F) {
            Log.d("PkgSyncDownloadCallback", "PMS CS协议信息获取成功");
        }
    }

    public final void L0(z84 z84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, z84Var) == null) || z84Var == null) {
            return;
        }
        try {
            PMSAppInfo a = md4.a(new JSONObject(z84Var.c));
            a.appId = a.appKey;
            g03.K().q().N0(a);
            hx1.i("PkgSyncDownloadCallback", "onFetchError: pms info:" + a.toString());
        } catch (Exception e) {
            if (F) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.repackage.h32
    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 200;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.h32
    public PMSDownloadType k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? PMSDownloadType.SYNC : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.a84, com.repackage.y74
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, bundle, set)) == null) {
            Bundle m = super.m(bundle, set);
            if (set.contains("get_launch_id")) {
                m.putString("launch_id", this.D.W().V());
            }
            return m;
        }
        return (Bundle) invokeLL.objValue;
    }

    @Override // com.repackage.a84, com.repackage.x74
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
                mt2.p("startup").F(new UbcFlowEvent(str2));
            } else if (c == 1 && (list = this.p) != null) {
                list.add(new UbcFlowEvent(str2));
            }
        }
    }

    @Override // com.repackage.h32
    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.v0();
            if (F) {
                Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
            }
            HybridUbcFlow p = mt2.p("startup");
            p.F(new UbcFlowEvent("aps_end_download"));
            p.E("type", "0");
            mi2.d("0");
            this.p.add(new UbcFlowEvent("na_start_update_db"));
            ac3 F0 = F0();
            this.p.add(new UbcFlowEvent("na_end_update_db"));
            if (F0 == null) {
                if (F) {
                    Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
                }
                el2 I0 = I0();
                c94 c94Var = this.l;
                if (c94Var != null && c94Var.h == 0) {
                    I0.Z0(m93.e(0));
                    I0.E(1);
                }
                c94 c94Var2 = this.l;
                if (c94Var2 != null && c94Var2.h == 1) {
                    I0.Z0(m93.e(1));
                    I0.E(1);
                }
                a94 a94Var = this.m;
                if (a94Var != null && a94Var.h == 0) {
                    I0.C0(qa2.c(0));
                    I0.E(2);
                }
                a94 a94Var2 = this.m;
                if (a94Var2 != null && a94Var2.h == 1) {
                    I0.C0(qa2.c(1));
                    I0.E(2);
                }
                f94 f94Var = this.q;
                if (f94Var != null) {
                    I0.F0(f94Var.r);
                    I0.V0(this.q.p);
                }
                s0(this.n);
                A0("main_download", "0");
                return;
            }
            if (F) {
                Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
            }
            t0(true, F0);
        }
    }

    @Override // com.repackage.h32
    public void w0(Throwable th) {
        ac3 ac3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
                if (F) {
                    Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
                }
                ac3Var = pkgDownloadError.getErrCode();
            } else {
                if (F) {
                    Log.e("PkgSyncDownloadCallback", "未知错误");
                }
                ac3Var = new ac3();
                ac3Var.k(10L);
                ac3Var.i(2900L);
                ac3Var.d("包下载过程未知错误");
            }
            t0(true, ac3Var);
        }
    }
}
