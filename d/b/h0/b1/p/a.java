package d.b.h0.b1.p;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f50440a;

    /* renamed from: b  reason: collision with root package name */
    public b f50441b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f50442c;

    /* renamed from: d  reason: collision with root package name */
    public float f50443d;

    /* renamed from: e  reason: collision with root package name */
    public float f50444e;

    /* renamed from: f  reason: collision with root package name */
    public long f50445f;

    /* renamed from: g  reason: collision with root package name */
    public long f50446g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50447h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    /* renamed from: d.b.h0.b1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1071a implements Runnable {
        public RunnableC1071a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.i || !a.this.f50447h || a.this.f50441b == null) {
                return;
            }
            a.this.f50441b.k();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void k();

        void l();

        void r0(float f2, float f3);
    }

    public a(View view) {
        this.f50440a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        b bVar;
        if (this.f50442c == null) {
            this.f50442c = VelocityTracker.obtain();
        }
        this.f50442c.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f50443d = motionEvent.getX();
            this.f50444e = motionEvent.getY();
            this.f50445f = System.currentTimeMillis();
            this.f50447h = true;
        } else if (action == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f50445f < 100 && currentTimeMillis - this.f50446g < 500) {
                this.i = true;
            } else {
                this.i = false;
            }
            VelocityTracker velocityTracker = this.f50442c;
            velocityTracker.computeCurrentVelocity(1000, this.k);
            if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f50444e - motionEvent.getY()) > 50.0f) {
                this.i = false;
                this.f50447h = false;
            }
            if (this.i) {
                b bVar2 = this.f50441b;
                if (bVar2 != null) {
                    bVar2.r0(motionEvent.getRawX(), motionEvent.getRawY());
                }
            } else if (Math.abs(this.f50443d - motionEvent.getX()) > this.l && (this.f50443d - motionEvent.getX()) - 50.0f > Math.abs(this.f50444e - motionEvent.getY()) && (bVar = this.f50441b) != null) {
                bVar.l();
            }
            if (!this.i && this.f50447h && Math.abs(this.f50443d - motionEvent.getX()) < 30.0f && Math.abs(this.f50444e - motionEvent.getY()) < 30.0f) {
                this.f50440a.postDelayed(new RunnableC1071a(), 300L);
            }
            this.f50446g = currentTimeMillis;
            e();
        } else if (action == 3) {
            e();
        }
        return true;
    }

    public final void e() {
        VelocityTracker velocityTracker = this.f50442c;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f50442c.recycle();
            this.f50442c = null;
        }
    }

    public void f(b bVar) {
        this.f50441b = bVar;
    }
}
