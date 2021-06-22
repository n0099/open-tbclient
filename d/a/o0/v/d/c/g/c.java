package d.a.o0.v.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import d.a.o0.v.d.c.e.e;
import d.a.o0.v.d.c.e.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65437a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f65438b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f65439c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f65440d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f65441e;

    /* renamed from: f  reason: collision with root package name */
    public String f65442f;

    /* renamed from: g  reason: collision with root package name */
    public String f65443g;

    public c(j jVar, String str, String str2) {
        this.f65441e = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f65441e = true;
        }
        this.f65442f = str;
        this.f65443g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean e2 = e(jVar.f65354b);
        this.f65437a = jVar.f65353a;
        return e2;
    }

    public void b() {
        this.f65437a = false;
        List<String> list = this.f65438b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f65439c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f65440d;
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
            aVar.f65248f = this.f65441e;
            aVar.f65249g = this.f65442f;
            aVar.f65250h = this.f65443g;
            int i3 = i2 + 1;
            aVar.f65251i = i3;
            eVar.f65342e = aVar;
            if (i3 < size) {
                d.a.o0.v.d.a.a aVar2 = new d.a.o0.v.d.a.a();
                aVar2.f65247e = list.get(i3);
                aVar2.f65248f = this.f65441e;
                aVar2.f65249g = this.f65442f;
                aVar2.f65250h = this.f65443g;
                aVar2.f65251i = i2 + 2;
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
        if (!ListUtils.isEmpty(this.f65440d)) {
            arrayList.addAll(this.f65440d);
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
                if (!this.f65438b.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.f65438b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        this.f65439c.addAll(arrayList);
        ArrayList<n> c2 = c(this.f65439c);
        this.f65440d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f65437a;
    }
}
