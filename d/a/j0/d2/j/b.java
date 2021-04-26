package d.a.j0.d2.j;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
/* loaded from: classes3.dex */
public abstract class b<D extends IBaseDialogData> implements g<D> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f52097e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f52098f;

    public b(TbPageContext<?> tbPageContext) {
        this.f52097e = tbPageContext;
        this.f52098f = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(c(), (ViewGroup) null, false);
        a();
    }

    public TbPageContext<?> d() {
        return this.f52097e;
    }

    @Override // d.a.j0.d2.j.g
    public ViewGroup getViewGroup() {
        return this.f52098f;
    }
}
