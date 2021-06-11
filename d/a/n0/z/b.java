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
    public int f67158e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f67159f;

    /* renamed from: g  reason: collision with root package name */
    public Context f67160g;

    /* renamed from: h  reason: collision with root package name */
    public View f67161h;

    /* renamed from: i  reason: collision with root package name */
    public b0<T> f67162i;
    public BdUniqueId j;
    public String k;
    public int l;

    public b(TbPageContext<?> tbPageContext) {
        this.f67158e = 3;
        this.j = null;
        this.f67159f = tbPageContext;
        this.f67160g = tbPageContext.getPageActivity();
        this.f67161h = LayoutInflater.from(b()).inflate(h(), (ViewGroup) null, false);
    }

    public Context b() {
        return this.f67160g;
    }

    public String f() {
        return this.k;
    }

    public abstract int h();

    public b0<T> i() {
        return this.f67162i;
    }

    public BdUniqueId j() {
        return this.j;
    }

    public TbPageContext<?> k() {
        return this.f67159f;
    }

    public View m() {
        return this.f67161h;
    }

    public abstract void n(T t);

    public abstract void o(TbPageContext<?> tbPageContext, int i2);

    public void p(b0<T> b0Var) {
        this.f67162i = b0Var;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.j = bdUniqueId;
    }

    public void s(int i2) {
        View view = this.f67161h;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void setFrom(String str) {
        this.k = str;
    }

    public b(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        this.f67158e = 3;
        this.j = null;
        this.f67159f = tbPageContext;
        this.f67160g = tbPageContext.getPageActivity();
        this.f67161h = LayoutInflater.from(b()).inflate(h(), viewGroup, false);
    }
}
