package d.a.q0.u0.o2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.s.a;
import d.a.q0.h3.f0;
import d.a.q0.h3.w;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f64057a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f64058b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f64059c;

    /* renamed from: d  reason: collision with root package name */
    public f0 f64060d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64061e;

    /* renamed from: f  reason: collision with root package name */
    public AntiHelper.k f64062f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f64063g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.d.a.e f64064h;

    /* renamed from: i  reason: collision with root package name */
    public f0.a f64065i;

    /* loaded from: classes8.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f64066a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64066a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                this.f64066a.f(customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f64067a;

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
            this.f64067a = fVar;
        }

        @Override // d.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f64067a.f(obj);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements f0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f64068a;

        public d(f fVar) {
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
            this.f64068a = fVar;
        }

        @Override // d.a.q0.h3.f0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // d.a.q0.h3.f0.a
        public void b(String str, long j) {
            FrsViewData l0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) || this.f64068a.f64057a == null || (l0 = this.f64068a.f64057a.l0()) == null || l0.getForum() == null) {
                return;
            }
            String name = l0.getForum().getName();
            String id = l0.getForum().getId();
            if (j == d.a.d.e.m.b.f(id, 0L) && TextUtils.equals(name, str)) {
                h R = this.f64068a.f64057a.R();
                if (R != null) {
                    R.Z(str);
                }
                l0.getForum().setLike(0);
                if (R != null) {
                    R.S(0);
                }
                this.f64068a.f64057a.c4(Boolean.TRUE);
                this.f64068a.l(false, id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                w wVar = new w();
                wVar.v(0);
                wVar.s(id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f64069e;

        public e(f fVar) {
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
            this.f64069e = fVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f64069e.f64057a == null || this.f64069e.f64060d == null) {
                    return;
                }
                FrsViewData l0 = this.f64069e.f64057a.l0();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (l0 == null || l0.getForum() == null) {
                        return;
                    }
                    this.f64069e.f64060d.c(l0.getForum().getName(), d.a.d.e.m.b.f(l0.getForum().getId(), 0L));
                    return;
                }
                TbadkCoreApplication.getInst().login(this.f64069e.f64057a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f64069e.f64057a.getActivity(), true, 11036)));
            }
        }
    }

    /* renamed from: d.a.q0.u0.o2.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1712f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1712f(f fVar) {
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
                }
            }
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    public f(FrsFragment frsFragment) {
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
        this.f64059c = null;
        this.f64060d = null;
        this.f64062f = new a(this);
        this.f64063g = new b(this, 2921600);
        this.f64064h = new c(this);
        this.f64065i = new d(this);
        this.f64057a = frsFragment;
        if (frsFragment != null) {
            frsFragment.registerListener(this.f64063g);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13605");
            FrsFragment frsFragment = this.f64057a;
            if (frsFragment != null) {
                d.a.p0.l0.c.b(frsFragment.getContext(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f(Object obj) {
        FrsFragment frsFragment;
        FrsViewData l0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || (frsFragment = this.f64057a) == null || (l0 = frsFragment.l0()) == null || l0.getForum() == null || obj == null) {
            return;
        }
        if (AntiHelper.m(this.f64059c.getErrorCode(), this.f64059c.getErrorString())) {
            if (AntiHelper.t(this.f64057a.getActivity(), this.f64059c.J(), this.f64062f) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                return;
            }
            return;
        }
        String name = l0.getForum().getName();
        String id = l0.getForum().getId();
        w wVar = obj instanceof w ? (w) obj : null;
        boolean z = wVar != null && this.f64059c.getErrorCode() == 0;
        if (wVar.d() == 3250013) {
            BdToast.h(TbadkCoreApplication.getInst().getContext(), wVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
            z = false;
        }
        if (wVar != null && z) {
            h R = this.f64057a.R();
            if (R != null) {
                R.Z(name);
            }
            wVar.v(1);
            l0.updateLikeData(wVar);
            l0.setLikeFeedForumDataList(wVar.f());
            if (R != null) {
                R.g0(l0, this.f64061e);
            }
            this.f64061e = true;
            FrsFragment frsFragment2 = this.f64057a;
            frsFragment2.showToast(frsFragment2.getResources().getString(R.string.attention_success));
            if (d.a.p0.t.h.a.e(this.f64057a.getContext(), 0)) {
                d.a.p0.t.h.a.g(this.f64057a.getPageContext(), 4, 2000L);
            }
            l(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            e();
        } else if (this.f64059c.getErrorCode() == 22) {
            FrsFragment frsFragment3 = this.f64057a;
            frsFragment3.showToast(frsFragment3.getString(R.string.had_liked_forum));
        } else {
            this.f64057a.showToast(this.f64059c.getErrorString());
        }
        this.f64057a.a3(Boolean.valueOf(z));
    }

    public void g(TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tBSpecificationBtn) == null) {
            this.f64058b = tBSpecificationBtn;
            m();
        }
    }

    public final void h() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (frsFragment = this.f64057a) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(frsFragment.getPageContext());
        this.f64059c = likeModel;
        likeModel.setLoadDataCallBack(this.f64064h);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f0 f0Var = new f0();
            this.f64060d = f0Var;
            f0Var.a("from_frs");
            this.f64060d.b(this.f64065i);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h();
            i();
        }
    }

    public void k() {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (likeModel = this.f64059c) == null) {
            return;
        }
        likeModel.I();
    }

    public final void l(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, str) == null) {
            d.a.q0.i1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void m() {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (tBSpecificationBtn = this.f64058b) == null) {
            return;
        }
        tBSpecificationBtn.k();
    }

    public void n(String str, String str2) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) || (likeModel = this.f64059c) == null) {
            return;
        }
        likeModel.M(str, str2, "FRS");
    }

    public void o(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (frsFragment = this.f64057a) == null || this.f64059c == null) {
            return;
        }
        FrsViewData l0 = frsFragment.l0();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (l0 == null || l0.getForum() == null) {
                return;
            }
            if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.f64057a.A2())) {
                TiebaStatic.log(new StatisticItem("c10356").param("fid", l0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.f64057a.A2())) {
                TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", l0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.f64057a.A2())) {
                TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", l0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.f64057a.A2())) {
                TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", l0.getForum().getId()));
            }
            this.f64059c.setFrom("recom_flist_like_frs");
            if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.f64057a.A2())) {
                TiebaStatic.eventStat(this.f64057a.getPageContext().getPageActivity(), "square_frs_focus", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.f64057a.A2())) {
                TiebaStatic.log(new StatisticItem("c10359").param("fid", l0.getForum().getId()));
            }
            this.f64059c.M(l0.getForum().getName(), l0.getForum().getId(), "FRS");
            this.f64061e = z;
            return;
        }
        TbadkCoreApplication.getInst().login(this.f64057a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f64057a.getActivity(), true, CyberPlayerManager.MEDIA_INFO_KERNEL_NET_TRAFFIC)));
    }

    public void p() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (frsFragment = this.f64057a) == null) {
            return;
        }
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(frsFragment.getActivity());
        FrsViewData l0 = this.f64057a.l0();
        String name = (l0 == null || l0.getForum() == null || l0.getForum().getName() == null) ? "" : l0.getForum().getName();
        if (!StringUtils.isNull(name)) {
            aVar.setMessage(String.format(this.f64057a.getString(R.string.attention_cancel_dialog_content), name));
        } else {
            aVar.setMessage(this.f64057a.getString(R.string.attention_cancel_dialog_content_default));
        }
        aVar.setPositiveButton(this.f64057a.getString(R.string.editor_dialog_yes), new e(this));
        aVar.setNegativeButton(this.f64057a.getString(R.string.editor_dialog_no), new C1712f(this));
        aVar.create(this.f64057a.m()).show();
    }
}
