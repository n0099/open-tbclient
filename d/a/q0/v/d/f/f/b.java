package d.a.q0.v.d.f.f;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f65206f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f65207g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e();
    }

    @Override // d.a.q0.v.d.f.f.a
    public void b(d.a.q0.v.d.f.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
        }
    }

    @Override // d.a.q0.v.d.f.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65206f : (View) invokeV.objValue;
    }

    @Override // d.a.q0.v.d.f.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f65206f = new FrameLayout(this.f65203c.getPageActivity());
            this.f65207g = new TbImageView(this.f65203c.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f65201a, this.f65202b);
            this.f65207g.setDefaultBgResource(R.drawable.pic_live_ufan);
            this.f65207g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f65207g.setLayoutParams(layoutParams);
            this.f65206f.addView(this.f65207g);
            this.f65205e.setVisibility(8);
            this.f65206f.addView(this.f65205e);
            this.f65207g.setClickable(false);
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // d.a.q0.v.d.f.f.a
    public boolean f(d.a.q0.v.d.f.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.v.d.f.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // d.a.q0.v.d.f.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            TbImageView tbImageView = this.f65207g;
            if (tbImageView != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
                layoutParams.width = this.f65201a;
                layoutParams.height = this.f65202b;
                this.f65207g.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // d.a.q0.v.d.f.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (1 == i2) {
                this.f65205e.setVisibility(0);
            } else {
                this.f65205e.setVisibility(8);
            }
        }
    }

    @Override // d.a.q0.v.d.f.f.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f65207g = null;
        }
    }

    @Override // d.a.q0.v.d.f.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // d.a.q0.v.d.f.f.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }
}
