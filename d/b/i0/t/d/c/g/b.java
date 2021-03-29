package d.b.i0.t.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import d.b.i0.t.d.c.e.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f60411a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f60412b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f60413c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f60414d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f60415e;

    /* renamed from: f  reason: collision with root package name */
    public String f60416f;

    /* renamed from: g  reason: collision with root package name */
    public String f60417g;

    public b(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.f60415e = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f60415e = true;
        }
        this.f60416f = str;
        this.f60417g = str2;
        a(list, z);
    }

    public boolean a(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean e2 = e(list);
        this.f60411a = z;
        return e2;
    }

    public void b() {
        this.f60411a = false;
        List<String> list = this.f60412b;
        if (list != null) {
            list.clear();
        }
        List<SdkLiveInfoData> list2 = this.f60413c;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.f60414d;
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
            aVar.f60236f = this.f60415e;
            aVar.f60237g = this.f60416f;
            aVar.f60238h = this.f60417g;
            int i2 = i + 1;
            aVar.i = i2;
            eVar.f60329e = aVar;
            if (i2 < size) {
                d.b.i0.t.d.a.a aVar2 = new d.b.i0.t.d.a.a();
                aVar2.f60235e = list.get(i2);
                aVar2.f60236f = this.f60415e;
                aVar2.f60237g = this.f60416f;
                aVar2.f60238h = this.f60417g;
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
        if (!ListUtils.isEmpty(this.f60414d)) {
            arrayList.addAll(this.f60414d);
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
                if (!this.f60412b.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.f60412b.add(str);
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return false;
        }
        this.f60413c.addAll(arrayList);
        ArrayList<n> c2 = c(this.f60413c);
        this.f60414d = c2;
        return !ListUtils.isEmpty(c2);
    }

    public boolean f() {
        return this.f60411a;
    }
}
