package d.b.j0.m1;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final List<d.b.j0.m1.j.a> f58766a = new ArrayList();

    public static void a(Context context) {
        d.b.j0.q1.a.h().y(context, "");
    }

    public static void b(Context context, String str, HashMap<String, Object> hashMap) {
        String str2;
        if (hashMap != null) {
            String str3 = (String) hashMap.get("enterroom_type");
            String str4 = (String) hashMap.get("live_activity_type");
            String str5 = (String) hashMap.get("extra");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("live_activity_type", str4);
                jSONObject.put("extra", str5);
                str2 = jSONObject.toString();
            } catch (JSONException unused) {
                str2 = "";
            }
            if ("1".equals(str3)) {
                d.b.j0.q1.a.h().z(context, str2);
                return;
            } else {
                d.b.j0.q1.a.h().y(context, "");
                return;
            }
        }
        d.b.j0.q1.a.h().y(context, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, String str, Map<String, Object> map) {
        String str2;
        String str3 = (String) map.get("enterroom_type");
        String str4 = (String) map.get("room_id");
        String str5 = (String) map.get("live_id");
        String str6 = (String) map.get("username");
        String str7 = (String) map.get("userrec");
        String str8 = (String) map.get(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
        String str9 = (String) map.get(AlaLiveRoomActivityConfig.SDK_LIVE_URL_KEY);
        String str10 = (String) map.get("screen_direction");
        String str11 = (String) map.get("open_giftlist");
        String str12 = (String) map.get("tab");
        String str13 = (String) map.get("tag");
        String str14 = (String) map.get("source");
        String str15 = (String) map.get("from");
        String str16 = (String) map.get("extra");
        String str17 = (String) map.get("audioUrl");
        String str18 = (String) map.get("audio_bg");
        String str19 = (String) map.get("chat_mcast_id");
        String str20 = (String) map.get("open_msgpanel");
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str12)) {
                jSONObject.put("tab", str12);
            }
            if (!TextUtils.isEmpty(str13)) {
                jSONObject.put("tag", str13);
            }
            if (!TextUtils.isEmpty(str14)) {
                jSONObject.put("source", str14);
            }
            if (!TextUtils.isEmpty(str15)) {
                jSONObject.put("from", str15);
            }
            if (!TextUtils.isEmpty(str8)) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, str8);
            }
            if (!TextUtils.isEmpty(str9)) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_URL_KEY, str9);
            }
            if (!TextUtils.isEmpty(str10)) {
                jSONObject.put("screen_direction", str10);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_ENTER_ROOM_ID_KEY, str4);
            }
            if (TextUtils.isEmpty(str5)) {
                str2 = str5;
            } else {
                str2 = str5;
                try {
                    jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_ENTER_LIVE_ID_KEY, str2);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (!"1".equals(str3)) {
                    }
                }
            }
            if (!TextUtils.isEmpty(str16)) {
                jSONObject.put("extra", str16);
            }
            if (!TextUtils.isEmpty(str17)) {
                jSONObject.put("audioUrl", str17);
            }
            if (!TextUtils.isEmpty(str18)) {
                jSONObject.put("audio_bg", str18);
            }
            if (!TextUtils.isEmpty(str19)) {
                jSONObject.put("chat_mcast_id", str19);
            }
            if (!TextUtils.isEmpty(str20)) {
                jSONObject.put("open_msgpanel", str20);
            }
        } catch (JSONException e3) {
            e = e3;
            str2 = str5;
        }
        if (!"1".equals(str3)) {
            d.b.j0.q1.a.h().t(context, str, jSONObject.toString(), map);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("user_name", str6);
            jSONObject2.put("open_giftlist", str11);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("live_id", str2);
            jSONObject3.put("useRecommend", true);
            jSONObject3.put("otherParams", jSONObject);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        d.b.j0.q1.a.h().s(context, jSONObject3.toString());
    }

    public static void d(Context context, d.b.j0.m1.m.a aVar, d.b.j0.m1.j.a aVar2) {
        if (context == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            try {
                if (!TextUtils.isEmpty(aVar.f58786a)) {
                    jSONObject.put("callback", aVar.f58786a);
                    if (aVar2 != null) {
                        f58766a.add(aVar2);
                    }
                }
                jSONObject.put("isTranslucent", aVar.f58787b);
                if (!TextUtils.isEmpty(aVar.f58788c)) {
                    jSONObject.put("from", aVar.f58788c);
                }
            } catch (JSONException unused) {
            }
        }
        d.b.j0.q1.a.h().w(context, jSONObject.toString());
    }

    public static void e(Context context) {
        d.b.j0.q1.a.h().m(context);
    }

    public static void f(Context context, long j, int i) {
        d.b.j0.q1.a.h().q(context, j, i);
    }

    public static void g(Context context, String str, int i) {
        d.b.j0.q1.a.h().n(context, str, i);
    }

    public static void h(Context context) {
        d.b.j0.q1.a.h().o(context);
    }

    public static void i(Context context, String str, String str2) {
        d.b.j0.q1.a.h().p(context, str, str2);
    }

    public static void j(Context context, String str, AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (alaLiveInfoCoreData != null) {
            long j = alaLiveInfoCoreData.liveID;
            String str2 = alaLiveInfoCoreData.userName;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", str);
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, alaLiveInfoCoreData.liveCover);
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_ENTER_LIVE_ID_KEY, j);
                jSONObject.put("user_name", str2);
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_URL_KEY, alaLiveInfoCoreData.rtmpUrl);
                jSONObject.put("screen_direction", alaLiveInfoCoreData.screenDirection);
                jSONObject.put("open_giftlist", "0");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("live_id", j);
                jSONObject2.put("useRecommend", true);
                jSONObject2.put("otherParams", jSONObject);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            d.b.j0.q1.a.h().s(context, jSONObject2.toString());
        }
    }

    public static void k(Context context) {
        d.b.j0.q1.a.h().u(context);
    }

    public static void l(Context context, String str) {
        d.b.j0.q1.a.h().v(context, str);
    }

    public static void m(Context context, String str, String str2) {
        d.b.j0.q1.a.h().x(context, str, str2);
    }

    public static void n(JSONObject jSONObject) {
        for (int i = 0; i < f58766a.size(); i++) {
            f58766a.get(i).onCallback(jSONObject);
        }
        f58766a.clear();
    }

    public static void o(String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("isSubscribe", Boolean.valueOf(z));
        d.b.j0.q1.a.h().f(TbadkCoreApplication.getInst(), "setAttentionChanged", hashMap);
    }

    public static void p(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", Long.valueOf(j));
        d.b.j0.q1.a.h().f(TbadkCoreApplication.getInst(), "shareSuccess", hashMap);
    }
}
