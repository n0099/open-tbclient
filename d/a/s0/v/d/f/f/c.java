package d.a.s0.v.d.f.f;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c extends d.a.s0.v.d.f.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f67781f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f67782g;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f67783e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67783e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f67783e.f67777d.f67729b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            c cVar = this.f67783e;
            urlManager.dealOneLink(cVar.f67776c, new String[]{cVar.f67777d.f67729b}, true);
            d.a.s0.v.d.d.a.c().f("c12909", this.f67783e.f67777d.f67732e, 3, "-1", null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext) {
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

    @Override // d.a.s0.v.d.f.f.a
    public void b(d.a.s0.v.d.f.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            this.f67782g.M(aVar.f67728a, 10, false);
            d.a.s0.v.d.d.a.c().f("c12908", this.f67777d.f67732e, 3, "-1", null);
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67781f : (View) invokeV.objValue;
    }

    @Override // d.a.s0.v.d.f.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f67781f = new FrameLayout(this.f67776c.getPageActivity());
            this.f67782g = new TbImageView(this.f67776c.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f67774a, this.f67775b);
            this.f67782g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f67782g.setLayoutParams(layoutParams);
            this.f67781f.addView(this.f67782g);
            this.f67778e.setVisibility(8);
            this.f67781f.addView(this.f67778e);
            this.f67782g.setOnClickListener(new a(this));
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public boolean f(d.a.s0.v.d.f.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 3 != aVar.f67731d || TextUtils.isEmpty(aVar.f67728a)) ? false : true : invokeL.booleanValue;
    }

    @Override // d.a.s0.v.d.f.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            TbImageView tbImageView = this.f67782g;
            if (tbImageView != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
                layoutParams.width = this.f67774a;
                layoutParams.height = this.f67775b;
                this.f67782g.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (1 == i2) {
                this.f67778e.setVisibility(0);
            } else {
                this.f67778e.setVisibility(8);
            }
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f67782g = null;
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }
}
