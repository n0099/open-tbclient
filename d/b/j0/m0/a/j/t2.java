package d.b.j0.m0.a.j;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityDataAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityDataAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class t2 {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityDataAuto.LottieResult lottieResult) {
        hashMap.put("result", lottieResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(TiebaUtilityDataAuto.HostUtilityData hostUtilityData, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityData.getLottieBytes(TiebaUtilityDataAuto.GetLottieParam.fromMap((HashMap) obj), new TiebaUtilityDataAuto.Result() { // from class: d.b.j0.m0.a.j.f0
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityDataAuto.Result
                public final void success(Object obj2) {
                    t2.a(hashMap, reply, (TiebaUtilityDataAuto.LottieResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityDataAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void c(BinaryMessenger binaryMessenger, final TiebaUtilityDataAuto.HostUtilityData hostUtilityData) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityData.getLottieBytes", new StandardMessageCodec());
        if (hostUtilityData != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.b.j0.m0.a.j.g0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    t2.b(TiebaUtilityDataAuto.HostUtilityData.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
    }
}
