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
    public static final boolean f44384f = k.f45051a;

    /* renamed from: g  reason: collision with root package name */
    public static d.b.g0.a.e2.a f44385g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f44386h;

    /* renamed from: a  reason: collision with root package name */
    public int f44387a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f44388b = 200;

    /* renamed from: c  reason: collision with root package name */
    public int f44389c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f44390d;

    /* renamed from: e  reason: collision with root package name */
    public String f44391e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f44392e;

        public a(View view) {
            this.f44392e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c.f44385g != null) {
                c.f44385g.a(c.this.f44391e);
            }
            Rect rect = new Rect();
            this.f44392e.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (c.this.f44389c == c.this.f44387a) {
                c.this.f44389c = height;
            } else if (c.this.f44389c == height) {
            } else {
                if (c.this.f44389c - height > c.this.f44388b) {
                    if (c.f44385g != null) {
                        c.f44385g.c(c.this.f44391e, c.this.f44389c - height);
                        if (c.f44384f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.f44389c + " visibleHeight " + height);
                        }
                    }
                    c.this.f44389c = height;
                } else if (height - c.this.f44389c > c.this.f44388b) {
                    if (c.f44385g != null) {
                        c.f44385g.b(c.this.f44391e, height - c.this.f44389c);
                    }
                    if (c.f44384f) {
                        Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.f44389c + " visibleHeight " + height);
                    }
                    c.this.f44389c = height;
                }
            }
        }
    }

    public static c i() {
        if (f44386h == null) {
            synchronized (c.class) {
                if (f44386h == null) {
                    f44386h = new c();
                }
            }
        }
        return f44386h;
    }

    public static void j() {
        f44385g = null;
        f44386h = null;
    }

    public final void h(View view) {
        if (this.f44390d == null) {
            this.f44390d = new a(view);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f44390d);
    }

    public void k(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f44390d);
        this.f44391e = "";
        f44385g = null;
        this.f44389c = 0;
    }

    public void l(View view, String str, d.b.g0.a.e2.a aVar) {
        h(view);
        this.f44391e = str;
        f44385g = aVar;
        this.f44389c = 0;
    }
}
