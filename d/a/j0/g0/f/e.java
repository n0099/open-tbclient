package d.a.j0.g0.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import d.a.j0.g0.d.b;
import d.a.k0.d3.t;
/* loaded from: classes3.dex */
public abstract class e<D, S extends d.a.j0.g0.d.b> implements t {

    /* renamed from: e  reason: collision with root package name */
    public final ViewEventCenter f49367e;

    /* renamed from: f  reason: collision with root package name */
    public D f49368f;

    /* renamed from: g  reason: collision with root package name */
    public S f49369g;

    /* renamed from: h  reason: collision with root package name */
    public final View f49370h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f49371i;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        this.f49371i = tbPageContext;
        this.f49370h = view;
        this.f49367e = viewEventCenter;
    }

    public Activity a() {
        return this.f49371i.getPageActivity();
    }

    public Context b() {
        return this.f49371i.getContext();
    }

    public D c() {
        return this.f49368f;
    }

    public ViewEventCenter d() {
        return this.f49367e;
    }

    public TbPageContext<?> e() {
        return this.f49371i;
    }

    public Resources f() {
        return this.f49371i.getResources();
    }

    public View g() {
        return this.f49370h;
    }

    public S h() {
        return this.f49369g;
    }

    public String i(int i2) {
        return f().getString(i2);
    }

    public BdUniqueId j() {
        return this.f49371i.getUniqueId();
    }

    public void k(D d2) {
        this.f49368f = d2;
    }

    public void l(D d2, S s) {
        k(d2);
        m(s);
    }

    public void m(S s) {
        this.f49369g = s;
    }
}
