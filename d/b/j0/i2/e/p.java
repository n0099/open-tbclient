package d.b.j0.i2.e;

import com.baidu.tbadk.core.util.ListUtils;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // d.b.j0.i2.e.a
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
