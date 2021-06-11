package d.a.n0.t2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.m0.r.q.m0;
import d.a.m0.r.q.z1;
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
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.a.n0.t2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1668a implements Comparator<m0> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(m0 m0Var, m0 m0Var2) {
            if (m0Var.d() && m0Var2.d()) {
                return m0Var.f() - m0Var2.f();
            }
            if (m0Var.d() || m0Var2.d()) {
                return m0Var.d() ? -1 : 1;
            }
            return (m0Var.m() == null ? -1 : a.f(m0Var.m())) - (m0Var2.m() != null ? a.f(m0Var2.m()) : -1);
        }
    }

    public static Set<d.a.c.k.e.n> a(List<d.a.c.k.e.n> list, int i2, String str) {
        AdvertAppInfo m;
        AdvertAppInfo m2;
        HashSet hashSet = new HashSet();
        if (d.a.n0.k1.o.k.a.e(list)) {
            return hashSet;
        }
        Set<d.a.c.k.e.n> a2 = d.a.n0.t2.i0.a.a(str);
        if (a2 == null) {
            a2 = new HashSet();
        }
        for (d.a.c.k.e.n nVar : list) {
            if (nVar != null) {
                for (d.a.c.k.e.n nVar2 : a2) {
                    if ((nVar instanceof m0) && (m2 = ((m0) nVar).m()) != null && nVar2.hashCode() == m2.hashCode()) {
                        m2.S3 = ((AdvertAppInfo) nVar2).S3;
                    }
                }
                if ((nVar instanceof m0) && (m = ((m0) nVar).m()) != null && m.S3 == null) {
                    d.a.m0.r.q.d dVar = new d.a.m0.r.q.d();
                    m.S3 = dVar;
                    dVar.f53655a = str;
                    dVar.f53656b = i2;
                    dVar.f53662h = m.Q3;
                    dVar.f53663i = false;
                    hashSet.add(m);
                }
            }
        }
        a2.addAll(hashSet);
        d.a.n0.t2.i0.a.b(str, a2);
        return hashSet;
    }

    public static int b(@NonNull List<d.a.c.k.e.n> list) {
        int i2 = 0;
        if (d.a.n0.k1.o.k.a.e(list)) {
            return 0;
        }
        int i3 = -1;
        for (int k = d.a.n0.k1.o.k.a.k(list) - 1; k >= 0 && !(d.a.n0.k1.o.k.a.d(list, k) instanceof m0); k--) {
            if (d.a.n0.k1.o.k.a.d(list, k) instanceof z1) {
                int i4 = ((z1) d.a.n0.k1.o.k.a.d(list, k)).position;
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

    public static void c(List<d.a.c.k.e.n> list) {
        if (d.a.n0.k1.o.k.a.e(list)) {
            return;
        }
        Iterator<d.a.c.k.e.n> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof m0) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        if (TextUtils.isEmpty(str) || d.a.n0.k1.o.k.a.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof m0;
            if (z || (next instanceof App)) {
                if (next instanceof App) {
                    str2 = c.a((App) next);
                } else {
                    if (z) {
                        m0 m0Var = (m0) next;
                        if (m0Var.m() != null) {
                            str2 = m0Var.m().J3;
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
        m0 m0Var;
        StringBuilder sb = new StringBuilder();
        if (!z && !d.a.n0.k1.o.k.a.e(list)) {
            int i2 = 0;
            for (int k = d.a.n0.k1.o.k.a.k(list) - 1; k >= 0 && i2 < 6; k--) {
                if ((d.a.n0.k1.o.k.a.d(list, k) instanceof m0) && (m0Var = (m0) d.a.n0.k1.o.k.a.d(list, k)) != null && !l(m0Var.m())) {
                    sb.append(m0Var.f() + 1);
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

    public static int f(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            return 0;
        }
        if (TextUtils.isEmpty(advertAppInfo.P3)) {
            return -1;
        }
        return d.a.c.e.m.b.d(advertAppInfo.P3, -1);
    }

    public static List<m0> g(List<App> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (d.a.n0.k1.o.k.a.e(list)) {
            return arrayList;
        }
        Log.e("frs", "src ad list size " + list.size());
        for (App app : list) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            advertAppInfo.K4(app);
            advertAppInfo.T3 = str;
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

    public static int h(@NonNull App app) {
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

    public static boolean i(App app, BannerList bannerList) {
        if (app != null && bannerList != null) {
            if (n(app, bannerList.pb_banner_ad)) {
                return true;
            }
            List<App> list = bannerList.video_recommend_ad;
            if (!d.a.n0.k1.o.k.a.e(list)) {
                for (App app2 : list) {
                    if (n(app, app2)) {
                        return true;
                    }
                }
            }
            List<App> list2 = bannerList.app;
            if (!d.a.n0.k1.o.k.a.e(list2)) {
                for (App app3 : list2) {
                    if (n(app, app3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static List<m0> j(List<m0> list, List<d.a.c.k.e.n> list2, int i2) {
        ArrayList arrayList = new ArrayList();
        if (d.a.n0.k1.o.k.a.e(list)) {
            return arrayList;
        }
        r(list);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            m0 m0Var = (m0) d.a.n0.k1.o.k.a.d(list, i4);
            if (m0Var != null && m0Var.m() != null) {
                int k = d.a.n0.k1.o.k.a.k(list2);
                int f2 = f(m0Var.m()) - 1;
                if (f2 < 0) {
                    q(m0Var.m());
                } else {
                    int f3 = m0Var.d() ? m0Var.f() : f2 + i2;
                    if (f3 > k) {
                        q(m0Var.m());
                    } else {
                        m0Var.setPosition(f3);
                        d.a.n0.k1.o.k.a.b(list2, m0Var, f3);
                        arrayList.add(m0Var);
                    }
                }
            }
        }
        while (i2 < d.a.n0.k1.o.k.a.k(list2)) {
            d.a.c.k.e.n nVar = list2.get(i2);
            if (nVar instanceof m0) {
                i3++;
            } else if (nVar instanceof BaseCardInfo) {
                ((BaseCardInfo) nVar).position += i3;
            }
            i2++;
        }
        return arrayList;
    }

    public static int k(@Nullable AdvertAppInfo advertAppInfo) {
        int I4 = advertAppInfo.I4();
        if (f(advertAppInfo) < 0) {
            return 23;
        }
        return I4;
    }

    public static boolean l(AdvertAppInfo advertAppInfo) {
        return advertAppInfo == null || advertAppInfo.L3 == 1001 || advertAppInfo.getType() == AdvertAppInfo.d4 || advertAppInfo.getType() == AdvertAppInfo.e4 || advertAppInfo.getType() == AdvertAppInfo.f4;
    }

    public static boolean m(@NonNull App app) {
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

    public static boolean n(App app, App app2) {
        String str;
        String str2;
        if (app != null && app2 != null && !d.a.n0.k1.o.k.a.e(app.goods_info) && !d.a.n0.k1.o.k.a.e(app2.goods_info)) {
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

    public static boolean o(@NonNull App app) {
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

    public static void p(AdvertAppInfo advertAppInfo, int i2) {
        d.a.n0.t2.i0.e.b().d(d.a.n0.t2.i0.g.i(advertAppInfo, 5, 1, i2));
    }

    public static void q(AdvertAppInfo advertAppInfo) {
        p(advertAppInfo, 23);
    }

    public static void r(List<m0> list) {
        Collections.sort(list, new C1668a());
    }

    public static void s(List<d.a.c.k.e.n> list) {
        for (int i2 = 0; i2 < d.a.n0.k1.o.k.a.k(list); i2++) {
            if (d.a.n0.k1.o.k.a.d(list, i2) instanceof m0) {
                ((m0) d.a.n0.k1.o.k.a.d(list, i2)).setPosition(i2);
            }
        }
    }
}
