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
/* loaded from: classes3.dex */
public class eu {
    private static a a;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, hq> f323a = null;

    /* loaded from: classes3.dex */
    public interface a {
        void a(Context context, hk hkVar);
    }

    public static int a(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    public static int a(Enum r2) {
        if (r2 != null) {
            if (r2 instanceof hg) {
                return r2.ordinal() + 1001;
            }
            if (r2 instanceof hq) {
                return r2.ordinal() + 2001;
            }
            if (r2 instanceof fa) {
                return r2.ordinal() + 3001;
            }
            return -1;
        }
        return -1;
    }

    public static Config a(Context context) {
        boolean a2 = com.xiaomi.push.service.ag.a(context).a(hl.PerfUploadSwitch.a(), false);
        boolean a3 = com.xiaomi.push.service.ag.a(context).a(hl.EventUploadSwitch.a(), false);
        int a4 = com.xiaomi.push.service.ag.a(context).a(hl.PerfUploadFrequency.a(), 86400);
        return Config.getBuilder().setEventUploadSwitchOpen(a3).setEventUploadFrequency(com.xiaomi.push.service.ag.a(context).a(hl.EventUploadFrequency.a(), 86400)).setPerfUploadSwitchOpen(a2).setPerfUploadFrequency(a4).build(context);
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

    public static hk a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hk hkVar = new hk();
        hkVar.d("category_client_report_data");
        hkVar.a("push_sdk_channel");
        hkVar.a(1L);
        hkVar.b(str);
        hkVar.a(true);
        hkVar.b(System.currentTimeMillis());
        hkVar.g(context.getPackageName());
        hkVar.e("com.xiaomi.xmsf");
        hkVar.f(com.xiaomi.push.service.be.a());
        hkVar.c("quality_support");
        return hkVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hq m242a(String str) {
        hq[] values;
        if (f323a == null) {
            synchronized (hq.class) {
                if (f323a == null) {
                    f323a = new HashMap();
                    for (hq hqVar : hq.values()) {
                        f323a.put(hqVar.f489a.toLowerCase(), hqVar);
                    }
                }
            }
        }
        hq hqVar2 = f323a.get(str.toLowerCase());
        return hqVar2 != null ? hqVar2 : hq.Invalid;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m243a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m244a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new es(context), new et(context));
    }

    private static void a(Context context, hk hkVar) {
        if (m245a(context.getApplicationContext())) {
            com.xiaomi.push.service.bf.a(context.getApplicationContext(), hkVar);
        } else if (a != null) {
            a.a(context, hkVar);
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            for (String str : list) {
                hk a2 = a(context, str);
                if (com.xiaomi.push.service.be.a(a2, false)) {
                    com.xiaomi.channel.commonutils.logger.b.c(a2.d() + "is not valid...");
                } else {
                    com.xiaomi.channel.commonutils.logger.b.c("send event/perf data item id:" + a2.d());
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
    public static boolean m245a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }
}
