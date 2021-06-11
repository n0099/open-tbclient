package d.a.n0.r0;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f62450a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.m0.e0.b> f62451b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f62452c;

    /* renamed from: d  reason: collision with root package name */
    public String f62453d;

    /* renamed from: e  reason: collision with root package name */
    public String f62454e;

    /* renamed from: f  reason: collision with root package name */
    public String f62455f;

    /* renamed from: g  reason: collision with root package name */
    public String f62456g;

    public j0(Context context, List<FrsTabInfo> list) {
        this.f62450a = list;
        this.f62452c = context;
    }

    public void a(d.a.m0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.m0.e0.b bVar2 : this.f62451b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f53012e == bVar.getFragmentTabStructure().f53012e) {
                return;
            }
        }
        this.f62451b.add(bVar);
    }

    public Context b() {
        return this.f62452c;
    }

    public String c() {
        return this.f62455f;
    }

    public String d() {
        return this.f62453d;
    }

    public String e() {
        return this.f62454e;
    }

    public String f() {
        return this.f62456g;
    }

    public List<FrsTabInfo> g() {
        return this.f62450a;
    }

    public List<d.a.m0.e0.b> h() {
        return this.f62451b;
    }

    public boolean i(int i2) {
        if (i2 < 100 && !ListUtils.isEmpty(this.f62450a)) {
            for (FrsTabInfo frsTabInfo : this.f62450a) {
                if (frsTabInfo.tab_id.intValue() == i2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void j(String str) {
        this.f62455f = str;
    }

    public void k(String str) {
        this.f62453d = str;
    }

    public void l(String str) {
        this.f62454e = str;
    }

    public void m(String str) {
        this.f62456g = str;
    }

    public void n() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.f62450a) {
            boolean z = false;
            Iterator<d.a.m0.e0.b> it = this.f62451b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.a.m0.e0.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().f53012e) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!ListUtils.isEmpty(linkedList2)) {
            this.f62450a.removeAll(linkedList2);
        }
        this.f62451b.clear();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        this.f62451b.addAll(linkedList);
    }
}
