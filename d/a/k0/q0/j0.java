package d.a.k0.q0;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f58618a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.j0.e0.b> f58619b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f58620c;

    /* renamed from: d  reason: collision with root package name */
    public String f58621d;

    /* renamed from: e  reason: collision with root package name */
    public String f58622e;

    /* renamed from: f  reason: collision with root package name */
    public String f58623f;

    /* renamed from: g  reason: collision with root package name */
    public String f58624g;

    public j0(Context context, List<FrsTabInfo> list) {
        this.f58618a = list;
        this.f58620c = context;
    }

    public void a(d.a.j0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.j0.e0.b bVar2 : this.f58619b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f49294e == bVar.getFragmentTabStructure().f49294e) {
                return;
            }
        }
        this.f58619b.add(bVar);
    }

    public Context b() {
        return this.f58620c;
    }

    public String c() {
        return this.f58623f;
    }

    public String d() {
        return this.f58621d;
    }

    public String e() {
        return this.f58622e;
    }

    public String f() {
        return this.f58624g;
    }

    public List<FrsTabInfo> g() {
        return this.f58618a;
    }

    public List<d.a.j0.e0.b> h() {
        return this.f58619b;
    }

    public boolean i(int i2) {
        if (i2 < 100 && !ListUtils.isEmpty(this.f58618a)) {
            for (FrsTabInfo frsTabInfo : this.f58618a) {
                if (frsTabInfo.tab_id.intValue() == i2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void j(String str) {
        this.f58623f = str;
    }

    public void k(String str) {
        this.f58621d = str;
    }

    public void l(String str) {
        this.f58622e = str;
    }

    public void m(String str) {
        this.f58624g = str;
    }

    public void n() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.f58618a) {
            boolean z = false;
            Iterator<d.a.j0.e0.b> it = this.f58619b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.a.j0.e0.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().f49294e) {
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
            this.f58618a.removeAll(linkedList2);
        }
        this.f58619b.clear();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        this.f58619b.addAll(linkedList);
    }
}
