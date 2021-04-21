package d.b.j0.t.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import d.b.j0.t.d.c.e.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f62396a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f62397b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f62398c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f62399d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f62400e;

    /* renamed from: f  reason: collision with root package name */
    public String f62401f;

    /* renamed from: g  reason: collision with root package name */
    public String f62402g;

    public b(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.f62400e = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f62400e = true;
        }
        this.f62401f = str;
        this.f62402g = str2;
        a(list, z);
    }

    public boolean a(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean e2 = e(list);
        this.f62396a = z;
        return e2;
    }

    public void b() {
        this.f62396a = false;
        List<String> list = this.f62397b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f62398c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f62399d;
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
            aVar.f62221f = this.f62400e;
            aVar.f62222g = this.f62401f;
            aVar.f62223h = this.f62402g;
            int i2 = i + 1;
            aVar.i = i2;
            eVar.f62314e = aVar;
            if (i2 < size) {
                d.b.j0.t.d.a.a aVar2 = new d.b.j0.t.d.a.a();
                aVar2.f62220e = list.get(i2);
                aVar2.f62221f = this.f62400e;
                aVar2.f62222g = this.f62401f;
                aVar2.f62223h = this.f62402g;
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
        if (!ListUtils.isEmpty(this.f62399d)) {
            arrayList.addAll(this.f62399d);
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
                String str = sdkLiveInfoData.roomId;
                if (!this.f62397b.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.f62397b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        this.f62398c.addAll(arrayList);
        ArrayList<n> c2 = c(this.f62398c);
        this.f62399d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f62396a;
    }
}
