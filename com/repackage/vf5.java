package com.repackage;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.sf5;
import com.repackage.yf5;
import java.util.List;
/* loaded from: classes7.dex */
public class vf5 implements uf5 {
    public static /* synthetic */ Interceptable $ic;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final View b;
    public GestureDetector c;
    public ScaleGestureDetector d;
    public BitmapRegionDecoder e;
    public tf5 f;
    public wf5 g;
    public float h;
    public float i;
    public float j;
    public float k;
    public Bitmap l;
    public int m;
    public c n;
    public yf5 o;
    public final Matrix p;
    public View.OnClickListener q;
    public View.OnLongClickListener r;
    public Bitmap s;
    public uf5 t;
    public ValueAnimator u;
    public boolean v;
    public boolean w;
    public boolean x;
    public BdAsyncTask<String, String, String> y;

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;
        public final /* synthetic */ vf5 c;

        public a(vf5 vf5Var, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf5Var, Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vf5Var;
            this.a = f;
            this.b = f2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                this.c.L(((Float) valueAnimator.getAnimatedValue()).floatValue() / this.c.i, this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf5 a;

        public b(vf5 vf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vf5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            double d;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (this.a.f != null && this.a.e != null) {
                    int[] b = this.a.g.b();
                    int i = 1;
                    while (true) {
                        d = i;
                        if (Math.max(b[0] / this.a.f.i(), b[1] / this.a.f.h()) <= Math.pow(2.0d, d)) {
                            break;
                        }
                        i++;
                    }
                    int pow = (int) Math.pow(2.0d, d);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = pow;
                    Rect rect = new Rect(0, 0, b[0], b[1]);
                    try {
                        this.a.s = this.a.e.decodeRegion(rect, options);
                    } catch (Throwable unused) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        System.gc();
                        try {
                            this.a.s = this.a.e.decodeRegion(rect, options);
                        } catch (Throwable unused2) {
                            this.a.s = null;
                        }
                    }
                    m45.k().d("long_img_mThumb" + System.currentTimeMillis(), new ym(this.a.s, false));
                    vf5 vf5Var = this.a;
                    vf5Var.B(vf5Var.s, vf5Var.f, pow);
                    this.a.f.t(this.a.s);
                    this.a.C();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                if (this.a.t != null) {
                    this.a.t.onLoadFinished();
                }
                this.a.u();
                this.a.b.invalidate();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends Scroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(vf5 vf5Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf5Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.b = 0;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : invokeV.intValue;
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a = i;
            }
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.b = i;
            }
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                this.a = 0;
                this.b = 0;
                super.fling(i, i2, i3, i4, i5, i6, i7, i8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf5 a;

        public d(vf5 vf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vf5Var;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.a.U(this.a.i == this.a.j ? this.a.k : this.a.j, motionEvent.getX(), motionEvent.getY(), 400);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                Rect o = this.a.f.o();
                Rect f3 = this.a.f.f();
                this.a.n.forceFinished(true);
                int i = (int) 0.0f;
                this.a.n.fling(i, i, (int) f, (int) f2, o.right - f3.right, o.left - f3.left, o.bottom - f3.bottom, o.top - f3.top);
                this.a.b.invalidate();
                if (Math.abs(f2) > vf5.z) {
                    this.a.x = true;
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                if (this.a.x || this.a.r == null) {
                    this.a.x = false;
                } else {
                    this.a.r.onLongClick(this.a.b);
                }
                super.onLongPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.I((int) f, (int) f2);
                if (Math.abs(f2) > vf5.z) {
                    this.a.x = true;
                }
                if (this.a.b != null && this.a.i != this.a.k) {
                    this.a.b.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
                if (this.a.x || this.a.q == null) {
                    this.a.x = false;
                } else {
                    this.a.q.onClick(this.a.b);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ d(vf5 vf5Var, a aVar) {
            this(vf5Var);
        }
    }

    /* loaded from: classes7.dex */
    public class e extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf5 a;

        public e(vf5 vf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vf5Var;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scaleGestureDetector)) == null) {
                this.a.L(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ e(vf5 vf5Var, a aVar) {
            this(vf5Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755233076, "Lcom/repackage/vf5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755233076, "Lcom/repackage/vf5;");
                return;
            }
        }
        z = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
    }

    public vf5(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = 2.0f;
        this.k = 1.0f;
        this.m = 1;
        this.p = new Matrix();
        this.s = null;
        this.v = true;
        this.w = false;
        this.x = false;
        this.y = new b(this);
        this.b = view2;
        this.a = view2.getContext();
        this.c = new GestureDetector(this.a, new d(this, null));
        this.d = new ScaleGestureDetector(this.a, new e(this, null));
        this.n = new c(this, this.a);
        this.m = 0;
    }

    public final float[] A(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float[] fArr = new float[2];
            Rect o = this.f.o();
            int[] b2 = this.g.b();
            if (o.top + f2 < 0.0f) {
                f2 = 0.0f;
            }
            int i = o.bottom;
            if (i + f2 > b2[1]) {
                f2 = (b2[1] - i) * this.i;
            }
            if (o.bottom - o.top > b2[1]) {
                f2 = 0.0f;
            }
            fArr[0] = 0.0f;
            fArr[1] = f2;
            this.v = f2 == 0.0f;
            boolean z2 = o.bottom == b2[1];
            this.w = z2;
            if (z2) {
                this.v = false;
            }
            return fArr;
        }
        return (float[]) invokeCommon.objValue;
    }

    public final void B(Bitmap bitmap, tf5 tf5Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, tf5Var, i) == null) {
            float max = Math.max((tf5Var.i() * 1.0f) / bitmap.getWidth(), (tf5Var.h() * 1.0f) / bitmap.getHeight());
            this.p.postScale(max, max);
            float f = (1.0f / i) * max;
            this.h = f;
            this.k = f;
            this.i = f;
            this.j = f * 2.0f;
            float i2 = (tf5Var.i() * 1.0f) / this.e.getWidth();
            if (i2 > 1.0f) {
                this.h /= i2;
            }
            tf5Var.s(1.0f / this.i);
        }
    }

    public final void C() {
        tf5 tf5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tf5Var = this.f) == null) {
            return;
        }
        tf5Var.q(1.0f / this.k);
    }

    public boolean D() {
        InterceptResult invokeV;
        Rect o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            tf5 tf5Var = this.f;
            return (tf5Var == null || (o = tf5Var.o()) == null || o.top > 10) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            tf5 tf5Var = this.f;
            return (tf5Var == null || tf5Var.n() == null || this.f.n().b() == null || this.f.n().b().isRecycled()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Math.floor((double) (this.k * 10000.0f)) == Math.floor((double) (this.i * 10000.0f)) : invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public void I(float f, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || this.f == null) {
            return;
        }
        float[] A = A(f, f2);
        float f3 = A[0];
        float f4 = A[1];
        this.p.postTranslate(-f3, -f4);
        tf5 tf5Var = this.f;
        float f5 = this.i;
        tf5Var.p((f3 * 1.0f) / f5, (f4 * 1.0f) / f5);
        u();
        this.b.invalidate();
    }

    public boolean J(Canvas canvas) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, canvas)) == null) {
            if (this.m != 1 || this.l == null) {
                tf5 tf5Var = this.f;
                if (tf5Var != null) {
                    tf5Var.o();
                    if (E()) {
                        canvas.drawBitmap(this.f.n().b(), this.p, null);
                    }
                    w(this.f, false);
                    X();
                    canvas.save();
                    float k = (this.f.k() * 1.0f) / this.f.l();
                    canvas.scale(k, k);
                    List<sf5> d2 = this.f.d();
                    if (d2 != null) {
                        for (sf5 sf5Var : d2) {
                            canvas.drawBitmap(sf5Var.b(), sf5Var.f(), sf5Var.c(), (Paint) null);
                        }
                    }
                    canvas.restore();
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean K(Canvas canvas, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, canvas, bitmap)) == null) {
            if (bitmap != null && !bitmap.isRecycled() && !E()) {
                Matrix matrix = new Matrix();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int width2 = (this.b.getWidth() - this.b.getPaddingLeft()) - this.b.getPaddingRight();
                int height2 = (this.b.getHeight() - this.b.getPaddingTop()) - this.b.getPaddingBottom();
                float f = width * height2 > width2 * height ? height2 / height : width2 / width;
                matrix.setScale(f, f);
                matrix.postTranslate(0.0f, 0.0f);
                canvas.drawBitmap(bitmap, matrix, null);
                return true;
            }
            return J(canvas);
        }
        return invokeLL.booleanValue;
    }

    public void L(float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            float f4 = this.i;
            float f5 = this.h;
            if (f4 * f < f5) {
                f = f5 / f4;
            }
            float f6 = this.i;
            float f7 = this.j;
            if (f6 * f > f7) {
                f = f7 / f6;
            }
            Rect o = this.f.o();
            float f8 = ((o.left + o.right) * 1.0f) / 2.0f;
            float f9 = ((o.top + o.bottom) * 1.0f) / 2.0f;
            tf5 tf5Var = this.f;
            if (tf5Var != null) {
                this.p.postScale(f, f, tf5Var.i() / 2, this.f.h() / 2);
                this.f.r(1.0f / f, f8, f9);
                float f10 = this.i * f;
                this.i = f10;
                this.f.s(1.0f / f10);
                float[] s = s();
                this.p.postTranslate(-s[0], -s[1]);
                tf5 tf5Var2 = this.f;
                float f11 = this.i;
                tf5Var2.p((s[0] * 1.0f) / f11, (s[1] * 1.0f) / f11);
                u();
                this.b.invalidate();
            }
        }
    }

    public boolean M(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            if (this.m == 2 && E()) {
                if (action == 0) {
                    if (!this.n.isFinished()) {
                        this.x = true;
                    } else {
                        this.x = false;
                    }
                    r();
                } else if (action == 1 || action == 3) {
                    r();
                }
                this.n.forceFinished(true);
                this.d.onTouchEvent(motionEvent);
                if (!this.d.isInProgress()) {
                    this.c.onTouchEvent(motionEvent);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public float N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : invokeV.floatValue;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ValueAnimator valueAnimator = this.u;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            BdAsyncTask<String, String, String> bdAsyncTask = this.y;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            yf5 yf5Var = this.o;
            if (yf5Var != null) {
                yf5Var.g();
            }
            tf5 tf5Var = this.f;
            if (tf5Var != null && tf5Var.d() != null) {
                this.f.d().clear();
            }
            Bitmap bitmap = this.s;
            if (bitmap != null) {
                bitmap.recycle();
                this.s = null;
            }
        }
    }

    public final void P(sf5 sf5Var, Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, sf5Var, rect, rect2) == null) {
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
            int c2 = sf5Var.d().c();
            int i9 = rect.left;
            int i10 = rect.top;
            sf5Var.k((i - i9) / c2, (i5 - i10) / c2, (i3 - i9) / c2, (i7 - i10) / c2);
            int i11 = rect2.left;
            int i12 = rect2.top;
            sf5Var.i((i - i11) / c2, (i5 - i12) / c2, (i3 - i11) / c2, (i7 - i12) / c2);
        }
    }

    public void Q(Bitmap bitmap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, bitmap, bArr) == null) || bArr == null || bArr.length == 0 || this.g != null) {
            return;
        }
        this.l = bitmap;
        wf5 wf5Var = new wf5(this.a);
        this.g = wf5Var;
        try {
            this.e = wf5Var.a(bArr);
        } catch (Throwable unused) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            try {
                this.e = this.g.a(bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.m = 2;
        V();
    }

    public void R(uf5 uf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, uf5Var) == null) {
            this.t = uf5Var;
        }
    }

    public void S(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.q = onClickListener;
        }
    }

    public void T(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onLongClickListener) == null) {
            this.r = onLongClickListener;
        }
    }

    public final void U(float f, float f2, float f3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i)}) == null) {
            ValueAnimator valueAnimator = this.u;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.i, f);
            this.u = ofFloat;
            ofFloat.setDuration(i);
            this.u.addUpdateListener(new a(this, f2, f3));
            this.u.start();
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.m != 2 || this.g == null || this.y.getStatus() != BdAsyncTask.BdAsyncTaskStatus.PENDING || this.f != null || this.b.getMeasuredWidth() <= 0 || this.b.getMeasuredHeight() <= 0 || this.g.b()[0] <= 0 || this.g.b()[1] <= 0) {
            return;
        }
        this.f = new tf5(this.b.getMeasuredWidth(), this.b.getMeasuredHeight(), this.g.b());
        this.y.setPriority(3);
        this.y.execute(new String[0]);
    }

    public final void W(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048598, this, i, i2, i3) == null) {
            yf5.d dVar = new yf5.d(i, i2, i3);
            dVar.d(this);
            this.o.h(dVar);
        }
    }

    public final void X() {
        List<sf5> d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (d2 = this.f.d()) == null) {
            return;
        }
        for (sf5 sf5Var : d2) {
            Y(sf5Var, this.f);
        }
    }

    public void Y(sf5 sf5Var, tf5 tf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, sf5Var, tf5Var) == null) {
            if (sf5Var.d().a() == 0 && sf5Var.d().b() == 1) {
                System.currentTimeMillis();
            }
            P(sf5Var, tf5Var.g(sf5Var), tf5Var.o());
        }
    }

    @Override // com.repackage.uf5
    public void onLoadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.b.postInvalidate();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            float f = this.i;
            float f2 = this.k;
            if (f / f2 < 1.0f) {
                U(f2, 0.0f, 0.0f, 400);
            }
        }
    }

    public final float[] s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            Rect o = this.f.o();
            int[] b2 = this.g.b();
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
            float f = fArr[0];
            float f2 = this.i;
            fArr[0] = f * f2;
            fArr[1] = fArr[1] * f2;
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.m == 1) {
                return false;
            }
            if (this.n.computeScrollOffset()) {
                int currX = this.n.getCurrX();
                int currY = this.n.getCurrY();
                float a2 = (currX - this.n.a()) * 2.0f;
                float b2 = (currY - this.n.b()) * 2.0f;
                int i = pi.i(TbadkCoreApplication.getInst());
                if (b2 >= 0.0f && Math.abs(b2) <= 20.0f && currX < i) {
                    I(0.0f, -20.0f);
                    this.b.invalidate();
                    return true;
                }
                this.n.c(currX);
                this.n.d(currY);
                I(-a2, -b2);
                this.b.invalidate();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.m == 1) {
            return;
        }
        w(this.f, true);
    }

    public final void v(Point[] pointArr, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{pointArr, Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            if (this.o == null) {
                this.o = new yf5(this.f, this.e);
            }
            int i2 = pointArr[0].x;
            boolean z3 = true;
            int i3 = pointArr[1].y;
            int i4 = pointArr[1].x;
            List<sf5> list = null;
            if (!z2) {
                list = this.f.d();
                list.clear();
            }
            for (int i5 = pointArr[0].y; i5 < i3; i5++) {
                for (int i6 = i2; i6 < i4; i6++) {
                    sf5 x = x(i5, i6, i);
                    if (x == null) {
                        if (z2) {
                            W(i5, i6, i);
                        }
                        z3 = false;
                    } else if (list != null && !z2) {
                        list.add(x);
                    }
                }
            }
            if (z3) {
                this.o.d(false);
            }
        }
    }

    public final void w(tf5 tf5Var, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048607, this, tf5Var, z2) == null) {
            v(tf5Var.m(), tf5Var.k(), z2);
        }
    }

    public final sf5 x(int i, int i2, int i3) {
        InterceptResult invokeIII;
        sf5 f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048608, this, i, i2, i3)) == null) {
            sf5.a aVar = new sf5.a(i, i2, i3);
            if (this.o.e() != null && (f = this.o.e().f(aVar)) != null) {
                if (f.b() != null && !f.b().isRecycled()) {
                    return f;
                }
                this.o.e().i(aVar);
            }
            return null;
        }
        return (sf5) invokeIII.objValue;
    }

    public float y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.k * 2.0f : invokeV.floatValue;
    }

    public float z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            float f = this.k;
            if (f < 1.0f) {
                return f;
            }
            return 1.0f;
        }
        return invokeV.floatValue;
    }
}
