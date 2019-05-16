package com.xiaomi.push.service.clientReport;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.bj;
import com.xiaomi.push.service.bk;
import com.xiaomi.xmpush.thrift.f;
import com.xiaomi.xmpush.thrift.g;
import com.xiaomi.xmpush.thrift.r;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class c {
    private static a a;
    private static Map<String, r> b = null;

    /* loaded from: classes3.dex */
    public interface a {
        void a(Context context, f fVar);
    }

    public static int a(Enum r2) {
        if (r2 != null) {
            if (r2 instanceof com.xiaomi.xmpush.thrift.a) {
                return r2.ordinal() + 1001;
            }
            if (r2 instanceof r) {
                return r2.ordinal() + 2001;
            }
            if (r2 instanceof com.xiaomi.push.service.xmpush.a) {
                return r2.ordinal() + 3001;
            }
            return -1;
        }
        return -1;
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

    public static f a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        f fVar = new f();
        fVar.d("category_client_report_data");
        fVar.a("push_sdk_channel");
        fVar.a(1L);
        fVar.b(str);
        fVar.c(true);
        fVar.b(System.currentTimeMillis());
        fVar.g(context.getPackageName());
        fVar.e("com.xiaomi.xmsf");
        fVar.f(bj.a());
        fVar.c("quality_support");
        return fVar;
    }

    public static String a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : "";
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new com.xiaomi.push.service.clientReport.a(context), new b(context));
    }

    private static void a(Context context, f fVar) {
        if (a(context.getApplicationContext())) {
            bk.a(context.getApplicationContext(), fVar);
        } else if (a != null) {
            a.a(context, fVar);
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            for (String str : list) {
                f a2 = a(context, str);
                if (bj.a(a2, false)) {
                    com.xiaomi.channel.commonutils.logger.b.c(a2.m() + "is not valid...");
                } else {
                    com.xiaomi.channel.commonutils.logger.b.c("send event/perf data item id:" + a2.m());
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

    public static boolean a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }

    public static int b(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    public static r b(String str) {
        r[] values;
        if (b == null) {
            synchronized (r.class) {
                if (b == null) {
                    b = new HashMap();
                    for (r rVar : r.values()) {
                        b.put(rVar.aa.toLowerCase(), rVar);
                    }
                }
            }
        }
        r rVar2 = b.get(str.toLowerCase());
        return rVar2 != null ? rVar2 : r.Invalid;
    }

    public static void b(Context context) {
        ClientReportClient.updateConfig(context, c(context));
    }

    public static Config c(Context context) {
        boolean a2 = an.a(context).a(g.PerfUploadSwitch.a(), false);
        boolean a3 = an.a(context).a(g.EventUploadSwitch.a(), false);
        int a4 = an.a(context).a(g.PerfUploadFrequency.a(), 86400);
        return Config.getBuilder().setEventUploadSwitchOpen(a3).setEventUploadFrequency(an.a(context).a(g.EventUploadFrequency.a(), 86400)).setPerfUploadSwitchOpen(a2).setPerfUploadFrequency(a4).build(context);
    }
}
