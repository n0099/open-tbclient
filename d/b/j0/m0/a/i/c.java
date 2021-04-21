package d.b.j0.m0.a.i;

import com.baidu.tieba.flutter.plugin.tiebaShare.TiebaShareAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaShareAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class c {
    public static /* synthetic */ void a(TiebaShareAuto.HostTiebaShare hostTiebaShare, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostTiebaShare.shareThread(TiebaShareAuto.ShareThreadParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaShareAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(TiebaShareAuto.HostTiebaShare hostTiebaShare, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostTiebaShare.shareGameItemDetails(TiebaShareAuto.GameDetailsParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaShareAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void c(BinaryMessenger binaryMessenger, final TiebaShareAuto.HostTiebaShare hostTiebaShare) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostTiebaShare.shareThread", new StandardMessageCodec());
        if (hostTiebaShare != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.b.j0.m0.a.i.a
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    c.a(TiebaShareAuto.HostTiebaShare.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostTiebaShare.shareGameItemDetails", new StandardMessageCodec());
        if (hostTiebaShare != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.b.j0.m0.a.i.b
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    c.b(TiebaShareAuto.HostTiebaShare.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
    }
}
