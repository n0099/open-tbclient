package d.a.k0.m0.a.a;

import com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: AudioPlayAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class i {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, AudioPlayAuto.AudioResult audioResult) {
        hashMap.put("result", audioResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, AudioPlayAuto.AudioResult audioResult) {
        hashMap.put("result", audioResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(HashMap hashMap, BasicMessageChannel.Reply reply, AudioPlayAuto.AudioResult audioResult) {
        hashMap.put("result", audioResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(HashMap hashMap, BasicMessageChannel.Reply reply, AudioPlayAuto.AudioResult audioResult) {
        hashMap.put("result", audioResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void e(AudioPlayAuto.HostAudioPlay hostAudioPlay, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostAudioPlay.play(AudioPlayAuto.PlayParam.fromMap((HashMap) obj), new AudioPlayAuto.Result() { // from class: d.a.k0.m0.a.a.c
                @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.Result
                public final void success(Object obj2) {
                    i.d(hashMap, reply, (AudioPlayAuto.AudioResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = AudioPlayAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void f(AudioPlayAuto.HostAudioPlay hostAudioPlay, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostAudioPlay.stop(AudioPlayAuto.StopParam.fromMap((HashMap) obj), new AudioPlayAuto.Result() { // from class: d.a.k0.m0.a.a.g
                @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.Result
                public final void success(Object obj2) {
                    i.a(hashMap, reply, (AudioPlayAuto.AudioResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = AudioPlayAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void g(AudioPlayAuto.HostAudioPlay hostAudioPlay, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostAudioPlay.dispose(AudioPlayAuto.DisposeParam.fromMap((HashMap) obj), new AudioPlayAuto.Result() { // from class: d.a.k0.m0.a.a.h
                @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.Result
                public final void success(Object obj2) {
                    i.b(hashMap, reply, (AudioPlayAuto.AudioResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = AudioPlayAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void h(AudioPlayAuto.HostAudioPlay hostAudioPlay, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostAudioPlay.create(AudioPlayAuto.CreateParam.fromMap((HashMap) obj), new AudioPlayAuto.Result() { // from class: d.a.k0.m0.a.a.d
                @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.Result
                public final void success(Object obj2) {
                    i.c(hashMap, reply, (AudioPlayAuto.AudioResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = AudioPlayAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void i(BinaryMessenger binaryMessenger, final AudioPlayAuto.HostAudioPlay hostAudioPlay) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostAudioPlay.create", new StandardMessageCodec());
        if (hostAudioPlay != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.k0.m0.a.a.e
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    i.h(AudioPlayAuto.HostAudioPlay.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostAudioPlay.play", new StandardMessageCodec());
        if (hostAudioPlay != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.k0.m0.a.a.a
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    i.e(AudioPlayAuto.HostAudioPlay.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostAudioPlay.stop", new StandardMessageCodec());
        if (hostAudioPlay != null) {
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.k0.m0.a.a.b
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    i.f(AudioPlayAuto.HostAudioPlay.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostAudioPlay.dispose", new StandardMessageCodec());
        if (hostAudioPlay != null) {
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.k0.m0.a.a.f
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    i.g(AudioPlayAuto.HostAudioPlay.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
    }
}
