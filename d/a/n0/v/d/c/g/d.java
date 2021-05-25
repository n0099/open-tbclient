package d.a.n0.v.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.n0.v.d.c.e.e;
import d.a.n0.v.d.c.e.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f61606a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f61607b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f61608c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f61609d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f61610e;

    /* renamed from: f  reason: collision with root package name */
    public String f61611f;

    /* renamed from: g  reason: collision with root package name */
    public String f61612g;

    public d(j jVar, String str, String str2) {
        this.f61610e = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f61610e = true;
        }
        this.f61611f = str;
        this.f61612g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar.f61516b);
        this.f61606a = jVar.f61515a;
        return e2;
    }

    public void b() {
        this.f61606a = false;
        List<String> list = this.f61607b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f61608c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f61609d;
        if (list3 != null) {
            list3.clear();
        }
    }

    public final ArrayList<n> c(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            e eVar = new e();
            d.a.n0.v.d.a.a aVar = new d.a.n0.v.d.a.a();
            aVar.f61409e = list.get(i2);
            aVar.j = true;
            aVar.f61410f = this.f61610e;
            aVar.f61411g = this.f61611f;
            aVar.f61412h = this.f61612g;
            int i3 = i2 + 1;
            aVar.f61413i = i3;
            eVar.f61504e = aVar;
            if (i3 < size) {
                d.a.n0.v.d.a.a aVar2 = new d.a.n0.v.d.a.a();
                aVar2.f61409e = list.get(i3);
                aVar2.f61410f = this.f61610e;
                aVar2.f61411g = this.f61611f;
                aVar2.f61412h = this.f61612g;
                aVar2.f61413i = i2 + 2;
                eVar.f61505f = aVar2;
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
        if (!ListUtils.isEmpty(this.f61609d)) {
            arrayList.addAll(this.f61609d);
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
                if (!this.f61607b.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.f61607b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        this.f61608c.addAll(arrayList);
        ArrayList<n> c2 = c(this.f61608c);
        this.f61609d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f61606a;
    }
}
