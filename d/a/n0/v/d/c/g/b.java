package d.a.n0.v.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.a.c.k.e.n;
import d.a.n0.v.d.c.e.e;
import d.a.n0.v.d.c.e.f;
import d.a.n0.v.d.c.e.g;
import d.a.n0.v.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public g f65304b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.v.d.c.e.a f65305c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.v.d.c.e.d f65306d;

    /* renamed from: e  reason: collision with root package name */
    public j f65307e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f65308f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f65309g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f65303a = false;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f65310h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<n> f65311i = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.f65304b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f65305c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f65306d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f65307e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        e();
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean g2 = g(jVar);
        this.f65303a = jVar.f65228a;
        return g2;
    }

    public void b() {
        this.f65304b = null;
        this.f65305c = null;
        this.f65306d = null;
        this.f65303a = false;
        List<n> list = this.f65308f;
        if (list != null) {
            list.clear();
        }
        List<n> list2 = this.f65309g;
        if (list2 != null) {
            list2.clear();
        }
        List<SdkLiveInfoData> list3 = this.f65310h;
        if (list3 != null) {
            list3.clear();
        }
        List<n> list4 = this.f65311i;
        if (list4 != null) {
            list4.clear();
        }
    }

    public final ArrayList<n> c(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            e eVar = new e();
            d.a.n0.v.d.a.a aVar = new d.a.n0.v.d.a.a();
            aVar.f65122e = list.get(i2);
            aVar.j = true;
            eVar.f65217e = aVar;
            int i3 = i2 + 1;
            if (i3 < size) {
                d.a.n0.v.d.a.a aVar2 = new d.a.n0.v.d.a.a();
                aVar2.f65122e = list.get(i3);
                eVar.f65218f = aVar2;
                aVar2.k = true;
            } else {
                aVar.j = false;
                aVar.l = true;
            }
            arrayList.add(eVar);
        }
        return arrayList;
    }

    public List<n> d() {
        ArrayList arrayList = new ArrayList();
        if (!ListUtils.isEmpty(this.f65309g)) {
            arrayList.addAll(this.f65309g);
        }
        if (!ListUtils.isEmpty(this.f65311i)) {
            arrayList.addAll(this.f65311i);
        }
        return arrayList;
    }

    public final void e() {
        this.f65308f = new ArrayList();
        g gVar = this.f65304b;
        if (gVar != null && gVar.a()) {
            f fVar = new f();
            fVar.f65220e = this.f65304b;
            this.f65308f.add(fVar);
        }
        if (this.f65305c != null) {
            ArrayList<n> f2 = f();
            if (!ListUtils.isEmpty(f2)) {
                this.f65308f.addAll(f2);
            }
        }
        d.a.n0.v.d.c.e.d dVar = this.f65306d;
        if (dVar != null && !ListUtils.isEmpty(dVar.f65214a)) {
            d.a.n0.v.d.c.e.c cVar = new d.a.n0.v.d.c.e.c();
            cVar.f65213e = this.f65306d;
            this.f65308f.add(cVar);
        }
        this.f65309g = new ArrayList(this.f65308f);
        a(this.f65307e);
    }

    public final ArrayList<n> f() {
        ArrayList<SdkLiveInfoData> arrayList = this.f65305c.f65208a;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                arrayList2.add(sdkLiveInfoData);
            }
        }
        if (arrayList2.size() < 2) {
            return null;
        }
        return c(arrayList2);
    }

    public final boolean g(j jVar) {
        if (jVar == null) {
            return false;
        }
        ArrayList<SdkLiveInfoData> arrayList = jVar.f65229b;
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || d.a.n0.v.d.c.c.c(next))) {
                arrayList2.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return false;
        }
        this.f65310h.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f65310h);
        this.f65311i = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean h() {
        return this.f65303a;
    }
}
