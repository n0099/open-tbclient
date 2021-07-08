package d.a.o0.r.f0.n;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b extends TBSpecificationButtonConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;

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
        this.f12684b = R.color.CAM_X0302;
        this.t = true;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? t(f2) : (Drawable) invokeF.objValue;
    }

    public void o(@ColorRes int i2, @ColorRes int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.f12686d = i2;
            this.f12684b = i3;
            this.t = false;
            TBSpecificationButtonConfig.a aVar = this.s;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f12684b = R.color.CAM_X0101;
            this.f12686d = R.color.CAM_X0904;
            this.t = false;
            this.p = true;
            TBSpecificationButtonConfig.a aVar = this.s;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void q(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f12684b = i2;
            this.t = true;
            this.p = true;
            TBSpecificationButtonConfig.a aVar = this.s;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void r(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f12684b = i2;
            this.f12686d = R.color.CAM_X0903;
            this.t = false;
            TBSpecificationButtonConfig.a aVar = this.s;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void s(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f12684b = i2;
            this.f12686d = R.color.CAM_X0211;
            this.t = false;
            this.p = true;
            TBSpecificationButtonConfig.a aVar = this.s;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public final Drawable t(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f2)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            if (this.t) {
                gradientDrawable.setColor(d.a.p0.h3.c.a(this.p ? SkinManager.getColor(this.q, this.f12684b) : this.f12684b, 0.08f));
            } else {
                gradientDrawable.setColor(SkinManager.getColor(this.q, this.f12686d));
            }
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(f2);
            return gradientDrawable;
        }
        return (Drawable) invokeF.objValue;
    }
}
