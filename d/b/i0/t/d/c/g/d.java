package d.b.i0.t.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import d.b.i0.t.d.c.e.e;
import d.b.i0.t.d.c.e.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f61990a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f61991b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f61992c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f61993d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f61994e;

    /* renamed from: f  reason: collision with root package name */
    public String f61995f;

    /* renamed from: g  reason: collision with root package name */
    public String f61996g;

    public d(j jVar, String str, String str2) {
        this.f61994e = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f61994e = true;
        }
        this.f61995f = str;
        this.f61996g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar.f61905b);
        this.f61990a = jVar.f61904a;
        return e2;
    }

    public void b() {
        this.f61990a = false;
        List<String> list = this.f61991b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f61992c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f61993d;
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
            aVar.f61800f = this.f61994e;
            aVar.f61801g = this.f61995f;
            aVar.f61802h = this.f61996g;
            int i2 = i + 1;
            aVar.i = i2;
            eVar.f61893e = aVar;
            if (i2 < size) {
                d.b.i0.t.d.a.a aVar2 = new d.b.i0.t.d.a.a();
                aVar2.f61799e = list.get(i2);
                aVar2.f61800f = this.f61994e;
                aVar2.f61801g = this.f61995f;
                aVar2.f61802h = this.f61996g;
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
        if (!ListUtils.isEmpty(this.f61993d)) {
            arrayList.addAll(this.f61993d);
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
                if (!this.f61991b.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.f61991b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        this.f61992c.addAll(arrayList);
        ArrayList<n> c2 = c(this.f61992c);
        this.f61993d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f61990a;
    }
}
