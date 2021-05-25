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
    public static final boolean f44120f = k.f43199a;

    /* renamed from: g  reason: collision with root package name */
    public static d.a.l0.a.p2.a f44121g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f44122h;

    /* renamed from: a  reason: collision with root package name */
    public int f44123a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f44124b = 200;

    /* renamed from: c  reason: collision with root package name */
    public int f44125c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f44126d;

    /* renamed from: e  reason: collision with root package name */
    public String f44127e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f44128e;

        public a(View view) {
            this.f44128e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c.f44121g != null) {
                c.f44121g.c(c.this.f44127e);
            }
            Rect rect = new Rect();
            this.f44128e.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (c.this.f44125c == c.this.f44123a) {
                c.this.f44125c = height;
            } else if (c.this.f44125c == height) {
            } else {
                if (c.this.f44125c - height > c.this.f44124b) {
                    if (c.f44121g != null) {
                        c.f44121g.b(c.this.f44127e, c.this.f44125c - height);
                        if (c.f44120f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.f44125c + " visibleHeight " + height);
                        }
                    }
                    c.this.f44125c = height;
                } else if (height - c.this.f44125c > c.this.f44124b) {
                    if (c.f44121g != null) {
                        c.f44121g.a(c.this.f44127e, height - c.this.f44125c);
                    }
                    if (c.f44120f) {
                        Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.f44125c + " visibleHeight " + height);
                    }
                    c.this.f44125c = height;
                }
            }
        }
    }

    public static c i() {
        if (f44122h == null) {
            synchronized (c.class) {
                if (f44122h == null) {
                    f44122h = new c();
                }
            }
        }
        return f44122h;
    }

    public static void j() {
        f44121g = null;
        f44122h = null;
    }

    public final void h(View view) {
        if (this.f44126d == null) {
            this.f44126d = new a(view);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f44126d);
    }

    public void k(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f44126d);
        this.f44127e = "";
        f44121g = null;
        this.f44125c = 0;
    }

    public void l(View view, String str, d.a.l0.a.p2.a aVar) {
        h(view);
        this.f44127e = str;
        f44121g = aVar;
        this.f44125c = 0;
    }
}
