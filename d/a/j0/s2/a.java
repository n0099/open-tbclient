package d.a.j0.s2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.a.i0.r.q.m0;
import d.a.i0.r.q.z1;
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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.j0.s2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1537a implements Comparator<m0> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(m0 m0Var, m0 m0Var2) {
            if (m0Var.b() && m0Var2.b()) {
                return m0Var.d() - m0Var2.d();
            }
            if (m0Var.b() || m0Var2.b()) {
                return m0Var.b() ? -1 : 1;
            }
            return (m0Var.j() == null ? -1 : a.f(m0Var.j())) - (m0Var2.j() != null ? a.f(m0Var2.j()) : -1);
        }
    }

    public static Set<d.a.c.j.e.n> a(List<d.a.c.j.e.n> list, int i2, String str) {
        AdvertAppInfo j;
        AdvertAppInfo j2;
        HashSet hashSet = new HashSet();
        if (d.a.j0.j1.o.k.a.e(list)) {
            return hashSet;
        }
        Set<d.a.c.j.e.n> a2 = d.a.j0.s2.h0.a.a(str);
        if (a2 == null) {
            a2 = new HashSet();
        }
        for (d.a.c.j.e.n nVar : list) {
            if (nVar != null) {
                for (d.a.c.j.e.n nVar2 : a2) {
                    if ((nVar instanceof m0) && (j2 = ((m0) nVar).j()) != null && nVar2.hashCode() == j2.hashCode()) {
                        j2.Y3 = ((AdvertAppInfo) nVar2).Y3;
                    }
                }
                if ((nVar instanceof m0) && (j = ((m0) nVar).j()) != null && j.Y3 == null) {
                    d.a.i0.r.q.d dVar = new d.a.i0.r.q.d();
                    j.Y3 = dVar;
                    dVar.f49116a = str;
                    dVar.f49117b = i2;
                    dVar.f49123h = j.T3;
                    dVar.f49124i = false;
                    hashSet.add(j);
                }
            }
        }
        a2.addAll(hashSet);
        d.a.j0.s2.h0.a.b(str, a2);
        return hashSet;
    }

    public static int b(@NonNull List<d.a.c.j.e.n> list) {
        int i2 = 0;
        if (d.a.j0.j1.o.k.a.e(list)) {
            return 0;
        }
        int i3 = -1;
        for (int k = d.a.j0.j1.o.k.a.k(list) - 1; k >= 0 && !(d.a.j0.j1.o.k.a.d(list, k) instanceof m0); k--) {
            if (d.a.j0.j1.o.k.a.d(list, k) instanceof z1) {
                int i4 = ((z1) d.a.j0.j1.o.k.a.d(list, k)).position;
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

    public static void c(List<d.a.c.j.e.n> list) {
        if (d.a.j0.j1.o.k.a.e(list)) {
            return;
        }
        Iterator<d.a.c.j.e.n> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof m0) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        if (TextUtils.isEmpty(str) || d.a.j0.j1.o.k.a.e(list)) {
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
                        if (m0Var.j() != null) {
                            str2 = m0Var.j().E3;
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

    public static String e(List<d.a.c.j.e.n> list, boolean z) {
        m0 m0Var;
        StringBuilder sb = new StringBuilder();
        if (!z && !d.a.j0.j1.o.k.a.e(list)) {
            int i2 = 0;
            for (int k = d.a.j0.j1.o.k.a.k(list) - 1; k >= 0 && i2 < 6; k--) {
                if ((d.a.j0.j1.o.k.a.d(list, k) instanceof m0) && (m0Var = (m0) d.a.j0.j1.o.k.a.d(list, k)) != null && !l(m0Var.j())) {
                    sb.append(m0Var.d() + 1);
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
        if (TextUtils.isEmpty(advertAppInfo.K3)) {
            return -1;
        }
        return d.a.c.e.m.b.d(advertAppInfo.K3, -1);
    }

    public static List<m0> g(List<App> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (d.a.j0.j1.o.k.a.e(list)) {
            return arrayList;
        }
        Log.e("frs", "src ad list size " + list.size());
        for (App app : list) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            advertAppInfo.H4(app);
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
            if (!d.a.j0.j1.o.k.a.e(list)) {
                for (App app2 : list) {
                    if (n(app, app2)) {
                        return true;
                    }
                }
            }
            List<App> list2 = bannerList.app;
            if (!d.a.j0.j1.o.k.a.e(list2)) {
                for (App app3 : list2) {
                    if (n(app, app3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static List<m0> j(List<m0> list, List<d.a.c.j.e.n> list2, int i2) {
        ArrayList arrayList = new ArrayList();
        if (d.a.j0.j1.o.k.a.e(list)) {
            return arrayList;
        }
        r(list);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            m0 m0Var = (m0) d.a.j0.j1.o.k.a.d(list, i4);
            if (m0Var != null && m0Var.j() != null) {
                int k = d.a.j0.j1.o.k.a.k(list2);
                int f2 = f(m0Var.j()) - 1;
                if (f2 < 0) {
                    q(m0Var.j());
                } else {
                    int d2 = m0Var.b() ? m0Var.d() : f2 + i2;
                    if (d2 > k) {
                        q(m0Var.j());
                    } else {
                        m0Var.setPosition(d2);
                        d.a.j0.j1.o.k.a.b(list2, m0Var, d2);
                        arrayList.add(m0Var);
                    }
                }
            }
        }
        while (i2 < d.a.j0.j1.o.k.a.k(list2)) {
            d.a.c.j.e.n nVar = list2.get(i2);
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
        int E4 = advertAppInfo.E4();
        if (f(advertAppInfo) < 0) {
            return 23;
        }
        return E4;
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
        if (app != null && app2 != null && !d.a.j0.j1.o.k.a.e(app.goods_info) && !d.a.j0.j1.o.k.a.e(app2.goods_info)) {
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
        AppData appData;
        d.a.j0.s2.h0.e.b().d(d.a.j0.s2.h0.h.i(advertAppInfo, 5, 1, i2));
        if (advertAppInfo == null || (appData = advertAppInfo.e4) == null) {
            return;
        }
        appData.mDiscardReason = i2;
    }

    public static void q(AdvertAppInfo advertAppInfo) {
        p(advertAppInfo, 23);
    }

    public static void r(List<m0> list) {
        Collections.sort(list, new C1537a());
    }

    public static void s(List<d.a.c.j.e.n> list) {
        for (int i2 = 0; i2 < d.a.j0.j1.o.k.a.k(list); i2++) {
            if (d.a.j0.j1.o.k.a.d(list, i2) instanceof m0) {
                ((m0) d.a.j0.j1.o.k.a.d(list, i2)).setPosition(i2);
            }
        }
    }
}
