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
import com.repackage.lk8;
import com.repackage.ur4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class qr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public List<TBSpecificationBtn> b;
    public LikeModel c;
    public lk8 d;
    public boolean e;
    public AntiHelper.k f;
    public CustomMessageListener g;
    public c9 h;
    public lk8.a i;

    /* loaded from: classes7.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(qr6 qr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr6Var};
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
        public void onNavigationButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qr6 qr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr6Var, Integer.valueOf(i)};
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
            this.a = qr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk8)) {
                this.a.f(customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qr6 a;

        public c(qr6 qr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qr6Var;
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
    public class d implements lk8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qr6 a;

        public d(qr6 qr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qr6Var;
        }

        @Override // com.repackage.lk8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // com.repackage.lk8.a
        public void b(String str, long j) {
            FrsViewData P0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) || this.a.a == null || (P0 = this.a.a.P0()) == null || P0.getForum() == null) {
                return;
            }
            String name = P0.getForum().getName();
            String id = P0.getForum().getId();
            if (j == og.g(id, 0L) && TextUtils.equals(name, str)) {
                sr6 o0 = this.a.a.o0();
                if (o0 != null) {
                    o0.d0(str);
                }
                P0.getForum().setLike(0);
                if (o0 != null) {
                    o0.X(0);
                }
                this.a.a.h5(Boolean.TRUE);
                this.a.l(false, id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                bk8 bk8Var = new bk8();
                bk8Var.x(0);
                bk8Var.u(id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, bk8Var));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qr6 a;

        public e(qr6 qr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qr6Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
                if (this.a.a == null || this.a.d == null) {
                    return;
                }
                FrsViewData P0 = this.a.a.P0();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (P0 == null || P0.getForum() == null) {
                        return;
                    }
                    this.a.d.c(P0.getForum().getName(), og.g(P0.getForum().getId(), 0L));
                    return;
                }
                TbadkCoreApplication.getInst().login(this.a.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.a.getActivity(), true, 11036)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(qr6 qr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    public qr6(FrsFragment frsFragment) {
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
                t95.b(frsFragment.getContext(), statisticItem);
                dp6.b(statisticItem, this.a.d(), this.a.c());
            }
            dp6.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f(Object obj) {
        FrsFragment frsFragment;
        FrsViewData P0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || (frsFragment = this.a) == null || (P0 = frsFragment.P0()) == null || P0.getForum() == null || obj == null) {
            return;
        }
        if (AntiHelper.m(this.c.getErrorCode(), this.c.getErrorString())) {
            if (AntiHelper.t(this.a.getActivity(), this.c.N(), this.f) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                return;
            }
            return;
        }
        String name = P0.getForum().getName();
        String id = P0.getForum().getId();
        bk8 bk8Var = obj instanceof bk8 ? (bk8) obj : null;
        boolean z = false;
        boolean z2 = bk8Var != null && this.c.getErrorCode() == 0;
        if (bk8Var.d() == 3250013) {
            BdToast b2 = BdToast.b(TbadkCoreApplication.getInst().getContext(), bk8Var.e());
            b2.f(BdToast.ToastIcon.FAILURE);
            b2.c(3000);
            b2.i();
        } else {
            z = z2;
        }
        if (bk8Var != null && z) {
            sr6 o0 = this.a.o0();
            if (o0 != null) {
                o0.d0(name);
            }
            bk8Var.x(1);
            P0.updateLikeData(bk8Var);
            P0.setLikeFeedForumDataList(bk8Var.f());
            if (o0 != null) {
                o0.k0(P0, this.e);
                if (!ListUtils.isEmpty(bk8Var.k())) {
                    o0.w0(bk8Var.k());
                }
            }
            this.e = true;
            FrsFragment frsFragment2 = this.a;
            if (frsFragment2 != null && (frsFragment2.getActivity() instanceof FrsActivity)) {
                ((FrsActivity) this.a.getActivity()).G0().b();
            }
            l(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, bk8Var));
            e();
        } else if (this.c.getErrorCode() == 22) {
            FrsFragment frsFragment3 = this.a;
            frsFragment3.showToast(frsFragment3.getString(R.string.obfuscated_res_0x7f0f0827));
        } else {
            this.a.showToast(this.c.getErrorString());
        }
        this.a.a4(Boolean.valueOf(z));
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
            lk8 lk8Var = new lk8();
            this.d = lk8Var;
            lk8Var.a("from_frs");
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
        likeModel.M();
    }

    public final void l(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, str) == null) {
            l97.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void m(boolean z) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (likeModel = this.c) == null) {
            return;
        }
        likeModel.P(z ? 1 : 0);
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
        likeModel.R(str, str2, "FRS");
    }

    public void p(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (frsFragment = this.a) == null || this.c == null) {
            return;
        }
        FrsViewData P0 = frsFragment.P0();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (P0 == null || P0.getForum() == null) {
                return;
            }
            if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.a.p3())) {
                TiebaStatic.log(new StatisticItem("c10356").param("fid", P0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.a.p3())) {
                TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", P0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.a.p3())) {
                TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", P0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.a.p3())) {
                TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", P0.getForum().getId()));
            }
            this.c.setFrom("recom_flist_like_frs");
            if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.a.p3())) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
            } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.a.p3())) {
                TiebaStatic.log(new StatisticItem("c10359").param("fid", P0.getForum().getId()));
            }
            this.c.R(P0.getForum().getName(), P0.getForum().getId(), "FRS");
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
        ur4 ur4Var = new ur4(frsFragment.getActivity());
        FrsViewData P0 = this.a.P0();
        String name = (P0 == null || P0.getForum() == null || P0.getForum().getName() == null) ? "" : P0.getForum().getName();
        if (!StringUtils.isNull(name)) {
            ur4Var.setMessage(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f02b0), name));
        } else {
            ur4Var.setMessage(this.a.getString(R.string.obfuscated_res_0x7f0f02b1));
        }
        ur4Var.setPositiveButton(this.a.getString(R.string.obfuscated_res_0x7f0f0531), new e(this));
        ur4Var.setNegativeButton(this.a.getString(R.string.obfuscated_res_0x7f0f0530), new f(this));
        ur4Var.create(this.a.o()).show();
    }
}
