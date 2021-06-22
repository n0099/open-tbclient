package d.a.o0.r0;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f62575a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.n0.e0.b> f62576b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f62577c;

    /* renamed from: d  reason: collision with root package name */
    public String f62578d;

    /* renamed from: e  reason: collision with root package name */
    public String f62579e;

    /* renamed from: f  reason: collision with root package name */
    public String f62580f;

    /* renamed from: g  reason: collision with root package name */
    public String f62581g;

    public j0(Context context, List<FrsTabInfo> list) {
        this.f62575a = list;
        this.f62577c = context;
    }

    public void a(d.a.n0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.n0.e0.b bVar2 : this.f62576b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f53119e == bVar.getFragmentTabStructure().f53119e) {
                return;
            }
        }
        this.f62576b.add(bVar);
    }

    public Context b() {
        return this.f62577c;
    }

    public String c() {
        return this.f62580f;
    }

    public String d() {
        return this.f62578d;
    }

    public String e() {
        return this.f62579e;
    }

    public String f() {
        return this.f62581g;
    }

    public List<FrsTabInfo> g() {
        return this.f62575a;
    }

    public List<d.a.n0.e0.b> h() {
        return this.f62576b;
    }

    public boolean i(int i2) {
        if (i2 < 100 && !ListUtils.isEmpty(this.f62575a)) {
            for (FrsTabInfo frsTabInfo : this.f62575a) {
                if (frsTabInfo.tab_id.intValue() == i2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void j(String str) {
        this.f62580f = str;
    }

    public void k(String str) {
        this.f62578d = str;
    }

    public void l(String str) {
        this.f62579e = str;
    }

    public void m(String str) {
        this.f62581g = str;
    }

    public void n() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.f62575a) {
            boolean z = false;
            Iterator<d.a.n0.e0.b> it = this.f62576b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.a.n0.e0.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().f53119e) {
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
            this.f62575a.removeAll(linkedList2);
        }
        this.f62576b.clear();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        this.f62576b.addAll(linkedList);
    }
}
