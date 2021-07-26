package d.a.q0.q0.a.a;

import com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: AudioPlayAuto.java */
/* loaded from: classes8.dex */
public final /* synthetic */ class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            hostAudioPlay.create(AudioPlayAuto.CreateParam.fromMap((HashMap) obj), new AudioPlayAuto.Result() { // from class: d.a.q0.q0.a.a.e
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        i.a(hashMap, reply, (AudioPlayAuto.AudioResult) obj2);
                    }
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
            hostAudioPlay.play(AudioPlayAuto.PlayParam.fromMap((HashMap) obj), new AudioPlayAuto.Result() { // from class: d.a.q0.q0.a.a.f
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        i.b(hashMap, reply, (AudioPlayAuto.AudioResult) obj2);
                    }
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
            hostAudioPlay.stop(AudioPlayAuto.StopParam.fromMap((HashMap) obj), new AudioPlayAuto.Result() { // from class: d.a.q0.q0.a.a.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        i.c(hashMap, reply, (AudioPlayAuto.AudioResult) obj2);
                    }
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
            hostAudioPlay.dispose(AudioPlayAuto.DisposeParam.fromMap((HashMap) obj), new AudioPlayAuto.Result() { // from class: d.a.q0.q0.a.a.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.Result
                public final void success(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, obj2) == null) {
                        i.d(hashMap, reply, (AudioPlayAuto.AudioResult) obj2);
                    }
                }
            });
        } catch (Exception e2) {
            wrapError = AudioPlayAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void i(BinaryMessenger binaryMessenger, final AudioPlayAuto.HostAudioPlay hostAudioPlay) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, binaryMessenger, hostAudioPlay) == null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostAudioPlay.create", new StandardMessageCodec());
            if (hostAudioPlay != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.q0.q0.a.a.c
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            i.e(AudioPlayAuto.HostAudioPlay.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostAudioPlay.play", new StandardMessageCodec());
            if (hostAudioPlay != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.q0.q0.a.a.b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            i.f(AudioPlayAuto.HostAudioPlay.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostAudioPlay.stop", new StandardMessageCodec());
            if (hostAudioPlay != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.q0.q0.a.a.g
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            i.g(AudioPlayAuto.HostAudioPlay.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostAudioPlay.dispose", new StandardMessageCodec());
            if (hostAudioPlay != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.q0.q0.a.a.h
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) {
                            i.h(AudioPlayAuto.HostAudioPlay.this, obj, reply);
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
        }
    }
}
