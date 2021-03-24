package d.b.i0.c2.j;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
/* loaded from: classes4.dex */
public abstract class b<D extends IBaseDialogData> implements g<D> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f52495e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f52496f;

    public b(TbPageContext<?> tbPageContext) {
        this.f52495e = tbPageContext;
        this.f52496f = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(b(), (ViewGroup) null, false);
        a();
    }

    public TbPageContext<?> d() {
        return this.f52495e;
    }

    @Override // d.b.i0.c2.j.g
    public ViewGroup getViewGroup() {
        return this.f52496f;
    }
}
