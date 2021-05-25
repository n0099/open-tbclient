package d.a.n0.n0.a.g;

import com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: PerformanceMonitorAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class e {
    public static /* synthetic */ void a(PerformanceMonitorAuto.HostPerformanceMonitor hostPerformanceMonitor, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostPerformanceMonitor.reportEnginePerformance(PerformanceMonitorAuto.MapParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = PerformanceMonitorAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(PerformanceMonitorAuto.HostPerformanceMonitor hostPerformanceMonitor, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostPerformanceMonitor.reportFPSPerformance(PerformanceMonitorAuto.FpsParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = PerformanceMonitorAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(PerformanceMonitorAuto.HostPerformanceMonitor hostPerformanceMonitor, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostPerformanceMonitor.reportImageLoadPerformance(PerformanceMonitorAuto.MapParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = PerformanceMonitorAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(PerformanceMonitorAuto.HostPerformanceMonitor hostPerformanceMonitor, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostPerformanceMonitor.reportPageLoadPerformance(PerformanceMonitorAuto.MapParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = PerformanceMonitorAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void e(BinaryMessenger binaryMessenger, final PerformanceMonitorAuto.HostPerformanceMonitor hostPerformanceMonitor) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostPerformanceMonitor.reportEnginePerformance", new StandardMessageCodec());
        if (hostPerformanceMonitor != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.g.d
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    e.a(PerformanceMonitorAuto.HostPerformanceMonitor.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostPerformanceMonitor.reportFPSPerformance", new StandardMessageCodec());
        if (hostPerformanceMonitor != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.g.c
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    e.b(PerformanceMonitorAuto.HostPerformanceMonitor.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostPerformanceMonitor.reportImageLoadPerformance", new StandardMessageCodec());
        if (hostPerformanceMonitor != null) {
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.g.b
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    e.c(PerformanceMonitorAuto.HostPerformanceMonitor.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostPerformanceMonitor.reportPageLoadPerformance", new StandardMessageCodec());
        if (hostPerformanceMonitor != null) {
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.g.a
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    e.d(PerformanceMonitorAuto.HostPerformanceMonitor.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
    }
}
