package d.b.g0.a.e0.m;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f44483f = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f44484a;

    /* renamed from: b  reason: collision with root package name */
    public View f44485b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f44486c;

    /* renamed from: d  reason: collision with root package name */
    public int f44487d;

    /* renamed from: e  reason: collision with root package name */
    public a f44488e;

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
        this.f44484a = context;
    }

    public void a() {
        if (this.f44485b == null) {
            return;
        }
        Context context = this.f44484a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            b(activity, false);
            ((FrameLayout) activity.getWindow().getDecorView()).removeView(this.f44486c);
            this.f44486c = null;
            this.f44485b = null;
            this.f44488e.onCustomViewHidden();
            activity.setRequestedOrientation(this.f44487d);
        }
    }

    public void b(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    public void c(View view, int i, a aVar) {
        Context context = this.f44484a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f44485b != null) {
                aVar.onCustomViewHidden();
                return;
            }
            this.f44487d = activity.getRequestedOrientation();
            b bVar = new b(activity);
            this.f44486c = bVar;
            bVar.addView(view, f44483f);
            ((FrameLayout) activity.getWindow().getDecorView()).addView(this.f44486c, f44483f);
            this.f44485b = view;
            b(activity, true);
            this.f44488e = aVar;
            activity.setRequestedOrientation(i);
        }
    }
}
