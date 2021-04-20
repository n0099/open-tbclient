package d.b.i0.t.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import d.b.i0.t.d.c.e.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f61975a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f61976b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f61977c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f61978d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f61979e;

    /* renamed from: f  reason: collision with root package name */
    public String f61980f;

    /* renamed from: g  reason: collision with root package name */
    public String f61981g;

    public b(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.f61979e = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f61979e = true;
        }
        this.f61980f = str;
        this.f61981g = str2;
        a(list, z);
    }

    public boolean a(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean e2 = e(list);
        this.f61975a = z;
        return e2;
    }

    public void b() {
        this.f61975a = false;
        List<String> list = this.f61976b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f61977c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f61978d;
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
            aVar.f61800f = this.f61979e;
            aVar.f61801g = this.f61980f;
            aVar.f61802h = this.f61981g;
            int i2 = i + 1;
            aVar.i = i2;
            eVar.f61893e = aVar;
            if (i2 < size) {
                d.b.i0.t.d.a.a aVar2 = new d.b.i0.t.d.a.a();
                aVar2.f61799e = list.get(i2);
                aVar2.f61800f = this.f61979e;
                aVar2.f61801g = this.f61980f;
                aVar2.f61802h = this.f61981g;
                aVar2.i = i + 2;
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
        if (!ListUtils.isEmpty(this.f61978d)) {
            arrayList.addAll(this.f61978d);
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
                if (!this.f61976b.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.f61976b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        this.f61977c.addAll(arrayList);
        ArrayList<n> c2 = c(this.f61977c);
        this.f61978d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f61975a;
    }
}
