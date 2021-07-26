package d.a.q0.h2.k.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e extends d.a.p0.d1.m.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static double H = 0.5d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f57783a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57783a = eVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i2;
            float f2;
            float f3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null || tbImageView.getScaleType() != ImageView.ScaleType.MATRIX) {
                return;
            }
            Matrix imageMatrix = tbImageView.getImageMatrix();
            d.a.d.k.d.a m = d.a.p0.b0.c.k().m(d.a.d.e.l.d.h().g(tbImageView.getUrl(), this.f57783a.r ? 17 : 18));
            int i3 = 0;
            if (m != null) {
                i3 = m.r();
                i2 = m.m();
            } else {
                i2 = 0;
            }
            if (i3 == 0 || i2 == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            if (i3 * height > width * i2) {
                f2 = height;
                f3 = i2;
            } else {
                f2 = width;
                f3 = i3;
            }
            float f4 = f2 / f3;
            imageMatrix.setScale(f4, f4);
            imageMatrix.postTranslate(0.0f, 0.0f);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(217592446, "Ld/a/q0/h2/k/e/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(217592446, "Ld/a/q0/h2/k/e/e;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d.a.p0.d1.m.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.p0.d1.m.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        k(true);
        t();
        o(TbConfig.getPostLineSpace(), 1.0f);
        y(0);
        l(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        m(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        i(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        r(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        j(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        this.D = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds749);
        this.E = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        this.F = new a(this);
    }

    @Override // d.a.p0.d1.m.a
    public int[] e(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i2, i3, i4, i5)) == null) {
            if (i3 <= 0 || i2 <= 0 || i4 <= 0 || i5 <= 0) {
                return null;
            }
            if (this.s) {
                float f2 = d.a.p0.d1.m.a.G;
                if (f2 > 1.0f) {
                    float f3 = i2;
                    if (f3 * f2 <= i4 * H) {
                        i4 = (int) (f3 * f2);
                    }
                    i3 = (i3 * i4) / i2;
                    if (i3 > 4096) {
                        this.p = ImageView.ScaleType.MATRIX;
                        i2 = i4;
                        i3 = 4096;
                    } else {
                        this.p = ImageView.ScaleType.CENTER_CROP;
                        i2 = i4;
                    }
                }
            }
            return new int[]{i2, i3};
        }
        return (int[]) invokeIIII.objValue;
    }
}
