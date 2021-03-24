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
    public static final boolean f44383f = k.f45050a;

    /* renamed from: g  reason: collision with root package name */
    public static d.b.g0.a.e2.a f44384g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f44385h;

    /* renamed from: a  reason: collision with root package name */
    public int f44386a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f44387b = 200;

    /* renamed from: c  reason: collision with root package name */
    public int f44388c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f44389d;

    /* renamed from: e  reason: collision with root package name */
    public String f44390e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f44391e;

        public a(View view) {
            this.f44391e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c.f44384g != null) {
                c.f44384g.a(c.this.f44390e);
            }
            Rect rect = new Rect();
            this.f44391e.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (c.this.f44388c == c.this.f44386a) {
                c.this.f44388c = height;
            } else if (c.this.f44388c == height) {
            } else {
                if (c.this.f44388c - height > c.this.f44387b) {
                    if (c.f44384g != null) {
                        c.f44384g.c(c.this.f44390e, c.this.f44388c - height);
                        if (c.f44383f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.f44388c + " visibleHeight " + height);
                        }
                    }
                    c.this.f44388c = height;
                } else if (height - c.this.f44388c > c.this.f44387b) {
                    if (c.f44384g != null) {
                        c.f44384g.b(c.this.f44390e, height - c.this.f44388c);
                    }
                    if (c.f44383f) {
                        Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.f44388c + " visibleHeight " + height);
                    }
                    c.this.f44388c = height;
                }
            }
        }
    }

    public static c i() {
        if (f44385h == null) {
            synchronized (c.class) {
                if (f44385h == null) {
                    f44385h = new c();
                }
            }
        }
        return f44385h;
    }

    public static void j() {
        f44384g = null;
        f44385h = null;
    }

    public final void h(View view) {
        if (this.f44389d == null) {
            this.f44389d = new a(view);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f44389d);
    }

    public void k(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f44389d);
        this.f44390e = "";
        f44384g = null;
        this.f44388c = 0;
    }

    public void l(View view, String str, d.b.g0.a.e2.a aVar) {
        h(view);
        this.f44390e = str;
        f44384g = aVar;
        this.f44388c = 0;
    }
}
