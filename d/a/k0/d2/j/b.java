package d.a.k0.d2.j;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
/* loaded from: classes4.dex */
public abstract class b<D extends IBaseDialogData> implements g<D> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f52796e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f52797f;

    public b(TbPageContext<?> tbPageContext) {
        this.f52796e = tbPageContext;
        this.f52797f = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(c(), (ViewGroup) null, false);
        a();
    }

    public TbPageContext<?> d() {
        return this.f52796e;
    }

    @Override // d.a.k0.d2.j.g
    public ViewGroup getViewGroup() {
        return this.f52797f;
    }
}
