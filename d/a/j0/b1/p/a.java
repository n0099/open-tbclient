package d.a.j0.b1.p;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f49175a;

    /* renamed from: b  reason: collision with root package name */
    public b f49176b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f49177c;

    /* renamed from: d  reason: collision with root package name */
    public float f49178d;

    /* renamed from: e  reason: collision with root package name */
    public float f49179e;

    /* renamed from: f  reason: collision with root package name */
    public long f49180f;

    /* renamed from: g  reason: collision with root package name */
    public long f49181g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49182h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49183i;
    public int j;
    public int k;
    public int l;

    /* renamed from: d.a.j0.b1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1108a implements Runnable {
        public RunnableC1108a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49183i || !a.this.f49182h || a.this.f49176b == null) {
                return;
            }
            a.this.f49176b.l();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void N(float f2, float f3);

        void j();

        void l();
    }

    public a(View view) {
        this.f49175a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        b bVar;
        if (this.f49177c == null) {
            this.f49177c = VelocityTracker.obtain();
        }
        this.f49177c.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f49178d = motionEvent.getX();
            this.f49179e = motionEvent.getY();
            this.f49180f = System.currentTimeMillis();
            this.f49182h = true;
        } else if (action == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f49180f < 100 && currentTimeMillis - this.f49181g < 500) {
                this.f49183i = true;
            } else {
                this.f49183i = false;
            }
            VelocityTracker velocityTracker = this.f49177c;
            velocityTracker.computeCurrentVelocity(1000, this.k);
            if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f49179e - motionEvent.getY()) > 50.0f) {
                this.f49183i = false;
                this.f49182h = false;
            }
            if (this.f49183i) {
                b bVar2 = this.f49176b;
                if (bVar2 != null) {
                    bVar2.N(motionEvent.getRawX(), motionEvent.getRawY());
                }
            } else if (Math.abs(this.f49178d - motionEvent.getX()) > this.l && (this.f49178d - motionEvent.getX()) - 50.0f > Math.abs(this.f49179e - motionEvent.getY()) && (bVar = this.f49176b) != null) {
                bVar.j();
            }
            if (!this.f49183i && this.f49182h && Math.abs(this.f49178d - motionEvent.getX()) < 30.0f && Math.abs(this.f49179e - motionEvent.getY()) < 30.0f) {
                this.f49175a.postDelayed(new RunnableC1108a(), 300L);
            }
            this.f49181g = currentTimeMillis;
            e();
        } else if (action == 3) {
            e();
        }
        return true;
    }

    public final void e() {
        VelocityTracker velocityTracker = this.f49177c;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f49177c.recycle();
            this.f49177c = null;
        }
    }

    public void f(b bVar) {
        this.f49176b = bVar;
    }
}
