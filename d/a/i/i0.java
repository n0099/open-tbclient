package d.a.i;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.SmartAppBottomLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i0 extends h {
    public SmartAppBottomLayout l;

    public i0(Context context) {
        super(context);
        this.l = new SmartAppBottomLayout(context);
    }

    @Override // d.a.i.a
    public View g() {
        return this.l;
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        SmartAppBottomLayout smartAppBottomLayout = this.l;
        if (smartAppBottomLayout != null) {
            smartAppBottomLayout.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: s */
    public void a(d.a.j0.r.q.a aVar) {
        SmartAppBottomLayout smartAppBottomLayout = this.l;
        if (smartAppBottomLayout != null) {
            smartAppBottomLayout.a(aVar);
        }
    }
}
