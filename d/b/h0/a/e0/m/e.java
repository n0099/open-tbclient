package d.b.h0.a.e0.m;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f44812f = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f44813a;

    /* renamed from: b  reason: collision with root package name */
    public View f44814b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f44815c;

    /* renamed from: d  reason: collision with root package name */
    public int f44816d;

    /* renamed from: e  reason: collision with root package name */
    public a f44817e;

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
        this.f44813a = context;
    }

    public void a() {
        if (this.f44814b == null) {
            return;
        }
        Context context = this.f44813a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            b(activity, false);
            ((FrameLayout) activity.getWindow().getDecorView()).removeView(this.f44815c);
            this.f44815c = null;
            this.f44814b = null;
            this.f44817e.onCustomViewHidden();
            activity.setRequestedOrientation(this.f44816d);
        }
    }

    public void b(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    public void c(View view, int i, a aVar) {
        Context context = this.f44813a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f44814b != null) {
                aVar.onCustomViewHidden();
                return;
            }
            this.f44816d = activity.getRequestedOrientation();
            b bVar = new b(activity);
            this.f44815c = bVar;
            bVar.addView(view, f44812f);
            ((FrameLayout) activity.getWindow().getDecorView()).addView(this.f44815c, f44812f);
            this.f44814b = view;
            b(activity, true);
            this.f44817e = aVar;
            activity.setRequestedOrientation(i);
        }
    }
}
