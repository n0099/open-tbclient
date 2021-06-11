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
    public final ArrayList<a2> f62085a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f62086b;

    /* renamed from: c  reason: collision with root package name */
    public x0 f62087c;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f62088d;

    /* renamed from: e  reason: collision with root package name */
    public String f62089e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62090f;

    /* renamed from: d.a.n0.r0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1545b {

        /* renamed from: a  reason: collision with root package name */
        public static b f62091a = new b();
    }

    public static b e() {
        return C1545b.f62091a;
    }

    public boolean a(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        if (this.f62085a.size() > 29) {
            x0 x0Var = this.f62087c;
            if (x0Var != null) {
                x0Var.b(1);
            }
            return false;
        }
        this.f62085a.add(a2Var);
        x0 x0Var2 = this.f62087c;
        if (x0Var2 != null) {
            x0Var2.c(this.f62085a.size(), 1);
        }
        return true;
    }

    public void b() {
        Iterator<a2> it = this.f62085a.iterator();
        while (it.hasNext()) {
            a2 next = it.next();
            if (next != null) {
                next.X3(false);
            }
        }
        this.f62085a.clear();
        x0 x0Var = this.f62087c;
        if (x0Var != null) {
            x0Var.c(0, 1);
        }
    }

    public AntiData c() {
        return this.f62088d;
    }

    public String d() {
        return this.f62089e;
    }

    public List<a2> f() {
        return this.f62085a;
    }

    public boolean g() {
        return this.f62086b;
    }

    public boolean h() {
        return this.f62090f;
    }

    public void i(List<String> list) {
        if (ListUtils.isEmpty(list) || ListUtils.isEmpty(this.f62085a)) {
            return;
        }
        Iterator<a2> it = this.f62085a.iterator();
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
        x0 x0Var = this.f62087c;
        if (x0Var != null) {
            x0Var.c(this.f62085a.size(), 1);
        }
    }

    public void j(a2 a2Var) {
        this.f62085a.remove(a2Var);
        x0 x0Var = this.f62087c;
        if (x0Var != null) {
            x0Var.c(this.f62085a.size(), 1);
        }
    }

    public void k() {
        m(false, false);
        b();
    }

    public void l(AntiData antiData) {
        this.f62088d = antiData;
    }

    public void m(boolean z, boolean z2) {
        this.f62086b = z;
        x0 x0Var = this.f62087c;
        if (x0Var != null) {
            x0Var.a(z, z2, 1);
        }
    }

    public void n(String str) {
        this.f62089e = str;
    }

    public void o(x0 x0Var) {
        this.f62087c = x0Var;
    }

    public void p(boolean z) {
        this.f62090f = z;
    }

    public b() {
        this.f62086b = false;
        this.f62085a = new ArrayList<>();
    }
}
