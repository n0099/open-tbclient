package d.a.q0.e1.h.i;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.d.k.e.c;
import d.a.p0.s.f0.f;
/* loaded from: classes8.dex */
public class b extends c implements BigdaySwipeRefreshLayout.k, PersonalizePageView.d0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView k;
    public LottieAnimationView l;
    public ImageView m;
    public TextView n;
    public d.a.p0.s.n.a o;
    public String p;
    public String q;
    public String r;
    public String s;
    public f.g t;
    public f.InterfaceC1212f u;
    public f.h v;
    public f.e w;

    /* loaded from: classes8.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56165a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56165a = bVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || this.f56165a.k.getBdImage() != null || this.f56165a.o == null || k.isEmpty(this.f56165a.o.f53181a)) {
                return;
            }
            this.f56165a.k.M(this.f56165a.o.f53181a, 41, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        if (context != null) {
            this.p = context.getText(R.string.adp_pull_to_refresh).toString();
            this.q = context.getText(R.string.bigday_refreshing).toString();
            this.r = context.getText(R.string.bigday_release_to_refresh).toString();
            this.s = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    public d.a.p0.s.n.a G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : (d.a.p0.s.n.a) invokeV.objValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void I(float f2) {
        d.a.p0.s.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            this.n.setAlpha(f2);
            this.m.setAlpha(f2);
            if (this.m.getBackground() != null || (aVar = this.o) == null) {
                return;
            }
            if (aVar.f53183c == 1) {
                this.m.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.m.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }

    public void J(d.a.p0.s.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar.a()) {
                this.o = aVar;
            }
            if (aVar.f53183c == 1) {
                this.n.setTextColor(p().getResources().getColor(R.color.CAM_X0101));
                this.m.setBackgroundResource(R.drawable.bigday_text_mask_black);
                this.l.setAnimation(R.raw.lottie_refresh_light);
            } else {
                this.n.setTextColor(p().getResources().getColor(R.color.cp_cont_b_alpha40));
                this.m.setBackgroundResource(R.drawable.bigday_text_mask_white);
                this.l.setAnimation(R.raw.lottie_refresh_dark);
            }
            this.l.setFrame(0);
            this.k.M(aVar.f53181a, 41, false);
            this.k.setOnDrawListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.d0
    public void a(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.t = gVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.d0
    public void b(f.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.v = hVar;
        }
    }

    @Override // d.a.d.k.e.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void e(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            super.e(f2, f3);
            float dimension = getView().getResources().getDimension(R.dimen.tbds120);
            float dimension2 = getView().getResources().getDimension(R.dimen.tbds236);
            float f4 = f2 * dimension2;
            if (f4 < dimension2) {
                float f5 = 0.09090909f;
                float f6 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
                if (f6 < 0.0f) {
                    f5 = 0.0f;
                } else if (f6 <= 0.09090909f) {
                    f5 = f6;
                }
                this.l.setProgress(f5);
                return;
            }
            this.l.setAlpha(1.0f - ((f4 - dimension2) / (h() - dimension2)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.n.setText(this.s);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void g() {
        d.a.p0.s.n.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (aVar = this.o) != null && aVar.a()) {
            MessageManager messageManager = MessageManager.getInstance();
            Context p = p();
            d.a.p0.s.n.a aVar2 = this.o;
            messageManager.sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(p, aVar2.f53181a, aVar2.f53182b, aVar2.f53184d)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (int) (l.i(p()) * 0.3d) : invokeV.intValue;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.d0
    public void i(f.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.w = eVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.FALSE));
            this.n.animate().alpha(0.0f).setDuration(200L).start();
            this.m.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.d0
    public void l(f.InterfaceC1212f interfaceC1212f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC1212f) == null) {
            this.u = interfaceC1212f;
        }
    }

    @Override // d.a.d.k.e.c
    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            View inflate = LayoutInflater.from(p()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
            this.k = (TbImageView) inflate.findViewById(R.id.pull_image);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
            this.l = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
            this.m = (ImageView) inflate.findViewById(R.id.text_mask);
            this.n = (TextView) inflate.findViewById(R.id.state_text);
            if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
            }
            this.k.setAutoChangeStyle(false);
            this.n.setText(this.p);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.d.k.e.c
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            I(1.0f);
            this.l.setAlpha(1.0f);
            this.n.setText(this.p);
            f.e eVar = this.w;
            if (eVar != null) {
                eVar.a();
            }
            f.InterfaceC1212f interfaceC1212f = this.u;
            if (interfaceC1212f != null) {
                interfaceC1212f.a(getView(), z);
            }
            this.l.cancelAnimation();
        }
    }

    @Override // d.a.d.k.e.c
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.n.setText("");
            this.l.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // d.a.d.k.e.c
    public void v(boolean z) {
        f.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (gVar = this.t) == null) {
            return;
        }
        gVar.onListPullRefresh(z);
    }

    @Override // d.a.d.k.e.c
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            I(1.0f);
            this.n.setText(this.p);
            f.h hVar = this.v;
            if (hVar != null) {
                hVar.a(z);
            }
        }
    }

    @Override // d.a.d.k.e.c
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            I(1.0f);
            this.n.setText(this.q);
            this.l.setAlpha(1.0f);
            this.l.setMinAndMaxFrame(8, 58);
            this.l.loop(true);
            this.l.playAnimation();
        }
    }

    @Override // d.a.d.k.e.c
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.n.setText(this.r);
        }
    }
}
