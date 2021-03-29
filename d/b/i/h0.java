package d.b.i;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.SmartAppBottomLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h0 extends h {
    public SmartAppBottomLayout l;

    public h0(Context context) {
        super(context);
        this.l = new SmartAppBottomLayout(context);
    }

    @Override // d.b.i.a
    public View g() {
        return this.l;
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SmartAppBottomLayout smartAppBottomLayout = this.l;
        if (smartAppBottomLayout != null) {
            smartAppBottomLayout.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: s */
    public void a(d.b.h0.r.q.a aVar) {
        SmartAppBottomLayout smartAppBottomLayout = this.l;
        if (smartAppBottomLayout != null) {
            smartAppBottomLayout.a(aVar);
        }
    }
}
