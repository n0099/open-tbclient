package d.a.n0.n0.a.j;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilitySettingsAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilitySettingsAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class b3 {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilitySettingsAuto.PhotoHostResult photoHostResult) {
        hashMap.put("result", photoHostResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilitySettingsAuto.PhotoHostResult photoHostResult) {
        hashMap.put("result", photoHostResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilitySettingsAuto.PrivateStatResult privateStatResult) {
        hashMap.put("result", privateStatResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilitySettingsAuto.PrivateStatResult privateStatResult) {
        hashMap.put("result", privateStatResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void e(TiebaUtilitySettingsAuto.HostUtilitySettings hostUtilitySettings, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilitySettings.getUserSmallPhotoHost(new TiebaUtilitySettingsAuto.Result() { // from class: d.a.n0.n0.a.j.w1
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilitySettingsAuto.Result
                public final void success(Object obj2) {
                    b3.a(hashMap, reply, (TiebaUtilitySettingsAuto.PhotoHostResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilitySettingsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void f(TiebaUtilitySettingsAuto.HostUtilitySettings hostUtilitySettings, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilitySettings.getUserBigPhotoHost(new TiebaUtilitySettingsAuto.Result() { // from class: d.a.n0.n0.a.j.u1
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilitySettingsAuto.Result
                public final void success(Object obj2) {
                    b3.b(hashMap, reply, (TiebaUtilitySettingsAuto.PhotoHostResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilitySettingsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void g(TiebaUtilitySettingsAuto.HostUtilitySettings hostUtilitySettings, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilitySettings.getMyPrivateStat(TiebaUtilitySettingsAuto.GetPrivateStatParam.fromMap((HashMap) obj), new TiebaUtilitySettingsAuto.Result() { // from class: d.a.n0.n0.a.j.z1
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilitySettingsAuto.Result
                public final void success(Object obj2) {
                    b3.c(hashMap, reply, (TiebaUtilitySettingsAuto.PrivateStatResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilitySettingsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void h(TiebaUtilitySettingsAuto.HostUtilitySettings hostUtilitySettings, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilitySettings.setMyPrivateStat(TiebaUtilitySettingsAuto.SetPrivateStatParam.fromMap((HashMap) obj), new TiebaUtilitySettingsAuto.Result() { // from class: d.a.n0.n0.a.j.x1
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilitySettingsAuto.Result
                public final void success(Object obj2) {
                    b3.d(hashMap, reply, (TiebaUtilitySettingsAuto.PrivateStatResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilitySettingsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void i(BinaryMessenger binaryMessenger, final TiebaUtilitySettingsAuto.HostUtilitySettings hostUtilitySettings) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilitySettings.getUserSmallPhotoHost", new StandardMessageCodec());
        if (hostUtilitySettings != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.y1
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    b3.e(TiebaUtilitySettingsAuto.HostUtilitySettings.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilitySettings.getUserBigPhotoHost", new StandardMessageCodec());
        if (hostUtilitySettings != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.v1
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    b3.f(TiebaUtilitySettingsAuto.HostUtilitySettings.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilitySettings.getMyPrivateStat", new StandardMessageCodec());
        if (hostUtilitySettings != null) {
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.a2
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    b3.g(TiebaUtilitySettingsAuto.HostUtilitySettings.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilitySettings.setMyPrivateStat", new StandardMessageCodec());
        if (hostUtilitySettings != null) {
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.t1
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    b3.h(TiebaUtilitySettingsAuto.HostUtilitySettings.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
    }
}
