package d.a.s0.a0;

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
/* loaded from: classes9.dex */
public class o extends b<d.a.s0.a0.e0.n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View B;
    public d.a.s0.a0.e0.n C;
    public String D;
    public View m;
    public TextView n;
    public TextView o;
    public LinearLayout p;
    public LinearLayout q;
    public LinearLayout r;
    public LinearLayout s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public View x;
    public View y;
    public View z;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f57133e;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57133e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || d.a.r0.p0.b.b(this.f57133e.k())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(this.f57133e.k().getPageActivity()).createNormalConfig("homepage", "all")));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        s(l());
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.home_card_hot_topic_item : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f57031e != i2) {
                SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.v, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.y, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.z, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.A, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.B, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.p, R.drawable.card_topic_click_selector);
                SkinManager.setBackgroundResource(this.q, R.drawable.card_topic_click_selector);
                SkinManager.setBackgroundResource(this.r, R.drawable.card_topic_click_selector);
                SkinManager.setBackgroundResource(this.s, R.drawable.card_topic_click_selector);
                t(this.t, 0);
                t(this.u, 1);
                t(this.v, 2);
                t(this.w, 3);
            }
            this.f57031e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            int d2 = d.a.c.e.m.b.d((String) view.getTag(), -1);
            d.a.s0.a0.e0.n nVar = this.C;
            if (nVar == null || ListUtils.getItem(nVar.f57079h, d2) == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(this.D).param("obj_locate", String.valueOf(this.C.j)).param("obj_name", this.C.f57079h.get(d2).f57074b));
            if (d2 >= 0 && !d.a.r0.p0.b.b(k())) {
                k().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(k().getPageActivity()).createNormalConfig(String.valueOf(this.C.f57079h.get(d2).f57073a), this.C.f57079h.get(d2).f57074b, "")));
            }
        }
    }

    public final void s(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.m = view.findViewById(R.id.home_card_hot_topic_root_view);
            this.n = (TextView) view.findViewById(R.id.home_card_topic_title);
            this.o = (TextView) view.findViewById(R.id.home_card_topic_more);
            this.p = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
            this.q = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
            this.r = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
            this.s = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
            this.t = (TextView) view.findViewById(R.id.home_card_topic_one);
            this.u = (TextView) view.findViewById(R.id.home_card_topic_two);
            this.v = (TextView) view.findViewById(R.id.home_card_topic_three);
            this.w = (TextView) view.findViewById(R.id.home_card_topic_four);
            this.x = view.findViewById(R.id.home_top_div);
            this.y = view.findViewById(R.id.home_top_topic_div_one);
            this.z = view.findViewById(R.id.home_top_topic_div_two);
            this.A = view.findViewById(R.id.home_card_top_divider_line);
            this.B = view.findViewById(R.id.home_card_bottom_divider_line);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.o.setOnClickListener(new a(this));
        }
    }

    public final void t(TextView textView, int i2) {
        d.a.s0.a0.e0.n nVar;
        d.a.s0.a0.e0.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, textView, i2) == null) || (nVar = this.C) == null || ListUtils.getCount(nVar.f57079h) < 4 || (mVar = (d.a.s0.a0.e0.m) ListUtils.getItem(this.C.f57079h, i2)) == null) {
            return;
        }
        int i3 = mVar.f57075c;
        if (i3 == 1) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
        } else if (i3 == 2) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
        } else if (i3 != 3) {
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: u */
    public void m(d.a.s0.a0.e0.n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nVar) == null) {
            if (nVar != null && !StringUtils.isNull(nVar.f57078g) && ListUtils.getCount(nVar.f57079h) >= 4) {
                if (this.m.getVisibility() != 0) {
                    this.m.setVisibility(0);
                }
                this.C = nVar;
                this.A.setVisibility(nVar.f57076e ? 0 : 8);
                y(this.C.f57077f);
                this.n.setText(this.C.f57078g.trim());
                x(this.t, 0);
                x(this.u, 1);
                x(this.v, 2);
                x(this.w, 3);
                t(this.t, 0);
                t(this.u, 1);
                t(this.v, 2);
                t(this.w, 3);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.D = str2;
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.A.getLayoutParams();
            layoutParams.height = i2;
            this.A.setLayoutParams(layoutParams);
        }
    }

    public final void x(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, textView, i2) == null) {
            d.a.s0.a0.e0.m mVar = this.C.f57079h.get(i2);
            if (StringUtils.isNull(mVar.f57074b)) {
                return;
            }
            textView.setText(mVar.f57074b.trim());
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.B.setVisibility(0);
            } else {
                this.B.setVisibility(8);
            }
        }
    }
}
