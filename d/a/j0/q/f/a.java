package d.a.j0.q.f;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.DataRes;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<e> f57465a;

    /* renamed from: b  reason: collision with root package name */
    public List<e> f57466b;

    public List<e> a() {
        if (this.f57465a == null) {
            this.f57465a = new ArrayList();
        }
        return this.f57465a;
    }

    public final boolean b(List<e> list, d.a.i0.s.f.a aVar) {
        List<d.a.i0.s.f.a> a2;
        if (list != null && aVar != null) {
            for (e eVar : list) {
                if (eVar != null && (a2 = eVar.a()) != null) {
                    for (d.a.i0.s.f.a aVar2 : a2) {
                        if (aVar2 != null && aVar2.e() == aVar.e()) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    public boolean c(DataRes dataRes) {
        boolean z;
        if (dataRes == null || dataRes.robots_list == null) {
            z = false;
        } else {
            this.f57466b = new ArrayList();
            z = false;
            for (robotsList robotslist : dataRes.robots_list) {
                if (TextUtils.isEmpty(robotslist.key)) {
                    z = true;
                } else {
                    e eVar = new e();
                    eVar.d(robotslist);
                    this.f57466b.add(eVar);
                }
            }
        }
        if (dataRes != null && dataRes.address_list != null) {
            this.f57465a = new ArrayList();
            for (listData listdata : dataRes.address_list) {
                if (TextUtils.isEmpty(listdata.key)) {
                    z = true;
                } else {
                    e eVar2 = new e();
                    eVar2.c(listdata);
                    if (eVar2.a() != null) {
                        for (d.a.i0.s.f.a aVar : eVar2.a()) {
                            if (b(this.f57466b, aVar)) {
                                aVar.r(1);
                            } else {
                                aVar.r(0);
                            }
                        }
                    }
                    this.f57465a.add(eVar2);
                }
            }
        }
        return z;
    }
}
