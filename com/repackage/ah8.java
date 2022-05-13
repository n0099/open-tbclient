package com.repackage;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.stamp.view.NewStyleStampDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xq4;
import java.util.List;
/* loaded from: classes5.dex */
public class ah8 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId c;
    public transient /* synthetic */ FieldHolder $fh;
    public NewStyleStampDialogView a;
    public fg<co> b;

    /* loaded from: classes5.dex */
    public class a extends fg<co> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xq4 a;
        public final /* synthetic */ ah8 b;

        public a(ah8 ah8Var, xq4 xq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah8Var, xq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah8Var;
            this.a = xq4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        public void onLoaded(co coVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, coVar, str, i) == null) {
                super.onLoaded((a) coVar, str, i);
                if (coVar == null || !coVar.w()) {
                    return;
                }
                this.b.g(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755856672, "Lcom/repackage/ah8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755856672, "Lcom/repackage/ah8;");
                return;
            }
        }
        c = BdUniqueId.gen();
    }

    public ah8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new NewStyleStampDialogView(TbadkCoreApplication.getInst().getContext());
    }

    public static /* synthetic */ void c(or4 or4Var, TbPageContext tbPageContext, View view2) {
        or4Var.a();
        if (tbPageContext != null) {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{"https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount()});
            h();
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 2).param("obj_source", 1).param("obj_locate", 1));
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 1).param("obj_source", 1).param("obj_locate", 1));
        }
    }

    public /* synthetic */ void d(or4 or4Var, xq4 xq4Var, Activity activity, View view2) {
        xq4.a i;
        or4Var.a();
        ch8 ch8Var = new ch8();
        NewStyleStampDialogView newStyleStampDialogView = this.a;
        if (newStyleStampDialogView != null && xq4Var != null && (i = newStyleStampDialogView.i(xq4Var.a())) != null) {
            ch8Var.g(i.c());
            ch8Var.h(i.b());
        }
        new bh8(activity, ch8Var).a();
        j();
    }

    public final void e(xq4 xq4Var) {
        List<xq4.a> a2;
        co coVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xq4Var) == null) || (a2 = xq4Var.a()) == null || a2.size() <= 0) {
            return;
        }
        for (xq4.a aVar : a2) {
            if (!StringUtils.isNull(aVar.c()) && ((coVar = (co) gg.h().n(aVar.c(), 10, new Object[0])) == null || !coVar.w())) {
                gg.h().m(aVar.c(), 10, null, c);
            }
        }
    }

    public void f(xq4 xq4Var) {
        xq4.a i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xq4Var) == null) || (i = this.a.i(xq4Var.a())) == null) {
            return;
        }
        this.b = new a(this, xq4Var);
        co coVar = (co) gg.h().n(i.c(), 10, new Object[0]);
        if (coVar != null && coVar.w()) {
            g(xq4Var);
            e(xq4Var);
            return;
        }
        gg.h().m(i.c(), 10, this.b, c);
    }

    public final void g(final xq4 xq4Var) {
        final Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, xq4Var) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        final TbPageContext pageContext = currentActivity instanceof TbPageContextSupport ? ((TbPageContextSupport) currentActivity).getPageContext() : null;
        this.a.setStampData(xq4Var);
        final or4 or4Var = new or4(currentActivity);
        or4Var.c(this.a);
        or4Var.d();
        this.a.getImgStampDialogCancelView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.yg8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    or4.this.a();
                }
            }
        });
        this.a.getStampDialogLookView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.wg8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ah8.c(or4.this, pageContext, view2);
                }
            }
        });
        this.a.getStampDialogShareView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.xg8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ah8.this.d(or4Var, xq4Var, currentActivity, view2);
                }
            }
        });
        i();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("obj_locate", 31));
        }
    }
}
