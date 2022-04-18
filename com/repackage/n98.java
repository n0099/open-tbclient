package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.GoodsInfo;
/* loaded from: classes6.dex */
public class n98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<dp4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(dp4 dp4Var, dp4 dp4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dp4Var, dp4Var2)) == null) {
                if (dp4Var.d() && dp4Var2.d()) {
                    return dp4Var.h() - dp4Var2.h();
                }
                if (dp4Var.d() || dp4Var2.d()) {
                    return dp4Var.d() ? -1 : 1;
                }
                return (dp4Var.o() == null ? -1 : n98.g(dp4Var.o())) - (dp4Var2.o() != null ? n98.g(dp4Var2.o()) : -1);
            }
            return invokeLL.intValue;
        }
    }

    public static Set<uo> a(List<uo> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo o;
        AdvertAppInfo o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (jd7.e(list)) {
                return hashSet;
            }
            Set<uo> a2 = xc8.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (uo uoVar : list) {
                if (uoVar != null) {
                    for (uo uoVar2 : a2) {
                        if ((uoVar instanceof dp4) && (o2 = ((dp4) uoVar).o()) != null && uoVar2.hashCode() == o2.hashCode()) {
                            o2.j = ((AdvertAppInfo) uoVar2).j;
                        }
                    }
                    if ((uoVar instanceof dp4) && (o = ((dp4) uoVar).o()) != null && o.j == null) {
                        un4 un4Var = new un4();
                        o.j = un4Var;
                        un4Var.a = str;
                        un4Var.b = i;
                        un4Var.h = o.h;
                        un4Var.i = false;
                        hashSet.add(o);
                    }
                }
            }
            a2.addAll(hashSet);
            xc8.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static int b(@NonNull List<uo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (jd7.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int k = jd7.k(list) - 1; k >= 0 && !(jd7.d(list, k) instanceof dp4); k--) {
                if (jd7.d(list, k) instanceof qq4) {
                    int i3 = ((qq4) jd7.d(list, k)).position;
                    if (i3 != i2) {
                        i++;
                        i2 = i3;
                    }
                } else {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static void c(List<uo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || jd7.e(list)) {
            return;
        }
        Iterator<uo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof dp4) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) || TextUtils.isEmpty(str) || jd7.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof dp4;
            if (z || (next instanceof App)) {
                if (next instanceof App) {
                    str2 = p98.a((App) next);
                } else {
                    if (z) {
                        dp4 dp4Var = (dp4) next;
                        if (dp4Var.o() != null) {
                            str2 = dp4Var.o().a;
                        }
                    }
                    str2 = "";
                }
                if (TextUtils.equals(str, str2)) {
                    it.remove();
                }
            }
        }
    }

    public static String e(List<uo> list, boolean z) {
        InterceptResult invokeLZ;
        dp4 dp4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !jd7.e(list)) {
                int i = 0;
                for (int k = jd7.k(list) - 1; k >= 0 && i < 6; k--) {
                    if ((jd7.d(list, k) instanceof dp4) && (dp4Var = (dp4) jd7.d(list, k)) != null && !n(dp4Var.o())) {
                        sb.append(dp4Var.h() + 1);
                        sb.append(",");
                        i++;
                    }
                }
                if (sb.length() <= 1) {
                    return sb.toString();
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static String f(@NonNull AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, advertAppInfo)) == null) {
            return "#Nad=" + advertAppInfo.h;
        }
        return (String) invokeL.objValue;
    }

    public static int g(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, advertAppInfo)) == null) {
            if (advertAppInfo == null) {
                return 0;
            }
            if (TextUtils.isEmpty(advertAppInfo.g)) {
                return -1;
            }
            return mg.e(advertAppInfo.g, -1);
        }
        return invokeL.intValue;
    }

    public static List<dp4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jd7.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.s(app);
                advertAppInfo.k = str;
                int m = m(advertAppInfo);
                if (m != 0) {
                    r(advertAppInfo, m);
                } else {
                    arrayList.add(advertAppInfo);
                }
            }
            Log.e("frs", "src ad jiaoyan size " + arrayList.size());
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static int i(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, app)) == null) {
            List<GoodsInfo> list = app.goods_info;
            if (list == null) {
                return -1001;
            }
            for (GoodsInfo goodsInfo : list) {
                if (goodsInfo != null) {
                    return goodsInfo.goods_style.intValue();
                }
            }
            return -1001;
        }
        return invokeL.intValue;
    }

    public static boolean j(App app, BannerList bannerList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, app, bannerList)) == null) {
            if (app != null && bannerList != null) {
                if (p(app, bannerList.pb_banner_ad)) {
                    return true;
                }
                List<App> list = bannerList.video_recommend_ad;
                if (!jd7.e(list)) {
                    for (App app2 : list) {
                        if (p(app, app2)) {
                            return true;
                        }
                    }
                }
                List<App> list2 = bannerList.app;
                if (!jd7.e(list2)) {
                    for (App app3 : list2) {
                        if (p(app, app3)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<dp4> k(List<dp4> list, List<uo> list2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jd7.e(list)) {
                return arrayList;
            }
            t(list);
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                dp4 dp4Var = (dp4) jd7.d(list, i3);
                if (dp4Var != null && dp4Var.o() != null) {
                    int k = jd7.k(list2);
                    int g = g(dp4Var.o()) - 1;
                    if (g < 0) {
                        s(dp4Var.o());
                    } else {
                        int h = dp4Var.d() ? dp4Var.h() : g + i;
                        if (h > k) {
                            s(dp4Var.o());
                        } else {
                            dp4Var.setPosition(h);
                            jd7.b(list2, dp4Var, h);
                            arrayList.add(dp4Var);
                        }
                    }
                }
            }
            while (i < jd7.k(list2)) {
                uo uoVar = list2.get(i);
                if (uoVar instanceof dp4) {
                    i2++;
                } else if (uoVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) uoVar).position += i2;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static boolean l(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("#Nad=");
        }
        return invokeL.booleanValue;
    }

    public static int m(@Nullable AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, advertAppInfo)) == null) {
            int q = advertAppInfo.q();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return q;
        }
        return invokeL.intValue;
    }

    public static boolean n(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, advertAppInfo)) == null) ? advertAppInfo.b() : invokeL.booleanValue;
    }

    public static boolean o(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, app)) == null) {
            List<GoodsInfo> list = app.goods_info;
            if (list == null) {
                return false;
            }
            for (GoodsInfo goodsInfo : list) {
                if (goodsInfo != null && goodsInfo.goods_style.intValue() == 1001) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean p(App app, App app2) {
        InterceptResult invokeLL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, app, app2)) == null) {
            if (app != null && app2 != null && !jd7.e(app.goods_info) && !jd7.e(app2.goods_info)) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    str = null;
                    if (!it.hasNext()) {
                        str2 = null;
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        str2 = next.lego_card;
                        break;
                    }
                }
                Iterator<GoodsInfo> it2 = app2.goods_info.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    GoodsInfo next2 = it2.next();
                    if (next2 != null) {
                        str = next2.lego_card;
                        break;
                    }
                }
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    try {
                        if (TextUtils.equals(new JSONObject(str2).optString("download_key"), new JSONObject(str).optString("download_key"))) {
                            return true;
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, app)) == null) {
            List<GoodsInfo> list = app.goods_info;
            if (list == null) {
                return false;
            }
            for (GoodsInfo goodsInfo : list) {
                if (goodsInfo != null && !TextUtils.isEmpty(goodsInfo.lego_card)) {
                    try {
                        JSONObject optJSONObject = new JSONObject(goodsInfo.lego_card).optJSONObject("vertical_video_style");
                        if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("bottom_picture", ""))) {
                            return true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void r(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, null, advertAppInfo, i) == null) {
            bd8.b().d(dd8.i(advertAppInfo, 5, 1, i));
        }
    }

    public static void s(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, advertAppInfo) == null) {
            r(advertAppInfo, 23);
        }
    }

    public static void t(List<dp4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void u(List<uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, list) == null) {
            for (int i = 0; i < jd7.k(list); i++) {
                if (jd7.d(list, i) instanceof dp4) {
                    ((dp4) jd7.d(list, i)).setPosition(i);
                }
            }
        }
    }
}
