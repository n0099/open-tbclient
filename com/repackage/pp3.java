package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class pp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Map<String, String> a(String str, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, str2, str3, str4, Boolean.valueOf(z)})) == null) {
            if (z || yo3.b() == null) {
                return null;
            }
            TreeMap treeMap = new TreeMap();
            treeMap.put("ver", zp3.l());
            treeMap.put("host", yo3.b().a());
            treeMap.put("os", "android");
            int c = NetworkUtils.c(false);
            treeMap.put("net", c + "");
            treeMap.put("phone", zp3.e());
            treeMap.put("osV", zp3.f());
            treeMap.put("slot", str);
            treeMap.put("flow", str2);
            treeMap.put("appid", str3);
            treeMap.put("apid", str4);
            treeMap.put("sdk", yo3.b().getSdkVersion());
            treeMap.put("time", "" + System.currentTimeMillis());
            return treeMap;
        }
        return (Map) invokeCommon.objValue;
    }

    public static String b(String str, @Nullable Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) {
            if (map != null) {
                map.put("name", str);
                return xp3.b("https://mobads-logs.baidu.com/dz.zb?type=mnp&", map);
            }
            return "https://mobads-logs.baidu.com/dz.zb?type=mnp&";
        }
        return (String) invokeLL.objValue;
    }

    public static String c(@NonNull Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) ? map.get("flow") : (String) invokeL.objValue;
    }

    public static void d(String str, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, xo3Var) == null) {
            xo3Var.e(str);
        }
    }

    public static String e(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2)) == null) {
            String replaceAll = str.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()).replaceAll("%25%25play_mode%25%25", "0");
            String replaceAll2 = replaceAll.replaceAll("%25%25cur_time%25%25", "" + i);
            return replaceAll2.replaceAll("%25%25start_time%25%25", "" + i2).replaceAll("%25%25area%25%25", "hot");
        }
        return (String) invokeLII.objValue;
    }

    public static void f(String str, String str2, String str3, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65541, null, str, str2, str3, xo3Var) == null) || yo3.b() == null || zp3.o()) {
            return;
        }
        String a = yo3.b().a();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bizId", 10003);
            jSONObject.put(TbEnum.SystemMessage.KEY_GROUP_ID, 10003);
            jSONObject.put("containerAppName", a);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("distribute_channel", 38);
            jSONObject2.put("CTK", str3);
            jSONObject2.put("logtype", 2);
            jSONObject2.put("media_id", str);
            jSONObject2.put("PVID", str3);
            jSONObject2.put("tuid", str2);
            jSONObject2.put("time", zp3.j());
            jSONObject2.put("page_type", 1);
            jSONObject2.put("traffic_type", 1);
            jSONObject.put("content", jSONObject2);
            xo3Var.d(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void g(AdElementInfo adElementInfo, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, adElementInfo, xo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            d(e(str, 0, 0), xo3Var);
        }
    }

    public static void h(AdElementInfo adElementInfo, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, adElementInfo, xo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            HashSet hashSet = new HashSet();
            hashSet.add(BdVideoAd.AD_VIDEO_DAPAGE);
            hashSet.add("da_type");
            String a = xp3.a(xp3.a(xp3.c(str, hashSet), BdVideoAd.AD_VIDEO_DAPAGE, "NAVIDEO_TAIL_PLAYABLE"), "da_type", "102");
            d(a.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), xo3Var);
        }
        d(adElementInfo.getClickUrl(), xo3Var);
    }

    public static void i(AdElementInfo adElementInfo, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, adElementInfo, xo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            HashSet hashSet = new HashSet();
            hashSet.add(BdVideoAd.AD_VIDEO_DAPAGE);
            hashSet.add("da_type");
            String c = xp3.c(str, hashSet);
            if (!TextUtils.isEmpty(adElementInfo.getEndFrameUrl())) {
                c = xp3.a(c, BdVideoAd.AD_VIDEO_DAPAGE, "NAVIDEO_TAIL_PLAYABLE");
            } else if (!TextUtils.isEmpty(adElementInfo.getEndFrameHtml())) {
                c = xp3.a(c, BdVideoAd.AD_VIDEO_DAPAGE, "NAVIDEO_TAIL");
            }
            String a = xp3.a(c, "da_type", TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            d(a.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), xo3Var);
        }
    }

    public static void j(AdElementInfo adElementInfo, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, adElementInfo, xo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            d(e(str, 0, 0), xo3Var);
        }
        for (String str2 : adElementInfo.getThirdImpressionTrackingUrls()) {
            d(e(str2, 0, 0), xo3Var);
        }
    }

    public static void k(@Nullable Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, map, str) == null) {
            l(map, str, new gp3(AppRuntime.getAppContext()));
        }
    }

    public static void l(@Nullable Map<String, String> map, String str, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, map, str, xo3Var) == null) || map == null) {
            return;
        }
        TreeMap treeMap = new TreeMap(map);
        if (!TextUtils.isEmpty(str)) {
            treeMap.put(StatConstants.KEY_EXT_ERR_CODE, str);
            treeMap.put(StatConstants.KEY_EXT_ERR_MSG, tp3.a(str));
        }
        n("error", treeMap, xo3Var);
    }

    public static void m(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, map) == null) {
            n(str, map, new gp3(AppRuntime.getAppContext()));
        }
    }

    public static void n(String str, Map<String, String> map, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65549, null, str, map, xo3Var) == null) || map == null) {
            return;
        }
        d(b(str, map), xo3Var);
    }

    public static void o(int i, int i2, AdElementInfo adElementInfo, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), adElementInfo, xo3Var}) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            d(e(str, i, i2), xo3Var);
        }
    }

    public static void p(AdElementInfo adElementInfo, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, adElementInfo, xo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getSkipTrackers()) {
            d(e(str, 0, 0), xo3Var);
        }
    }

    public static void q(AdElementInfo adElementInfo, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, adElementInfo, xo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getStartTrackers()) {
            d(e(str, 0, 0), xo3Var);
        }
    }
}
