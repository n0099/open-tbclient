package d.a.s0.u0.h2;

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
import d.a.c.e.p.l;
import d.a.s0.u0.c1;
import d.a.s0.u0.q;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f66113a;

    /* renamed from: b  reason: collision with root package name */
    public c1 f66114b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f66115c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66116d;

    /* renamed from: e  reason: collision with root package name */
    public int f66117e;

    public a(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66117e = -1;
        if (frsFragment != null) {
            this.f66113a = frsFragment;
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                UtilHelper.getStatusBarHeight();
                return;
            }
            return;
        }
        throw new NullPointerException("FrsFragment is null");
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 >= 0) {
                d(true);
                e(i2);
                return;
            }
            d(false);
            e(i2);
        }
    }

    public void b() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f66116d && (i2 = this.f66117e) >= 0) {
                f(i2);
            }
            this.f66116d = false;
        }
    }

    public void c() {
        c1 c1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (c1Var = this.f66114b) == null) {
            return;
        }
        c1Var.e();
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f66116d = z;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f66117e = i2;
        }
    }

    public final void f(int i2) {
        q B0;
        FrameLayout frameLayout;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (B0 = this.f66113a.B0()) == null || B0.a0() == null || (frameLayout = (FrameLayout) B0.T()) == null) {
            return;
        }
        if (this.f66115c == null && this.f66113a.getPageContext() != null) {
            TextView textView = new TextView(this.f66113a.getPageContext().getPageActivity());
            this.f66115c = textView;
            textView.setTextSize(0, this.f66113a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.f66115c.setGravity(17);
        }
        if (this.f66115c != null) {
            if (i2 > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
            }
            this.f66115c.setText(string);
        }
        SkinManager.setBackgroundResource(this.f66115c, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f66115c, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.f66114b == null) {
            this.f66114b = new c1();
        }
        this.f66114b.h(this.f66115c, frameLayout, layoutParams, 2000);
        this.f66117e = -1;
    }
}
