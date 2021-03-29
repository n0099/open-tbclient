package d.b.i0.t.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import d.b.i0.t.d.c.e.e;
import d.b.i0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f60426a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f60427b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f60428c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f60429d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f60430e;

    /* renamed from: f  reason: collision with root package name */
    public String f60431f;

    /* renamed from: g  reason: collision with root package name */
    public String f60432g;

    public d(j jVar, String str, String str2) {
        this.f60430e = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f60430e = true;
        }
        this.f60431f = str;
        this.f60432g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar.f60341b);
        this.f60426a = jVar.f60340a;
        return e2;
    }

    public void b() {
        this.f60426a = false;
        List<String> list = this.f60427b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f60428c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f60429d;
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
            aVar.f60236f = this.f60430e;
            aVar.f60237g = this.f60431f;
            aVar.f60238h = this.f60432g;
            int i2 = i + 1;
            aVar.i = i2;
            eVar.f60329e = aVar;
            if (i2 < size) {
                d.b.i0.t.d.a.a aVar2 = new d.b.i0.t.d.a.a();
                aVar2.f60235e = list.get(i2);
                aVar2.f60236f = this.f60430e;
                aVar2.f60237g = this.f60431f;
                aVar2.f60238h = this.f60432g;
                aVar2.i = i + 2;
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
        if (!ListUtils.isEmpty(this.f60429d)) {
            arrayList.addAll(this.f60429d);
        }
        return arrayList;
    }

    public final boolean e(List<SdkLiveInfoData> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.f60427b.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.f60427b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        this.f60428c.addAll(arrayList);
        ArrayList<n> c2 = c(this.f60428c);
        this.f60429d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f60426a;
    }
}
