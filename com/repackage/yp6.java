package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.yh8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class yp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public List<TBSpecificationBtn> b;
    public LikeModel c;
    public yh8 d;
    public boolean e;
    public AntiHelper.k f;
    public CustomMessageListener g;
    public c9 h;
    public yh8.a i;

    /* loaded from: classes7.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(yp6 yp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yp6 yp6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof oh8)) {
                this.a.f(customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp6 a;

        public c(yp6 yp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp6Var;
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.f(obj);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements yh8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp6 a;

        public d(yp6 yp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp6Var;
        }

        @Override // com.repackage.yh8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // com.repackage.yh8.a
        public void b(String str, long j) {
            FrsViewData Q0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) || this.a.a == null || (Q0 = this.a.a.Q0()) == null || Q0.getForum() == null) {
                return;
            }
            String name = Q0.getForum().getName();
            String id = Q0.getForum().getId();
            if (j == ng.g(id, 0L) && TextUtils.equals(name, str)) {
                aq6 p0 = this.a.a.p0();
                if (p0 != null) {
                    p0.a0(str);
                }
                Q0.getForum().setLike(0);
                if (p0 != null) {
                    p0.V(0);
                }
                this.a.a.e5(Boolean.TRUE);
                this.a.l(false, id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                oh8 oh8Var = new oh8();
                oh8Var.y(0);
                oh8Var.v(id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, oh8Var));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp6 a;

        public e(yp6 yp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yp6Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                if (this.a.a == null || this.a.d == null) {
                    return;
                }
                FrsViewData Q0 = this.a.a.Q0();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (Q0 == null || Q0.getForum() == null) {
                        return;
                    }
                    this.a.d.c(Q0.getForum().getName(), ng.g(Q0.getForum().getId(), 0L));
                    return;
                }
                TbadkCoreApplication.getInst().login(this.a.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.a.getActivity(), true, 11036)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(yp6 yp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    public yp6(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.c = null;
        this.d = null;
        this.f = new a(this);
        this.g = new b(this, 2921600);
        this.h = new c(this);
        this.i = new d(this);
        this.a = frsFragment;
        if (frsFragment != null) {
            frsFragment.registerListener(this.g);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13605");
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                u85.b(frsFragment.getContext(), statisticItem);
                kn6.b(statisticItem, this.a.d(), this.a.c());
            }
            kn6.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f(Object obj) {
        FrsFragment frsFragment;
        FrsViewData Q0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || (frsFragment = this.a) == null || (Q0 = frsFragment.Q0()) == null || Q0.getForum() == null || obj == null) {
            return;
        }
        if (AntiHelper.m(this.c.getErrorCode(), this.c.getErrorString())) {
            if (AntiHelper.t(this.a.getActivity(), this.c.O(), this.f) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                return;
            }
            return;
        }
        String name = Q0.getForum().getName();
        String id = Q0.getForum().getId();
        oh8 oh8Var = obj instanceof oh8 ? (oh8) obj : null;
        boolean z = false;
        boolean z2 = oh8Var != null && this.c.getErrorCode() == 0;
        if (oh8Var.d() == 3250013) {
            BdToast b2 = BdToast.b(TbadkCoreApplication.getInst().getContext(), oh8Var.e());
            b2.f(BdToast.ToastIcon.FAILURE);
            b2.c(3000);
            b2.h();
        } else {
            z = z2;
        }
        if (oh8Var != null && z) {
            aq6 p0 = this.a.p0();
            if (p0 != null) {
                p0.a0(name);
            }
            oh8Var.y(1);
            Q0.updateLikeData(oh8Var);
            Q0.setLikeFeedForumDataList(oh8Var.f());
            if (p0 != null) {
                p0.i0(Q0, this.e);
                if (!ListUtils.isEmpty(oh8Var.l())) {
                    p0.u0(oh8Var.l());
                }
            }
            this.e = true;
            if (UbsABTestHelper.isFrsLikeShareDialogABTestA()) {
                mp6.f(this.a.o(), oh8Var, Q0.getForum());
            } else {
                FrsFragment frsFragment2 = this.a;
                frsFragment2.showToast(frsFragment2.getResources().getString(R.string.obfuscated_res_0x7f0f02b6));
            }
            FrsFragment frsFragment3 = this.a;
            if (frsFragment3 != null && (frsFragment3.getActivity() instanceof FrsActivity)) {
                ((FrsActivity) this.a.getActivity()).s0().b();
            }
            l(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, oh8Var));
            e();
        } else if (this.c.getErrorCode() == 22) {
            FrsFragment frsFragment4 = this.a;
            frsFragment4.showToast(frsFragment4.getString(R.string.obfuscated_res_0x7f0f0819));
        } else {
            this.a.showToast(this.c.getErrorString());
        }
        this.a.Y3(Boolean.valueOf(z));
    }

    public void g(@NonNull List<TBSpecificationBtn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.b = list;
            n();
        }
    }

    public final void h() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (frsFragment = this.a) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(frsFragment.getPageContext());
        this.c = likeModel;
        likeModel.setLoadDataCallBack(this.h);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            yh8 yh8Var = new yh8();
            this.d = yh8Var;
            yh8Var.a("from_frs");
            this.d.b(this.i);
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (likeModel = this.c) == null) {
            return;
        }
        likeModel.N();
    }

    public final void l(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, str) == null) {
            s77.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void m(boolean z) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (likeModel = this.c) == null) {
            return;
        }
        likeModel.Q(z ? 1 : 0);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (TBSpecificationBtn tBSpecificationBtn : this.b) {
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.k();
                }
            }
        }
    }

    public void o(String str, String str2) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) || (likeModel = this.c) == null) {
            return;
        }
        likeModel.S(str, str2, "FRS");
    }

    public void p(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (frsFragment = this.a) == null || this.c == null) {
            return;
        }
        FrsViewData Q0 = frsFragment.Q0();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (Q0 == null || Q0.getForum() == null) {
                return;
            }
            if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.a.p3())) {
                TiebaStatic.log(new StatisticItem("c10356").param("fid", Q0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.a.p3())) {
                TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", Q0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.a.p3())) {
                TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", Q0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.a.p3())) {
                TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", Q0.getForum().getId()));
            }
            this.c.setFrom("recom_flist_like_frs");
            if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.a.p3())) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
            } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.a.p3())) {
                TiebaStatic.log(new StatisticItem("c10359").param("fid", Q0.getForum().getId()));
            }
            this.c.S(Q0.getForum().getName(), Q0.getForum().getId(), "FRS");
            this.e = z;
            return;
        }
        TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getActivity(), true, 11002)));
    }

    public void q() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (frsFragment = this.a) == null) {
            return;
        }
        cr4 cr4Var = new cr4(frsFragment.getActivity());
        FrsViewData Q0 = this.a.Q0();
        String name = (Q0 == null || Q0.getForum() == null || Q0.getForum().getName() == null) ? "" : Q0.getForum().getName();
        if (!StringUtils.isNull(name)) {
            cr4Var.setMessage(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f02ac), name));
        } else {
            cr4Var.setMessage(this.a.getString(R.string.obfuscated_res_0x7f0f02ad));
        }
        cr4Var.setPositiveButton(this.a.getString(R.string.obfuscated_res_0x7f0f0528), new e(this));
        cr4Var.setNegativeButton(this.a.getString(R.string.obfuscated_res_0x7f0f0527), new f(this));
        cr4Var.create(this.a.o()).show();
    }
}
