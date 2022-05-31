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
import com.baidu.tieba.forumSquare.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kg8;
/* loaded from: classes5.dex */
public class ea6 extends nv5<ba6> {
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
    public ba6 r;
    public LikeModel s;
    public kg8 t;
    public boolean u;

    /* loaded from: classes5.dex */
    public class a extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ea6 a;

        public a(ea6 ea6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ea6Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.u = false;
                if (this.a.s.getErrorCode() == 22) {
                    li.O(this.a.b.getPageActivity(), this.a.b.getString(R.string.obfuscated_res_0x7f0f0811));
                } else if (obj == null) {
                } else {
                    if (this.a.s.getErrorCode() != 0) {
                        li.O(this.a.b.getPageActivity(), this.a.s.getErrorString());
                    } else {
                        this.a.y(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements kg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ea6 a;

        public b(ea6 ea6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ea6Var;
        }

        @Override // com.repackage.kg8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.a.u = false;
            }
        }

        @Override // com.repackage.kg8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.u = false;
                this.a.y(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ea6(TbPageContext<?> tbPageContext) {
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
        this.p = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f067e);
        this.q = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0682);
        View k = k();
        this.i = k;
        this.j = (BarImageView) k.findViewById(R.id.obfuscated_res_0x7f09030e);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09031b);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090762);
        this.m = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0913b4);
        this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0918c8);
        this.o = (TBSpecificationBtn) k.findViewById(R.id.obfuscated_res_0x7f090a3b);
    }

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d077d : invokeV.intValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            this.o.k();
            SkinManager.setBackgroundColor(k(), R.color.CAM_X0205);
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
            w();
            nw5<T> nw5Var = this.e;
            if (nw5Var != 0) {
                nw5Var.a(view2, this.r);
            }
        } else if (this.o == view2) {
            if (this.b.getPageActivity() instanceof ForumSquareActivity) {
                String f = ((ForumSquareActivity) this.b.getPageActivity()).getDelegate().f();
                if (!"推荐".equals(f)) {
                    statisticItem = new StatisticItem("c13653");
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, f);
                } else {
                    statisticItem = new StatisticItem("c13644");
                    statisticItem.param("obj_locate", 3);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.r.a);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.r.q() ? 2 : 1);
                TiebaStatic.log(statisticItem);
            }
            if (this.r.q()) {
                v();
            } else {
                u();
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.u) {
            return;
        }
        if (!li.D()) {
            UtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.obfuscated_res_0x7f0f0c33));
            return;
        }
        ba6 ba6Var = this.r;
        if (ba6Var == null || StringUtils.isNull(ba6Var.i()) || this.r.g() <= 0 || !ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
            return;
        }
        if (this.s == null) {
            LikeModel likeModel = new LikeModel(this.b);
            this.s = likeModel;
            likeModel.setLoadDataCallBack(new a(this));
        }
        if (ki.isForumName(this.r.i())) {
            this.u = true;
            this.s.L();
            this.s.P(this.r.i(), String.valueOf(this.r.g()));
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.u) {
            return;
        }
        if (!li.D()) {
            UtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.obfuscated_res_0x7f0f0c33));
            return;
        }
        ba6 ba6Var = this.r;
        if (ba6Var == null || StringUtils.isNull(ba6Var.i()) || this.r.g() <= 0 || !ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
            return;
        }
        if (this.t == null) {
            kg8 kg8Var = new kg8();
            this.t = kg8Var;
            kg8Var.b(new b(this));
        }
        this.u = true;
        this.t.c(this.r.i(), this.r.g());
    }

    public final void w() {
        ba6 ba6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (ba6Var = this.r) == null) {
            return;
        }
        String i = ba6Var.i();
        if (ki.isForumName(i)) {
            this.b.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.b.getPageActivity()).createNormalCfg(i, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nv5
    /* renamed from: x */
    public void l(ba6 ba6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ba6Var) == null) || ba6Var == null) {
            return;
        }
        this.r = ba6Var;
        this.j.setShowOval(true);
        this.j.setShowOuterBorder(false);
        this.j.setShowInnerBorder(true);
        this.j.setStrokeWith(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.j.setStrokeColorResId(R.color.CAM_X0401);
        this.j.K(ba6Var.e(), 10, false);
        String i = ba6Var.i();
        if (ki.isEmpty(i)) {
            i = "";
        }
        this.k.setText(i);
        this.m.setText(this.p + " " + StringHelper.numberUniformFormatExtra(ba6Var.k()));
        this.n.setText(this.q + " " + StringHelper.numberUniformFormatExtra((long) ba6Var.m()));
        z(ba6Var.getRecomReason());
        y(this.r.q());
        this.i.setOnClickListener(this);
        this.o.setOnClickListener(this);
        m(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (!z) {
                ot4 ot4Var = new ot4();
                ot4Var.r(R.color.CAM_X0302);
                this.o.setConfig(ot4Var);
                this.o.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0667));
            } else {
                ot4 ot4Var2 = new ot4();
                ot4Var2.t(R.color.CAM_X0109);
                this.o.setConfig(ot4Var2);
                this.o.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f067a));
            }
            this.r.s(z);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (ki.isEmpty(str)) {
                if (this.l.getVisibility() != 8) {
                    this.l.setVisibility(8);
                    if (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = li.f(this.b.getPageActivity(), R.dimen.tbds47);
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
                    ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = li.f(this.b.getPageActivity(), R.dimen.tbds24);
                    this.k.requestLayout();
                }
            }
            this.l.setText(str);
        }
    }
}
