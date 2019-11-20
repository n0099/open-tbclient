package com.xiaomi.clientreport.manager;

import android.content.Context;
import android.os.Process;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.g;
/* loaded from: classes3.dex */
public class ClientReportClient {
    public static void init(Context context) {
        init(context, Config.defaultConfig(context), new com.xiaomi.clientreport.processor.a(context), new com.xiaomi.clientreport.processor.b(context));
    }

    public static void init(Context context, Config config) {
        init(context, config, new com.xiaomi.clientreport.processor.a(context), new com.xiaomi.clientreport.processor.b(context));
    }

    public static void init(Context context, Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        com.xiaomi.channel.commonutils.logger.b.c("init in process " + g.a(context) + " pid :" + Process.myPid() + " threadId: " + Thread.currentThread().getId());
        a.a(context).a(config, iEventProcessor, iPerfProcessor);
        if (g.m280a(context)) {
            com.xiaomi.channel.commonutils.logger.b.c("init in process\u3000start scheduleJob");
            a.a(context).m34a();
        }
    }

    public static void reportEvent(Context context, EventClientReport eventClientReport) {
        if (eventClientReport != null) {
            a.a(context).a(eventClientReport);
        }
    }

    public static void reportPerf(Context context, PerfClientReport perfClientReport) {
        if (perfClientReport != null) {
            a.a(context).a(perfClientReport);
        }
    }

    public static void updateConfig(Context context, Config config) {
        if (config == null) {
            return;
        }
        a.a(context).a(config.isEventUploadSwitchOpen(), config.isPerfUploadSwitchOpen(), config.getEventUploadFrequency(), config.getPerfUploadFrequency());
    }
}
