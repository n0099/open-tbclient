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
import com.repackage.mq4;
import java.util.List;
/* loaded from: classes5.dex */
public class ci8 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId c;
    public transient /* synthetic */ FieldHolder $fh;
    public NewStyleStampDialogView a;
    public hg<fo> b;

    /* loaded from: classes5.dex */
    public class a extends hg<fo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq4 a;
        public final /* synthetic */ ci8 b;

        public a(ci8 ci8Var, mq4 mq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci8Var, mq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci8Var;
            this.a = mq4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) {
                super.onLoaded((a) foVar, str, i);
                if (foVar == null || !foVar.w()) {
                    return;
                }
                this.b.g(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755796129, "Lcom/repackage/ci8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755796129, "Lcom/repackage/ci8;");
                return;
            }
        }
        c = BdUniqueId.gen();
    }

    public ci8() {
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

    public static /* synthetic */ void c(dr4 dr4Var, TbPageContext tbPageContext, View view2) {
        dr4Var.a();
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

    public /* synthetic */ void d(dr4 dr4Var, mq4 mq4Var, Activity activity, View view2) {
        mq4.a i;
        dr4Var.a();
        ei8 ei8Var = new ei8();
        NewStyleStampDialogView newStyleStampDialogView = this.a;
        if (newStyleStampDialogView != null && mq4Var != null && (i = newStyleStampDialogView.i(mq4Var.a())) != null) {
            ei8Var.g(i.c());
            ei8Var.h(i.b());
        }
        new di8(activity, ei8Var).a();
        j();
    }

    public final void e(mq4 mq4Var) {
        List<mq4.a> a2;
        fo foVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mq4Var) == null) || (a2 = mq4Var.a()) == null || a2.size() <= 0) {
            return;
        }
        for (mq4.a aVar : a2) {
            if (!StringUtils.isNull(aVar.c()) && ((foVar = (fo) ig.h().n(aVar.c(), 10, new Object[0])) == null || !foVar.w())) {
                ig.h().m(aVar.c(), 10, null, c);
            }
        }
    }

    public void f(mq4 mq4Var) {
        mq4.a i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mq4Var) == null) || (i = this.a.i(mq4Var.a())) == null) {
            return;
        }
        this.b = new a(this, mq4Var);
        fo foVar = (fo) ig.h().n(i.c(), 10, new Object[0]);
        if (foVar != null && foVar.w()) {
            g(mq4Var);
            e(mq4Var);
            return;
        }
        ig.h().m(i.c(), 10, this.b, c);
    }

    public final void g(final mq4 mq4Var) {
        final Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, mq4Var) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        final TbPageContext pageContext = currentActivity instanceof TbPageContextSupport ? ((TbPageContextSupport) currentActivity).getPageContext() : null;
        this.a.setStampData(mq4Var);
        final dr4 dr4Var = new dr4(currentActivity);
        dr4Var.c(this.a);
        dr4Var.d();
        this.a.getImgStampDialogCancelView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.ai8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    dr4.this.a();
                }
            }
        });
        this.a.getStampDialogLookView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.zh8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ci8.c(dr4.this, pageContext, view2);
                }
            }
        });
        this.a.getStampDialogShareView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.yh8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ci8.this.d(dr4Var, mq4Var, currentActivity, view2);
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
