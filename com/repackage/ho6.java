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
import com.repackage.dq4;
import com.repackage.kg8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ho6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public List<TBSpecificationBtn> b;
    public LikeModel c;
    public kg8 d;
    public boolean e;
    public AntiHelper.k f;
    public CustomMessageListener g;
    public a9 h;
    public kg8.a i;

    /* loaded from: classes6.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ho6 ho6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho6Var};
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
        public void onNavigationButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ho6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ho6 ho6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho6Var, Integer.valueOf(i)};
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
            this.a = ho6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ag8)) {
                this.a.f(customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ho6 a;

        public c(ho6 ho6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ho6Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.f(obj);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements kg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ho6 a;

        public d(ho6 ho6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ho6Var;
        }

        @Override // com.repackage.kg8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // com.repackage.kg8.a
        public void b(String str, long j) {
            FrsViewData h0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) || this.a.a == null || (h0 = this.a.a.h0()) == null || h0.getForum() == null) {
                return;
            }
            String name = h0.getForum().getName();
            String id = h0.getForum().getId();
            if (j == jg.g(id, 0L) && TextUtils.equals(name, str)) {
                jo6 N = this.a.a.N();
                if (N != null) {
                    N.a0(str);
                }
                h0.getForum().setLike(0);
                if (N != null) {
                    N.V(0);
                }
                this.a.a.o4(Boolean.TRUE);
                this.a.l(false, id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                ag8 ag8Var = new ag8();
                ag8Var.y(0);
                ag8Var.v(id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, ag8Var));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ho6 a;

        public e(ho6 ho6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ho6Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
                if (this.a.a == null || this.a.d == null) {
                    return;
                }
                FrsViewData h0 = this.a.a.h0();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (h0 == null || h0.getForum() == null) {
                        return;
                    }
                    this.a.d.c(h0.getForum().getName(), jg.g(h0.getForum().getId(), 0L));
                    return;
                }
                TbadkCoreApplication.getInst().login(this.a.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.a.getActivity(), true, 11036)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(ho6 ho6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    public ho6(FrsFragment frsFragment) {
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
                e75.b(frsFragment.getContext(), statisticItem);
                ll6.b(statisticItem, this.a.b(), this.a.a());
            }
            ll6.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f(Object obj) {
        FrsFragment frsFragment;
        FrsViewData h0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || (frsFragment = this.a) == null || (h0 = frsFragment.h0()) == null || h0.getForum() == null || obj == null) {
            return;
        }
        if (AntiHelper.m(this.c.getErrorCode(), this.c.getErrorString())) {
            if (AntiHelper.t(this.a.getActivity(), this.c.M(), this.f) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                return;
            }
            return;
        }
        String name = h0.getForum().getName();
        String id = h0.getForum().getId();
        ag8 ag8Var = obj instanceof ag8 ? (ag8) obj : null;
        boolean z = false;
        boolean z2 = ag8Var != null && this.c.getErrorCode() == 0;
        if (ag8Var.d() == 3250013) {
            BdToast.h(TbadkCoreApplication.getInst().getContext(), ag8Var.e(), R.drawable.obfuscated_res_0x7f0809ca, 3000, true).n();
        } else {
            z = z2;
        }
        if (ag8Var != null && z) {
            jo6 N = this.a.N();
            if (N != null) {
                N.a0(name);
            }
            ag8Var.y(1);
            h0.updateLikeData(ag8Var);
            h0.setLikeFeedForumDataList(ag8Var.f());
            if (N != null) {
                N.h0(h0, this.e);
                if (!ListUtils.isEmpty(ag8Var.l())) {
                    N.t0(ag8Var.l());
                }
            }
            this.e = true;
            if (UbsABTestHelper.isFrsLikeShareDialogABTestA()) {
                vn6.f(this.a.i(), ag8Var, h0.getForum());
            } else {
                FrsFragment frsFragment2 = this.a;
                frsFragment2.showToast(frsFragment2.getResources().getString(R.string.obfuscated_res_0x7f0f02b3));
            }
            FrsFragment frsFragment3 = this.a;
            if (frsFragment3 != null && (frsFragment3.getActivity() instanceof FrsActivity)) {
                ((FrsActivity) this.a.getActivity()).getPushPermissionController().b();
            }
            l(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, ag8Var));
            e();
        } else if (this.c.getErrorCode() == 22) {
            FrsFragment frsFragment4 = this.a;
            frsFragment4.showToast(frsFragment4.getString(R.string.obfuscated_res_0x7f0f0811));
        } else {
            this.a.showToast(this.c.getErrorString());
        }
        this.a.h3(Boolean.valueOf(z));
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
            kg8 kg8Var = new kg8();
            this.d = kg8Var;
            kg8Var.a("from_frs");
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
            q57.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
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
        FrsViewData h0 = frsFragment.h0();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (h0 == null || h0.getForum() == null) {
                return;
            }
            if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.a.y2())) {
                TiebaStatic.log(new StatisticItem("c10356").param("fid", h0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.a.y2())) {
                TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", h0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.a.y2())) {
                TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", h0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.a.y2())) {
                TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", h0.getForum().getId()));
            }
            this.c.setFrom("recom_flist_like_frs");
            if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.a.y2())) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
            } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.a.y2())) {
                TiebaStatic.log(new StatisticItem("c10359").param("fid", h0.getForum().getId()));
            }
            this.c.Q(h0.getForum().getName(), h0.getForum().getId(), "FRS");
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
        dq4 dq4Var = new dq4(frsFragment.getActivity());
        FrsViewData h0 = this.a.h0();
        String name = (h0 == null || h0.getForum() == null || h0.getForum().getName() == null) ? "" : h0.getForum().getName();
        if (!StringUtils.isNull(name)) {
            dq4Var.setMessage(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f02a9), name));
        } else {
            dq4Var.setMessage(this.a.getString(R.string.obfuscated_res_0x7f0f02aa));
        }
        dq4Var.setPositiveButton(this.a.getString(R.string.obfuscated_res_0x7f0f052a), new e(this));
        dq4Var.setNegativeButton(this.a.getString(R.string.obfuscated_res_0x7f0f0529), new f(this));
        dq4Var.create(this.a.i()).show();
    }
}
