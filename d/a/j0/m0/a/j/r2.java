package d.a.j0.m0.a.j;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAccountAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityAccountAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class r2 {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityAccountAuto.AccountBoolResult accountBoolResult) {
        hashMap.put("result", accountBoolResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityAccountAuto.AccountBoolResult accountBoolResult) {
        hashMap.put("result", accountBoolResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(TiebaUtilityAccountAuto.HostUtilityAccount hostUtilityAccount, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityAccount.goToLogin();
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityAccountAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(TiebaUtilityAccountAuto.HostUtilityAccount hostUtilityAccount, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityAccount.showLoginAwardCell(new TiebaUtilityAccountAuto.Result() { // from class: d.a.j0.m0.a.j.h
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAccountAuto.Result
                public final void success(Object obj2) {
                    r2.a(hashMap, reply, (TiebaUtilityAccountAuto.AccountBoolResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityAccountAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void e(TiebaUtilityAccountAuto.HostUtilityAccount hostUtilityAccount, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityAccount.isLogin(new TiebaUtilityAccountAuto.Result() { // from class: d.a.j0.m0.a.j.c
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAccountAuto.Result
                public final void success(Object obj2) {
                    r2.b(hashMap, reply, (TiebaUtilityAccountAuto.AccountBoolResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityAccountAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void f(TiebaUtilityAccountAuto.HostUtilityAccount hostUtilityAccount, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityAccount.jumpRealNameAuthWebActivity();
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityAccountAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void g(BinaryMessenger binaryMessenger, final TiebaUtilityAccountAuto.HostUtilityAccount hostUtilityAccount) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityAccount.goToLogin", new StandardMessageCodec());
        if (hostUtilityAccount != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.j0.m0.a.j.e
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    r2.c(TiebaUtilityAccountAuto.HostUtilityAccount.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityAccount.showLoginAwardCell", new StandardMessageCodec());
        if (hostUtilityAccount != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.j0.m0.a.j.g
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    r2.d(TiebaUtilityAccountAuto.HostUtilityAccount.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityAccount.isLogin", new StandardMessageCodec());
        if (hostUtilityAccount != null) {
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.j0.m0.a.j.f
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    r2.e(TiebaUtilityAccountAuto.HostUtilityAccount.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityAccount.jumpRealNameAuthWebActivity", new StandardMessageCodec());
        if (hostUtilityAccount != null) {
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.j0.m0.a.j.d
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    r2.f(TiebaUtilityAccountAuto.HostUtilityAccount.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
    }
}
