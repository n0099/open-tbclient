package d.a.j0.q0;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import d.a.i0.r.q.a2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<a2> f57511a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57512b;

    /* renamed from: c  reason: collision with root package name */
    public x0 f57513c;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f57514d;

    /* renamed from: e  reason: collision with root package name */
    public String f57515e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57516f;

    /* renamed from: d.a.j0.q0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1402b {

        /* renamed from: a  reason: collision with root package name */
        public static b f57517a = new b();
    }

    public static b e() {
        return C1402b.f57517a;
    }

    public boolean a(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        if (this.f57511a.size() > 29) {
            x0 x0Var = this.f57513c;
            if (x0Var != null) {
                x0Var.b(1);
            }
            return false;
        }
        this.f57511a.add(a2Var);
        x0 x0Var2 = this.f57513c;
        if (x0Var2 != null) {
            x0Var2.c(this.f57511a.size(), 1);
        }
        return true;
    }

    public void b() {
        Iterator<a2> it = this.f57511a.iterator();
        while (it.hasNext()) {
            a2 next = it.next();
            if (next != null) {
                next.T3(false);
            }
        }
        this.f57511a.clear();
        x0 x0Var = this.f57513c;
        if (x0Var != null) {
            x0Var.c(0, 1);
        }
    }

    public AntiData c() {
        return this.f57514d;
    }

    public String d() {
        return this.f57515e;
    }

    public List<a2> f() {
        return this.f57511a;
    }

    public boolean g() {
        return this.f57512b;
    }

    public boolean h() {
        return this.f57516f;
    }

    public void i(List<String> list) {
        if (ListUtils.isEmpty(list) || ListUtils.isEmpty(this.f57511a)) {
            return;
        }
        Iterator<a2> it = this.f57511a.iterator();
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
        x0 x0Var = this.f57513c;
        if (x0Var != null) {
            x0Var.c(this.f57511a.size(), 1);
        }
    }

    public void j(a2 a2Var) {
        this.f57511a.remove(a2Var);
        x0 x0Var = this.f57513c;
        if (x0Var != null) {
            x0Var.c(this.f57511a.size(), 1);
        }
    }

    public void k() {
        m(false, false);
        b();
    }

    public void l(AntiData antiData) {
        this.f57514d = antiData;
    }

    public void m(boolean z, boolean z2) {
        this.f57512b = z;
        x0 x0Var = this.f57513c;
        if (x0Var != null) {
            x0Var.a(z, z2, 1);
        }
    }

    public void n(String str) {
        this.f57515e = str;
    }

    public void o(x0 x0Var) {
        this.f57513c = x0Var;
    }

    public void p(boolean z) {
        this.f57516f = z;
    }

    public b() {
        this.f57512b = false;
        this.f57511a = new ArrayList<>();
    }
}
