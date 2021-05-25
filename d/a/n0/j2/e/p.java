package d.a.n0.j2.e;

import com.baidu.tbadk.core.util.ListUtils;
/* loaded from: classes5.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // d.a.n0.j2.e.a
    public void b() {
        this.q.clear();
        i iVar = this.o;
        if (iVar != null) {
            this.q.add(iVar);
        }
        if (ListUtils.isEmpty(this.p)) {
            return;
        }
        this.q.addAll(this.p);
    }
}
