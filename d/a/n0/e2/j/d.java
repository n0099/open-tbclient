package d.a.n0.e2.j;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class d extends a<e, CustomDialogData> {
    public d(TbPageContext tbPageContext, CustomDialogData customDialogData) {
        super(tbPageContext, new e(tbPageContext), customDialogData);
        V v = this.f56689h;
        if (v instanceof e) {
            ((e) v).f(this);
        }
    }

    @Override // d.a.n0.e2.j.f
    public int a() {
        return l.g(this.f56684c, R.dimen.ds90);
    }

    @Override // d.a.n0.e2.j.f
    public boolean b() {
        return true;
    }

    @Override // d.a.n0.e2.j.f
    public boolean c() {
        return true;
    }
}
