package d.a.m0.a.p2;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47902f = k.f46983a;

    /* renamed from: g  reason: collision with root package name */
    public static d.a.m0.a.p2.a f47903g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f47904h;

    /* renamed from: a  reason: collision with root package name */
    public int f47905a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f47906b = 200;

    /* renamed from: c  reason: collision with root package name */
    public int f47907c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f47908d;

    /* renamed from: e  reason: collision with root package name */
    public String f47909e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f47910e;

        public a(View view) {
            this.f47910e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c.f47903g != null) {
                c.f47903g.c(c.this.f47909e);
            }
            Rect rect = new Rect();
            this.f47910e.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (c.this.f47907c == c.this.f47905a) {
                c.this.f47907c = height;
            } else if (c.this.f47907c == height) {
            } else {
                if (c.this.f47907c - height > c.this.f47906b) {
                    if (c.f47903g != null) {
                        c.f47903g.b(c.this.f47909e, c.this.f47907c - height);
                        if (c.f47902f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.f47907c + " visibleHeight " + height);
                        }
                    }
                    c.this.f47907c = height;
                } else if (height - c.this.f47907c > c.this.f47906b) {
                    if (c.f47903g != null) {
                        c.f47903g.a(c.this.f47909e, height - c.this.f47907c);
                    }
                    if (c.f47902f) {
                        Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.f47907c + " visibleHeight " + height);
                    }
                    c.this.f47907c = height;
                }
            }
        }
    }

    public static c i() {
        if (f47904h == null) {
            synchronized (c.class) {
                if (f47904h == null) {
                    f47904h = new c();
                }
            }
        }
        return f47904h;
    }

    public static void j() {
        f47903g = null;
        f47904h = null;
    }

    public final void h(View view) {
        if (this.f47908d == null) {
            this.f47908d = new a(view);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f47908d);
    }

    public void k(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f47908d);
        this.f47909e = "";
        f47903g = null;
        this.f47907c = 0;
    }

    public void l(View view, String str, d.a.m0.a.p2.a aVar) {
        h(view);
        this.f47909e = str;
        f47903g = aVar;
        this.f47907c = 0;
    }
}
