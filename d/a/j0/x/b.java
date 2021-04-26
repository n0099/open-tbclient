package d.a.j0.x;

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
    public int f62436e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f62437f;

    /* renamed from: g  reason: collision with root package name */
    public Context f62438g;

    /* renamed from: h  reason: collision with root package name */
    public View f62439h;

    /* renamed from: i  reason: collision with root package name */
    public b0<T> f62440i;
    public BdUniqueId j;
    public String k;
    public int l;

    public b(TbPageContext<?> tbPageContext) {
        this.f62436e = 3;
        this.j = null;
        this.f62437f = tbPageContext;
        this.f62438g = tbPageContext.getPageActivity();
        this.f62439h = LayoutInflater.from(b()).inflate(g(), (ViewGroup) null, false);
    }

    public Context b() {
        return this.f62438g;
    }

    public String f() {
        return this.k;
    }

    public abstract int g();

    public b0<T> h() {
        return this.f62440i;
    }

    public BdUniqueId i() {
        return this.j;
    }

    public TbPageContext<?> k() {
        return this.f62437f;
    }

    public View l() {
        return this.f62439h;
    }

    public abstract void m(T t);

    public abstract void n(TbPageContext<?> tbPageContext, int i2);

    public void o(b0<T> b0Var) {
        this.f62440i = b0Var;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.j = bdUniqueId;
    }

    public void r(int i2) {
        View view = this.f62439h;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void setFrom(String str) {
        this.k = str;
    }

    public b(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        this.f62436e = 3;
        this.j = null;
        this.f62437f = tbPageContext;
        this.f62438g = tbPageContext.getPageActivity();
        this.f62439h = LayoutInflater.from(b()).inflate(g(), viewGroup, false);
    }
}
