package d.a.n0.z;

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
    public int f63440e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f63441f;

    /* renamed from: g  reason: collision with root package name */
    public Context f63442g;

    /* renamed from: h  reason: collision with root package name */
    public View f63443h;

    /* renamed from: i  reason: collision with root package name */
    public b0<T> f63444i;
    public BdUniqueId j;
    public String k;
    public int l;

    public b(TbPageContext<?> tbPageContext) {
        this.f63440e = 3;
        this.j = null;
        this.f63441f = tbPageContext;
        this.f63442g = tbPageContext.getPageActivity();
        this.f63443h = LayoutInflater.from(b()).inflate(g(), (ViewGroup) null, false);
    }

    public Context b() {
        return this.f63442g;
    }

    public String f() {
        return this.k;
    }

    public abstract int g();

    public b0<T> h() {
        return this.f63444i;
    }

    public BdUniqueId i() {
        return this.j;
    }

    public TbPageContext<?> k() {
        return this.f63441f;
    }

    public View l() {
        return this.f63443h;
    }

    public abstract void m(T t);

    public abstract void n(TbPageContext<?> tbPageContext, int i2);

    public void o(b0<T> b0Var) {
        this.f63444i = b0Var;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.j = bdUniqueId;
    }

    public void r(int i2) {
        View view = this.f63443h;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void setFrom(String str) {
        this.k = str;
    }

    public b(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        this.f63440e = 3;
        this.j = null;
        this.f63441f = tbPageContext;
        this.f63442g = tbPageContext.getPageActivity();
        this.f63443h = LayoutInflater.from(b()).inflate(g(), viewGroup, false);
    }
}
