package d.b.h0.a.e2;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import d.b.h0.a.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45105f = k.f45772a;

    /* renamed from: g  reason: collision with root package name */
    public static d.b.h0.a.e2.a f45106g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f45107h;

    /* renamed from: a  reason: collision with root package name */
    public int f45108a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f45109b = 200;

    /* renamed from: c  reason: collision with root package name */
    public int f45110c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f45111d;

    /* renamed from: e  reason: collision with root package name */
    public String f45112e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f45113e;

        public a(View view) {
            this.f45113e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c.f45106g != null) {
                c.f45106g.a(c.this.f45112e);
            }
            Rect rect = new Rect();
            this.f45113e.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (c.this.f45110c == c.this.f45108a) {
                c.this.f45110c = height;
            } else if (c.this.f45110c == height) {
            } else {
                if (c.this.f45110c - height > c.this.f45109b) {
                    if (c.f45106g != null) {
                        c.f45106g.c(c.this.f45112e, c.this.f45110c - height);
                        if (c.f45105f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.f45110c + " visibleHeight " + height);
                        }
                    }
                    c.this.f45110c = height;
                } else if (height - c.this.f45110c > c.this.f45109b) {
                    if (c.f45106g != null) {
                        c.f45106g.b(c.this.f45112e, height - c.this.f45110c);
                    }
                    if (c.f45105f) {
                        Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.f45110c + " visibleHeight " + height);
                    }
                    c.this.f45110c = height;
                }
            }
        }
    }

    public static c i() {
        if (f45107h == null) {
            synchronized (c.class) {
                if (f45107h == null) {
                    f45107h = new c();
                }
            }
        }
        return f45107h;
    }

    public static void j() {
        f45106g = null;
        f45107h = null;
    }

    public final void h(View view) {
        if (this.f45111d == null) {
            this.f45111d = new a(view);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f45111d);
    }

    public void k(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f45111d);
        this.f45112e = "";
        f45106g = null;
        this.f45110c = 0;
    }

    public void l(View view, String str, d.b.h0.a.e2.a aVar) {
        h(view);
        this.f45112e = str;
        f45106g = aVar;
        this.f45110c = 0;
    }
}
