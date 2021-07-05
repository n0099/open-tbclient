package d.a.s0.m2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c extends d.a.s0.a0.b<d.a.s0.m2.e.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public ClickableHeaderImageView q;
    public ClickableHeaderImageView r;
    public ClickableHeaderImageView s;
    public TextView t;
    public View u;
    public int v;
    public TbPageContext<?> w;
    public View.OnClickListener x;
    public boolean y;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f63604e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63604e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (!this.f63604e.y) {
                TiebaStatic.log(new StatisticItem("c11595"));
            }
            if (view.getTag() instanceof UserData) {
                UserData userData = (UserData) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f63604e.w.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext) {
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
        this.v = 3;
        this.w = tbPageContext;
        View l = l();
        u();
        this.u = l.findViewById(R.id.bottom_divider);
        this.n = (TextView) l.findViewById(R.id.month_num);
        this.m = (TextView) l.findViewById(R.id.day_num);
        this.o = (TextView) l.findViewById(R.id.identity);
        this.p = (TextView) l.findViewById(R.id.attention_str);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) l.findViewById(R.id.header1);
        this.q = clickableHeaderImageView;
        clickableHeaderImageView.setRadius(d.a.c.e.p.l.g(this.w.getPageActivity(), R.dimen.ds100));
        this.q.setAutoChangeStyle(true);
        this.q.setOnClickListener(this.x);
        ClickableHeaderImageView clickableHeaderImageView2 = (ClickableHeaderImageView) l.findViewById(R.id.header2);
        this.r = clickableHeaderImageView2;
        clickableHeaderImageView2.setRadius(d.a.c.e.p.l.g(this.w.getPageActivity(), R.dimen.ds100));
        this.r.setAutoChangeStyle(true);
        this.r.setOnClickListener(this.x);
        ClickableHeaderImageView clickableHeaderImageView3 = (ClickableHeaderImageView) l.findViewById(R.id.header3);
        this.s = clickableHeaderImageView3;
        clickableHeaderImageView3.setRadius(d.a.c.e.p.l.g(this.w.getPageActivity(), R.dimen.ds100));
        this.s.setAutoChangeStyle(true);
        this.s.setOnClickListener(this.x);
        this.t = (TextView) l.findViewById(R.id.etc_person);
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.person_info_attention_card : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.v != i2) {
                SkinManager.setBackgroundResource(l(), R.drawable.home_thread_card_item_bg);
                SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0108);
            }
            this.v = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.x = new a(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: v */
    public void m(d.a.s0.m2.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            if (dVar == null) {
                if (l() != null) {
                    l().setVisibility(8);
                    return;
                }
                return;
            }
            if (l() != null) {
                l().setVisibility(0);
            }
            this.y = dVar.f63476e;
            this.m.setText(dVar.f63479h);
            this.n.setText(dVar.f63478g);
            this.m.setVisibility(dVar.f63477f ? 0 : 4);
            this.n.setVisibility(dVar.f63477f ? 0 : 4);
            if (dVar.f63476e) {
                this.o.setText(this.w.getString(R.string.me));
            } else {
                this.o.setText(StringHelper.getUserDescByGender(dVar.f63480i));
            }
            int count = ListUtils.getCount(dVar.j);
            if (count > 3) {
                this.t.setVisibility(0);
                this.t.setText(String.format(this.w.getString(R.string.attention_etc_person), Integer.valueOf(count)));
            } else {
                this.t.setVisibility(8);
            }
            if (count >= 3) {
                this.s.setVisibility(0);
                this.s.setTag(dVar.j.get(2));
                if (dVar.j.get(2).getGodUserData() != null && dVar.j.get(2).getGodUserData().getType() == 2) {
                    this.s.setIsGod(true);
                } else {
                    this.s.setIsGod(false);
                }
                this.s.M(dVar.j.get(2).getPortrait(), 12, false);
            } else {
                this.s.setVisibility(8);
            }
            if (count >= 2) {
                this.r.setVisibility(0);
                this.r.setTag(dVar.j.get(1));
                if (dVar.j.get(1).getGodUserData() != null && dVar.j.get(1).getGodUserData().getType() == 2) {
                    this.r.setIsGod(true);
                } else {
                    this.r.setIsGod(false);
                }
                this.r.M(dVar.j.get(1).getPortrait(), 12, false);
            } else {
                this.r.setVisibility(8);
            }
            if (count >= 1) {
                this.q.setVisibility(0);
                this.q.setTag(dVar.j.get(0));
                if (dVar.j.get(0).getGodUserData() != null && dVar.j.get(0).getGodUserData().getType() == 2) {
                    this.q.setIsGod(true);
                } else {
                    this.q.setIsGod(false);
                }
                this.q.M(dVar.j.get(0).getPortrait(), 12, false);
            } else {
                this.q.setVisibility(8);
            }
            n(this.w, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
