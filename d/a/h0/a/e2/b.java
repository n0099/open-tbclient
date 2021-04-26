package d.a.h0.a.e2;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f42408a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f42409b = 200;

    /* renamed from: c  reason: collision with root package name */
    public View f42410c;

    /* renamed from: d  reason: collision with root package name */
    public int f42411d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.a.e2.a f42412e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42413e;

        public a(String str) {
            this.f42413e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.f42412e != null) {
                b.this.f42412e.c(this.f42413e);
            }
            Rect rect = new Rect();
            b.this.f42410c.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (b.this.f42411d == b.this.f42408a) {
                b.this.f42411d = height;
            } else if (b.this.f42411d == height) {
            } else {
                if (b.this.f42411d - height > b.this.f42409b) {
                    if (b.this.f42412e != null) {
                        b.this.f42412e.b(this.f42413e, b.this.f42411d - height);
                    }
                    b.this.f42411d = height;
                } else if (height - b.this.f42411d > b.this.f42409b) {
                    if (b.this.f42412e != null) {
                        b.this.f42412e.a(this.f42413e, height - b.this.f42411d);
                    }
                    b.this.f42411d = height;
                }
            }
        }
    }

    public b(String str, Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f42410c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(str));
    }

    public static void g(String str, Activity activity, d.a.h0.a.e2.a aVar) {
        new b(str, activity).h(aVar);
    }

    public final void h(d.a.h0.a.e2.a aVar) {
        this.f42412e = aVar;
    }
}
