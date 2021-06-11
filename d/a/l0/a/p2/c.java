package d.a.l0.a.p2;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47794f = k.f46875a;

    /* renamed from: g  reason: collision with root package name */
    public static d.a.l0.a.p2.a f47795g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f47796h;

    /* renamed from: a  reason: collision with root package name */
    public int f47797a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f47798b = 200;

    /* renamed from: c  reason: collision with root package name */
    public int f47799c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f47800d;

    /* renamed from: e  reason: collision with root package name */
    public String f47801e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f47802e;

        public a(View view) {
            this.f47802e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c.f47795g != null) {
                c.f47795g.c(c.this.f47801e);
            }
            Rect rect = new Rect();
            this.f47802e.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (c.this.f47799c == c.this.f47797a) {
                c.this.f47799c = height;
            } else if (c.this.f47799c == height) {
            } else {
                if (c.this.f47799c - height > c.this.f47798b) {
                    if (c.f47795g != null) {
                        c.f47795g.b(c.this.f47801e, c.this.f47799c - height);
                        if (c.f47794f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.f47799c + " visibleHeight " + height);
                        }
                    }
                    c.this.f47799c = height;
                } else if (height - c.this.f47799c > c.this.f47798b) {
                    if (c.f47795g != null) {
                        c.f47795g.a(c.this.f47801e, height - c.this.f47799c);
                    }
                    if (c.f47794f) {
                        Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.f47799c + " visibleHeight " + height);
                    }
                    c.this.f47799c = height;
                }
            }
        }
    }

    public static c i() {
        if (f47796h == null) {
            synchronized (c.class) {
                if (f47796h == null) {
                    f47796h = new c();
                }
            }
        }
        return f47796h;
    }

    public static void j() {
        f47795g = null;
        f47796h = null;
    }

    public final void h(View view) {
        if (this.f47800d == null) {
            this.f47800d = new a(view);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f47800d);
    }

    public void k(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f47800d);
        this.f47801e = "";
        f47795g = null;
        this.f47799c = 0;
    }

    public void l(View view, String str, d.a.l0.a.p2.a aVar) {
        h(view);
        this.f47801e = str;
        f47795g = aVar;
        this.f47799c = 0;
    }
}
