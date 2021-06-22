package d.a.o0.n0.a.j;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityPreferenceAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityPreferenceAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class a3 {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityPreferenceAuto.KVResult kVResult) {
        hashMap.put("result", kVResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityPreferenceAuto.SuccessResult successResult) {
        hashMap.put("result", successResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(TiebaUtilityPreferenceAuto.HostUtilityPreference hostUtilityPreference, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityPreference.preferenceGetValues(TiebaUtilityPreferenceAuto.GetPreferenceParam.fromMap((HashMap) obj), new TiebaUtilityPreferenceAuto.Result() { // from class: d.a.o0.n0.a.j.q1
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityPreferenceAuto.Result
                public final void success(Object obj2) {
                    a3.a(hashMap, reply, (TiebaUtilityPreferenceAuto.KVResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityPreferenceAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void d(TiebaUtilityPreferenceAuto.HostUtilityPreference hostUtilityPreference, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityPreference.preferenceSetValues(TiebaUtilityPreferenceAuto.SetPreferenceParam.fromMap((HashMap) obj), new TiebaUtilityPreferenceAuto.Result() { // from class: d.a.o0.n0.a.j.p1
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityPreferenceAuto.Result
                public final void success(Object obj2) {
                    a3.b(hashMap, reply, (TiebaUtilityPreferenceAuto.SuccessResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityPreferenceAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void e(BinaryMessenger binaryMessenger, final TiebaUtilityPreferenceAuto.HostUtilityPreference hostUtilityPreference) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityPreference.preferenceGetValues", new StandardMessageCodec());
        if (hostUtilityPreference != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.r1
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    a3.c(TiebaUtilityPreferenceAuto.HostUtilityPreference.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityPreference.preferenceSetValues", new StandardMessageCodec());
        if (hostUtilityPreference != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.j.s1
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    a3.d(TiebaUtilityPreferenceAuto.HostUtilityPreference.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
    }
}
