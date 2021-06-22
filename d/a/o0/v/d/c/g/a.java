package d.a.o0.v.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import d.a.c.k.e.n;
import d.a.o0.v.d.c.e.e;
import d.a.o0.v.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65424a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f65425b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f65426c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f65427d = new ArrayList();

    public a(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        a(alaTabLiveResponsedMessage.tabAllLiveInfo);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar);
        this.f65424a = jVar.f65353a;
        return e2;
    }

    public void b() {
        this.f65424a = false;
        List<String> list = this.f65425b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f65426c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f65427d;
        if (list3 != null) {
            list3.clear();
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
        if (!ListUtils.isEmpty(this.f65427d)) {
            arrayList.addAll(this.f65427d);
        }
        return arrayList;
    }

    public final boolean e(j jVar) {
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
            if (next != null && d.a.o0.v.d.c.c.c(next)) {
                String str = next.liveId;
                if (!this.f65425b.contains(str)) {
                    arrayList2.add(next);
                    this.f65425b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return false;
        }
        this.f65426c.addAll(arrayList2);
        ArrayList<n> c2 = c(this.f65426c);
        this.f65427d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f65424a;
    }
}
