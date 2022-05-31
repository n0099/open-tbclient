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
import com.repackage.mp4;
import java.util.List;
/* loaded from: classes5.dex */
public class be8 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId c;
    public transient /* synthetic */ FieldHolder $fh;
    public NewStyleStampDialogView a;
    public eg<um> b;

    /* loaded from: classes5.dex */
    public class a extends eg<um> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp4 a;
        public final /* synthetic */ be8 b;

        public a(be8 be8Var, mp4 mp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be8Var, mp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = be8Var;
            this.a = mp4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        public void onLoaded(um umVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, umVar, str, i) == null) {
                super.onLoaded((a) umVar, str, i);
                if (umVar == null || !umVar.w()) {
                    return;
                }
                this.b.g(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755829764, "Lcom/repackage/be8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755829764, "Lcom/repackage/be8;");
                return;
            }
        }
        c = BdUniqueId.gen();
    }

    public be8() {
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

    public static /* synthetic */ void c(eq4 eq4Var, TbPageContext tbPageContext, View view2) {
        eq4Var.a();
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

    public /* synthetic */ void d(eq4 eq4Var, mp4 mp4Var, Activity activity, View view2) {
        mp4.a i;
        eq4Var.a();
        de8 de8Var = new de8();
        NewStyleStampDialogView newStyleStampDialogView = this.a;
        if (newStyleStampDialogView != null && mp4Var != null && (i = newStyleStampDialogView.i(mp4Var.a())) != null) {
            de8Var.g(i.c());
            de8Var.h(i.b());
        }
        new ce8(activity, de8Var).a();
        j();
    }

    public final void e(mp4 mp4Var) {
        List<mp4.a> a2;
        um umVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mp4Var) == null) || (a2 = mp4Var.a()) == null || a2.size() <= 0) {
            return;
        }
        for (mp4.a aVar : a2) {
            if (!StringUtils.isNull(aVar.c()) && ((umVar = (um) fg.h().n(aVar.c(), 10, new Object[0])) == null || !umVar.w())) {
                fg.h().m(aVar.c(), 10, null, c);
            }
        }
    }

    public void f(mp4 mp4Var) {
        mp4.a i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mp4Var) == null) || (i = this.a.i(mp4Var.a())) == null) {
            return;
        }
        this.b = new a(this, mp4Var);
        um umVar = (um) fg.h().n(i.c(), 10, new Object[0]);
        if (umVar != null && umVar.w()) {
            g(mp4Var);
            e(mp4Var);
            return;
        }
        fg.h().m(i.c(), 10, this.b, c);
    }

    public final void g(final mp4 mp4Var) {
        final Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, mp4Var) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        final TbPageContext pageContext = currentActivity instanceof TbPageContextSupport ? ((TbPageContextSupport) currentActivity).getPageContext() : null;
        this.a.setStampData(mp4Var);
        final eq4 eq4Var = new eq4(currentActivity);
        eq4Var.c(this.a);
        eq4Var.d();
        this.a.getImgStampDialogCancelView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.zd8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    eq4.this.a();
                }
            }
        });
        this.a.getStampDialogLookView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.xd8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    be8.c(eq4.this, pageContext, view2);
                }
            }
        });
        this.a.getStampDialogShareView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.yd8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    be8.this.d(eq4Var, mp4Var, currentActivity, view2);
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
