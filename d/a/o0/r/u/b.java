package d.a.o0.r.u;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes7.dex */
public class b extends Drawable implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RectF A;
    public Path B;
    public Path C;
    public Path D;
    public View.OnLayoutChangeListener E;
    public int F;

    /* renamed from: e  reason: collision with root package name */
    public int f52961e;

    /* renamed from: f  reason: collision with root package name */
    public View f52962f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f52963g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f52964h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f52965i;
    public float j;
    public int k;
    public float l;
    public float m;
    public int n;
    public int o;
    public int p;
    public float[] q;
    public float[] r;
    public int s;
    public int t;
    public int[] u;
    public LinearGradient v;
    public float[] w;
    public float[] x;
    public String y;
    public RectF z;

    /* loaded from: classes7.dex */
    public class a implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f52966e;

        /* renamed from: d.a.o0.r.u.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1219a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ View f52967e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ViewGroup.MarginLayoutParams f52968f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f52969g;

            public RunnableC1219a(a aVar, View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view, marginLayoutParams};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52969g = aVar;
                this.f52967e = view;
                this.f52968f = marginLayoutParams;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f52967e.setLayoutParams(this.f52968f);
                }
            }
        }

        public a(b bVar) {
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
            this.f52966e = bVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                if (view.getBackground() instanceof b) {
                    b bVar = (b) view.getBackground();
                    this.f52966e.n = bVar.n;
                    this.f52966e.s = bVar.s;
                    this.f52966e.t = bVar.t;
                    this.f52966e.r = bVar.r;
                }
                float[] u = this.f52966e.u();
                if (this.f52966e.p == 1) {
                    u[0] = (this.f52966e.F & 1) == 1 ? u[0] : 0.0f;
                    u[1] = (this.f52966e.F & 16) == 16 ? u[1] : 0.0f;
                    u[2] = (this.f52966e.F & 256) == 256 ? u[2] : 0.0f;
                    u[3] = (this.f52966e.F & 4096) == 4096 ? u[3] : 0.0f;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.leftMargin -= (int) u[0];
                    marginLayoutParams.topMargin -= (int) u[1];
                    marginLayoutParams.rightMargin -= (int) u[2];
                    marginLayoutParams.bottomMargin -= (int) u[3];
                    marginLayoutParams.width = (i4 - i2) + ((int) u[0]) + ((int) u[2]);
                    marginLayoutParams.height = (i5 - i3) + ((int) u[1]) + ((int) u[3]);
                    view.post(new RunnableC1219a(this, view, marginLayoutParams));
                }
                view.removeOnLayoutChangeListener(this);
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52961e = 0;
        this.j = 1.0f;
        this.k = 0;
        this.l = 1.0f;
        this.m = 0.0f;
        this.p = 1;
        this.q = new float[8];
        this.r = new float[8];
        this.u = new int[]{0};
        this.w = new float[]{0.0f, 1.0f};
        this.x = new float[]{0.0f, 1.0f};
        this.y = TipsConfigItem.TipConfigData.BOTTOM;
        this.z = new RectF();
        this.A = new RectF();
        this.B = new Path();
        this.C = new Path();
        this.D = new Path();
        this.E = new a(this);
        this.F = ShadowDrawable.ALL;
        Paint paint = new Paint();
        this.f52964h = paint;
        paint.setColor(0);
        this.f52964h.setAntiAlias(true);
        this.f52964h.setShadowLayer(this.n, this.s, this.t, this.o);
        this.f52964h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.f52963g = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f52965i = paint3;
        paint3.setColor(this.k);
        this.f52965i.setAlpha((int) (this.l * 255.0f));
        this.f52965i.setStrokeWidth(this.m);
        this.f52965i.setStyle(Paint.Style.STROKE);
        this.f52965i.setAntiAlias(true);
    }

    public static b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? new b() : (b) invokeV.objValue;
    }

    public b A(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
            if (this.j != f2) {
                this.j = f2;
            }
            return this;
        }
        return (b) invokeF.objValue;
    }

    public b B(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int[] iArr = this.u;
            if (iArr.length == 1 && iArr[0] == i2) {
                return this;
            }
            this.u = r0;
            int[] iArr2 = {i2};
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b C(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr)) == null) {
            if (Arrays.equals(this.u, iArr)) {
                return this;
            }
            this.u = iArr;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b D(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            if (this.l == f2) {
                return this;
            }
            this.l = f2;
            return this;
        }
        return (b) invokeF.objValue;
    }

    public b E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (this.k == i2) {
                return this;
            }
            this.k = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b F(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
            if (this.m == f2) {
                return this;
            }
            this.m = f2;
            return this;
        }
        return (b) invokeF.objValue;
    }

    public b G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (this.f52961e == i2) {
                return this;
            }
            this.f52961e = i2;
            Q();
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.y.equals(str)) {
                return this;
            }
            this.y = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (this.s == i2) {
                return this;
            }
            this.s = i2;
            this.f52964h.setShadowLayer(this.n, i2, this.t, this.o);
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            int i3 = this.s;
            if (i3 == i2) {
                return this;
            }
            this.t = i2;
            this.f52964h.setShadowLayer(this.n, i3, i2, this.o);
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b K(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, fArr)) == null) {
            if (Arrays.equals(this.w, fArr)) {
                return this;
            }
            this.w = fArr;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b L(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (this.o == i2) {
                return this;
            }
            this.o = i2;
            this.f52964h.setShadowLayer(this.n, this.s, this.t, i2);
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (this.n == i2) {
                return this;
            }
            this.n = i2;
            this.f52964h.setShadowLayer(i2, this.s, this.t, this.o);
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (this.F == i2) {
                return this;
            }
            this.F = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            if (this.p == i2) {
                return this;
            }
            this.p = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b P(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, fArr)) == null) {
            if (Arrays.equals(this.q, fArr)) {
                return this;
            }
            System.arraycopy(fArr, 0, this.q, 0, Math.min(fArr.length, 8));
            Q();
            return this;
        }
        return (b) invokeL.objValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            float[] fArr = this.q;
            float[] fArr2 = this.r;
            System.arraycopy(fArr, 0, fArr2, 0, Math.min(fArr2.length, 8));
            int i2 = this.f52961e;
            if (i2 == 1) {
                for (int i3 = 4; i3 < 8; i3++) {
                    this.r[i3] = 0.0f;
                }
            } else if (i2 == 2) {
                for (int i4 = 0; i4 < 4; i4++) {
                    this.r[i4] = 0.0f;
                }
            }
        }
    }

    public Object clone() {
        b bVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            try {
                bVar = (b) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                bVar = null;
            }
            if (bVar == null) {
                return this;
            }
            bVar.O(this.p);
            bVar.N(this.F);
            bVar.G(this.f52961e);
            bVar.P((float[]) this.q.clone());
            bVar.L(this.o);
            bVar.M(this.n);
            bVar.I(this.s);
            bVar.J(this.t);
            bVar.C((int[]) this.u.clone());
            bVar.K((float[]) this.w.clone());
            bVar.H(this.y);
            bVar.E(this.k);
            bVar.D(this.l);
            bVar.F(this.m);
            bVar.A(this.j);
            return bVar;
        }
        return invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, canvas) == null) {
            int[] q = q();
            if (q != null) {
                if (q.length == 1) {
                    this.f52963g.setColor(q[0]);
                } else {
                    PointF w = w(this.z, this.y);
                    PointF v = v(this.z, this.y);
                    LinearGradient linearGradient = new LinearGradient(w.x, w.y, v.x, v.y, q, this.x, Shader.TileMode.CLAMP);
                    this.v = linearGradient;
                    this.f52963g.setShader(linearGradient);
                }
            }
            this.f52965i.setColor(d.a.p0.h3.c.a(this.k, this.j));
            this.f52965i.setAlpha((int) (this.l * 255.0f));
            this.f52965i.setStrokeWidth(this.m);
            int i2 = this.p;
            if (i2 == 1) {
                p(canvas);
                canvas.drawPath(this.C, this.f52963g);
                o(canvas);
            } else if (i2 == 2) {
                canvas.drawCircle(this.z.centerX(), this.z.centerY(), Math.min(this.z.width(), this.z.height()) / 2.0f, this.f52964h);
                canvas.drawCircle(this.z.centerX(), this.z.centerY(), Math.min(this.z.width(), this.z.height()) / 2.0f, this.f52963g);
                canvas.drawCircle(this.z.centerX(), this.z.centerY(), (Math.min(this.z.width(), this.z.height()) / 2.0f) - (this.m * 0.5f), this.f52965i);
            } else {
                canvas.drawRect(this.z, this.f52963g);
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return hashCode() == bVar.hashCode() && this.f52961e == bVar.f52961e && this.n == bVar.n && this.o == bVar.o && this.p == bVar.p && this.s == bVar.s && this.t == bVar.t && this.F == bVar.F && Arrays.equals(this.q, bVar.q) && Arrays.equals(this.r, bVar.r) && Arrays.equals(this.u, bVar.u) && Arrays.equals(this.w, bVar.w) && this.y.equals(bVar.y) && this.k == bVar.k && this.l == bVar.l && this.m == bVar.m && this.j == bVar.j;
        }
        return invokeL.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (((((((Objects.hash(Integer.valueOf(this.f52961e), Integer.valueOf(this.n), Integer.valueOf(this.o), Integer.valueOf(this.p), Integer.valueOf(this.s), Integer.valueOf(this.t), this.y, Integer.valueOf(this.F), Integer.valueOf(this.k), Float.valueOf(this.l), Float.valueOf(this.m), Float.valueOf(this.j)) * 31) + Arrays.hashCode(this.q)) * 31) + Arrays.hashCode(this.r)) * 31) + Arrays.hashCode(this.u)) * 31) + Arrays.hashCode(this.w) : invokeV.intValue;
    }

    public GradientDrawable l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            int length = this.r.length;
            for (int i3 = 0; i3 < length; i3++) {
                float[] fArr = this.r;
                if (fArr[i3] > 0.0f && fArr[i3] < 1.0f) {
                    fArr[i3] = fArr[i3] * i2;
                }
            }
            gradientDrawable.setCornerRadii(this.r);
            gradientDrawable.setAlpha((int) (this.j * 255.0f));
            return gradientDrawable;
        }
        return (GradientDrawable) invokeI.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void m(float[] fArr, float[] fArr2) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, fArr, fArr2) == null) {
            String str = this.y;
            switch (str.hashCode()) {
                case -1383228885:
                    if (str.equals(TipsConfigItem.TipConfigData.BOTTOM)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3317767:
                    if (str.equals(CustomDialogData.POS_LEFT)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                RectF rectF = this.z;
                float f2 = rectF.top;
                float height = rectF.height();
                float[] fArr3 = this.w;
                rectF.bottom = f2 + (height * fArr3[fArr3.length - 1]);
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
            } else if (c2 == 1) {
                RectF rectF2 = this.z;
                float f3 = rectF2.bottom;
                float height2 = rectF2.height();
                float[] fArr4 = this.w;
                rectF2.top = f3 - (height2 * fArr4[fArr4.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
            } else if (c2 == 2) {
                RectF rectF3 = this.z;
                float f4 = rectF3.right;
                float width = rectF3.width();
                float[] fArr5 = this.w;
                rectF3.left = f4 - (width * fArr5[fArr5.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
            } else if (c2 == 3) {
                RectF rectF4 = this.z;
                float f5 = rectF4.left;
                float width2 = rectF4.width();
                float[] fArr6 = this.w;
                rectF4.right = f5 + (width2 * fArr6[fArr6.length - 1]);
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
            }
            fArr2[fArr2.length - 1] = 1.0f;
        }
    }

    public b n(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, view)) == null) {
            if (view == null) {
                return null;
            }
            this.f52962f = view;
            if (equals(view.getBackground())) {
                return null;
            }
            this.f52962f.removeOnLayoutChangeListener(this.E);
            this.f52962f.addOnLayoutChangeListener(this.E);
            return this;
        }
        return (b) invokeL.objValue;
    }

    public void o(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, canvas) == null) || this.m == 0.0f || this.l == 0.0f || this.k == 0) {
            return;
        }
        canvas.drawPath(this.D, this.f52965i);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, rect) == null) {
            super.onBoundsChange(rect);
            int length = this.r.length;
            for (int i2 = 0; i2 < length; i2++) {
                float[] fArr = this.r;
                if (fArr[i2] > 0.0f && fArr[i2] < 1.0f) {
                    fArr[i2] = fArr[i2] * rect.height();
                }
            }
            float[] u = u();
            this.z = new RectF(rect.left + u[0], rect.top + u[1], rect.right - u[2], rect.bottom - u[3]);
            this.B.reset();
            this.B.addRoundRect(this.z, this.r, Path.Direction.CW);
            this.x = (float[]) this.w.clone();
            float[] fArr2 = (float[]) this.r.clone();
            int[] iArr = this.u;
            if (iArr != null && iArr.length > 1 && x()) {
                m(fArr2, this.x);
            }
            this.C.reset();
            this.C.addRoundRect(this.z, fArr2, Path.Direction.CW);
            float f2 = this.m * 0.5f;
            float[] fArr3 = (float[]) this.r.clone();
            for (int i3 = 0; i3 < fArr3.length; i3++) {
                fArr3[i3] = fArr3[i3] - this.m;
                if (fArr3[i3] < 0.0f) {
                    fArr3[i3] = 0.0f;
                }
            }
            RectF rectF = this.z;
            this.A = new RectF(rectF.left + f2, rectF.top + f2, rectF.right - f2, rectF.bottom - f2);
            this.D.reset();
            this.D.addRoundRect(this.A, fArr3, Path.Direction.CW);
        }
    }

    public void p(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, canvas) == null) {
            if (this.n == 0 && this.s == 0 && this.t == 0) {
                return;
            }
            canvas.drawPath(this.B, this.f52964h);
        }
    }

    public final int[] q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            int[] iArr = this.u;
            if (iArr == null) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr2[i2] = d.a.p0.h3.c.a(this.u[i2], this.j);
            }
            return iArr2;
        }
        return (int[]) invokeV.objValue;
    }

    public float r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.l : invokeV.floatValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.f52964h.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, colorFilter) == null) {
            this.f52964h.setColorFilter(colorFilter);
        }
    }

    public float t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.m : invokeV.floatValue;
    }

    public final float[] u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            float[] fArr = new float[4];
            int i2 = this.p;
            if (i2 == 1) {
                fArr[0] = (this.F & 1) == 1 ? this.n - this.s : -this.r[0];
                fArr[1] = (this.F & 16) == 16 ? this.n - this.t : -this.r[2];
                fArr[2] = (this.F & 256) == 256 ? this.n + this.s : -this.r[4];
                fArr[3] = (this.F & 4096) == 4096 ? this.n + this.t : -this.r[6];
            } else if (i2 == 2) {
                Arrays.fill(fArr, this.n);
            }
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final PointF v(RectF rectF, String str) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, rectF, str)) == null) {
            switch (str.hashCode()) {
                case -1383228885:
                    if (str.equals(TipsConfigItem.TipConfigData.BOTTOM)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3317767:
                    if (str.equals(CustomDialogData.POS_LEFT)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return new PointF();
                        }
                        return new PointF(rectF.right, rectF.height() / 2.0f);
                    }
                    return new PointF(rectF.left, rectF.height() / 2.0f);
                }
                return new PointF(rectF.width() / 2.0f, rectF.top);
            }
            return new PointF(rectF.width() / 2.0f, rectF.bottom);
        }
        return (PointF) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final PointF w(RectF rectF, String str) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, rectF, str)) == null) {
            switch (str.hashCode()) {
                case -1383228885:
                    if (str.equals(TipsConfigItem.TipConfigData.BOTTOM)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3317767:
                    if (str.equals(CustomDialogData.POS_LEFT)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return new PointF();
                        }
                        return new PointF(rectF.left, rectF.height() / 2.0f);
                    }
                    return new PointF(rectF.right, rectF.height() / 2.0f);
                }
                return new PointF(rectF.width() / 2.0f, rectF.bottom);
            }
            return new PointF(rectF.width() / 2.0f, rectF.top);
        }
        return (PointF) invokeLL.objValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            float[] fArr = this.w;
            return fArr != null && fArr.length >= 1 && fArr[fArr.length - 1] < 1.0f;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (view = this.f52962f) == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.E);
        this.f52962f.setLayerType(0, null);
        this.f52962f = null;
    }
}
