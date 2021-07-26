package d.a.q0.u0.o2;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b implements d.a.q0.u0.m1.e.c, d.a.q0.u0.k2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f64017a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f64018b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f64019c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f64020d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f64021e;

    /* renamed from: f  reason: collision with root package name */
    public int f64022f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64023g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f64024h;

    /* renamed from: i  reason: collision with root package name */
    public EntelechyPullUpRefreshView f64025i;
    public EntelechyPullUpRefreshView j;
    public boolean k;
    public View.OnClickListener l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64026e;

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
            this.f64026e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64026e.f64017a == null) {
                return;
            }
            if (view == this.f64026e.f64025i) {
                TiebaStatic.eventStat(this.f64026e.f64017a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (this.f64026e.f64017a.F2() || this.f64026e.f64017a.G0() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", this.f64026e.f64017a.A()).param("obj_locate", "3"));
                this.f64026e.f64017a.G0().O1();
            } else if (view != this.f64026e.j || this.f64026e.f64017a.G0() == null || this.f64026e.f64017a.G0().b0() == null) {
            } else {
                this.f64026e.f64017a.G0().b0().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: d.a.q0.u0.o2.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class animation.Animation$AnimationListenerC1709b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f64027a;

        public animation.Animation$AnimationListenerC1709b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64027a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.f64027a) != null && view.getAnimation() == animation) {
                this.f64027a.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.f64027a) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f64028a;

        public c(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64028a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.f64028a) != null && view.getAnimation() == animation) {
                this.f64028a.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.f64028a) == null) {
                return;
            }
            view.setVisibility(0);
        }
    }

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, noPressedRelativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64019c = null;
        this.f64022f = 3;
        this.f64023g = false;
        this.f64024h = null;
        this.f64025i = null;
        this.j = null;
        this.k = true;
        this.l = new a(this);
        this.f64017a = frsFragment;
        this.f64018b = noPressedRelativeLayout;
        i();
        this.f64024h = (LinearLayout) this.f64018b.findViewById(R.id.frs_stick_bottom_holder);
        this.j = (EntelechyPullUpRefreshView) this.f64018b.findViewById(R.id.frs_stick_bottom_goto_top);
        this.f64025i = (EntelechyPullUpRefreshView) this.f64018b.findViewById(R.id.frs_stick_bottom_reload);
        this.j.setOnClickListener(this.l);
        this.f64025i.setOnClickListener(this.l);
        onChangeSkinType(this.f64022f);
    }

    @Override // d.a.q0.u0.m1.e.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f64023g = z;
            if (this.f64025i != null) {
                if (z) {
                    LinearLayout linearLayout = this.f64024h;
                    if (linearLayout == null || linearLayout.getVisibility() != 0) {
                        return;
                    }
                    l();
                    return;
                }
                m();
            }
        }
    }

    @Override // d.a.q0.u0.m1.e.c
    public void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f64023g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f64024h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f64024h.setVisibility(8);
        }
    }

    @Override // d.a.q0.u0.m1.e.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f64025i == null) {
                return false;
            }
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.u0.k2.d
    public void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbImageView = this.f64019c) == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f64019c.setImageDrawable(null);
        this.f64019c.setVisibility(8);
    }

    public final void h() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (linearLayout = this.f64024h) == null) {
            return;
        }
        linearLayout.clearAnimation();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f64019c = new TbImageView(this.f64017a.getPageContext().getPageActivity());
            int g2 = d.a.d.e.p.l.g(this.f64017a.getPageContext().getPageActivity(), R.dimen.ds68);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.topMargin = g2;
            this.f64019c.setLayoutParams(layoutParams);
            this.f64018b.addView(this.f64019c);
            this.f64019c.setVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f64017a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f64017a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.f64020d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1709b(this.f64024h));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f64017a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f64017a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.f64021e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f64024h));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h();
            if (this.f64020d == null) {
                j();
            }
            Animation animation = this.f64020d;
            if (animation == null) {
                return;
            }
            this.f64024h.startAnimation(animation);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            if (this.f64021e == null) {
                k();
            }
            if (this.f64021e == null) {
                return;
            }
            this.f64024h.setVisibility(0);
            this.f64024h.startAnimation(this.f64021e);
        }
    }

    @Override // d.a.q0.u0.m1.e.c
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f64022f == i2) {
            return;
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.f64025i;
        if (entelechyPullUpRefreshView != null) {
            entelechyPullUpRefreshView.b(i2);
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.j;
        if (entelechyPullUpRefreshView2 != null) {
            entelechyPullUpRefreshView2.b(i2);
        }
        this.f64022f = i2;
    }
}
