package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yh8;
/* loaded from: classes7.dex */
public class yf8 extends jx5<hf8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public BarImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TBSpecificationBtn o;
    public String p;
    public String q;
    public hf8 r;
    public LikeModel s;
    public yh8 t;
    public boolean u;

    /* loaded from: classes7.dex */
    public class a extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf8 a;

        public a(yf8 yf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf8Var;
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.u = false;
                if (this.a.s.getErrorCode() == 22) {
                    pi.O(this.a.b.getPageActivity(), this.a.b.getString(R.string.obfuscated_res_0x7f0f0819));
                } else if (obj == null) {
                } else {
                    if (this.a.s.getErrorCode() != 0) {
                        pi.O(this.a.b.getPageActivity(), this.a.s.getErrorString());
                    } else {
                        this.a.x(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yh8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf8 a;

        public b(yf8 yf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf8Var;
        }

        @Override // com.repackage.yh8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.a.u = false;
            }
        }

        @Override // com.repackage.yh8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.u = false;
                this.a.x(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yf8(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = false;
        this.p = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f067c);
        this.q = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0680);
        View h = h();
        this.i = h;
        this.j = (BarImageView) h.findViewById(R.id.obfuscated_res_0x7f090313);
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090320);
        this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090754);
        this.m = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091452);
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091968);
        this.o = (TBSpecificationBtn) h.findViewById(R.id.obfuscated_res_0x7f090a32);
    }

    @Override // com.repackage.jx5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d079a : invokeV.intValue;
    }

    @Override // com.repackage.jx5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            this.o.k();
            SkinManager.setBackgroundColor(h(), R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || this.r == null) {
            return;
        }
        if (this.i == view2) {
            v();
            jy5<T> jy5Var = this.e;
            if (jy5Var != 0) {
                jy5Var.a(view2, this.r);
            }
        } else if (this.o == view2) {
            if (this.b.getPageActivity() instanceof ForumSquareActivity) {
                String className = ((ForumSquareActivity) this.b.getPageActivity()).A1().getClassName();
                if (!"推荐".equals(className)) {
                    statisticItem = new StatisticItem("c13653");
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, className);
                } else {
                    statisticItem = new StatisticItem("c13644");
                    statisticItem.param("obj_locate", 3);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.r.a);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.r.m() ? 2 : 1);
                TiebaStatic.log(statisticItem);
            }
            if (this.r.m()) {
                u();
            } else {
                t();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.u) {
            return;
        }
        if (!pi.D()) {
            UtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.obfuscated_res_0x7f0f0c2b));
            return;
        }
        hf8 hf8Var = this.r;
        if (hf8Var == null || StringUtils.isNull(hf8Var.g()) || this.r.d() <= 0 || !ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
            return;
        }
        if (this.s == null) {
            LikeModel likeModel = new LikeModel(this.b);
            this.s = likeModel;
            likeModel.setLoadDataCallBack(new a(this));
        }
        if (oi.isForumName(this.r.g())) {
            this.u = true;
            this.s.N();
            this.s.R(this.r.g(), String.valueOf(this.r.d()));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.u) {
            return;
        }
        if (!pi.D()) {
            UtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.obfuscated_res_0x7f0f0c2b));
            return;
        }
        hf8 hf8Var = this.r;
        if (hf8Var == null || StringUtils.isNull(hf8Var.g()) || this.r.d() <= 0 || !ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
            return;
        }
        if (this.t == null) {
            yh8 yh8Var = new yh8();
            this.t = yh8Var;
            yh8Var.b(new b(this));
        }
        this.u = true;
        this.t.c(this.r.g(), this.r.d());
    }

    public final void v() {
        hf8 hf8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (hf8Var = this.r) == null) {
            return;
        }
        String g = hf8Var.g();
        if (oi.isForumName(g)) {
            this.b.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.b.getPageActivity()).createNormalCfg(g, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jx5
    /* renamed from: w */
    public void i(hf8 hf8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, hf8Var) == null) || hf8Var == null) {
            return;
        }
        this.r = hf8Var;
        this.j.setShowOval(true);
        this.j.setShowOuterBorder(false);
        this.j.setShowInnerBorder(true);
        this.j.setStrokeWith(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.j.setStrokeColorResId(R.color.CAM_X0401);
        this.j.J(hf8Var.c(), 10, false);
        String g = hf8Var.g();
        if (oi.isEmpty(g)) {
            g = "";
        }
        this.k.setText(g);
        this.m.setText(this.p + " " + StringHelper.numberUniformFormatExtra(hf8Var.i()));
        this.n.setText(this.q + " " + StringHelper.numberUniformFormatExtra((long) hf8Var.k()));
        y(hf8Var.getRecomReason());
        x(this.r.m());
        this.i.setOnClickListener(this);
        this.o.setOnClickListener(this);
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (!z) {
                uu4 uu4Var = new uu4();
                uu4Var.r(R.color.CAM_X0302);
                this.o.setConfig(uu4Var);
                this.o.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0665));
            } else {
                uu4 uu4Var2 = new uu4();
                uu4Var2.t(R.color.CAM_X0109);
                this.o.setConfig(uu4Var2);
                this.o.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0678));
            }
            this.r.s(z);
        }
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (oi.isEmpty(str)) {
                if (this.l.getVisibility() != 8) {
                    this.l.setVisibility(8);
                    if (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = pi.f(this.b.getPageActivity(), R.dimen.tbds47);
                        this.k.requestLayout();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.l.getVisibility() != 0) {
                this.l.setVisibility(0);
                if (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = pi.f(this.b.getPageActivity(), R.dimen.tbds24);
                    this.k.requestLayout();
                }
            }
            this.l.setText(str);
        }
    }
}
