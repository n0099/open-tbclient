package d.a.o0.e2.j;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
/* loaded from: classes5.dex */
public abstract class b<D extends IBaseDialogData> implements g<D> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f56816e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f56817f;

    public b(TbPageContext<?> tbPageContext) {
        this.f56816e = tbPageContext;
        this.f56817f = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(c(), (ViewGroup) null, false);
        a();
    }

    public TbPageContext<?> d() {
        return this.f56816e;
    }

    @Override // d.a.o0.e2.j.g
    public ViewGroup getViewGroup() {
        return this.f56817f;
    }
}
