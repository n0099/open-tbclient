package d.a.o0.b1.m;

import android.content.res.TypedArray;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final float G;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public int D;
    public int E;
    public TbImageView.g F;

    /* renamed from: a  reason: collision with root package name */
    public float f51715a;

    /* renamed from: b  reason: collision with root package name */
    public float f51716b;

    /* renamed from: c  reason: collision with root package name */
    public int f51717c;

    /* renamed from: d  reason: collision with root package name */
    public int f51718d;

    /* renamed from: e  reason: collision with root package name */
    public float f51719e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51720f;

    /* renamed from: g  reason: collision with root package name */
    public int f51721g;

    /* renamed from: h  reason: collision with root package name */
    public int f51722h;

    /* renamed from: i  reason: collision with root package name */
    public int f51723i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public int o;
    public ImageView.ScaleType p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1403900403, "Ld/a/o0/b1/m/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1403900403, "Ld/a/o0/b1/m/a;");
                return;
            }
        }
        G = l.h(TbadkCoreApplication.getInst());
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51715a = 0.0f;
        this.f51716b = 0.0f;
        this.f51717c = 0;
        this.f51718d = 0;
        this.f51719e = 15.0f;
        this.f51720f = false;
        this.f51721g = -1;
        this.f51722h = -1;
        this.f51723i = -16777216;
        this.j = 200;
        this.k = 200;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = -9989158;
        this.p = ImageView.ScaleType.CENTER_CROP;
        this.q = false;
        this.t = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
        this.u = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.v = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        this.w = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.x = 0;
        this.y = -1;
        this.z = -1;
        this.A = -1;
        this.B = 0;
        this.C = false;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f51715a = aVar.f51715a;
            this.f51716b = aVar.f51716b;
            this.f51717c = aVar.f51717c;
            this.f51718d = aVar.f51718d;
            this.f51719e = aVar.f51719e;
            this.f51721g = aVar.f51721g;
            this.f51722h = aVar.f51722h;
            this.f51723i = aVar.f51723i;
            this.j = aVar.j;
            this.k = aVar.k;
            this.l = aVar.l;
            this.m = aVar.m;
            this.n = aVar.n;
            this.r = aVar.r;
            this.o = aVar.o;
            this.q = aVar.q;
            this.s = aVar.s;
            this.t = aVar.t;
            this.u = aVar.u;
            this.w = aVar.w;
            this.x = aVar.x;
            this.y = aVar.y;
            this.z = aVar.f51718d;
            this.A = aVar.A;
            this.C = aVar.C;
        }
    }

    public void b(TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typedArray) == null) {
            this.f51718d = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_segmentMargin, 0);
            this.f51717c = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_textPadding, 0);
            this.f51715a = typedArray.getFloat(R$styleable.TbRichTextView_tbLineSpacing, 1.12f);
            this.f51719e = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_textSize, (int) this.f51719e);
            this.f51723i = typedArray.getColor(R$styleable.TbRichTextView_textColor, this.f51723i);
            this.j = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_maxImageWidth, this.j);
            this.k = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_maxImageHeight, this.k);
            this.l = typedArray.getResourceId(R$styleable.TbRichTextView_defaultImage, 0);
            this.f51721g = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_faceWidth, this.f51721g);
            this.f51722h = typedArray.getDimensionPixelSize(R$styleable.TbRichTextView_faceHeight, this.f51722h);
            this.m = typedArray.getResourceId(R$styleable.TbRichTextView_videoImage, 0);
            this.n = typedArray.getBoolean(R$styleable.TbRichTextView_singleLine, false);
            this.z = this.f51718d;
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public int[] e(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048580, this, i2, i3, i4, i5)) == null) {
            int[] l = l.l(i2, i3, i4, i5);
            if (l == null) {
                return null;
            }
            int[] iArr = {l[0], l[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.s && i4 > i6) {
                float f2 = G;
                if (f2 > 1.0f) {
                    float f3 = i6;
                    float f4 = i4;
                    if (f3 * f2 <= f4) {
                        float f5 = f4 * 0.68f;
                        i4 = f3 * f2 > f5 ? (int) f5 : (int) (f3 * f2);
                    }
                    if (iArr[0] > 0) {
                        i7 = (iArr[1] * i4) / iArr[0];
                    }
                    i6 = i4;
                }
            }
            return new int[]{i6, i7};
        }
        return (int[]) invokeIIII.objValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.v = i2;
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.l = i2;
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.B = i2;
        }
    }

    public void i(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            this.f51721g = i2;
            this.f51722h = i3;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.A = i2;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.s = z;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.y = i2;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.z = i2;
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.f51715a = f2;
        }
    }

    public void o(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f51715a = f3;
            this.f51716b = f2;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.k = i2;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.j = i2;
        }
    }

    public void r(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            this.t = i2;
            this.u = i3;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f51718d = i2;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.q = true;
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.w = i2;
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f51719e = i2;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.C = z;
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.m = i2;
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.x = i2;
        }
    }

    public a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f51715a = 0.0f;
        this.f51716b = 0.0f;
        this.f51717c = 0;
        this.f51718d = 0;
        this.f51719e = 15.0f;
        this.f51720f = false;
        this.f51721g = -1;
        this.f51722h = -1;
        this.f51723i = -16777216;
        this.j = 200;
        this.k = 200;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = -9989158;
        this.p = ImageView.ScaleType.CENTER_CROP;
        this.q = false;
        this.t = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
        this.u = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.v = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        this.w = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.x = 0;
        this.y = -1;
        this.z = -1;
        this.A = -1;
        this.B = 0;
        this.C = false;
        if (aVar != null) {
            a(aVar);
        }
    }
}
