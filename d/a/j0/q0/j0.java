package d.a.j0.q0;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f57876a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.i0.e0.b> f57877b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f57878c;

    /* renamed from: d  reason: collision with root package name */
    public String f57879d;

    /* renamed from: e  reason: collision with root package name */
    public String f57880e;

    /* renamed from: f  reason: collision with root package name */
    public String f57881f;

    /* renamed from: g  reason: collision with root package name */
    public String f57882g;

    public j0(Context context, List<FrsTabInfo> list) {
        this.f57876a = list;
        this.f57878c = context;
    }

    public void a(d.a.i0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.i0.e0.b bVar2 : this.f57877b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f48466e == bVar.getFragmentTabStructure().f48466e) {
                return;
            }
        }
        this.f57877b.add(bVar);
    }

    public Context b() {
        return this.f57878c;
    }

    public String c() {
        return this.f57881f;
    }

    public String d() {
        return this.f57879d;
    }

    public String e() {
        return this.f57880e;
    }

    public String f() {
        return this.f57882g;
    }

    public List<FrsTabInfo> g() {
        return this.f57876a;
    }

    public List<d.a.i0.e0.b> h() {
        return this.f57877b;
    }

    public boolean i(int i2) {
        if (i2 < 100 && !ListUtils.isEmpty(this.f57876a)) {
            for (FrsTabInfo frsTabInfo : this.f57876a) {
                if (frsTabInfo.tab_id.intValue() == i2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void j(String str) {
        this.f57881f = str;
    }

    public void k(String str) {
        this.f57879d = str;
    }

    public void l(String str) {
        this.f57880e = str;
    }

    public void m(String str) {
        this.f57882g = str;
    }

    public void n() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.f57876a) {
            boolean z = false;
            Iterator<d.a.i0.e0.b> it = this.f57877b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.a.i0.e0.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().f48466e) {
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
            this.f57876a.removeAll(linkedList2);
        }
        this.f57877b.clear();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        this.f57877b.addAll(linkedList);
    }
}
