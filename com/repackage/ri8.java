package com.repackage;

import android.app.Activity;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tieba.stamp.view.NewStyleStampDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dr4;
import java.util.List;
/* loaded from: classes7.dex */
public class ri8 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId d;
    public transient /* synthetic */ FieldHolder $fh;
    public NewStyleStampDialogView a;
    public jg<zm> b;
    public d c;

    /* loaded from: classes7.dex */
    public class a extends jg<zm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ ri8 b;

        public a(ri8 ri8Var, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri8Var, dr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ri8Var;
            this.a = dr4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jg
        public void onLoaded(zm zmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, zmVar, str, i) == null) {
                super.onLoaded((a) zmVar, str, i);
                if (zmVar == null || !zmVar.w()) {
                    return;
                }
                this.b.l(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr4 a;
        public final /* synthetic */ ri8 b;

        public b(ri8 ri8Var, vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri8Var, vr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ri8Var;
            this.a = vr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.c != null) {
                    this.b.c.a();
                }
                this.a.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr4 a;
        public final /* synthetic */ qi8 b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ ri8 d;

        public c(ri8 ri8Var, vr4 vr4Var, qi8 qi8Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri8Var, vr4Var, qi8Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ri8Var;
            this.a = vr4Var;
            this.b = qi8Var;
            this.c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
                ti8 ti8Var = new ti8();
                qi8 qi8Var = this.b;
                if (qi8Var != null) {
                    ti8Var.g(qi8Var.a());
                    ti8Var.h(this.b.b());
                }
                new si8(this.c, ti8Var).a();
                this.d.p();
                if (this.d.c != null) {
                    this.d.c.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();

        void b();

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755349264, "Lcom/repackage/ri8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755349264, "Lcom/repackage/ri8;");
                return;
            }
        }
        d = BdUniqueId.gen();
    }

    public ri8() {
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

    public static /* synthetic */ void e(vr4 vr4Var, TbPageContext tbPageContext, View view2) {
        vr4Var.a();
        if (tbPageContext != null) {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{"https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount()});
            n();
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 2).param("obj_source", 1).param("obj_locate", 1));
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 1).param("obj_source", 1).param("obj_locate", 1));
        }
    }

    public /* synthetic */ void f(vr4 vr4Var, dr4 dr4Var, Activity activity, View view2) {
        dr4.a i;
        vr4Var.a();
        ti8 ti8Var = new ti8();
        NewStyleStampDialogView newStyleStampDialogView = this.a;
        if (newStyleStampDialogView != null && dr4Var != null && (i = newStyleStampDialogView.i(dr4Var.a())) != null) {
            ti8Var.g(i.c());
            ti8Var.h(i.b());
        }
        new si8(activity, ti8Var).a();
        p();
    }

    public /* synthetic */ void g(vr4 vr4Var, TbPageContext tbPageContext, View view2) {
        vr4Var.a();
        if (tbPageContext != null) {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{"https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount()});
            n();
            d dVar = this.c;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    public final void h(dr4 dr4Var) {
        List<dr4.a> a2;
        zm zmVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dr4Var) == null) || (a2 = dr4Var.a()) == null || a2.size() <= 0) {
            return;
        }
        for (dr4.a aVar : a2) {
            if (!StringUtils.isNull(aVar.c()) && ((zmVar = (zm) kg.h().n(aVar.c(), 10, new Object[0])) == null || !zmVar.w())) {
                kg.h().m(aVar.c(), 10, null, d);
            }
        }
    }

    public void i(IconPopData iconPopData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, iconPopData) == null) || iconPopData == null || iconPopData.getPic160() == null || iconPopData.getTitle() == null) {
            return;
        }
        qi8 qi8Var = new qi8();
        String pic160 = iconPopData.getPic160();
        qi8Var.d(iconPopData.getTitle());
        qi8Var.c(pic160);
        m(qi8Var);
        PollingModel.Q(iconPopData, true);
    }

    public void j(dr4 dr4Var) {
        dr4.a i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dr4Var) == null) || (i = this.a.i(dr4Var.a())) == null) {
            return;
        }
        this.b = new a(this, dr4Var);
        zm zmVar = (zm) kg.h().n(i.c(), 10, new Object[0]);
        if (zmVar != null && zmVar.w()) {
            l(dr4Var);
            h(dr4Var);
            return;
        }
        kg.h().m(i.c(), 10, this.b, d);
    }

    public void k(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.c = dVar;
        }
    }

    public final void l(final dr4 dr4Var) {
        final Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dr4Var) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        final TbPageContext pageContext = currentActivity instanceof TbPageContextSupport ? ((TbPageContextSupport) currentActivity).getPageContext() : null;
        this.a.setStampData(dr4Var);
        final vr4 vr4Var = new vr4(currentActivity);
        vr4Var.c(this.a);
        vr4Var.d();
        this.a.getImgStampDialogCancelView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.mi8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    vr4.this.a();
                }
            }
        });
        this.a.getStampDialogLookView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.ni8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ri8.e(vr4.this, pageContext, view2);
                }
            }
        });
        this.a.getStampDialogShareView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.oi8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ri8.this.f(vr4Var, dr4Var, currentActivity, view2);
                }
            }
        });
        o();
    }

    public final void m(qi8 qi8Var) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, qi8Var) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        final TbPageContext pageContext = currentActivity instanceof TbPageContextSupport ? ((TbPageContextSupport) currentActivity).getPageContext() : null;
        NewStyleStampDialogView newStyleStampDialogView = new NewStyleStampDialogView(currentActivity);
        newStyleStampDialogView.setStampData(qi8Var);
        final vr4 vr4Var = new vr4(currentActivity);
        vr4Var.c(newStyleStampDialogView);
        vr4Var.d();
        o();
        newStyleStampDialogView.getImgStampDialogCancelView().setOnClickListener(new b(this, vr4Var));
        newStyleStampDialogView.getStampDialogLookView().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.pi8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ri8.this.g(vr4Var, pageContext, view2);
                }
            }
        });
        newStyleStampDialogView.getStampDialogShareView().setOnClickListener(new c(this, vr4Var, qi8Var, currentActivity));
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("obj_locate", 31));
        }
    }
}
