package d.a.s0.w2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.a2;
import d.a.r0.r.q.n0;
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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.s0.w2.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1867a implements Comparator<n0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1867a() {
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
                return (n0Var.m() == null ? -1 : a.f(n0Var.m())) - (n0Var2.m() != null ? a.f(n0Var2.m()) : -1);
            }
            return invokeLL.intValue;
        }
    }

    public static Set<d.a.c.k.e.n> a(List<d.a.c.k.e.n> list, int i2, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo m;
        AdvertAppInfo m2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i2, str)) == null) {
            HashSet hashSet = new HashSet();
            if (d.a.s0.n1.o.k.a.e(list)) {
                return hashSet;
            }
            Set<d.a.c.k.e.n> a2 = d.a.s0.w2.i0.a.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (d.a.c.k.e.n nVar : list) {
                if (nVar != null) {
                    for (d.a.c.k.e.n nVar2 : a2) {
                        if ((nVar instanceof n0) && (m2 = ((n0) nVar).m()) != null && nVar2.hashCode() == m2.hashCode()) {
                            m2.U3 = ((AdvertAppInfo) nVar2).U3;
                        }
                    }
                    if ((nVar instanceof n0) && (m = ((n0) nVar).m()) != null && m.U3 == null) {
                        d.a.r0.r.q.e eVar = new d.a.r0.r.q.e();
                        m.U3 = eVar;
                        eVar.f55917a = str;
                        eVar.f55918b = i2;
                        eVar.f55924h = m.S3;
                        eVar.f55925i = false;
                        hashSet.add(m);
                    }
                }
            }
            a2.addAll(hashSet);
            d.a.s0.w2.i0.a.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static int b(@NonNull List<d.a.c.k.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i2 = 0;
            if (d.a.s0.n1.o.k.a.e(list)) {
                return 0;
            }
            int i3 = -1;
            for (int k = d.a.s0.n1.o.k.a.k(list) - 1; k >= 0 && !(d.a.s0.n1.o.k.a.d(list, k) instanceof n0); k--) {
                if (d.a.s0.n1.o.k.a.d(list, k) instanceof a2) {
                    int i4 = ((a2) d.a.s0.n1.o.k.a.d(list, k)).position;
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

    public static void c(List<d.a.c.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || d.a.s0.n1.o.k.a.e(list)) {
            return;
        }
        Iterator<d.a.c.k.e.n> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof n0) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) || TextUtils.isEmpty(str) || d.a.s0.n1.o.k.a.e(list)) {
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
                            str2 = n0Var.m().L3;
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

    public static String e(List<d.a.c.k.e.n> list, boolean z) {
        InterceptResult invokeLZ;
        n0 n0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65540, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !d.a.s0.n1.o.k.a.e(list)) {
                int i2 = 0;
                for (int k = d.a.s0.n1.o.k.a.k(list) - 1; k >= 0 && i2 < 6; k--) {
                    if ((d.a.s0.n1.o.k.a.d(list, k) instanceof n0) && (n0Var = (n0) d.a.s0.n1.o.k.a.d(list, k)) != null && !l(n0Var.m())) {
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

    public static int f(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, advertAppInfo)) == null) {
            if (advertAppInfo == null) {
                return 0;
            }
            if (TextUtils.isEmpty(advertAppInfo.R3)) {
                return -1;
            }
            return d.a.c.e.m.b.d(advertAppInfo.R3, -1);
        }
        return invokeL.intValue;
    }

    public static List<n0> g(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (d.a.s0.n1.o.k.a.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.y4(app);
                advertAppInfo.V3 = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    p(advertAppInfo, k);
                } else {
                    arrayList.add(advertAppInfo);
                }
            }
            Log.e("frs", "src ad jiaoyan size " + arrayList.size());
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static int h(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, app)) == null) {
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

    public static boolean i(App app, BannerList bannerList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, app, bannerList)) == null) {
            if (app != null && bannerList != null) {
                if (n(app, bannerList.pb_banner_ad)) {
                    return true;
                }
                List<App> list = bannerList.video_recommend_ad;
                if (!d.a.s0.n1.o.k.a.e(list)) {
                    for (App app2 : list) {
                        if (n(app, app2)) {
                            return true;
                        }
                    }
                }
                List<App> list2 = bannerList.app;
                if (!d.a.s0.n1.o.k.a.e(list2)) {
                    for (App app3 : list2) {
                        if (n(app, app3)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<n0> j(List<n0> list, List<d.a.c.k.e.n> list2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, list, list2, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (d.a.s0.n1.o.k.a.e(list)) {
                return arrayList;
            }
            r(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                n0 n0Var = (n0) d.a.s0.n1.o.k.a.d(list, i4);
                if (n0Var != null && n0Var.m() != null) {
                    int k = d.a.s0.n1.o.k.a.k(list2);
                    int f2 = f(n0Var.m()) - 1;
                    if (f2 < 0) {
                        q(n0Var.m());
                    } else {
                        int g2 = n0Var.f() ? n0Var.g() : f2 + i2;
                        if (g2 > k) {
                            q(n0Var.m());
                        } else {
                            n0Var.setPosition(g2);
                            d.a.s0.n1.o.k.a.b(list2, n0Var, g2);
                            arrayList.add(n0Var);
                        }
                    }
                }
            }
            while (i2 < d.a.s0.n1.o.k.a.k(list2)) {
                d.a.c.k.e.n nVar = list2.get(i2);
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

    public static int k(@Nullable AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, advertAppInfo)) == null) {
            int w4 = advertAppInfo.w4();
            if (f(advertAppInfo) < 0) {
                return 23;
            }
            return w4;
        }
        return invokeL.intValue;
    }

    public static boolean l(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, advertAppInfo)) == null) ? advertAppInfo == null || advertAppInfo.N3 == 1001 || advertAppInfo.getType() == AdvertAppInfo.f4 || advertAppInfo.getType() == AdvertAppInfo.g4 || advertAppInfo.getType() == AdvertAppInfo.h4 : invokeL.booleanValue;
    }

    public static boolean m(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, app)) == null) {
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

    public static boolean n(App app, App app2) {
        InterceptResult invokeLL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, app, app2)) == null) {
            if (app != null && app2 != null && !d.a.s0.n1.o.k.a.e(app.goods_info) && !d.a.s0.n1.o.k.a.e(app2.goods_info)) {
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

    public static boolean o(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, app)) == null) {
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

    public static void p(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, advertAppInfo, i2) == null) {
            d.a.s0.w2.i0.e.b().d(d.a.s0.w2.i0.g.i(advertAppInfo, 5, 1, i2));
        }
    }

    public static void q(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, advertAppInfo) == null) {
            p(advertAppInfo, 23);
        }
    }

    public static void r(List<n0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, list) == null) {
            Collections.sort(list, new C1867a());
        }
    }

    public static void s(List<d.a.c.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, list) == null) {
            for (int i2 = 0; i2 < d.a.s0.n1.o.k.a.k(list); i2++) {
                if (d.a.s0.n1.o.k.a.d(list, i2) instanceof n0) {
                    ((n0) d.a.s0.n1.o.k.a.d(list, i2)).setPosition(i2);
                }
            }
        }
    }
}
