package d.b.i0.u3;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes5.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f61535a;

    /* renamed from: b  reason: collision with root package name */
    public View f61536b;

    /* renamed from: c  reason: collision with root package name */
    public View f61537c;

    /* renamed from: d  reason: collision with root package name */
    public a f61538d;

    /* renamed from: e  reason: collision with root package name */
    public int f61539e = 4;

    /* renamed from: f  reason: collision with root package name */
    public Rect f61540f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    public Rect f61541g = new Rect();

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i);
    }

    public h(Context context, d.b.i0.u3.a aVar) {
        this.f61535a = context;
    }

    public void a(View view, View view2) {
        this.f61536b = view;
        this.f61537c = view2;
        if (view2 != null) {
            view2.getGlobalVisibleRect(this.f61540f);
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
        this.f61538d = aVar;
    }

    public void f() {
        g();
    }

    public abstract void g();

    public abstract void h();
}
