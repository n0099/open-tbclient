package d.a.q0.u0.c2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.live.FrsLiveTipResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.u0.c1;
import d.a.q0.u0.c2.c;
import d.a.q0.u0.q;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f63231a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63232b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f63233c;

    /* renamed from: d  reason: collision with root package name */
    public c1 f63234d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63235e;

    /* renamed from: f  reason: collision with root package name */
    public int f63236f;

    /* renamed from: g  reason: collision with root package name */
    public FrsFragment f63237g;

    /* renamed from: h  reason: collision with root package name */
    public int f63238h;

    /* renamed from: i  reason: collision with root package name */
    public String f63239i;
    public AlaLiveInfoCoreData j;
    public AlaLiveInfoListCoreData k;
    public d.a.q0.u0.c2.c l;
    public int m;
    public c.b n;
    public Runnable o;

    /* renamed from: d.a.q0.u0.c2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1669a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63240a;

        public C1669a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63240a = aVar;
        }

        @Override // d.a.q0.u0.c2.c.b
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, frsLiveTipResponseMessage) == null) || frsLiveTipResponseMessage == null) {
                return;
            }
            this.f63240a.f63238h = frsLiveTipResponseMessage.remindType;
            this.f63240a.f63239i = frsLiveTipResponseMessage.remindText;
            this.f63240a.j = frsLiveTipResponseMessage.infoCoreData;
            this.f63240a.k = frsLiveTipResponseMessage.listCoreData;
            if (this.f63240a.f63234d != null) {
                this.f63240a.f63234d.f();
            }
            if (this.f63240a.f63238h == 0) {
                return;
            }
            this.f63240a.y();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63241e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63241e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f63241e.l == null) {
                return;
            }
            this.f63241e.l.b(this.f63241e.m);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63242e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63242e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f63242e.u();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63243e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63243e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f63243e.t();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63244e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63244e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63244e.l();
            }
        }
    }

    public a(FrsFragment frsFragment, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63235e = true;
        this.n = new C1669a(this);
        this.o = new b(this);
        this.f63237g = frsFragment;
        this.m = i2;
        this.f63236f = n();
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f63236f++;
            d.a.p0.s.d0.b.j().v("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), this.f63236f);
        }
    }

    public void l() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsFragment = this.f63237g) == null) {
            return;
        }
        frsFragment.K2().b(49);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f63236f = 0;
            d.a.p0.s.d0.b j = d.a.p0.s.d0.b.j();
            j.v("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), this.f63236f);
        }
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.p0.s.d0.b j = d.a.p0.s.d0.b.j();
            return j.k("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), 0);
        }
        return invokeV.intValue;
    }

    public final long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.p0.s.d0.b j = d.a.p0.s.d0.b.j();
            return j.l("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + p(), 0L);
        }
        return invokeV.longValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                String id = currentAccountInfo.getID();
                return !TextUtils.isEmpty(id) ? id : "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, context) == null) && context != null && this.f63231a == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.f63231a = frameLayout;
            frameLayout.setOnClickListener(new c(this));
            this.f63232b = (TextView) this.f63231a.findViewById(R.id.frs_hot_live_tip_content);
            ImageView imageView = (ImageView) this.f63231a.findViewById(R.id.frs_hot_live_tip_close);
            this.f63233c = imageView;
            imageView.setOnClickListener(new d(this));
            s();
        }
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f63235e : invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundResource(this.f63231a, R.drawable.bg_frs_hot_live_tip_selector);
            SkinManager.setViewTextColor(this.f63232b, R.color.CAM_X0101);
            SkinManager.setImageResource(this.f63233c, R.drawable.icon_home_card_close_white);
            this.f63232b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f63238h == 2) {
                k();
            }
            c1 c1Var = this.f63234d;
            if (c1Var != null) {
                c1Var.d();
            }
        }
    }

    public final void u() {
        FrsFragment frsFragment;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            m();
            if (this.j == null || (frsFragment = this.f63237g) == null || !frsFragment.isAdded()) {
                return;
            }
            boolean equals = TextUtils.equals(p(), String.valueOf(this.j.userID));
            int i2 = this.f63238h;
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c12540"));
                c1 c1Var = this.f63234d;
                if (c1Var != null) {
                    c1Var.d();
                }
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
            } else if (i2 == 2) {
                TiebaStatic.log(new StatisticItem("c12331"));
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
            } else {
                str = "";
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f63237g.getPageContext().getPageActivity(), this.j, this.k, str, p(), equals, null, null)));
            if (this.f63237g.l0().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.f63237g.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            d.a.d.e.m.e.a().post(new e(this));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c1 c1Var = this.f63234d;
            if (c1Var != null) {
                c1Var.f();
            }
            d.a.d.e.m.e.a().removeCallbacks(this.o);
            d.a.q0.u0.c2.c cVar = this.l;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public void w() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (frsFragment = this.f63237g) != null && frsFragment.isAdded()) {
            if (System.currentTimeMillis() - o() < 1800000) {
                return;
            }
            if (this.f63237g.Y2() && r()) {
                this.f63235e = false;
                return;
            }
            if (this.l == null) {
                this.l = new d.a.q0.u0.c2.c(this.n);
            }
            d.a.d.e.m.e.a().removeCallbacks(this.o);
            d.a.d.e.m.e.a().postDelayed(this.o, 5000L);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            d.a.p0.s.d0.b j = d.a.p0.s.d0.b.j();
            j.w("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + p(), currentTimeMillis);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || StringUtils.isNull(this.f63239i) || this.j == null) {
            return;
        }
        if (this.f63238h != 2 || n() < 3) {
            q(this.f63237g.getPageContext().getPageActivity());
            TextView textView = this.f63232b;
            if (textView != null) {
                textView.setText(this.f63239i);
            }
            s();
            z();
            x();
        }
    }

    public final void z() {
        FrsFragment frsFragment;
        q G0;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (frsFragment = this.f63237g) == null || (G0 = frsFragment.G0()) == null || G0.b0() == null || (frameLayout = (FrameLayout) G0.U()) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.f63234d == null) {
            this.f63234d = new c1();
        }
        int i2 = this.f63238h;
        if (i2 == 2) {
            this.f63234d.h(this.f63231a, frameLayout, layoutParams, 5000);
        } else if (i2 == 1) {
            this.f63234d.g(this.f63231a, frameLayout, layoutParams);
            TiebaStatic.log(new StatisticItem("c12539"));
        }
    }
}
