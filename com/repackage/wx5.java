package com.repackage;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wx5 extends jx5<zy5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TextView j;
    public TextView k;
    public LinearLayout l;
    public LinearLayout m;
    public LinearLayout n;
    public LinearLayout o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public View t;
    public View u;
    public View v;
    public View w;
    public View x;
    public zy5 y;
    public String z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wx5 a;

        public a(wx5 wx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wx5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || id5.b(this.a.g())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(this.a.g().getPageActivity()).createNormalConfig("homepage", "all")));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wx5(TbPageContext<?> tbPageContext) {
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
        r(h());
    }

    @Override // com.repackage.jx5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0385 : invokeV.intValue;
    }

    @Override // com.repackage.jx5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(this.t, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.u, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.v, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.w, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.l, R.drawable.card_topic_click_selector);
                SkinManager.setBackgroundResource(this.m, R.drawable.card_topic_click_selector);
                SkinManager.setBackgroundResource(this.n, R.drawable.card_topic_click_selector);
                SkinManager.setBackgroundResource(this.o, R.drawable.card_topic_click_selector);
                s(this.p, 0);
                s(this.q, 1);
                s(this.r, 2);
                s(this.s, 3);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            int e = ng.e((String) view2.getTag(), -1);
            zy5 zy5Var = this.y;
            if (zy5Var == null || ListUtils.getItem(zy5Var.d, e) == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(this.z).param("obj_locate", String.valueOf(this.y.f)).param("obj_name", this.y.d.get(e).b));
            if (e >= 0 && !id5.b(g())) {
                g().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(g().getPageActivity()).createNormalConfig(String.valueOf(this.y.d.get(e).a), this.y.d.get(e).b, "")));
            }
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f090d22);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d2c);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d29);
            this.l = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d26);
            this.m = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d28);
            this.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d27);
            this.o = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d25);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d2a);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d2d);
            this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d2b);
            this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d24);
            this.t = view2.findViewById(R.id.obfuscated_res_0x7f090d44);
            this.u = view2.findViewById(R.id.obfuscated_res_0x7f090d45);
            this.v = view2.findViewById(R.id.obfuscated_res_0x7f090d46);
            this.w = view2.findViewById(R.id.obfuscated_res_0x7f090d23);
            this.x = view2.findViewById(R.id.obfuscated_res_0x7f090d21);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.k.setOnClickListener(new a(this));
        }
    }

    public final void s(TextView textView, int i) {
        zy5 zy5Var;
        yy5 yy5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, textView, i) == null) || (zy5Var = this.y) == null || ListUtils.getCount(zy5Var.d) < 4 || (yy5Var = (yy5) ListUtils.getItem(this.y.d, i)) == null) {
            return;
        }
        int i2 = yy5Var.c;
        if (i2 == 1) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
        } else if (i2 == 2) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
        } else if (i2 != 3) {
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jx5
    /* renamed from: t */
    public void i(zy5 zy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, zy5Var) == null) {
            if (zy5Var != null && !StringUtils.isNull(zy5Var.c) && ListUtils.getCount(zy5Var.d) >= 4) {
                if (this.i.getVisibility() != 0) {
                    this.i.setVisibility(0);
                }
                this.y = zy5Var;
                this.w.setVisibility(zy5Var.a ? 0 : 8);
                x(this.y.b);
                this.j.setText(this.y.c.trim());
                w(this.p, 0);
                w(this.q, 1);
                w(this.r, 2);
                w(this.s, 3);
                s(this.p, 0);
                s(this.q, 1);
                s(this.r, 2);
                s(this.s, 3);
                return;
            }
            this.i.setVisibility(8);
        }
    }

    public void u(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.z = str2;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
            layoutParams.height = i;
            this.w.setLayoutParams(layoutParams);
        }
    }

    public final void w(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, textView, i) == null) {
            yy5 yy5Var = this.y.d.get(i);
            if (StringUtils.isNull(yy5Var.b)) {
                return;
            }
            textView.setText(yy5Var.b.trim());
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.x.setVisibility(0);
            } else {
                this.x.setVisibility(8);
            }
        }
    }
}
