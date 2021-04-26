package d.a.h0.a.e2;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f42415f = k.f43101a;

    /* renamed from: g  reason: collision with root package name */
    public static d.a.h0.a.e2.a f42416g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f42417h;

    /* renamed from: a  reason: collision with root package name */
    public int f42418a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f42419b = 200;

    /* renamed from: c  reason: collision with root package name */
    public int f42420c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f42421d;

    /* renamed from: e  reason: collision with root package name */
    public String f42422e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f42423e;

        public a(View view) {
            this.f42423e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c.f42416g != null) {
                c.f42416g.c(c.this.f42422e);
            }
            Rect rect = new Rect();
            this.f42423e.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (c.this.f42420c == c.this.f42418a) {
                c.this.f42420c = height;
            } else if (c.this.f42420c == height) {
            } else {
                if (c.this.f42420c - height > c.this.f42419b) {
                    if (c.f42416g != null) {
                        c.f42416g.b(c.this.f42422e, c.this.f42420c - height);
                        if (c.f42415f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.f42420c + " visibleHeight " + height);
                        }
                    }
                    c.this.f42420c = height;
                } else if (height - c.this.f42420c > c.this.f42419b) {
                    if (c.f42416g != null) {
                        c.f42416g.a(c.this.f42422e, height - c.this.f42420c);
                    }
                    if (c.f42415f) {
                        Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.f42420c + " visibleHeight " + height);
                    }
                    c.this.f42420c = height;
                }
            }
        }
    }

    public static c i() {
        if (f42417h == null) {
            synchronized (c.class) {
                if (f42417h == null) {
                    f42417h = new c();
                }
            }
        }
        return f42417h;
    }

    public static void j() {
        f42416g = null;
        f42417h = null;
    }

    public final void h(View view) {
        if (this.f42421d == null) {
            this.f42421d = new a(view);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f42421d);
    }

    public void k(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f42421d);
        this.f42422e = "";
        f42416g = null;
        this.f42420c = 0;
    }

    public void l(View view, String str, d.a.h0.a.e2.a aVar) {
        h(view);
        this.f42422e = str;
        f42416g = aVar;
        this.f42420c = 0;
    }
}
