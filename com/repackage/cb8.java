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
import com.repackage.qw8;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes5.dex */
public class cb8 {
    public static /* synthetic */ Interceptable $ic;
    public static cb8 c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public j28 b;

    /* loaded from: classes5.dex */
    public class a implements qw8.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ cb8 b;

        public a(cb8 cb8Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb8Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cb8Var;
            this.a = tbPageContext;
        }

        @Override // com.repackage.qw8.g
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

    /* loaded from: classes5.dex */
    public class b implements qw8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ cb8 b;

        public b(cb8 cb8Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb8Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cb8Var;
            this.a = tbPageContext;
        }

        @Override // com.repackage.qw8.e
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

    /* loaded from: classes5.dex */
    public class c implements qw8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cb8 a;

        public c(cb8 cb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cb8Var;
        }

        @Override // com.repackage.qw8.d
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

    public cb8() {
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

    public static cb8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (c == null) {
                synchronized (cb8.class) {
                    if (c == null) {
                        c = new cb8();
                    }
                }
            }
            return c;
        }
        return (cb8) invokeV.objValue;
    }

    public final void h(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, new String[]{TbConfig.getFeedBackUrl()}, true);
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
            if (version.equals(ru4.k().q("key_rate_version", ""))) {
                return;
            }
            ru4.k().y("key_rate_version", version);
            ru4.k().x("key_rate_version_time", new Date().getTime());
        }
    }

    public final void k(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - ru4.k().m("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        ru4 k = ru4.k();
        if (k.h("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        ru4 k2 = ru4.k();
        k2.u("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void l(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        ru4 k = ru4.k();
        int l = k.l("key_rate_like_count" + currentAccount, 0) + 1;
        if (l < 3) {
            if (l == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                ru4 k2 = ru4.k();
                k2.x("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                ru4 k3 = ru4.k();
                k3.w("key_rate_like_count" + currentAccount, l);
                return;
            }
            ru4 k4 = ru4.k();
            k4.w("key_rate_like_count" + currentAccount, l);
            return;
        }
        ru4 k5 = ru4.k();
        if (Long.valueOf(new Date().getTime()).longValue() - k5.m("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            ru4 k6 = ru4.k();
            k6.w("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        ru4 k7 = ru4.k();
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
        qw8 qw8Var = new qw8(tbPageContext.getContext());
        qw8Var.x(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f097f));
        qw8Var.n(8);
        qw8Var.r(0);
        int f = qi.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070305);
        int f2 = qi.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070246);
        int f3 = qi.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f07028d);
        qw8Var.w(R.dimen.obfuscated_res_0x7f0701f9);
        qw8Var.v(0, f, 0, f3);
        qw8Var.p(0, 0, 0, f2);
        qw8Var.o(true);
        qw8Var.u(new a(this, tbPageContext));
        j28 j28Var = new j28(tbPageContext.getContext(), qw8Var.j());
        this.b = j28Var;
        j28Var.a(0.7f);
        tg.j(this.b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void o(TbPageContext tbPageContext) {
        qw8.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        qw8 qw8Var = new qw8(tbPageContext.getContext());
        int i = this.a;
        if (i != 1 && i != 2) {
            qw8Var.x(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f07d2));
            cVar = new qw8.c(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f07d0), qw8Var);
        } else {
            qw8Var.x(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f0842));
            cVar = new qw8.c(tbPageContext.getContext().getString(R.string.obfuscated_res_0x7f0f07cd), qw8Var);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        qw8Var.q(this.a);
        qw8Var.r(0);
        qw8Var.n(0);
        qw8Var.o(false);
        qi.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0702be);
        int f = qi.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070207);
        qi.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0702d5);
        qw8Var.v(0, qi.f(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070272), 0, 0);
        qw8Var.p(0, f, 0, f);
        cVar.h(new b(this, tbPageContext));
        qw8Var.t(new c(this));
        qw8Var.s(arrayList);
        j28 j28Var = new j28(tbPageContext.getContext(), qw8Var.j());
        this.b = j28Var;
        j28Var.a(0.7f);
        tg.j(this.b, tbPageContext);
        int i2 = this.a;
        if (i2 != 1 && i2 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
