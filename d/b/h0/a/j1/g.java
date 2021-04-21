package d.b.h0.a.j1;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes2.dex */
public class g implements d.b.h0.a.i2.u0.b<HybridUbcFlow> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45602e = d.b.h0.a.k.f45772a;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.i2.u0.b
    /* renamed from: a */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        b(hybridUbcFlow);
    }

    @SuppressLint({"SwanDebugLog"})
    public void b(HybridUbcFlow hybridUbcFlow) {
        String str;
        String str2;
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (hybridUbcFlow == null || hybridUbcFlow.f12065f.isEmpty()) {
            return;
        }
        String str3 = "master_dispatch_start";
        long e2 = hybridUbcFlow.e("slave_first_rendered", "master_dispatch_start");
        d.b.h0.a.f2.d.f45187g.d(Long.valueOf(e2));
        d.b.h0.a.f2.d.f45182b.d(Long.valueOf(hybridUbcFlow.e("slave_first_rendered", "naStart")));
        String str4 = "aps_start_download";
        String str5 = "aps_end_req";
        d.b.h0.a.f2.d.f45183c.d(Long.valueOf(hybridUbcFlow.e("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart")));
        if ((f45602e || d.b.h0.a.m1.a.a.d("aiapps_startup_reporter", false)) && y != null) {
            long e3 = hybridUbcFlow.e("na_first_meaningful_paint", "naStart");
            if (e3 < 1) {
                e3 = hybridUbcFlow.e("na_first_paint", "naStart");
            }
            if (e3 < 1) {
                e3 = 1;
            }
            int i = d.b.h0.a.m1.a.a.r().getInt("aiapps_startup_reporter_resolution", 100);
            String M = y.M();
            if (TextUtils.isEmpty(M)) {
                M = "";
            }
            Log.i("StartupReporter", "\n\n  小程序启动性能报告: " + M + " appID: " + (!TextUtils.isEmpty(y.f46461f) ? y.f46461f : "") + " speedLog\n");
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                sb.append("&");
            }
            boolean z = true;
            Log.i("StartupReporter", String.format(" Cost [%s] Delta Src  Total Action", sb.toString()));
            long g2 = hybridUbcFlow.f12065f.get(0).g();
            Iterator<UbcFlowEvent> it = hybridUbcFlow.f12065f.iterator();
            long j = 0;
            while (it.hasNext()) {
                UbcFlowEvent next = it.next();
                if (!next.b() || d.b.h0.a.m1.a.a.d("aiapps_startup_reporter_local_report", z)) {
                    String[] strArr = new String[2];
                    Iterator<UbcFlowEvent> it2 = it;
                    strArr[0] = next.f12073a;
                    strArr[z ? 1 : 0] = "naStart";
                    long e4 = hybridUbcFlow.e(strArr);
                    boolean z2 = e4 < 0;
                    boolean z3 = e4 > e3;
                    if (z2) {
                        e4 = 0;
                    }
                    if (z3) {
                        e4 = e3;
                    }
                    long j2 = e4 - j;
                    if (j2 < 0) {
                        str = str4;
                        str2 = str5;
                        j2 = 0;
                    } else {
                        str = str4;
                        str2 = str5;
                    }
                    long j3 = i;
                    int round = Math.round((float) ((e4 * j3) / e3));
                    i = i;
                    if (round > i) {
                        round = i;
                    }
                    int round2 = Math.round((float) ((j3 * j2) / e3));
                    if (round2 > i) {
                        round2 = i;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    long j4 = e3;
                    String str6 = str3;
                    sb2.append(String.format(Locale.getDefault(), " %5d ", Long.valueOf(e4)));
                    sb2.append(z2 ? "<" : "[");
                    for (int i3 = 0; i3 < i; i3++) {
                        if (i3 > round) {
                            sb2.append(".");
                        } else if (i3 > round2) {
                            sb2.append("=");
                        } else {
                            sb2.append("#");
                        }
                    }
                    sb2.append(z3 ? ">" : "]");
                    sb2.append(String.format(Locale.getDefault(), "%5d", Long.valueOf(j2)));
                    sb2.append(String.format("  %s", next.f()));
                    sb2.append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(next.g() - g2)));
                    sb2.append(next.f12073a);
                    if (next.b()) {
                        sb2.append("(LocalRecord)");
                    }
                    Log.i("StartupReporter", sb2.toString());
                    it = it2;
                    j = e4;
                    str4 = str;
                    str5 = str2;
                    e3 = j4;
                    str3 = str6;
                    z = true;
                }
            }
            String str7 = str3;
            String str8 = str4;
            String str9 = str5;
            long j5 = e3;
            Log.i("StartupReporter", "Total  ： " + hybridUbcFlow.f12065f.size());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n========APS下载完成:" + hybridUbcFlow.e("aps_end_download", "naStart"));
            sb3.append("\n========解压包时长:" + hybridUbcFlow.e("package_end_unzip", "first_anim_start", "aps_end_download"));
            sb3.append("\n========第一次setData的调用:" + hybridUbcFlow.e("slave_first_loaded", "slave_js_parsed"));
            sb3.append("\n========master第一次和slave通信:" + hybridUbcFlow.e("slave_first_loaded", "master_first_init_data"));
            sb3.append("\n========slave第一次收到数据:" + hybridUbcFlow.e("slave_first_recieve_data", "master_first_init_data"));
            sb3.append("\n========slave第一次渲染完成:" + hybridUbcFlow.e("slave_first_rendered", "slave_first_recieve_data"));
            sb3.append("\n========第一次动画时长:" + hybridUbcFlow.e("first_anim_end", "first_anim_start"));
            sb3.append("\n========第二次动画时长:" + hybridUbcFlow.e("second_anim_end", "second_anim_start"));
            sb3.append("\n\n核心指标--------");
            sb3.append("\n========aps接口时长:" + hybridUbcFlow.e(str9, "aps_start_req", "naStart"));
            sb3.append("\n========aps纯下载时长:" + hybridUbcFlow.e("aps_end_download", str8, str9, "aps_start_req", "naStart"));
            sb3.append("\n========");
            sb3.append("\n========准备启动时长:" + hybridUbcFlow.e("na_launch_activity", "naStart"));
            sb3.append("\n========准备查库时长:" + hybridUbcFlow.e("na_query_db", "naStart"));
            sb3.append("\n========Activity调起时长:" + hybridUbcFlow.e("frame_start_create", "na_launch_activity"));
            sb3.append("\n========");
            sb3.append("\n========预加载等待时长:" + hybridUbcFlow.e("na_pre_load_ok", "na_pre_load_check"));
            sb3.append("\n========主线程阻塞时长:" + hybridUbcFlow.e("na_post_to_main_end", "na_post_to_main_start"));
            sb3.append("\n========本地小程序包加载及渲染总时长:" + hybridUbcFlow.e("slave_first_rendered", "first_anim_start"));
            sb3.append("\n\n启动线性跟踪分段指标简报--------");
            sb3.append("\n========取包（网络开销，从小程序入口，到APS及前置接口等网络交互完成）:" + hybridUbcFlow.e("first_anim_start", "naStart"));
            sb3.append("\n========安装（IO开销，从下载完成，到小程序包解压安装作业完成）:" + hybridUbcFlow.e("package_end_unzip", "first_anim_start"));
            sb3.append("\n========下载-安装（IO开销，从下载开始，到小程序包解压安装作业完成）:" + hybridUbcFlow.e("package_end_unzip", str8));
            sb3.append("\n========小程序框架启动总时长（NA开销，从开始，到 NA 准备完成）:" + hybridUbcFlow.e(str7, "naStart"));
            sb3.append("\n========小程序业务渲染总时长（H5开销，从 NA 准备完成，到页面渲染）:" + e2);
            int optInt = hybridUbcFlow.j().optInt("type", -1);
            String g3 = hybridUbcFlow.g("preload_scene");
            String g4 = hybridUbcFlow.g("app_package_version");
            if (TextUtils.isEmpty(g3)) {
                g3 = "-1";
            }
            String g5 = hybridUbcFlow.g("package_type");
            String str10 = TextUtils.isEmpty(g5) ? "-1" : g5;
            sb3.append("\n\n小程序启动总时长：========> " + j5 + " LaunchDiff=" + hybridUbcFlow.e("naStart", "user_action"));
            sb3.append(hybridUbcFlow.f12063d.contains("package_start_unzip") ^ true ? "(热启动)" : "(冷启动)");
            sb3.append("  relaunchType:" + optInt);
            sb3.append("  preloadType:" + g3);
            sb3.append(" packageType:" + str10);
            if (!TextUtils.isEmpty(g4)) {
                sb3.append(" packageVersion:" + g4);
            }
            Log.i("StartupReporter", "Report ： " + sb3.toString());
        }
    }
}
