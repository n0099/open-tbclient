package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class fa {
    private static a a;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, hw> f309a = null;

    /* loaded from: classes8.dex */
    public interface a {
        void uploader(Context context, hq hqVar);
    }

    public static int a(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    public static int a(Enum r2) {
        if (r2 != null) {
            if (r2 instanceof hm) {
                return r2.ordinal() + 1001;
            }
            if (r2 instanceof hw) {
                return r2.ordinal() + 2001;
            }
            if (r2 instanceof fg) {
                return r2.ordinal() + 3001;
            }
            return -1;
        }
        return -1;
    }

    public static Config a(Context context) {
        boolean a2 = com.xiaomi.push.service.ak.a(context).a(hr.PerfUploadSwitch.a(), false);
        boolean a3 = com.xiaomi.push.service.ak.a(context).a(hr.EventUploadNewSwitch.a(), false);
        int a4 = com.xiaomi.push.service.ak.a(context).a(hr.PerfUploadFrequency.a(), 86400);
        return Config.getBuilder().setEventUploadSwitchOpen(a3).setEventUploadFrequency(com.xiaomi.push.service.ak.a(context).a(hr.EventUploadFrequency.a(), 86400)).setPerfUploadSwitchOpen(a2).setPerfUploadFrequency(a4).build(context);
    }

    public static EventClientReport a(Context context, String str, String str2, int i, long j, String str3) {
        EventClientReport a2 = a(str);
        a2.eventId = str2;
        a2.eventType = i;
        a2.eventTime = j;
        a2.eventContent = str3;
        return a2;
    }

    public static EventClientReport a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    public static PerfClientReport a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    public static PerfClientReport a(Context context, int i, long j, long j2) {
        PerfClientReport a2 = a();
        a2.code = i;
        a2.perfCounts = j;
        a2.perfLatencies = j2;
        return a2;
    }

    public static hq a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hq hqVar = new hq();
        hqVar.d("category_client_report_data");
        hqVar.a("push_sdk_channel");
        hqVar.a(1L);
        hqVar.b(str);
        hqVar.a(true);
        hqVar.b(System.currentTimeMillis());
        hqVar.g(context.getPackageName());
        hqVar.e("com.xiaomi.xmsf");
        hqVar.f(com.xiaomi.push.service.bi.a());
        hqVar.c("quality_support");
        return hqVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hw m268a(String str) {
        hw[] values;
        if (f309a == null) {
            synchronized (hw.class) {
                if (f309a == null) {
                    f309a = new HashMap();
                    for (hw hwVar : hw.values()) {
                        f309a.put(hwVar.f475a.toLowerCase(), hwVar);
                    }
                }
            }
        }
        hw hwVar2 = f309a.get(str.toLowerCase());
        return hwVar2 != null ? hwVar2 : hw.Invalid;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m269a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m270a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new ey(context), new ez(context));
    }

    private static void a(Context context, hq hqVar) {
        if (m271a(context.getApplicationContext())) {
            com.xiaomi.push.service.bj.a(context.getApplicationContext(), hqVar);
        } else if (a != null) {
            a.uploader(context, hqVar);
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            for (String str : list) {
                hq a2 = a(context, str);
                if (!com.xiaomi.push.service.bi.a(a2, false)) {
                    a(context, a2);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d(th.getMessage());
        }
    }

    public static void a(a aVar) {
        a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m271a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }
}
