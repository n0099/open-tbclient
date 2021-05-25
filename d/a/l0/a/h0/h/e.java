package d.a.l0.a.h0.h;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f42149f = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f42150a;

    /* renamed from: b  reason: collision with root package name */
    public View f42151b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f42152c;

    /* renamed from: d  reason: collision with root package name */
    public int f42153d;

    /* renamed from: e  reason: collision with root package name */
    public a f42154e;

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
        this.f42150a = context;
    }

    public void a() {
        if (this.f42151b == null) {
            return;
        }
        Context context = this.f42150a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            b(activity, false);
            ((FrameLayout) activity.getWindow().getDecorView()).removeView(this.f42152c);
            this.f42152c = null;
            this.f42151b = null;
            this.f42154e.onCustomViewHidden();
            activity.setRequestedOrientation(this.f42153d);
        }
    }

    public void b(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    public void c(View view, int i2, a aVar) {
        Context context = this.f42150a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f42151b != null) {
                aVar.onCustomViewHidden();
                return;
            }
            this.f42153d = activity.getRequestedOrientation();
            b bVar = new b(activity);
            this.f42152c = bVar;
            bVar.addView(view, f42149f);
            ((FrameLayout) activity.getWindow().getDecorView()).addView(this.f42152c, f42149f);
            this.f42151b = view;
            b(activity, true);
            this.f42154e = aVar;
            activity.setRequestedOrientation(i2);
        }
    }
}
