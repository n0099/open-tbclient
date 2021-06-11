package d.a.n0.w3;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes5.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f66471a;

    /* renamed from: b  reason: collision with root package name */
    public View f66472b;

    /* renamed from: c  reason: collision with root package name */
    public View f66473c;

    /* renamed from: d  reason: collision with root package name */
    public a f66474d;

    /* renamed from: e  reason: collision with root package name */
    public int f66475e = 4;

    /* renamed from: f  reason: collision with root package name */
    public Rect f66476f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    public Rect f66477g = new Rect();

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2);
    }

    public g(Context context, d.a.n0.w3.a aVar) {
        this.f66471a = context;
    }

    public void a(View view, View view2) {
        this.f66472b = view;
        this.f66473c = view2;
        if (view2 != null) {
            view2.getGlobalVisibleRect(this.f66476f);
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
        this.f66474d = aVar;
    }

    public void f() {
        g();
    }

    public abstract void g();

    public abstract void h();
}
