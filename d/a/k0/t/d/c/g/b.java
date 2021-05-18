package d.a.k0.t.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.a.c.j.e.n;
import d.a.k0.t.d.c.e.e;
import d.a.k0.t.d.c.e.f;
import d.a.k0.t.d.c.e.g;
import d.a.k0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public g f61303b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.t.d.c.e.a f61304c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.t.d.c.e.d f61305d;

    /* renamed from: e  reason: collision with root package name */
    public j f61306e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f61307f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f61308g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61302a = false;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f61309h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<n> f61310i = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.f61303b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f61304c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f61305d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f61306e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        e();
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean g2 = g(jVar);
        this.f61302a = jVar.f61227a;
        return g2;
    }

    public void b() {
        this.f61303b = null;
        this.f61304c = null;
        this.f61305d = null;
        this.f61302a = false;
        List<n> list = this.f61307f;
        if (list != null) {
            list.clear();
        }
        List<n> list2 = this.f61308g;
        if (list2 != null) {
            list2.clear();
        }
        List<SdkLiveInfoData> list3 = this.f61309h;
        if (list3 != null) {
            list3.clear();
        }
        List<n> list4 = this.f61310i;
        if (list4 != null) {
            list4.clear();
        }
    }

    public final ArrayList<n> c(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            e eVar = new e();
            d.a.k0.t.d.a.a aVar = new d.a.k0.t.d.a.a();
            aVar.f61121e = list.get(i2);
            aVar.j = true;
            eVar.f61216e = aVar;
            int i3 = i2 + 1;
            if (i3 < size) {
                d.a.k0.t.d.a.a aVar2 = new d.a.k0.t.d.a.a();
                aVar2.f61121e = list.get(i3);
                eVar.f61217f = aVar2;
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
        if (!ListUtils.isEmpty(this.f61308g)) {
            arrayList.addAll(this.f61308g);
        }
        if (!ListUtils.isEmpty(this.f61310i)) {
            arrayList.addAll(this.f61310i);
        }
        return arrayList;
    }

    public final void e() {
        this.f61307f = new ArrayList();
        g gVar = this.f61303b;
        if (gVar != null && gVar.a()) {
            f fVar = new f();
            fVar.f61219e = this.f61303b;
            this.f61307f.add(fVar);
        }
        if (this.f61304c != null) {
            ArrayList<n> f2 = f();
            if (!ListUtils.isEmpty(f2)) {
                this.f61307f.addAll(f2);
            }
        }
        d.a.k0.t.d.c.e.d dVar = this.f61305d;
        if (dVar != null && !ListUtils.isEmpty(dVar.f61213a)) {
            d.a.k0.t.d.c.e.c cVar = new d.a.k0.t.d.c.e.c();
            cVar.f61212e = this.f61305d;
            this.f61307f.add(cVar);
        }
        this.f61308g = new ArrayList(this.f61307f);
        a(this.f61306e);
    }

    public final ArrayList<n> f() {
        ArrayList<SdkLiveInfoData> arrayList = this.f61304c.f61207a;
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.f61228b;
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || d.a.k0.t.d.c.c.c(next))) {
                arrayList2.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return false;
        }
        this.f61309h.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f61309h);
        this.f61310i = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean h() {
        return this.f61302a;
    }
}
