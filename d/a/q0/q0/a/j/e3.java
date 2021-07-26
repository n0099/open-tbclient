package d.a.q0.q0.a.j;

import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityStatisticAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityStatisticAuto.java */
/* loaded from: classes8.dex */
public final /* synthetic */ class e3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static /* synthetic */ void a(TiebaUtilityStatisticAuto.HostUtilityStatistic hostUtilityStatistic, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityStatistic.statLogEvent(TiebaUtilityStatisticAuto.StatisticParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityStatisticAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(TiebaUtilityStatisticAuto.HostUtilityStatistic hostUtilityStatistic, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityStatistic.debugLog(TiebaUtilityStatisticAuto.StatisticParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityStatisticAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void c(BinaryMessenger binaryMessenger, final TiebaUtilityStatisticAuto.HostUtilityStatistic hostUtilityStatistic) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, binaryMessenger, hostUtilityStatistic) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityStatistic.statLogEvent", new StandardMessageCodec());
            if (hostUtilityStatistic != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.q0.q0.a.j.d2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            e3.a(TiebaUtilityStatisticAuto.HostUtilityStatistic.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityStatistic.debugLog", new StandardMessageCodec());
            if (hostUtilityStatistic != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.q0.q0.a.j.c2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            e3.b(TiebaUtilityStatisticAuto.HostUtilityStatistic.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
        }
    }
}
