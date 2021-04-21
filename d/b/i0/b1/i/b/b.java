package d.b.i0.b1.i.b;

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
import d.b.c.e.p.l;
import d.b.i0.b1.i.a.a;
import d.b.i0.b1.i.c.c;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements d.b.i0.b1.i.b.a {
    public static final int z = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* renamed from: a  reason: collision with root package name */
    public final Context f50631a;

    /* renamed from: b  reason: collision with root package name */
    public final View f50632b;

    /* renamed from: c  reason: collision with root package name */
    public GestureDetector f50633c;

    /* renamed from: d  reason: collision with root package name */
    public ScaleGestureDetector f50634d;

    /* renamed from: e  reason: collision with root package name */
    public BitmapRegionDecoder f50635e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.b1.i.a.b f50636f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.b1.i.c.a f50637g;

    /* renamed from: h  reason: collision with root package name */
    public float f50638h;
    public float i;
    public Bitmap l;
    public int m;
    public c n;
    public d.b.i0.b1.i.c.c o;
    public View.OnClickListener q;
    public View.OnLongClickListener r;
    public d.b.i0.b1.i.b.a t;
    public ValueAnimator u;
    public float j = 2.0f;
    public float k = 1.0f;
    public final Matrix p = new Matrix();
    public Bitmap s = null;
    public boolean v = true;
    public boolean w = false;
    public boolean x = false;
    public BdAsyncTask<String, String, String> y = new C1087b();

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f50639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f50640f;

        public a(float f2, float f3) {
            this.f50639e = f2;
            this.f50640f = f3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null || !(valueAnimator.getAnimatedValue() instanceof Float)) {
                return;
            }
            b.this.L(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.i, this.f50639e, this.f50640f);
        }
    }

    /* renamed from: d.b.i0.b1.i.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1087b extends BdAsyncTask<String, String, String> {
        public C1087b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            double d2;
            if (b.this.f50636f != null && b.this.f50635e != null) {
                int[] b2 = b.this.f50637g.b();
                int i = 1;
                while (true) {
                    d2 = i;
                    if (Math.max(b2[0] / b.this.f50636f.i(), b2[1] / b.this.f50636f.h()) <= Math.pow(2.0d, d2)) {
                        break;
                    }
                    i++;
                }
                int pow = (int) Math.pow(2.0d, d2);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, b2[0], b2[1]);
                try {
                    b.this.s = b.this.f50635e.decodeRegion(rect, options);
                } catch (Throwable unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.s = b.this.f50635e.decodeRegion(rect, options);
                    } catch (Throwable unused2) {
                        b.this.s = null;
                    }
                }
                d.b.i0.a0.c.k().d("long_img_mThumb" + System.currentTimeMillis(), new d.b.c.j.d.a(b.this.s, false));
                b bVar = b.this;
                bVar.B(bVar.s, bVar.f50636f, pow);
                b.this.f50636f.t(b.this.s);
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
            b.this.f50632b.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Scroller {

        /* renamed from: a  reason: collision with root package name */
        public int f50643a;

        /* renamed from: b  reason: collision with root package name */
        public int f50644b;

        public c(b bVar, Context context) {
            super(context);
            this.f50643a = 0;
            this.f50644b = 0;
        }

        public int a() {
            return this.f50643a;
        }

        public int b() {
            return this.f50644b;
        }

        public void c(int i) {
            this.f50643a = i;
        }

        public void d(int i) {
            this.f50644b = i;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f50643a = 0;
            this.f50644b = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        public d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.U(b.this.i == b.this.j ? b.this.k : b.this.j, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            Rect o = b.this.f50636f.o();
            Rect f4 = b.this.f50636f.f();
            b.this.n.forceFinished(true);
            int i = (int) 0.0f;
            b.this.n.fling(i, i, (int) f2, (int) f3, o.right - f4.right, o.left - f4.left, o.bottom - f4.bottom, o.top - f4.top);
            b.this.f50632b.invalidate();
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
                b.this.r.onLongClick(b.this.f50632b);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            b.this.I((int) f2, (int) f3);
            if (Math.abs(f3) > b.z) {
                b.this.x = true;
            }
            if (b.this.f50632b != null && b.this.i != b.this.k) {
                b.this.f50632b.getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.x || b.this.q == null) {
                b.this.x = false;
            } else {
                b.this.q.onClick(b.this.f50632b);
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
        this.f50632b = view;
        this.f50631a = view.getContext();
        this.f50633c = new GestureDetector(this.f50631a, new d(this, null));
        this.f50634d = new ScaleGestureDetector(this.f50631a, new e(this, null));
        this.n = new c(this, this.f50631a);
        this.m = 0;
    }

    public final float[] A(float f2, float f3) {
        float[] fArr = new float[2];
        Rect o = this.f50636f.o();
        int[] b2 = this.f50637g.b();
        if (o.top + f3 < 0.0f) {
            f3 = 0.0f;
        }
        int i = o.bottom;
        if (i + f3 > b2[1]) {
            f3 = (b2[1] - i) * this.i;
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

    public final void B(Bitmap bitmap, d.b.i0.b1.i.a.b bVar, int i) {
        float max = Math.max((bVar.i() * 1.0f) / bitmap.getWidth(), (bVar.h() * 1.0f) / bitmap.getHeight());
        this.p.postScale(max, max);
        float f2 = (1.0f / i) * max;
        this.f50638h = f2;
        this.k = f2;
        this.i = f2;
        this.j = f2 * 2.0f;
        float i2 = (bVar.i() * 1.0f) / this.f50635e.getWidth();
        if (i2 > 1.0f) {
            this.f50638h /= i2;
        }
        bVar.s(1.0f / this.i);
    }

    public final void C() {
        d.b.i0.b1.i.a.b bVar = this.f50636f;
        if (bVar != null) {
            bVar.q(1.0f / this.k);
        }
    }

    public boolean D() {
        Rect o;
        d.b.i0.b1.i.a.b bVar = this.f50636f;
        return (bVar == null || (o = bVar.o()) == null || o.top > 10) ? false : true;
    }

    public final boolean E() {
        d.b.i0.b1.i.a.b bVar = this.f50636f;
        return (bVar == null || bVar.n() == null || this.f50636f.n().b() == null || this.f50636f.n().b().isRecycled()) ? false : true;
    }

    public boolean F() {
        return Math.floor((double) (this.k * 10000.0f)) == Math.floor((double) (this.i * 10000.0f));
    }

    public boolean G() {
        return this.w;
    }

    public boolean H() {
        return this.v;
    }

    public void I(float f2, float f3) {
        if (this.f50636f != null) {
            float[] A = A(f2, f3);
            float f4 = A[0];
            float f5 = A[1];
            this.p.postTranslate(-f4, -f5);
            d.b.i0.b1.i.a.b bVar = this.f50636f;
            float f6 = this.i;
            bVar.p((f4 * 1.0f) / f6, (f5 * 1.0f) / f6);
            u();
            this.f50632b.invalidate();
        }
    }

    public boolean J(Canvas canvas) {
        if (this.m != 1 || this.l == null) {
            d.b.i0.b1.i.a.b bVar = this.f50636f;
            if (bVar != null) {
                bVar.o();
                if (E()) {
                    canvas.drawBitmap(this.f50636f.n().b(), this.p, null);
                }
                w(this.f50636f, false);
                X();
                canvas.save();
                float k = (this.f50636f.k() * 1.0f) / this.f50636f.l();
                canvas.scale(k, k);
                List<d.b.i0.b1.i.a.a> d2 = this.f50636f.d();
                if (d2 != null) {
                    for (d.b.i0.b1.i.a.a aVar : d2) {
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
            int width2 = (this.f50632b.getWidth() - this.f50632b.getPaddingLeft()) - this.f50632b.getPaddingRight();
            int height2 = (this.f50632b.getHeight() - this.f50632b.getPaddingTop()) - this.f50632b.getPaddingBottom();
            float f2 = width * height2 > width2 * height ? height2 / height : width2 / width;
            matrix.setScale(f2, f2);
            matrix.postTranslate(0.0f, 0.0f);
            canvas.drawBitmap(bitmap, matrix, null);
            return true;
        }
        return J(canvas);
    }

    public void L(float f2, float f3, float f4) {
        float f5 = this.i;
        float f6 = this.f50638h;
        if (f5 * f2 < f6) {
            f2 = f6 / f5;
        }
        float f7 = this.i;
        float f8 = this.j;
        if (f7 * f2 > f8) {
            f2 = f8 / f7;
        }
        Rect o = this.f50636f.o();
        float f9 = ((o.left + o.right) * 1.0f) / 2.0f;
        float f10 = ((o.top + o.bottom) * 1.0f) / 2.0f;
        d.b.i0.b1.i.a.b bVar = this.f50636f;
        if (bVar != null) {
            this.p.postScale(f2, f2, bVar.i() / 2, this.f50636f.h() / 2);
            this.f50636f.r(1.0f / f2, f9, f10);
            float f11 = this.i * f2;
            this.i = f11;
            this.f50636f.s(1.0f / f11);
            float[] s = s();
            this.p.postTranslate(-s[0], -s[1]);
            d.b.i0.b1.i.a.b bVar2 = this.f50636f;
            float f12 = this.i;
            bVar2.p((s[0] * 1.0f) / f12, (s[1] * 1.0f) / f12);
            u();
            this.f50632b.invalidate();
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
            this.f50634d.onTouchEvent(motionEvent);
            if (!this.f50634d.isInProgress()) {
                this.f50633c.onTouchEvent(motionEvent);
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
        d.b.i0.b1.i.c.c cVar = this.o;
        if (cVar != null) {
            cVar.g();
        }
        d.b.i0.b1.i.a.b bVar = this.f50636f;
        if (bVar != null && bVar.d() != null) {
            this.f50636f.d().clear();
        }
        Bitmap bitmap = this.s;
        if (bitmap != null) {
            bitmap.recycle();
            this.s = null;
        }
    }

    public final void P(d.b.i0.b1.i.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left;
        int i2 = rect2.left;
        if (i <= i2) {
            i = i2;
        }
        int i3 = rect.right;
        int i4 = rect2.right;
        if (i3 >= i4) {
            i3 = i4;
        }
        int i5 = rect.top;
        int i6 = rect2.top;
        if (i5 <= i6) {
            i5 = i6;
        }
        int i7 = rect.bottom;
        int i8 = rect2.bottom;
        if (i7 >= i8) {
            i7 = i8;
        }
        int c2 = aVar.d().c();
        int i9 = rect.left;
        int i10 = rect.top;
        aVar.k((i - i9) / c2, (i5 - i10) / c2, (i3 - i9) / c2, (i7 - i10) / c2);
        int i11 = rect2.left;
        int i12 = rect2.top;
        aVar.i((i - i11) / c2, (i5 - i12) / c2, (i3 - i11) / c2, (i7 - i12) / c2);
    }

    public void Q(Bitmap bitmap, byte[] bArr) {
        if (bArr == null || bArr.length == 0 || this.f50637g != null) {
            return;
        }
        this.l = bitmap;
        d.b.i0.b1.i.c.a aVar = new d.b.i0.b1.i.c.a(this.f50631a);
        this.f50637g = aVar;
        try {
            this.f50635e = aVar.a(bArr);
        } catch (Throwable unused) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            try {
                this.f50635e = this.f50637g.a(bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.m = 2;
        V();
    }

    public void R(d.b.i0.b1.i.b.a aVar) {
        this.t = aVar;
    }

    public void S(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void T(View.OnLongClickListener onLongClickListener) {
        this.r = onLongClickListener;
    }

    public final void U(float f2, float f3, float f4, int i) {
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.i, f2);
        this.u = ofFloat;
        ofFloat.setDuration(i);
        this.u.addUpdateListener(new a(f3, f4));
        this.u.start();
    }

    public void V() {
        if (this.m != 2 || this.f50637g == null || this.y.getStatus() != BdAsyncTask.BdAsyncTaskStatus.PENDING || this.f50636f != null || this.f50632b.getMeasuredWidth() <= 0 || this.f50632b.getMeasuredHeight() <= 0 || this.f50637g.b()[0] <= 0 || this.f50637g.b()[1] <= 0) {
            return;
        }
        this.f50636f = new d.b.i0.b1.i.a.b(this.f50632b.getMeasuredWidth(), this.f50632b.getMeasuredHeight(), this.f50637g.b());
        this.y.setPriority(3);
        this.y.execute(new String[0]);
    }

    public final void W(int i, int i2, int i3) {
        c.d dVar = new c.d(i, i2, i3);
        dVar.d(this);
        this.o.h(dVar);
    }

    public final void X() {
        List<d.b.i0.b1.i.a.a> d2 = this.f50636f.d();
        if (d2 != null) {
            for (d.b.i0.b1.i.a.a aVar : d2) {
                Y(aVar, this.f50636f);
            }
        }
    }

    public void Y(d.b.i0.b1.i.a.a aVar, d.b.i0.b1.i.a.b bVar) {
        if (aVar.d().a() == 0 && aVar.d().b() == 1) {
            System.currentTimeMillis();
        }
        P(aVar, bVar.g(aVar), bVar.o());
    }

    @Override // d.b.i0.b1.i.b.a
    public void onLoadFinished() {
        this.f50632b.postInvalidate();
    }

    public void r() {
        float f2 = this.i;
        float f3 = this.k;
        if (f2 / f3 < 1.0f) {
            U(f3, 0.0f, 0.0f, 400);
        }
    }

    public final float[] s() {
        Rect o = this.f50636f.o();
        int[] b2 = this.f50637g.b();
        float[] fArr = {(b2[0] / 2) - (((o.left + o.right) * 1.0f) / 2.0f)};
        int i = o.top;
        if (i < 0) {
            fArr[1] = 0 - i;
        }
        int i2 = o.bottom;
        if (i2 > b2[1]) {
            fArr[1] = b2[1] - i2;
        }
        int i3 = o.bottom;
        int i4 = o.top;
        if (i3 - i4 > b2[1]) {
            fArr[1] = (b2[1] / 2) - (((i4 + i3) * 1.0f) / 2.0f);
        }
        float f2 = fArr[0];
        float f3 = this.i;
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
            int i = l.i(TbadkCoreApplication.getInst());
            if (b2 >= 0.0f && Math.abs(b2) <= 20.0f && currX < i) {
                I(0.0f, -20.0f);
                this.f50632b.invalidate();
                return true;
            }
            this.n.c(currX);
            this.n.d(currY);
            I(-a2, -b2);
            this.f50632b.invalidate();
        }
        return true;
    }

    public void u() {
        if (this.m == 1) {
            return;
        }
        w(this.f50636f, true);
    }

    public final void v(Point[] pointArr, int i, boolean z2) {
        if (this.o == null) {
            this.o = new d.b.i0.b1.i.c.c(this.f50636f, this.f50635e);
        }
        int i2 = pointArr[0].x;
        boolean z3 = true;
        int i3 = pointArr[1].y;
        int i4 = pointArr[1].x;
        List<d.b.i0.b1.i.a.a> list = null;
        if (!z2) {
            list = this.f50636f.d();
            list.clear();
        }
        for (int i5 = pointArr[0].y; i5 < i3; i5++) {
            for (int i6 = i2; i6 < i4; i6++) {
                d.b.i0.b1.i.a.a x = x(i5, i6, i);
                if (x == null) {
                    if (z2) {
                        W(i5, i6, i);
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

    public final void w(d.b.i0.b1.i.a.b bVar, boolean z2) {
        v(bVar.m(), bVar.k(), z2);
    }

    public final d.b.i0.b1.i.a.a x(int i, int i2, int i3) {
        d.b.i0.b1.i.a.a f2;
        a.C1086a c1086a = new a.C1086a(i, i2, i3);
        if (this.o.e() != null && (f2 = this.o.e().f(c1086a)) != null) {
            if (f2.b() != null && !f2.b().isRecycled()) {
                return f2;
            }
            this.o.e().i(c1086a);
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
