package d.b.i0.m0.a.c;

import com.baidu.tieba.flutter.plugin.imageLoader.ImageLoaderAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: ImageLoaderAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class d {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, ImageLoaderAuto.ImageResult imageResult) {
        hashMap.put("result", imageResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(ImageLoaderAuto.HostImageLoader hostImageLoader, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostImageLoader.loadImage(ImageLoaderAuto.RequestParam.fromMap((HashMap) obj), new ImageLoaderAuto.Result() { // from class: d.b.i0.m0.a.c.a
                @Override // com.baidu.tieba.flutter.plugin.imageLoader.ImageLoaderAuto.Result
                public final void success(Object obj2) {
                    d.a(hashMap, reply, (ImageLoaderAuto.ImageResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = ImageLoaderAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void c(ImageLoaderAuto.HostImageLoader hostImageLoader, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostImageLoader.cancel(ImageLoaderAuto.ImageLoaderCancelParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ImageLoaderAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void d(BinaryMessenger binaryMessenger, final ImageLoaderAuto.HostImageLoader hostImageLoader) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostImageLoader.loadImage", new StandardMessageCodec());
        if (hostImageLoader != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.b.i0.m0.a.c.b
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    d.b(ImageLoaderAuto.HostImageLoader.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostImageLoader.cancel", new StandardMessageCodec());
        if (hostImageLoader != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.b.i0.m0.a.c.c
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    d.c(ImageLoaderAuto.HostImageLoader.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
    }
}
