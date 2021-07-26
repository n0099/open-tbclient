package d.a.q0.q0.a.f;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: NetworkServiceAuto.java */
/* loaded from: classes8.dex */
public final /* synthetic */ class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            hostNetworkService.loadData(NetworkServiceAuto.LoadDataParam.fromMap((HashMap) obj), new NetworkServiceAuto.Result() { // from class: d.a.q0.q0.a.f.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        f.a(hashMap, reply, (NetworkServiceAuto.NetworkResult) obj2);
                    }
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
            hostNetworkService.sendImMessage(NetworkServiceAuto.IMParam.fromMap((HashMap) obj), new NetworkServiceAuto.Result() { // from class: d.a.q0.q0.a.f.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        f.b(hashMap, reply, (NetworkServiceAuto.NetworkResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = NetworkServiceAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void f(BinaryMessenger binaryMessenger, final NetworkServiceAuto.HostNetworkService hostNetworkService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, binaryMessenger, hostNetworkService) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostNetworkService.loadData", new StandardMessageCodec());
            if (hostNetworkService != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.q0.q0.a.f.e
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            f.c(NetworkServiceAuto.HostNetworkService.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostNetworkService.cancel", new StandardMessageCodec());
            if (hostNetworkService != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.q0.q0.a.f.b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            f.d(NetworkServiceAuto.HostNetworkService.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostNetworkService.sendImMessage", new StandardMessageCodec());
            if (hostNetworkService != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.q0.q0.a.f.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            f.e(NetworkServiceAuto.HostNetworkService.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
        }
    }
}
