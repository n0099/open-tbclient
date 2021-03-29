package d.b.h0.b1.e;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes3.dex */
public class b extends e implements View.OnTouchListener, GestureDetector.OnGestureListener {
    public float A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public ListView F;
    public d.b.h0.b1.e.a G;
    public int H;
    public GestureDetector.OnGestureListener I;
    public int i;
    public boolean j;
    public int k;
    public boolean l;
    public boolean m;
    public GestureDetector n;
    public GestureDetector o;
    public GestureDetector p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int[] u;
    public int v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements GestureDetector.OnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (!b.this.G.h0() || b.this.G.i0()) {
                return false;
            }
            b.this.onDown(motionEvent);
            b.this.x = (int) motionEvent.getX();
            b.this.y = (int) motionEvent.getY();
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            b.this.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* renamed from: d.b.h0.b1.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1050b extends GestureDetector.SimpleOnGestureListener {
        public C1050b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (b.this.l && b.this.m) {
                int width = b.this.F.getWidth() / 5;
                if (f2 > b.this.A) {
                    if (b.this.H > (-width)) {
                        b.this.G.B0(true, f2);
                    }
                } else if (f2 < (-b.this.A) && b.this.H < width) {
                    b.this.G.B0(true, f2);
                }
                b.this.m = false;
            }
            return false;
        }
    }

    public b(d.b.h0.b1.e.a aVar, ListView listView, int i, int i2, int i3) {
        this(aVar, listView, i, i2, i3, 0);
    }

    @Override // d.b.h0.b1.e.a.j
    public void c(View view, Point point, Point point2) {
        if (this.l && this.m) {
            this.H = point.x;
        }
    }

    public int n(MotionEvent motionEvent) {
        return x(motionEvent, this.B);
    }

    public int o(MotionEvent motionEvent) {
        return x(motionEvent, this.D);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.l && this.k == 0) {
            this.t = x(motionEvent, this.C);
        }
        int v = v(motionEvent);
        this.r = v;
        if (v != -1 && this.i == 0) {
            u(v, ((int) motionEvent.getX()) - this.v, ((int) motionEvent.getY()) - this.w);
        }
        this.m = false;
        this.E = true;
        this.H = 0;
        this.s = w(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.r == -1 || this.i != 2) {
            return;
        }
        this.F.performHapticFeedback(0);
        u(this.r, this.x - this.v, this.y - this.w);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.v;
            int i2 = y2 - this.w;
            if (this.E && !this.z && (this.r != -1 || this.s != -1)) {
                if (this.r != -1) {
                    if (this.i == 1 && Math.abs(y2 - y) > this.q && this.j) {
                        u(this.r, i, i2);
                    } else if (this.i != 0 && Math.abs(x2 - x) > this.q && this.l) {
                        this.m = true;
                        u(this.s, i, i2);
                    }
                } else if (this.s != -1) {
                    if (Math.abs(x2 - x) > this.q && this.l) {
                        this.m = true;
                        u(this.s, i, i2);
                    } else if (Math.abs(y2 - y) > this.q) {
                        this.E = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int i;
        if (this.l && this.k == 0 && (i = this.t) != -1) {
            this.G.m0(i - this.F.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r3 != 3) goto L29;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.G.h0() && !this.G.i0()) {
            this.n.onTouchEvent(motionEvent);
            if (this.l && this.z && this.k == 1) {
                this.p.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action == 1) {
                    if (this.l && this.m) {
                        int i = this.H;
                        if (i < 0) {
                            i = -i;
                        }
                        if (i > this.F.getWidth() / 2) {
                            this.G.B0(true, 0.0f);
                        }
                    }
                }
                this.m = false;
                this.z = false;
            } else {
                this.x = (int) motionEvent.getX();
                this.y = (int) motionEvent.getY();
            }
        }
        return false;
    }

    public GestureDetector p() {
        return this.o;
    }

    public void q(int i) {
        this.i = i;
    }

    public void r(boolean z) {
        this.l = z;
    }

    public void s(int i) {
        this.k = i;
    }

    public void t(boolean z) {
        this.j = z;
    }

    public boolean u(int i, int i2, int i3) {
        int i4 = (!this.j || this.m) ? 0 : 12;
        if (this.l && this.m) {
            i4 = i4 | 1 | 2;
        }
        boolean x0 = this.G.x0(i - this.F.getHeaderViewsCount(), i4, i2, i3);
        this.z = x0;
        return x0;
    }

    public int v(MotionEvent motionEvent) {
        return n(motionEvent);
    }

    public int w(MotionEvent motionEvent) {
        if (this.k == 1) {
            return o(motionEvent);
        }
        return -1;
    }

    public int x(MotionEvent motionEvent, int i) {
        int pointToPosition = this.F.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.F.getHeaderViewsCount();
        int footerViewsCount = this.F.getFooterViewsCount();
        int count = this.F.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            ListView listView = this.F;
            View childAt = listView.getChildAt(pointToPosition - listView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.u);
                int[] iArr = this.u;
                if (rawX > iArr[0] && rawY > iArr[1] && rawX < iArr[0] + findViewById.getWidth() && rawY < this.u[1] + findViewById.getHeight()) {
                    this.v = childAt.getLeft();
                    this.w = childAt.getTop();
                    return pointToPosition;
                }
            }
        }
        return -1;
    }

    public b(d.b.h0.b1.e.a aVar, ListView listView, int i, int i2, int i3, int i4) {
        this(aVar, listView, i, i2, i3, i4, 0);
    }

    public b(d.b.h0.b1.e.a aVar, ListView listView, int i, int i2, int i3, int i4, int i5) {
        super(listView);
        this.i = 0;
        this.j = true;
        this.l = false;
        this.m = false;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = new int[2];
        this.z = false;
        this.A = 500.0f;
        this.I = new C1050b();
        this.G = aVar;
        this.F = listView;
        this.n = new GestureDetector(listView.getContext(), this);
        this.o = new GestureDetector(listView.getContext(), new a());
        GestureDetector gestureDetector = new GestureDetector(listView.getContext(), this.I);
        this.p = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.q = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.B = i;
        this.C = i4;
        this.D = i5;
        s(i3);
        q(i2);
    }
}
