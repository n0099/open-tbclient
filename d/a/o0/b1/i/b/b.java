package d.a.o0.b1.i.b;

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
import d.a.c.e.p.l;
import d.a.o0.b1.i.a.a;
import d.a.o0.b1.i.c.c;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements d.a.o0.b1.i.b.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f51668a;

    /* renamed from: b  reason: collision with root package name */
    public final View f51669b;

    /* renamed from: c  reason: collision with root package name */
    public GestureDetector f51670c;

    /* renamed from: d  reason: collision with root package name */
    public ScaleGestureDetector f51671d;

    /* renamed from: e  reason: collision with root package name */
    public BitmapRegionDecoder f51672e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.b1.i.a.b f51673f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.b1.i.c.a f51674g;

    /* renamed from: h  reason: collision with root package name */
    public float f51675h;

    /* renamed from: i  reason: collision with root package name */
    public float f51676i;
    public float j;
    public float k;
    public Bitmap l;
    public int m;
    public c n;
    public d.a.o0.b1.i.c.c o;
    public final Matrix p;
    public View.OnClickListener q;
    public View.OnLongClickListener r;
    public Bitmap s;
    public d.a.o0.b1.i.b.a t;
    public ValueAnimator u;
    public boolean v;
    public boolean w;
    public boolean x;
    public BdAsyncTask<String, String, String> y;

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f51677e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f51678f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f51679g;

        public a(b bVar, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51679g = bVar;
            this.f51677e = f2;
            this.f51678f = f3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                this.f51679g.L(((Float) valueAnimator.getAnimatedValue()).floatValue() / this.f51679g.f51676i, this.f51677e, this.f51678f);
            }
        }
    }

    /* renamed from: d.a.o0.b1.i.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1177b extends BdAsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f51680a;

        public C1177b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51680a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            double d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (this.f51680a.f51673f != null && this.f51680a.f51672e != null) {
                    int[] b2 = this.f51680a.f51674g.b();
                    int i2 = 1;
                    while (true) {
                        d2 = i2;
                        if (Math.max(b2[0] / this.f51680a.f51673f.i(), b2[1] / this.f51680a.f51673f.h()) <= Math.pow(2.0d, d2)) {
                            break;
                        }
                        i2++;
                    }
                    int pow = (int) Math.pow(2.0d, d2);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = pow;
                    Rect rect = new Rect(0, 0, b2[0], b2[1]);
                    try {
                        this.f51680a.s = this.f51680a.f51672e.decodeRegion(rect, options);
                    } catch (Throwable unused) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        System.gc();
                        try {
                            this.f51680a.s = this.f51680a.f51672e.decodeRegion(rect, options);
                        } catch (Throwable unused2) {
                            this.f51680a.s = null;
                        }
                    }
                    d.a.o0.a0.c.k().d("long_img_mThumb" + System.currentTimeMillis(), new d.a.c.k.d.a(this.f51680a.s, false));
                    b bVar = this.f51680a;
                    bVar.B(bVar.s, bVar.f51673f, pow);
                    this.f51680a.f51673f.t(this.f51680a.s);
                    this.f51680a.C();
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
                if (this.f51680a.t != null) {
                    this.f51680a.t.onLoadFinished();
                }
                this.f51680a.u();
                this.f51680a.f51669b.invalidate();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends Scroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f51681a;

        /* renamed from: b  reason: collision with root package name */
        public int f51682b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51681a = 0;
            this.f51682b = 0;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51681a : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51682b : invokeV.intValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f51681a = i2;
            }
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.f51682b = i2;
            }
        }

        @Override // android.widget.Scroller
        public void fling(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                this.f51681a = 0;
                this.f51682b = 0;
                super.fling(i2, i3, i4, i5, i6, i7, i8, i9);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f51683e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51683e = bVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f51683e.U(this.f51683e.f51676i == this.f51683e.j ? this.f51683e.k : this.f51683e.j, motionEvent.getX(), motionEvent.getY(), 400);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                Rect o = this.f51683e.f51673f.o();
                Rect f4 = this.f51683e.f51673f.f();
                this.f51683e.n.forceFinished(true);
                int i2 = (int) 0.0f;
                this.f51683e.n.fling(i2, i2, (int) f2, (int) f3, o.right - f4.right, o.left - f4.left, o.bottom - f4.bottom, o.top - f4.top);
                this.f51683e.f51669b.invalidate();
                if (Math.abs(f3) > b.z) {
                    this.f51683e.x = true;
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                if (this.f51683e.x || this.f51683e.r == null) {
                    this.f51683e.x = false;
                } else {
                    this.f51683e.r.onLongClick(this.f51683e.f51669b);
                }
                super.onLongPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f51683e.I((int) f2, (int) f3);
                if (Math.abs(f3) > b.z) {
                    this.f51683e.x = true;
                }
                if (this.f51683e.f51669b != null && this.f51683e.f51676i != this.f51683e.k) {
                    this.f51683e.f51669b.getParent().requestDisallowInterceptTouchEvent(true);
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
                if (this.f51683e.x || this.f51683e.q == null) {
                    this.f51683e.x = false;
                } else {
                    this.f51683e.q.onClick(this.f51683e.f51669b);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes7.dex */
    public class e extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f51684e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51684e = bVar;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scaleGestureDetector)) == null) {
                this.f51684e.L(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(414061091, "Ld/a/o0/b1/i/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(414061091, "Ld/a/o0/b1/i/b/b;");
                return;
            }
        }
        z = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
    }

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.y = new C1177b(this);
        this.f51669b = view;
        this.f51668a = view.getContext();
        this.f51670c = new GestureDetector(this.f51668a, new d(this, null));
        this.f51671d = new ScaleGestureDetector(this.f51668a, new e(this, null));
        this.n = new c(this, this.f51668a);
        this.m = 0;
    }

    public final float[] A(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = new float[2];
            Rect o = this.f51673f.o();
            int[] b2 = this.f51674g.b();
            if (o.top + f3 < 0.0f) {
                f3 = 0.0f;
            }
            int i2 = o.bottom;
            if (i2 + f3 > b2[1]) {
                f3 = (b2[1] - i2) * this.f51676i;
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
        return (float[]) invokeCommon.objValue;
    }

    public final void B(Bitmap bitmap, d.a.o0.b1.i.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, bVar, i2) == null) {
            float max = Math.max((bVar.i() * 1.0f) / bitmap.getWidth(), (bVar.h() * 1.0f) / bitmap.getHeight());
            this.p.postScale(max, max);
            float f2 = (1.0f / i2) * max;
            this.f51675h = f2;
            this.k = f2;
            this.f51676i = f2;
            this.j = f2 * 2.0f;
            float i3 = (bVar.i() * 1.0f) / this.f51672e.getWidth();
            if (i3 > 1.0f) {
                this.f51675h /= i3;
            }
            bVar.s(1.0f / this.f51676i);
        }
    }

    public final void C() {
        d.a.o0.b1.i.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f51673f) == null) {
            return;
        }
        bVar.q(1.0f / this.k);
    }

    public boolean D() {
        InterceptResult invokeV;
        Rect o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.o0.b1.i.a.b bVar = this.f51673f;
            return (bVar == null || (o = bVar.o()) == null || o.top > 10) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.o0.b1.i.a.b bVar = this.f51673f;
            return (bVar == null || bVar.n() == null || this.f51673f.n().b() == null || this.f51673f.n().b().isRecycled()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Math.floor((double) (this.k * 10000.0f)) == Math.floor((double) (this.f51676i * 10000.0f)) : invokeV.booleanValue;
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

    public void I(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.f51673f == null) {
            return;
        }
        float[] A = A(f2, f3);
        float f4 = A[0];
        float f5 = A[1];
        this.p.postTranslate(-f4, -f5);
        d.a.o0.b1.i.a.b bVar = this.f51673f;
        float f6 = this.f51676i;
        bVar.p((f4 * 1.0f) / f6, (f5 * 1.0f) / f6);
        u();
        this.f51669b.invalidate();
    }

    public boolean J(Canvas canvas) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, canvas)) == null) {
            if (this.m != 1 || this.l == null) {
                d.a.o0.b1.i.a.b bVar = this.f51673f;
                if (bVar != null) {
                    bVar.o();
                    if (E()) {
                        canvas.drawBitmap(this.f51673f.n().b(), this.p, null);
                    }
                    w(this.f51673f, false);
                    X();
                    canvas.save();
                    float k = (this.f51673f.k() * 1.0f) / this.f51673f.l();
                    canvas.scale(k, k);
                    List<d.a.o0.b1.i.a.a> d2 = this.f51673f.d();
                    if (d2 != null) {
                        for (d.a.o0.b1.i.a.a aVar : d2) {
                            canvas.drawBitmap(aVar.b(), aVar.f(), aVar.c(), (Paint) null);
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
                int width2 = (this.f51669b.getWidth() - this.f51669b.getPaddingLeft()) - this.f51669b.getPaddingRight();
                int height2 = (this.f51669b.getHeight() - this.f51669b.getPaddingTop()) - this.f51669b.getPaddingBottom();
                float f2 = width * height2 > width2 * height ? height2 / height : width2 / width;
                matrix.setScale(f2, f2);
                matrix.postTranslate(0.0f, 0.0f);
                canvas.drawBitmap(bitmap, matrix, null);
                return true;
            }
            return J(canvas);
        }
        return invokeLL.booleanValue;
    }

    public void L(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            float f5 = this.f51676i;
            float f6 = this.f51675h;
            if (f5 * f2 < f6) {
                f2 = f6 / f5;
            }
            float f7 = this.f51676i;
            float f8 = this.j;
            if (f7 * f2 > f8) {
                f2 = f8 / f7;
            }
            Rect o = this.f51673f.o();
            float f9 = ((o.left + o.right) * 1.0f) / 2.0f;
            float f10 = ((o.top + o.bottom) * 1.0f) / 2.0f;
            d.a.o0.b1.i.a.b bVar = this.f51673f;
            if (bVar != null) {
                this.p.postScale(f2, f2, bVar.i() / 2, this.f51673f.h() / 2);
                this.f51673f.r(1.0f / f2, f9, f10);
                float f11 = this.f51676i * f2;
                this.f51676i = f11;
                this.f51673f.s(1.0f / f11);
                float[] s = s();
                this.p.postTranslate(-s[0], -s[1]);
                d.a.o0.b1.i.a.b bVar2 = this.f51673f;
                float f12 = this.f51676i;
                bVar2.p((s[0] * 1.0f) / f12, (s[1] * 1.0f) / f12);
                u();
                this.f51669b.invalidate();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r0 != 3) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean M(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
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
                this.f51671d.onTouchEvent(motionEvent);
                if (!this.f51671d.isInProgress()) {
                    this.f51670c.onTouchEvent(motionEvent);
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
            d.a.o0.b1.i.c.c cVar = this.o;
            if (cVar != null) {
                cVar.g();
            }
            d.a.o0.b1.i.a.b bVar = this.f51673f;
            if (bVar != null && bVar.d() != null) {
                this.f51673f.d().clear();
            }
            Bitmap bitmap = this.s;
            if (bitmap != null) {
                bitmap.recycle();
                this.s = null;
            }
        }
    }

    public final void P(d.a.o0.b1.i.a.a aVar, Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, aVar, rect, rect2) == null) {
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
    }

    public void Q(Bitmap bitmap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, bitmap, bArr) == null) || bArr == null || bArr.length == 0 || this.f51674g != null) {
            return;
        }
        this.l = bitmap;
        d.a.o0.b1.i.c.a aVar = new d.a.o0.b1.i.c.a(this.f51668a);
        this.f51674g = aVar;
        try {
            this.f51672e = aVar.a(bArr);
        } catch (Throwable unused) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            try {
                this.f51672e = this.f51674g.a(bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.m = 2;
        V();
    }

    public void R(d.a.o0.b1.i.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.t = aVar;
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

    public final void U(float f2, float f3, float f4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)}) == null) {
            ValueAnimator valueAnimator = this.u;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f51676i, f2);
            this.u = ofFloat;
            ofFloat.setDuration(i2);
            this.u.addUpdateListener(new a(this, f3, f4));
            this.u.start();
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.m != 2 || this.f51674g == null || this.y.getStatus() != BdAsyncTask.BdAsyncTaskStatus.PENDING || this.f51673f != null || this.f51669b.getMeasuredWidth() <= 0 || this.f51669b.getMeasuredHeight() <= 0 || this.f51674g.b()[0] <= 0 || this.f51674g.b()[1] <= 0) {
            return;
        }
        this.f51673f = new d.a.o0.b1.i.a.b(this.f51669b.getMeasuredWidth(), this.f51669b.getMeasuredHeight(), this.f51674g.b());
        this.y.setPriority(3);
        this.y.execute(new String[0]);
    }

    public final void W(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048598, this, i2, i3, i4) == null) {
            c.d dVar = new c.d(i2, i3, i4);
            dVar.d(this);
            this.o.h(dVar);
        }
    }

    public final void X() {
        List<d.a.o0.b1.i.a.a> d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (d2 = this.f51673f.d()) == null) {
            return;
        }
        for (d.a.o0.b1.i.a.a aVar : d2) {
            Y(aVar, this.f51673f);
        }
    }

    public void Y(d.a.o0.b1.i.a.a aVar, d.a.o0.b1.i.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, aVar, bVar) == null) {
            if (aVar.d().a() == 0 && aVar.d().b() == 1) {
                System.currentTimeMillis();
            }
            P(aVar, bVar.g(aVar), bVar.o());
        }
    }

    @Override // d.a.o0.b1.i.b.a
    public void onLoadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f51669b.postInvalidate();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            float f2 = this.f51676i;
            float f3 = this.k;
            if (f2 / f3 < 1.0f) {
                U(f3, 0.0f, 0.0f, 400);
            }
        }
    }

    public final float[] s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            Rect o = this.f51673f.o();
            int[] b2 = this.f51674g.b();
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
            float f3 = this.f51676i;
            fArr[0] = f2 * f3;
            fArr[1] = fArr[1] * f3;
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
                int i2 = l.i(TbadkCoreApplication.getInst());
                if (b2 >= 0.0f && Math.abs(b2) <= 20.0f && currX < i2) {
                    I(0.0f, -20.0f);
                    this.f51669b.invalidate();
                    return true;
                }
                this.n.c(currX);
                this.n.d(currY);
                I(-a2, -b2);
                this.f51669b.invalidate();
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
        w(this.f51673f, true);
    }

    public final void v(Point[] pointArr, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{pointArr, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            if (this.o == null) {
                this.o = new d.a.o0.b1.i.c.c(this.f51673f, this.f51672e);
            }
            int i3 = pointArr[0].x;
            boolean z3 = true;
            int i4 = pointArr[1].y;
            int i5 = pointArr[1].x;
            List<d.a.o0.b1.i.a.a> list = null;
            if (!z2) {
                list = this.f51673f.d();
                list.clear();
            }
            for (int i6 = pointArr[0].y; i6 < i4; i6++) {
                for (int i7 = i3; i7 < i5; i7++) {
                    d.a.o0.b1.i.a.a x = x(i6, i7, i2);
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
    }

    public final void w(d.a.o0.b1.i.a.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048607, this, bVar, z2) == null) {
            v(bVar.m(), bVar.k(), z2);
        }
    }

    public final d.a.o0.b1.i.a.a x(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        d.a.o0.b1.i.a.a f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048608, this, i2, i3, i4)) == null) {
            a.C1176a c1176a = new a.C1176a(i2, i3, i4);
            if (this.o.e() != null && (f2 = this.o.e().f(c1176a)) != null) {
                if (f2.b() != null && !f2.b().isRecycled()) {
                    return f2;
                }
                this.o.e().i(c1176a);
            }
            return null;
        }
        return (d.a.o0.b1.i.a.a) invokeIII.objValue;
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
            float f2 = this.k;
            if (f2 < 1.0f) {
                return f2;
            }
            return 1.0f;
        }
        return invokeV.floatValue;
    }
}
