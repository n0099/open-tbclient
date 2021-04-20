package d.b.i0.t.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.b.c.j.e.n;
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
    public g f61983b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.t.d.c.e.a f61984c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.t.d.c.e.d f61985d;

    /* renamed from: e  reason: collision with root package name */
    public j f61986e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f61987f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f61988g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61982a = false;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f61989h = new ArrayList();
    public List<n> i = new ArrayList();

    public c(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.f61983b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f61984c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f61985d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f61986e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        e();
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean g2 = g(jVar);
        this.f61982a = jVar.f61904a;
        return g2;
    }

    public void b() {
        this.f61983b = null;
        this.f61984c = null;
        this.f61985d = null;
        this.f61982a = false;
        List<n> list = this.f61987f;
        if (list != null) {
            list.clear();
        }
        List<n> list2 = this.f61988g;
        if (list2 != null) {
            list2.clear();
        }
        List<SdkLiveInfoData> list3 = this.f61989h;
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
            aVar.f61799e = list.get(i);
            aVar.j = true;
            eVar.f61893e = aVar;
            int i2 = i + 1;
            if (i2 < size) {
                d.b.i0.t.d.a.a aVar2 = new d.b.i0.t.d.a.a();
                aVar2.f61799e = list.get(i2);
                eVar.f61894f = aVar2;
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
        if (!ListUtils.isEmpty(this.f61988g)) {
            arrayList.addAll(this.f61988g);
        }
        if (!ListUtils.isEmpty(this.i)) {
            arrayList.addAll(this.i);
        }
        return arrayList;
    }

    public final void e() {
        this.f61987f = new ArrayList();
        g gVar = this.f61983b;
        if (gVar != null && gVar.a()) {
            f fVar = new f();
            fVar.f61896e = this.f61983b;
            this.f61987f.add(fVar);
        }
        if (this.f61984c != null) {
            ArrayList<n> f2 = f();
            if (!ListUtils.isEmpty(f2)) {
                this.f61987f.addAll(f2);
            }
        }
        d.b.i0.t.d.c.e.d dVar = this.f61985d;
        if (dVar != null && !ListUtils.isEmpty(dVar.f61891a)) {
            d.b.i0.t.d.c.e.c cVar = new d.b.i0.t.d.c.e.c();
            cVar.f61890e = this.f61985d;
            this.f61987f.add(cVar);
        }
        this.f61988g = new ArrayList(this.f61987f);
        a(this.f61986e);
    }

    public final ArrayList<n> f() {
        ArrayList<SdkLiveInfoData> arrayList = this.f61984c.f61885a;
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.f61905b;
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
        this.f61989h.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f61989h);
        this.i = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean h() {
        return this.f61982a;
    }
}
