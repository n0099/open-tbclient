package d.a.p0.u0.o2;

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
public class b implements d.a.p0.u0.m1.e.c, d.a.p0.u0.k2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f63374a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f63375b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f63376c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f63377d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f63378e;

    /* renamed from: f  reason: collision with root package name */
    public int f63379f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63380g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f63381h;

    /* renamed from: i  reason: collision with root package name */
    public EntelechyPullUpRefreshView f63382i;
    public EntelechyPullUpRefreshView j;
    public boolean k;
    public View.OnClickListener l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f63383e;

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
            this.f63383e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f63383e.f63374a == null) {
                return;
            }
            if (view == this.f63383e.f63382i) {
                TiebaStatic.eventStat(this.f63383e.f63374a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (this.f63383e.f63374a.A2() || this.f63383e.f63374a.B0() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", this.f63383e.f63374a.A()).param("obj_locate", "3"));
                this.f63383e.f63374a.B0().O1();
            } else if (view != this.f63383e.j || this.f63383e.f63374a.B0() == null || this.f63383e.f63374a.B0().b0() == null) {
            } else {
                this.f63383e.f63374a.B0().b0().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: d.a.p0.u0.o2.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class animation.Animation$AnimationListenerC1707b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f63384a;

        public animation.Animation$AnimationListenerC1707b(View view) {
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
            this.f63384a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.f63384a) != null && view.getAnimation() == animation) {
                this.f63384a.clearAnimation();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.f63384a) == null) {
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
        public View f63385a;

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
            this.f63385a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.f63385a) != null && view.getAnimation() == animation) {
                this.f63385a.clearAnimation();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.f63385a) == null) {
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
        this.f63376c = null;
        this.f63379f = 3;
        this.f63380g = false;
        this.f63381h = null;
        this.f63382i = null;
        this.j = null;
        this.k = true;
        this.l = new a(this);
        this.f63374a = frsFragment;
        this.f63375b = noPressedRelativeLayout;
        i();
        this.f63381h = (LinearLayout) this.f63375b.findViewById(R.id.frs_stick_bottom_holder);
        this.j = (EntelechyPullUpRefreshView) this.f63375b.findViewById(R.id.frs_stick_bottom_goto_top);
        this.f63382i = (EntelechyPullUpRefreshView) this.f63375b.findViewById(R.id.frs_stick_bottom_reload);
        this.j.setOnClickListener(this.l);
        this.f63382i.setOnClickListener(this.l);
        onChangeSkinType(this.f63379f);
    }

    @Override // d.a.p0.u0.m1.e.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f63380g = z;
            if (this.f63382i != null) {
                if (z) {
                    LinearLayout linearLayout = this.f63381h;
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

    @Override // d.a.p0.u0.m1.e.c
    public void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f63380g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f63381h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f63381h.setVisibility(8);
        }
    }

    @Override // d.a.p0.u0.m1.e.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f63382i == null) {
                return false;
            }
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.u0.k2.d
    public void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbImageView = this.f63376c) == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f63376c.setImageDrawable(null);
        this.f63376c.setVisibility(8);
    }

    public final void h() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (linearLayout = this.f63381h) == null) {
            return;
        }
        linearLayout.clearAnimation();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f63376c = new TbImageView(this.f63374a.getPageContext().getPageActivity());
            int g2 = d.a.c.e.p.l.g(this.f63374a.getPageContext().getPageActivity(), R.dimen.ds68);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.topMargin = g2;
            this.f63376c.setLayoutParams(layoutParams);
            this.f63375b.addView(this.f63376c);
            this.f63376c.setVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f63374a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f63374a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.f63377d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1707b(this.f63381h));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f63374a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f63374a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.f63378e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f63381h));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h();
            if (this.f63377d == null) {
                j();
            }
            Animation animation = this.f63377d;
            if (animation == null) {
                return;
            }
            this.f63381h.startAnimation(animation);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            if (this.f63378e == null) {
                k();
            }
            if (this.f63378e == null) {
                return;
            }
            this.f63381h.setVisibility(0);
            this.f63381h.startAnimation(this.f63378e);
        }
    }

    @Override // d.a.p0.u0.m1.e.c
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f63379f == i2) {
            return;
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.f63382i;
        if (entelechyPullUpRefreshView != null) {
            entelechyPullUpRefreshView.b(i2);
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.j;
        if (entelechyPullUpRefreshView2 != null) {
            entelechyPullUpRefreshView2.b(i2);
        }
        this.f63379f = i2;
    }
}
