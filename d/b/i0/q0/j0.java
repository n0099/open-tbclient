package d.b.i0.q0;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f59384a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.h0.e0.b> f59385b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public Context f59386c;

    /* renamed from: d  reason: collision with root package name */
    public String f59387d;

    /* renamed from: e  reason: collision with root package name */
    public String f59388e;

    /* renamed from: f  reason: collision with root package name */
    public String f59389f;

    /* renamed from: g  reason: collision with root package name */
    public String f59390g;

    public j0(Context context, List<FrsTabInfo> list) {
        this.f59384a = list;
        this.f59386c = context;
    }

    public void a(d.b.h0.e0.b bVar) {
        if (bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (d.b.h0.e0.b bVar2 : this.f59385b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f50552e == bVar.getFragmentTabStructure().f50552e) {
                return;
            }
        }
        this.f59385b.add(bVar);
    }

    public Context b() {
        return this.f59386c;
    }

    public String c() {
        return this.f59389f;
    }

    public String d() {
        return this.f59387d;
    }

    public String e() {
        return this.f59388e;
    }

    public String f() {
        return this.f59390g;
    }

    public List<FrsTabInfo> g() {
        return this.f59384a;
    }

    public List<d.b.h0.e0.b> h() {
        return this.f59385b;
    }

    public boolean i(int i) {
        if (i < 100 && !ListUtils.isEmpty(this.f59384a)) {
            for (FrsTabInfo frsTabInfo : this.f59384a) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void j(String str) {
        this.f59389f = str;
    }

    public void k(String str) {
        this.f59387d = str;
    }

    public void l(String str) {
        this.f59388e = str;
    }

    public void m(String str) {
        this.f59390g = str;
    }

    public void n() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.f59384a) {
            boolean z = false;
            Iterator<d.b.h0.e0.b> it = this.f59385b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.b.h0.e0.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().f50552e) {
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
            this.f59384a.removeAll(linkedList2);
        }
        this.f59385b.clear();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        this.f59385b.addAll(linkedList);
    }
}
