package d.a.n0.e2.j;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
/* loaded from: classes4.dex */
public abstract class b<D extends IBaseDialogData> implements g<D> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f53002e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f53003f;

    public b(TbPageContext<?> tbPageContext) {
        this.f53002e = tbPageContext;
        this.f53003f = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(c(), (ViewGroup) null, false);
        a();
    }

    public TbPageContext<?> d() {
        return this.f53002e;
    }

    @Override // d.a.n0.e2.j.g
    public ViewGroup getViewGroup() {
        return this.f53003f;
    }
}
