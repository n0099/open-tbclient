package com.kascend.chushou.player.c;

import android.support.annotation.Nullable;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.PlayUrl;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import tv.chushou.a.a.b.b;
import tv.chushou.basis.http.Http;
import tv.chushou.basis.http.model.RequestTag;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class a {
    private static volatile a mJO = null;
    private ExecutorService b = Executors.newFixedThreadPool(3, new b("ParserMgr", 0));
    private final RequestTag mJP = new RequestTag();

    /* renamed from: com.kascend.chushou.player.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0799a {
        void a(ParserRet parserRet);
    }

    public static a dET() {
        if (mJO == null) {
            synchronized (a.class) {
                if (mJO == null) {
                    mJO = new a();
                }
            }
        }
        return mJO;
    }

    private a() {
        this.mJP.signType = 1;
        this.mJP.thread = EventThread.EXECUTOR;
        this.mJP.executorService = this.b;
        this.mJP.supportEmpty = false;
        this.mJP.respType = JSONObject.class;
    }

    public static void b() {
    }

    public static String b(PlayUrl playUrl) {
        if (playUrl == null) {
            return null;
        }
        return playUrl.mSelectedUrl;
    }

    public void a(String str, String str2, final InterfaceC0799a interfaceC0799a) {
        if (interfaceC0799a == null) {
            e.e("ParserMgr", "callback is null");
        } else if (h.isEmpty(str) || h.isEmpty(str2)) {
            e.e("ParserMgr", "getPlayUrlAsync invalid param");
        } else {
            e.d("ParserMgr", "getPlayUrlAsync()<----");
            e.d("ParserMgr", "roomid=" + str + " protocal=" + str2);
            Http http = (Http) tv.chushou.basis.d.b.dRm().S(Http.class);
            ParserRet parserRet = new ParserRet();
            parserRet.mRc = -1;
            if (http == null) {
                interfaceC0799a.a(parserRet);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("roomId", str);
            hashMap.put(WebSocketRequest.PARAM_KEY_PROTOCOLS, str2);
            hashMap.put("_v", "1");
            http.getAsync(tv.chushou.common.a.dRn(), "api/live-room/get-play-url.htm?", hashMap, this.mJP, new tv.chushou.basis.d.a.c.a<Http.Resp>() { // from class: com.kascend.chushou.player.c.a.1
                @Override // tv.chushou.basis.d.a.c.a
                public void onStart() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.basis.d.a.c.a
                /* renamed from: a */
                public void onSuccess(Http.Resp resp) {
                    if (resp.respJson != null) {
                        int optInt = resp.respJson.optInt("code", -1);
                        if (optInt == 0) {
                            interfaceC0799a.a(com.kascend.chushou.c.e.dJ(resp.respJson));
                            return;
                        }
                        onFailure(optInt, "", null);
                        return;
                    }
                    onFailure(-1, "", null);
                }

                @Override // tv.chushou.basis.d.a.c.a
                public void onFailure(int i, @Nullable String str3, @Nullable Throwable th) {
                    ParserRet parserRet2 = new ParserRet();
                    parserRet2.mRc = -1;
                    interfaceC0799a.a(parserRet2);
                }
            });
        }
    }

    public ParserRet fL(final String str, final String str2) {
        e.d("ParserMgr", "getPlayUrlSync()<----");
        ParserRet parserRet = new ParserRet();
        parserRet.mRc = -1;
        if (h.isEmpty(str) || h.isEmpty(str2)) {
            e.e("ParserMgr", "getPlayUrlSync invalid param");
            return parserRet;
        }
        try {
            FutureTask futureTask = new FutureTask(new Callable<ParserRet>() { // from class: com.kascend.chushou.player.c.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dEU */
                public ParserRet call() throws Exception {
                    return a.this.G(str, str2, true);
                }
            });
            this.b.submit(futureTask);
            e.d("ParserMgr", "getPlayUrlSync()---->");
            return (ParserRet) futureTask.get(2L, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.e("ParserMgr", "getPlayUrlSync error=" + e.toString());
            return parserRet;
        }
    }

    public void a(String str, final InterfaceC0799a interfaceC0799a, boolean z) {
        e.d("ParserMgr", "getVideoPlayUrlAsync()<----");
        if (interfaceC0799a != null && !h.isEmpty(str)) {
            ParserRet parserRet = new ParserRet();
            parserRet.mRc = -1;
            Http http = (Http) tv.chushou.basis.d.b.dRm().S(Http.class);
            if (http == null) {
                interfaceC0799a.a(parserRet);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("videoId", str);
            hashMap.put("_v", 1);
            hashMap.put("auto", z ? "1" : "0");
            http.getAsync(tv.chushou.common.a.dRn(), "api/gamezone/playinfo/get.htm?", hashMap, this.mJP, new tv.chushou.basis.d.a.c.a<Http.Resp>() { // from class: com.kascend.chushou.player.c.a.3
                @Override // tv.chushou.basis.d.a.c.a
                public void onStart() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.basis.d.a.c.a
                /* renamed from: a */
                public void onSuccess(Http.Resp resp) {
                    if (resp.respJson != null) {
                        int optInt = resp.respJson.optInt("code", -1);
                        if (optInt == 0) {
                            interfaceC0799a.a(com.kascend.chushou.c.e.dJ(resp.respJson));
                            return;
                        }
                        onFailure(optInt, "", null);
                        return;
                    }
                    onFailure(-1, "", null);
                }

                @Override // tv.chushou.basis.d.a.c.a
                public void onFailure(int i, @Nullable String str2, @Nullable Throwable th) {
                    ParserRet parserRet2 = new ParserRet();
                    parserRet2.mRc = -1;
                    interfaceC0799a.a(parserRet2);
                }
            });
        }
    }

    public ParserRet aZ(final String str, final boolean z) {
        e.d("ParserMgr", "getVideoPlayUrlSync()<----");
        ParserRet parserRet = new ParserRet();
        parserRet.mRc = -1;
        if (h.isEmpty(str)) {
            e.e("ParserMgr", "getVideoPlayUrlSync invalid param");
            return parserRet;
        }
        try {
            FutureTask futureTask = new FutureTask(new Callable<ParserRet>() { // from class: com.kascend.chushou.player.c.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dEU */
                public ParserRet call() throws Exception {
                    return a.this.n(str, true, z);
                }
            });
            this.b.submit(futureTask);
            e.d("ParserMgr", "getVideoPlayUrlSync()---->");
            return (ParserRet) futureTask.get(2L, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.e("ParserMgr", "getVideoPlayUrlSync error=", e);
            return parserRet;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ParserRet G(String str, String str2, boolean z) {
        ParserRet parserRet;
        Http.Resp sync;
        ParserRet parserRet2 = new ParserRet();
        parserRet2.mRc = -1;
        Http http = (Http) tv.chushou.basis.d.b.dRm().S(Http.class);
        if (http != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("roomId", str);
            hashMap.put(WebSocketRequest.PARAM_KEY_PROTOCOLS, str2);
            hashMap.put("_v", "1");
            try {
                sync = http.getSync(tv.chushou.common.a.dRn(), "api/live-room/get-play-url.htm?", hashMap, this.mJP);
            } catch (Exception e) {
                tv.chushou.basis.d.b.dRl().e("ParserMgr", "同步获取直播地址失败", e);
            }
            if (sync.respJson != null) {
                int optInt = sync.respJson.optInt("code", -1);
                if (z && optInt == 602) {
                    return G(str, str2, false);
                }
                parserRet = com.kascend.chushou.c.e.dJ(sync.respJson);
                return parserRet;
            }
            parserRet = parserRet2;
            return parserRet;
        }
        return parserRet2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ParserRet n(String str, boolean z, boolean z2) {
        ParserRet parserRet;
        Http.Resp sync;
        ParserRet parserRet2 = new ParserRet();
        parserRet2.mRc = -1;
        Http http = (Http) tv.chushou.basis.d.b.dRm().S(Http.class);
        if (http != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("videoId", str);
            hashMap.put("_v", 1);
            hashMap.put("auto", z2 ? "1" : "0");
            try {
                sync = http.getSync(tv.chushou.common.a.dRn(), "api/gamezone/playinfo/get.htm?", hashMap, this.mJP);
            } catch (Exception e) {
                tv.chushou.basis.d.b.dRl().e("ParserMgr", "同步获取视频地址失败", e);
            }
            if (sync.respJson != null) {
                int optInt = sync.respJson.optInt("code", -1);
                if (z && optInt == 602) {
                    return n(str, false, z2);
                }
                parserRet = com.kascend.chushou.c.e.dJ(sync.respJson);
                return parserRet;
            }
            parserRet = parserRet2;
            return parserRet;
        }
        return parserRet2;
    }
}
