package d.b.g0.a.j1;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes2.dex */
public class f implements d.b.g0.a.i2.u0.b<HybridUbcFlow> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45272e = d.b.g0.a.k.f45443a;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.i2.u0.b
    /* renamed from: a */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        b(hybridUbcFlow);
    }

    @SuppressLint({"SwanDebugLog"})
    public void b(HybridUbcFlow hybridUbcFlow) {
        long e2;
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (hybridUbcFlow == null || hybridUbcFlow.f12057f.isEmpty() || !f45272e || y == null) {
            return;
        }
        HybridUbcFlow.SubmitStrategy h2 = hybridUbcFlow.h();
        String str = hybridUbcFlow.f12055d.contains("fe_route_start") ? "fe_route_start" : "na_first_receive_action";
        int i = 2;
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
        String M = y.M();
        if (TextUtils.isEmpty(M)) {
            M = "";
        }
        Log.i("RouteReporter", "\n\n  小程序路由性能报告: " + M + " appID: " + (!TextUtils.isEmpty(y.f46132f) ? y.f46132f : "") + " launchId ：" + (y.L() != null ? y.L().U() : "") + " speedLog\n");
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 100; i2++) {
            sb.append("&");
        }
        Log.i("RouteReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
        long g2 = hybridUbcFlow.f12057f.get(0).g();
        Iterator<UbcFlowEvent> it = hybridUbcFlow.f12057f.iterator();
        long j = 0;
        long j2 = 0;
        while (it.hasNext()) {
            UbcFlowEvent next = it.next();
            String[] strArr = new String[i];
            strArr[c3] = next.f12065a;
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
            int i3 = round2 > 100 ? 100 : round2;
            StringBuilder sb2 = new StringBuilder();
            Iterator<UbcFlowEvent> it2 = it;
            sb2.append(String.format(Locale.getDefault(), "%5d ", Long.valueOf(j3)));
            sb2.append(z ? "<" : "[");
            for (int i4 = 0; i4 < 100; i4++) {
                if (i4 > round) {
                    sb2.append(".");
                } else if (i4 > i3) {
                    sb2.append("=");
                } else {
                    sb2.append("#");
                }
            }
            sb2.append(z3 ? ">" : "]");
            c2 = 1;
            sb2.append(String.format(Locale.getDefault(), " %5d", Long.valueOf(e3)));
            sb2.append(String.format("  %s", next.f()));
            sb2.append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(next.g() - g2)));
            sb2.append(next.f12065a);
            if (next.b()) {
                sb2.append("(LocalRecord)");
            }
            Log.i("RouteReporter", sb2.toString());
            j2 = e3;
            it = it2;
            i = 2;
            c3 = 0;
            j = 0;
        }
        Log.i("RouteReporter", "Total  ： " + hybridUbcFlow.f12057f.size());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\n\n小程序路由总时长：========> " + e2);
        String optString = hybridUbcFlow.j().optString("type");
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
