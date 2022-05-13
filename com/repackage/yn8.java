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
public class yn8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final gn8 b;

    /* loaded from: classes7.dex */
    public class a implements dh8<zg8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yn8 a;

        /* renamed from: com.repackage.yn8$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0562a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ zg8 a;
            public final /* synthetic */ a b;

            public RunnableC0562a(a aVar, zg8 zg8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, zg8Var};
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
                this.a = zg8Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                zg8 zg8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (zg8Var = this.a) == null) {
                    return;
                }
                this.b.a.f(zg8Var);
            }
        }

        public a(yn8 yn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yn8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.dh8
        /* renamed from: b */
        public void a(zg8 zg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zg8Var) == null) {
                this.a.a.runOnUiThread(new RunnableC0562a(this, zg8Var));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ or4 a;

        public b(yn8 yn8Var, or4 or4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn8Var, or4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = or4Var;
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
        public final /* synthetic */ or4 a;
        public final /* synthetic */ yn8 b;

        public c(yn8 yn8Var, or4 or4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn8Var, or4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yn8Var;
            this.a = or4Var;
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
        public final /* synthetic */ or4 a;
        public final /* synthetic */ zg8 b;
        public final /* synthetic */ yn8 c;

        public d(yn8 yn8Var, or4 or4Var, zg8 zg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn8Var, or4Var, zg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yn8Var;
            this.a = or4Var;
            this.b = zg8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
                ch8 ch8Var = new ch8();
                zg8 zg8Var = this.b;
                if (zg8Var != null) {
                    ch8Var.g(zg8Var.a());
                    ch8Var.h(this.b.b());
                }
                new bh8(this.c.a, ch8Var).a();
                this.c.i();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yn8(MainTabActivity mainTabActivity, tm8 tm8Var) {
        super(2001384);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, tm8Var};
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
                mainTabActivity.fetchStampController = new gh8(mainTabActivity.getPageContext(), new a(this));
            }
            this.a.fetchStampController.b();
        }
    }

    public final void f(zg8 zg8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zg8Var) == null) && !this.a.isShowedNewStyleStampDialog && TbadkCoreApplication.isLogin() && this.a.mCurrentTabIndex.intValue() == 4) {
            NewStyleStampDialogView newStyleStampDialogView = new NewStyleStampDialogView(this.a);
            newStyleStampDialogView.setStampData(zg8Var);
            or4 or4Var = new or4(this.a);
            or4Var.c(newStyleStampDialogView);
            or4Var.d();
            h();
            this.a.isShowedNewStyleStampDialog = true;
            newStyleStampDialogView.getImgStampDialogCancelView().setOnClickListener(new b(this, or4Var));
            newStyleStampDialogView.getStampDialogLookView().setOnClickListener(new c(this, or4Var));
            newStyleStampDialogView.getStampDialogShareView().setOnClickListener(new d(this, or4Var, zg8Var));
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
        gn8 gn8Var;
        gn8 gn8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = this.a.mCurrentTabIndex.intValue();
            this.a.mCurrentTabIndex = (Integer) customResponsedMessage.getData();
            if (this.a.mCurrentTabIndex.intValue() == 1) {
                gn8 gn8Var3 = this.b;
                if (gn8Var3 != null && gn8Var3.a() != null) {
                    this.b.a().a();
                }
                if (TbadkCoreApplication.isLogin() && TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                    lh8.r().A(2, 2);
                    lh8.r().G();
                }
            } else if (intValue == 1 && (gn8Var = this.b) != null && gn8Var.a() != null) {
                this.b.a().h();
            }
            if (this.a.mCurrentTabIndex.intValue() == 2 && (gn8Var2 = this.b) != null && gn8Var2.a() != null) {
                this.b.a().c();
            }
            if (this.a.mCurrentTabIndex.intValue() == 4) {
                gn8 gn8Var4 = this.b;
                if (gn8Var4 != null && gn8Var4.a() != null) {
                    this.b.a().b();
                }
                if (!this.a.isShowedNewStyleStampDialog) {
                    e();
                }
                if (!TbadkCoreApplication.isLogin() || hd5.b()) {
                    return;
                }
                MainTabActivity mainTabActivity = this.a;
                if (mainTabActivity.isAutoPay && mainTabActivity.isPermanentBan) {
                    new hd5().c(this.a.getPageContext().getPageActivity());
                    return;
                }
                return;
            }
            gh8 gh8Var = this.a.fetchStampController;
            if (gh8Var != null) {
                gh8Var.a();
                this.a.fetchStampController = null;
            }
        }
    }
}
