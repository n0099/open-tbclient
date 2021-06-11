package d.a.l0.a.p2;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f47787a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f47788b = 200;

    /* renamed from: c  reason: collision with root package name */
    public View f47789c;

    /* renamed from: d  reason: collision with root package name */
    public int f47790d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.p2.a f47791e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47792e;

        public a(String str) {
            this.f47792e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.f47791e != null) {
                b.this.f47791e.c(this.f47792e);
            }
            Rect rect = new Rect();
            b.this.f47789c.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (b.this.f47790d == b.this.f47787a) {
                b.this.f47790d = height;
            } else if (b.this.f47790d == height) {
            } else {
                if (b.this.f47790d - height > b.this.f47788b) {
                    if (b.this.f47791e != null) {
                        b.this.f47791e.b(this.f47792e, b.this.f47790d - height);
                    }
                    b.this.f47790d = height;
                } else if (height - b.this.f47790d > b.this.f47788b) {
                    if (b.this.f47791e != null) {
                        b.this.f47791e.a(this.f47792e, height - b.this.f47790d);
                    }
                    b.this.f47790d = height;
                }
            }
        }
    }

    public b(String str, Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f47789c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(str));
    }

    public static void g(String str, Activity activity, d.a.l0.a.p2.a aVar) {
        new b(str, activity).h(aVar);
    }

    public final void h(d.a.l0.a.p2.a aVar) {
        this.f47791e = aVar;
    }
}
