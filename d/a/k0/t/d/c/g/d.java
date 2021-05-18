package d.a.k0.t.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.k0.t.d.c.e.e;
import d.a.k0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f61318a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f61319b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f61320c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f61321d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f61322e;

    /* renamed from: f  reason: collision with root package name */
    public String f61323f;

    /* renamed from: g  reason: collision with root package name */
    public String f61324g;

    public d(j jVar, String str, String str2) {
        this.f61322e = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f61322e = true;
        }
        this.f61323f = str;
        this.f61324g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar.f61228b);
        this.f61318a = jVar.f61227a;
        return e2;
    }

    public void b() {
        this.f61318a = false;
        List<String> list = this.f61319b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f61320c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f61321d;
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
            aVar.f61122f = this.f61322e;
            aVar.f61123g = this.f61323f;
            aVar.f61124h = this.f61324g;
            int i3 = i2 + 1;
            aVar.f61125i = i3;
            eVar.f61216e = aVar;
            if (i3 < size) {
                d.a.k0.t.d.a.a aVar2 = new d.a.k0.t.d.a.a();
                aVar2.f61121e = list.get(i3);
                aVar2.f61122f = this.f61322e;
                aVar2.f61123g = this.f61323f;
                aVar2.f61124h = this.f61324g;
                aVar2.f61125i = i2 + 2;
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
        if (!ListUtils.isEmpty(this.f61321d)) {
            arrayList.addAll(this.f61321d);
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
                if (!this.f61319b.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.f61319b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        this.f61320c.addAll(arrayList);
        ArrayList<n> c2 = c(this.f61320c);
        this.f61321d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f61318a;
    }
}
