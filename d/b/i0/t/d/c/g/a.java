package d.b.i0.t.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.b.b.j.e.n;
import d.b.i0.t.d.c.e.e;
import d.b.i0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f60407a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f60408b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f60409c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f60410d = new ArrayList();

    public a(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        a(alaTabLiveResponsedMessage.tabAllLiveInfo);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar);
        this.f60407a = jVar.f60340a;
        return e2;
    }

    public void b() {
        this.f60407a = false;
        List<String> list = this.f60408b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f60409c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f60410d;
        if (list3 != null) {
            list3.clear();
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
        if (!ListUtils.isEmpty(this.f60410d)) {
            arrayList.addAll(this.f60410d);
        }
        return arrayList;
    }

    public final boolean e(j jVar) {
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
            if (next != null && d.b.i0.t.d.c.c.b(next)) {
                String str = next.liveId;
                if (!this.f60408b.contains(str)) {
                    arrayList2.add(next);
                    this.f60408b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return false;
        }
        this.f60409c.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f60409c);
        this.f60410d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f60407a;
    }
}
