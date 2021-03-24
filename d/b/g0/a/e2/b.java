package d.b.g0.a.e2;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f44376a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f44377b = 200;

    /* renamed from: c  reason: collision with root package name */
    public View f44378c;

    /* renamed from: d  reason: collision with root package name */
    public int f44379d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.a.e2.a f44380e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44381e;

        public a(String str) {
            this.f44381e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.f44380e != null) {
                b.this.f44380e.a(this.f44381e);
            }
            Rect rect = new Rect();
            b.this.f44378c.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (b.this.f44379d == b.this.f44376a) {
                b.this.f44379d = height;
            } else if (b.this.f44379d == height) {
            } else {
                if (b.this.f44379d - height > b.this.f44377b) {
                    if (b.this.f44380e != null) {
                        b.this.f44380e.c(this.f44381e, b.this.f44379d - height);
                    }
                    b.this.f44379d = height;
                } else if (height - b.this.f44379d > b.this.f44377b) {
                    if (b.this.f44380e != null) {
                        b.this.f44380e.b(this.f44381e, height - b.this.f44379d);
                    }
                    b.this.f44379d = height;
                }
            }
        }
    }

    public b(String str, Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f44378c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(str));
    }

    public static void g(String str, Activity activity, d.b.g0.a.e2.a aVar) {
        new b(str, activity).h(aVar);
    }

    public final void h(d.b.g0.a.e2.a aVar) {
        this.f44380e = aVar;
    }
}
