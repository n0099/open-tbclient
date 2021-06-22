package d.a.o0.r0;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import d.a.n0.r.q.a2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<a2> f62210a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f62211b;

    /* renamed from: c  reason: collision with root package name */
    public x0 f62212c;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f62213d;

    /* renamed from: e  reason: collision with root package name */
    public String f62214e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62215f;

    /* renamed from: d.a.o0.r0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1549b {

        /* renamed from: a  reason: collision with root package name */
        public static b f62216a = new b();
    }

    public static b e() {
        return C1549b.f62216a;
    }

    public boolean a(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        if (this.f62210a.size() > 29) {
            x0 x0Var = this.f62212c;
            if (x0Var != null) {
                x0Var.b(1);
            }
            return false;
        }
        this.f62210a.add(a2Var);
        x0 x0Var2 = this.f62212c;
        if (x0Var2 != null) {
            x0Var2.c(this.f62210a.size(), 1);
        }
        return true;
    }

    public void b() {
        Iterator<a2> it = this.f62210a.iterator();
        while (it.hasNext()) {
            a2 next = it.next();
            if (next != null) {
                next.X3(false);
            }
        }
        this.f62210a.clear();
        x0 x0Var = this.f62212c;
        if (x0Var != null) {
            x0Var.c(0, 1);
        }
    }

    public AntiData c() {
        return this.f62213d;
    }

    public String d() {
        return this.f62214e;
    }

    public List<a2> f() {
        return this.f62210a;
    }

    public boolean g() {
        return this.f62211b;
    }

    public boolean h() {
        return this.f62215f;
    }

    public void i(List<String> list) {
        if (ListUtils.isEmpty(list) || ListUtils.isEmpty(this.f62210a)) {
            return;
        }
        Iterator<a2> it = this.f62210a.iterator();
        while (it.hasNext()) {
            a2 next = it.next();
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                } else if (StringHelper.equals(list.get(i2), next.o0())) {
                    it.remove();
                    break;
                } else {
                    i2++;
                }
            }
        }
        x0 x0Var = this.f62212c;
        if (x0Var != null) {
            x0Var.c(this.f62210a.size(), 1);
        }
    }

    public void j(a2 a2Var) {
        this.f62210a.remove(a2Var);
        x0 x0Var = this.f62212c;
        if (x0Var != null) {
            x0Var.c(this.f62210a.size(), 1);
        }
    }

    public void k() {
        m(false, false);
        b();
    }

    public void l(AntiData antiData) {
        this.f62213d = antiData;
    }

    public void m(boolean z, boolean z2) {
        this.f62211b = z;
        x0 x0Var = this.f62212c;
        if (x0Var != null) {
            x0Var.a(z, z2, 1);
        }
    }

    public void n(String str) {
        this.f62214e = str;
    }

    public void o(x0 x0Var) {
        this.f62212c = x0Var;
    }

    public void p(boolean z) {
        this.f62215f = z;
    }

    public b() {
        this.f62211b = false;
        this.f62210a = new ArrayList<>();
    }
}
