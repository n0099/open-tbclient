package d.a.s0.m2.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f extends d.a.s0.m2.d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f63407f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f63408g;

    /* renamed from: h  reason: collision with root package name */
    public View f63409h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.r0.d0.h f63410i;
    public e j;
    public PbListView k;
    public NoNetworkView l;
    public PluginErrorTipView m;
    public ImageView n;
    public d.a.r0.d0.g o;
    public int p;
    public LinearLayout q;
    public FrameLayout r;
    public NoNetworkView s;
    public RelativeLayout t;
    public d.a.s0.m2.j.k u;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f63411e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63411e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f63411e.f63407f.getPageActivity(), "notlogin_10", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                ViewHelper.skipToLoginActivity(this.f63411e.f63407f.getPageActivity());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f63412e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63412e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && d.a.c.e.p.j.A()) {
                this.f63412e.o();
                this.f63412e.B(true);
                if (this.f63412e.j != null) {
                    this.f63412e.j.a(view);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f63413e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63413e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f63413e.f63407f.getPageActivity(), null, d.a.s0.h2.c.a(), true)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.s0.m2.f.b f63414e;

        /* renamed from: f  reason: collision with root package name */
        public UserData f63415f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.s0.z3.f f63416g;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63414e = new d.a.s0.m2.f.b();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UserData userData = this.f63415f;
                if (userData == null || !userData.isBaijiahaoUser()) {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "3"));
                    d.a.s0.m2.f.b bVar = this.f63414e;
                    bVar.f63324a = 10;
                    bVar.f63325b = new Bundle();
                    this.f63414e.f63325b.putSerializable(UserData.TYPE_USER, this.f63415f);
                    d.a.s0.z3.f fVar = this.f63416g;
                    if (fVar != null) {
                        fVar.a(view, this.f63414e);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(View view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        new d();
        this.p = 3;
        if (tbPageContext == null || view == null) {
            return;
        }
        this.f63407f = tbPageContext;
        this.f63409h = view;
        this.l = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.m = (PluginErrorTipView) this.f63409h.findViewById(R.id.person_center_plugin_error_tip_view);
        this.q = (LinearLayout) this.f63409h.findViewById(R.id.person_center_anti_container);
        d.a.s0.m2.j.k kVar = new d.a.s0.m2.j.k(this.f63407f, this.f63409h.findViewById(R.id.person_center_anti_navigation_bar), this.f63409h.findViewById(R.id.person_center_anti_status_bar_space), z);
        this.u = kVar;
        kVar.k(PersonStatus.GUEST_DEFAULT);
        this.r = (FrameLayout) this.f63409h.findViewById(R.id.person_center_anti_content);
        this.s = (NoNetworkView) this.f63409h.findViewById(R.id.person_center_anti_no_network_view);
        this.t = (RelativeLayout) this.f63409h.findViewById(R.id.person_center_noanti_rootview);
        PbListView pbListView = new PbListView(this.f63407f.getPageActivity());
        this.k = pbListView;
        pbListView.b();
        this.k.C(SkinManager.getColor(R.color.CAM_X0109));
        this.k.y(R.color.CAM_X0110);
        this.k.o(R.color.CAM_X0201);
        this.k.r(l.g(this.f63407f.getPageActivity(), R.dimen.ds140));
        this.k.p(l.g(this.f63407f.getPageActivity(), R.dimen.ds12));
        this.k.x();
        this.k.u(R.color.CAM_X0205);
        r(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.r == null) {
            return;
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.q.setVisibility(0);
        int dimensionPixelSize = this.f63407f.getResources().getDimensionPixelSize(R.dimen.ds220);
        int dimensionPixelSize2 = this.f63407f.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.f63407f.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.f63407f.getResources().getDimensionPixelSize(R.dimen.ds60);
        int dimensionPixelSize5 = this.f63407f.getResources().getDimensionPixelSize(R.dimen.ds20);
        NoDataView a2 = NoDataViewFactory.a(this.f63407f.getPageActivity(), this.r, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.e(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.c.b(new NoDataViewFactory.b(this.f63407f.getString(R.string.unlogin_person_button_text), new a(this)), dimensionPixelSize5));
        this.f63408g = a2;
        a2.setVisibility(0);
        this.f63408g.f(this.f63407f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
            y();
        }
    }

    public void k(d.a.s0.m2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.r0.d0.g gVar = this.o;
            if (gVar != null) {
                gVar.dettachView(this.f63409h);
                this.o = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
        }
    }

    public void o() {
        d.a.r0.d0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (hVar = this.f63410i) == null) {
            return;
        }
        hVar.dettachView(this.r);
        this.f63410i = null;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d.a.r0.d0.h hVar = this.f63410i;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.p == i2) {
            return;
        }
        NoDataView noDataView = this.f63408g;
        if (noDataView != null) {
            noDataView.f(this.f63407f, i2);
        }
        NoNetworkView noNetworkView = this.s;
        if (noNetworkView != null) {
            noNetworkView.c(this.f63407f, i2);
        }
        d.a.s0.m2.j.k kVar = this.u;
        if (kVar != null) {
            kVar.g(i2);
        }
        SkinManager.setBackgroundResource(this.f63409h, R.color.CAM_X0201);
        d.a.r0.d0.h hVar = this.f63410i;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.p = i2;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.t.setVisibility(i2);
        }
    }

    public void t(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.j = eVar;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.t.setVisibility(8);
            int dimensionPixelSize = this.f63407f.getResources().getDimensionPixelSize(R.dimen.ds240);
            if (this.f63408g == null) {
                this.f63408g = NoDataViewFactory.a(this.f63407f.getPageActivity(), this.f63409h, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.e.d(null, this.f63407f.getString(R.string.user_to_anti)), null);
            }
            SkinManager.setViewTextColor(this.f63408g.getSuTextView(), R.color.CAM_X0106);
            this.f63408g.f(this.f63407f, TbadkCoreApplication.getInst().getSkinType());
            this.f63408g.setVisibility(0);
        }
    }

    public void v(List<n> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && ListUtils.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void w(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.o == null) {
                if (i2 < 0) {
                    this.o = new d.a.r0.d0.g(this.f63407f.getContext());
                } else {
                    this.o = new d.a.r0.d0.g(this.f63407f.getContext(), i2);
                }
                this.o.onChangeSkinType();
            }
            this.o.attachView(this.f63409h, z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
        }
    }

    public void x(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) || q()) {
            return;
        }
        this.q.setVisibility(0);
        if (this.f63410i == null) {
            this.f63410i = new d.a.r0.d0.h(this.f63407f.getPageActivity(), new b(this));
        }
        this.f63410i.h(R.drawable.new_pic_emotion_08);
        this.f63410i.attachView(this.r, z);
        this.f63410i.o();
        this.f63410i.onChangeSkinType();
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (NickNameActivitySwitch.isOn()) {
                if (this.n == null) {
                    ImageView imageView = new ImageView(this.f63407f.getPageActivity());
                    this.n = imageView;
                    imageView.setImageResource(R.drawable.icon_nichengjun);
                    this.n.setOnClickListener(new c(this));
                }
                if (this.n.getParent() != null) {
                    ((ViewGroup) this.n.getParent()).removeView(this.n);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.topMargin = l.g(this.f63407f.getPageActivity(), R.dimen.ds504);
                layoutParams.rightMargin = l.g(this.f63407f.getPageActivity(), R.dimen.ds26);
                View view = this.f63409h;
                if (view instanceof RelativeLayout) {
                    ((RelativeLayout) view).addView(this.n, layoutParams);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.n;
            if (imageView2 == null || imageView2.getParent() == null) {
                return;
            }
            ViewParent parent = this.n.getParent();
            View view2 = this.f63409h;
            if (parent == view2) {
                ((RelativeLayout) view2).removeView(this.n);
            }
        }
    }

    public void z(boolean z, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048593, this, z, list) == null) {
        }
    }
}
