package com.kascend.chushou.c;

import android.support.annotation.Nullable;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.mobstat.Config;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.m;
import com.kascend.chushou.constants.GeneralGift;
import com.kascend.chushou.constants.ParserRet;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.http.Http;
import tv.chushou.basis.http.listener.DownloadListener;
import tv.chushou.basis.http.listener.JsonCallbackWrapper;
import tv.chushou.basis.http.model.RequestTag;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class c {
    private static volatile c nnu = null;
    private long b = 0;

    public static String a(int i) {
        switch (i) {
            case 1:
                return tv.chushou.common.a.dZJ() + "m/quest/index.htm";
            case 2:
                return tv.chushou.common.a.dZJ() + "m/billboard.htm";
            case 3:
                return tv.chushou.common.a.dZJ() + "m/information/flow.htm?category=1&type=-1";
            case 4:
            case 46:
            default:
                return "";
            case 5:
                return tv.chushou.common.a.dZJ() + "m/copyright.htm";
            case 6:
                return tv.chushou.common.a.dZJ() + "m/anchor/verify/process.htm?step=1&isVerify=false";
            case 7:
                return tv.chushou.common.a.dZJ() + "m/anchor/verify/process.htm?step=2&isVerify=false";
            case 8:
                return tv.chushou.common.a.dZJ() + "m/anchor/bank-card.htm?bizCode=ALIYUN";
            case 9:
                return tv.chushou.common.a.dZJ() + "m/pocket/list.htm";
            case 10:
                return tv.chushou.common.a.dZJ() + "m/pocket-store/list.htm";
            case 11:
                return tv.chushou.common.a.dZJ() + "m/anchor/income.htm";
            case 12:
                return tv.chushou.common.a.dZJ() + "m/register.htm";
            case 13:
                return tv.chushou.common.a.dZJ() + "m/find-password.htm";
            case 14:
                return tv.chushou.common.a.dZJ() + "m/agreement/user.htm";
            case 15:
                return tv.chushou.common.a.dZJ() + "m/about.htm";
            case 16:
                return tv.chushou.common.a.dZJ() + "m/beautiful-system.htm";
            case 17:
                return tv.chushou.common.a.dZJ() + "m/help.htm";
            case 18:
                return tv.chushou.common.a.dZJ() + "m/agreement/group.htm";
            case 19:
                return tv.chushou.common.a.dZJ() + "m/password.htm?isVerify=false";
            case 20:
                return tv.chushou.common.a.dZJ() + "m/information/flow.htm?category=2&type=1";
            case 21:
                return tv.chushou.common.a.dZJ() + "m/game/home-data.htm";
            case 22:
                return tv.chushou.common.a.dZJ() + "m/game/my-gift-bag.htm";
            case 23:
                return tv.chushou.common.a.dZJ() + "m/anchor/verify/entrance.htm?bizCode=ALIYUN";
            case 24:
                return tv.chushou.common.a.dZJ() + "m/anchor/center.htm";
            case 25:
                return tv.chushou.common.a.dZJ() + "m/bigfans/list.htm";
            case 26:
                return tv.chushou.common.a.dZJ() + "m/bigfans/pay.htm";
            case 27:
                return tv.chushou.common.a.dZJ() + "m/bigfans/introduce.htm";
            case 28:
                return tv.chushou.common.a.dZJ() + "m/bigfans/detail.htm";
            case 29:
                return tv.chushou.common.a.dZJ() + "m/user/real/name/certification/info.htm?bizCode=ALIYUN";
            case 30:
                return tv.chushou.common.a.dZJ() + "m/agreement/qqgroup.htm";
            case 31:
                return tv.chushou.common.a.dZJ() + "m/qq/group/guide.htm";
            case 32:
                return tv.chushou.common.a.dZJ() + "m/email.htm";
            case 33:
                return tv.chushou.common.a.dZJ() + "m/quest/room.htm?";
            case 34:
                return tv.chushou.common.a.dZJ() + "m/information/flow.htm?category=3&type=2";
            case 35:
                return tv.chushou.common.a.dZJ() + "m/gamezone/video/reward-billboard/";
            case 36:
                return tv.chushou.common.a.dZJ() + "m/user/rank.htm";
            case 37:
                return tv.chushou.common.a.dZJ() + "m/user/privacy/get-opts.htm";
            case 38:
                return tv.chushou.common.a.dZJ() + "m/quest/exchange.htm?";
            case 39:
                return tv.chushou.common.a.dZJ() + "m/achievement/uid.htm?";
            case 40:
                return tv.chushou.common.a.dZJ() + "m/achievement/detail.htm?";
            case 41:
                return tv.chushou.common.a.dZN() + "luck/room/guess/join/introduce.htm?";
            case 42:
                return tv.chushou.common.a.dZN() + "luck/room/guess/user/record.htm?";
            case 43:
                return tv.chushou.common.a.dZN() + "luck/room/guess/top/board.htm?";
            case 44:
                return tv.chushou.common.a.dZJ() + "m/quest/exchange.htm?";
            case 45:
                return tv.chushou.common.a.dZN() + "luck/room/guess/quest-notify.htm?";
            case 47:
                return tv.chushou.common.a.dZJ() + "m/noble/point/about.htm";
            case 48:
                return tv.chushou.common.a.dZJ() + "m/pk-live/audience-rule.htm";
            case 49:
                return tv.chushou.common.a.dZJ() + "m/account-security/login-record/unusual-list.htm";
            case 50:
                return tv.chushou.common.a.dZL() + "api/mic/room/inning/rule.htm";
            case 51:
                return tv.chushou.common.a.dZL() + "api/mic/room/inning/contribute/rank.htm?";
            case 52:
                return tv.chushou.common.a.dZJ() + "m/pk-destiny/scene-view.htm";
            case 53:
                return tv.chushou.common.a.dZJ() + "guide/m/privacy.htm";
            case 54:
                return tv.chushou.common.a.dZJ() + "m/account-security/delete/intro.htm";
            case 55:
                return tv.chushou.common.a.dZJ() + "m/captcha/init.htm";
            case 56:
                return tv.chushou.common.a.dZJ() + "m/timeline/billboard/top.htm";
            case 57:
                return tv.chushou.common.a.dZJ() + "m/timeline/first-reward-tips.htm";
        }
    }

    public static c dMk() {
        if (nnu == null) {
            synchronized (c.class) {
                if (nnu == null) {
                    nnu = new c();
                }
            }
        }
        return nnu;
    }

    private c() {
    }

    public void a(String str, File file, DownloadListener downloadListener) {
        Http http = (Http) tv.chushou.basis.d.b.dZG().S(Http.class);
        if (http != null) {
            http.downloadAsync(str, file, downloadListener);
        }
    }

    public void a(b bVar, String str, boolean z) {
        tv.chushou.zues.utils.e.i("MyHttpMgr", "getHomeMainList() <-----");
        Map<String, Object> hashMap = new HashMap<>(3);
        hashMap.put("breakpoint", str);
        hashMap.put("_v", "2");
        hashMap.put("_reg", z ? "1" : null);
        String d = com.kascend.chushou.d.b.d();
        if (h.isEmpty(d)) {
            d = com.kascend.chushou.d.h.dMo().s();
        }
        hashMap.put("token", d);
        a(tv.chushou.common.a.dZH(), "api/remix-index.htm?", hashMap, bVar);
        tv.chushou.zues.utils.e.i("MyHttpMgr", "getHomeMainList() ----->");
    }

    public void b(b bVar, String str, boolean z) {
        Map<String, Object> hashMap = new HashMap<>(3);
        hashMap.put("breakpoint", str);
        hashMap.put("_reg", z ? "1" : null);
        String d = com.kascend.chushou.d.b.d();
        if (h.isEmpty(d)) {
            d = com.kascend.chushou.d.h.dMo().s();
        }
        hashMap.put("token", d);
        a(tv.chushou.common.a.dZH(), "api/entertainment-index.htm?", hashMap, bVar);
    }

    public void a(b bVar, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", str);
        hashMap.put("_fr", 0);
        hashMap.put("_v", 3);
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str2));
        a(tv.chushou.common.a.dZH(), "api/room/get.htm?", hashMap, bVar);
    }

    public void a(String str, b bVar, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", str);
        hashMap.put("needRelatedRoomList", 1);
        hashMap.put("styleType", str3);
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str2));
        a(tv.chushou.common.a.dZH(), "api/room-expand/get.htm?", hashMap, bVar);
    }

    public void a(String str, b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", str);
        a(tv.chushou.common.a.dZH(), "api/pk-live/info.htm?", hashMap, bVar);
    }

    public void b(String str, b bVar, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", str);
        hashMap.put("uid", str3);
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str2));
        a(tv.chushou.common.a.dZH(), "api/room-space/get.htm?", hashMap, bVar);
    }

    public void a(b bVar, String str, String str2, String str3, long j) {
        if (h.isEmpty(str) || h.isEmpty(str2)) {
            tv.chushou.zues.utils.e.e("MyHttpMgr", "sendDanmu invalid param videoId=" + str + " content=" + str2);
            return;
        }
        String replaceAll = str2.replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
        HashMap hashMap = new HashMap();
        hashMap.put("videoId", str);
        hashMap.put("content", replaceAll);
        hashMap.put("timePoint", Long.valueOf(j));
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str3));
        b(tv.chushou.common.a.dZH(), "api/gamezone/video/barrage/send.htm", hashMap, bVar);
    }

    public void a(final b bVar, final String str, final String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", str);
        hashMap.put("uid", str2);
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str3));
        b(tv.chushou.common.a.dZH(), "api/subscriber/subscribe.htm?", hashMap, new b() { // from class: com.kascend.chushou.c.c.1
            @Override // com.kascend.chushou.c.b
            public void a() {
                if (bVar != null) {
                    bVar.a();
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str4, JSONObject jSONObject) {
                ParserRet dW = a.dW(jSONObject);
                if (bVar != null) {
                    bVar.a(str4, jSONObject);
                }
                if (dW.mRc == 0) {
                    tv.chushou.zues.a.a.post(new m(str2, str, true));
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str4) {
                if (bVar != null) {
                    bVar.a(i, str4);
                }
            }
        });
    }

    public void b(final b bVar, final String str, final String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", str);
        hashMap.put("uid", str2);
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str3));
        b(tv.chushou.common.a.dZH(), "api/subscriber/unsubscribe.htm?", hashMap, new b() { // from class: com.kascend.chushou.c.c.2
            @Override // com.kascend.chushou.c.b
            public void a() {
                if (bVar != null) {
                    bVar.a();
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str4, JSONObject jSONObject) {
                if (a.dW(jSONObject).mRc == 0) {
                    tv.chushou.zues.a.a.post(new m(str2, str, false));
                }
                if (bVar != null) {
                    bVar.a(str4, jSONObject);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str4) {
                if (bVar != null) {
                    bVar.a(i, str4);
                }
            }
        });
    }

    public void a(b bVar, String str) {
        tv.chushou.zues.utils.e.i("MyHttpMgr", "getRecommend() <-----");
        HashMap hashMap = new HashMap(1);
        hashMap.put("roomId", str);
        a(tv.chushou.common.a.dZH(), "api/room/get-recommend.htm?", hashMap, bVar);
        tv.chushou.zues.utils.e.i("MyHttpMgr", "getRecommend() ----->");
    }

    public void b(b bVar, String str) {
        tv.chushou.zues.utils.e.i("MyHttpMgr", "getRecommend() <-----");
        HashMap hashMap = new HashMap(1);
        hashMap.put("roomId", str);
        a(tv.chushou.common.a.dZH(), "api/room/get-recommends.htm?", hashMap, bVar);
        tv.chushou.zues.utils.e.i("MyHttpMgr", "getRecommend() ----->");
    }

    public void a(String str, String str2, long j) {
        HashMap hashMap = new HashMap(6);
        hashMap.put("roomId", str);
        hashMap.put("_timestamp", Long.valueOf(j));
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str2));
        a(tv.chushou.common.a.dZH(), "api/room/heartbeat.htm?", hashMap, (b) null);
    }

    public void c(final b bVar, String str) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("roomId", str);
        a(tv.chushou.common.a.dZH(), "api/user/rank/get.htm?", hashMap, new b() { // from class: com.kascend.chushou.c.c.3
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str2, JSONObject jSONObject) {
                JSONObject optJSONObject;
                if (jSONObject != null && jSONObject.optInt("code", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    Long valueOf = Long.valueOf(optJSONObject.optLong("updatedTime", -1L));
                    if (valueOf.longValue() != -1 && valueOf.longValue() > c.this.b) {
                        c.this.b = valueOf.longValue();
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("rank");
                        if (optJSONObject2 != null) {
                            String optString = optJSONObject2.optString(Config.EVENT_HEAT_POINT, null);
                            if (optString != null) {
                                com.kascend.chushou.d.h.dMo().b(optString, null);
                            }
                            String optString2 = optJSONObject2.optString("noblePoint", null);
                            if (optString2 != null) {
                                com.kascend.chushou.d.h.dMo().a(optString2);
                            }
                            com.kascend.chushou.d.h.dMo().a(optJSONObject2.optInt("nobleState", -1));
                        }
                        if (bVar != null) {
                            bVar.a(str2, jSONObject);
                        }
                    }
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str2) {
            }
        });
    }

    public void d(b bVar, String str) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("ids", str);
        b(tv.chushou.common.a.dZH(), "api/gift/get-batch.htm?", hashMap, bVar);
    }

    public void a(b bVar, String str, int i, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("breakpoint", str2);
        hashMap.put("roomId", str);
        hashMap.put(TbEnum.ParamKey.GROUP, Integer.valueOf(i));
        hashMap.put("count", 20);
        a(tv.chushou.common.a.dZH(), "api/emoji-gift/down.htm?", hashMap, bVar);
    }

    public void b(b bVar, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("breakpoint", str2);
        hashMap.put("keyword", str);
        hashMap.put("count", 20);
        b(tv.chushou.common.a.dZH(), "api/emoji-gift/search.htm?", hashMap, bVar);
    }

    public void a(final b bVar, String str, String str2, String str3, String str4, final int i, final int i2, final GeneralGift generalGift, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("primaryKey", str2);
        hashMap.put("targetKey", str3);
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str4));
        hashMap.put("count", Long.valueOf(j));
        b(tv.chushou.common.a.dZH(), "api/pocket/consume.htm?", hashMap, new b() { // from class: com.kascend.chushou.c.c.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str5, JSONObject jSONObject) {
                int optInt = jSONObject.optInt("code", -1);
                String optString = jSONObject.optString("message", "");
                if (optInt == 0) {
                    try {
                        jSONObject.put("tabIndex", i);
                        jSONObject.put("pos", i2);
                        jSONObject.put("giftObj", generalGift);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (bVar != null) {
                        bVar.a(str5, jSONObject);
                        return;
                    }
                    return;
                }
                a(optInt, optString);
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i3, String str5) {
                if (bVar != null) {
                    bVar.a(i3, str5);
                }
            }
        });
    }

    public void a(final b bVar, String str, String str2, String str3, String str4, String str5, String str6, final int i, final int i2, final GeneralGift generalGift, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("primaryKey", str2);
        hashMap.put("targetKey", str3);
        hashMap.put("uid", str4);
        hashMap.put("roomId", str5);
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str6));
        hashMap.put("count", Long.valueOf(j));
        b(tv.chushou.common.a.dZH(), "api/mic/room/pocket/send.htm?", hashMap, new b() { // from class: com.kascend.chushou.c.c.5
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str7, JSONObject jSONObject) {
                int optInt = jSONObject.optInt("code", -1);
                String optString = jSONObject.optString("message", "");
                if (optInt == 401) {
                    if (h.isEmpty(optString)) {
                        optString = tv.chushou.widget.a.c.getString(a.i.str_login_timeout);
                    }
                    tv.chushou.zues.utils.g.y(optString);
                    com.kascend.chushou.d.e.d();
                } else if (optInt == 0) {
                    try {
                        jSONObject.put("tabIndex", i);
                        jSONObject.put("pos", i2);
                        jSONObject.put("giftObj", generalGift);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (bVar != null) {
                        bVar.a(str7, jSONObject);
                    }
                } else {
                    a(optInt, optString);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i3, String str7) {
                if (bVar != null) {
                    bVar.a(i3, str7);
                }
            }
        });
    }

    public void a(final JsonCallbackWrapper jsonCallbackWrapper, String str, String str2, String str3, long j) {
        HashMap hashMap = new HashMap(7);
        hashMap.put("roomId", str);
        hashMap.put("giftId", str2);
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str3));
        hashMap.put("giftCount", Long.valueOf(j));
        Http http = (Http) tv.chushou.basis.d.b.dZG().S(Http.class);
        if (http != null) {
            http.postAsync(tv.chushou.common.a.dZH(), "api/point-consume/reward.htm?", hashMap, RequestTag.normal(), new JsonCallbackWrapper() { // from class: com.kascend.chushou.c.c.6
                @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
                public void callStart() {
                    if (jsonCallbackWrapper != null) {
                        jsonCallbackWrapper.callStart();
                    }
                }

                @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
                public void callSuccess(String str4, JSONObject jSONObject) {
                    JSONObject optJSONObject;
                    int optInt = jSONObject.optInt("code", -1);
                    jSONObject.optString("message", "");
                    if (optInt == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                        Long valueOf = Long.valueOf(optJSONObject.optLong("updatedTime", -1L));
                        if (valueOf.longValue() > c.this.b) {
                            c.this.b = valueOf.longValue();
                            String optString = optJSONObject.optString(Config.EVENT_HEAT_POINT, null);
                            if (optString != null) {
                                com.kascend.chushou.d.h.dMo().b(optString, null);
                            }
                            String optString2 = optJSONObject.optString("noblePoint", null);
                            if (optString2 != null) {
                                com.kascend.chushou.d.h.dMo().a(optString2);
                            }
                            com.kascend.chushou.d.h.dMo().a(optJSONObject.optInt("nobleState", -1));
                            jsonCallbackWrapper.callSuccess(str4, jSONObject);
                        }
                    }
                }

                @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
                public void callFailure(int i, @Nullable String str4, @Nullable String str5) {
                    if (jsonCallbackWrapper != null) {
                        jsonCallbackWrapper.callFailure(i, str4, str5);
                    }
                }
            });
        }
    }

    public void a(final JsonCallbackWrapper jsonCallbackWrapper, String str, String str2, String str3, String str4, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("giftId", str2);
        hashMap.put("roomId", str3);
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str4));
        hashMap.put("count", Long.valueOf(j));
        hashMap.put("_v", 1);
        Http http = (Http) tv.chushou.basis.d.b.dZG().S(Http.class);
        if (http != null) {
            http.postAsync(tv.chushou.common.a.dZH(), "api/mic/room/gift/send.htm?", hashMap, RequestTag.normal(), new JsonCallbackWrapper() { // from class: com.kascend.chushou.c.c.7
                @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
                public void callStart() {
                    if (jsonCallbackWrapper != null) {
                        jsonCallbackWrapper.callStart();
                    }
                }

                @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
                public void callSuccess(String str5, JSONObject jSONObject) {
                    JSONObject optJSONObject;
                    int optInt = jSONObject.optInt("code", -1);
                    jSONObject.optString("message", "");
                    if (optInt == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                        Long valueOf = Long.valueOf(optJSONObject.optLong("updatedTime", -1L));
                        if (valueOf.longValue() > c.this.b) {
                            c.this.b = valueOf.longValue();
                            String optString = optJSONObject.optString(Config.EVENT_HEAT_POINT, null);
                            if (optString != null) {
                                com.kascend.chushou.d.h.dMo().b(optString, null);
                            }
                            String optString2 = optJSONObject.optString("noblePoint", null);
                            if (optString2 != null) {
                                com.kascend.chushou.d.h.dMo().a(optString2);
                            }
                            com.kascend.chushou.d.h.dMo().a(optJSONObject.optInt("nobleState", -1));
                            jsonCallbackWrapper.callSuccess(str5, jSONObject);
                        }
                    }
                }

                @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
                public void callFailure(int i, @Nullable String str5, @Nullable String str6) {
                    if (jsonCallbackWrapper != null) {
                        jsonCallbackWrapper.callFailure(i, str5, str6);
                    }
                }
            });
        }
    }

    public void a(b bVar, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("type", str);
        hashMap.put("targetKey", str2);
        hashMap.put(DownloadDataConstants.Columns.COLUMN_URI, str4);
        hashMap.put("index", str3);
        b(tv.chushou.common.a.dZH(), "api/upload/notify.htm?", hashMap, bVar);
    }

    public void a(String str, String str2, int i, b bVar) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("roomId", str);
        hashMap.put("uid", str2);
        hashMap.put("type", Integer.valueOf(i));
        b(tv.chushou.common.a.dZH(), "api/chat/privilege/ban.htm", hashMap, bVar);
    }

    public void a(String str, String str2, b bVar) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("roomId", str);
        hashMap.put("keyword", str2);
        b(tv.chushou.common.a.dZH(), "api/rec/room/manager/add.htm", hashMap, bVar);
    }

    public void c(b bVar, String str, String str2, String str3) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("reportedUid", str);
        hashMap.put("reportedRoomId", str2);
        hashMap.put("type", str3);
        b(tv.chushou.common.a.dZH(), "api/report/add.htm?", hashMap, bVar);
    }

    public void a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap(8);
        hashMap.put("sourceId", str);
        hashMap.put("targetKey", str2);
        hashMap.put("type", str4);
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str3));
        a(tv.chushou.common.a.dZH(), "api/share/feedback.htm?", hashMap, (b) null);
    }

    public void b(String str, String str2, b bVar) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("uid", str2);
        hashMap.put("roomId", str);
        b(tv.chushou.common.a.dZH(), "api/room/blacklist-user/add.htm?", hashMap, bVar);
    }

    public void a(String str, String str2, String str3, b bVar) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("roomId", str2);
        hashMap.put("uid", str);
        hashMap.put("showName", str3);
        a(tv.chushou.common.a.dZH(), "api/user-card/get.htm?", hashMap, bVar);
    }

    public void e(b bVar, String str) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("opts", str);
        b(tv.chushou.common.a.dZH(), "api/user/privacy/set-opts.htm", hashMap, bVar);
    }

    public void c(b bVar, String str, String str2) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("type", str);
        hashMap.put("targetKey", str2);
        a(tv.chushou.common.a.dZH(), "api/share/info.htm", hashMap, bVar);
    }

    public void a(int i, b bVar) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("type", 26);
        hashMap.put("primaryKey", 1);
        hashMap.put("count", Integer.valueOf(i));
        b(tv.chushou.common.a.dZH(), "api/pocket/purchase.htm", hashMap, bVar);
    }

    public void c(String str, String str2, b bVar) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("targetKey", str);
        hashMap.put("extraInfo", str2);
        b(tv.chushou.common.a.dZH(), "api/pocket/trumpet-consume.htm", hashMap, bVar);
    }

    public void b(String str, b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("giftId", str);
        b(tv.chushou.common.a.dZH(), "api/emoji-gift/detail.htm?", hashMap, bVar);
    }

    public void a(String str, String str2, String str3, String str4, b bVar) {
        String d = com.kascend.chushou.d.b.d();
        if (h.isEmpty(d)) {
            d = com.kascend.chushou.d.h.dMo().s();
        }
        Map<String, Object> hashMap = new HashMap<>(5);
        hashMap.put("codes", str);
        hashMap.put("screenWidth", str2);
        hashMap.put("screenHeight", str3);
        hashMap.put("roomId", str4);
        hashMap.put("token", d);
        a(tv.chushou.common.a.dZM(), "api/advert/getList.htm", hashMap, bVar);
    }

    public void a(JsonCallbackWrapper jsonCallbackWrapper, String str, String str2, String str3, String str4) {
        if (h.isEmpty(str) || h.isEmpty(str2) || h.isEmpty(str3)) {
            tv.chushou.zues.utils.e.e("MyHttpMgr", "sendDanmu invalid param roomid=" + str + " token=" + str2 + " content=" + str3);
            return;
        }
        String replaceAll = str3.replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", str);
        hashMap.put("content", replaceAll);
        hashMap.putAll(tv.chushou.zues.utils.d.TS(str4));
        Http http = (Http) tv.chushou.basis.d.b.dZG().S(Http.class);
        if (http != null) {
            http.postAsync(tv.chushou.common.a.dZH(), "open/chat/send.htm", hashMap, RequestTag.normal(), jsonCallbackWrapper);
        }
    }

    public void d(b bVar, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", str);
        hashMap.put("breakpoint", str2);
        hashMap.put("_ltn", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("style", 2);
        a(tv.chushou.common.a.dZK(), "chat/get.htm?", hashMap, bVar);
    }

    public void a(final tv.chushou.basis.d.a.c.a<String> aVar) {
        Http http = (Http) tv.chushou.basis.d.b.dZG().S(Http.class);
        if (http != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("method", "common.getUpdateVersionInfo");
            hashMap.put(HttpConstants.HTTP_OS_TYPE_OLD, "1");
            hashMap.put("app_parent", "com.kascend.chushouplugin");
            hashMap.put("targetVersion", 109);
            tv.chushou.basis.d.a.b.b bVar = (tv.chushou.basis.d.a.b.b) tv.chushou.basis.d.b.dZG().S(tv.chushou.basis.d.a.b.b.class);
            if (bVar != null) {
                hashMap.put("appkey", bVar.getAppKey());
            }
            hashMap.put("format", "json");
            RequestTag requestTag = new RequestTag();
            requestTag.signType = 1;
            requestTag.signKey = "appsig";
            requestTag.signSecret = "HAL$#%^RTYDFGdktsf_)(*^%$";
            requestTag.respType = String.class;
            requestTag.supportEmpty = false;
            requestTag.thread = EventThread.IO;
            requestTag.executorService = null;
            requestTag.callbackThread = EventThread.IO;
            http.getAsync(tv.chushou.common.a.dZI(), "osmcommon?", hashMap, requestTag, new tv.chushou.basis.d.a.c.a<Http.Resp>() { // from class: com.kascend.chushou.c.c.8
                @Override // tv.chushou.basis.d.a.c.a
                public void onStart() {
                    if (aVar != null) {
                        aVar.onStart();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.basis.d.a.c.a
                /* renamed from: a */
                public void onSuccess(Http.Resp resp) {
                    if (resp.respString != null) {
                        if (aVar != null) {
                            aVar.onSuccess(resp.respString);
                            return;
                        }
                        return;
                    }
                    onFailure(-1, "", null);
                }

                @Override // tv.chushou.basis.d.a.c.a
                public void onFailure(int i, @Nullable String str, @Nullable Throwable th) {
                    if (aVar != null) {
                        aVar.onFailure(-1, "", th);
                    }
                }
            });
        }
    }

    public void c(String str, b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", str);
        a(tv.chushou.common.a.dZH(), "api/live-switch/get.htm?", hashMap, bVar);
    }

    public void d(String str, String str2, b bVar) {
        if (!h.isEmpty(str) && !h.isEmpty(str2)) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("code", str2);
            a(str, "", hashMap, bVar);
        }
    }

    public void a(String str) {
        if (!h.isEmpty(str)) {
            a(str, "", (Map<String, Object>) null, (b) null);
        }
    }

    public void d(String str, b bVar) {
        a(str, "", (Map<String, Object>) null, bVar);
    }

    public void a(String str, String str2, String str3, JsonCallbackWrapper jsonCallbackWrapper) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("openUid", str);
        hashMap.put("accessToken", str2);
        hashMap.put("extraInfo", str3);
        Http http = (Http) tv.chushou.basis.d.b.dZG().S(Http.class);
        if (http != null) {
            http.postAsync(tv.chushou.common.a.dZO(), "xapi/open-login.htm", hashMap, RequestTag.normal(), jsonCallbackWrapper);
        }
    }

    public void e(String str, b bVar) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("code", str);
        b(tv.chushou.common.a.dZO(), "open/baidu/login.htm", hashMap, bVar);
    }

    public void a(b bVar) {
        a(tv.chushou.common.a.dZH(), "open/baidu/share-room-list.htm", (Map<String, Object>) null, bVar);
    }

    public void a(JsonCallbackWrapper jsonCallbackWrapper) {
        String d = com.kascend.chushou.d.b.d();
        if (h.isEmpty(d)) {
            d = com.kascend.chushou.d.h.dMo().s();
        }
        HashMap hashMap = new HashMap(7);
        hashMap.put("token", d);
        Http http = (Http) tv.chushou.basis.d.b.dZG().S(Http.class);
        if (http != null) {
            http.getAsync(tv.chushou.common.a.dZH(), "api/token/get-complex-info.htm?", hashMap, RequestTag.normal(), jsonCallbackWrapper);
        }
    }

    public void b(JsonCallbackWrapper jsonCallbackWrapper) {
        Http http = (Http) tv.chushou.basis.d.b.dZG().S(Http.class);
        if (http != null) {
            http.postAsync(tv.chushou.common.a.dZH(), "api/logout.htm?", null, RequestTag.normal(), jsonCallbackWrapper);
        }
    }

    public void a(String str, String str2, Map<String, Object> map, b bVar) {
        Http http = (Http) tv.chushou.basis.d.b.dZG().S(Http.class);
        if (http != null) {
            http.getAsync(str, str2, map, RequestTag.normal(), new com.kascend.chushou.c.a.a(bVar));
        }
    }

    public void b(String str, String str2, Map<String, Object> map, b bVar) {
        Http http = (Http) tv.chushou.basis.d.b.dZG().S(Http.class);
        if (http != null) {
            http.postAsync(str, str2, map, RequestTag.normal(), new com.kascend.chushou.c.a.a(bVar));
        }
    }
}
