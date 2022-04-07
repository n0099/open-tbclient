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
/* loaded from: classes6.dex */
public class ex5 extends rw5<hy5> {
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
    public hy5 y;
    public String z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex5 a;

        public a(ex5 ex5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || hc5.b(this.a.j())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(this.a.j().getPageActivity()).createNormalConfig("homepage", "all")));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex5(TbPageContext<?> tbPageContext) {
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
        s(k());
    }

    @Override // com.repackage.rw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0395 : invokeV.intValue;
    }

    @Override // com.repackage.rw5
    public void m(TbPageContext<?> tbPageContext, int i) {
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
                t(this.p, 0);
                t(this.q, 1);
                t(this.r, 2);
                t(this.s, 3);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            int e = mg.e((String) view2.getTag(), -1);
            hy5 hy5Var = this.y;
            if (hy5Var == null || ListUtils.getItem(hy5Var.d, e) == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(this.z).param("obj_locate", String.valueOf(this.y.f)).param("obj_name", this.y.d.get(e).b));
            if (e >= 0 && !hc5.b(j())) {
                j().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(j().getPageActivity()).createNormalConfig(String.valueOf(this.y.d.get(e).a), this.y.d.get(e).b, "")));
            }
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f090d70);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d7a);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d77);
            this.l = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d74);
            this.m = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d76);
            this.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d75);
            this.o = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d73);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d78);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d7b);
            this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d79);
            this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d72);
            this.t = view2.findViewById(R.id.obfuscated_res_0x7f090d90);
            this.u = view2.findViewById(R.id.obfuscated_res_0x7f090d91);
            this.v = view2.findViewById(R.id.obfuscated_res_0x7f090d92);
            this.w = view2.findViewById(R.id.obfuscated_res_0x7f090d71);
            this.x = view2.findViewById(R.id.obfuscated_res_0x7f090d6f);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.k.setOnClickListener(new a(this));
        }
    }

    public final void t(TextView textView, int i) {
        hy5 hy5Var;
        gy5 gy5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, textView, i) == null) || (hy5Var = this.y) == null || ListUtils.getCount(hy5Var.d) < 4 || (gy5Var = (gy5) ListUtils.getItem(this.y.d, i)) == null) {
            return;
        }
        int i2 = gy5Var.c;
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
    @Override // com.repackage.rw5
    /* renamed from: u */
    public void l(hy5 hy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hy5Var) == null) {
            if (hy5Var != null && !StringUtils.isNull(hy5Var.c) && ListUtils.getCount(hy5Var.d) >= 4) {
                if (this.i.getVisibility() != 0) {
                    this.i.setVisibility(0);
                }
                this.y = hy5Var;
                this.w.setVisibility(hy5Var.a ? 0 : 8);
                y(this.y.b);
                this.j.setText(this.y.c.trim());
                x(this.p, 0);
                x(this.q, 1);
                x(this.r, 2);
                x(this.s, 3);
                t(this.p, 0);
                t(this.q, 1);
                t(this.r, 2);
                t(this.s, 3);
                return;
            }
            this.i.setVisibility(8);
        }
    }

    public void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.z = str2;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
            layoutParams.height = i;
            this.w.setLayoutParams(layoutParams);
        }
    }

    public final void x(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, textView, i) == null) {
            gy5 gy5Var = this.y.d.get(i);
            if (StringUtils.isNull(gy5Var.b)) {
                return;
            }
            textView.setText(gy5Var.b.trim());
        }
    }

    public void y(boolean z) {
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
