package d.a.p0.u0.o2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
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
import d.a.o0.r.s.a;
import d.a.p0.h3.f0;
import d.a.p0.h3.w;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f63414a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f63415b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f63416c;

    /* renamed from: d  reason: collision with root package name */
    public f0 f63417d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63418e;

    /* renamed from: f  reason: collision with root package name */
    public AntiHelper.k f63419f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.a.e f63420g;

    /* renamed from: h  reason: collision with root package name */
    public f0.a f63421h;

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
        public void onNavigationButtonClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f63422a;

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
            this.f63422a = fVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            FrsViewData i0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.f63422a.f63414a == null || (i0 = this.f63422a.f63414a.i0()) == null || i0.getForum() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(this.f63422a.f63416c.getErrorCode(), this.f63422a.f63416c.getErrorString())) {
                if (AntiHelper.t(this.f63422a.f63414a.getActivity(), this.f63422a.f63416c.J(), this.f63422a.f63419f) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            String name = i0.getForum().getName();
            String id = i0.getForum().getId();
            w wVar = obj instanceof w ? (w) obj : null;
            boolean z = wVar != null && this.f63422a.f63416c.getErrorCode() == 0;
            if (wVar.d() == 3250013) {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), wVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                z = false;
            }
            if (wVar == null || !z) {
                if (this.f63422a.f63416c.getErrorCode() == 22) {
                    this.f63422a.f63414a.showToast(this.f63422a.f63414a.getString(R.string.had_liked_forum));
                } else {
                    this.f63422a.f63414a.showToast(this.f63422a.f63416c.getErrorString());
                }
            } else {
                h Q = this.f63422a.f63414a.Q();
                if (Q != null) {
                    Q.Z(name);
                }
                wVar.v(1);
                i0.updateLikeData(wVar);
                i0.setLikeFeedForumDataList(wVar.f());
                if (Q != null) {
                    Q.h0(i0, this.f63422a.f63418e);
                }
                this.f63422a.f63418e = true;
                this.f63422a.f63414a.showToast(this.f63422a.f63414a.getResources().getString(R.string.attention_success));
                if (d.a.o0.s.h.a.e(this.f63422a.f63414a.getContext(), 0)) {
                    d.a.o0.s.h.a.g(this.f63422a.f63414a.getPageContext(), 4, 2000L);
                }
                this.f63422a.o(true, id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                this.f63422a.i();
            }
            this.f63422a.f63414a.V2(Boolean.valueOf(z));
        }
    }

    /* loaded from: classes8.dex */
    public class c implements f0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f63423a;

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
            this.f63423a = fVar;
        }

        @Override // d.a.p0.h3.f0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // d.a.p0.h3.f0.a
        public void b(String str, long j) {
            FrsViewData i0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) || this.f63423a.f63414a == null || (i0 = this.f63423a.f63414a.i0()) == null || i0.getForum() == null) {
                return;
            }
            String name = i0.getForum().getName();
            String id = i0.getForum().getId();
            if (j == d.a.c.e.m.b.f(id, 0L) && TextUtils.equals(name, str)) {
                h Q = this.f63423a.f63414a.Q();
                if (Q != null) {
                    Q.Z(str);
                }
                i0.getForum().setLike(0);
                if (Q != null) {
                    Q.S(0);
                }
                this.f63423a.f63414a.X3(Boolean.TRUE);
                this.f63423a.o(false, id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                w wVar = new w();
                wVar.v(0);
                wVar.s(id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f63424e;

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
            this.f63424e = fVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f63424e.f63414a == null || this.f63424e.f63417d == null) {
                    return;
                }
                FrsViewData i0 = this.f63424e.f63414a.i0();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (i0 == null || i0.getForum() == null) {
                        return;
                    }
                    this.f63424e.f63417d.c(i0.getForum().getName(), d.a.c.e.m.b.f(i0.getForum().getId(), 0L));
                    return;
                }
                TbadkCoreApplication.getInst().login(this.f63424e.f63414a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f63424e.f63414a.getActivity(), true, 11036)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
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
        this.f63416c = null;
        this.f63417d = null;
        this.f63419f = new a(this);
        this.f63420g = new b(this);
        this.f63421h = new c(this);
        this.f63414a = frsFragment;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13605");
            FrsFragment frsFragment = this.f63414a;
            if (frsFragment != null) {
                d.a.o0.j0.c.b(frsFragment.getContext(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void j(TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tBSpecificationBtn) == null) {
            this.f63415b = tBSpecificationBtn;
            p();
        }
    }

    public final void k() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (frsFragment = this.f63414a) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(frsFragment.getPageContext());
        this.f63416c = likeModel;
        likeModel.setLoadDataCallBack(this.f63420g);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f0 f0Var = new f0();
            this.f63417d = f0Var;
            f0Var.a("from_frs");
            this.f63417d.b(this.f63421h);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            k();
            l();
        }
    }

    public void n() {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (likeModel = this.f63416c) == null) {
            return;
        }
        likeModel.I();
    }

    public final void o(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) {
            d.a.p0.i1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void p() {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tBSpecificationBtn = this.f63415b) == null) {
            return;
        }
        tBSpecificationBtn.k();
    }

    public void q(String str, String str2) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (likeModel = this.f63416c) == null) {
            return;
        }
        likeModel.M(str, str2, "FRS");
    }

    public void r(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (frsFragment = this.f63414a) == null || this.f63416c == null) {
            return;
        }
        FrsViewData i0 = frsFragment.i0();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (i0 == null || i0.getForum() == null) {
                return;
            }
            if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.f63414a.v2())) {
                TiebaStatic.log(new StatisticItem("c10356").param("fid", i0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.f63414a.v2())) {
                TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", i0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.f63414a.v2())) {
                TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", i0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.f63414a.v2())) {
                TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", i0.getForum().getId()));
            }
            this.f63416c.setFrom("recom_flist_like_frs");
            if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.f63414a.v2())) {
                TiebaStatic.eventStat(this.f63414a.getPageContext().getPageActivity(), "square_frs_focus", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.f63414a.v2())) {
                TiebaStatic.log(new StatisticItem("c10359").param("fid", i0.getForum().getId()));
            }
            this.f63416c.M(i0.getForum().getName(), i0.getForum().getId(), "FRS");
            this.f63418e = z;
            return;
        }
        TbadkCoreApplication.getInst().login(this.f63414a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f63414a.getActivity(), true, CyberPlayerManager.MEDIA_INFO_KERNEL_NET_TRAFFIC)));
    }

    public void s() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (frsFragment = this.f63414a) == null) {
            return;
        }
        d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(frsFragment.getActivity());
        FrsViewData i0 = this.f63414a.i0();
        String name = (i0 == null || i0.getForum() == null || i0.getForum().getName() == null) ? "" : i0.getForum().getName();
        if (!StringUtils.isNull(name)) {
            aVar.setMessage(String.format(this.f63414a.getString(R.string.attention_cancel_dialog_content), name));
        } else {
            aVar.setMessage(this.f63414a.getString(R.string.attention_cancel_dialog_content_default));
        }
        aVar.setPositiveButton(this.f63414a.getString(R.string.editor_dialog_yes), new d(this));
        aVar.setNegativeButton(this.f63414a.getString(R.string.editor_dialog_no), new e(this));
        aVar.create(this.f63414a.m()).show();
    }
}
