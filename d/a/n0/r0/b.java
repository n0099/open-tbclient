package d.a.n0.r0;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import d.a.m0.r.q.a2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<a2> f58394a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58395b;

    /* renamed from: c  reason: collision with root package name */
    public x0 f58396c;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f58397d;

    /* renamed from: e  reason: collision with root package name */
    public String f58398e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58399f;

    /* renamed from: d.a.n0.r0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1489b {

        /* renamed from: a  reason: collision with root package name */
        public static b f58400a = new b();
    }

    public static b e() {
        return C1489b.f58400a;
    }

    public boolean a(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        if (this.f58394a.size() > 29) {
            x0 x0Var = this.f58396c;
            if (x0Var != null) {
                x0Var.b(1);
            }
            return false;
        }
        this.f58394a.add(a2Var);
        x0 x0Var2 = this.f58396c;
        if (x0Var2 != null) {
            x0Var2.c(this.f58394a.size(), 1);
        }
        return true;
    }

    public void b() {
        Iterator<a2> it = this.f58394a.iterator();
        while (it.hasNext()) {
            a2 next = it.next();
            if (next != null) {
                next.W3(false);
            }
        }
        this.f58394a.clear();
        x0 x0Var = this.f58396c;
        if (x0Var != null) {
            x0Var.c(0, 1);
        }
    }

    public AntiData c() {
        return this.f58397d;
    }

    public String d() {
        return this.f58398e;
    }

    public List<a2> f() {
        return this.f58394a;
    }

    public boolean g() {
        return this.f58395b;
    }

    public boolean h() {
        return this.f58399f;
    }

    public void i(List<String> list) {
        if (ListUtils.isEmpty(list) || ListUtils.isEmpty(this.f58394a)) {
            return;
        }
        Iterator<a2> it = this.f58394a.iterator();
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
        x0 x0Var = this.f58396c;
        if (x0Var != null) {
            x0Var.c(this.f58394a.size(), 1);
        }
    }

    public void j(a2 a2Var) {
        this.f58394a.remove(a2Var);
        x0 x0Var = this.f58396c;
        if (x0Var != null) {
            x0Var.c(this.f58394a.size(), 1);
        }
    }

    public void k() {
        m(false, false);
        b();
    }

    public void l(AntiData antiData) {
        this.f58397d = antiData;
    }

    public void m(boolean z, boolean z2) {
        this.f58395b = z;
        x0 x0Var = this.f58396c;
        if (x0Var != null) {
            x0Var.a(z, z2, 1);
        }
    }

    public void n(String str) {
        this.f58398e = str;
    }

    public void o(x0 x0Var) {
        this.f58396c = x0Var;
    }

    public void p(boolean z) {
        this.f58399f = z;
    }

    public b() {
        this.f58395b = false;
        this.f58394a = new ArrayList<>();
    }
}
