package d.b.i0.p0;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<a2> f57350a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57351b;

    /* renamed from: c  reason: collision with root package name */
    public x0 f57352c;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f57353d;

    /* renamed from: e  reason: collision with root package name */
    public String f57354e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57355f;

    /* renamed from: d.b.i0.p0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1378b {

        /* renamed from: a  reason: collision with root package name */
        public static b f57356a = new b();
    }

    public static b e() {
        return C1378b.f57356a;
    }

    public boolean a(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        if (this.f57350a.size() > 29) {
            x0 x0Var = this.f57352c;
            if (x0Var != null) {
                x0Var.a(1);
            }
            return false;
        }
        this.f57350a.add(a2Var);
        x0 x0Var2 = this.f57352c;
        if (x0Var2 != null) {
            x0Var2.c(this.f57350a.size(), 1);
        }
        return true;
    }

    public void b() {
        Iterator<a2> it = this.f57350a.iterator();
        while (it.hasNext()) {
            a2 next = it.next();
            if (next != null) {
                next.S3(false);
            }
        }
        this.f57350a.clear();
        x0 x0Var = this.f57352c;
        if (x0Var != null) {
            x0Var.c(0, 1);
        }
    }

    public AntiData c() {
        return this.f57353d;
    }

    public String d() {
        return this.f57354e;
    }

    public List<a2> f() {
        return this.f57350a;
    }

    public boolean g() {
        return this.f57351b;
    }

    public boolean h() {
        return this.f57355f;
    }

    public void i(List<String> list) {
        if (ListUtils.isEmpty(list) || ListUtils.isEmpty(this.f57350a)) {
            return;
        }
        Iterator<a2> it = this.f57350a.iterator();
        while (it.hasNext()) {
            a2 next = it.next();
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                } else if (StringHelper.equals(list.get(i), next.o0())) {
                    it.remove();
                    break;
                } else {
                    i++;
                }
            }
        }
        x0 x0Var = this.f57352c;
        if (x0Var != null) {
            x0Var.c(this.f57350a.size(), 1);
        }
    }

    public void j(a2 a2Var) {
        this.f57350a.remove(a2Var);
        x0 x0Var = this.f57352c;
        if (x0Var != null) {
            x0Var.c(this.f57350a.size(), 1);
        }
    }

    public void k() {
        m(false, false);
        b();
    }

    public void l(AntiData antiData) {
        this.f57353d = antiData;
    }

    public void m(boolean z, boolean z2) {
        this.f57351b = z;
        x0 x0Var = this.f57352c;
        if (x0Var != null) {
            x0Var.b(z, z2, 1);
        }
    }

    public void n(String str) {
        this.f57354e = str;
    }

    public void o(x0 x0Var) {
        this.f57352c = x0Var;
    }

    public void p(boolean z) {
        this.f57355f = z;
    }

    public b() {
        this.f57351b = false;
        this.f57350a = new ArrayList<>();
    }
}
