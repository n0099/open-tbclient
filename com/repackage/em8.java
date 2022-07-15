package com.repackage;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class em8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final nl8 b;

    /* loaded from: classes6.dex */
    public class a implements gg8<cg8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ em8 a;

        /* renamed from: com.repackage.em8$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0619a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ cg8 a;
            public final /* synthetic */ a b;

            public RunnableC0619a(a aVar, cg8 cg8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cg8Var};
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
                this.a = cg8Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                cg8 cg8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cg8Var = this.a) == null) {
                    return;
                }
                this.b.a.f(cg8Var);
            }
        }

        public a(em8 em8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = em8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg8
        /* renamed from: b */
        public void a(cg8 cg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cg8Var) == null) {
                this.a.a.runOnUiThread(new RunnableC0619a(this, cg8Var));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;

        public b(em8 em8Var, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em8Var, dr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ em8 b;

        public c(em8 em8Var, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em8Var, dr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = em8Var;
            this.a = dr4Var;
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

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ cg8 b;
        public final /* synthetic */ em8 c;

        public d(em8 em8Var, dr4 dr4Var, cg8 cg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em8Var, dr4Var, cg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = em8Var;
            this.a = dr4Var;
            this.b = cg8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
                fg8 fg8Var = new fg8();
                cg8 cg8Var = this.b;
                if (cg8Var != null) {
                    fg8Var.g(cg8Var.a());
                    fg8Var.h(this.b.b());
                }
                new eg8(this.c.a, fg8Var).a();
                this.c.i();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public em8(MainTabActivity mainTabActivity, al8 al8Var) {
        super(2001384);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, al8Var};
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
        this.b = mainTabActivity.f;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MainTabActivity mainTabActivity = this.a;
            if (mainTabActivity.I == null) {
                mainTabActivity.I = new jg8(mainTabActivity.getPageContext(), new a(this));
            }
            this.a.I.b();
        }
    }

    public final void f(cg8 cg8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cg8Var) == null) && !this.a.J && TbadkCoreApplication.isLogin() && this.a.D.intValue() == 4) {
            NewStyleStampDialogView newStyleStampDialogView = new NewStyleStampDialogView(this.a);
            newStyleStampDialogView.setStampData(cg8Var);
            dr4 dr4Var = new dr4(this.a);
            dr4Var.c(newStyleStampDialogView);
            dr4Var.d();
            h();
            this.a.J = true;
            newStyleStampDialogView.getImgStampDialogCancelView().setOnClickListener(new b(this, dr4Var));
            newStyleStampDialogView.getStampDialogLookView().setOnClickListener(new c(this, dr4Var));
            newStyleStampDialogView.getStampDialogShareView().setOnClickListener(new d(this, dr4Var, cg8Var));
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
        nl8 nl8Var;
        nl8 nl8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = this.a.D.intValue();
            this.a.D = (Integer) customResponsedMessage.getData();
            if (this.a.D.intValue() == 1) {
                nl8 nl8Var3 = this.b;
                if (nl8Var3 != null && nl8Var3.a() != null) {
                    this.b.a().b();
                }
            } else if (intValue == 1 && (nl8Var = this.b) != null && nl8Var.a() != null) {
                this.b.a().h();
            }
            if (this.a.D.intValue() == 2 && (nl8Var2 = this.b) != null && nl8Var2.a() != null) {
                this.b.a().d();
            }
            if (this.a.D.intValue() == 4) {
                nl8 nl8Var4 = this.b;
                if (nl8Var4 != null && nl8Var4.a() != null) {
                    this.b.a().c();
                }
                if (!this.a.J) {
                    e();
                }
                if (!TbadkCoreApplication.isLogin() || rd5.b()) {
                    return;
                }
                MainTabActivity mainTabActivity = this.a;
                if (mainTabActivity.P && mainTabActivity.O) {
                    new rd5().c(this.a.getPageContext().getPageActivity());
                    return;
                }
                return;
            }
            jg8 jg8Var = this.a.I;
            if (jg8Var != null) {
                jg8Var.a();
                this.a.I = null;
            }
        }
    }
}
