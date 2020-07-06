package com.kascend.chushou.toolkit.a;

import android.content.Context;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.games.utils.so.SoUtils;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import org.json.JSONObject;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class c {
    public static void a(Context context, String str, String str2, Object... objArr) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        HashMap hashMap = new HashMap();
        if (objArr != null && objArr.length > 0) {
            int length = objArr.length;
            if (length % 2 != 0 && tv.chushou.basis.d.b.OJ()) {
                throw new IllegalArgumentException("Supplied arguments must be even");
            }
            for (int i = 0; i < length; i += 2) {
                String valueOf = String.valueOf(objArr[i]);
                String valueOf2 = String.valueOf(objArr[i + 1]);
                if (!h.isEmpty(valueOf) && !h.isEmpty(valueOf2)) {
                    hashMap.put(String.valueOf(objArr[i]), objArr[i + 1]);
                }
            }
        }
        tv.chushou.basis.d.a.b.a aVar = (tv.chushou.basis.d.a.b.a) tv.chushou.basis.d.b.dWk().S(tv.chushou.basis.d.a.b.a.class);
        if (aVar != null) {
            aVar.a(context, str, str2, hashMap);
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("_listKey");
            String optString2 = jSONObject.optString("categoryname");
            String optString3 = jSONObject.optString("_fromPos");
            String optString4 = jSONObject.optString("_fromView");
            String a = a(optString3);
            String str = "";
            char c = 65535;
            switch (optString4.hashCode()) {
                case 49:
                    if (optString4.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 52:
                    if (optString4.equals("4")) {
                        c = 2;
                        break;
                    }
                    break;
                case 53:
                    if (optString4.equals("5")) {
                        c = 5;
                        break;
                    }
                    break;
                case 54:
                    if (optString4.equals("6")) {
                        c = 6;
                        break;
                    }
                    break;
                case 55:
                    if (optString4.equals("7")) {
                        c = 7;
                        break;
                    }
                    break;
                case 56:
                    if (optString4.equals("8")) {
                        c = 14;
                        break;
                    }
                    break;
                case 57:
                    if (optString4.equals("9")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1568:
                    if (optString4.equals("11")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1572:
                    if (optString4.equals(Constants.VIA_REPORT_TYPE_WPA_STATE)) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1576:
                    if (optString4.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                        c = 16;
                        break;
                    }
                    break;
                case 1598:
                    if (optString4.equals("20")) {
                        c = 15;
                        break;
                    }
                    break;
                case FeatureCodes.ADVANCE_BEAUTY /* 1600 */:
                    if (optString4.equals(Constants.VIA_REPORT_TYPE_DATALINE)) {
                        c = 18;
                        break;
                    }
                    break;
                case ARPMessageType.MSG_TYPE_SHARE /* 1601 */:
                    if (optString4.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR)) {
                        c = 17;
                        break;
                    }
                    break;
                case 1602:
                    if (optString4.equals(SoUtils.SO_EVENT_ID_DEFAULT)) {
                        c = '\r';
                        break;
                    }
                    break;
                case 1607:
                    if (optString4.equals("29")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1629:
                    if (optString4.equals("30")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1666:
                    if (optString4.equals("46")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1730:
                    if (optString4.equals("68")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1731:
                    if (optString4.equals("69")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    str = "首页";
                    break;
                case 2:
                case 3:
                    str = "关注";
                    if (optString3 != null && optString3.equals("54")) {
                        a = "猜你喜欢";
                        break;
                    } else {
                        a = "小item";
                        break;
                    }
                    break;
                case 4:
                    str = "好友列表";
                    break;
                case 5:
                    str = "历史";
                    break;
                case 6:
                    str = "搜索";
                    break;
                case 7:
                    str = "列表";
                    break;
                case '\b':
                    str = SuspensionBallEntity.KEY_SCHEME;
                    break;
                case '\t':
                    str = "专区";
                    break;
                case '\n':
                    str = "首页广场动态";
                    break;
                case 11:
                    str = "关注动态";
                    break;
                case '\f':
                    str = "直播间用户动态";
                    break;
                case '\r':
                    str = "IM分享";
                    break;
                case 14:
                    str = "其他直播";
                    break;
                case 15:
                    str = "播放结束后推荐";
                    break;
                case 16:
                    str = "视频播放页回到直播";
                    break;
                case 17:
                    str = "IM直播列表";
                    break;
                case 18:
                    str = "用户主页";
                    break;
            }
            a(context, "进房间", str, "分类key", optString, "分类名称", optString2, "位置", a);
        }
    }

    private static String a(String str) {
        if (h.isEmpty(str)) {
            return null;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c = 2;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c = 5;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c = 1;
                    break;
                }
                break;
            case 1691:
                if (str.equals("50")) {
                    c = 0;
                    break;
                }
                break;
            case 1692:
                if (str.equals("51")) {
                    c = 3;
                    break;
                }
                break;
            case 1693:
                if (str.equals("52")) {
                    c = 4;
                    break;
                }
                break;
            case 1694:
                if (str.equals("53")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "头部（更多）";
            case 1:
                return "小item";
            case 2:
                return "海报";
            case 3:
                return "大（单个）海报";
            case 4:
                return "小（单个）海报";
            case 5:
                return "大神主播推荐";
            case 6:
                return "首页图标";
            default:
                return null;
        }
    }

    public static void b(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("_listKey");
            String optString2 = jSONObject.optString("categoryname");
            String optString3 = jSONObject.optString("_fromView");
            String a = a(jSONObject.optString("_fromPos"));
            String str = "";
            char c = 65535;
            switch (optString3.hashCode()) {
                case 54:
                    if (optString3.equals("6")) {
                        c = 0;
                        break;
                    }
                    break;
                case 55:
                    if (optString3.equals("7")) {
                        c = 1;
                        break;
                    }
                    break;
                case 57:
                    if (optString3.equals("9")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1568:
                    if (optString3.equals("11")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1569:
                    if (optString3.equals("12")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1572:
                    if (optString3.equals(Constants.VIA_REPORT_TYPE_WPA_STATE)) {
                        c = 6;
                        break;
                    }
                    break;
                case FeatureCodes.ADVANCE_BEAUTY /* 1600 */:
                    if (optString3.equals(Constants.VIA_REPORT_TYPE_DATALINE)) {
                        c = 11;
                        break;
                    }
                    break;
                case 1602:
                    if (optString3.equals(SoUtils.SO_EVENT_ID_DEFAULT)) {
                        c = 7;
                        break;
                    }
                    break;
                case 1607:
                    if (optString3.equals("29")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1629:
                    if (optString3.equals("30")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1633:
                    if (optString3.equals("34")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1635:
                    if (optString3.equals("36")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1637:
                    if (optString3.equals("38")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1638:
                    if (optString3.equals("39")) {
                        c = '\r';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str = "搜索";
                    break;
                case 1:
                    str = "列表";
                    break;
                case 2:
                    str = SuspensionBallEntity.KEY_SCHEME;
                    break;
                case 3:
                    str = "专区";
                    break;
                case 4:
                    str = "首页广场动态";
                    break;
                case 5:
                    str = "关注动态";
                    break;
                case 6:
                    str = "直播间用户动态";
                    break;
                case 7:
                    str = "IM分享";
                    break;
                case '\b':
                    str = "录制端数据";
                    break;
                case '\t':
                    str = "动态分类";
                    break;
                case '\n':
                    str = "话题";
                    break;
                case 11:
                    str = "用户主页";
                    break;
                case '\f':
                    str = "更多热门动态(动态分类)";
                    break;
                case '\r':
                    str = "更多热门动态(话题)";
                    break;
            }
            a(context, "进视频", str, "分类key", optString, "分类名称", optString2, "位置", a);
        }
    }

    public static void a(Context context, String str, boolean z) {
        a(context, "点击热词", z ? "竖屏" : "横屏", "热词", str);
    }

    public static void a(Context context, boolean z, boolean z2) {
        String str = z ? "视频" : "直播";
        Object[] objArr = new Object[2];
        objArr[0] = "当前屏幕方向";
        objArr[1] = z2 ? "竖屏" : "横屏";
        a(context, "点击解码设置", str, objArr);
    }

    public static void c(Context context, boolean z, boolean z2) {
        a(context, "点击弹幕开关", z ? "竖屏" : "横屏", "是否关弹幕", Boolean.valueOf(z2));
    }

    public static void d(Context context, boolean z, boolean z2) {
        String str = z ? "视频" : "直播";
        Object[] objArr = new Object[2];
        objArr[0] = "当前屏幕方向";
        objArr[1] = z2 ? "竖屏" : "横屏";
        a(context, "点击重新加载", str, objArr);
    }

    public static void e(Context context, boolean z, boolean z2) {
        String str = z ? "视频" : "直播";
        Object[] objArr = new Object[2];
        objArr[0] = "当前屏幕方向";
        objArr[1] = z2 ? "竖屏" : "横屏";
        a(context, "点击清晰度", str, objArr);
    }
}
