package d.a.h0.a.e0.m;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f42111f = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f42112a;

    /* renamed from: b  reason: collision with root package name */
    public View f42113b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f42114c;

    /* renamed from: d  reason: collision with root package name */
    public int f42115d;

    /* renamed from: e  reason: collision with root package name */
    public a f42116e;

    /* loaded from: classes2.dex */
    public interface a {
        void onCustomViewHidden();
    }

    /* loaded from: classes2.dex */
    public static class b extends FrameLayout {
        public b(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    public e(Context context) {
        this.f42112a = context;
    }

    public void a() {
        if (this.f42113b == null) {
            return;
        }
        Context context = this.f42112a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            b(activity, false);
            ((FrameLayout) activity.getWindow().getDecorView()).removeView(this.f42114c);
            this.f42114c = null;
            this.f42113b = null;
            this.f42116e.onCustomViewHidden();
            activity.setRequestedOrientation(this.f42115d);
        }
    }

    public void b(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    public void c(View view, int i2, a aVar) {
        Context context = this.f42112a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f42113b != null) {
                aVar.onCustomViewHidden();
                return;
            }
            this.f42115d = activity.getRequestedOrientation();
            b bVar = new b(activity);
            this.f42114c = bVar;
            bVar.addView(view, f42111f);
            ((FrameLayout) activity.getWindow().getDecorView()).addView(this.f42114c, f42111f);
            this.f42113b = view;
            b(activity, true);
            this.f42116e = aVar;
            activity.setRequestedOrientation(i2);
        }
    }
}
