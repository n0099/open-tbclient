package com.repackage;

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
/* loaded from: classes5.dex */
public class bt7 extends kf5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static double L = 0.5d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt7 a;

        public a(bt7 bt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bt7Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i;
            float f;
            float f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null || tbImageView.getScaleType() != ImageView.ScaleType.MATRIX) {
                return;
            }
            Matrix imageMatrix = tbImageView.getImageMatrix();
            ym m = j35.k().m(jg.h().g(tbImageView.getUrl(), this.a.s ? 17 : 18));
            int i2 = 0;
            if (m != null) {
                i2 = m.r();
                i = m.m();
            } else {
                i = 0;
            }
            if (i2 == 0 || i == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            if (i2 * height > width * i) {
                f = height;
                f2 = i;
            } else {
                f = width;
                f2 = i2;
            }
            float f3 = f / f2;
            imageMatrix.setScale(f3, f3);
            imageMatrix.postTranslate(0.0f, 0.0f);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755815380, "Lcom/repackage/bt7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755815380, "Lcom/repackage/bt7;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt7(kf5 kf5Var) {
        super(kf5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kf5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((kf5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        k(true);
        t();
        o(TbConfig.getPostLineSpace(), 1.0f);
        y(0);
        l(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        m(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        i(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        r(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        j(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        this.H = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds749);
        this.I = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        this.J = new a(this);
    }

    @Override // com.repackage.kf5
    public int[] e(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i, i2, i3, i4)) == null) {
            if (i2 <= 0 || i <= 0 || i3 <= 0 || i4 <= 0) {
                return null;
            }
            if (this.t) {
                float f = kf5.K;
                if (f > 1.0f) {
                    float f2 = i;
                    if (f2 * f <= i3 * L) {
                        i3 = (int) (f2 * f);
                    }
                    i2 = (i2 * i3) / i;
                    if (i2 > 4096) {
                        this.q = ImageView.ScaleType.MATRIX;
                        i = i3;
                        i2 = 4096;
                    } else {
                        this.q = ImageView.ScaleType.CENTER_CROP;
                        i = i3;
                    }
                }
            }
            return new int[]{i, i2};
        }
        return (int[]) invokeIIII.objValue;
    }
}
