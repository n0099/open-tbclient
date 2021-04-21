package d.b.j0.t.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.b.c.j.e.n;
import d.b.j0.t.d.c.e.e;
import d.b.j0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f62392a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f62393b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f62394c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f62395d = new ArrayList();

    public a(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        a(alaTabLiveResponsedMessage.tabAllLiveInfo);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar);
        this.f62392a = jVar.f62325a;
        return e2;
    }

    public void b() {
        this.f62392a = false;
        List<String> list = this.f62393b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f62394c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f62395d;
        if (list3 != null) {
            list3.clear();
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
        if (!ListUtils.isEmpty(this.f62395d)) {
            arrayList.addAll(this.f62395d);
        }
        return arrayList;
    }

    public final boolean e(j jVar) {
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
            if (next != null && d.b.j0.t.d.c.c.b(next)) {
                String str = next.liveId;
                if (!this.f62393b.contains(str)) {
                    arrayList2.add(next);
                    this.f62393b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return false;
        }
        this.f62394c.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f62394c);
        this.f62395d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f62392a;
    }
}
