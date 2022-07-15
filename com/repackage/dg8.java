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
import com.repackage.lq4;
import java.util.List;
/* loaded from: classes5.dex */
public class dg8 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId c;
    public transient /* synthetic */ FieldHolder $fh;
    public NewStyleStampDialogView a;
    public ig<ym> b;

    /* loaded from: classes5.dex */
    public class a extends ig<ym> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lq4 a;
        public final /* synthetic */ dg8 b;

        public a(dg8 dg8Var, lq4 lq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg8Var, lq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dg8Var;
            this.a = lq4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ig
        public void onLoaded(ym ymVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, ymVar, str, i) == null) {
                super.onLoaded((a) ymVar, str, i);
                if (ymVar == null || !ymVar.w()) {
                    return;
                }
                this.b.g(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755768260, "Lcom/repackage/dg8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755768260, "Lcom/repackage/dg8;");
                return;
            }
        }
        c = BdUniqueId.gen();
    }

    public dg8() {
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

    public /* synthetic */ void d(dr4 dr4Var, lq4 lq4Var, Activity activity, View view2) {
        lq4.a i;
        dr4Var.a();
        fg8 fg8Var = new fg8();
        NewStyleStampDialogView newStyleStampDialogView = this.a;
        if (newStyleStampDialogView != null && lq4Var != null && (i = newStyleStampDialogView.i(lq4Var.a())) != null) {
            fg8Var.g(i.c());
            fg8Var.h(i.b());
        }
        new eg8(activity, fg8Var).a();
        j();
    }

    public final void e(lq4 lq4Var) {
        List<lq4.a> a2;
        ym ymVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lq4Var) == null) || (a2 = lq4Var.a()) == null || a2.size() <= 0) {
            return;
        }
        for (lq4.a aVar : a2) {
            if (!StringUtils.isNull(aVar.c()) && ((ymVar = (ym) jg.h().n(aVar.c(), 10, new Object[0])) == null || !ymVar.w())) {
                jg.h().m(aVar.c(), 10, null, c);
            }
        }
    }

    public void f(lq4 lq4Var) {
        lq4.a i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lq4Var) == null) || (i = this.a.i(lq4Var.a())) == null) {
            return;
        }
        this.b = new a(this, lq4Var);
        ym ymVar = (ym) jg.h().n(i.c(), 10, new Object[0]);
        if (ymVar != null && ymVar.w()) {
            g(lq4Var);
            e(lq4Var);
            return;
        }
        jg.h().m(i.c(), 10, this.b, c);
    }

    public final void g(final lq4 lq4Var) {
        final Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, lq4Var) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        final TbPageContext pageContext = currentActivity instanceof TbPageContextSupport ? ((TbPageContextSupport) currentActivity).getPageContext() : null;
        this.a.setStampData(lq4Var);
        final dr4 dr4Var = new dr4(currentActivity);
        dr4Var.c(this.a);
        dr4Var.d();
        this.a.getImgStampDialogCancelView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.zf8
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
        this.a.getStampDialogLookView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.ag8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    dg8.c(dr4.this, pageContext, view2);
                }
            }
        });
        this.a.getStampDialogShareView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.bg8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    dg8.this.d(dr4Var, lq4Var, currentActivity, view2);
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
