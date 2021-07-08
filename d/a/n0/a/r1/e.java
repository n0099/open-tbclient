package d.a.n0.a.r1;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes7.dex */
public class e implements d.a.n0.a.v2.e1.b<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47061e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(715740496, "Ld/a/n0/a/r1/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(715740496, "Ld/a/n0/a/r1/e;");
                return;
            }
        }
        f47061e = k.f45831a;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.a.v2.e1.b
    /* renamed from: a */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
            b(hybridUbcFlow);
        }
    }

    @SuppressLint({"SwanDebugLog", "LogConditional"})
    public void b(HybridUbcFlow hybridUbcFlow) {
        long e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            d.a.n0.a.a2.e i2 = d.a.n0.a.a2.e.i();
            if (hybridUbcFlow == null || hybridUbcFlow.f11213f.isEmpty() || !f47061e || i2 == null) {
                return;
            }
            HybridUbcFlow.SubmitStrategy h2 = hybridUbcFlow.h();
            String str = hybridUbcFlow.f11211d.contains("fe_route_start") ? "fe_route_start" : "na_first_receive_action";
            int i3 = 2;
            char c2 = 1;
            char c3 = 0;
            if (h2 == HybridUbcFlow.SubmitStrategy.ROUTE) {
                e2 = hybridUbcFlow.e("fe_first_render_start", str);
            } else if (h2 == HybridUbcFlow.SubmitStrategy.ROUTE_NA) {
                e2 = hybridUbcFlow.e("na_push_page_end", str);
            } else {
                e2 = hybridUbcFlow.e("web_widget_first_screen_finish", str);
            }
            if (e2 < 1) {
                e2 = 1;
            }
            String O = i2.O();
            if (TextUtils.isEmpty(O)) {
                O = "";
            }
            Log.i("RouteReporter", "\n\n  小程序路由性能报告: " + O + " appID: " + (!TextUtils.isEmpty(i2.f43381f) ? i2.f43381f : "") + " launchId ：" + (i2.N() != null ? i2.N().V() : "") + " speedLog\n");
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < 100; i4++) {
                sb.append("&");
            }
            Log.i("RouteReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
            long g2 = hybridUbcFlow.f11213f.get(0).g();
            Iterator<UbcFlowEvent> it = hybridUbcFlow.f11213f.iterator();
            long j = 0;
            long j2 = 0;
            while (it.hasNext()) {
                UbcFlowEvent next = it.next();
                String[] strArr = new String[i3];
                strArr[c3] = next.f11222a;
                strArr[c2] = str;
                long e3 = hybridUbcFlow.e(strArr);
                boolean z = e3 < j;
                boolean z2 = e3 > e2;
                if (z) {
                    e3 = j;
                }
                if (z2) {
                    e3 = e2;
                }
                long j3 = e3 - j2;
                boolean z3 = z2;
                if (j3 < j) {
                    j3 = j;
                }
                long j4 = 100;
                int round = Math.round((float) ((e3 * j4) / e2));
                if (round > 100) {
                    round = 100;
                }
                int round2 = Math.round((float) ((j3 * j4) / e2));
                int i5 = round2 > 100 ? 100 : round2;
                StringBuilder sb2 = new StringBuilder();
                Iterator<UbcFlowEvent> it2 = it;
                sb2.append(String.format(Locale.getDefault(), "%5d ", Long.valueOf(j3)));
                sb2.append(z ? "<" : PreferencesUtil.LEFT_MOUNT);
                for (int i6 = 0; i6 < 100; i6++) {
                    if (i6 > round) {
                        sb2.append(".");
                    } else if (i6 > i5) {
                        sb2.append("=");
                    } else {
                        sb2.append("#");
                    }
                }
                sb2.append(z3 ? ">" : PreferencesUtil.RIGHT_MOUNT);
                c2 = 1;
                sb2.append(String.format(Locale.getDefault(), " %5d", Long.valueOf(e3)));
                sb2.append(String.format("  %s", next.f()));
                sb2.append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(next.g() - g2)));
                sb2.append(next.f11222a);
                if (next.b()) {
                    sb2.append("(LocalRecord)");
                }
                Log.i("RouteReporter", sb2.toString());
                j2 = e3;
                it = it2;
                i3 = 2;
                c3 = 0;
                j = 0;
            }
            Log.i("RouteReporter", "Total  ： " + hybridUbcFlow.f11213f.size());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n\n小程序路由总时长：========> " + e2);
            String optString = hybridUbcFlow.k().optString("type");
            String g3 = hybridUbcFlow.g("sub_state");
            String g4 = hybridUbcFlow.g("preload");
            String g5 = hybridUbcFlow.g("web_widget_state");
            StringBuilder sb4 = new StringBuilder();
            sb4.append("\nsub_state :");
            sb4.append(TextUtils.equals(g3, "0") ? "无需下载分包" : "需要下载分包");
            sb3.append(sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\npreload :");
            sb5.append(TextUtils.equals(g4, "0") ? "未完成" : "已完成");
            sb3.append(sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("\nhasWebViewWidget :");
            sb6.append(TextUtils.equals(g5, "0") ? "无webview组件" : "有webview组件");
            sb3.append(sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("\ntype ：");
            sb7.append(TextUtils.isEmpty(optString) ? "" : optString);
            sb3.append(sb7.toString());
            Log.i("RouteReporter", "Report ： " + sb3.toString());
        }
    }
}
