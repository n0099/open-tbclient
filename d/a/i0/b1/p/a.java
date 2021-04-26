package d.a.i0.b1.p;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f48347a;

    /* renamed from: b  reason: collision with root package name */
    public b f48348b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f48349c;

    /* renamed from: d  reason: collision with root package name */
    public float f48350d;

    /* renamed from: e  reason: collision with root package name */
    public float f48351e;

    /* renamed from: f  reason: collision with root package name */
    public long f48352f;

    /* renamed from: g  reason: collision with root package name */
    public long f48353g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48354h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48355i;
    public int j;
    public int k;
    public int l;

    /* renamed from: d.a.i0.b1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1032a implements Runnable {
        public RunnableC1032a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48355i || !a.this.f48354h || a.this.f48348b == null) {
                return;
            }
            a.this.f48348b.l();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void N(float f2, float f3);

        void j();

        void l();
    }

    public a(View view) {
        this.f48347a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        b bVar;
        if (this.f48349c == null) {
            this.f48349c = VelocityTracker.obtain();
        }
        this.f48349c.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f48350d = motionEvent.getX();
            this.f48351e = motionEvent.getY();
            this.f48352f = System.currentTimeMillis();
            this.f48354h = true;
        } else if (action == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f48352f < 100 && currentTimeMillis - this.f48353g < 500) {
                this.f48355i = true;
            } else {
                this.f48355i = false;
            }
            VelocityTracker velocityTracker = this.f48349c;
            velocityTracker.computeCurrentVelocity(1000, this.k);
            if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f48351e - motionEvent.getY()) > 50.0f) {
                this.f48355i = false;
                this.f48354h = false;
            }
            if (this.f48355i) {
                b bVar2 = this.f48348b;
                if (bVar2 != null) {
                    bVar2.N(motionEvent.getRawX(), motionEvent.getRawY());
                }
            } else if (Math.abs(this.f48350d - motionEvent.getX()) > this.l && (this.f48350d - motionEvent.getX()) - 50.0f > Math.abs(this.f48351e - motionEvent.getY()) && (bVar = this.f48348b) != null) {
                bVar.j();
            }
            if (!this.f48355i && this.f48354h && Math.abs(this.f48350d - motionEvent.getX()) < 30.0f && Math.abs(this.f48351e - motionEvent.getY()) < 30.0f) {
                this.f48347a.postDelayed(new RunnableC1032a(), 300L);
            }
            this.f48353g = currentTimeMillis;
            e();
        } else if (action == 3) {
            e();
        }
        return true;
    }

    public final void e() {
        VelocityTracker velocityTracker = this.f48349c;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f48349c.recycle();
            this.f48349c = null;
        }
    }

    public void f(b bVar) {
        this.f48348b = bVar;
    }
}
