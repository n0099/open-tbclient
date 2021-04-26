package d.a.i0.g0.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import d.a.i0.g0.d.b;
import d.a.j0.d3.t;
/* loaded from: classes3.dex */
public abstract class e<D, S extends d.a.i0.g0.d.b> implements t {

    /* renamed from: e  reason: collision with root package name */
    public final ViewEventCenter f48539e;

    /* renamed from: f  reason: collision with root package name */
    public D f48540f;

    /* renamed from: g  reason: collision with root package name */
    public S f48541g;

    /* renamed from: h  reason: collision with root package name */
    public final View f48542h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f48543i;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        this.f48543i = tbPageContext;
        this.f48542h = view;
        this.f48539e = viewEventCenter;
    }

    public Activity a() {
        return this.f48543i.getPageActivity();
    }

    public Context b() {
        return this.f48543i.getContext();
    }

    public D c() {
        return this.f48540f;
    }

    public ViewEventCenter d() {
        return this.f48539e;
    }

    public TbPageContext<?> e() {
        return this.f48543i;
    }

    public Resources f() {
        return this.f48543i.getResources();
    }

    public View g() {
        return this.f48542h;
    }

    public S h() {
        return this.f48541g;
    }

    public String i(int i2) {
        return f().getString(i2);
    }

    public BdUniqueId j() {
        return this.f48543i.getUniqueId();
    }

    public void k(D d2) {
        this.f48540f = d2;
    }

    public void l(D d2, S s) {
        k(d2);
        m(s);
    }

    public void m(S s) {
        this.f48541g = s;
    }
}
