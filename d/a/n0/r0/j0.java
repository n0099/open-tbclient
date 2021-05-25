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
    public List<FrsTabInfo> f58759a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.m0.e0.b> f58760b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f58761c;

    /* renamed from: d  reason: collision with root package name */
    public String f58762d;

    /* renamed from: e  reason: collision with root package name */
    public String f58763e;

    /* renamed from: f  reason: collision with root package name */
    public String f58764f;

    /* renamed from: g  reason: collision with root package name */
    public String f58765g;

    public j0(Context context, List<FrsTabInfo> list) {
        this.f58759a = list;
        this.f58761c = context;
    }

    public void a(d.a.m0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.a.m0.e0.b bVar2 : this.f58760b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f49338e == bVar.getFragmentTabStructure().f49338e) {
                return;
            }
        }
        this.f58760b.add(bVar);
    }

    public Context b() {
        return this.f58761c;
    }

    public String c() {
        return this.f58764f;
    }

    public String d() {
        return this.f58762d;
    }

    public String e() {
        return this.f58763e;
    }

    public String f() {
        return this.f58765g;
    }

    public List<FrsTabInfo> g() {
        return this.f58759a;
    }

    public List<d.a.m0.e0.b> h() {
        return this.f58760b;
    }

    public boolean i(int i2) {
        if (i2 < 100 && !ListUtils.isEmpty(this.f58759a)) {
            for (FrsTabInfo frsTabInfo : this.f58759a) {
                if (frsTabInfo.tab_id.intValue() == i2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void j(String str) {
        this.f58764f = str;
    }

    public void k(String str) {
        this.f58762d = str;
    }

    public void l(String str) {
        this.f58763e = str;
    }

    public void m(String str) {
        this.f58765g = str;
    }

    public void n() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.f58759a) {
            boolean z = false;
            Iterator<d.a.m0.e0.b> it = this.f58760b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.a.m0.e0.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().f49338e) {
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
            this.f58759a.removeAll(linkedList2);
        }
        this.f58760b.clear();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        this.f58760b.addAll(linkedList);
    }
}
