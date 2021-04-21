package d.b.i0.g0.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import d.b.i0.g0.d.b;
import d.b.j0.d3.t;
/* loaded from: classes3.dex */
public abstract class e<D, S extends d.b.i0.g0.d.b> implements t {

    /* renamed from: e  reason: collision with root package name */
    public final ViewEventCenter f50959e;

    /* renamed from: f  reason: collision with root package name */
    public D f50960f;

    /* renamed from: g  reason: collision with root package name */
    public S f50961g;

    /* renamed from: h  reason: collision with root package name */
    public final View f50962h;
    public TbPageContext<?> i;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        this.i = tbPageContext;
        this.f50962h = view;
        this.f50959e = viewEventCenter;
    }

    public Activity a() {
        return this.i.getPageActivity();
    }

    public Context b() {
        return this.i.getContext();
    }

    public D c() {
        return this.f50960f;
    }

    public ViewEventCenter d() {
        return this.f50959e;
    }

    public TbPageContext<?> e() {
        return this.i;
    }

    public Resources f() {
        return this.i.getResources();
    }

    public View g() {
        return this.f50962h;
    }

    public S h() {
        return this.f50961g;
    }

    public String i(int i) {
        return f().getString(i);
    }

    public BdUniqueId j() {
        return this.i.getUniqueId();
    }

    public void k(D d2) {
        this.f50960f = d2;
    }

    public void l(D d2, S s) {
        k(d2);
        m(s);
    }

    public void m(S s) {
        this.f50961g = s;
    }
}
