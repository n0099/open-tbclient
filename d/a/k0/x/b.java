package d.a.k0.x;

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
    public int f63160e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f63161f;

    /* renamed from: g  reason: collision with root package name */
    public Context f63162g;

    /* renamed from: h  reason: collision with root package name */
    public View f63163h;

    /* renamed from: i  reason: collision with root package name */
    public b0<T> f63164i;
    public BdUniqueId j;
    public String k;
    public int l;

    public b(TbPageContext<?> tbPageContext) {
        this.f63160e = 3;
        this.j = null;
        this.f63161f = tbPageContext;
        this.f63162g = tbPageContext.getPageActivity();
        this.f63163h = LayoutInflater.from(b()).inflate(g(), (ViewGroup) null, false);
    }

    public Context b() {
        return this.f63162g;
    }

    public String f() {
        return this.k;
    }

    public abstract int g();

    public b0<T> h() {
        return this.f63164i;
    }

    public BdUniqueId i() {
        return this.j;
    }

    public TbPageContext<?> k() {
        return this.f63161f;
    }

    public View l() {
        return this.f63163h;
    }

    public abstract void m(T t);

    public abstract void n(TbPageContext<?> tbPageContext, int i2);

    public void o(b0<T> b0Var) {
        this.f63164i = b0Var;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.j = bdUniqueId;
    }

    public void r(int i2) {
        View view = this.f63163h;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void setFrom(String str) {
        this.k = str;
    }

    public b(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        this.f63160e = 3;
        this.j = null;
        this.f63161f = tbPageContext;
        this.f63162g = tbPageContext.getPageActivity();
        this.f63163h = LayoutInflater.from(b()).inflate(g(), viewGroup, false);
    }
}
