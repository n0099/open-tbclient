package d.b.i0.r2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.h0.r.q.m0;
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

    /* renamed from: d.b.i0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1504a implements Comparator<m0> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(m0 m0Var, m0 m0Var2) {
            if (m0Var.c() && m0Var2.c()) {
                return m0Var.i() - m0Var2.i();
            }
            if (m0Var.c() || m0Var2.c()) {
                return m0Var.c() ? -1 : 1;
            }
            return (m0Var.d() == null ? -1 : a.f(m0Var.d())) - (m0Var2.d() != null ? a.f(m0Var2.d()) : -1);
        }
    }

    public static Set<d.b.b.j.e.n> a(List<d.b.b.j.e.n> list, int i, String str) {
        AdvertAppInfo d2;
        AdvertAppInfo d3;
        HashSet hashSet = new HashSet();
        if (d.b.i0.i1.o.k.a.e(list)) {
            return hashSet;
        }
        Set<d.b.b.j.e.n> a2 = d.b.i0.r2.b0.a.a(str);
        if (a2 == null) {
            a2 = new HashSet();
        }
        for (d.b.b.j.e.n nVar : list) {
            if (nVar != null) {
                for (d.b.b.j.e.n nVar2 : a2) {
                    if ((nVar instanceof m0) && (d3 = ((m0) nVar).d()) != null && nVar2.hashCode() == d3.hashCode()) {
                        d3.Y3 = ((AdvertAppInfo) nVar2).Y3;
                    }
                }
                if ((nVar instanceof m0) && (d2 = ((m0) nVar).d()) != null && d2.Y3 == null) {
                    d.b.h0.r.q.d dVar = new d.b.h0.r.q.d();
                    d2.Y3 = dVar;
                    dVar.f50749a = str;
                    dVar.f50750b = i;
                    dVar.f50756h = d2.T3;
                    dVar.i = false;
                    hashSet.add(d2);
                }
            }
        }
        a2.addAll(hashSet);
        d.b.i0.r2.b0.a.b(str, a2);
        return hashSet;
    }

    public static int b(@NonNull List<d.b.b.j.e.n> list) {
        int j = d.b.i0.i1.o.k.a.j(list);
        if (d.b.i0.i1.o.k.a.e(list)) {
            return j;
        }
        boolean z = true;
        int j2 = d.b.i0.i1.o.k.a.j(list) - 1;
        int i = 0;
        while (true) {
            if (j2 < 0) {
                z = false;
                break;
            } else if (d.b.i0.i1.o.k.a.d(list, j2) instanceof m0) {
                break;
            } else {
                i++;
                j2--;
            }
        }
        return z ? i : j;
    }

    public static void c(List<d.b.b.j.e.n> list) {
        if (d.b.i0.i1.o.k.a.e(list)) {
            return;
        }
        Iterator<d.b.b.j.e.n> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof m0) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        if (TextUtils.isEmpty(str) || d.b.i0.i1.o.k.a.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof m0;
            if (z || (next instanceof App)) {
                if (next instanceof App) {
                    str2 = ((App) next).id;
                } else {
                    if (z) {
                        m0 m0Var = (m0) next;
                        if (m0Var.d() != null) {
                            str2 = m0Var.d().E3;
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

    public static String e(List<d.b.b.j.e.n> list, boolean z) {
        m0 m0Var;
        StringBuilder sb = new StringBuilder();
        if (!z && !d.b.i0.i1.o.k.a.e(list)) {
            int i = 0;
            for (int j = d.b.i0.i1.o.k.a.j(list) - 1; j >= 0 && i < 6; j--) {
                if ((d.b.i0.i1.o.k.a.d(list, j) instanceof m0) && (m0Var = (m0) d.b.i0.i1.o.k.a.d(list, j)) != null && !l(m0Var.d())) {
                    sb.append(m0Var.i() + 1);
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

    public static int f(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            return 0;
        }
        if (TextUtils.isEmpty(advertAppInfo.K3)) {
            return -1;
        }
        return d.b.b.e.m.b.d(advertAppInfo.K3, -1);
    }

    public static List<m0> g(List<App> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (d.b.i0.i1.o.k.a.e(list)) {
            return arrayList;
        }
        Log.e("frs", "src ad list size " + list.size());
        for (App app : list) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            advertAppInfo.F4(app);
            advertAppInfo.c4 = str;
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
            if (!d.b.i0.i1.o.k.a.e(list)) {
                for (App app2 : list) {
                    if (n(app, app2)) {
                        return true;
                    }
                }
            }
            List<App> list2 = bannerList.app;
            if (!d.b.i0.i1.o.k.a.e(list2)) {
                for (App app3 : list2) {
                    if (n(app, app3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static List<m0> j(List<m0> list, List<d.b.b.j.e.n> list2, int i) {
        ArrayList arrayList = new ArrayList();
        if (d.b.i0.i1.o.k.a.e(list)) {
            return arrayList;
        }
        r(list);
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            m0 m0Var = (m0) d.b.i0.i1.o.k.a.d(list, i3);
            if (m0Var != null && m0Var.d() != null) {
                int j = d.b.i0.i1.o.k.a.j(list2);
                int f2 = f(m0Var.d()) - 1;
                if (f2 < 0) {
                    q(m0Var.d());
                } else {
                    int i4 = m0Var.c() ? m0Var.i() : f2 + i;
                    if (i4 > j) {
                        q(m0Var.d());
                    } else {
                        m0Var.setPosition(i4);
                        d.b.i0.i1.o.k.a.b(list2, m0Var, i4);
                        arrayList.add(m0Var);
                    }
                }
            }
        }
        while (i < d.b.i0.i1.o.k.a.j(list2)) {
            d.b.b.j.e.n nVar = list2.get(i);
            if (nVar instanceof m0) {
                i2++;
            } else if (nVar instanceof BaseCardInfo) {
                ((BaseCardInfo) nVar).position += i2;
            }
            i++;
        }
        return arrayList;
    }

    public static int k(@Nullable AdvertAppInfo advertAppInfo) {
        int D4 = advertAppInfo.D4();
        if (f(advertAppInfo) < 0) {
            return 23;
        }
        return D4;
    }

    public static boolean l(AdvertAppInfo advertAppInfo) {
        return advertAppInfo == null || advertAppInfo.getType() == AdvertAppInfo.h4 || advertAppInfo.getType() == AdvertAppInfo.i4 || advertAppInfo.getType() == AdvertAppInfo.j4;
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
        if (app != null && app2 != null && !d.b.i0.i1.o.k.a.e(app.goods_info) && !d.b.i0.i1.o.k.a.e(app2.goods_info)) {
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

    public static void p(AdvertAppInfo advertAppInfo, int i) {
        AppData appData;
        d.b.i0.r2.b0.e.b().d(d.b.i0.r2.b0.h.i(advertAppInfo, 5, 1, i));
        if (advertAppInfo == null || (appData = advertAppInfo.e4) == null) {
            return;
        }
        appData.mDiscardReason = i;
    }

    public static void q(AdvertAppInfo advertAppInfo) {
        p(advertAppInfo, 23);
    }

    public static void r(List<m0> list) {
        Collections.sort(list, new C1504a());
    }

    public static void s(List<d.b.b.j.e.n> list) {
        for (int i = 0; i < d.b.i0.i1.o.k.a.j(list); i++) {
            if (d.b.i0.i1.o.k.a.d(list, i) instanceof m0) {
                ((m0) d.b.i0.i1.o.k.a.d(list, i)).setPosition(i);
            }
        }
    }
}
