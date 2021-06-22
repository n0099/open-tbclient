package d.a.o0.v.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.a.c.k.e.n;
import d.a.o0.v.d.c.e.e;
import d.a.o0.v.d.c.e.f;
import d.a.o0.v.d.c.e.g;
import d.a.o0.v.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public g f65429b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.v.d.c.e.a f65430c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.v.d.c.e.d f65431d;

    /* renamed from: e  reason: collision with root package name */
    public j f65432e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f65433f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f65434g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f65428a = false;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f65435h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<n> f65436i = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.f65429b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f65430c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f65431d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f65432e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        e();
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean g2 = g(jVar);
        this.f65428a = jVar.f65353a;
        return g2;
    }

    public void b() {
        this.f65429b = null;
        this.f65430c = null;
        this.f65431d = null;
        this.f65428a = false;
        List<n> list = this.f65433f;
        if (list != null) {
            list.clear();
        }
        List<n> list2 = this.f65434g;
        if (list2 != null) {
            list2.clear();
        }
        List<SdkLiveInfoData> list3 = this.f65435h;
        if (list3 != null) {
            list3.clear();
        }
        List<n> list4 = this.f65436i;
        if (list4 != null) {
            list4.clear();
        }
    }

    public final ArrayList<n> c(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            e eVar = new e();
            d.a.o0.v.d.a.a aVar = new d.a.o0.v.d.a.a();
            aVar.f65247e = list.get(i2);
            aVar.j = true;
            eVar.f65342e = aVar;
            int i3 = i2 + 1;
            if (i3 < size) {
                d.a.o0.v.d.a.a aVar2 = new d.a.o0.v.d.a.a();
                aVar2.f65247e = list.get(i3);
                eVar.f65343f = aVar2;
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
        if (!ListUtils.isEmpty(this.f65434g)) {
            arrayList.addAll(this.f65434g);
        }
        if (!ListUtils.isEmpty(this.f65436i)) {
            arrayList.addAll(this.f65436i);
        }
        return arrayList;
    }

    public final void e() {
        this.f65433f = new ArrayList();
        g gVar = this.f65429b;
        if (gVar != null && gVar.a()) {
            f fVar = new f();
            fVar.f65345e = this.f65429b;
            this.f65433f.add(fVar);
        }
        if (this.f65430c != null) {
            ArrayList<n> f2 = f();
            if (!ListUtils.isEmpty(f2)) {
                this.f65433f.addAll(f2);
            }
        }
        d.a.o0.v.d.c.e.d dVar = this.f65431d;
        if (dVar != null && !ListUtils.isEmpty(dVar.f65339a)) {
            d.a.o0.v.d.c.e.c cVar = new d.a.o0.v.d.c.e.c();
            cVar.f65338e = this.f65431d;
            this.f65433f.add(cVar);
        }
        this.f65434g = new ArrayList(this.f65433f);
        a(this.f65432e);
    }

    public final ArrayList<n> f() {
        ArrayList<SdkLiveInfoData> arrayList = this.f65430c.f65333a;
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.f65354b;
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || d.a.o0.v.d.c.c.c(next))) {
                arrayList2.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return false;
        }
        this.f65435h.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f65435h);
        this.f65436i = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean h() {
        return this.f65428a;
    }
}
