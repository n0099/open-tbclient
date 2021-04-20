package d.b.g0.a.e2;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f44769a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f44770b = 200;

    /* renamed from: c  reason: collision with root package name */
    public View f44771c;

    /* renamed from: d  reason: collision with root package name */
    public int f44772d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.a.e2.a f44773e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44774e;

        public a(String str) {
            this.f44774e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.f44773e != null) {
                b.this.f44773e.a(this.f44774e);
            }
            Rect rect = new Rect();
            b.this.f44771c.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (b.this.f44772d == b.this.f44769a) {
                b.this.f44772d = height;
            } else if (b.this.f44772d == height) {
            } else {
                if (b.this.f44772d - height > b.this.f44770b) {
                    if (b.this.f44773e != null) {
                        b.this.f44773e.c(this.f44774e, b.this.f44772d - height);
                    }
                    b.this.f44772d = height;
                } else if (height - b.this.f44772d > b.this.f44770b) {
                    if (b.this.f44773e != null) {
                        b.this.f44773e.b(this.f44774e, height - b.this.f44772d);
                    }
                    b.this.f44772d = height;
                }
            }
        }
    }

    public b(String str, Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f44771c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(str));
    }

    public static void g(String str, Activity activity, d.b.g0.a.e2.a aVar) {
        new b(str, activity).h(aVar);
    }

    public final void h(d.b.g0.a.e2.a aVar) {
        this.f44773e = aVar;
    }
}
