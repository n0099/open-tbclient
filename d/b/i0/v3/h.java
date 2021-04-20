package d.b.i0.v3;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes5.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f63273a;

    /* renamed from: b  reason: collision with root package name */
    public View f63274b;

    /* renamed from: c  reason: collision with root package name */
    public View f63275c;

    /* renamed from: d  reason: collision with root package name */
    public a f63276d;

    /* renamed from: e  reason: collision with root package name */
    public int f63277e = 4;

    /* renamed from: f  reason: collision with root package name */
    public Rect f63278f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    public Rect f63279g = new Rect();

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i);
    }

    public h(Context context, d.b.i0.v3.a aVar) {
        this.f63273a = context;
    }

    public void a(View view, View view2) {
        this.f63274b = view;
        this.f63275c = view2;
        if (view2 != null) {
            view2.getGlobalVisibleRect(this.f63278f);
        }
    }

    public void b(boolean z) {
        if (z) {
            h();
        } else {
            c();
        }
    }

    public abstract void c();

    public abstract void d();

    public void e(a aVar) {
        this.f63276d = aVar;
    }

    public void f() {
        g();
    }

    public abstract void g();

    public abstract void h();
}
