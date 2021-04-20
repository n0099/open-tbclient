package d.b.i0.t.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.b.c.j.e.n;
import d.b.i0.t.d.c.e.e;
import d.b.i0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f61971a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f61972b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f61973c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f61974d = new ArrayList();

    public a(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        a(alaTabLiveResponsedMessage.tabAllLiveInfo);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar);
        this.f61971a = jVar.f61904a;
        return e2;
    }

    public void b() {
        this.f61971a = false;
        List<String> list = this.f61972b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f61973c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f61974d;
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
        if (!ListUtils.isEmpty(this.f61974d)) {
            arrayList.addAll(this.f61974d);
        }
        return arrayList;
    }

    public final boolean e(j jVar) {
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
            if (next != null && d.b.i0.t.d.c.c.b(next)) {
                String str = next.liveId;
                if (!this.f61972b.contains(str)) {
                    arrayList2.add(next);
                    this.f61972b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return false;
        }
        this.f61973c.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f61973c);
        this.f61974d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f61971a;
    }
}
