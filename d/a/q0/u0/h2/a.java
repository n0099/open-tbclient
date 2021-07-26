package d.a.q0.u0.h2;

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
import d.a.d.e.p.l;
import d.a.q0.u0.c1;
import d.a.q0.u0.q;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f63537a;

    /* renamed from: b  reason: collision with root package name */
    public c1 f63538b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63539c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63540d;

    /* renamed from: e  reason: collision with root package name */
    public int f63541e;

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
        this.f63541e = -1;
        if (frsFragment != null) {
            this.f63537a = frsFragment;
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
            if (this.f63540d && (i2 = this.f63541e) >= 0) {
                f(i2);
            }
            this.f63540d = false;
        }
    }

    public void c() {
        c1 c1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (c1Var = this.f63538b) == null) {
            return;
        }
        c1Var.e();
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f63540d = z;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f63541e = i2;
        }
    }

    public final void f(int i2) {
        q G0;
        FrameLayout frameLayout;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (G0 = this.f63537a.G0()) == null || G0.b0() == null || (frameLayout = (FrameLayout) G0.U()) == null) {
            return;
        }
        if (this.f63539c == null && this.f63537a.getPageContext() != null) {
            TextView textView = new TextView(this.f63537a.getPageContext().getPageActivity());
            this.f63539c = textView;
            textView.setTextSize(0, this.f63537a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.f63539c.setGravity(17);
        }
        if (this.f63539c != null) {
            if (i2 > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
            }
            this.f63539c.setText(string);
        }
        SkinManager.setBackgroundResource(this.f63539c, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f63539c, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.f63538b == null) {
            this.f63538b = new c1();
        }
        this.f63538b.h(this.f63539c, frameLayout, layoutParams, 2000);
        this.f63541e = -1;
    }
}
