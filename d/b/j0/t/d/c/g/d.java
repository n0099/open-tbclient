package d.b.j0.t.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import d.b.j0.t.d.c.e.e;
import d.b.j0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f62411a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f62412b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f62413c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f62414d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f62415e;

    /* renamed from: f  reason: collision with root package name */
    public String f62416f;

    /* renamed from: g  reason: collision with root package name */
    public String f62417g;

    public d(j jVar, String str, String str2) {
        this.f62415e = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f62415e = true;
        }
        this.f62416f = str;
        this.f62417g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar.f62326b);
        this.f62411a = jVar.f62325a;
        return e2;
    }

    public void b() {
        this.f62411a = false;
        List<String> list = this.f62412b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f62413c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f62414d;
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
            aVar.f62221f = this.f62415e;
            aVar.f62222g = this.f62416f;
            aVar.f62223h = this.f62417g;
            int i2 = i + 1;
            aVar.i = i2;
            eVar.f62314e = aVar;
            if (i2 < size) {
                d.b.j0.t.d.a.a aVar2 = new d.b.j0.t.d.a.a();
                aVar2.f62220e = list.get(i2);
                aVar2.f62221f = this.f62415e;
                aVar2.f62222g = this.f62416f;
                aVar2.f62223h = this.f62417g;
                aVar2.i = i + 2;
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
        if (!ListUtils.isEmpty(this.f62414d)) {
            arrayList.addAll(this.f62414d);
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
                if (!this.f62412b.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.f62412b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        this.f62413c.addAll(arrayList);
        ArrayList<n> c2 = c(this.f62413c);
        this.f62414d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f62411a;
    }
}
