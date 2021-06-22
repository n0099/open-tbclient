package d.a.o0.n0.a.j;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityComponentsAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class u2 {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult) {
        hashMap.put("result", componentsBoolResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult) {
        hashMap.put("result", componentsBoolResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult) {
        hashMap.put("result", componentsBoolResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue) {
        hashMap.put("result", componentsStringValue.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void e(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue) {
        hashMap.put("result", componentsStringValue.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void f(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult) {
        hashMap.put("result", componentsBoolResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void g(TiebaUtilityComponentsAuto.HostUtilityComponents hostUtilityComponents, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityComponents.negativeFeedBack(TiebaUtilityComponentsAuto.AgreeThreadParam.fromMap((HashMap) obj), new TiebaUtilityComponentsAuto.Result() { // from class: d.a.o0.n0.a.j.z
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.Result
                public final void success(Object obj2) {
                    u2.a(hashMap, reply, (TiebaUtilityComponentsAuto.ComponentsBoolResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityComponentsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void h(TiebaUtilityComponentsAuto.HostUtilityComponents hostUtilityComponents, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityComponents.hasOfficialChat(new TiebaUtilityComponentsAuto.Result() { // from class: d.a.o0.n0.a.j.x
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.Result
                public final void success(Object obj2) {
                    u2.b(hashMap, reply, (TiebaUtilityComponentsAuto.ComponentsBoolResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityComponentsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void i(TiebaUtilityComponentsAuto.HostUtilityComponents hostUtilityComponents, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityComponents.delLikeForum(TiebaUtilityComponentsAuto.ComponentsStringValue.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityComponentsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void j(TiebaUtilityComponentsAuto.HostUtilityComponents hostUtilityComponents, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityComponents.showRedDotForMyTab(new TiebaUtilityComponentsAuto.Result() { // from class: d.a.o0.n0.a.j.t
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.Result
                public final void success(Object obj2) {
                    u2.c(hashMap, reply, (TiebaUtilityComponentsAuto.ComponentsBoolResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityComponentsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void k(TiebaUtilityComponentsAuto.HostUtilityComponents hostUtilityComponents, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityComponents.getHistoryCount(new TiebaUtilityComponentsAuto.Result() { // from class: d.a.o0.n0.a.j.v
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.Result
                public final void success(Object obj2) {
                    u2.d(hashMap, reply, (TiebaUtilityComponentsAuto.ComponentsStringValue) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityComponentsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void l(TiebaUtilityComponentsAuto.HostUtilityComponents hostUtilityComponents, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityComponents.agreeThread(TiebaUtilityComponentsAuto.AgreeThreadParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityComponentsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void m(TiebaUtilityComponentsAuto.HostUtilityComponents hostUtilityComponents, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityComponents.disagreeThread(TiebaUtilityComponentsAuto.AgreeThreadParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityComponentsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void n(TiebaUtilityComponentsAuto.HostUtilityComponents hostUtilityComponents, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityComponents.getHistoryForumStr(new TiebaUtilityComponentsAuto.Result() { // from class: d.a.o0.n0.a.j.p
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.Result
                public final void success(Object obj2) {
                    u2.e(hashMap, reply, (TiebaUtilityComponentsAuto.ComponentsStringValue) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityComponentsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void o(TiebaUtilityComponentsAuto.HostUtilityComponents hostUtilityComponents, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityComponents.deleteRecentlyVisitedForumHistory(TiebaUtilityComponentsAuto.ComponentsStringValue.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityComponentsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void p(TiebaUtilityComponentsAuto.HostUtilityComponents hostUtilityComponents, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityComponents.getRecnbarShow(new TiebaUtilityComponentsAuto.Result() { // from class: d.a.o0.n0.a.j.w
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.Result
                public final void success(Object obj2) {
                    u2.f(hashMap, reply, (TiebaUtilityComponentsAuto.ComponentsBoolResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityComponentsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void q(TiebaUtilityComponentsAuto.HostUtilityComponents hostUtilityComponents, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityComponents.selectForumCategory(TiebaUtilityComponentsAuto.ComponentsStringValue.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityComponentsAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void r(BinaryMessenger binaryMessenger, final TiebaUtilityComponentsAuto.HostUtilityComponents hostUtilityComponents) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityComponents.hasOfficialChat", new StandardMessageCodec());
        if (hostUtilityComponents != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.y
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.h(TiebaUtilityComponentsAuto.HostUtilityComponents.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityComponents.delLikeForum", new StandardMessageCodec());
        if (hostUtilityComponents != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.s
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.i(TiebaUtilityComponentsAuto.HostUtilityComponents.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityComponents.showRedDotForMyTab", new StandardMessageCodec());
        if (hostUtilityComponents != null) {
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.b0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.j(TiebaUtilityComponentsAuto.HostUtilityComponents.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityComponents.getHistoryCount", new StandardMessageCodec());
        if (hostUtilityComponents != null) {
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.a0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.k(TiebaUtilityComponentsAuto.HostUtilityComponents.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityComponents.agreeThread", new StandardMessageCodec());
        if (hostUtilityComponents != null) {
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.r
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.l(TiebaUtilityComponentsAuto.HostUtilityComponents.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityComponents.disagreeThread", new StandardMessageCodec());
        if (hostUtilityComponents != null) {
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.d0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.m(TiebaUtilityComponentsAuto.HostUtilityComponents.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityComponents.getHistoryForumStr", new StandardMessageCodec());
        if (hostUtilityComponents != null) {
            basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.c0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.n(TiebaUtilityComponentsAuto.HostUtilityComponents.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel7.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityComponents.deleteRecentlyVisitedForumHistory", new StandardMessageCodec());
        if (hostUtilityComponents != null) {
            basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.u
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.o(TiebaUtilityComponentsAuto.HostUtilityComponents.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel8.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityComponents.getRecnbarShow", new StandardMessageCodec());
        if (hostUtilityComponents != null) {
            basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.e0
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.p(TiebaUtilityComponentsAuto.HostUtilityComponents.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel9.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityComponents.selectForumCategory", new StandardMessageCodec());
        if (hostUtilityComponents != null) {
            basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.o
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.q(TiebaUtilityComponentsAuto.HostUtilityComponents.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel10.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityComponents.negativeFeedBack", new StandardMessageCodec());
        if (hostUtilityComponents != null) {
            basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.q
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    u2.g(TiebaUtilityComponentsAuto.HostUtilityComponents.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel11.setMessageHandler(null);
        }
    }
}
