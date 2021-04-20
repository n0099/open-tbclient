package d.b.i0.m0.a.j;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityLocationAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityLocationAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class u2 {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityLocationAuto.DistanceResult distanceResult) {
        hashMap.put("result", distanceResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityLocationAuto.AppPosInfoResult appPosInfoResult) {
        hashMap.put("result", appPosInfoResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(TiebaUtilityLocationAuto.HostUtilityLocation hostUtilityLocation, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityLocation.requestDistance(TiebaUtilityLocationAuto.LocationParam.fromMap((HashMap) obj), new TiebaUtilityLocationAuto.Result() { // from class: d.b.i0.m0.a.j.k0
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityLocationAuto.Result
                public final void success(Object obj2) {
                    u2.a(hashMap, reply, (TiebaUtilityLocationAuto.DistanceResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityLocationAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void d(TiebaUtilityLocationAuto.HostUtilityLocation hostUtilityLocation, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityLocation.getAppPosInfo(new TiebaUtilityLocationAuto.Result() { // from class: d.b.i0.m0.a.j.h0
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityLocationAuto.Result
                public final void success(Object obj2) {
                    u2.b(hashMap, reply, (TiebaUtilityLocationAuto.AppPosInfoResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityLocationAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void e(BinaryMessenger binaryMessenger, final TiebaUtilityLocationAuto.HostUtilityLocation hostUtilityLocation) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityLocation.requestDistance", new StandardMessageCodec());
        if (hostUtilityLocation != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.b.i0.m0.a.j.j0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.c(TiebaUtilityLocationAuto.HostUtilityLocation.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityLocation.getAppPosInfo", new StandardMessageCodec());
        if (hostUtilityLocation != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.b.i0.m0.a.j.i0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.d(TiebaUtilityLocationAuto.HostUtilityLocation.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
    }
}
