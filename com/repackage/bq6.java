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
import com.repackage.jj8;
import com.repackage.nr4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class bq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public List<TBSpecificationBtn> b;
    public LikeModel c;
    public jj8 d;
    public boolean e;
    public AntiHelper.k f;
    public CustomMessageListener g;
    public a9 h;
    public jj8.a i;

    /* loaded from: classes5.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(bq6 bq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq6Var};
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
        public void onNavigationButtonClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bq6 bq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq6Var, Integer.valueOf(i)};
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
            this.a = bq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zi8)) {
                this.a.f(customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bq6 a;

        public c(bq6 bq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bq6Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.f(obj);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements jj8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bq6 a;

        public d(bq6 bq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bq6Var;
        }

        @Override // com.repackage.jj8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // com.repackage.jj8.a
        public void b(String str, long j) {
            FrsViewData g0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) || this.a.a == null || (g0 = this.a.a.g0()) == null || g0.getForum() == null) {
                return;
            }
            String name = g0.getForum().getName();
            String id = g0.getForum().getId();
            if (j == kg.g(id, 0L) && TextUtils.equals(name, str)) {
                dq6 N = this.a.a.N();
                if (N != null) {
                    N.b0(str);
                }
                g0.getForum().setLike(0);
                if (N != null) {
                    N.W(0);
                }
                this.a.a.l4(Boolean.TRUE);
                this.a.l(false, id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                zi8 zi8Var = new zi8();
                zi8Var.y(0);
                zi8Var.v(id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, zi8Var));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bq6 a;

        public e(bq6 bq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bq6Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
                if (this.a.a == null || this.a.d == null) {
                    return;
                }
                FrsViewData g0 = this.a.a.g0();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (g0 == null || g0.getForum() == null) {
                        return;
                    }
                    this.a.d.c(g0.getForum().getName(), kg.g(g0.getForum().getId(), 0L));
                    return;
                }
                TbadkCoreApplication.getInst().login(this.a.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.a.getActivity(), true, 11036)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(bq6 bq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    public bq6(FrsFragment frsFragment) {
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
                l85.b(frsFragment.getContext(), statisticItem);
                fn6.b(statisticItem, this.a.b(), this.a.a());
            }
            fn6.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f(Object obj) {
        FrsFragment frsFragment;
        FrsViewData g0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || (frsFragment = this.a) == null || (g0 = frsFragment.g0()) == null || g0.getForum() == null || obj == null) {
            return;
        }
        if (AntiHelper.m(this.c.getErrorCode(), this.c.getErrorString())) {
            if (AntiHelper.t(this.a.getActivity(), this.c.M(), this.f) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                return;
            }
            return;
        }
        String name = g0.getForum().getName();
        String id = g0.getForum().getId();
        zi8 zi8Var = obj instanceof zi8 ? (zi8) obj : null;
        boolean z = zi8Var != null && this.c.getErrorCode() == 0;
        if (zi8Var.d() == 3250013) {
            BdToast.h(TbadkCoreApplication.getInst().getContext(), zi8Var.e(), R.drawable.obfuscated_res_0x7f0809be, 3000, true).q();
            z = false;
        }
        if (zi8Var != null && z) {
            dq6 N = this.a.N();
            if (N != null) {
                N.b0(name);
            }
            zi8Var.y(1);
            g0.updateLikeData(zi8Var);
            g0.setLikeFeedForumDataList(zi8Var.f());
            if (N != null) {
                N.i0(g0, this.e);
                N.u0(zi8Var.l());
            }
            this.e = true;
            if (UbsABTestHelper.isFrsLikeShareDialogABTestA()) {
                pp6.f(this.a.i(), zi8Var, g0.getForum());
            } else {
                FrsFragment frsFragment2 = this.a;
                frsFragment2.showToast(frsFragment2.getResources().getString(R.string.obfuscated_res_0x7f0f02b1));
            }
            if (gz4.f(this.a.getContext(), 0)) {
                gz4.h(this.a.getPageContext(), 4, 2000L);
            }
            l(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, zi8Var));
            e();
        } else if (this.c.getErrorCode() == 22) {
            FrsFragment frsFragment3 = this.a;
            frsFragment3.showToast(frsFragment3.getString(R.string.obfuscated_res_0x7f0f080b));
        } else {
            this.a.showToast(this.c.getErrorString());
        }
        this.a.f3(Boolean.valueOf(z));
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
            jj8 jj8Var = new jj8();
            this.d = jj8Var;
            jj8Var.a("from_frs");
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
        likeModel.L();
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
        likeModel.O(z ? 1 : 0);
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
        likeModel.Q(str, str2, "FRS");
    }

    public void p(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (frsFragment = this.a) == null || this.c == null) {
            return;
        }
        FrsViewData g0 = frsFragment.g0();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (g0 == null || g0.getForum() == null) {
                return;
            }
            if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.a.x2())) {
                TiebaStatic.log(new StatisticItem("c10356").param("fid", g0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.a.x2())) {
                TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", g0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.a.x2())) {
                TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", g0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.a.x2())) {
                TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", g0.getForum().getId()));
            }
            this.c.setFrom("recom_flist_like_frs");
            if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.a.x2())) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
            } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.a.x2())) {
                TiebaStatic.log(new StatisticItem("c10359").param("fid", g0.getForum().getId()));
            }
            this.c.Q(g0.getForum().getName(), g0.getForum().getId(), "FRS");
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
        nr4 nr4Var = new nr4(frsFragment.getActivity());
        FrsViewData g0 = this.a.g0();
        String name = (g0 == null || g0.getForum() == null || g0.getForum().getName() == null) ? "" : g0.getForum().getName();
        if (!StringUtils.isNull(name)) {
            nr4Var.setMessage(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f02a7), name));
        } else {
            nr4Var.setMessage(this.a.getString(R.string.obfuscated_res_0x7f0f02a8));
        }
        nr4Var.setPositiveButton(this.a.getString(R.string.obfuscated_res_0x7f0f0523), new e(this));
        nr4Var.setNegativeButton(this.a.getString(R.string.obfuscated_res_0x7f0f0522), new f(this));
        nr4Var.create(this.a.i()).show();
    }
}
