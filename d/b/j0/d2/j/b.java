package d.b.j0.d2.j;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
/* loaded from: classes3.dex */
public abstract class b<D extends IBaseDialogData> implements g<D> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f54312e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f54313f;

    public b(TbPageContext<?> tbPageContext) {
        this.f54312e = tbPageContext;
        this.f54313f = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(b(), (ViewGroup) null, false);
        a();
    }

    public TbPageContext<?> d() {
        return this.f54312e;
    }

    @Override // d.b.j0.d2.j.g
    public ViewGroup getViewGroup() {
        return this.f54313f;
    }
}
