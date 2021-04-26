package d.a.j0.t.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.j0.t.d.c.e.e;
import d.a.j0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f60587a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f60588b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f60589c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f60590d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f60591e;

    /* renamed from: f  reason: collision with root package name */
    public String f60592f;

    /* renamed from: g  reason: collision with root package name */
    public String f60593g;

    public c(j jVar, String str, String str2) {
        this.f60591e = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f60591e = true;
        }
        this.f60592f = str;
        this.f60593g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar.f60504b);
        this.f60587a = jVar.f60503a;
        return e2;
    }

    public void b() {
        this.f60587a = false;
        List<String> list = this.f60588b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f60589c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f60590d;
        if (list3 != null) {
            list3.clear();
        }
    }

    public final ArrayList<n> c(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            e eVar = new e();
            d.a.j0.t.d.a.a aVar = new d.a.j0.t.d.a.a();
            aVar.f60397e = list.get(i2);
            aVar.j = true;
            aVar.f60398f = this.f60591e;
            aVar.f60399g = this.f60592f;
            aVar.f60400h = this.f60593g;
            int i3 = i2 + 1;
            aVar.f60401i = i3;
            eVar.f60492e = aVar;
            if (i3 < size) {
                d.a.j0.t.d.a.a aVar2 = new d.a.j0.t.d.a.a();
                aVar2.f60397e = list.get(i3);
                aVar2.f60398f = this.f60591e;
                aVar2.f60399g = this.f60592f;
                aVar2.f60400h = this.f60593g;
                aVar2.f60401i = i2 + 2;
                eVar.f60493f = aVar2;
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
        if (!ListUtils.isEmpty(this.f60590d)) {
            arrayList.addAll(this.f60590d);
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
                if (!this.f60588b.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.f60588b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        this.f60589c.addAll(arrayList);
        ArrayList<n> c2 = c(this.f60589c);
        this.f60590d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f60587a;
    }
}
