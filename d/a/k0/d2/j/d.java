package d.a.k0.d2.j;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class d extends a<e, CustomDialogData> {
    public d(TbPageContext tbPageContext, CustomDialogData customDialogData) {
        super(tbPageContext, new e(tbPageContext), customDialogData);
        V v = this.f52794h;
        if (v instanceof e) {
            ((e) v).f(this);
        }
    }

    @Override // d.a.k0.d2.j.f
    public int a() {
        return l.g(this.f52789c, R.dimen.ds90);
    }

    @Override // d.a.k0.d2.j.f
    public boolean b() {
        return true;
    }

    @Override // d.a.k0.d2.j.f
    public boolean c() {
        return true;
    }
}
