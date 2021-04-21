package d.b.h0.a.y.b;

import d.b.h0.a.y.a.j.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends a {
    public List<d.b.h0.a.y.a.j.a> o;
    public j p;

    public e(String str) {
        super(str);
        this.o = new ArrayList();
        j jVar = new j(str);
        this.p = jVar;
        this.o.add(jVar);
    }

    public int h() {
        return this.p.c();
    }

    public List<d.b.h0.a.y.a.j.a> i() {
        return this.o;
    }

    public boolean j() {
        return true;
    }
}
