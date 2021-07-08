package d.a.p0.q0.a.j;

import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoCreationCenterAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityVideoCreationCenterAuto.java */
/* loaded from: classes8.dex */
public final /* synthetic */ class g3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static /* synthetic */ void a(TiebaUtilityVideoCreationCenterAuto.HostUtilityVideoCreationCenter hostUtilityVideoCreationCenter, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityVideoCreationCenter.sendThread(TiebaUtilityVideoCreationCenterAuto.VideoCreationCenterSendParams.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityVideoCreationCenterAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void b(BinaryMessenger binaryMessenger, final TiebaUtilityVideoCreationCenterAuto.HostUtilityVideoCreationCenter hostUtilityVideoCreationCenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, binaryMessenger, hostUtilityVideoCreationCenter) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityVideoCreationCenter.sendThread", new StandardMessageCodec());
            if (hostUtilityVideoCreationCenter != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.p0.q0.a.j.s2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            g3.a(TiebaUtilityVideoCreationCenterAuto.HostUtilityVideoCreationCenter.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
        }
    }
}
