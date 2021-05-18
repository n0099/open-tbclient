package d.a.j0.b1.i.b;

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
import d.a.j0.b1.i.a.a;
import d.a.j0.b1.i.c.c;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements d.a.j0.b1.i.b.a {
    public static final int z = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* renamed from: a  reason: collision with root package name */
    public final Context f49021a;

    /* renamed from: b  reason: collision with root package name */
    public final View f49022b;

    /* renamed from: c  reason: collision with root package name */
    public GestureDetector f49023c;

    /* renamed from: d  reason: collision with root package name */
    public ScaleGestureDetector f49024d;

    /* renamed from: e  reason: collision with root package name */
    public BitmapRegionDecoder f49025e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.b1.i.a.b f49026f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.b1.i.c.a f49027g;

    /* renamed from: h  reason: collision with root package name */
    public float f49028h;

    /* renamed from: i  reason: collision with root package name */
    public float f49029i;
    public Bitmap l;
    public int m;
    public c n;
    public d.a.j0.b1.i.c.c o;
    public View.OnClickListener q;
    public View.OnLongClickListener r;
    public d.a.j0.b1.i.b.a t;
    public ValueAnimator u;
    public float j = 2.0f;
    public float k = 1.0f;
    public final Matrix p = new Matrix();
    public Bitmap s = null;
    public boolean v = true;
    public boolean w = false;
    public boolean x = false;
    public BdAsyncTask<String, String, String> y = new C1102b();

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f49030e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f49031f;

        public a(float f2, float f3) {
            this.f49030e = f2;
            this.f49031f = f3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null || !(valueAnimator.getAnimatedValue() instanceof Float)) {
                return;
            }
            b.this.L(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.f49029i, this.f49030e, this.f49031f);
        }
    }

    /* renamed from: d.a.j0.b1.i.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1102b extends BdAsyncTask<String, String, String> {
        public C1102b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            double d2;
            if (b.this.f49026f != null && b.this.f49025e != null) {
                int[] b2 = b.this.f49027g.b();
                int i2 = 1;
                while (true) {
                    d2 = i2;
                    if (Math.max(b2[0] / b.this.f49026f.i(), b2[1] / b.this.f49026f.h()) <= Math.pow(2.0d, d2)) {
                        break;
                    }
                    i2++;
                }
                int pow = (int) Math.pow(2.0d, d2);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, b2[0], b2[1]);
                try {
                    b.this.s = b.this.f49025e.decodeRegion(rect, options);
                } catch (Throwable unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.s = b.this.f49025e.decodeRegion(rect, options);
                    } catch (Throwable unused2) {
                        b.this.s = null;
                    }
                }
                d.a.j0.a0.c.k().d("long_img_mThumb" + System.currentTimeMillis(), new d.a.c.j.d.a(b.this.s, false));
                b bVar = b.this;
                bVar.B(bVar.s, bVar.f49026f, pow);
                b.this.f49026f.t(b.this.s);
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
            b.this.f49022b.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Scroller {

        /* renamed from: a  reason: collision with root package name */
        public int f49034a;

        /* renamed from: b  reason: collision with root package name */
        public int f49035b;

        public c(b bVar, Context context) {
            super(context);
            this.f49034a = 0;
            this.f49035b = 0;
        }

        public int a() {
            return this.f49034a;
        }

        public int b() {
            return this.f49035b;
        }

        public void c(int i2) {
            this.f49034a = i2;
        }

        public void d(int i2) {
            this.f49035b = i2;
        }

        @Override // android.widget.Scroller
        public void fling(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.f49034a = 0;
            this.f49035b = 0;
            super.fling(i2, i3, i4, i5, i6, i7, i8, i9);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        public d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.U(b.this.f49029i == b.this.j ? b.this.k : b.this.j, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            Rect o = b.this.f49026f.o();
            Rect f4 = b.this.f49026f.f();
            b.this.n.forceFinished(true);
            int i2 = (int) 0.0f;
            b.this.n.fling(i2, i2, (int) f2, (int) f3, o.right - f4.right, o.left - f4.left, o.bottom - f4.bottom, o.top - f4.top);
            b.this.f49022b.invalidate();
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
                b.this.r.onLongClick(b.this.f49022b);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            b.this.I((int) f2, (int) f3);
            if (Math.abs(f3) > b.z) {
                b.this.x = true;
            }
            if (b.this.f49022b != null && b.this.f49029i != b.this.k) {
                b.this.f49022b.getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.x || b.this.q == null) {
                b.this.x = false;
            } else {
                b.this.q.onClick(b.this.f49022b);
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
        this.f49022b = view;
        this.f49021a = view.getContext();
        this.f49023c = new GestureDetector(this.f49021a, new d(this, null));
        this.f49024d = new ScaleGestureDetector(this.f49021a, new e(this, null));
        this.n = new c(this, this.f49021a);
        this.m = 0;
    }

    public final float[] A(float f2, float f3) {
        float[] fArr = new float[2];
        Rect o = this.f49026f.o();
        int[] b2 = this.f49027g.b();
        if (o.top + f3 < 0.0f) {
            f3 = 0.0f;
        }
        int i2 = o.bottom;
        if (i2 + f3 > b2[1]) {
            f3 = (b2[1] - i2) * this.f49029i;
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

    public final void B(Bitmap bitmap, d.a.j0.b1.i.a.b bVar, int i2) {
        float max = Math.max((bVar.i() * 1.0f) / bitmap.getWidth(), (bVar.h() * 1.0f) / bitmap.getHeight());
        this.p.postScale(max, max);
        float f2 = (1.0f / i2) * max;
        this.f49028h = f2;
        this.k = f2;
        this.f49029i = f2;
        this.j = f2 * 2.0f;
        float i3 = (bVar.i() * 1.0f) / this.f49025e.getWidth();
        if (i3 > 1.0f) {
            this.f49028h /= i3;
        }
        bVar.s(1.0f / this.f49029i);
    }

    public final void C() {
        d.a.j0.b1.i.a.b bVar = this.f49026f;
        if (bVar != null) {
            bVar.q(1.0f / this.k);
        }
    }

    public boolean D() {
        Rect o;
        d.a.j0.b1.i.a.b bVar = this.f49026f;
        return (bVar == null || (o = bVar.o()) == null || o.top > 10) ? false : true;
    }

    public final boolean E() {
        d.a.j0.b1.i.a.b bVar = this.f49026f;
        return (bVar == null || bVar.n() == null || this.f49026f.n().b() == null || this.f49026f.n().b().isRecycled()) ? false : true;
    }

    public boolean F() {
        return Math.floor((double) (this.k * 10000.0f)) == Math.floor((double) (this.f49029i * 10000.0f));
    }

    public boolean G() {
        return this.w;
    }

    public boolean H() {
        return this.v;
    }

    public void I(float f2, float f3) {
        if (this.f49026f != null) {
            float[] A = A(f2, f3);
            float f4 = A[0];
            float f5 = A[1];
            this.p.postTranslate(-f4, -f5);
            d.a.j0.b1.i.a.b bVar = this.f49026f;
            float f6 = this.f49029i;
            bVar.p((f4 * 1.0f) / f6, (f5 * 1.0f) / f6);
            u();
            this.f49022b.invalidate();
        }
    }

    public boolean J(Canvas canvas) {
        if (this.m != 1 || this.l == null) {
            d.a.j0.b1.i.a.b bVar = this.f49026f;
            if (bVar != null) {
                bVar.o();
                if (E()) {
                    canvas.drawBitmap(this.f49026f.n().b(), this.p, null);
                }
                w(this.f49026f, false);
                X();
                canvas.save();
                float k = (this.f49026f.k() * 1.0f) / this.f49026f.l();
                canvas.scale(k, k);
                List<d.a.j0.b1.i.a.a> d2 = this.f49026f.d();
                if (d2 != null) {
                    for (d.a.j0.b1.i.a.a aVar : d2) {
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
            int width2 = (this.f49022b.getWidth() - this.f49022b.getPaddingLeft()) - this.f49022b.getPaddingRight();
            int height2 = (this.f49022b.getHeight() - this.f49022b.getPaddingTop()) - this.f49022b.getPaddingBottom();
            float f2 = width * height2 > width2 * height ? height2 / height : width2 / width;
            matrix.setScale(f2, f2);
            matrix.postTranslate(0.0f, 0.0f);
            canvas.drawBitmap(bitmap, matrix, null);
            return true;
        }
        return J(canvas);
    }

    public void L(float f2, float f3, float f4) {
        float f5 = this.f49029i;
        float f6 = this.f49028h;
        if (f5 * f2 < f6) {
            f2 = f6 / f5;
        }
        float f7 = this.f49029i;
        float f8 = this.j;
        if (f7 * f2 > f8) {
            f2 = f8 / f7;
        }
        Rect o = this.f49026f.o();
        float f9 = ((o.left + o.right) * 1.0f) / 2.0f;
        float f10 = ((o.top + o.bottom) * 1.0f) / 2.0f;
        d.a.j0.b1.i.a.b bVar = this.f49026f;
        if (bVar != null) {
            this.p.postScale(f2, f2, bVar.i() / 2, this.f49026f.h() / 2);
            this.f49026f.r(1.0f / f2, f9, f10);
            float f11 = this.f49029i * f2;
            this.f49029i = f11;
            this.f49026f.s(1.0f / f11);
            float[] s = s();
            this.p.postTranslate(-s[0], -s[1]);
            d.a.j0.b1.i.a.b bVar2 = this.f49026f;
            float f12 = this.f49029i;
            bVar2.p((s[0] * 1.0f) / f12, (s[1] * 1.0f) / f12);
            u();
            this.f49022b.invalidate();
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
            this.f49024d.onTouchEvent(motionEvent);
            if (!this.f49024d.isInProgress()) {
                this.f49023c.onTouchEvent(motionEvent);
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
        d.a.j0.b1.i.c.c cVar = this.o;
        if (cVar != null) {
            cVar.g();
        }
        d.a.j0.b1.i.a.b bVar = this.f49026f;
        if (bVar != null && bVar.d() != null) {
            this.f49026f.d().clear();
        }
        Bitmap bitmap = this.s;
        if (bitmap != null) {
            bitmap.recycle();
            this.s = null;
        }
    }

    public final void P(d.a.j0.b1.i.a.a aVar, Rect rect, Rect rect2) {
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
        if (bArr == null || bArr.length == 0 || this.f49027g != null) {
            return;
        }
        this.l = bitmap;
        d.a.j0.b1.i.c.a aVar = new d.a.j0.b1.i.c.a(this.f49021a);
        this.f49027g = aVar;
        try {
            this.f49025e = aVar.a(bArr);
        } catch (Throwable unused) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            try {
                this.f49025e = this.f49027g.a(bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.m = 2;
        V();
    }

    public void R(d.a.j0.b1.i.b.a aVar) {
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
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f49029i, f2);
        this.u = ofFloat;
        ofFloat.setDuration(i2);
        this.u.addUpdateListener(new a(f3, f4));
        this.u.start();
    }

    public void V() {
        if (this.m != 2 || this.f49027g == null || this.y.getStatus() != BdAsyncTask.BdAsyncTaskStatus.PENDING || this.f49026f != null || this.f49022b.getMeasuredWidth() <= 0 || this.f49022b.getMeasuredHeight() <= 0 || this.f49027g.b()[0] <= 0 || this.f49027g.b()[1] <= 0) {
            return;
        }
        this.f49026f = new d.a.j0.b1.i.a.b(this.f49022b.getMeasuredWidth(), this.f49022b.getMeasuredHeight(), this.f49027g.b());
        this.y.setPriority(3);
        this.y.execute(new String[0]);
    }

    public final void W(int i2, int i3, int i4) {
        c.d dVar = new c.d(i2, i3, i4);
        dVar.d(this);
        this.o.h(dVar);
    }

    public final void X() {
        List<d.a.j0.b1.i.a.a> d2 = this.f49026f.d();
        if (d2 != null) {
            for (d.a.j0.b1.i.a.a aVar : d2) {
                Y(aVar, this.f49026f);
            }
        }
    }

    public void Y(d.a.j0.b1.i.a.a aVar, d.a.j0.b1.i.a.b bVar) {
        if (aVar.d().a() == 0 && aVar.d().b() == 1) {
            System.currentTimeMillis();
        }
        P(aVar, bVar.g(aVar), bVar.o());
    }

    @Override // d.a.j0.b1.i.b.a
    public void onLoadFinished() {
        this.f49022b.postInvalidate();
    }

    public void r() {
        float f2 = this.f49029i;
        float f3 = this.k;
        if (f2 / f3 < 1.0f) {
            U(f3, 0.0f, 0.0f, 400);
        }
    }

    public final float[] s() {
        Rect o = this.f49026f.o();
        int[] b2 = this.f49027g.b();
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
        float f3 = this.f49029i;
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
                this.f49022b.invalidate();
                return true;
            }
            this.n.c(currX);
            this.n.d(currY);
            I(-a2, -b2);
            this.f49022b.invalidate();
        }
        return true;
    }

    public void u() {
        if (this.m == 1) {
            return;
        }
        w(this.f49026f, true);
    }

    public final void v(Point[] pointArr, int i2, boolean z2) {
        if (this.o == null) {
            this.o = new d.a.j0.b1.i.c.c(this.f49026f, this.f49025e);
        }
        int i3 = pointArr[0].x;
        boolean z3 = true;
        int i4 = pointArr[1].y;
        int i5 = pointArr[1].x;
        List<d.a.j0.b1.i.a.a> list = null;
        if (!z2) {
            list = this.f49026f.d();
            list.clear();
        }
        for (int i6 = pointArr[0].y; i6 < i4; i6++) {
            for (int i7 = i3; i7 < i5; i7++) {
                d.a.j0.b1.i.a.a x = x(i6, i7, i2);
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

    public final void w(d.a.j0.b1.i.a.b bVar, boolean z2) {
        v(bVar.m(), bVar.k(), z2);
    }

    public final d.a.j0.b1.i.a.a x(int i2, int i3, int i4) {
        d.a.j0.b1.i.a.a f2;
        a.C1101a c1101a = new a.C1101a(i2, i3, i4);
        if (this.o.e() != null && (f2 = this.o.e().f(c1101a)) != null) {
            if (f2.b() != null && !f2.b().isRecycled()) {
                return f2;
            }
            this.o.e().i(c1101a);
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
