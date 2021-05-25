package d.a.m0.b1.p;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f49200a;

    /* renamed from: b  reason: collision with root package name */
    public b f49201b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f49202c;

    /* renamed from: d  reason: collision with root package name */
    public float f49203d;

    /* renamed from: e  reason: collision with root package name */
    public float f49204e;

    /* renamed from: f  reason: collision with root package name */
    public long f49205f;

    /* renamed from: g  reason: collision with root package name */
    public long f49206g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49207h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49208i;
    public int j;
    public int k;
    public int l;

    /* renamed from: d.a.m0.b1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1115a implements Runnable {
        public RunnableC1115a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49208i || !a.this.f49207h || a.this.f49201b == null) {
                return;
            }
            a.this.f49201b.l();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void N(float f2, float f3);

        void j();

        void l();
    }

    public a(View view) {
        this.f49200a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        b bVar;
        if (this.f49202c == null) {
            this.f49202c = VelocityTracker.obtain();
        }
        this.f49202c.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f49203d = motionEvent.getX();
            this.f49204e = motionEvent.getY();
            this.f49205f = System.currentTimeMillis();
            this.f49207h = true;
        } else if (action == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f49205f < 100 && currentTimeMillis - this.f49206g < 500) {
                this.f49208i = true;
            } else {
                this.f49208i = false;
            }
            VelocityTracker velocityTracker = this.f49202c;
            velocityTracker.computeCurrentVelocity(1000, this.k);
            if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f49204e - motionEvent.getY()) > 50.0f) {
                this.f49208i = false;
                this.f49207h = false;
            }
            if (this.f49208i) {
                b bVar2 = this.f49201b;
                if (bVar2 != null) {
                    bVar2.N(motionEvent.getRawX(), motionEvent.getRawY());
                }
            } else if (Math.abs(this.f49203d - motionEvent.getX()) > this.l && (this.f49203d - motionEvent.getX()) - 50.0f > Math.abs(this.f49204e - motionEvent.getY()) && (bVar = this.f49201b) != null) {
                bVar.j();
            }
            if (!this.f49208i && this.f49207h && Math.abs(this.f49203d - motionEvent.getX()) < 30.0f && Math.abs(this.f49204e - motionEvent.getY()) < 30.0f) {
                this.f49200a.postDelayed(new RunnableC1115a(), 300L);
            }
            this.f49206g = currentTimeMillis;
            e();
        } else if (action == 3) {
            e();
        }
        return true;
    }

    public final void e() {
        VelocityTracker velocityTracker = this.f49202c;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f49202c.recycle();
            this.f49202c = null;
        }
    }

    public void f(b bVar) {
        this.f49201b = bVar;
    }
}
