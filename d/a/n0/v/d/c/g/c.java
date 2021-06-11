package d.a.n0.v.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import d.a.n0.v.d.c.e.e;
import d.a.n0.v.d.c.e.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65312a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f65313b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f65314c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f65315d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f65316e;

    /* renamed from: f  reason: collision with root package name */
    public String f65317f;

    /* renamed from: g  reason: collision with root package name */
    public String f65318g;

    public c(j jVar, String str, String str2) {
        this.f65316e = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f65316e = true;
        }
        this.f65317f = str;
        this.f65318g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar.f65229b);
        this.f65312a = jVar.f65228a;
        return e2;
    }

    public void b() {
        this.f65312a = false;
        List<String> list = this.f65313b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f65314c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f65315d;
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
            aVar.f65122e = list.get(i2);
            aVar.j = true;
            aVar.f65123f = this.f65316e;
            aVar.f65124g = this.f65317f;
            aVar.f65125h = this.f65318g;
            int i3 = i2 + 1;
            aVar.f65126i = i3;
            eVar.f65217e = aVar;
            if (i3 < size) {
                d.a.n0.v.d.a.a aVar2 = new d.a.n0.v.d.a.a();
                aVar2.f65122e = list.get(i3);
                aVar2.f65123f = this.f65316e;
                aVar2.f65124g = this.f65317f;
                aVar2.f65125h = this.f65318g;
                aVar2.f65126i = i2 + 2;
                eVar.f65218f = aVar2;
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
        if (!ListUtils.isEmpty(this.f65315d)) {
            arrayList.addAll(this.f65315d);
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
                if (!this.f65313b.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.f65313b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        this.f65314c.addAll(arrayList);
        ArrayList<n> c2 = c(this.f65314c);
        this.f65315d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f65312a;
    }
}
