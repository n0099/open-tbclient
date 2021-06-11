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
/* loaded from: classes7.dex */
public class ek {

    /* renamed from: a  reason: collision with root package name */
    public static a f41200a;

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, hp> f317a;

    /* loaded from: classes7.dex */
    public interface a {
        void uploader(Context context, hj hjVar);
    }

    public static int a(int i2) {
        if (i2 > 0) {
            return i2 + 1000;
        }
        return -1;
    }

    public static int a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof hf) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof hp) {
                return r1.ordinal() + 2001;
            }
            if (r1 instanceof ev) {
                return r1.ordinal() + 3001;
            }
        }
        return -1;
    }

    public static Config a(Context context) {
        boolean a2 = com.xiaomi.push.service.aq.a(context).a(hk.PerfUploadSwitch.a(), false);
        boolean a3 = com.xiaomi.push.service.aq.a(context).a(hk.EventUploadNewSwitch.a(), false);
        int a4 = com.xiaomi.push.service.aq.a(context).a(hk.PerfUploadFrequency.a(), 86400);
        return Config.getBuilder().setEventUploadSwitchOpen(a3).setEventUploadFrequency(com.xiaomi.push.service.aq.a(context).a(hk.EventUploadFrequency.a(), 86400)).setPerfUploadSwitchOpen(a2).setPerfUploadFrequency(a4).build(context);
    }

    public static EventClientReport a(Context context, String str, String str2, int i2, long j, String str3) {
        EventClientReport a2 = a(str);
        a2.eventId = str2;
        a2.eventType = i2;
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

    public static PerfClientReport a(Context context, int i2, long j, long j2) {
        PerfClientReport a2 = a();
        a2.code = i2;
        a2.perfCounts = j;
        a2.perfLatencies = j2;
        return a2;
    }

    public static hj a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hj hjVar = new hj();
        hjVar.d("category_client_report_data");
        hjVar.a("push_sdk_channel");
        hjVar.a(1L);
        hjVar.b(str);
        hjVar.a(true);
        hjVar.b(System.currentTimeMillis());
        hjVar.g(context.getPackageName());
        hjVar.e("com.xiaomi.xmsf");
        hjVar.f(com.xiaomi.push.service.bm.a());
        hjVar.c("quality_support");
        return hjVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hp m271a(String str) {
        hp[] values;
        if (f317a == null) {
            synchronized (hp.class) {
                if (f317a == null) {
                    f317a = new HashMap();
                    for (hp hpVar : hp.values()) {
                        f317a.put(hpVar.f506a.toLowerCase(), hpVar);
                    }
                }
            }
        }
        hp hpVar2 = f317a.get(str.toLowerCase());
        return hpVar2 != null ? hpVar2 : hp.Invalid;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m272a(int i2) {
        return i2 == 1000 ? "E100000" : i2 == 3000 ? "E100002" : i2 == 2000 ? "E100001" : i2 == 6000 ? "E100003" : "";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m273a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new ei(context), new ej(context));
    }

    public static void a(Context context, hj hjVar) {
        if (m274a(context.getApplicationContext())) {
            com.xiaomi.push.service.bn.a(context.getApplicationContext(), hjVar);
            return;
        }
        a aVar = f41200a;
        if (aVar != null) {
            aVar.uploader(context, hjVar);
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            for (String str : list) {
                hj a2 = a(context, str);
                if (!com.xiaomi.push.service.bm.a(a2, false)) {
                    a(context, a2);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d(th.getMessage());
        }
    }

    public static void a(a aVar) {
        f41200a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m274a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }
}
