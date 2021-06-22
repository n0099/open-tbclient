package d.a.n0.b1.p;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f52981a;

    /* renamed from: b  reason: collision with root package name */
    public b f52982b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f52983c;

    /* renamed from: d  reason: collision with root package name */
    public float f52984d;

    /* renamed from: e  reason: collision with root package name */
    public float f52985e;

    /* renamed from: f  reason: collision with root package name */
    public long f52986f;

    /* renamed from: g  reason: collision with root package name */
    public long f52987g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52988h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52989i;
    public int j;
    public int k;
    public int l;

    /* renamed from: d.a.n0.b1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1174a implements Runnable {
        public RunnableC1174a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f52989i || !a.this.f52988h || a.this.f52982b == null) {
                return;
            }
            a.this.f52982b.m();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void O(float f2, float f3);

        void k();

        void m();
    }

    public a(View view) {
        this.f52981a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        b bVar;
        if (this.f52983c == null) {
            this.f52983c = VelocityTracker.obtain();
        }
        this.f52983c.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f52984d = motionEvent.getX();
            this.f52985e = motionEvent.getY();
            this.f52986f = System.currentTimeMillis();
            this.f52988h = true;
        } else if (action == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f52986f < 100 && currentTimeMillis - this.f52987g < 500) {
                this.f52989i = true;
            } else {
                this.f52989i = false;
            }
            VelocityTracker velocityTracker = this.f52983c;
            velocityTracker.computeCurrentVelocity(1000, this.k);
            if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f52985e - motionEvent.getY()) > 50.0f) {
                this.f52989i = false;
                this.f52988h = false;
            }
            if (this.f52989i) {
                b bVar2 = this.f52982b;
                if (bVar2 != null) {
                    bVar2.O(motionEvent.getRawX(), motionEvent.getRawY());
                }
            } else if (Math.abs(this.f52984d - motionEvent.getX()) > this.l && (this.f52984d - motionEvent.getX()) - 50.0f > Math.abs(this.f52985e - motionEvent.getY()) && (bVar = this.f52982b) != null) {
                bVar.k();
            }
            if (!this.f52989i && this.f52988h && Math.abs(this.f52984d - motionEvent.getX()) < 30.0f && Math.abs(this.f52985e - motionEvent.getY()) < 30.0f) {
                this.f52981a.postDelayed(new RunnableC1174a(), 300L);
            }
            this.f52987g = currentTimeMillis;
            e();
        } else if (action == 3) {
            e();
        }
        return true;
    }

    public final void e() {
        VelocityTracker velocityTracker = this.f52983c;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f52983c.recycle();
            this.f52983c = null;
        }
    }

    public void f(b bVar) {
        this.f52982b = bVar;
    }
}
