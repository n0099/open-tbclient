package com.repackage;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lk8;
import com.repackage.vv6;
/* loaded from: classes7.dex */
public class xv6 extends BdBaseViewPagerAdapter.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vv6 d;
    public boolean e;
    public LikeModel f;
    public lk8 g;
    public b h;
    public pv4 i;
    public pv4 j;
    public TbPageContext<?> k;
    public byte l;
    public TextView m;
    public BarImageView[] n;
    public TextView[] o;
    public TextView[] p;
    public TextView[] q;
    public TextView[] r;
    public TextView[] s;
    public FollowUserButton[] t;
    public final int[] u;
    public final int[] v;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends c9 implements lk8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public vv6.a a;
        public FollowUserButton b;
        public final /* synthetic */ xv6 c;

        public b(xv6 xv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xv6Var;
        }

        @Override // com.repackage.lk8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.c.e = false;
            }
        }

        @Override // com.repackage.lk8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.c.e = false;
                this.c.o(this.b, false);
                this.a.n(false);
            }
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.c.e = false;
                if (this.c.f.getErrorCode() == 22) {
                    qi.N(this.c.k.getPageActivity(), this.c.k.getString(R.string.obfuscated_res_0x7f0f0827));
                } else if (obj == null) {
                } else {
                    if (this.c.f.getErrorCode() != 0) {
                        qi.N(this.c.k.getPageActivity(), this.c.f.getErrorString());
                        return;
                    }
                    this.c.o(this.b, true);
                    this.a.n(true);
                }
            }
        }

        public void d(FollowUserButton followUserButton, vv6.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, followUserButton, aVar) == null) {
                this.a = aVar;
                this.b = followUserButton;
            }
        }

        public /* synthetic */ b(xv6 xv6Var, a aVar) {
            this(xv6Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xv6(View view2, TbPageContext<?> tbPageContext, byte b2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext, Byte.valueOf(b2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.i = new pv4();
        this.j = new pv4();
        this.n = new BarImageView[3];
        this.o = new TextView[3];
        this.p = new TextView[3];
        this.q = new TextView[3];
        this.r = new TextView[3];
        this.s = new TextView[3];
        this.t = new FollowUserButton[3];
        this.u = new int[]{R.id.obfuscated_res_0x7f091b43, R.id.obfuscated_res_0x7f091b44, R.id.obfuscated_res_0x7f091b45};
        this.v = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.k = tbPageContext;
        this.l = b2;
        k(view2);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void c(on onVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, onVar) == null) && (onVar instanceof vv6)) {
            vv6 vv6Var = (vv6) onVar;
            this.d = vv6Var;
            this.m.setText(vv6Var.a);
            for (int i = 0; i < 3; i++) {
                this.n[i].K(this.d.d[i].b(), 10, false);
                this.p[i].setText(this.d.d[i].c());
                this.s[i].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f95, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.d.d[i].f())}));
                this.r[i].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f93, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.d.d[i].a())}));
                this.t[i].setTag(Integer.valueOf(i));
                o(this.t[i], this.d.d[i].l());
                this.o[i].setVisibility(this.d.b ? 0 : 8);
                ((LinearLayout.LayoutParams) this.p[i].getLayoutParams()).leftMargin = qi.f(this.k.getPageActivity(), this.d.b ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.d.d[i].k())) {
                    this.q[i].setText(this.d.d[i].k());
                } else if (!StringUtils.isNull(this.d.d[i].h()) && UbsABTestHelper.isRecommendBarHotText()) {
                    this.q[i].setText(this.d.d[i].h());
                } else {
                    this.q[i].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f94));
                }
            }
        }
    }

    public final void h(vv6.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, followUserButton) == null) || this.e) {
            return;
        }
        if (!qi.D()) {
            UtilHelper.showToast(this.k.getPageActivity(), this.k.getString(R.string.obfuscated_res_0x7f0f0c3d));
        } else if (aVar == null || StringUtils.isNull(aVar.c()) || aVar.g() <= 0 || !ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
        } else {
            if (this.h == null) {
                this.h = new b(this, null);
            }
            if (this.f == null) {
                LikeModel likeModel = new LikeModel(this.k);
                this.f = likeModel;
                likeModel.setLoadDataCallBack(this.h);
            }
            this.h.d(followUserButton, aVar);
            if (pi.isForumName(aVar.c())) {
                this.e = true;
                this.f.M();
                this.f.Q(aVar.c(), String.valueOf(aVar.g()));
            }
        }
    }

    public final void i(vv6.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, followUserButton) == null) || this.e) {
            return;
        }
        if (!qi.D()) {
            UtilHelper.showToast(this.k.getPageActivity(), this.k.getString(R.string.obfuscated_res_0x7f0f0c3d));
        } else if (aVar == null || StringUtils.isNull(aVar.c()) || aVar.g() <= 0 || !ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
        } else {
            if (this.h == null) {
                this.h = new b(this, null);
            }
            if (this.g == null) {
                lk8 lk8Var = new lk8();
                this.g = lk8Var;
                lk8Var.b(this.h);
            }
            this.h.d(followUserButton, aVar);
            this.e = true;
            this.g.c(aVar.c(), aVar.g());
        }
    }

    public vv6 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (vv6) invokeV.objValue;
    }

    public final void k(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b46);
            this.i.t(R.color.CAM_X0109);
            this.i.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.j.r(R.color.CAM_X0304);
            this.j.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.j.f(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
            int i = 0;
            while (i < 3) {
                View findViewById = view2.findViewById(this.u[i]);
                findViewById.setTag(Integer.valueOf(i));
                findViewById.setOnClickListener(this);
                this.n[i] = (BarImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f091b42);
                this.o[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091b4c);
                this.p[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091b48);
                this.q[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091b41);
                this.r[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091b3f);
                this.s[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091b4a);
                this.t[i] = (FollowUserButton) findViewById.findViewById(R.id.obfuscated_res_0x7f091b3e);
                this.t[i].setOnClickListener(this);
                int i2 = i + 1;
                this.o[i].setText(String.valueOf(i2));
                this.n[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.n[i].setShowInnerBorder(true);
                this.n[i].setStrokeWith(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.n[i].setShowOval(true);
                this.n[i].setPlaceHolder(2);
                this.n[i].setShowOuterBorder(false);
                this.n[i].setStrokeColorResId(R.color.CAM_X0401);
                i = i2;
            }
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0108);
        for (int i2 = 0; i2 < 3; i2++) {
            if (this.o[i2].getVisibility() == 0) {
                SkinManager.setViewTextColor(this.o[i2], (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().defaultColor(this.v[i2]).cornerRadius(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8)).into(this.o[i2]);
            }
            this.t[i2].r(i);
            SkinManager.setViewTextColor(this.p[i2], (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q[i2], (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r[i2], (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s[i2], (int) R.color.CAM_X0109);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.m.setVisibility(z ? 0 : 8);
        }
    }

    public void n(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || this.d == null) {
            return;
        }
        if (z) {
            o(this.t[i], true);
            this.d.d[i].n(true);
            return;
        }
        o(this.t[i], false);
        this.d.d[i].n(false);
    }

    public final void o(FollowUserButton followUserButton, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, followUserButton, z) == null) || followUserButton == null) {
            return;
        }
        followUserButton.setConfig(z ? this.i : this.j);
        followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.obfuscated_res_0x7f0f0645 : R.string.obfuscated_res_0x7f0f02ab));
        followUserButton.r(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view2) == null) || this.d == null || view2 == null) {
            return;
        }
        int id = view2.getId();
        int intValue = ((Integer) view2.getTag()).intValue();
        vv6.a aVar = this.d.d[intValue];
        if (view2 instanceof TBSpecificationBtn) {
            if (aVar.l()) {
                i(aVar, this.t[intValue]);
                return;
            }
            h(aVar, this.t[intValue]);
            StatisticItem param = new StatisticItem("c13644").param("fid", aVar.g()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.l);
            if (!StringUtils.isNull(this.d.a)) {
                param = param.param("obj_name", this.d.a);
            }
            TiebaStatic.log(param);
        } else if (id == R.id.obfuscated_res_0x7f091b43 || id == R.id.obfuscated_res_0x7f091b44 || id == R.id.obfuscated_res_0x7f091b45) {
            FrsActivityConfig callFrom = new FrsActivityConfig(this.k.getPageActivity()).createNormalCfg(aVar.c(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
            if (UbsABTestHelper.isRecommendBarHotText()) {
                Intent intent = callFrom.getIntent();
                if (aVar.j() != 0 && intent != null) {
                    intent.putExtra("transition_type", 0);
                    intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.j());
                }
            }
            this.k.sendMessage(new CustomMessage(2003000, callFrom));
            StatisticItem param2 = new StatisticItem("c13988").param("fid", aVar.g()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.l);
            if (!StringUtils.isNull(this.d.a)) {
                param2 = param2.param("obj_name", this.d.a);
            }
            TiebaStatic.log(param2);
        }
    }
}
