package d.b.h0.a.e2;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f45098a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f45099b = 200;

    /* renamed from: c  reason: collision with root package name */
    public View f45100c;

    /* renamed from: d  reason: collision with root package name */
    public int f45101d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.a.e2.a f45102e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45103e;

        public a(String str) {
            this.f45103e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.f45102e != null) {
                b.this.f45102e.a(this.f45103e);
            }
            Rect rect = new Rect();
            b.this.f45100c.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (b.this.f45101d == b.this.f45098a) {
                b.this.f45101d = height;
            } else if (b.this.f45101d == height) {
            } else {
                if (b.this.f45101d - height > b.this.f45099b) {
                    if (b.this.f45102e != null) {
                        b.this.f45102e.c(this.f45103e, b.this.f45101d - height);
                    }
                    b.this.f45101d = height;
                } else if (height - b.this.f45101d > b.this.f45099b) {
                    if (b.this.f45102e != null) {
                        b.this.f45102e.b(this.f45103e, height - b.this.f45101d);
                    }
                    b.this.f45101d = height;
                }
            }
        }
    }

    public b(String str, Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f45100c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(str));
    }

    public static void g(String str, Activity activity, d.b.h0.a.e2.a aVar) {
        new b(str, activity).h(aVar);
    }

    public final void h(d.b.h0.a.e2.a aVar) {
        this.f45102e = aVar;
    }
}
