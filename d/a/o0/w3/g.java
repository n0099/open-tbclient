package d.a.o0.w3;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes5.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f66596a;

    /* renamed from: b  reason: collision with root package name */
    public View f66597b;

    /* renamed from: c  reason: collision with root package name */
    public View f66598c;

    /* renamed from: d  reason: collision with root package name */
    public a f66599d;

    /* renamed from: e  reason: collision with root package name */
    public int f66600e = 4;

    /* renamed from: f  reason: collision with root package name */
    public Rect f66601f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    public Rect f66602g = new Rect();

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2);
    }

    public g(Context context, d.a.o0.w3.a aVar) {
        this.f66596a = context;
    }

    public void a(View view, View view2) {
        this.f66597b = view;
        this.f66598c = view2;
        if (view2 != null) {
            view2.getGlobalVisibleRect(this.f66601f);
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
        this.f66599d = aVar;
    }

    public void f() {
        g();
    }

    public abstract void g();

    public abstract void h();
}
