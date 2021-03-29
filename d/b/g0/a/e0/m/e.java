package d.b.g0.a.e0.m;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f44091f = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f44092a;

    /* renamed from: b  reason: collision with root package name */
    public View f44093b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f44094c;

    /* renamed from: d  reason: collision with root package name */
    public int f44095d;

    /* renamed from: e  reason: collision with root package name */
    public a f44096e;

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
        this.f44092a = context;
    }

    public void a() {
        if (this.f44093b == null) {
            return;
        }
        Context context = this.f44092a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            b(activity, false);
            ((FrameLayout) activity.getWindow().getDecorView()).removeView(this.f44094c);
            this.f44094c = null;
            this.f44093b = null;
            this.f44096e.onCustomViewHidden();
            activity.setRequestedOrientation(this.f44095d);
        }
    }

    public void b(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    public void c(View view, int i, a aVar) {
        Context context = this.f44092a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f44093b != null) {
                aVar.onCustomViewHidden();
                return;
            }
            this.f44095d = activity.getRequestedOrientation();
            b bVar = new b(activity);
            this.f44094c = bVar;
            bVar.addView(view, f44091f);
            ((FrameLayout) activity.getWindow().getDecorView()).addView(this.f44094c, f44091f);
            this.f44093b = view;
            b(activity, true);
            this.f44096e = aVar;
            activity.setRequestedOrientation(i);
        }
    }
}
