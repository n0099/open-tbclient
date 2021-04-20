package d.b.g0.a.e2;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44776f = k.f45443a;

    /* renamed from: g  reason: collision with root package name */
    public static d.b.g0.a.e2.a f44777g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f44778h;

    /* renamed from: a  reason: collision with root package name */
    public int f44779a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f44780b = 200;

    /* renamed from: c  reason: collision with root package name */
    public int f44781c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f44782d;

    /* renamed from: e  reason: collision with root package name */
    public String f44783e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f44784e;

        public a(View view) {
            this.f44784e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c.f44777g != null) {
                c.f44777g.a(c.this.f44783e);
            }
            Rect rect = new Rect();
            this.f44784e.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (c.this.f44781c == c.this.f44779a) {
                c.this.f44781c = height;
            } else if (c.this.f44781c == height) {
            } else {
                if (c.this.f44781c - height > c.this.f44780b) {
                    if (c.f44777g != null) {
                        c.f44777g.c(c.this.f44783e, c.this.f44781c - height);
                        if (c.f44776f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.f44781c + " visibleHeight " + height);
                        }
                    }
                    c.this.f44781c = height;
                } else if (height - c.this.f44781c > c.this.f44780b) {
                    if (c.f44777g != null) {
                        c.f44777g.b(c.this.f44783e, height - c.this.f44781c);
                    }
                    if (c.f44776f) {
                        Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.f44781c + " visibleHeight " + height);
                    }
                    c.this.f44781c = height;
                }
            }
        }
    }

    public static c i() {
        if (f44778h == null) {
            synchronized (c.class) {
                if (f44778h == null) {
                    f44778h = new c();
                }
            }
        }
        return f44778h;
    }

    public static void j() {
        f44777g = null;
        f44778h = null;
    }

    public final void h(View view) {
        if (this.f44782d == null) {
            this.f44782d = new a(view);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f44782d);
    }

    public void k(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f44782d);
        this.f44783e = "";
        f44777g = null;
        this.f44781c = 0;
    }

    public void l(View view, String str, d.b.g0.a.e2.a aVar) {
        h(view);
        this.f44783e = str;
        f44777g = aVar;
        this.f44781c = 0;
    }
}
