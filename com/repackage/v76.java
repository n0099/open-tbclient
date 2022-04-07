package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fk8;
/* loaded from: classes7.dex */
public class v76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public View b;
    public BarImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TBSpecificationBtn h;
    public String i;
    public String j;
    public eq4 k;
    public LikeModel l;
    public fk8 m;
    public boolean n;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v76 a;

        public a(v76 v76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v76 a;

        public b(v76 v76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = new StatisticItem("c13644");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.a.k.k());
                statisticItem.param("obj_locate", 1);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.a.k.s() ? 2 : 1);
                TiebaStatic.log(statisticItem);
                if (this.a.k.s()) {
                    this.a.i();
                } else {
                    this.a.h();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v76 a;

        public c(v76 v76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v76Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.l.getErrorCode() == 22) {
                    oi.N(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f0803));
                } else if (obj == null) {
                } else {
                    if (this.a.l.getErrorCode() != 0) {
                        oi.N(this.a.a.getPageActivity(), this.a.l.getErrorString());
                        return;
                    }
                    this.a.n(true);
                    oi.N(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f02ac));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements fk8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v76 a;

        public d(v76 v76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v76Var;
        }

        @Override // com.repackage.fk8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // com.repackage.fk8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.n(false);
                oi.N(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f1467));
            }
        }
    }

    public v76(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.i = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029c);
        this.j = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13a9);
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0721, (ViewGroup) null);
        this.b = inflate;
        this.c = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090318);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090326);
        this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090780);
        this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090a08);
        this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091fe5);
        this.h = (TBSpecificationBtn) this.b.findViewById(R.id.obfuscated_res_0x7f090a5c);
        this.b.setOnClickListener(new a(this));
        this.h.setOnClickListener(new b(this));
    }

    public void g(eq4 eq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eq4Var) == null) || eq4Var == null) {
            return;
        }
        this.k = eq4Var;
        this.c.setShowOval(true);
        this.c.setShowOuterBorder(false);
        this.c.setShowInnerBorder(true);
        this.c.setStrokeWith(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.c.setStrokeColorResId(R.color.CAM_X0401);
        this.c.K(eq4Var.i(), 10, false);
        String m = eq4Var.m();
        if (ni.isEmpty(m)) {
            m = "";
        }
        this.d.setText(m);
        this.f.setText(this.i + " " + StringHelper.numFormatOverWanWithoutDecimals(eq4Var.q()));
        this.g.setText(this.j + " " + StringHelper.numFormatOverWanWithoutDecimals((long) eq4Var.r()));
        String recomReason = eq4Var.getRecomReason();
        if (ni.isEmpty(recomReason)) {
            if (this.e.getVisibility() != 8) {
                this.e.setVisibility(8);
                if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()).topMargin = oi.f(this.a.getPageActivity(), R.dimen.tbds47);
                    this.d.requestLayout();
                }
            }
        } else {
            if (this.e.getVisibility() != 0) {
                this.e.setVisibility(0);
                if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()).topMargin = oi.f(this.a.getPageActivity(), R.dimen.tbds24);
                    this.d.requestLayout();
                }
            }
            this.e.setText(recomReason);
        }
        n(this.k.s());
        l();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!oi.C()) {
                UtilHelper.showToast(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0c18));
                return;
            }
            eq4 eq4Var = this.k;
            if (eq4Var == null || StringUtils.isNull(eq4Var.m()) || this.k.k() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.l == null) {
                this.l = new LikeModel(this.a);
            }
            this.l.setLoadDataCallBack(new c(this));
            if (ni.isForumName(this.k.m())) {
                this.l.L();
                this.l.P(this.k.m(), String.valueOf(this.k.k()));
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!oi.C()) {
                UtilHelper.showToast(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0c18));
                return;
            }
            eq4 eq4Var = this.k;
            if (eq4Var == null || StringUtils.isNull(eq4Var.m()) || this.k.k() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.m == null) {
                this.m = new fk8();
            }
            this.m.b(new d(this));
            this.m.c(this.k.m(), this.k.k());
        }
    }

    public final void j() {
        eq4 eq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eq4Var = this.k) == null) {
            return;
        }
        String m = eq4Var.m();
        if (ni.isForumName(m)) {
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(m, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            StatisticItem statisticItem = new StatisticItem("c13643");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.k.k());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", this.n ? 4 : 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (!z) {
                mu4 mu4Var = new mu4();
                mu4Var.r(R.color.CAM_X0302);
                this.h.setConfig(mu4Var);
                this.h.setText(this.i);
            } else {
                mu4 mu4Var2 = new mu4();
                mu4Var2.t(R.color.CAM_X0109);
                this.h.setConfig(mu4Var2);
                this.h.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f6d));
            }
            this.k.y(z);
        }
    }
}
