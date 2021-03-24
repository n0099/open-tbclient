package d.b.i0.p0;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f57684a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.h0.e0.b> f57685b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f57686c;

    /* renamed from: d  reason: collision with root package name */
    public String f57687d;

    /* renamed from: e  reason: collision with root package name */
    public String f57688e;

    /* renamed from: f  reason: collision with root package name */
    public String f57689f;

    /* renamed from: g  reason: collision with root package name */
    public String f57690g;

    public j0(Context context, List<FrsTabInfo> list) {
        this.f57684a = list;
        this.f57686c = context;
    }

    public void a(d.b.h0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.b.h0.e0.b bVar2 : this.f57685b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f50158e == bVar.getFragmentTabStructure().f50158e) {
                return;
            }
        }
        this.f57685b.add(bVar);
    }

    public Context b() {
        return this.f57686c;
    }

    public String c() {
        return this.f57689f;
    }

    public String d() {
        return this.f57687d;
    }

    public String e() {
        return this.f57688e;
    }

    public String f() {
        return this.f57690g;
    }

    public List<FrsTabInfo> g() {
        return this.f57684a;
    }

    public List<d.b.h0.e0.b> h() {
        return this.f57685b;
    }

    public boolean i(int i) {
        if (i < 100 && !ListUtils.isEmpty(this.f57684a)) {
            for (FrsTabInfo frsTabInfo : this.f57684a) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void j(String str) {
        this.f57689f = str;
    }

    public void k(String str) {
        this.f57687d = str;
    }

    public void l(String str) {
        this.f57688e = str;
    }

    public void m(String str) {
        this.f57690g = str;
    }

    public void n() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.f57684a) {
            boolean z = false;
            Iterator<d.b.h0.e0.b> it = this.f57685b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.b.h0.e0.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().f50158e) {
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
            this.f57684a.removeAll(linkedList2);
        }
        this.f57685b.clear();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        this.f57685b.addAll(linkedList);
    }
}
