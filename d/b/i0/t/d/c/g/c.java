package d.b.i0.t.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.b.b.j.e.n;
import d.b.i0.t.d.c.e.e;
import d.b.i0.t.d.c.e.f;
import d.b.i0.t.d.c.e.g;
import d.b.i0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public g f60419b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.t.d.c.e.a f60420c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.t.d.c.e.d f60421d;

    /* renamed from: e  reason: collision with root package name */
    public j f60422e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f60423f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f60424g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f60418a = false;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f60425h = new ArrayList();
    public List<n> i = new ArrayList();

    public c(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.f60419b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f60420c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f60421d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f60422e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        e();
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean g2 = g(jVar);
        this.f60418a = jVar.f60340a;
        return g2;
    }

    public void b() {
        this.f60419b = null;
        this.f60420c = null;
        this.f60421d = null;
        this.f60418a = false;
        List<n> list = this.f60423f;
        if (list != null) {
            list.clear();
        }
        List<n> list2 = this.f60424g;
        if (list2 != null) {
            list2.clear();
        }
        List<SdkLiveInfoData> list3 = this.f60425h;
        if (list3 != null) {
            list3.clear();
        }
        List<n> list4 = this.i;
        if (list4 != null) {
            list4.clear();
        }
    }

    public final ArrayList<n> c(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            d.b.i0.t.d.a.a aVar = new d.b.i0.t.d.a.a();
            aVar.f60235e = list.get(i);
            aVar.j = true;
            eVar.f60329e = aVar;
            int i2 = i + 1;
            if (i2 < size) {
                d.b.i0.t.d.a.a aVar2 = new d.b.i0.t.d.a.a();
                aVar2.f60235e = list.get(i2);
                eVar.f60330f = aVar2;
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
        if (!ListUtils.isEmpty(this.f60424g)) {
            arrayList.addAll(this.f60424g);
        }
        if (!ListUtils.isEmpty(this.i)) {
            arrayList.addAll(this.i);
        }
        return arrayList;
    }

    public final void e() {
        this.f60423f = new ArrayList();
        g gVar = this.f60419b;
        if (gVar != null && gVar.a()) {
            f fVar = new f();
            fVar.f60332e = this.f60419b;
            this.f60423f.add(fVar);
        }
        if (this.f60420c != null) {
            ArrayList<n> f2 = f();
            if (!ListUtils.isEmpty(f2)) {
                this.f60423f.addAll(f2);
            }
        }
        d.b.i0.t.d.c.e.d dVar = this.f60421d;
        if (dVar != null && !ListUtils.isEmpty(dVar.f60327a)) {
            d.b.i0.t.d.c.e.c cVar = new d.b.i0.t.d.c.e.c();
            cVar.f60326e = this.f60421d;
            this.f60423f.add(cVar);
        }
        this.f60424g = new ArrayList(this.f60423f);
        a(this.f60422e);
    }

    public final ArrayList<n> f() {
        ArrayList<SdkLiveInfoData> arrayList = this.f60420c.f60321a;
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.f60341b;
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || d.b.i0.t.d.c.c.b(next))) {
                arrayList2.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return false;
        }
        this.f60425h.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f60425h);
        this.i = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean h() {
        return this.f60418a;
    }
}
