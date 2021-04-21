package d.b.j0.v3;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes5.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f63694a;

    /* renamed from: b  reason: collision with root package name */
    public View f63695b;

    /* renamed from: c  reason: collision with root package name */
    public View f63696c;

    /* renamed from: d  reason: collision with root package name */
    public a f63697d;

    /* renamed from: e  reason: collision with root package name */
    public int f63698e = 4;

    /* renamed from: f  reason: collision with root package name */
    public Rect f63699f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    public Rect f63700g = new Rect();

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i);
    }

    public h(Context context, d.b.j0.v3.a aVar) {
        this.f63694a = context;
    }

    public void a(View view, View view2) {
        this.f63695b = view;
        this.f63696c = view2;
        if (view2 != null) {
            view2.getGlobalVisibleRect(this.f63699f);
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
        this.f63697d = aVar;
    }

    public void f() {
        g();
    }

    public abstract void g();

    public abstract void h();
}
