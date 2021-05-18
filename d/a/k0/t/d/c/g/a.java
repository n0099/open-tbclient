package d.a.k0.t.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.a.c.j.e.n;
import d.a.k0.t.d.c.e.e;
import d.a.k0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f61298a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f61299b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f61300c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f61301d = new ArrayList();

    public a(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        a(alaTabLiveResponsedMessage.tabAllLiveInfo);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar);
        this.f61298a = jVar.f61227a;
        return e2;
    }

    public void b() {
        this.f61298a = false;
        List<String> list = this.f61299b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f61300c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f61301d;
        if (list3 != null) {
            list3.clear();
        }
    }

    public final ArrayList<n> c(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            e eVar = new e();
            d.a.k0.t.d.a.a aVar = new d.a.k0.t.d.a.a();
            aVar.f61121e = list.get(i2);
            aVar.j = true;
            eVar.f61216e = aVar;
            int i3 = i2 + 1;
            if (i3 < size) {
                d.a.k0.t.d.a.a aVar2 = new d.a.k0.t.d.a.a();
                aVar2.f61121e = list.get(i3);
                eVar.f61217f = aVar2;
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
        if (!ListUtils.isEmpty(this.f61301d)) {
            arrayList.addAll(this.f61301d);
        }
        return arrayList;
    }

    public final boolean e(j jVar) {
        if (jVar == null) {
            return false;
        }
        ArrayList<SdkLiveInfoData> arrayList = jVar.f61228b;
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && d.a.k0.t.d.c.c.c(next)) {
                String str = next.liveId;
                if (!this.f61299b.contains(str)) {
                    arrayList2.add(next);
                    this.f61299b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return false;
        }
        this.f61300c.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f61300c);
        this.f61301d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f61298a;
    }
}
