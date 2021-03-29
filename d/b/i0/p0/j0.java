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
    public List<FrsTabInfo> f57685a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.h0.e0.b> f57686b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f57687c;

    /* renamed from: d  reason: collision with root package name */
    public String f57688d;

    /* renamed from: e  reason: collision with root package name */
    public String f57689e;

    /* renamed from: f  reason: collision with root package name */
    public String f57690f;

    /* renamed from: g  reason: collision with root package name */
    public String f57691g;

    public j0(Context context, List<FrsTabInfo> list) {
        this.f57685a = list;
        this.f57687c = context;
    }

    public void a(d.b.h0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.b.h0.e0.b bVar2 : this.f57686b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f50159e == bVar.getFragmentTabStructure().f50159e) {
                return;
            }
        }
        this.f57686b.add(bVar);
    }

    public Context b() {
        return this.f57687c;
    }

    public String c() {
        return this.f57690f;
    }

    public String d() {
        return this.f57688d;
    }

    public String e() {
        return this.f57689e;
    }

    public String f() {
        return this.f57691g;
    }

    public List<FrsTabInfo> g() {
        return this.f57685a;
    }

    public List<d.b.h0.e0.b> h() {
        return this.f57686b;
    }

    public boolean i(int i) {
        if (i < 100 && !ListUtils.isEmpty(this.f57685a)) {
            for (FrsTabInfo frsTabInfo : this.f57685a) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void j(String str) {
        this.f57690f = str;
    }

    public void k(String str) {
        this.f57688d = str;
    }

    public void l(String str) {
        this.f57689e = str;
    }

    public void m(String str) {
        this.f57691g = str;
    }

    public void n() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.f57685a) {
            boolean z = false;
            Iterator<d.b.h0.e0.b> it = this.f57686b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.b.h0.e0.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().f50159e) {
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
            this.f57685a.removeAll(linkedList2);
        }
        this.f57686b.clear();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        this.f57686b.addAll(linkedList);
    }
}
