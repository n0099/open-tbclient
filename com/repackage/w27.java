package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class w27 extends tw5<t27> {
    public static /* synthetic */ Interceptable $ic;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public final View i;
    public int j;
    public CellTopicLinearLayout k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public RelativeLayout p;
    public TbImageView q;
    public View r;
    public TopicPkView s;
    public ThreadGodReplyLayout t;
    public View u;
    public RelativeLayout v;
    public HeadImageView w;
    public t27 x;
    public final int y;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755253195, "Lcom/repackage/w27;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755253195, "Lcom/repackage/w27;");
                return;
            }
        }
        z = oi.k(TbadkCoreApplication.getInst()) - ((oi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + oi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w27(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = 3;
        this.y = oi.f(getContext(), R.dimen.M_W_X005);
        View k = k();
        this.k = (CellTopicLinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0905cf);
        this.v = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f0905d1);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0905cc);
        this.m = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0905d0);
        this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0905cd);
        this.o = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0905c6);
        this.p = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f0905c9);
        this.q = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f0905c8);
        this.r = k.findViewById(R.id.obfuscated_res_0x7f0905cb);
        this.s = (TopicPkView) k.findViewById(R.id.obfuscated_res_0x7f0905ce);
        this.t = (ThreadGodReplyLayout) k.findViewById(R.id.obfuscated_res_0x7f0905c7);
        this.u = k.findViewById(R.id.obfuscated_res_0x7f0905ca);
        this.i = k.findViewById(R.id.obfuscated_res_0x7f0905c5);
        HeadImageView headImageView = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f09227b);
        this.w = headImageView;
        headImageView.setIsRound(true);
        this.w.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.w.setDefaultResource(17170445);
        this.w.setPlaceHolder(1);
        u(this.v);
        u(this.o);
        u(this.t);
        u(this.i);
        u(this.q);
        u(this.u);
        int f = oi.f(getContext(), R.dimen.tbds11);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams.leftMargin = f;
        layoutParams.rightMargin = f;
        this.s.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.q.getLayoutParams();
        layoutParams2.height = ((oi.k(getContext()) - oi.f(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.q.setLayoutParams(layoutParams2);
        this.q.setRadiusById(R.string.J_X05);
        this.q.setConrers(15);
        this.q.setDrawCorner(true);
        this.q.setPlaceHolder(3);
    }

    @Override // com.repackage.tw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01d8 : invokeV.intValue;
    }

    @Override // com.repackage.tw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.s.r();
            this.t.k();
            if (i == this.j) {
                return;
            }
            this.j = i;
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
            this.q.setSkinType(this.j);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        t27 t27Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || (t27Var = this.x) == null) {
            return;
        }
        if (t27Var.Z != 1) {
            TiebaStatic.log(new StatisticItem("c13351").param("topic_id", this.x.S).param("obj_locate", this.x.R));
        }
        if (this.x.Z == 1) {
            TiebaStatic.log(new StatisticItem("c13449").param("topic_id", this.x.S));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(getContext(), this.x.S)));
    }

    public CellTopicLinearLayout s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (CellTopicLinearLayout) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tw5
    /* renamed from: t */
    public void l(t27 t27Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, t27Var) == null) || t27Var == null) {
            return;
        }
        this.x = t27Var;
        if (t27Var.Z == 0) {
            this.w.setVisibility(8);
            this.l.setVisibility(0);
            this.n.setVisibility(0);
            this.l.setText(String.valueOf(t27Var.R));
            int i = t27Var.R;
            if (i == 1) {
                SkinManager.setBackgroundResource(this.l, R.drawable.topic_rank_one_bg);
            } else if (i == 2) {
                SkinManager.setBackgroundResource(this.l, R.drawable.topic_rank_two_bg);
            } else if (i == 3) {
                SkinManager.setBackgroundResource(this.l, R.drawable.topic_rank_three_bg);
            } else {
                SkinManager.setBackgroundResource(this.l, R.drawable.topic_rank_other_bg);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            int f = oi.f(getContext(), R.dimen.tbds16);
            layoutParams.addRule(1, R.id.obfuscated_res_0x7f0905cc);
            layoutParams.setMargins(f, 0, f, 0);
            ThreadCardUtils.cutAndSetTextByMaxLine(this.o, t27Var.U, R.string.obfuscated_res_0x7f0f03ab, R.dimen.tbds17, 2, z, true);
            if (t27Var.V == 0) {
                this.n.setText("NEW");
            } else {
                this.n.setText(String.format(this.b.getString(R.string.obfuscated_res_0x7f0f140e), StringHelper.numberUniformFormat(t27Var.V)));
            }
            if (t27Var.Y == null) {
                this.t.setVisibility(8);
            } else {
                this.t.setVisibility(0);
                this.t.setData(t27Var.Y);
            }
        } else {
            this.w.setVisibility(0);
            this.l.setVisibility(8);
            this.n.setVisibility(8);
            this.t.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            int f2 = oi.f(getContext(), R.dimen.tbds30);
            int f3 = oi.f(getContext(), R.dimen.tbds16);
            layoutParams2.addRule(1, R.id.obfuscated_res_0x7f09227b);
            layoutParams2.setMargins(f2, 0, f3, 0);
            this.m.setTextSize(0, oi.f(this.c, R.dimen.tbds40));
            vr4 d = vr4.d(this.m);
            d.v(R.color.CAM_X0105);
            d.A(R.string.F_X01);
            if (StringUtils.isNull(t27Var.U)) {
                this.o.setVisibility(8);
            } else {
                this.o.setVisibility(0);
                ThreadCardUtils.setAbstractStyleAb(this.o);
                ThreadCardUtils.cutAndSetTextByMaxLine(this.o, t27Var.U, R.string.obfuscated_res_0x7f0f03ab, R.dimen.tbds17, 2, z, true, false);
            }
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        }
        String str = t27Var.T;
        if (str.length() > 14) {
            str = str.substring(0, 13) + StringHelper.STRING_MORE;
        }
        this.m.setText(String.format(this.b.getString(R.string.obfuscated_res_0x7f0f0470), str));
        if (StringUtils.isNull(t27Var.W)) {
            this.p.setVisibility(8);
            this.s.setUserColor(R.color.CAM_X0109);
        } else {
            this.p.setVisibility(0);
            this.q.setPlaceHolder(3);
            this.q.K(t27Var.W, 10, false);
            this.s.setUserColor(R.color.CAM_X0101);
        }
        if (!StringUtils.isNull(t27Var.g0)) {
            this.w.setVisibility(0);
            this.w.K(t27Var.g0, 10, false);
        }
        if (t27Var.X == null) {
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            this.u.setVisibility(8);
            return;
        }
        this.r.setVisibility(0);
        this.s.setVisibility(0);
        this.s.setData(t27Var.X);
        this.u.setVisibility(0);
    }

    public final void u(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int i = this.y;
            marginLayoutParams.leftMargin = i;
            marginLayoutParams.rightMargin = i;
            view2.setLayoutParams(marginLayoutParams);
        }
    }
}
