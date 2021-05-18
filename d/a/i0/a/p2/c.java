package d.a.i0.a.p2;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f43944f = k.f43025a;

    /* renamed from: g  reason: collision with root package name */
    public static d.a.i0.a.p2.a f43945g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f43946h;

    /* renamed from: a  reason: collision with root package name */
    public int f43947a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f43948b = 200;

    /* renamed from: c  reason: collision with root package name */
    public int f43949c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f43950d;

    /* renamed from: e  reason: collision with root package name */
    public String f43951e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f43952e;

        public a(View view) {
            this.f43952e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c.f43945g != null) {
                c.f43945g.c(c.this.f43951e);
            }
            Rect rect = new Rect();
            this.f43952e.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (c.this.f43949c == c.this.f43947a) {
                c.this.f43949c = height;
            } else if (c.this.f43949c == height) {
            } else {
                if (c.this.f43949c - height > c.this.f43948b) {
                    if (c.f43945g != null) {
                        c.f43945g.b(c.this.f43951e, c.this.f43949c - height);
                        if (c.f43944f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.f43949c + " visibleHeight " + height);
                        }
                    }
                    c.this.f43949c = height;
                } else if (height - c.this.f43949c > c.this.f43948b) {
                    if (c.f43945g != null) {
                        c.f43945g.a(c.this.f43951e, height - c.this.f43949c);
                    }
                    if (c.f43944f) {
                        Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.f43949c + " visibleHeight " + height);
                    }
                    c.this.f43949c = height;
                }
            }
        }
    }

    public static c i() {
        if (f43946h == null) {
            synchronized (c.class) {
                if (f43946h == null) {
                    f43946h = new c();
                }
            }
        }
        return f43946h;
    }

    public static void j() {
        f43945g = null;
        f43946h = null;
    }

    public final void h(View view) {
        if (this.f43950d == null) {
            this.f43950d = new a(view);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f43950d);
    }

    public void k(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f43950d);
        this.f43951e = "";
        f43945g = null;
        this.f43949c = 0;
    }

    public void l(View view, String str, d.a.i0.a.p2.a aVar) {
        h(view);
        this.f43951e = str;
        f43945g = aVar;
        this.f43949c = 0;
    }
}
