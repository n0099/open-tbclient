package d.b.h0.b1.p;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f50047a;

    /* renamed from: b  reason: collision with root package name */
    public b f50048b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f50049c;

    /* renamed from: d  reason: collision with root package name */
    public float f50050d;

    /* renamed from: e  reason: collision with root package name */
    public float f50051e;

    /* renamed from: f  reason: collision with root package name */
    public long f50052f;

    /* renamed from: g  reason: collision with root package name */
    public long f50053g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50054h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    /* renamed from: d.b.h0.b1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1059a implements Runnable {
        public RunnableC1059a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.i || !a.this.f50054h || a.this.f50048b == null) {
                return;
            }
            a.this.f50048b.k();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void k();

        void l();

        void r0(float f2, float f3);
    }

    public a(View view) {
        this.f50047a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        b bVar;
        if (this.f50049c == null) {
            this.f50049c = VelocityTracker.obtain();
        }
        this.f50049c.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f50050d = motionEvent.getX();
            this.f50051e = motionEvent.getY();
            this.f50052f = System.currentTimeMillis();
            this.f50054h = true;
        } else if (action == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f50052f < 100 && currentTimeMillis - this.f50053g < 500) {
                this.i = true;
            } else {
                this.i = false;
            }
            VelocityTracker velocityTracker = this.f50049c;
            velocityTracker.computeCurrentVelocity(1000, this.k);
            if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f50051e - motionEvent.getY()) > 50.0f) {
                this.i = false;
                this.f50054h = false;
            }
            if (this.i) {
                b bVar2 = this.f50048b;
                if (bVar2 != null) {
                    bVar2.r0(motionEvent.getRawX(), motionEvent.getRawY());
                }
            } else if (Math.abs(this.f50050d - motionEvent.getX()) > this.l && (this.f50050d - motionEvent.getX()) - 50.0f > Math.abs(this.f50051e - motionEvent.getY()) && (bVar = this.f50048b) != null) {
                bVar.l();
            }
            if (!this.i && this.f50054h && Math.abs(this.f50050d - motionEvent.getX()) < 30.0f && Math.abs(this.f50051e - motionEvent.getY()) < 30.0f) {
                this.f50047a.postDelayed(new RunnableC1059a(), 300L);
            }
            this.f50053g = currentTimeMillis;
            e();
        } else if (action == 3) {
            e();
        }
        return true;
    }

    public final void e() {
        VelocityTracker velocityTracker = this.f50049c;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f50049c.recycle();
            this.f50049c = null;
        }
    }

    public void f(b bVar) {
        this.f50048b = bVar;
    }
}
