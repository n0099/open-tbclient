package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ad.FrsAdCommentScrollView;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class th6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public mj8 b;
    public ForumData c;
    public RoundAdapterLinearLayout d;
    public TextView e;
    public TbImageView f;
    public TextView g;
    public FrsAdCommentScrollView h;
    public TextView i;
    public rh6 j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th6 a;

        public a(th6 th6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = th6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || StringUtils.isNull(this.a.b.o())) {
                return;
            }
            if (!wh5.a(this.a.a, this.a.b.h())) {
                cr6.b((TbPageContext) h9.a(this.a.a), this.a.b.j(), this.a.b.o(), this.a.b.i());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.a.b.c());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i = 6;
            if (this.a.b.getType() != 1) {
                if (this.a.b.getType() == 2) {
                    i = 7;
                } else if (this.a.b.getType() == 3) {
                    i = 8;
                } else if (this.a.b.getType() == 4) {
                    i = 21;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
            statisticItem.param("obj_id", this.a.b.c());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (this.a.c != null) {
                statisticItem.param("fid", this.a.c.getId());
                statisticItem.param("fname", this.a.c.getName());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.a.c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.a.c.getSecond_class());
            }
            if (this.a.b.getType() == 1) {
                statisticItem.param("tid", this.a.b.l());
                statisticItem.param("thread_type", this.a.b.m());
            }
            if (StringUtils.isNull(this.a.b.p())) {
                statisticItem.param("obj_type", 1);
            } else {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.a.b.k(), 1));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th6 a;

        public b(th6 th6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = th6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j.u();
            }
        }
    }

    public th6(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        g(context);
    }

    public void e(ForumData forumData, mj8 mj8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, forumData, mj8Var, z) == null) || mj8Var == null) {
            return;
        }
        this.c = forumData;
        this.b = mj8Var;
        this.e.setText(mj8Var.n());
        if (mj8Var.getType() == 3) {
            this.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0756, Integer.valueOf(this.b.g())));
        } else if (mj8Var.getType() == 1) {
            this.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0758, Integer.valueOf(this.b.g())));
        } else if (mj8Var.getType() == 2) {
            this.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0754, Integer.valueOf(this.b.g())));
        } else if (mj8Var.getType() == 4) {
            this.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0755, Integer.valueOf(this.b.g())));
        }
        this.f.K(this.b.d(), 10, false);
        mj8 mj8Var2 = this.b;
        if (mj8Var2 != null && mj8Var2.f()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        FrsAdCommentScrollView frsAdCommentScrollView = this.h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.m(this.b.a());
        }
        if (!z && forumData != null && ar6.j(this.b, forumData.getId())) {
            this.j.s(this.b, forumData, Long.parseLong(forumData.getId()));
            this.h.post(new b(this));
        }
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.b.k(), 0));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d034a, (ViewGroup) null);
            this.d = roundAdapterLinearLayout;
            roundAdapterLinearLayout.setRadius(this.a.getResources().getDimension(R.dimen.tbds20));
            this.e = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090bf5);
            this.g = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090bfa);
            TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090bf3);
            this.f = tbImageView;
            tbImageView.setDefaultBgResource(R.color.white_alpha100);
            this.h = (FrsAdCommentScrollView) this.d.findViewById(R.id.obfuscated_res_0x7f090098);
            TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090bf4);
            this.i = textView;
            ms4 d = ms4.d(textView);
            d.n(R.string.J_X01);
            d.f(R.color.CAM_X0602);
            ms4.d(this.i).v(R.color.CAM_X0617);
            this.j = new rh6(context, this.d, this.f);
            this.d.setOnClickListener(new a(this));
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f.invalidate();
        }
    }

    public void i() {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsAdCommentScrollView = this.h) == null) {
            return;
        }
        frsAdCommentScrollView.o();
    }

    public void j() {
        rh6 rh6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (rh6Var = this.j) == null) {
            return;
        }
        rh6Var.q();
    }

    public void k(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (frsAdCommentScrollView = this.h) == null) {
            return;
        }
        frsAdCommentScrollView.p(z);
    }

    public void l() {
        rh6 rh6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (rh6Var = this.j) == null) {
            return;
        }
        rh6Var.r();
    }
}
