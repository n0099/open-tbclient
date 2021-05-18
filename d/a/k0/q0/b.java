package d.a.k0.q0;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import d.a.j0.r.q.a2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<a2> f58253a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58254b;

    /* renamed from: c  reason: collision with root package name */
    public x0 f58255c;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f58256d;

    /* renamed from: e  reason: collision with root package name */
    public String f58257e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58258f;

    /* renamed from: d.a.k0.q0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1476b {

        /* renamed from: a  reason: collision with root package name */
        public static b f58259a = new b();
    }

    public static b e() {
        return C1476b.f58259a;
    }

    public boolean a(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        if (this.f58253a.size() > 29) {
            x0 x0Var = this.f58255c;
            if (x0Var != null) {
                x0Var.b(1);
            }
            return false;
        }
        this.f58253a.add(a2Var);
        x0 x0Var2 = this.f58255c;
        if (x0Var2 != null) {
            x0Var2.c(this.f58253a.size(), 1);
        }
        return true;
    }

    public void b() {
        Iterator<a2> it = this.f58253a.iterator();
        while (it.hasNext()) {
            a2 next = it.next();
            if (next != null) {
                next.V3(false);
            }
        }
        this.f58253a.clear();
        x0 x0Var = this.f58255c;
        if (x0Var != null) {
            x0Var.c(0, 1);
        }
    }

    public AntiData c() {
        return this.f58256d;
    }

    public String d() {
        return this.f58257e;
    }

    public List<a2> f() {
        return this.f58253a;
    }

    public boolean g() {
        return this.f58254b;
    }

    public boolean h() {
        return this.f58258f;
    }

    public void i(List<String> list) {
        if (ListUtils.isEmpty(list) || ListUtils.isEmpty(this.f58253a)) {
            return;
        }
        Iterator<a2> it = this.f58253a.iterator();
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
        x0 x0Var = this.f58255c;
        if (x0Var != null) {
            x0Var.c(this.f58253a.size(), 1);
        }
    }

    public void j(a2 a2Var) {
        this.f58253a.remove(a2Var);
        x0 x0Var = this.f58255c;
        if (x0Var != null) {
            x0Var.c(this.f58253a.size(), 1);
        }
    }

    public void k() {
        m(false, false);
        b();
    }

    public void l(AntiData antiData) {
        this.f58256d = antiData;
    }

    public void m(boolean z, boolean z2) {
        this.f58254b = z;
        x0 x0Var = this.f58255c;
        if (x0Var != null) {
            x0Var.a(z, z2, 1);
        }
    }

    public void n(String str) {
        this.f58257e = str;
    }

    public void o(x0 x0Var) {
        this.f58255c = x0Var;
    }

    public void p(boolean z) {
        this.f58258f = z;
    }

    public b() {
        this.f58254b = false;
        this.f58253a = new ArrayList<>();
    }
}
