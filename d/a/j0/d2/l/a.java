package d.a.j0.d2.l;

import com.baidu.tbadk.TbPageContext;
import d.a.j0.d2.l.b.c;
import d.a.j0.d2.l.b.d;
import d.a.j0.d2.l.b.f;
import d.a.j0.d2.l.b.g;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d> f52746a = new ArrayList<>();

    public ArrayList<d> a() {
        return this.f52746a;
    }

    public final boolean b(ExcContent excContent) {
        long longValue = excContent.type.longValue();
        return longValue == 2 || longValue == 0 || longValue == 1;
    }

    public void c(TbPageContext<?> tbPageContext, List<ExcContent> list) {
        g gVar;
        if (list == null || list.isEmpty()) {
            return;
        }
        loop0: while (true) {
            gVar = null;
            for (ExcContent excContent : list) {
                if (excContent != null && excContent.type != null) {
                    if (b(excContent)) {
                        c a2 = f.a(tbPageContext, excContent);
                        if (a2 == null) {
                            continue;
                        } else if (a2.a()) {
                            if (gVar != null) {
                                this.f52746a.add(gVar);
                            }
                            this.f52746a.add(a2);
                        } else {
                            if (gVar == null) {
                                gVar = new g();
                            }
                            gVar.c(a2.b());
                        }
                    } else {
                        if (gVar != null) {
                            this.f52746a.add(gVar);
                        }
                        this.f52746a.add(f.b(excContent));
                    }
                }
            }
            break loop0;
        }
        if (gVar != null) {
            this.f52746a.add(gVar);
        }
    }
}
