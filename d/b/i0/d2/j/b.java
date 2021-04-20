package d.b.i0.d2.j;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
/* loaded from: classes3.dex */
public abstract class b<D extends IBaseDialogData> implements g<D> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f53891e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f53892f;

    public b(TbPageContext<?> tbPageContext) {
        this.f53891e = tbPageContext;
        this.f53892f = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(b(), (ViewGroup) null, false);
        a();
    }

    public TbPageContext<?> d() {
        return this.f53891e;
    }

    @Override // d.b.i0.d2.j.g
    public ViewGroup getViewGroup() {
        return this.f53892f;
    }
}
