package d.a.o0.n0.a.d;

import com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: ImagePickerAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class e {
    public static /* synthetic */ void a(ImagePickerAuto.HostImagePicker hostImagePicker, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostImagePicker.editUserPortrait();
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ImagePickerAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(ImagePickerAuto.HostImagePicker hostImagePicker, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostImagePicker.takePhoto(ImagePickerAuto.HostParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ImagePickerAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(ImagePickerAuto.HostImagePicker hostImagePicker, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostImagePicker.chosePhotoLibrary(ImagePickerAuto.HostParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ImagePickerAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(ImagePickerAuto.HostImagePicker hostImagePicker, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostImagePicker.savePhoto(ImagePickerAuto.HostParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = ImagePickerAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static void e(BinaryMessenger binaryMessenger, final ImagePickerAuto.HostImagePicker hostImagePicker) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostImagePicker.editUserPortrait", new StandardMessageCodec());
        if (hostImagePicker != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.d.b
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    e.a(ImagePickerAuto.HostImagePicker.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostImagePicker.takePhoto", new StandardMessageCodec());
        if (hostImagePicker != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.d.c
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    e.b(ImagePickerAuto.HostImagePicker.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostImagePicker.chosePhotoLibrary", new StandardMessageCodec());
        if (hostImagePicker != null) {
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.d.a
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    e.c(ImagePickerAuto.HostImagePicker.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostImagePicker.savePhoto", new StandardMessageCodec());
        if (hostImagePicker != null) {
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.o0.n0.a.d.d
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    e.d(ImagePickerAuto.HostImagePicker.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
    }
}
