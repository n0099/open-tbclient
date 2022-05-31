package com.repackage;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.stamp.view.NewStyleStampDialogView;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zk8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final hk8 b;

    /* loaded from: classes7.dex */
    public class a implements ee8<ae8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk8 a;

        /* renamed from: com.repackage.zk8$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0578a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ae8 a;
            public final /* synthetic */ a b;

            public RunnableC0578a(a aVar, ae8 ae8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ae8Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = ae8Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                ae8 ae8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ae8Var = this.a) == null) {
                    return;
                }
                this.b.a.f(ae8Var);
            }
        }

        public a(zk8 zk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ee8
        /* renamed from: b */
        public void a(ae8 ae8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ae8Var) == null) {
                this.a.a.runOnUiThread(new RunnableC0578a(this, ae8Var));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq4 a;

        public b(zk8 zk8Var, eq4 eq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, eq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eq4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq4 a;
        public final /* synthetic */ zk8 b;

        public c(zk8 zk8Var, eq4 eq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, eq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zk8Var;
            this.a = eq4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount()});
                this.b.g();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq4 a;
        public final /* synthetic */ ae8 b;
        public final /* synthetic */ zk8 c;

        public d(zk8 zk8Var, eq4 eq4Var, ae8 ae8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, eq4Var, ae8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zk8Var;
            this.a = eq4Var;
            this.b = ae8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
                de8 de8Var = new de8();
                ae8 ae8Var = this.b;
                if (ae8Var != null) {
                    de8Var.g(ae8Var.a());
                    de8Var.h(this.b.b());
                }
                new ce8(this.c.a, de8Var).a();
                this.c.i();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zk8(MainTabActivity mainTabActivity, uj8 uj8Var) {
        super(2001384);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, uj8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = mainTabActivity.mLogicController;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MainTabActivity mainTabActivity = this.a;
            if (mainTabActivity.fetchStampController == null) {
                mainTabActivity.fetchStampController = new he8(mainTabActivity.getPageContext(), new a(this));
            }
            this.a.fetchStampController.b();
        }
    }

    public final void f(ae8 ae8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ae8Var) == null) && !this.a.isShowedNewStyleStampDialog && TbadkCoreApplication.isLogin() && this.a.mCurrentTabIndex.intValue() == 4) {
            NewStyleStampDialogView newStyleStampDialogView = new NewStyleStampDialogView(this.a);
            newStyleStampDialogView.setStampData(ae8Var);
            eq4 eq4Var = new eq4(this.a);
            eq4Var.c(newStyleStampDialogView);
            eq4Var.d();
            h();
            this.a.isShowedNewStyleStampDialog = true;
            newStyleStampDialogView.getImgStampDialogCancelView().setOnClickListener(new b(this, eq4Var));
            newStyleStampDialogView.getStampDialogLookView().setOnClickListener(new c(this, eq4Var));
            newStyleStampDialogView.getStampDialogShareView().setOnClickListener(new d(this, eq4Var, ae8Var));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 2).param("obj_source", 3).param("obj_locate", 3));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 1).param("obj_source", 3).param("obj_locate", 3));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("obj_locate", 31));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        hk8 hk8Var;
        hk8 hk8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = this.a.mCurrentTabIndex.intValue();
            this.a.mCurrentTabIndex = (Integer) customResponsedMessage.getData();
            if (this.a.mCurrentTabIndex.intValue() == 1) {
                hk8 hk8Var3 = this.b;
                if (hk8Var3 != null && hk8Var3.a() != null) {
                    this.b.a().a();
                }
                if (TbadkCoreApplication.isLogin() && TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                    me8.r().A(2, 2);
                    me8.r().G();
                }
            } else if (intValue == 1 && (hk8Var = this.b) != null && hk8Var.a() != null) {
                this.b.a().h();
            }
            if (this.a.mCurrentTabIndex.intValue() == 2 && (hk8Var2 = this.b) != null && hk8Var2.a() != null) {
                this.b.a().c();
            }
            if (this.a.mCurrentTabIndex.intValue() == 4) {
                hk8 hk8Var4 = this.b;
                if (hk8Var4 != null && hk8Var4.a() != null) {
                    this.b.a().b();
                }
                if (!this.a.isShowedNewStyleStampDialog) {
                    e();
                }
                if (!TbadkCoreApplication.isLogin() || bc5.b()) {
                    return;
                }
                MainTabActivity mainTabActivity = this.a;
                if (mainTabActivity.isAutoPay && mainTabActivity.isPermanentBan) {
                    new bc5().c(this.a.getPageContext().getPageActivity());
                    return;
                }
                return;
            }
            he8 he8Var = this.a.fetchStampController;
            if (he8Var != null) {
                he8Var.a();
                this.a.fetchStampController = null;
            }
        }
    }
}
