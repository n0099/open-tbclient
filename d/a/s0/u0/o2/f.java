package d.a.s0.u0.o2;

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
import d.a.r0.r.s.a;
import d.a.s0.h3.f0;
import d.a.s0.h3.w;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f66633a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f66634b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f66635c;

    /* renamed from: d  reason: collision with root package name */
    public f0 f66636d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66637e;

    /* renamed from: f  reason: collision with root package name */
    public AntiHelper.k f66638f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.a.e f66639g;

    /* renamed from: h  reason: collision with root package name */
    public f0.a f66640h;

    /* loaded from: classes9.dex */
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
        public void onNavigationButtonClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f66641a;

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
            this.f66641a = fVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            FrsViewData i0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.f66641a.f66633a == null || (i0 = this.f66641a.f66633a.i0()) == null || i0.getForum() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(this.f66641a.f66635c.getErrorCode(), this.f66641a.f66635c.getErrorString())) {
                if (AntiHelper.t(this.f66641a.f66633a.getActivity(), this.f66641a.f66635c.J(), this.f66641a.f66638f) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            String name = i0.getForum().getName();
            String id = i0.getForum().getId();
            w wVar = obj instanceof w ? (w) obj : null;
            boolean z = wVar != null && this.f66641a.f66635c.getErrorCode() == 0;
            if (wVar.d() == 3250013) {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), wVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                z = false;
            }
            if (wVar == null || !z) {
                if (this.f66641a.f66635c.getErrorCode() == 22) {
                    this.f66641a.f66633a.showToast(this.f66641a.f66633a.getString(R.string.had_liked_forum));
                } else {
                    this.f66641a.f66633a.showToast(this.f66641a.f66635c.getErrorString());
                }
            } else {
                h Q = this.f66641a.f66633a.Q();
                if (Q != null) {
                    Q.Z(name);
                }
                wVar.v(1);
                i0.updateLikeData(wVar);
                i0.setLikeFeedForumDataList(wVar.f());
                if (Q != null) {
                    Q.h0(i0, this.f66641a.f66637e);
                }
                this.f66641a.f66637e = true;
                this.f66641a.f66633a.showToast(this.f66641a.f66633a.getResources().getString(R.string.attention_success));
                if (d.a.r0.s.h.a.e(this.f66641a.f66633a.getContext(), 0)) {
                    d.a.r0.s.h.a.g(this.f66641a.f66633a.getPageContext(), 4, 2000L);
                }
                this.f66641a.o(true, id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                this.f66641a.i();
            }
            this.f66641a.f66633a.U2(Boolean.valueOf(z));
        }
    }

    /* loaded from: classes9.dex */
    public class c implements f0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f66642a;

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
            this.f66642a = fVar;
        }

        @Override // d.a.s0.h3.f0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // d.a.s0.h3.f0.a
        public void b(String str, long j) {
            FrsViewData i0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) || this.f66642a.f66633a == null || (i0 = this.f66642a.f66633a.i0()) == null || i0.getForum() == null) {
                return;
            }
            String name = i0.getForum().getName();
            String id = i0.getForum().getId();
            if (j == d.a.c.e.m.b.f(id, 0L) && TextUtils.equals(name, str)) {
                h Q = this.f66642a.f66633a.Q();
                if (Q != null) {
                    Q.Z(str);
                }
                i0.getForum().setLike(0);
                if (Q != null) {
                    Q.S(0);
                }
                this.f66642a.f66633a.W3(Boolean.TRUE);
                this.f66642a.o(false, id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                w wVar = new w();
                wVar.v(0);
                wVar.s(id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f66643e;

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
            this.f66643e = fVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f66643e.f66633a == null || this.f66643e.f66636d == null) {
                    return;
                }
                FrsViewData i0 = this.f66643e.f66633a.i0();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (i0 == null || i0.getForum() == null) {
                        return;
                    }
                    this.f66643e.f66636d.c(i0.getForum().getName(), d.a.c.e.m.b.f(i0.getForum().getId(), 0L));
                    return;
                }
                TbadkCoreApplication.getInst().login(this.f66643e.f66633a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f66643e.f66633a.getActivity(), true, 11036)));
            }
        }
    }

    /* loaded from: classes9.dex */
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

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
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
        this.f66635c = null;
        this.f66636d = null;
        this.f66638f = new a(this);
        this.f66639g = new b(this);
        this.f66640h = new c(this);
        this.f66633a = frsFragment;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13605");
            FrsFragment frsFragment = this.f66633a;
            if (frsFragment != null) {
                d.a.r0.j0.c.b(frsFragment.getContext(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void j(TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tBSpecificationBtn) == null) {
            this.f66634b = tBSpecificationBtn;
            p();
        }
    }

    public final void k() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (frsFragment = this.f66633a) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(frsFragment.getPageContext());
        this.f66635c = likeModel;
        likeModel.setLoadDataCallBack(this.f66639g);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f0 f0Var = new f0();
            this.f66636d = f0Var;
            f0Var.a("from_frs");
            this.f66636d.b(this.f66640h);
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (likeModel = this.f66635c) == null) {
            return;
        }
        likeModel.I();
    }

    public final void o(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) {
            d.a.s0.i1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void p() {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tBSpecificationBtn = this.f66634b) == null) {
            return;
        }
        tBSpecificationBtn.k();
    }

    public void q(String str, String str2) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (likeModel = this.f66635c) == null) {
            return;
        }
        likeModel.M(str, str2, "FRS");
    }

    public void r(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (frsFragment = this.f66633a) == null || this.f66635c == null) {
            return;
        }
        FrsViewData i0 = frsFragment.i0();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (i0 == null || i0.getForum() == null) {
                return;
            }
            if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.f66633a.u2())) {
                TiebaStatic.log(new StatisticItem("c10356").param("fid", i0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.f66633a.u2())) {
                TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", i0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.f66633a.u2())) {
                TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", i0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.f66633a.u2())) {
                TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", i0.getForum().getId()));
            }
            this.f66635c.setFrom("recom_flist_like_frs");
            if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.f66633a.u2())) {
                TiebaStatic.eventStat(this.f66633a.getPageContext().getPageActivity(), "square_frs_focus", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.f66633a.u2())) {
                TiebaStatic.log(new StatisticItem("c10359").param("fid", i0.getForum().getId()));
            }
            this.f66635c.M(i0.getForum().getName(), i0.getForum().getId(), "FRS");
            this.f66637e = z;
            return;
        }
        TbadkCoreApplication.getInst().login(this.f66633a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f66633a.getActivity(), true, CyberPlayerManager.MEDIA_INFO_KERNEL_NET_TRAFFIC)));
    }

    public void s() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (frsFragment = this.f66633a) == null) {
            return;
        }
        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(frsFragment.getActivity());
        FrsViewData i0 = this.f66633a.i0();
        String name = (i0 == null || i0.getForum() == null || i0.getForum().getName() == null) ? "" : i0.getForum().getName();
        if (!StringUtils.isNull(name)) {
            aVar.setMessage(String.format(this.f66633a.getString(R.string.attention_cancel_dialog_content), name));
        } else {
            aVar.setMessage(this.f66633a.getString(R.string.attention_cancel_dialog_content_default));
        }
        aVar.setPositiveButton(this.f66633a.getString(R.string.editor_dialog_yes), new d(this));
        aVar.setNegativeButton(this.f66633a.getString(R.string.editor_dialog_no), new e(this));
        aVar.create(this.f66633a.n()).show();
    }
}
