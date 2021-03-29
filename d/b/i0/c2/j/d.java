package d.b.i0.c2.j;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class d extends a<e, CustomDialogData> {
    public d(TbPageContext tbPageContext, CustomDialogData customDialogData) {
        super(tbPageContext, new e(tbPageContext), customDialogData);
        V v = this.f52494h;
        if (v instanceof e) {
            ((e) v).f(this);
        }
    }

    @Override // d.b.i0.c2.j.f
    public int a() {
        return l.g(this.f52489c, R.dimen.ds90);
    }

    @Override // d.b.i0.c2.j.f
    public boolean b() {
        return true;
    }

    @Override // d.b.i0.c2.j.f
    public boolean c() {
        return true;
    }
}
