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
/* loaded from: classes6.dex */
public class fu7 extends af5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static double K = 0.5d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fu7 a;

        public a(fu7 fu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fu7Var;
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
            fo m = h35.k().m(ig.h().g(tbImageView.getUrl(), this.a.r ? 17 : 18));
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755695255, "Lcom/repackage/fu7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755695255, "Lcom/repackage/fu7;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fu7(af5 af5Var) {
        super(af5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {af5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((af5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        k(true);
        t();
        o(TbConfig.getPostLineSpace(), 1.0f);
        y(0);
        l(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        m(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        i(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        r(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        j(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        this.G = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds749);
        this.H = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        this.I = new a(this);
    }

    @Override // com.repackage.af5
    public int[] e(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i, i2, i3, i4)) == null) {
            if (i2 <= 0 || i <= 0 || i3 <= 0 || i4 <= 0) {
                return null;
            }
            if (this.s) {
                float f = af5.J;
                if (f > 1.0f) {
                    float f2 = i;
                    if (f2 * f <= i3 * K) {
                        i3 = (int) (f2 * f);
                    }
                    i2 = (i2 * i3) / i;
                    if (i2 > 4096) {
                        this.p = ImageView.ScaleType.MATRIX;
                        i = i3;
                        i2 = 4096;
                    } else {
                        this.p = ImageView.ScaleType.CENTER_CROP;
                        i = i3;
                    }
                }
            }
            return new int[]{i, i2};
        }
        return (int[]) invokeIIII.objValue;
    }
}
