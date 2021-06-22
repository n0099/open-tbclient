package d.a.o0.v.d.c.f.c;

import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.o0.v.d.a.c;
import d.a.o0.v.d.c.e.k;
import d.a.o0.v.d.f.c.e;
import d.a.o0.v.d.f.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static long f65380f = 604800000;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65381a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f65382b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<n> f65383c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f65384d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<n> f65385e = new ArrayList();

    public b(TbPageContext tbPageContext) {
        this.f65381a = tbPageContext;
    }

    public void a() {
        List<n> list = this.f65383c;
        if (list != null) {
            list.clear();
        }
        List<n> list2 = this.f65384d;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f65385e;
        if (list3 != null) {
            list3.clear();
        }
        List<n> list4 = this.f65382b;
        if (list4 != null) {
            list4.clear();
        }
    }

    public final List<n> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null && alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!ListUtils.isEmpty(this.f65384d) && k(alaLiveTabMyConcernResponse)) {
                arrayList.add(new d.a.o0.v.d.c.f.b.a());
            }
            if (!ListUtils.isEmpty(this.f65384d)) {
                g gVar = new g();
                gVar.f65570f = this.f65381a.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!ListUtils.isEmpty(this.f65384d)) {
                for (n nVar : this.f65384d) {
                    arrayList.add(nVar);
                }
            }
        }
        return arrayList;
    }

    public final List<n> c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            g gVar = new g();
            gVar.f65570f = this.f65381a.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
            arrayList.add(gVar);
        }
        if (!ListUtils.isEmpty(this.f65383c)) {
            arrayList.addAll(f());
        } else if (z) {
            e eVar = new e();
            eVar.f65563e = alaLiveTabMyConcernResponse.followStatus;
            arrayList.add(eVar);
        }
        return arrayList;
    }

    public final List<n> d() {
        ArrayList arrayList = new ArrayList();
        if (!ListUtils.isEmpty(this.f65385e)) {
            g gVar = new g();
            gVar.f65570f = this.f65381a.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(g(this.f65385e));
        }
        return arrayList;
    }

    public void e(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse == null) {
            return;
        }
        if (z) {
            this.f65382b.clear();
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.followList)) {
            this.f65383c.addAll(alaLiveTabMyConcernResponse.followList);
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
            this.f65384d.addAll(alaLiveTabMyConcernResponse.followCloseList);
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
            this.f65385e.addAll(alaLiveTabMyConcernResponse.recommendList);
        }
        this.f65382b = i(alaLiveTabMyConcernResponse, z);
    }

    public final List<n> f() {
        ArrayList arrayList = new ArrayList();
        if (!ListUtils.isEmpty(this.f65383c)) {
            int size = this.f65383c.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.f65255h = (a2) this.f65383c.get(i2);
                cVar.k = true;
                kVar.f65356e = cVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    c cVar2 = new c();
                    cVar2.f65255h = (a2) this.f65383c.get(i3);
                    kVar.f65357f = cVar2;
                    cVar2.l = true;
                } else {
                    cVar.k = false;
                    cVar.m = true;
                }
                int i4 = size % 2;
                if ((i4 == 0 && i2 == size - 2) || (i4 != 0 && i2 == size - 1)) {
                    kVar.f65358g = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    public final List<n> g(List<n> list) {
        ArrayList arrayList = new ArrayList();
        if (!ListUtils.isEmpty(list)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 += 3) {
                d.a.o0.v.d.c.f.b.c cVar = new d.a.o0.v.d.c.f.b.c();
                c cVar2 = new c();
                cVar2.f65255h = (a2) list.get(i2);
                cVar2.j = false;
                cVar.f65377e = cVar2;
                int i3 = i2 + 1;
                if (i3 < size) {
                    c cVar3 = new c();
                    cVar3.f65255h = (a2) list.get(i3);
                    cVar3.j = false;
                    cVar.f65378f = cVar3;
                }
                int i4 = i2 + 2;
                if (i4 < size) {
                    c cVar4 = new c();
                    cVar4.f65255h = (a2) list.get(i4);
                    cVar4.j = false;
                    cVar.f65379g = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public List<n> h() {
        return this.f65382b;
    }

    public final List<n> i(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        List<n> c2 = c(alaLiveTabMyConcernResponse, z);
        if (!ListUtils.isEmpty(c2)) {
            arrayList.addAll(c2);
        }
        List<n> b2 = b(alaLiveTabMyConcernResponse);
        if (!ListUtils.isEmpty(b2)) {
            arrayList.addAll(b2);
        }
        List<n> d2 = d();
        if (!ListUtils.isEmpty(d2)) {
            arrayList.addAll(d2);
        }
        return arrayList;
    }

    public void j(Class<? extends BaseCardInfo> cls) {
        if (ListUtils.isEmpty(this.f65382b)) {
            return;
        }
        for (int size = this.f65382b.size() - 1; size >= 0; size--) {
            n nVar = (n) ListUtils.getItem(this.f65382b, size);
            if (nVar != null && nVar.getClass().equals(cls)) {
                this.f65382b.remove(size);
            }
        }
    }

    public final boolean k(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        if (alaLiveTabMyConcernResponse == null) {
            return false;
        }
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.a(this.f65381a) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > f65380f ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == f65380f ? 0 : -1)) > 0)) ? false : true;
    }
}
