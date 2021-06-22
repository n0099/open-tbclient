package d.a.o0.z;

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
    public int f67283e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f67284f;

    /* renamed from: g  reason: collision with root package name */
    public Context f67285g;

    /* renamed from: h  reason: collision with root package name */
    public View f67286h;

    /* renamed from: i  reason: collision with root package name */
    public b0<T> f67287i;
    public BdUniqueId j;
    public String k;
    public int l;

    public b(TbPageContext<?> tbPageContext) {
        this.f67283e = 3;
        this.j = null;
        this.f67284f = tbPageContext;
        this.f67285g = tbPageContext.getPageActivity();
        this.f67286h = LayoutInflater.from(b()).inflate(h(), (ViewGroup) null, false);
    }

    public Context b() {
        return this.f67285g;
    }

    public String f() {
        return this.k;
    }

    public abstract int h();

    public b0<T> i() {
        return this.f67287i;
    }

    public BdUniqueId j() {
        return this.j;
    }

    public TbPageContext<?> k() {
        return this.f67284f;
    }

    public View m() {
        return this.f67286h;
    }

    public abstract void n(T t);

    public abstract void o(TbPageContext<?> tbPageContext, int i2);

    public void p(b0<T> b0Var) {
        this.f67287i = b0Var;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.j = bdUniqueId;
    }

    public void s(int i2) {
        View view = this.f67286h;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void setFrom(String str) {
        this.k = str;
    }

    public b(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        this.f67283e = 3;
        this.j = null;
        this.f67284f = tbPageContext;
        this.f67285g = tbPageContext.getPageActivity();
        this.f67286h = LayoutInflater.from(b()).inflate(h(), viewGroup, false);
    }
}
