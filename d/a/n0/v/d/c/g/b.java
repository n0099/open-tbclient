package d.a.n0.v.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.a.c.j.e.n;
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
    public g f61591b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.v.d.c.e.a f61592c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.v.d.c.e.d f61593d;

    /* renamed from: e  reason: collision with root package name */
    public j f61594e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f61595f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f61596g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61590a = false;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f61597h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<n> f61598i = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.f61591b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f61592c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f61593d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f61594e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        e();
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean g2 = g(jVar);
        this.f61590a = jVar.f61515a;
        return g2;
    }

    public void b() {
        this.f61591b = null;
        this.f61592c = null;
        this.f61593d = null;
        this.f61590a = false;
        List<n> list = this.f61595f;
        if (list != null) {
            list.clear();
        }
        List<n> list2 = this.f61596g;
        if (list2 != null) {
            list2.clear();
        }
        List<SdkLiveInfoData> list3 = this.f61597h;
        if (list3 != null) {
            list3.clear();
        }
        List<n> list4 = this.f61598i;
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
            aVar.f61409e = list.get(i2);
            aVar.j = true;
            eVar.f61504e = aVar;
            int i3 = i2 + 1;
            if (i3 < size) {
                d.a.n0.v.d.a.a aVar2 = new d.a.n0.v.d.a.a();
                aVar2.f61409e = list.get(i3);
                eVar.f61505f = aVar2;
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
        if (!ListUtils.isEmpty(this.f61596g)) {
            arrayList.addAll(this.f61596g);
        }
        if (!ListUtils.isEmpty(this.f61598i)) {
            arrayList.addAll(this.f61598i);
        }
        return arrayList;
    }

    public final void e() {
        this.f61595f = new ArrayList();
        g gVar = this.f61591b;
        if (gVar != null && gVar.a()) {
            f fVar = new f();
            fVar.f61507e = this.f61591b;
            this.f61595f.add(fVar);
        }
        if (this.f61592c != null) {
            ArrayList<n> f2 = f();
            if (!ListUtils.isEmpty(f2)) {
                this.f61595f.addAll(f2);
            }
        }
        d.a.n0.v.d.c.e.d dVar = this.f61593d;
        if (dVar != null && !ListUtils.isEmpty(dVar.f61501a)) {
            d.a.n0.v.d.c.e.c cVar = new d.a.n0.v.d.c.e.c();
            cVar.f61500e = this.f61593d;
            this.f61595f.add(cVar);
        }
        this.f61596g = new ArrayList(this.f61595f);
        a(this.f61594e);
    }

    public final ArrayList<n> f() {
        ArrayList<SdkLiveInfoData> arrayList = this.f61592c.f61495a;
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.f61516b;
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
        this.f61597h.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f61597h);
        this.f61598i = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean h() {
        return this.f61590a;
    }
}
