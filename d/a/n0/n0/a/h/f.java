package d.a.n0.n0.a.h;

import com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: ProgressHUDAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class f {
    public static /* synthetic */ void a(ProgressHUDAuto.HostProgressHUD hostProgressHUD, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostProgressHUD.showWithImg(ProgressHUDAuto.ImageParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ProgressHUDAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(ProgressHUDAuto.HostProgressHUD hostProgressHUD, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostProgressHUD.showErrorWithStatus(ProgressHUDAuto.StringParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ProgressHUDAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(ProgressHUDAuto.HostProgressHUD hostProgressHUD, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostProgressHUD.showSuccessWithStatus(ProgressHUDAuto.StringParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ProgressHUDAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(ProgressHUDAuto.HostProgressHUD hostProgressHUD, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostProgressHUD.showAttentionWithStatus(ProgressHUDAuto.StringParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ProgressHUDAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void e(ProgressHUDAuto.HostProgressHUD hostProgressHUD, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostProgressHUD.showAttentionWithStatusForTime(ProgressHUDAuto.AttentionTimeParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ProgressHUDAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void f(BinaryMessenger binaryMessenger, final ProgressHUDAuto.HostProgressHUD hostProgressHUD) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostProgressHUD.showWithImg", new StandardMessageCodec());
        if (hostProgressHUD != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.h.c
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    f.a(ProgressHUDAuto.HostProgressHUD.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostProgressHUD.showErrorWithStatus", new StandardMessageCodec());
        if (hostProgressHUD != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.h.b
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    f.b(ProgressHUDAuto.HostProgressHUD.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostProgressHUD.showSuccessWithStatus", new StandardMessageCodec());
        if (hostProgressHUD != null) {
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.h.d
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    f.c(ProgressHUDAuto.HostProgressHUD.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostProgressHUD.showAttentionWithStatus", new StandardMessageCodec());
        if (hostProgressHUD != null) {
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.h.a
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    f.d(ProgressHUDAuto.HostProgressHUD.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostProgressHUD.showAttentionWithStatusForTime", new StandardMessageCodec());
        if (hostProgressHUD != null) {
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.h.e
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    f.e(ProgressHUDAuto.HostProgressHUD.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler(null);
        }
    }
}
