package d.b.h0.b1.p;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f50046a;

    /* renamed from: b  reason: collision with root package name */
    public b f50047b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f50048c;

    /* renamed from: d  reason: collision with root package name */
    public float f50049d;

    /* renamed from: e  reason: collision with root package name */
    public float f50050e;

    /* renamed from: f  reason: collision with root package name */
    public long f50051f;

    /* renamed from: g  reason: collision with root package name */
    public long f50052g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50053h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    /* renamed from: d.b.h0.b1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1058a implements Runnable {
        public RunnableC1058a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.i || !a.this.f50053h || a.this.f50047b == null) {
                return;
            }
            a.this.f50047b.k();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void k();

        void l();

        void r0(float f2, float f3);
    }

    public a(View view) {
        this.f50046a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        b bVar;
        if (this.f50048c == null) {
            this.f50048c = VelocityTracker.obtain();
        }
        this.f50048c.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f50049d = motionEvent.getX();
            this.f50050e = motionEvent.getY();
            this.f50051f = System.currentTimeMillis();
            this.f50053h = true;
        } else if (action == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f50051f < 100 && currentTimeMillis - this.f50052g < 500) {
                this.i = true;
            } else {
                this.i = false;
            }
            VelocityTracker velocityTracker = this.f50048c;
            velocityTracker.computeCurrentVelocity(1000, this.k);
            if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f50050e - motionEvent.getY()) > 50.0f) {
                this.i = false;
                this.f50053h = false;
            }
            if (this.i) {
                b bVar2 = this.f50047b;
                if (bVar2 != null) {
                    bVar2.r0(motionEvent.getRawX(), motionEvent.getRawY());
                }
            } else if (Math.abs(this.f50049d - motionEvent.getX()) > this.l && (this.f50049d - motionEvent.getX()) - 50.0f > Math.abs(this.f50050e - motionEvent.getY()) && (bVar = this.f50047b) != null) {
                bVar.l();
            }
            if (!this.i && this.f50053h && Math.abs(this.f50049d - motionEvent.getX()) < 30.0f && Math.abs(this.f50050e - motionEvent.getY()) < 30.0f) {
                this.f50046a.postDelayed(new RunnableC1058a(), 300L);
            }
            this.f50052g = currentTimeMillis;
            e();
        } else if (action == 3) {
            e();
        }
        return true;
    }

    public final void e() {
        VelocityTracker velocityTracker = this.f50048c;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f50048c.recycle();
            this.f50048c = null;
        }
    }

    public void f(b bVar) {
        this.f50047b = bVar;
    }
}
