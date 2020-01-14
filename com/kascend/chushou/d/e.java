package com.kascend.chushou.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Toast;
import com.baidu.live.tbadk.pay.PayHelper;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.k;
import com.kascend.chushou.b.a.a.o;
import com.kascend.chushou.constants.GeneralGift;
import com.kascend.chushou.constants.GeneralTabGift;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.VideoPlayer;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.widget.EmptyLoadingView;
import com.qiniu.android.storage.UploadManager;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.http.Http;
import tv.chushou.basis.http.HttpExecutor;
import tv.chushou.basis.http.impl.HttpImpl;
import tv.chushou.basis.http.model.RequestTag;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.widget.sweetalert.b;
/* loaded from: classes4.dex */
public class e {
    private static volatile boolean a = false;
    private static final Object b = new Object();
    private static volatile boolean c = false;
    private static final Object d = new Object();

    public static boolean a(String str) {
        return !tv.chushou.zues.utils.h.isEmpty(str) && str.toLowerCase().endsWith(".gif");
    }

    public static void a() {
        tv.chushou.basis.c.c.Sy("chushou_player_prefs").putBoolean("key_only_play_when_wifi", h.dAM().u());
    }

    public static boolean b() {
        return h.dAM().u() && !com.kascend.chushou.b.dAF().a && com.kascend.chushou.b.dAF().b;
    }

    public static int c() {
        return tv.chushou.basis.c.c.Sy("chushou_player_prefs").getInt("key_user_4g_choice", -1);
    }

    public static void a(int i) {
        tv.chushou.basis.c.c.Sy("chushou_player_prefs").putInt("key_user_4g_choice", i);
    }

    public static Uri aA(String str, String str2, String str3) {
        if (tv.chushou.zues.utils.h.isEmpty(str) || tv.chushou.zues.utils.h.isEmpty(str2)) {
            return null;
        }
        return Uri.parse("chushou://chushou.tv/play?roomId=" + str + "&protocols=" + str2 + "&liveType=" + str3);
    }

    public static void a(Context context, boolean z) {
        tv.chushou.widget.a.a.q(context, z);
    }

    @Nullable
    public static io.reactivex.disposables.b a(io.reactivex.disposables.a aVar, final ArrayList<GeneralTabGift> arrayList) {
        if (tv.chushou.zues.utils.h.isEmpty(arrayList)) {
            return null;
        }
        return RxExecutor.post(aVar, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    GeneralTabGift generalTabGift = (GeneralTabGift) it.next();
                    if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                        for (GeneralGift generalGift : generalTabGift.mGeneralGifts) {
                            if (generalGift != null && !tv.chushou.zues.utils.h.isEmpty(generalGift.mIcon)) {
                                tv.chushou.zues.utils.h.SO(generalGift.mIcon);
                            }
                        }
                    }
                }
            }
        });
    }

    public static String b(String str) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return "";
        }
        return Pattern.compile("\t|\r|\n").matcher(str).replaceAll("");
    }

    public static void a(Context context, ListItem listItem, JSONObject jSONObject) {
        if (listItem != null && !tv.chushou.zues.utils.h.isEmpty(listItem.mType)) {
            tv.chushou.zues.utils.e.d("KasUtil", "doclick type=" + listItem.mType);
            String str = listItem.mType;
            char c2 = 65535;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 53:
                    if (str.equals("5")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 54:
                    if (str.equals("6")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case 1567:
                    if (str.equals("10")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case 1568:
                    if (str.equals("11")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 1570:
                    if (str.equals(Constants.VIA_REPORT_TYPE_JOININ_GROUP)) {
                        c2 = 15;
                        break;
                    }
                    break;
                case 1572:
                    if (str.equals(Constants.VIA_REPORT_TYPE_WPA_STATE)) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 1574:
                    if (str.equals("17")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1575:
                    if (str.equals("18")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1576:
                    if (str.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 1598:
                    if (str.equals("20")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 1820:
                    if (str.equals("95")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 1821:
                    if (str.equals("96")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1823:
                    if (str.equals("98")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1824:
                    if (str.equals("99")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1507424:
                    if (str.equals(PayHelper.STATUS_SUCC)) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (listItem.fromBaidu ? true : com.kascend.cstvsdk.utils.a.njI.a(listItem.mTargetKey)) {
                        JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
                        try {
                            if ("mic_room".equals(jSONObject2.optString("imfrom"))) {
                                jSONObject2.put("tag_from_game_mic", true);
                            }
                            if (listItem.mDisplayStyle != null && !listItem.mDisplayStyle.equals("3") && !listItem.mDisplayStyle.equals("4") && !listItem.mDisplayStyle.equals("6") && !listItem.mDisplayStyle.equals("10") && !listItem.mDisplayStyle.equals("32") && !listItem.mDisplayStyle.equals("14") && !listItem.mDisplayStyle.equals(Constants.VIA_REPORT_TYPE_JOININ_GROUP) && tv.chushou.zues.utils.h.isEmpty(jSONObject2.optString("_thumb"))) {
                                if (!tv.chushou.zues.utils.h.isEmpty(listItem.mOriginalCover)) {
                                    jSONObject2.put("_thumb", listItem.mOriginalCover);
                                } else {
                                    jSONObject2.put("_thumb", listItem.mCover);
                                }
                            }
                            if (!tv.chushou.zues.utils.h.isEmpty(listItem.mSC) && !jSONObject2.has("_sc")) {
                                jSONObject2.put("_sc", listItem.mSC);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        a(context, listItem.mTargetKey, listItem.mName, jSONObject2, false, listItem.mLiveType);
                        return;
                    }
                    return;
                case 1:
                    a.a(context, listItem.mUrl, listItem.mName);
                    return;
                case 2:
                    tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
                    return;
                case 3:
                    a(context, listItem.mUrl);
                    return;
                case 4:
                    com.kascend.chushou.a.a.a(context, listItem, jSONObject, true);
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(Context context, String str) {
        FragmentActivity fragmentActivity;
        FragmentActivity fragmentActivity2 = null;
        if (context instanceof FragmentActivity) {
            fragmentActivity2 = (FragmentActivity) context;
        }
        if (fragmentActivity2 == null) {
            Activity e = b.e();
            if (e instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) e;
                if (fragmentActivity == null && !fragmentActivity.isFinishing()) {
                    com.kascend.chushou.player.ui.h5.a.nbt.QJ(str).show(fragmentActivity.getSupportFragmentManager(), "fixedDialog");
                    return;
                }
            }
        }
        fragmentActivity = fragmentActivity2;
        if (fragmentActivity == null) {
        }
    }

    public static String a(String str, Map<String, Object> map, RequestTag requestTag) {
        Http http;
        if (!tv.chushou.zues.utils.h.isEmpty(str) && (http = (Http) tv.chushou.basis.d.b.dOG().T(Http.class)) != null) {
            if (str.contains("chushou.tv") || str.contains("192.168.") || str.contains("183.129.155.244") || str.contains("vchushou.com") || str.contains("playground") || str.contains("kascend-inc.com")) {
                if (requestTag == null) {
                    requestTag = RequestTag.normal();
                }
                return http.packSystemParams(str, map, requestTag);
            }
            return str;
        }
        return str;
    }

    public static String c(String str) {
        return a(str, (Map<String, Object>) null, RequestTag.normal());
    }

    public static String o(String str, Map<String, Object> map) {
        Http http = (Http) tv.chushou.basis.d.b.dOG().T(Http.class);
        return http == null ? str : http.packParams(str, map);
    }

    private static void a(final Context context, final String str, String str2, final JSONObject jSONObject, boolean z, final boolean z2, final String str3) {
        String str4;
        final String str5;
        if (jSONObject != null) {
            str4 = jSONObject.optString("_fromView");
            if (tv.chushou.zues.utils.h.isEmpty(str4)) {
                str5 = null;
            } else {
                String optString = jSONObject.optString("_viewType");
                if (optString != null && optString.equals("3")) {
                    com.kascend.chushou.toolkit.a.c.b(context, jSONObject);
                    str5 = optString;
                } else {
                    com.kascend.chushou.toolkit.a.c.a(context, jSONObject);
                    str5 = optString;
                }
            }
        } else {
            str4 = null;
            str5 = null;
        }
        if (jSONObject != null && (context instanceof VideoPlayer) && "3".equals(str5) && "3".equals(jSONObject.optString("tag_from_view"))) {
            new tv.chushou.zues.c(context.getMainLooper()).m(new Runnable() { // from class: com.kascend.chushou.d.e.2
                @Override // java.lang.Runnable
                public void run() {
                    ListItem listItem = new ListItem();
                    listItem.mTargetKey = str;
                    String str6 = str5;
                    if (tv.chushou.zues.utils.h.isEmpty(str6)) {
                        str6 = "1";
                    }
                    listItem.mType = str6;
                    o oVar = new o();
                    oVar.mOj = listItem;
                    oVar.f = "3";
                    oVar.c = context;
                    oVar.d = z2;
                    oVar.e = jSONObject.toString();
                    tv.chushou.zues.a.a.post(oVar);
                }
            });
        } else if (jSONObject != null && (context instanceof VideoPlayer) && !"3".equals(str5) && "1".equals(jSONObject.optString("tag_from_view"))) {
            ListItem listItem = new ListItem();
            listItem.mTargetKey = str;
            if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                str5 = "1";
            }
            listItem.mType = str5;
            listItem.mCover = jSONObject.optString("_thumb");
            o oVar = new o();
            oVar.f = "1";
            oVar.mOj = listItem;
            oVar.c = context;
            oVar.d = z2;
            oVar.g = str3;
            tv.chushou.zues.a.a.post(oVar);
        } else if ((context instanceof VideoPlayer) && str4 != null && (str4.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR) || str4.equals("8") || str4.equals(Constants.VIA_REPORT_TYPE_WPA_STATE))) {
            new tv.chushou.zues.c(context.getMainLooper()).m(new Runnable() { // from class: com.kascend.chushou.d.e.3
                @Override // java.lang.Runnable
                public void run() {
                    ListItem listItem2 = new ListItem();
                    listItem2.mTargetKey = str;
                    String str6 = str5;
                    if (tv.chushou.zues.utils.h.isEmpty(str6)) {
                        str6 = "1";
                    }
                    listItem2.mType = str6;
                    o oVar2 = new o();
                    oVar2.mOj = listItem2;
                    oVar2.c = context;
                    oVar2.d = z2;
                    oVar2.g = str3;
                    tv.chushou.zues.a.a.post(oVar2);
                }
            });
        } else {
            tv.chushou.zues.a.a.post(new k(1));
            Intent intent = new Intent(context, VideoPlayer.class);
            intent.setData(aA(str, "2,1,101,102", str3));
            intent.setAction("android.intent.action.VIEW");
            intent.putExtra("tittle", str2);
            if (jSONObject != null) {
                intent.putExtra("json_str", jSONObject.toString());
            }
            intent.putExtra("showkeyboard", z);
            intent.putExtra("room_play_audio", z2);
            if (jSONObject != null) {
                intent.putExtra("action_video_pos", jSONObject.optLong("action_video_pos"));
            }
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    private static boolean a(Context context, String str, String str2, JSONObject jSONObject, boolean z, String str3) {
        if (!tv.chushou.zues.utils.h.isEmpty(str)) {
            if (!tv.chushou.zues.utils.a.dPa()) {
                Toast.makeText(context, a.i.s_no_available_network, 0).show();
            } else {
                a(context, str, str2, jSONObject, z, false, str3);
            }
        } else {
            tv.chushou.zues.utils.e.e("KasUtil", "failed to get video node");
        }
        return true;
    }

    public static String a(Object... objArr) {
        JSONObject M = M(objArr);
        if (M != null) {
            return M.toString();
        }
        return null;
    }

    public static JSONObject a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                } catch (Exception e) {
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject M(Object... objArr) {
        int length = objArr.length;
        if (length % 2 != 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < length; i += 2) {
            String valueOf = String.valueOf(objArr[i]);
            String valueOf2 = String.valueOf(objArr[i + 1]);
            if (!tv.chushou.zues.utils.h.isEmpty(valueOf) && !tv.chushou.zues.utils.h.isEmpty(valueOf2)) {
                try {
                    jSONObject.put(valueOf, valueOf2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public static String a(String str, Object... objArr) {
        JSONObject jSONObject;
        int length = objArr.length;
        if (length % 2 == 0) {
            try {
                if (tv.chushou.zues.utils.h.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                for (int i = 0; i < length; i += 2) {
                    try {
                        jSONObject.put(String.valueOf(objArr[i]), String.valueOf(objArr[i + 1]));
                    } catch (JSONException e) {
                    }
                }
            } catch (JSONException e2) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                return jSONObject.toString();
            }
            return null;
        }
        return str;
    }

    public static void b(Context context, String str) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            str = context.getString(a.i.str_login_timeout);
        }
        tv.chushou.zues.utils.g.c(context, str);
        a.b(context, null);
    }

    public static boolean c(Context context, String str) {
        if (!tv.chushou.zues.utils.a.dPa()) {
            tv.chushou.zues.utils.g.Oj(a.i.s_no_available_network);
            return false;
        } else if (!LoginManager.Instance().islogined()) {
            a.b(context, str);
            return false;
        } else {
            return true;
        }
    }

    public static void d() {
        LoginManager.Instance().userLogout();
    }

    public static void a(FragmentActivity fragmentActivity, String str) {
        com.kascend.chushou.view.b.b.QO(str).show(fragmentActivity.getSupportFragmentManager(), "RechargeDialog");
    }

    public static void a(Context context, String str, b.a aVar) {
        new tv.chushou.zues.widget.sweetalert.b(context).a(new b.a() { // from class: com.kascend.chushou.d.e.4
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.dismiss();
            }
        }).b(aVar).SS(context.getString(a.i.alert_dialog_cancel)).SU(context.getString(a.i.alert_dialog_ok)).x(context.getString(a.i.manage_follow_confirm, str)).show();
    }

    public static void d(FragmentManager fragmentManager) {
        if (LoginManager.Instance().islogined()) {
            com.kascend.chushou.view.b.d.wn(true).show(fragmentManager, "userinfocopy");
        }
    }

    public static void a(FragmentManager fragmentManager, String str, String str2, String str3) {
        com.kascend.chushou.view.b.d.c(false, str, str2, str3).show(fragmentManager, "userinfocopy");
    }

    public static void e() {
        synchronized (b) {
            if (!a) {
                RxExecutor.initRxJavaPlugins();
                f();
                a = true;
            }
        }
    }

    public static void f() {
        c.mOu.c();
        c.mOu.dAJ();
        c.mOu.e();
    }

    public static void g() {
        synchronized (d) {
            if (c) {
                tv.chushou.basis.d.b.dOF().d(null, "initMainThread, already finished");
                return;
            }
            tv.chushou.basis.d.b.dOF().d(null, "initMainThread");
            tv.chushou.basis.d.b.dOG().e(tv.chushou.basis.d.a.b.b.class, com.kascend.chushou.toolkit.c.a.class);
            tv.chushou.basis.d.b.dOG().e(tv.chushou.basis.d.a.b.d.class, tv.chushou.basis.b.a.a.a.class);
            tv.chushou.basis.d.b.dOG().e(tv.chushou.basis.d.a.b.e.class, com.kascend.chushou.toolkit.c.e.class);
            tv.chushou.basis.d.b.dOG().e(tv.chushou.basis.d.a.b.c.class, com.kascend.chushou.toolkit.c.b.class);
            tv.chushou.basis.d.b.dOG().e(Http.class, HttpImpl.class);
            tv.chushou.basis.d.b.dOG().e(tv.chushou.basis.d.a.a.c.class, com.kascend.chushou.toolkit.c.a.c.class);
            tv.chushou.basis.d.b.dOG().e(tv.chushou.basis.d.a.a.b.class, com.kascend.chushou.toolkit.c.d.class);
            tv.chushou.basis.d.b.dOG().e(tv.chushou.basis.d.a.a.a.class, com.kascend.chushou.toolkit.c.c.class);
            h();
            i();
            c = true;
        }
    }

    public static void h() {
        j();
        a();
    }

    public static void b(OkHttpClient okHttpClient, String str) {
        HttpExecutor.initialize(okHttpClient);
        UploadManager.a(HttpExecutor.getOkHttpClient());
        tv.chushou.common.a.Sz(str);
    }

    public static void i() {
        EmptyLoadingView.ai(new View.OnClickListener() { // from class: com.kascend.chushou.d.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.c(view.getContext(), null);
            }
        });
    }

    public static void j() {
        com.kascend.chushou.b.dAF().a = tv.chushou.zues.utils.a.hg(tv.chushou.basis.d.b.dOE());
        com.kascend.chushou.b.dAF().b = tv.chushou.zues.utils.a.hh(tv.chushou.basis.d.b.dOE());
    }
}
