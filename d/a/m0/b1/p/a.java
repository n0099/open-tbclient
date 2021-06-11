package d.a.m0.b1.p;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f52874a;

    /* renamed from: b  reason: collision with root package name */
    public b f52875b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f52876c;

    /* renamed from: d  reason: collision with root package name */
    public float f52877d;

    /* renamed from: e  reason: collision with root package name */
    public float f52878e;

    /* renamed from: f  reason: collision with root package name */
    public long f52879f;

    /* renamed from: g  reason: collision with root package name */
    public long f52880g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52881h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52882i;
    public int j;
    public int k;
    public int l;

    /* renamed from: d.a.m0.b1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1171a implements Runnable {
        public RunnableC1171a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f52882i || !a.this.f52881h || a.this.f52875b == null) {
                return;
            }
            a.this.f52875b.m();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void O(float f2, float f3);

        void k();

        void m();
    }

    public a(View view) {
        this.f52874a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        b bVar;
        if (this.f52876c == null) {
            this.f52876c = VelocityTracker.obtain();
        }
        this.f52876c.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f52877d = motionEvent.getX();
            this.f52878e = motionEvent.getY();
            this.f52879f = System.currentTimeMillis();
            this.f52881h = true;
        } else if (action == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f52879f < 100 && currentTimeMillis - this.f52880g < 500) {
                this.f52882i = true;
            } else {
                this.f52882i = false;
            }
            VelocityTracker velocityTracker = this.f52876c;
            velocityTracker.computeCurrentVelocity(1000, this.k);
            if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f52878e - motionEvent.getY()) > 50.0f) {
                this.f52882i = false;
                this.f52881h = false;
            }
            if (this.f52882i) {
                b bVar2 = this.f52875b;
                if (bVar2 != null) {
                    bVar2.O(motionEvent.getRawX(), motionEvent.getRawY());
                }
            } else if (Math.abs(this.f52877d - motionEvent.getX()) > this.l && (this.f52877d - motionEvent.getX()) - 50.0f > Math.abs(this.f52878e - motionEvent.getY()) && (bVar = this.f52875b) != null) {
                bVar.k();
            }
            if (!this.f52882i && this.f52881h && Math.abs(this.f52877d - motionEvent.getX()) < 30.0f && Math.abs(this.f52878e - motionEvent.getY()) < 30.0f) {
                this.f52874a.postDelayed(new RunnableC1171a(), 300L);
            }
            this.f52880g = currentTimeMillis;
            e();
        } else if (action == 3) {
            e();
        }
        return true;
    }

    public final void e() {
        VelocityTracker velocityTracker = this.f52876c;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f52876c.recycle();
            this.f52876c = null;
        }
    }

    public void f(b bVar) {
        this.f52875b = bVar;
    }
}
