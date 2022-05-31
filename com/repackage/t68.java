package com.repackage;

import android.content.Intent;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vs8;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes7.dex */
public class t68 {
    public static /* synthetic */ Interceptable $ic;
    public static t68 c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public fy7 b;

    /* loaded from: classes7.dex */
    public class a implements vs8.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ t68 b;

        public a(t68 t68Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t68Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t68Var;
            this.a = tbPageContext;
        }

        @Override // com.repackage.vs8.g
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.b.b == null) {
                return;
            }
            this.b.b.dismiss();
            this.b.b = null;
            this.b.a = i;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_CLICK_STAR).param("obj_type", this.b.a));
            this.b.o(this.a);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements vs8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ t68 b;

        public b(t68 t68Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t68Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t68Var;
            this.a = tbPageContext;
        }

        @Override // com.repackage.vs8.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.b == null) {
                return;
            }
            this.b.b.dismiss();
            this.b.b = null;
            if (this.b.a == 1 || this.b.a == 2) {
                this.b.h(this.a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_FEEDBACK));
                return;
            }
            this.b.i(this.a);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_SCORE));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements vs8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t68 a;

        public c(t68 t68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t68Var;
        }

        @Override // com.repackage.vs8.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.dismiss();
            this.a.b = null;
            if (this.a.a != 1 && this.a.a != 2) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_CANCEL));
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_CANCEL));
            }
        }
    }

    public t68() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
    }

    public static t68 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (c == null) {
                synchronized (t68.class) {
                    if (c == null) {
                        c = new t68();
                    }
                }
            }
            return c;
        }
        return (t68) invokeV.objValue;
    }

    public final void h(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    public final void i(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + TbadkCoreApplication.getInst().getPackageName()));
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                tbPageContext.getContext().startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String version = TbConfig.getVersion();
            if (version.equals(ys4.k().q("key_rate_version", ""))) {
                return;
            }
            ys4.k().y("key_rate_version", version);
            ys4.k().x("key_rate_version_time", new Date().getTime());
        }
    }

    public final void k(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - ys4.k().m("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        ys4 k = ys4.k();
        if (k.h("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        ys4 k2 = ys4.k();
        k2.u("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void l(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        ys4 k = ys4.k();
        int l = k.l("key_rate_like_count" + currentAccount, 0) + 1;
        if (l < 3) {
            if (l == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                ys4 k2 = ys4.k();
                k2.x("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                ys4 k3 = ys4.k();
                k3.w("key_rate_like_count" + currentAccount, l);
                return;
            }
            ys4 k4 = ys4.k();
            k4.w("key_rate_like_count" + currentAccount, l);
            return;
        }
        ys4 k5 = ys4.k();
        if (Long.valueOf(new Date().getTime()).longValue() - k5.m("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            ys4 k6 = ys4.k();
            k6.w("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        ys4 k7 = ys4.k();
        k7.w("key_rate_like_count" + currentAccount, 0);
    }

    public void m(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        k(tbPageContext);
    }

    public void n(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        vs8 vs8Var = new vs8(tbPageContext.getContext());
        vs8Var.x(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f096d));
        vs8Var.n(8);
        vs8Var.r(0);
        int f = li.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070308);
        int f2 = li.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070249);
        int f3 = li.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070290);
        vs8Var.w(R.dimen.obfuscated_res_0x7f0701f9);
        vs8Var.v(0, f, 0, f3);
        vs8Var.p(0, 0, 0, f2);
        vs8Var.o(true);
        vs8Var.u(new a(this, tbPageContext));
        fy7 fy7Var = new fy7(tbPageContext.getContext(), vs8Var.j());
        this.b = fy7Var;
        fy7Var.a(0.7f);
        og.j(this.b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void o(TbPageContext tbPageContext) {
        vs8.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        vs8 vs8Var = new vs8(tbPageContext.getContext());
        int i = this.a;
        if (i != 1 && i != 2) {
            vs8Var.x(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f07bd));
            cVar = new vs8.c(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f07bb), vs8Var);
        } else {
            vs8Var.x(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f082c));
            cVar = new vs8.c(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f07b8), vs8Var);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        vs8Var.q(this.a);
        vs8Var.r(0);
        vs8Var.n(0);
        vs8Var.o(false);
        li.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0702c1);
        int f = li.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070207);
        li.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0702d8);
        vs8Var.v(0, li.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070276), 0, 0);
        vs8Var.p(0, f, 0, f);
        cVar.h(new b(this, tbPageContext));
        vs8Var.t(new c(this));
        vs8Var.s(arrayList);
        fy7 fy7Var = new fy7(tbPageContext.getContext(), vs8Var.j());
        this.b = fy7Var;
        fy7Var.a(0.7f);
        og.j(this.b, tbPageContext);
        int i2 = this.a;
        if (i2 != 1 && i2 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
