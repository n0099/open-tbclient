package d.a.l0.a.p2;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f44113a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f44114b = 200;

    /* renamed from: c  reason: collision with root package name */
    public View f44115c;

    /* renamed from: d  reason: collision with root package name */
    public int f44116d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.p2.a f44117e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44118e;

        public a(String str) {
            this.f44118e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.f44117e != null) {
                b.this.f44117e.c(this.f44118e);
            }
            Rect rect = new Rect();
            b.this.f44115c.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (b.this.f44116d == b.this.f44113a) {
                b.this.f44116d = height;
            } else if (b.this.f44116d == height) {
            } else {
                if (b.this.f44116d - height > b.this.f44114b) {
                    if (b.this.f44117e != null) {
                        b.this.f44117e.b(this.f44118e, b.this.f44116d - height);
                    }
                    b.this.f44116d = height;
                } else if (height - b.this.f44116d > b.this.f44114b) {
                    if (b.this.f44117e != null) {
                        b.this.f44117e.a(this.f44118e, height - b.this.f44116d);
                    }
                    b.this.f44116d = height;
                }
            }
        }
    }

    public b(String str, Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f44115c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(str));
    }

    public static void g(String str, Activity activity, d.a.l0.a.p2.a aVar) {
        new b(str, activity).h(aVar);
    }

    public final void h(d.a.l0.a.p2.a aVar) {
        this.f44117e = aVar;
    }
}
