package d.a.p0.s.f0.n;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
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
public class a extends TBSpecificationButtonConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] t;
    public boolean u;

    public a() {
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
        this.u = false;
        this.f12733b = R.color.CAM_X0101;
        this.f12735d = R.color.CAM_X0302;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? p(f2) : (Drawable) invokeF.objValue;
    }

    public void o(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f12735d = i2;
            this.f12733b = R.color.CAM_X0101;
            this.p = true;
            TBSpecificationButtonConfig.a aVar = this.s;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public final Drawable p(float f2) {
        InterceptResult invokeF;
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
            if (!this.p) {
                this.f12733b = SkinManager.getColor(this.q, R.color.CAM_X0101);
            }
            int color = this.p ? SkinManager.getColor(this.q, this.f12735d) : this.f12735d;
            if (!this.u) {
                this.t = new int[]{color, color};
            }
            if (Build.VERSION.SDK_INT >= 16) {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setOrientation(this.r);
                gradientDrawable.setColors(this.t);
            } else {
                gradientDrawable = new GradientDrawable(this.r, this.t);
            }
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(f2);
            return gradientDrawable;
        }
        return (Drawable) invokeF.objValue;
    }
}
