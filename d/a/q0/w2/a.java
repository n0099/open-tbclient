package d.a.q0.w2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.n0;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.w2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1829a implements Comparator<n0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1829a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(n0 n0Var, n0 n0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, n0Var, n0Var2)) == null) {
                if (n0Var.f() && n0Var2.f()) {
                    return n0Var.g() - n0Var2.g();
                }
                if (n0Var.f() || n0Var2.f()) {
                    return n0Var.f() ? -1 : 1;
                }
                return (n0Var.m() == null ? -1 : a.g(n0Var.m())) - (n0Var2.m() != null ? a.g(n0Var2.m()) : -1);
            }
            return invokeLL.intValue;
        }
    }

    public static Set<d.a.d.k.e.n> a(List<d.a.d.k.e.n> list, int i2, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo m;
        AdvertAppInfo m2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i2, str)) == null) {
            HashSet hashSet = new HashSet();
            if (d.a.q0.n1.o.k.a.e(list)) {
                return hashSet;
            }
            Set<d.a.d.k.e.n> a2 = d.a.q0.w2.i0.a.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (d.a.d.k.e.n nVar : list) {
                if (nVar != null) {
                    for (d.a.d.k.e.n nVar2 : a2) {
                        if ((nVar instanceof n0) && (m2 = ((n0) nVar).m()) != null && nVar2.hashCode() == m2.hashCode()) {
                            m2.a4 = ((AdvertAppInfo) nVar2).a4;
                        }
                    }
                    if ((nVar instanceof n0) && (m = ((n0) nVar).m()) != null && m.a4 == null) {
                        d.a.p0.s.q.e eVar = new d.a.p0.s.q.e();
                        m.a4 = eVar;
                        eVar.f53296a = str;
                        eVar.f53297b = i2;
                        eVar.f53303h = m.Y3;
                        eVar.f53304i = false;
                        hashSet.add(m);
                    }
                }
            }
            a2.addAll(hashSet);
            d.a.q0.w2.i0.a.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static int b(@NonNull List<d.a.d.k.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i2 = 0;
            if (d.a.q0.n1.o.k.a.e(list)) {
                return 0;
            }
            int i3 = -1;
            for (int k = d.a.q0.n1.o.k.a.k(list) - 1; k >= 0 && !(d.a.q0.n1.o.k.a.d(list, k) instanceof n0); k--) {
                if (d.a.q0.n1.o.k.a.d(list, k) instanceof a2) {
                    int i4 = ((a2) d.a.q0.n1.o.k.a.d(list, k)).position;
                    if (i4 != i3) {
                        i2++;
                        i3 = i4;
                    }
                } else {
                    i2++;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static void c(List<d.a.d.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || d.a.q0.n1.o.k.a.e(list)) {
            return;
        }
        Iterator<d.a.d.k.e.n> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof n0) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) || TextUtils.isEmpty(str) || d.a.q0.n1.o.k.a.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof n0;
            if (z || (next instanceof App)) {
                if (next instanceof App) {
                    str2 = c.a((App) next);
                } else {
                    if (z) {
                        n0 n0Var = (n0) next;
                        if (n0Var.m() != null) {
                            str2 = n0Var.m().R3;
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

    public static String e(List<d.a.d.k.e.n> list, boolean z) {
        InterceptResult invokeLZ;
        n0 n0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !d.a.q0.n1.o.k.a.e(list)) {
                int i2 = 0;
                for (int k = d.a.q0.n1.o.k.a.k(list) - 1; k >= 0 && i2 < 6; k--) {
                    if ((d.a.q0.n1.o.k.a.d(list, k) instanceof n0) && (n0Var = (n0) d.a.q0.n1.o.k.a.d(list, k)) != null && !n(n0Var.m())) {
                        sb.append(n0Var.g() + 1);
                        sb.append(",");
                        i2++;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, advertAppInfo)) == null) {
            return "#Nad=" + advertAppInfo.Y3;
        }
        return (String) invokeL.objValue;
    }

    public static int g(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, advertAppInfo)) == null) {
            if (advertAppInfo == null) {
                return 0;
            }
            if (TextUtils.isEmpty(advertAppInfo.X3)) {
                return -1;
            }
            return d.a.d.e.m.b.d(advertAppInfo.X3, -1);
        }
        return invokeL.intValue;
    }

    public static List<n0> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (d.a.q0.n1.o.k.a.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.B4(app);
                advertAppInfo.b4 = str;
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
                if (!d.a.q0.n1.o.k.a.e(list)) {
                    for (App app2 : list) {
                        if (p(app, app2)) {
                            return true;
                        }
                    }
                }
                List<App> list2 = bannerList.app;
                if (!d.a.q0.n1.o.k.a.e(list2)) {
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

    public static List<n0> k(List<n0> list, List<d.a.d.k.e.n> list2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, list, list2, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (d.a.q0.n1.o.k.a.e(list)) {
                return arrayList;
            }
            t(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                n0 n0Var = (n0) d.a.q0.n1.o.k.a.d(list, i4);
                if (n0Var != null && n0Var.m() != null) {
                    int k = d.a.q0.n1.o.k.a.k(list2);
                    int g2 = g(n0Var.m()) - 1;
                    if (g2 < 0) {
                        s(n0Var.m());
                    } else {
                        int g3 = n0Var.f() ? n0Var.g() : g2 + i2;
                        if (g3 > k) {
                            s(n0Var.m());
                        } else {
                            n0Var.setPosition(g3);
                            d.a.q0.n1.o.k.a.b(list2, n0Var, g3);
                            arrayList.add(n0Var);
                        }
                    }
                }
            }
            while (i2 < d.a.q0.n1.o.k.a.k(list2)) {
                d.a.d.k.e.n nVar = list2.get(i2);
                if (nVar instanceof n0) {
                    i3++;
                } else if (nVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) nVar).position += i3;
                }
                i2++;
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
            int z4 = advertAppInfo.z4();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return z4;
        }
        return invokeL.intValue;
    }

    public static boolean n(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, advertAppInfo)) == null) ? advertAppInfo == null || advertAppInfo.T3 == 1001 || advertAppInfo.getType() == AdvertAppInfo.l4 || advertAppInfo.getType() == AdvertAppInfo.m4 || advertAppInfo.getType() == AdvertAppInfo.n4 : invokeL.booleanValue;
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
            if (app != null && app2 != null && !d.a.q0.n1.o.k.a.e(app.goods_info) && !d.a.q0.n1.o.k.a.e(app2.goods_info)) {
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

    public static void r(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, null, advertAppInfo, i2) == null) {
            d.a.q0.w2.i0.e.b().d(d.a.q0.w2.i0.g.i(advertAppInfo, 5, 1, i2));
        }
    }

    public static void s(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, advertAppInfo) == null) {
            r(advertAppInfo, 23);
        }
    }

    public static void t(List<n0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, list) == null) {
            Collections.sort(list, new C1829a());
        }
    }

    public static void u(List<d.a.d.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, list) == null) {
            for (int i2 = 0; i2 < d.a.q0.n1.o.k.a.k(list); i2++) {
                if (d.a.q0.n1.o.k.a.d(list, i2) instanceof n0) {
                    ((n0) d.a.q0.n1.o.k.a.d(list, i2)).setPosition(i2);
                }
            }
        }
    }
}
