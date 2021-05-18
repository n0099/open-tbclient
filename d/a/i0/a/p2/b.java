package d.a.i0.a.p2;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f43937a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f43938b = 200;

    /* renamed from: c  reason: collision with root package name */
    public View f43939c;

    /* renamed from: d  reason: collision with root package name */
    public int f43940d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.p2.a f43941e;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43942e;

        public a(String str) {
            this.f43942e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.f43941e != null) {
                b.this.f43941e.c(this.f43942e);
            }
            Rect rect = new Rect();
            b.this.f43939c.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (b.this.f43940d == b.this.f43937a) {
                b.this.f43940d = height;
            } else if (b.this.f43940d == height) {
            } else {
                if (b.this.f43940d - height > b.this.f43938b) {
                    if (b.this.f43941e != null) {
                        b.this.f43941e.b(this.f43942e, b.this.f43940d - height);
                    }
                    b.this.f43940d = height;
                } else if (height - b.this.f43940d > b.this.f43938b) {
                    if (b.this.f43941e != null) {
                        b.this.f43941e.a(this.f43942e, height - b.this.f43940d);
                    }
                    b.this.f43940d = height;
                }
            }
        }
    }

    public b(String str, Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f43939c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(str));
    }

    public static void g(String str, Activity activity, d.a.i0.a.p2.a aVar) {
        new b(str, activity).h(aVar);
    }

    public final void h(d.a.i0.a.p2.a aVar) {
        this.f43941e = aVar;
    }
}
