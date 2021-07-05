package d.a.q0.f.i.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.router.RouterCallback;
import d.a.q0.f.i.l.g;
import d.a.q0.f.i.r.f;
import d.a.q0.f.i.r.h;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Map<String, String> a(String str, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, str2, str3, str4, Boolean.valueOf(z)})) == null) {
            if (z || d.a.q0.f.i.m.a.b() == null) {
                return null;
            }
            TreeMap treeMap = new TreeMap();
            treeMap.put("ver", h.l());
            treeMap.put("host", d.a.q0.f.i.m.a.b().a());
            treeMap.put(IAdRequestParam.OS, "android");
            int c2 = NetworkUtils.c(false);
            treeMap.put("net", c2 + "");
            treeMap.put("phone", h.e());
            treeMap.put("osV", h.f());
            treeMap.put("slot", str);
            treeMap.put("flow", str2);
            treeMap.put("appid", str3);
            treeMap.put("apid", str4);
            treeMap.put("sdk", d.a.q0.f.i.m.a.b().getSdkVersion());
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
                return f.b("https://mobads-logs.baidu.com/dz.zb?type=mnp&", map);
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

    public static void d(String str, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, gVar) == null) {
            gVar.d(str);
        }
    }

    public static String e(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65540, null, str, i2, i3)) == null) {
            String replaceAll = str.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()).replaceAll("%25%25play_mode%25%25", "0");
            String replaceAll2 = replaceAll.replaceAll("%25%25cur_time%25%25", "" + i2);
            return replaceAll2.replaceAll("%25%25start_time%25%25", "" + i3).replaceAll("%25%25area%25%25", "hot");
        }
        return (String) invokeLII.objValue;
    }

    public static void f(String str, String str2, String str3, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, str3, gVar) == null) || d.a.q0.f.i.m.a.b() == null || h.o()) {
            return;
        }
        String a2 = d.a.q0.f.i.m.a.b().a();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bizId", 10003);
            jSONObject.put(TbEnum.SystemMessage.KEY_GROUP_ID, 10003);
            jSONObject.put("containerAppName", a2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("distribute_channel", 38);
            jSONObject2.put("CTK", str3);
            jSONObject2.put("logtype", 2);
            jSONObject2.put("media_id", str);
            jSONObject2.put("PVID", str3);
            jSONObject2.put("tuid", str2);
            jSONObject2.put("time", h.j());
            jSONObject2.put("page_type", 1);
            jSONObject2.put("traffic_type", 1);
            jSONObject.put("content", jSONObject2);
            gVar.c(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void g(AdElementInfo adElementInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, adElementInfo, gVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            d(e(str, 0, 0), gVar);
        }
    }

    public static void h(AdElementInfo adElementInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, adElementInfo, gVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            HashSet hashSet = new HashSet();
            hashSet.add("da_page");
            hashSet.add("da_type");
            String a2 = f.a(f.a(f.c(str, hashSet), "da_page", "NAVIDEO_TAIL_PLAYABLE"), "da_type", "102");
            d(a2.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), gVar);
        }
        d(adElementInfo.getClickUrl(), gVar);
    }

    public static void i(AdElementInfo adElementInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, adElementInfo, gVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            HashSet hashSet = new HashSet();
            hashSet.add("da_page");
            hashSet.add("da_type");
            String c2 = f.c(str, hashSet);
            if (!TextUtils.isEmpty(adElementInfo.getEndFrameUrl())) {
                c2 = f.a(c2, "da_page", "NAVIDEO_TAIL_PLAYABLE");
            } else if (!TextUtils.isEmpty(adElementInfo.getEndFrameHtml())) {
                c2 = f.a(c2, "da_page", "NAVIDEO_TAIL");
            }
            String a2 = f.a(c2, "da_type", "103");
            d(a2.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), gVar);
        }
    }

    public static void j(AdElementInfo adElementInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, adElementInfo, gVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            d(e(str, 0, 0), gVar);
        }
        for (String str2 : adElementInfo.getThirdImpressionTrackingUrls()) {
            d(e(str2, 0, 0), gVar);
        }
    }

    public static void k(@Nullable Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, map, str) == null) {
            l(map, str, new d.a.q0.f.i.o.b(AppRuntime.getAppContext()));
        }
    }

    public static void l(@Nullable Map<String, String> map, String str, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, map, str, gVar) == null) || map == null) {
            return;
        }
        TreeMap treeMap = new TreeMap(map);
        if (!TextUtils.isEmpty(str)) {
            treeMap.put(RouterCallback.KEY_ERROR_CODE, str);
            treeMap.put("errMsg", d.a.q0.f.i.r.b.a(str));
        }
        n("error", treeMap, gVar);
    }

    public static void m(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, map) == null) {
            n(str, map, new d.a.q0.f.i.o.b(AppRuntime.getAppContext()));
        }
    }

    public static void n(String str, Map<String, String> map, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65549, null, str, map, gVar) == null) || map == null) {
            return;
        }
        d(b(str, map), gVar);
    }

    public static void o(int i2, int i3, AdElementInfo adElementInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), adElementInfo, gVar}) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            d(e(str, i2, i3), gVar);
        }
    }

    public static void p(AdElementInfo adElementInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, adElementInfo, gVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getSkipTrackers()) {
            d(e(str, 0, 0), gVar);
        }
    }

    public static void q(AdElementInfo adElementInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, adElementInfo, gVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getStartTrackers()) {
            d(e(str, 0, 0), gVar);
        }
    }
}
