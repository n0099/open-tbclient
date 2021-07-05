package d.a.s0.e1.k.b.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import d.a.c.e.p.l;
import d.a.r0.r.u.c;
/* loaded from: classes9.dex */
public class a extends d.a.s0.a0.b<d.a.s0.e1.k.b.c.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int D;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout A;
    public d.a.s0.e1.k.b.c.a B;
    public final int C;
    public final View m;
    public int n;
    public CellTopicLinearLayout o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public RelativeLayout t;
    public TbImageView u;
    public View v;
    public TopicPkView w;
    public ThreadGodReplyLayout x;
    public TextView y;
    public View z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1151699572, "Ld/a/s0/e1/k/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1151699572, "Ld/a/s0/e1/k/b/d/a;");
                return;
            }
        }
        D = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = 3;
        this.C = l.g(b(), R.dimen.M_W_X005);
        View l = l();
        this.o = (CellTopicLinearLayout) l.findViewById(R.id.cell_topic_root);
        this.A = (RelativeLayout) l.findViewById(R.id.cell_topic_top_layout);
        this.p = (TextView) l.findViewById(R.id.cell_topic_index);
        this.q = (TextView) l.findViewById(R.id.cell_topic_title);
        this.r = (TextView) l.findViewById(R.id.cell_topic_partake);
        this.s = (TextView) l.findViewById(R.id.cell_topic_des);
        this.t = (RelativeLayout) l.findViewById(R.id.cell_topic_img_layout);
        this.u = (TbImageView) l.findViewById(R.id.cell_topic_img);
        this.v = l.findViewById(R.id.cell_topic_img_placeholder);
        this.w = (TopicPkView) l.findViewById(R.id.cell_topic_pk);
        this.x = (ThreadGodReplyLayout) l.findViewById(R.id.cell_topic_god_reply);
        this.y = (TextView) l.findViewById(R.id.cell_topic_icon);
        this.z = l.findViewById(R.id.cell_topic_img_mask);
        this.m = l.findViewById(R.id.cell_topic_bottom_placeholder);
        u(this.A);
        u(this.s);
        u(this.x);
        u(this.m);
        u(this.u);
        u(this.z);
        int g2 = l.g(b(), R.dimen.tbds11);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.w.getLayoutParams();
        layoutParams.leftMargin = g2;
        layoutParams.rightMargin = g2;
        this.w.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.u.getLayoutParams();
        layoutParams2.height = ((l.k(b()) - l.g(b(), R.dimen.tbds88)) * 9) / 16;
        this.u.setLayoutParams(layoutParams2);
        this.u.setRadiusById(R.string.J_X05);
        this.u.setConrers(15);
        this.u.setDrawCorner(true);
        this.u.setPlaceHolder(3);
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.cell_topic_card_layout : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.w.q();
            this.x.l();
            if (i2 == this.n) {
                return;
            }
            this.n = i2;
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105);
            this.u.setIsNight(this.n == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.s0.e1.k.b.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (aVar = this.B) == null) {
            return;
        }
        if (aVar.c0 != 1) {
            TiebaStatic.log(new StatisticItem("c13351").param("topic_id", this.B.V).param("obj_locate", this.B.U));
        }
        if (this.B.c0 == 1) {
            TiebaStatic.log(new StatisticItem("c13449").param("topic_id", this.B.V));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(b(), this.B.V)));
    }

    public CellTopicLinearLayout s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : (CellTopicLinearLayout) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: t */
    public void m(d.a.s0.e1.k.b.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        this.B = aVar;
        if (aVar.c0 == 0) {
            this.y.setVisibility(8);
            this.p.setVisibility(0);
            this.r.setVisibility(0);
            this.p.setText(String.valueOf(aVar.U));
            int i2 = aVar.U;
            if (i2 == 1) {
                SkinManager.setBackgroundResource(this.p, R.drawable.topic_rank_one_bg);
            } else if (i2 == 2) {
                SkinManager.setBackgroundResource(this.p, R.drawable.topic_rank_two_bg);
            } else if (i2 == 3) {
                SkinManager.setBackgroundResource(this.p, R.drawable.topic_rank_three_bg);
            } else {
                SkinManager.setBackgroundResource(this.p, R.drawable.topic_rank_other_bg);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            int g2 = l.g(b(), R.dimen.tbds16);
            layoutParams.addRule(1, R.id.cell_topic_index);
            layoutParams.setMargins(g2, 0, g2, 0);
            ThreadCardUtils.cutAndSetTextByMaxLine(this.s, aVar.X, R.string.check_detail, R.dimen.tbds17, 2, D, true);
            if (aVar.Y == 0) {
                this.r.setText("NEW");
            } else {
                this.r.setText(String.format(this.f57032f.getString(R.string.topic_partake_default), StringHelper.numberUniformFormat(aVar.Y)));
            }
            if (aVar.b0 == null) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
                this.x.setData(aVar.b0);
            }
        } else {
            this.y.setVisibility(0);
            this.p.setVisibility(8);
            this.r.setVisibility(8);
            this.x.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            int g3 = l.g(b(), R.dimen.tbds30);
            int g4 = l.g(b(), R.dimen.tbds16);
            layoutParams2.addRule(1, R.id.cell_topic_icon);
            layoutParams2.setMargins(g3, 0, g4, 0);
            this.q.setTextSize(0, l.g(this.f57033g, R.dimen.tbds40));
            c d2 = c.d(this.q);
            d2.t(R.color.CAM_X0105);
            d2.y(R.string.F_X01);
            if (StringUtils.isNull(aVar.X)) {
                this.s.setVisibility(8);
            } else {
                this.s.setVisibility(0);
                ThreadCardUtils.cutAndSetTextByMaxLine(this.s, aVar.X, R.string.check_detail, R.dimen.tbds17, 2, D, true, false);
            }
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
        }
        String str = aVar.W;
        if (str.length() > 14) {
            str = str.substring(0, 13) + StringHelper.STRING_MORE;
        }
        this.q.setText(String.format(this.f57032f.getString(R.string.daily_topic_name), str));
        if (StringUtils.isNull(aVar.Z)) {
            this.t.setVisibility(8);
            this.w.setUserColor(R.color.CAM_X0109);
        } else {
            this.t.setVisibility(0);
            this.u.setPlaceHolder(3);
            this.u.M(aVar.Z, 10, false);
            this.w.setUserColor(R.color.CAM_X0101);
        }
        if (aVar.a0 == null) {
            this.v.setVisibility(8);
            this.w.setVisibility(8);
            this.z.setVisibility(8);
            return;
        }
        this.v.setVisibility(0);
        this.w.setVisibility(0);
        this.w.setData(aVar.a0);
        this.z.setVisibility(0);
    }

    public final void u(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i2 = this.C;
            marginLayoutParams.leftMargin = i2;
            marginLayoutParams.rightMargin = i2;
            view.setLayoutParams(marginLayoutParams);
        }
    }
}
