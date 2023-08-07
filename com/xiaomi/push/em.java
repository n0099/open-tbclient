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
/* loaded from: classes10.dex */
public class em {
    public static a a;

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, hr> f314a;

    /* loaded from: classes10.dex */
    public interface a {
        void uploader(Context context, hl hlVar);
    }

    public static int a(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    public static int a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof hh) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof hr) {
                return r1.ordinal() + 2001;
            }
            if (r1 instanceof ex) {
                return r1.ordinal() + 3001;
            }
        }
        return -1;
    }

    public static Config a(Context context) {
        boolean a2 = com.xiaomi.push.service.ba.a(context).a(hm.PerfUploadSwitch.a(), false);
        boolean a3 = com.xiaomi.push.service.ba.a(context).a(hm.EventUploadNewSwitch.a(), false);
        int a4 = com.xiaomi.push.service.ba.a(context).a(hm.PerfUploadFrequency.a(), 86400);
        return Config.getBuilder().setEventUploadSwitchOpen(a3).setEventUploadFrequency(com.xiaomi.push.service.ba.a(context).a(hm.EventUploadFrequency.a(), 86400)).setPerfUploadSwitchOpen(a2).setPerfUploadFrequency(a4).build(context);
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

    public static hl a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hl hlVar = new hl();
        hlVar.d("category_client_report_data");
        hlVar.a("push_sdk_channel");
        hlVar.a(1L);
        hlVar.b(str);
        hlVar.a(true);
        hlVar.b(System.currentTimeMillis());
        hlVar.g(context.getPackageName());
        hlVar.e("com.xiaomi.xmsf");
        hlVar.f(com.xiaomi.push.service.bz.a());
        hlVar.c("quality_support");
        return hlVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hr m449a(String str) {
        hr[] values;
        if (f314a == null) {
            synchronized (hr.class) {
                if (f314a == null) {
                    f314a = new HashMap();
                    for (hr hrVar : hr.values()) {
                        f314a.put(hrVar.f508a.toLowerCase(), hrVar);
                    }
                }
            }
        }
        hr hrVar2 = f314a.get(str.toLowerCase());
        return hrVar2 != null ? hrVar2 : hr.Invalid;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m450a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m451a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new ek(context), new el(context));
    }

    public static void a(Context context, hl hlVar) {
        if (m452a(context.getApplicationContext())) {
            com.xiaomi.push.service.ca.a(context.getApplicationContext(), hlVar);
            return;
        }
        a aVar = a;
        if (aVar != null) {
            aVar.uploader(context, hlVar);
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            for (String str : list) {
                hl a2 = a(context, str);
                if (!com.xiaomi.push.service.bz.a(a2, false)) {
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
    public static boolean m452a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }
}
