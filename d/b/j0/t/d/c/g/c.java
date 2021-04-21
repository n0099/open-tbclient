package d.b.j0.t.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.b.c.j.e.n;
import d.b.j0.t.d.c.e.e;
import d.b.j0.t.d.c.e.f;
import d.b.j0.t.d.c.e.g;
import d.b.j0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public g f62404b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.t.d.c.e.a f62405c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.t.d.c.e.d f62406d;

    /* renamed from: e  reason: collision with root package name */
    public j f62407e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f62408f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f62409g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f62403a = false;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f62410h = new ArrayList();
    public List<n> i = new ArrayList();

    public c(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.f62404b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f62405c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f62406d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f62407e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        e();
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean g2 = g(jVar);
        this.f62403a = jVar.f62325a;
        return g2;
    }

    public void b() {
        this.f62404b = null;
        this.f62405c = null;
        this.f62406d = null;
        this.f62403a = false;
        List<n> list = this.f62408f;
        if (list != null) {
            list.clear();
        }
        List<n> list2 = this.f62409g;
        if (list2 != null) {
            list2.clear();
        }
        List<SdkLiveInfoData> list3 = this.f62410h;
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
            d.b.j0.t.d.a.a aVar = new d.b.j0.t.d.a.a();
            aVar.f62220e = list.get(i);
            aVar.j = true;
            eVar.f62314e = aVar;
            int i2 = i + 1;
            if (i2 < size) {
                d.b.j0.t.d.a.a aVar2 = new d.b.j0.t.d.a.a();
                aVar2.f62220e = list.get(i2);
                eVar.f62315f = aVar2;
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
        if (!ListUtils.isEmpty(this.f62409g)) {
            arrayList.addAll(this.f62409g);
        }
        if (!ListUtils.isEmpty(this.i)) {
            arrayList.addAll(this.i);
        }
        return arrayList;
    }

    public final void e() {
        this.f62408f = new ArrayList();
        g gVar = this.f62404b;
        if (gVar != null && gVar.a()) {
            f fVar = new f();
            fVar.f62317e = this.f62404b;
            this.f62408f.add(fVar);
        }
        if (this.f62405c != null) {
            ArrayList<n> f2 = f();
            if (!ListUtils.isEmpty(f2)) {
                this.f62408f.addAll(f2);
            }
        }
        d.b.j0.t.d.c.e.d dVar = this.f62406d;
        if (dVar != null && !ListUtils.isEmpty(dVar.f62312a)) {
            d.b.j0.t.d.c.e.c cVar = new d.b.j0.t.d.c.e.c();
            cVar.f62311e = this.f62406d;
            this.f62408f.add(cVar);
        }
        this.f62409g = new ArrayList(this.f62408f);
        a(this.f62407e);
    }

    public final ArrayList<n> f() {
        ArrayList<SdkLiveInfoData> arrayList = this.f62405c.f62306a;
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.f62326b;
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || d.b.j0.t.d.c.c.b(next))) {
                arrayList2.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return false;
        }
        this.f62410h.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f62410h);
        this.i = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean h() {
        return this.f62403a;
    }
}
