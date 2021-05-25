package d.a.n0.n0.a.j;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* compiled from: TiebaUtilityVideoAuto.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class d3 {
    public static /* synthetic */ void a(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityVideoAuto.ResumeTimeResult resumeTimeResult) {
        hashMap.put("result", resumeTimeResult.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void b(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityVideoAuto.VideoBoolValue videoBoolValue) {
        hashMap.put("result", videoBoolValue.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void c(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityVideoAuto.CachePosition cachePosition) {
        hashMap.put("result", cachePosition.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void d(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityVideoAuto.VideoBoolValue videoBoolValue) {
        hashMap.put("result", videoBoolValue.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void e(HashMap hashMap, BasicMessageChannel.Reply reply, TiebaUtilityVideoAuto.VideoBoolValue videoBoolValue) {
        hashMap.put("result", videoBoolValue.toMap());
        reply.reply(hashMap);
    }

    public static /* synthetic */ void f(TiebaUtilityVideoAuto.HostUtilityVideo hostUtilityVideo, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityVideo.getResumeTimeForVideo(TiebaUtilityVideoAuto.VideoStringParam.fromMap((HashMap) obj), new TiebaUtilityVideoAuto.Result() { // from class: d.a.n0.n0.a.j.d2
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.Result
                public final void success(Object obj2) {
                    d3.a(hashMap, reply, (TiebaUtilityVideoAuto.ResumeTimeResult) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityVideoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void g(TiebaUtilityVideoAuto.HostUtilityVideo hostUtilityVideo, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityVideo.updateTime(TiebaUtilityVideoAuto.VideoTimeParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityVideoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void h(TiebaUtilityVideoAuto.HostUtilityVideo hostUtilityVideo, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityVideo.isVideoCardMute(new TiebaUtilityVideoAuto.Result() { // from class: d.a.n0.n0.a.j.q2
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.Result
                public final void success(Object obj2) {
                    d3.b(hashMap, reply, (TiebaUtilityVideoAuto.VideoBoolValue) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityVideoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void i(TiebaUtilityVideoAuto.HostUtilityVideo hostUtilityVideo, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityVideo.setVideoCardMute(TiebaUtilityVideoAuto.VideoBoolValue.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityVideoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void j(TiebaUtilityVideoAuto.HostUtilityVideo hostUtilityVideo, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityVideo.videoPositionCacheManagerUpdate(TiebaUtilityVideoAuto.VideoTimeParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityVideoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void k(TiebaUtilityVideoAuto.HostUtilityVideo hostUtilityVideo, Object obj, BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        HashMap hashMap = new HashMap();
        try {
            hostUtilityVideo.videoPositionCacheManagerRemove(TiebaUtilityVideoAuto.VideoStringParam.fromMap((HashMap) obj));
            hashMap.put("result", null);
        } catch (Exception e2) {
            wrapError = TiebaUtilityVideoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void l(TiebaUtilityVideoAuto.HostUtilityVideo hostUtilityVideo, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityVideo.videoPositionCacheManagerGetCachePosition(TiebaUtilityVideoAuto.VideoStringParam.fromMap((HashMap) obj), new TiebaUtilityVideoAuto.Result() { // from class: d.a.n0.n0.a.j.o2
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.Result
                public final void success(Object obj2) {
                    d3.c(hashMap, reply, (TiebaUtilityVideoAuto.CachePosition) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityVideoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void m(TiebaUtilityVideoAuto.HostUtilityVideo hostUtilityVideo, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityVideo.getVideoMute(new TiebaUtilityVideoAuto.Result() { // from class: d.a.n0.n0.a.j.m2
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.Result
                public final void success(Object obj2) {
                    d3.d(hashMap, reply, (TiebaUtilityVideoAuto.VideoBoolValue) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityVideoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void n(TiebaUtilityVideoAuto.HostUtilityVideo hostUtilityVideo, Object obj, final BasicMessageChannel.Reply reply) {
        HashMap wrapError;
        final HashMap hashMap = new HashMap();
        try {
            hostUtilityVideo.setVideoMute(TiebaUtilityVideoAuto.VideoBoolValue.fromMap((HashMap) obj), new TiebaUtilityVideoAuto.Result() { // from class: d.a.n0.n0.a.j.g2
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.Result
                public final void success(Object obj2) {
                    d3.e(hashMap, reply, (TiebaUtilityVideoAuto.VideoBoolValue) obj2);
                }
            });
        } catch (Exception e2) {
            wrapError = TiebaUtilityVideoAuto.wrapError(e2);
            hashMap.put("error", wrapError);
            reply.reply(hashMap);
        }
    }

    public static void o(BinaryMessenger binaryMessenger, final TiebaUtilityVideoAuto.HostUtilityVideo hostUtilityVideo) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityVideo.getResumeTimeForVideo", new StandardMessageCodec());
        if (hostUtilityVideo != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.e2
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    d3.f(TiebaUtilityVideoAuto.HostUtilityVideo.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityVideo.updateTime", new StandardMessageCodec());
        if (hostUtilityVideo != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.l2
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    d3.g(TiebaUtilityVideoAuto.HostUtilityVideo.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityVideo.isVideoCardMute", new StandardMessageCodec());
        if (hostUtilityVideo != null) {
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.i2
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    d3.h(TiebaUtilityVideoAuto.HostUtilityVideo.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityVideo.setVideoCardMute", new StandardMessageCodec());
        if (hostUtilityVideo != null) {
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.k2
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    d3.i(TiebaUtilityVideoAuto.HostUtilityVideo.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityVideo.videoPositionCacheManagerUpdate", new StandardMessageCodec());
        if (hostUtilityVideo != null) {
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.h2
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    d3.j(TiebaUtilityVideoAuto.HostUtilityVideo.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityVideo.videoPositionCacheManagerRemove", new StandardMessageCodec());
        if (hostUtilityVideo != null) {
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.p2
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    d3.k(TiebaUtilityVideoAuto.HostUtilityVideo.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityVideo.videoPositionCacheManagerGetCachePosition", new StandardMessageCodec());
        if (hostUtilityVideo != null) {
            basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.n2
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    d3.l(TiebaUtilityVideoAuto.HostUtilityVideo.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel7.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityVideo.getVideoMute", new StandardMessageCodec());
        if (hostUtilityVideo != null) {
            basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.f2
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    d3.m(TiebaUtilityVideoAuto.HostUtilityVideo.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel8.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.HostUtilityVideo.setVideoMute", new StandardMessageCodec());
        if (hostUtilityVideo != null) {
            basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: d.a.n0.n0.a.j.j2
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    d3.n(TiebaUtilityVideoAuto.HostUtilityVideo.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel9.setMessageHandler(null);
        }
    }
}
