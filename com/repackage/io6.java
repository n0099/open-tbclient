package com.repackage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeElement;
/* loaded from: classes6.dex */
public abstract class io6 implements ko6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public Context b;
    public View c;
    public View.OnClickListener d;
    public NavigationBar e;
    public View f;
    public ImageView g;
    public boolean h;
    public ThemeElement i;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-293369532, "Lcom/repackage/io6$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-293369532, "Lcom/repackage/io6$a;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.BACK_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LogicField.BACK_IV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public io6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = true;
        this.i = zi8.b();
    }

    @Override // com.repackage.ko6
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            int i = a.a[logicField.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return (T) this.g;
            }
            return (T) this.f;
        }
        return (T) invokeL.objValue;
    }

    @Override // com.repackage.ko6
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // com.repackage.ko6
    @CallSuper
    public void c(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            if (f < 0.5f) {
                if (this.h) {
                    return;
                }
                m(true);
                this.h = true;
            } else if (this.h) {
                m(false);
                this.h = false;
            }
        }
    }

    @Override // com.repackage.ko6
    public void d(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.repackage.ko6
    @CallSuper
    public void e(@NonNull ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, themeElement) == null) {
            this.i = themeElement;
        }
    }

    @Override // com.repackage.ko6
    @NonNull
    public NavigationBar f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            uc5.b(this.e);
            return this.e;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.repackage.ko6
    @Nullable
    public qo6 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (qo6) invokeV.objValue;
    }

    @Override // com.repackage.ko6
    @CallSuper
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            SkinManager.setBackgroundColor(this.e.getContentLayout(), z ? R.color.CAM_X0201 : R.color.black_alpha0);
        }
    }

    @Override // com.repackage.ko6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.ko6
    public void j(@NonNull FrsFragment frsFragment, @NonNull View view2, @NonNull View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, frsFragment, view2, onClickListener) == null) && this.c == null) {
            this.a = frsFragment;
            this.b = view2.getContext();
            this.c = view2;
            this.d = onClickListener;
            NavigationBar navigationBar = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0923ab);
            this.e = navigationBar;
            navigationBar.getBarBgView().setAlpha(1.0f);
            l();
            n();
        }
    }

    @Override // com.repackage.ko6
    @Nullable
    public no6 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (no6) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            View addSystemImageButton = this.e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this.d);
            this.g = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09244a);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    public abstract void n();

    @Override // com.repackage.ko6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }
}
