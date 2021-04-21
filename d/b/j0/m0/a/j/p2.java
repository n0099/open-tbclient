package d.b.j0.m0.a.j;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAbtestAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityAbtestAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class p2 {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityAbtestAuto.ExperimentType experimentType) {
        hashMap.put("result", experimentType.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(TiebaUtilityAbtestAuto.HostUtilityABTest hostUtilityABTest, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityABTest.experimentTypeForBarEntry(new TiebaUtilityAbtestAuto.Result() { // from class: d.b.j0.m0.a.j.b
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAbtestAuto.Result
                public final void success(Object obj2) {
                    p2.a(hashMap, reply, (TiebaUtilityAbtestAuto.ExperimentType) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityAbtestAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void c(BinaryMessenger binaryMessenger, final TiebaUtilityAbtestAuto.HostUtilityABTest hostUtilityABTest) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityABTest.experimentTypeForBarEntry", new StandardMessageCodec());
        if (hostUtilityABTest != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.b.j0.m0.a.j.a
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    p2.b(TiebaUtilityAbtestAuto.HostUtilityABTest.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
    }
}
