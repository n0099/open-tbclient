package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uu0 extends du0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdImageView e;
    public AdImageView f;

    public uu0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.vt0
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AdImageView adImageView = new AdImageView(this.c);
            this.e = adImageView;
            adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.e.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
            AdImageView adImageView2 = new AdImageView(this.c);
            this.f = adImageView2;
            adImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f.setVisibility(i);
            this.e.setVisibility(i);
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.e.getVisibility() == 8) {
            this.e.setVisibility(0);
            this.e.g(str);
        }
    }

    @Override // com.repackage.vt0, com.repackage.js0
    public void d(@NonNull ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ir0Var) == null) {
            if (PlayerEvent.ACTION_ON_INFO.equals(ir0Var.c())) {
                int intValue = ((Integer) ir0Var.f(1)).intValue();
                if (intValue == 904 || 956 == intValue) {
                    this.e.setVisibility(8);
                    this.f.setVisibility(8);
                }
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(ir0Var.c())) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            } else if ((!PlayerEvent.ACTION_SET_DATA_SOURCE.equals(ir0Var.c()) && !PlayerEvent.ACTION_PLAYER_ATTACH.equals(ir0Var.c())) || u() == null || u().o1() == null) {
            } else {
                M(u().o1().getPoster());
            }
        }
    }

    @Override // com.repackage.iu0
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    @Override // com.repackage.js0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new int[]{4, 2} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.vt0, com.repackage.js0
    public void q(@NonNull ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ir0Var) == null) {
            if (ControlEvent.ACTION_RESUME.equals(ir0Var.c()) || ControlEvent.ACTION_SHOW_TIP.equals(ir0Var.c())) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            }
        }
    }
}
