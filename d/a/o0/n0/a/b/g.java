package d.a.o0.n0.a.b;

import com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: GlobalStateSyncAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class g {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, GlobalStateSyncAuto.AllStateData allStateData) {
        hashMap.put("result", allStateData.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, GlobalStateSyncAuto.SingleTypeStateData singleTypeStateData) {
        hashMap.put("result", singleTypeStateData.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(GlobalStateSyncAuto.HostGlobalStateSync hostGlobalStateSync, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostGlobalStateSync.readAllState(new GlobalStateSyncAuto.Result() { // from class: d.a.o0.n0.a.b.d
                @Override // com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto.Result
                public final void success(Object obj2) {
                    g.a(hashMap, reply, (GlobalStateSyncAuto.AllStateData) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = GlobalStateSyncAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void d(GlobalStateSyncAuto.HostGlobalStateSync hostGlobalStateSync, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostGlobalStateSync.readStateForType(GlobalStateSyncAuto.readParam.fromMap((HashMap) obj), new GlobalStateSyncAuto.Result() { // from class: d.a.o0.n0.a.b.b
                @Override // com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto.Result
                public final void success(Object obj2) {
                    g.b(hashMap, reply, (GlobalStateSyncAuto.SingleTypeStateData) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = GlobalStateSyncAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void e(GlobalStateSyncAuto.HostGlobalStateSync hostGlobalStateSync, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostGlobalStateSync.write(GlobalStateSyncAuto.SingleTypeStateData.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = GlobalStateSyncAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void f(BinaryMessenger binaryMessenger, final GlobalStateSyncAuto.HostGlobalStateSync hostGlobalStateSync) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostGlobalStateSync.readAllState", new StandardMessageCodec());
        if (hostGlobalStateSync != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.b.f
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    g.c(GlobalStateSyncAuto.HostGlobalStateSync.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostGlobalStateSync.readStateForType", new StandardMessageCodec());
        if (hostGlobalStateSync != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.b.e
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    g.d(GlobalStateSyncAuto.HostGlobalStateSync.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostGlobalStateSync.write", new StandardMessageCodec());
        if (hostGlobalStateSync != null) {
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.b.c
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    g.e(GlobalStateSyncAuto.HostGlobalStateSync.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
    }
}
