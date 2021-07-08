package d.a.p0.v2;

import android.content.Intent;
import android.net.Uri;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
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
import d.a.c.e.m.g;
import d.a.c.e.p.l;
import d.a.p0.j2.e;
import d.a.p0.z3.h;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f65348c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f65349a;

    /* renamed from: b  reason: collision with root package name */
    public e f65350b;

    /* renamed from: d.a.p0.v2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1803a implements h.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f65351a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f65352b;

        public C1803a(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65352b = aVar;
            this.f65351a = tbPageContext;
        }

        @Override // d.a.p0.z3.h.g
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f65352b.f65350b == null) {
                return;
            }
            this.f65352b.f65350b.dismiss();
            this.f65352b.f65350b = null;
            this.f65352b.f65349a = i2;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_CLICK_STAR).param("obj_type", this.f65352b.f65349a));
            this.f65352b.o(this.f65351a);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f65353a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f65354b;

        public b(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65354b = aVar;
            this.f65353a = tbPageContext;
        }

        @Override // d.a.p0.z3.h.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f65354b.f65350b == null) {
                return;
            }
            this.f65354b.f65350b.dismiss();
            this.f65354b.f65350b = null;
            if (this.f65354b.f65349a == 1 || this.f65354b.f65349a == 2) {
                this.f65354b.h(this.f65353a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_FEEDBACK));
                return;
            }
            this.f65354b.i(this.f65353a);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_SCORE));
        }
    }

    /* loaded from: classes8.dex */
    public class c implements h.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65355a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65355a = aVar;
        }

        @Override // d.a.p0.z3.h.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f65355a.f65350b == null) {
                return;
            }
            this.f65355a.f65350b.dismiss();
            this.f65355a.f65350b = null;
            if (this.f65355a.f65349a != 1 && this.f65355a.f65349a != 2) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_CANCEL));
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_CANCEL));
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65349a = 0;
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f65348c == null) {
                synchronized (a.class) {
                    if (f65348c == null) {
                        f65348c = new a();
                    }
                }
            }
            return f65348c;
        }
        return (a) invokeV.objValue;
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
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                tbPageContext.getContext().startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String version = TbConfig.getVersion();
            if (version.equals(d.a.o0.r.d0.b.j().p("key_rate_version", ""))) {
                return;
            }
            d.a.o0.r.d0.b.j().x("key_rate_version", version);
            d.a.o0.r.d0.b.j().w("key_rate_version_time", new Date().getTime());
        }
    }

    public final void k(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - d.a.o0.r.d0.b.j().l("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
        if (j.g("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        d.a.o0.r.d0.b j2 = d.a.o0.r.d0.b.j();
        j2.t("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void l(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
        int k = j.k("key_rate_like_count" + currentAccount, 0) + 1;
        if (k < 3) {
            if (k == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                d.a.o0.r.d0.b j2 = d.a.o0.r.d0.b.j();
                j2.w("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                d.a.o0.r.d0.b j3 = d.a.o0.r.d0.b.j();
                j3.v("key_rate_like_count" + currentAccount, k);
                return;
            }
            d.a.o0.r.d0.b j4 = d.a.o0.r.d0.b.j();
            j4.v("key_rate_like_count" + currentAccount, k);
            return;
        }
        d.a.o0.r.d0.b j5 = d.a.o0.r.d0.b.j();
        if (Long.valueOf(new Date().getTime()).longValue() - j5.l("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            d.a.o0.r.d0.b j6 = d.a.o0.r.d0.b.j();
            j6.v("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        d.a.o0.r.d0.b j7 = d.a.o0.r.d0.b.j();
        j7.v("key_rate_like_count" + currentAccount, 0);
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
        h hVar = new h(tbPageContext.getContext());
        hVar.y(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
        hVar.o(8);
        hVar.s(0);
        int g2 = l.g(tbPageContext.getContext(), R.dimen.ds86);
        int g3 = l.g(tbPageContext.getContext(), R.dimen.ds138);
        int g4 = l.g(tbPageContext.getContext(), R.dimen.ds27);
        hVar.x(R.dimen.ds28);
        hVar.w(0, g2, 0, g4);
        hVar.q(0, 0, 0, g3);
        hVar.p(true);
        hVar.v(new C1803a(this, tbPageContext));
        e eVar = new e(tbPageContext.getContext(), hVar.j());
        this.f65350b = eVar;
        eVar.a(0.7f);
        g.j(this.f65350b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void o(TbPageContext tbPageContext) {
        h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        h hVar = new h(tbPageContext.getContext());
        int i2 = this.f65349a;
        if (i2 != 1 && i2 != 2) {
            hVar.y(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
            cVar = new h.c(tbPageContext.getContext().getString(R.string.go_score), hVar);
        } else {
            hVar.y(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
            cVar = new h.c(tbPageContext.getContext().getString(R.string.go_feedback), hVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        hVar.r(this.f65349a);
        hVar.s(0);
        hVar.o(0);
        hVar.p(false);
        l.g(tbPageContext.getContext(), R.dimen.ds42);
        int g2 = l.g(tbPageContext.getContext(), R.dimen.ds32);
        l.g(tbPageContext.getContext(), R.dimen.ds51);
        hVar.w(0, l.g(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
        hVar.q(0, g2, 0, g2);
        cVar.h(new b(this, tbPageContext));
        hVar.u(new c(this));
        hVar.t(arrayList);
        e eVar = new e(tbPageContext.getContext(), hVar.j());
        this.f65350b = eVar;
        eVar.a(0.7f);
        g.j(this.f65350b, tbPageContext);
        int i3 = this.f65349a;
        if (i3 != 1 && i3 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
