package d.b.i0.x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public abstract class b<T extends BaseCardInfo> implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f62179e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f62180f;

    /* renamed from: g  reason: collision with root package name */
    public Context f62181g;

    /* renamed from: h  reason: collision with root package name */
    public View f62182h;
    public b0<T> i;
    public BdUniqueId j;
    public String k;
    public int l;

    public b(TbPageContext<?> tbPageContext) {
        this.f62179e = 3;
        this.j = null;
        this.f62180f = tbPageContext;
        this.f62181g = tbPageContext.getPageActivity();
        this.f62182h = LayoutInflater.from(b()).inflate(h(), (ViewGroup) null, false);
    }

    public Context b() {
        return this.f62181g;
    }

    public String f() {
        return this.k;
    }

    public abstract int h();

    public b0<T> i() {
        return this.i;
    }

    public BdUniqueId k() {
        return this.j;
    }

    public TbPageContext<?> l() {
        return this.f62180f;
    }

    public View m() {
        return this.f62182h;
    }

    public abstract void n(T t);

    public abstract void o(TbPageContext<?> tbPageContext, int i);

    public void q(b0<T> b0Var) {
        this.i = b0Var;
    }

    public void r(BdUniqueId bdUniqueId) {
        this.j = bdUniqueId;
    }

    public void s(int i) {
        View view = this.f62182h;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void setFrom(String str) {
        this.k = str;
    }

    public b(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        this.f62179e = 3;
        this.j = null;
        this.f62180f = tbPageContext;
        this.f62181g = tbPageContext.getPageActivity();
        this.f62182h = LayoutInflater.from(b()).inflate(h(), viewGroup, false);
    }
}
