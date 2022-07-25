package com.repackage;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;
    public we6 b;
    public TextView c;
    public boolean d;
    public int e;

    public yn6(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = -1;
        if (frsFragment != null) {
            this.a = frsFragment;
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                UtilHelper.getStatusBarHeight();
                return;
            }
            return;
        }
        throw new NullPointerException("FrsFragment is null");
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i >= 0) {
                d(true);
                e(i);
                return;
            }
            d(false);
            e(i);
        }
    }

    public void b() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.d && (i = this.e) >= 0) {
                f(i);
            }
            this.d = false;
        }
    }

    public void c() {
        we6 we6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (we6Var = this.b) == null) {
            return;
        }
        we6Var.e();
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.d = z;
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.e = i;
        }
    }

    public final void f(int i) {
        id6 l1;
        FrameLayout frameLayout;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (l1 = this.a.l1()) == null || l1.d0() == null || (frameLayout = (FrameLayout) l1.W()) == null) {
            return;
        }
        if (this.c == null && this.a.getPageContext() != null) {
            TextView textView = new TextView(this.a.getPageContext().getPageActivity());
            this.c = textView;
            textView.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
            this.c.setGravity(17);
        }
        if (this.c != null) {
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f6e), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f116e);
            }
            this.c.setText(string);
        }
        SkinManager.setBackgroundResource(this.c, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702dd));
        if (this.b == null) {
            this.b = new we6();
        }
        this.b.h(this.c, frameLayout, layoutParams, 2000);
        this.e = -1;
    }
}
