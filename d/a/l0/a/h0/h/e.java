package d.a.l0.a.h0.h;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f45825f = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f45826a;

    /* renamed from: b  reason: collision with root package name */
    public View f45827b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f45828c;

    /* renamed from: d  reason: collision with root package name */
    public int f45829d;

    /* renamed from: e  reason: collision with root package name */
    public a f45830e;

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
        this.f45826a = context;
    }

    public void a() {
        if (this.f45827b == null) {
            return;
        }
        Context context = this.f45826a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            b(activity, false);
            ((FrameLayout) activity.getWindow().getDecorView()).removeView(this.f45828c);
            this.f45828c = null;
            this.f45827b = null;
            this.f45830e.onCustomViewHidden();
            activity.setRequestedOrientation(this.f45829d);
        }
    }

    public void b(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    public void c(View view, int i2, a aVar) {
        Context context = this.f45826a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f45827b != null) {
                aVar.onCustomViewHidden();
                return;
            }
            this.f45829d = activity.getRequestedOrientation();
            b bVar = new b(activity);
            this.f45828c = bVar;
            bVar.addView(view, f45825f);
            ((FrameLayout) activity.getWindow().getDecorView()).addView(this.f45828c, f45825f);
            this.f45827b = view;
            b(activity, true);
            this.f45830e = aVar;
            activity.setRequestedOrientation(i2);
        }
    }
}
