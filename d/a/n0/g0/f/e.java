package d.a.n0.g0.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import d.a.n0.g0.d.b;
import d.a.o0.e3.t;
/* loaded from: classes3.dex */
public abstract class e<D, S extends d.a.n0.g0.d.b> implements t {

    /* renamed from: e  reason: collision with root package name */
    public final ViewEventCenter f53192e;

    /* renamed from: f  reason: collision with root package name */
    public D f53193f;

    /* renamed from: g  reason: collision with root package name */
    public S f53194g;

    /* renamed from: h  reason: collision with root package name */
    public final View f53195h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f53196i;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        this.f53196i = tbPageContext;
        this.f53195h = view;
        this.f53192e = viewEventCenter;
    }

    public Activity a() {
        return this.f53196i.getPageActivity();
    }

    public Context b() {
        return this.f53196i.getContext();
    }

    public D c() {
        return this.f53193f;
    }

    public ViewEventCenter d() {
        return this.f53192e;
    }

    public TbPageContext<?> e() {
        return this.f53196i;
    }

    public Resources f() {
        return this.f53196i.getResources();
    }

    public View g() {
        return this.f53195h;
    }

    public S h() {
        return this.f53194g;
    }

    public String i(int i2) {
        return f().getString(i2);
    }

    public BdUniqueId j() {
        return this.f53196i.getUniqueId();
    }

    public void k(D d2) {
        this.f53193f = d2;
    }

    public void l(D d2, S s) {
        k(d2);
        m(s);
    }

    public void m(S s) {
        this.f53194g = s;
    }
}
