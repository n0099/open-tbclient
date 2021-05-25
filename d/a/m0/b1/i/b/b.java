package d.a.m0.b1.i.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import d.a.c.e.p.l;
import d.a.m0.b1.i.a.a;
import d.a.m0.b1.i.c.c;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements d.a.m0.b1.i.b.a {
    public static final int z = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* renamed from: a  reason: collision with root package name */
    public final Context f49046a;

    /* renamed from: b  reason: collision with root package name */
    public final View f49047b;

    /* renamed from: c  reason: collision with root package name */
    public GestureDetector f49048c;

    /* renamed from: d  reason: collision with root package name */
    public ScaleGestureDetector f49049d;

    /* renamed from: e  reason: collision with root package name */
    public BitmapRegionDecoder f49050e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.b1.i.a.b f49051f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.b1.i.c.a f49052g;

    /* renamed from: h  reason: collision with root package name */
    public float f49053h;

    /* renamed from: i  reason: collision with root package name */
    public float f49054i;
    public Bitmap l;
    public int m;
    public c n;
    public d.a.m0.b1.i.c.c o;
    public View.OnClickListener q;
    public View.OnLongClickListener r;
    public d.a.m0.b1.i.b.a t;
    public ValueAnimator u;
    public float j = 2.0f;
    public float k = 1.0f;
    public final Matrix p = new Matrix();
    public Bitmap s = null;
    public boolean v = true;
    public boolean w = false;
    public boolean x = false;
    public BdAsyncTask<String, String, String> y = new C1109b();

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f49055e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f49056f;

        public a(float f2, float f3) {
            this.f49055e = f2;
            this.f49056f = f3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null || !(valueAnimator.getAnimatedValue() instanceof Float)) {
                return;
            }
            b.this.L(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.f49054i, this.f49055e, this.f49056f);
        }
    }

    /* renamed from: d.a.m0.b1.i.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1109b extends BdAsyncTask<String, String, String> {
        public C1109b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            double d2;
            if (b.this.f49051f != null && b.this.f49050e != null) {
                int[] b2 = b.this.f49052g.b();
                int i2 = 1;
                while (true) {
                    d2 = i2;
                    if (Math.max(b2[0] / b.this.f49051f.i(), b2[1] / b.this.f49051f.h()) <= Math.pow(2.0d, d2)) {
                        break;
                    }
                    i2++;
                }
                int pow = (int) Math.pow(2.0d, d2);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, b2[0], b2[1]);
                try {
                    b.this.s = b.this.f49050e.decodeRegion(rect, options);
                } catch (Throwable unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.s = b.this.f49050e.decodeRegion(rect, options);
                    } catch (Throwable unused2) {
                        b.this.s = null;
                    }
                }
                d.a.m0.a0.c.k().d("long_img_mThumb" + System.currentTimeMillis(), new d.a.c.j.d.a(b.this.s, false));
                b bVar = b.this;
                bVar.B(bVar.s, bVar.f49051f, pow);
                b.this.f49051f.t(b.this.s);
                b.this.C();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.t != null) {
                b.this.t.onLoadFinished();
            }
            b.this.u();
            b.this.f49047b.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Scroller {

        /* renamed from: a  reason: collision with root package name */
        public int f49059a;

        /* renamed from: b  reason: collision with root package name */
        public int f49060b;

        public c(b bVar, Context context) {
            super(context);
            this.f49059a = 0;
            this.f49060b = 0;
        }

        public int a() {
            return this.f49059a;
        }

        public int b() {
            return this.f49060b;
        }

        public void c(int i2) {
            this.f49059a = i2;
        }

        public void d(int i2) {
            this.f49060b = i2;
        }

        @Override // android.widget.Scroller
        public void fling(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.f49059a = 0;
            this.f49060b = 0;
            super.fling(i2, i3, i4, i5, i6, i7, i8, i9);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        public d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.U(b.this.f49054i == b.this.j ? b.this.k : b.this.j, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            Rect o = b.this.f49051f.o();
            Rect f4 = b.this.f49051f.f();
            b.this.n.forceFinished(true);
            int i2 = (int) 0.0f;
            b.this.n.fling(i2, i2, (int) f2, (int) f3, o.right - f4.right, o.left - f4.left, o.bottom - f4.bottom, o.top - f4.top);
            b.this.f49047b.invalidate();
            if (Math.abs(f3) > b.z) {
                b.this.x = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.x || b.this.r == null) {
                b.this.x = false;
            } else {
                b.this.r.onLongClick(b.this.f49047b);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            b.this.I((int) f2, (int) f3);
            if (Math.abs(f3) > b.z) {
                b.this.x = true;
            }
            if (b.this.f49047b != null && b.this.f49054i != b.this.k) {
                b.this.f49047b.getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.x || b.this.q == null) {
                b.this.x = false;
            } else {
                b.this.q.onClick(b.this.f49047b);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public e() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            b.this.L(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this();
        }
    }

    public b(View view) {
        this.m = 1;
        this.f49047b = view;
        this.f49046a = view.getContext();
        this.f49048c = new GestureDetector(this.f49046a, new d(this, null));
        this.f49049d = new ScaleGestureDetector(this.f49046a, new e(this, null));
        this.n = new c(this, this.f49046a);
        this.m = 0;
    }

    public final float[] A(float f2, float f3) {
        float[] fArr = new float[2];
        Rect o = this.f49051f.o();
        int[] b2 = this.f49052g.b();
        if (o.top + f3 < 0.0f) {
            f3 = 0.0f;
        }
        int i2 = o.bottom;
        if (i2 + f3 > b2[1]) {
            f3 = (b2[1] - i2) * this.f49054i;
        }
        if (o.bottom - o.top > b2[1]) {
            f3 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f3;
        this.v = f3 == 0.0f;
        boolean z2 = o.bottom == b2[1];
        this.w = z2;
        if (z2) {
            this.v = false;
        }
        return fArr;
    }

    public final void B(Bitmap bitmap, d.a.m0.b1.i.a.b bVar, int i2) {
        float max = Math.max((bVar.i() * 1.0f) / bitmap.getWidth(), (bVar.h() * 1.0f) / bitmap.getHeight());
        this.p.postScale(max, max);
        float f2 = (1.0f / i2) * max;
        this.f49053h = f2;
        this.k = f2;
        this.f49054i = f2;
        this.j = f2 * 2.0f;
        float i3 = (bVar.i() * 1.0f) / this.f49050e.getWidth();
        if (i3 > 1.0f) {
            this.f49053h /= i3;
        }
        bVar.s(1.0f / this.f49054i);
    }

    public final void C() {
        d.a.m0.b1.i.a.b bVar = this.f49051f;
        if (bVar != null) {
            bVar.q(1.0f / this.k);
        }
    }

    public boolean D() {
        Rect o;
        d.a.m0.b1.i.a.b bVar = this.f49051f;
        return (bVar == null || (o = bVar.o()) == null || o.top > 10) ? false : true;
    }

    public final boolean E() {
        d.a.m0.b1.i.a.b bVar = this.f49051f;
        return (bVar == null || bVar.n() == null || this.f49051f.n().b() == null || this.f49051f.n().b().isRecycled()) ? false : true;
    }

    public boolean F() {
        return Math.floor((double) (this.k * 10000.0f)) == Math.floor((double) (this.f49054i * 10000.0f));
    }

    public boolean G() {
        return this.w;
    }

    public boolean H() {
        return this.v;
    }

    public void I(float f2, float f3) {
        if (this.f49051f != null) {
            float[] A = A(f2, f3);
            float f4 = A[0];
            float f5 = A[1];
            this.p.postTranslate(-f4, -f5);
            d.a.m0.b1.i.a.b bVar = this.f49051f;
            float f6 = this.f49054i;
            bVar.p((f4 * 1.0f) / f6, (f5 * 1.0f) / f6);
            u();
            this.f49047b.invalidate();
        }
    }

    public boolean J(Canvas canvas) {
        if (this.m != 1 || this.l == null) {
            d.a.m0.b1.i.a.b bVar = this.f49051f;
            if (bVar != null) {
                bVar.o();
                if (E()) {
                    canvas.drawBitmap(this.f49051f.n().b(), this.p, null);
                }
                w(this.f49051f, false);
                X();
                canvas.save();
                float k = (this.f49051f.k() * 1.0f) / this.f49051f.l();
                canvas.scale(k, k);
                List<d.a.m0.b1.i.a.a> d2 = this.f49051f.d();
                if (d2 != null) {
                    for (d.a.m0.b1.i.a.a aVar : d2) {
                        canvas.drawBitmap(aVar.b(), aVar.f(), aVar.c(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public boolean K(Canvas canvas, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled() && !E()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.f49047b.getWidth() - this.f49047b.getPaddingLeft()) - this.f49047b.getPaddingRight();
            int height2 = (this.f49047b.getHeight() - this.f49047b.getPaddingTop()) - this.f49047b.getPaddingBottom();
            float f2 = width * height2 > width2 * height ? height2 / height : width2 / width;
            matrix.setScale(f2, f2);
            matrix.postTranslate(0.0f, 0.0f);
            canvas.drawBitmap(bitmap, matrix, null);
            return true;
        }
        return J(canvas);
    }

    public void L(float f2, float f3, float f4) {
        float f5 = this.f49054i;
        float f6 = this.f49053h;
        if (f5 * f2 < f6) {
            f2 = f6 / f5;
        }
        float f7 = this.f49054i;
        float f8 = this.j;
        if (f7 * f2 > f8) {
            f2 = f8 / f7;
        }
        Rect o = this.f49051f.o();
        float f9 = ((o.left + o.right) * 1.0f) / 2.0f;
        float f10 = ((o.top + o.bottom) * 1.0f) / 2.0f;
        d.a.m0.b1.i.a.b bVar = this.f49051f;
        if (bVar != null) {
            this.p.postScale(f2, f2, bVar.i() / 2, this.f49051f.h() / 2);
            this.f49051f.r(1.0f / f2, f9, f10);
            float f11 = this.f49054i * f2;
            this.f49054i = f11;
            this.f49051f.s(1.0f / f11);
            float[] s = s();
            this.p.postTranslate(-s[0], -s[1]);
            d.a.m0.b1.i.a.b bVar2 = this.f49051f;
            float f12 = this.f49054i;
            bVar2.p((s[0] * 1.0f) / f12, (s[1] * 1.0f) / f12);
            u();
            this.f49047b.invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r0 != 3) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean M(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.m == 2 && E()) {
            if (action != 0) {
                if (action != 1) {
                }
            } else if (!this.n.isFinished()) {
                this.x = true;
            } else {
                this.x = false;
            }
            r();
            this.n.forceFinished(true);
            this.f49049d.onTouchEvent(motionEvent);
            if (!this.f49049d.isInProgress()) {
                this.f49048c.onTouchEvent(motionEvent);
            }
            return true;
        }
        return false;
    }

    public float N() {
        return this.k;
    }

    public void O() {
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        BdAsyncTask<String, String, String> bdAsyncTask = this.y;
        if (bdAsyncTask != null) {
            bdAsyncTask.cancel();
        }
        d.a.m0.b1.i.c.c cVar = this.o;
        if (cVar != null) {
            cVar.g();
        }
        d.a.m0.b1.i.a.b bVar = this.f49051f;
        if (bVar != null && bVar.d() != null) {
            this.f49051f.d().clear();
        }
        Bitmap bitmap = this.s;
        if (bitmap != null) {
            bitmap.recycle();
            this.s = null;
        }
    }

    public final void P(d.a.m0.b1.i.a.a aVar, Rect rect, Rect rect2) {
        int i2 = rect.left;
        int i3 = rect2.left;
        if (i2 <= i3) {
            i2 = i3;
        }
        int i4 = rect.right;
        int i5 = rect2.right;
        if (i4 >= i5) {
            i4 = i5;
        }
        int i6 = rect.top;
        int i7 = rect2.top;
        if (i6 <= i7) {
            i6 = i7;
        }
        int i8 = rect.bottom;
        int i9 = rect2.bottom;
        if (i8 >= i9) {
            i8 = i9;
        }
        int c2 = aVar.d().c();
        int i10 = rect.left;
        int i11 = rect.top;
        aVar.k((i2 - i10) / c2, (i6 - i11) / c2, (i4 - i10) / c2, (i8 - i11) / c2);
        int i12 = rect2.left;
        int i13 = rect2.top;
        aVar.i((i2 - i12) / c2, (i6 - i13) / c2, (i4 - i12) / c2, (i8 - i13) / c2);
    }

    public void Q(Bitmap bitmap, byte[] bArr) {
        if (bArr == null || bArr.length == 0 || this.f49052g != null) {
            return;
        }
        this.l = bitmap;
        d.a.m0.b1.i.c.a aVar = new d.a.m0.b1.i.c.a(this.f49046a);
        this.f49052g = aVar;
        try {
            this.f49050e = aVar.a(bArr);
        } catch (Throwable unused) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            try {
                this.f49050e = this.f49052g.a(bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.m = 2;
        V();
    }

    public void R(d.a.m0.b1.i.b.a aVar) {
        this.t = aVar;
    }

    public void S(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void T(View.OnLongClickListener onLongClickListener) {
        this.r = onLongClickListener;
    }

    public final void U(float f2, float f3, float f4, int i2) {
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f49054i, f2);
        this.u = ofFloat;
        ofFloat.setDuration(i2);
        this.u.addUpdateListener(new a(f3, f4));
        this.u.start();
    }

    public void V() {
        if (this.m != 2 || this.f49052g == null || this.y.getStatus() != BdAsyncTask.BdAsyncTaskStatus.PENDING || this.f49051f != null || this.f49047b.getMeasuredWidth() <= 0 || this.f49047b.getMeasuredHeight() <= 0 || this.f49052g.b()[0] <= 0 || this.f49052g.b()[1] <= 0) {
            return;
        }
        this.f49051f = new d.a.m0.b1.i.a.b(this.f49047b.getMeasuredWidth(), this.f49047b.getMeasuredHeight(), this.f49052g.b());
        this.y.setPriority(3);
        this.y.execute(new String[0]);
    }

    public final void W(int i2, int i3, int i4) {
        c.d dVar = new c.d(i2, i3, i4);
        dVar.d(this);
        this.o.h(dVar);
    }

    public final void X() {
        List<d.a.m0.b1.i.a.a> d2 = this.f49051f.d();
        if (d2 != null) {
            for (d.a.m0.b1.i.a.a aVar : d2) {
                Y(aVar, this.f49051f);
            }
        }
    }

    public void Y(d.a.m0.b1.i.a.a aVar, d.a.m0.b1.i.a.b bVar) {
        if (aVar.d().a() == 0 && aVar.d().b() == 1) {
            System.currentTimeMillis();
        }
        P(aVar, bVar.g(aVar), bVar.o());
    }

    @Override // d.a.m0.b1.i.b.a
    public void onLoadFinished() {
        this.f49047b.postInvalidate();
    }

    public void r() {
        float f2 = this.f49054i;
        float f3 = this.k;
        if (f2 / f3 < 1.0f) {
            U(f3, 0.0f, 0.0f, 400);
        }
    }

    public final float[] s() {
        Rect o = this.f49051f.o();
        int[] b2 = this.f49052g.b();
        float[] fArr = {(b2[0] / 2) - (((o.left + o.right) * 1.0f) / 2.0f)};
        int i2 = o.top;
        if (i2 < 0) {
            fArr[1] = 0 - i2;
        }
        int i3 = o.bottom;
        if (i3 > b2[1]) {
            fArr[1] = b2[1] - i3;
        }
        int i4 = o.bottom;
        int i5 = o.top;
        if (i4 - i5 > b2[1]) {
            fArr[1] = (b2[1] / 2) - (((i5 + i4) * 1.0f) / 2.0f);
        }
        float f2 = fArr[0];
        float f3 = this.f49054i;
        fArr[0] = f2 * f3;
        fArr[1] = fArr[1] * f3;
        return fArr;
    }

    public boolean t() {
        if (this.m == 1) {
            return false;
        }
        if (this.n.computeScrollOffset()) {
            int currX = this.n.getCurrX();
            int currY = this.n.getCurrY();
            float a2 = (currX - this.n.a()) * 2.0f;
            float b2 = (currY - this.n.b()) * 2.0f;
            int i2 = l.i(TbadkCoreApplication.getInst());
            if (b2 >= 0.0f && Math.abs(b2) <= 20.0f && currX < i2) {
                I(0.0f, -20.0f);
                this.f49047b.invalidate();
                return true;
            }
            this.n.c(currX);
            this.n.d(currY);
            I(-a2, -b2);
            this.f49047b.invalidate();
        }
        return true;
    }

    public void u() {
        if (this.m == 1) {
            return;
        }
        w(this.f49051f, true);
    }

    public final void v(Point[] pointArr, int i2, boolean z2) {
        if (this.o == null) {
            this.o = new d.a.m0.b1.i.c.c(this.f49051f, this.f49050e);
        }
        int i3 = pointArr[0].x;
        boolean z3 = true;
        int i4 = pointArr[1].y;
        int i5 = pointArr[1].x;
        List<d.a.m0.b1.i.a.a> list = null;
        if (!z2) {
            list = this.f49051f.d();
            list.clear();
        }
        for (int i6 = pointArr[0].y; i6 < i4; i6++) {
            for (int i7 = i3; i7 < i5; i7++) {
                d.a.m0.b1.i.a.a x = x(i6, i7, i2);
                if (x == null) {
                    if (z2) {
                        W(i6, i7, i2);
                    }
                    z3 = false;
                } else if (!z2) {
                    list.add(x);
                }
            }
        }
        if (z3) {
            this.o.d(false);
        }
    }

    public final void w(d.a.m0.b1.i.a.b bVar, boolean z2) {
        v(bVar.m(), bVar.k(), z2);
    }

    public final d.a.m0.b1.i.a.a x(int i2, int i3, int i4) {
        d.a.m0.b1.i.a.a f2;
        a.C1108a c1108a = new a.C1108a(i2, i3, i4);
        if (this.o.e() != null && (f2 = this.o.e().f(c1108a)) != null) {
            if (f2.b() != null && !f2.b().isRecycled()) {
                return f2;
            }
            this.o.e().i(c1108a);
        }
        return null;
    }

    public float y() {
        return this.k * 2.0f;
    }

    public float z() {
        float f2 = this.k;
        if (f2 < 1.0f) {
            return f2;
        }
        return 1.0f;
    }
}
