package d.b.j0.m0.a.f;

import com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: NetworkServiceAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class f {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, NetworkServiceAuto.NetworkResult networkResult) {
        hashMap.put("result", networkResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, NetworkServiceAuto.NetworkResult networkResult) {
        hashMap.put("result", networkResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(NetworkServiceAuto.HostNetworkService hostNetworkService, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostNetworkService.loadData(NetworkServiceAuto.LoadDataParam.fromMap((HashMap) obj), new NetworkServiceAuto.Result() { // from class: d.b.j0.m0.a.f.c
                @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto.Result
                public final void success(Object obj2) {
                    f.a(hashMap, reply, (NetworkServiceAuto.NetworkResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = NetworkServiceAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void d(NetworkServiceAuto.HostNetworkService hostNetworkService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostNetworkService.cancel(NetworkServiceAuto.NetServiceCancelParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = NetworkServiceAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void e(NetworkServiceAuto.HostNetworkService hostNetworkService, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostNetworkService.sendImMessage(NetworkServiceAuto.IMParam.fromMap((HashMap) obj), new NetworkServiceAuto.Result() { // from class: d.b.j0.m0.a.f.a
                @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto.Result
                public final void success(Object obj2) {
                    f.b(hashMap, reply, (NetworkServiceAuto.NetworkResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = NetworkServiceAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void f(BinaryMessenger binaryMessenger, final NetworkServiceAuto.HostNetworkService hostNetworkService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostNetworkService.loadData", new StandardMessageCodec());
        if (hostNetworkService != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.b.j0.m0.a.f.e
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    f.c(NetworkServiceAuto.HostNetworkService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostNetworkService.cancel", new StandardMessageCodec());
        if (hostNetworkService != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.b.j0.m0.a.f.b
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    f.d(NetworkServiceAuto.HostNetworkService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostNetworkService.sendImMessage", new StandardMessageCodec());
        if (hostNetworkService != null) {
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.b.j0.m0.a.f.d
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    f.e(NetworkServiceAuto.HostNetworkService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
    }
}
