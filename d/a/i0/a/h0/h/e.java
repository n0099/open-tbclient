package d.a.i0.a.h0.h;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f41975f = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f41976a;

    /* renamed from: b  reason: collision with root package name */
    public View f41977b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f41978c;

    /* renamed from: d  reason: collision with root package name */
    public int f41979d;

    /* renamed from: e  reason: collision with root package name */
    public a f41980e;

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
        this.f41976a = context;
    }

    public void a() {
        if (this.f41977b == null) {
            return;
        }
        Context context = this.f41976a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            b(activity, false);
            ((FrameLayout) activity.getWindow().getDecorView()).removeView(this.f41978c);
            this.f41978c = null;
            this.f41977b = null;
            this.f41980e.onCustomViewHidden();
            activity.setRequestedOrientation(this.f41979d);
        }
    }

    public void b(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    public void c(View view, int i2, a aVar) {
        Context context = this.f41976a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f41977b != null) {
                aVar.onCustomViewHidden();
                return;
            }
            this.f41979d = activity.getRequestedOrientation();
            b bVar = new b(activity);
            this.f41978c = bVar;
            bVar.addView(view, f41975f);
            ((FrameLayout) activity.getWindow().getDecorView()).addView(this.f41978c, f41975f);
            this.f41977b = view;
            b(activity, true);
            this.f41980e = aVar;
            activity.setRequestedOrientation(i2);
        }
    }
}
