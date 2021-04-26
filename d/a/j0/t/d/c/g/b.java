package d.a.j0.t.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.a.c.j.e.n;
import d.a.j0.t.d.c.e.e;
import d.a.j0.t.d.c.e.f;
import d.a.j0.t.d.c.e.g;
import d.a.j0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public g f60579b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.t.d.c.e.a f60580c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.t.d.c.e.d f60581d;

    /* renamed from: e  reason: collision with root package name */
    public j f60582e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f60583f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f60584g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f60578a = false;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f60585h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<n> f60586i = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.f60579b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f60580c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f60581d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f60582e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        e();
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean g2 = g(jVar);
        this.f60578a = jVar.f60503a;
        return g2;
    }

    public void b() {
        this.f60579b = null;
        this.f60580c = null;
        this.f60581d = null;
        this.f60578a = false;
        List<n> list = this.f60583f;
        if (list != null) {
            list.clear();
        }
        List<n> list2 = this.f60584g;
        if (list2 != null) {
            list2.clear();
        }
        List<SdkLiveInfoData> list3 = this.f60585h;
        if (list3 != null) {
            list3.clear();
        }
        List<n> list4 = this.f60586i;
        if (list4 != null) {
            list4.clear();
        }
    }

    public final ArrayList<n> c(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            e eVar = new e();
            d.a.j0.t.d.a.a aVar = new d.a.j0.t.d.a.a();
            aVar.f60397e = list.get(i2);
            aVar.j = true;
            eVar.f60492e = aVar;
            int i3 = i2 + 1;
            if (i3 < size) {
                d.a.j0.t.d.a.a aVar2 = new d.a.j0.t.d.a.a();
                aVar2.f60397e = list.get(i3);
                eVar.f60493f = aVar2;
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
        if (!ListUtils.isEmpty(this.f60584g)) {
            arrayList.addAll(this.f60584g);
        }
        if (!ListUtils.isEmpty(this.f60586i)) {
            arrayList.addAll(this.f60586i);
        }
        return arrayList;
    }

    public final void e() {
        this.f60583f = new ArrayList();
        g gVar = this.f60579b;
        if (gVar != null && gVar.a()) {
            f fVar = new f();
            fVar.f60495e = this.f60579b;
            this.f60583f.add(fVar);
        }
        if (this.f60580c != null) {
            ArrayList<n> f2 = f();
            if (!ListUtils.isEmpty(f2)) {
                this.f60583f.addAll(f2);
            }
        }
        d.a.j0.t.d.c.e.d dVar = this.f60581d;
        if (dVar != null && !ListUtils.isEmpty(dVar.f60489a)) {
            d.a.j0.t.d.c.e.c cVar = new d.a.j0.t.d.c.e.c();
            cVar.f60488e = this.f60581d;
            this.f60583f.add(cVar);
        }
        this.f60584g = new ArrayList(this.f60583f);
        a(this.f60582e);
    }

    public final ArrayList<n> f() {
        ArrayList<SdkLiveInfoData> arrayList = this.f60580c.f60483a;
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.f60504b;
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || d.a.j0.t.d.c.c.c(next))) {
                arrayList2.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return false;
        }
        this.f60585h.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f60585h);
        this.f60586i = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean h() {
        return this.f60578a;
    }
}
