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
    public g f60418b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.t.d.c.e.a f60419c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.t.d.c.e.d f60420d;

    /* renamed from: e  reason: collision with root package name */
    public j f60421e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f60422f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f60423g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f60417a = false;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f60424h = new ArrayList();
    public List<n> i = new ArrayList();

    public c(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.f60418b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f60419c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f60420d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f60421e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        e();
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean g2 = g(jVar);
        this.f60417a = jVar.f60339a;
        return g2;
    }

    public void b() {
        this.f60418b = null;
        this.f60419c = null;
        this.f60420d = null;
        this.f60417a = false;
        List<n> list = this.f60422f;
        if (list != null) {
            list.clear();
        }
        List<n> list2 = this.f60423g;
        if (list2 != null) {
            list2.clear();
        }
        List<SdkLiveInfoData> list3 = this.f60424h;
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
            aVar.f60234e = list.get(i);
            aVar.j = true;
            eVar.f60328e = aVar;
            int i2 = i + 1;
            if (i2 < size) {
                d.b.i0.t.d.a.a aVar2 = new d.b.i0.t.d.a.a();
                aVar2.f60234e = list.get(i2);
                eVar.f60329f = aVar2;
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
        if (!ListUtils.isEmpty(this.f60423g)) {
            arrayList.addAll(this.f60423g);
        }
        if (!ListUtils.isEmpty(this.i)) {
            arrayList.addAll(this.i);
        }
        return arrayList;
    }

    public final void e() {
        this.f60422f = new ArrayList();
        g gVar = this.f60418b;
        if (gVar != null && gVar.a()) {
            f fVar = new f();
            fVar.f60331e = this.f60418b;
            this.f60422f.add(fVar);
        }
        if (this.f60419c != null) {
            ArrayList<n> f2 = f();
            if (!ListUtils.isEmpty(f2)) {
                this.f60422f.addAll(f2);
            }
        }
        d.b.i0.t.d.c.e.d dVar = this.f60420d;
        if (dVar != null && !ListUtils.isEmpty(dVar.f60326a)) {
            d.b.i0.t.d.c.e.c cVar = new d.b.i0.t.d.c.e.c();
            cVar.f60325e = this.f60420d;
            this.f60422f.add(cVar);
        }
        this.f60423g = new ArrayList(this.f60422f);
        a(this.f60421e);
    }

    public final ArrayList<n> f() {
        ArrayList<SdkLiveInfoData> arrayList = this.f60419c.f60320a;
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.f60340b;
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
        this.f60424h.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f60424h);
        this.i = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean h() {
        return this.f60417a;
    }
}
