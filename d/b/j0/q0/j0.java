package d.b.j0.q0;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f59805a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.i0.e0.b> f59806b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f59807c;

    /* renamed from: d  reason: collision with root package name */
    public String f59808d;

    /* renamed from: e  reason: collision with root package name */
    public String f59809e;

    /* renamed from: f  reason: collision with root package name */
    public String f59810f;

    /* renamed from: g  reason: collision with root package name */
    public String f59811g;

    public j0(Context context, List<FrsTabInfo> list) {
        this.f59805a = list;
        this.f59807c = context;
    }

    public void a(d.b.i0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.b.i0.e0.b bVar2 : this.f59806b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f50888e == bVar.getFragmentTabStructure().f50888e) {
                return;
            }
        }
        this.f59806b.add(bVar);
    }

    public Context b() {
        return this.f59807c;
    }

    public String c() {
        return this.f59810f;
    }

    public String d() {
        return this.f59808d;
    }

    public String e() {
        return this.f59809e;
    }

    public String f() {
        return this.f59811g;
    }

    public List<FrsTabInfo> g() {
        return this.f59805a;
    }

    public List<d.b.i0.e0.b> h() {
        return this.f59806b;
    }

    public boolean i(int i) {
        if (i < 100 && !ListUtils.isEmpty(this.f59805a)) {
            for (FrsTabInfo frsTabInfo : this.f59805a) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void j(String str) {
        this.f59810f = str;
    }

    public void k(String str) {
        this.f59808d = str;
    }

    public void l(String str) {
        this.f59809e = str;
    }

    public void m(String str) {
        this.f59811g = str;
    }

    public void n() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.f59805a) {
            boolean z = false;
            Iterator<d.b.i0.e0.b> it = this.f59806b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.b.i0.e0.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().f50888e) {
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
            this.f59805a.removeAll(linkedList2);
        }
        this.f59806b.clear();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        this.f59806b.addAll(linkedList);
    }
}
