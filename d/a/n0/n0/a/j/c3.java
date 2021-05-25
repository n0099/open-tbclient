package d.a.n0.n0.a.j;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityStatisticAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityStatisticAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class c3 {
    public static /* synthetic */ void a(TiebaUtilityStatisticAuto.HostUtilityStatistic hostUtilityStatistic, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityStatistic.statLogEvent(TiebaUtilityStatisticAuto.StatisticParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityStatisticAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(TiebaUtilityStatisticAuto.HostUtilityStatistic hostUtilityStatistic, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityStatistic.debugLog(TiebaUtilityStatisticAuto.StatisticParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityStatisticAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void c(BinaryMessenger binaryMessenger, final TiebaUtilityStatisticAuto.HostUtilityStatistic hostUtilityStatistic) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityStatistic.statLogEvent", new StandardMessageCodec());
        if (hostUtilityStatistic != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.c2
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    c3.a(TiebaUtilityStatisticAuto.HostUtilityStatistic.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityStatistic.debugLog", new StandardMessageCodec());
        if (hostUtilityStatistic != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.b2
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    c3.b(TiebaUtilityStatisticAuto.HostUtilityStatistic.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
    }
}
