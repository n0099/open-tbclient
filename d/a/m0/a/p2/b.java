package d.a.m0.a.p2;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f47895a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f47896b = 200;

    /* renamed from: c  reason: collision with root package name */
    public View f47897c;

    /* renamed from: d  reason: collision with root package name */
    public int f47898d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.a.p2.a f47899e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47900e;

        public a(String str) {
            this.f47900e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.f47899e != null) {
                b.this.f47899e.c(this.f47900e);
            }
            Rect rect = new Rect();
            b.this.f47897c.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (b.this.f47898d == b.this.f47895a) {
                b.this.f47898d = height;
            } else if (b.this.f47898d == height) {
            } else {
                if (b.this.f47898d - height > b.this.f47896b) {
                    if (b.this.f47899e != null) {
                        b.this.f47899e.b(this.f47900e, b.this.f47898d - height);
                    }
                    b.this.f47898d = height;
                } else if (height - b.this.f47898d > b.this.f47896b) {
                    if (b.this.f47899e != null) {
                        b.this.f47899e.a(this.f47900e, height - b.this.f47898d);
                    }
                    b.this.f47898d = height;
                }
            }
        }
    }

    public b(String str, Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f47897c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(str));
    }

    public static void g(String str, Activity activity, d.a.m0.a.p2.a aVar) {
        new b(str, activity).h(aVar);
    }

    public final void h(d.a.m0.a.p2.a aVar) {
        this.f47899e = aVar;
    }
}
