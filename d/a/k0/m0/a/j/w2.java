package d.a.k0.m0.a.j;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityMessageAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityMessageAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class w2 {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityMessageAuto.NewMessage newMessage) {
        hashMap.put("result", newMessage.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityMessageAuto.MessageBoolResult messageBoolResult) {
        hashMap.put("result", messageBoolResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityMessageAuto.MessageBoolResult messageBoolResult) {
        hashMap.put("result", messageBoolResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(TiebaUtilityMessageAuto.HostUtilityMessage hostUtilityMessage, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityMessage.readNewMessage(new TiebaUtilityMessageAuto.Result() { // from class: d.a.k0.m0.a.j.o0
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityMessageAuto.Result
                public final void success(Object obj2) {
                    w2.a(hashMap, reply, (TiebaUtilityMessageAuto.NewMessage) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityMessageAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void e(TiebaUtilityMessageAuto.HostUtilityMessage hostUtilityMessage, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityMessage.clearNewMessage(TiebaUtilityMessageAuto.MessageStringParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityMessageAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void f(TiebaUtilityMessageAuto.HostUtilityMessage hostUtilityMessage, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityMessage.readVipCenterNewMessage(new TiebaUtilityMessageAuto.Result() { // from class: d.a.k0.m0.a.j.n0
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityMessageAuto.Result
                public final void success(Object obj2) {
                    w2.b(hashMap, reply, (TiebaUtilityMessageAuto.MessageBoolResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityMessageAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void g(TiebaUtilityMessageAuto.HostUtilityMessage hostUtilityMessage, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityMessage.getIsOfficalForumLetterReminderOpen(TiebaUtilityMessageAuto.MessageStringParam.fromMap((HashMap) obj), new TiebaUtilityMessageAuto.Result() { // from class: d.a.k0.m0.a.j.u0
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityMessageAuto.Result
                public final void success(Object obj2) {
                    w2.c(hashMap, reply, (TiebaUtilityMessageAuto.MessageBoolResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityMessageAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void h(TiebaUtilityMessageAuto.HostUtilityMessage hostUtilityMessage, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityMessage.setOfficalForumLetterReminderOpen(TiebaUtilityMessageAuto.SetForumBroadcastParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityMessageAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void i(TiebaUtilityMessageAuto.HostUtilityMessage hostUtilityMessage, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityMessage.delAllMsgInForumUser(TiebaUtilityMessageAuto.MessageStringParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityMessageAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void j(TiebaUtilityMessageAuto.HostUtilityMessage hostUtilityMessage, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityMessage.resetFansNumCount();
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityMessageAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void k(BinaryMessenger binaryMessenger, final TiebaUtilityMessageAuto.HostUtilityMessage hostUtilityMessage) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityMessage.readNewMessage", new StandardMessageCodec());
        if (hostUtilityMessage != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.k0.m0.a.j.m0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    w2.d(TiebaUtilityMessageAuto.HostUtilityMessage.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityMessage.clearNewMessage", new StandardMessageCodec());
        if (hostUtilityMessage != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.k0.m0.a.j.p0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    w2.e(TiebaUtilityMessageAuto.HostUtilityMessage.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityMessage.readVipCenterNewMessage", new StandardMessageCodec());
        if (hostUtilityMessage != null) {
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.k0.m0.a.j.q0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    w2.f(TiebaUtilityMessageAuto.HostUtilityMessage.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityMessage.getIsOfficalForumLetterReminderOpen", new StandardMessageCodec());
        if (hostUtilityMessage != null) {
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.k0.m0.a.j.s0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    w2.g(TiebaUtilityMessageAuto.HostUtilityMessage.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityMessage.setOfficalForumLetterReminderOpen", new StandardMessageCodec());
        if (hostUtilityMessage != null) {
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.k0.m0.a.j.r0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    w2.h(TiebaUtilityMessageAuto.HostUtilityMessage.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityMessage.delAllMsgInForumUser", new StandardMessageCodec());
        if (hostUtilityMessage != null) {
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.k0.m0.a.j.t0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    w2.i(TiebaUtilityMessageAuto.HostUtilityMessage.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityMessage.resetFansNumCount", new StandardMessageCodec());
        if (hostUtilityMessage != null) {
            basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.k0.m0.a.j.l0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    w2.j(TiebaUtilityMessageAuto.HostUtilityMessage.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel7.setMessageHandler(null);
        }
    }
}
