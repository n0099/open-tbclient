package d.a.n0.j2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
/* loaded from: classes5.dex */
public class c extends d.a.n0.z.b<d.a.n0.j2.e.d> {
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            if (!c.this.y) {
                TiebaStatic.log(new StatisticItem("c11595"));
            }
            if (view.getTag() instanceof UserData) {
                UserData userData = (UserData) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(c.this.w.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
            }
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.v = 3;
        this.w = tbPageContext;
        View m = m();
        v();
        this.u = m.findViewById(R.id.bottom_divider);
        this.n = (TextView) m.findViewById(R.id.month_num);
        this.m = (TextView) m.findViewById(R.id.day_num);
        this.o = (TextView) m.findViewById(R.id.identity);
        this.p = (TextView) m.findViewById(R.id.attention_str);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) m.findViewById(R.id.header1);
        this.q = clickableHeaderImageView;
        clickableHeaderImageView.setRadius(d.a.c.e.p.l.g(this.w.getPageActivity(), R.dimen.ds100));
        this.q.setAutoChangeStyle(true);
        this.q.setOnClickListener(this.x);
        ClickableHeaderImageView clickableHeaderImageView2 = (ClickableHeaderImageView) m.findViewById(R.id.header2);
        this.r = clickableHeaderImageView2;
        clickableHeaderImageView2.setRadius(d.a.c.e.p.l.g(this.w.getPageActivity(), R.dimen.ds100));
        this.r.setAutoChangeStyle(true);
        this.r.setOnClickListener(this.x);
        ClickableHeaderImageView clickableHeaderImageView3 = (ClickableHeaderImageView) m.findViewById(R.id.header3);
        this.s = clickableHeaderImageView3;
        clickableHeaderImageView3.setRadius(d.a.c.e.p.l.g(this.w.getPageActivity(), R.dimen.ds100));
        this.s.setAutoChangeStyle(true);
        this.s.setOnClickListener(this.x);
        this.t = (TextView) m.findViewById(R.id.etc_person);
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.person_info_attention_card;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.v != i2) {
            SkinManager.setBackgroundResource(m(), R.drawable.home_thread_card_item_bg);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0108);
        }
        this.v = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void v() {
        this.x = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: w */
    public void n(d.a.n0.j2.e.d dVar) {
        if (dVar == null) {
            if (m() != null) {
                m().setVisibility(8);
                return;
            }
            return;
        }
        if (m() != null) {
            m().setVisibility(0);
        }
        this.y = dVar.f60084e;
        this.m.setText(dVar.f60087h);
        this.n.setText(dVar.f60086g);
        this.m.setVisibility(dVar.f60085f ? 0 : 4);
        this.n.setVisibility(dVar.f60085f ? 0 : 4);
        if (dVar.f60084e) {
            this.o.setText(this.w.getString(R.string.me));
        } else {
            this.o.setText(StringHelper.getUserDescByGender(dVar.f60088i));
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
            this.s.U(dVar.j.get(2).getPortrait(), 12, false);
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
            this.r.U(dVar.j.get(1).getPortrait(), 12, false);
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
            this.q.U(dVar.j.get(0).getPortrait(), 12, false);
        } else {
            this.q.setVisibility(8);
        }
        o(this.w, TbadkCoreApplication.getInst().getSkinType());
    }
}
