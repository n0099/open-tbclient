package d.b.i0.i2.j;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import d.b.h0.z0.i0;
/* loaded from: classes3.dex */
public class b extends d.b.i0.x.b<d.b.i0.i2.e.b> {
    public View m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public BarImageView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public d.b.i0.i2.e.b v;
    public LikeModel w;
    public boolean x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || b.this.x) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof d.b.i0.d3.q0.e) {
                d.b.i0.d3.q0.e eVar = (d.b.i0.d3.q0.e) data;
                if (eVar.f55038a == b.this.v.j) {
                    if (eVar.f55039b) {
                        b.this.v.m = true;
                        b.this.u.setVisibility(0);
                        b.this.B(true);
                        d.b.c.e.p.l.K(b.this.f63757g, R.string.attention_success);
                    } else if (StringUtils.isNull(eVar.f55040c)) {
                        d.b.c.e.p.l.K(b.this.f63757g, R.string.attention_fail);
                    } else {
                        d.b.c.e.p.l.L(b.this.f63757g, eVar.f55040c);
                    }
                }
            }
        }
    }

    /* renamed from: d.b.i0.i2.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1352b extends CustomMessageListener {
        public C1352b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || b.this.x) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof d.b.i0.d3.q0.e) {
                d.b.i0.d3.q0.e eVar = (d.b.i0.d3.q0.e) data;
                if (eVar.f55038a == b.this.v.j) {
                    if (eVar.f55039b) {
                        b.this.v.m = false;
                        b.this.u.setVisibility(0);
                        b bVar = b.this;
                        bVar.B(bVar.v.m);
                        d.b.c.e.p.l.K(b.this.f63757g, R.string.unlike_success);
                        return;
                    }
                    d.b.c.e.p.l.K(b.this.f63757g, R.string.unlike_failure);
                }
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.y = new a(2001437);
        this.z = new C1352b(2001438);
        y(m());
    }

    public void A(LikeModel likeModel) {
        this.w = likeModel;
    }

    public final void B(boolean z) {
        if (z) {
            this.u.setText(this.f63757g.getString(R.string.relate_forum_is_followed));
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0110);
            SkinManager.setBackgroundResource(this.u, R.color.transparent);
            this.u.setClickable(false);
            return;
        }
        this.u.setText(this.f63757g.getString(R.string.focus_text));
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0302, 1);
        SkinManager.setBackgroundResource(this.u, R.drawable.polymeric_attention_btn_bg);
        this.u.setClickable(true);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_polymeric_attention_bar_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext tbPageContext, int i) {
        if (this.f63755e != i) {
            SkinManager.setBackgroundResource(this.m, R.drawable.item_person_header_attention_bg_selector);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0108, 1);
            d.b.i0.i2.e.b bVar = this.v;
            if (bVar != null) {
                B(bVar.m);
            }
        }
        this.f63755e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.m == view) {
            if (!this.x) {
                TiebaStatic.log(new StatisticItem("c11595"));
            }
            this.f63756f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f63757g).createNormalCfg(this.v.l, "")));
        } else if (this.u == view) {
            TiebaStatic.log(new StatisticItem("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(this.f63757g);
            } else if (d.b.c.e.p.k.isForumName(this.v.l)) {
                d.b.i0.i2.e.b bVar = this.v;
                if (bVar.m) {
                    return;
                }
                this.w.H(bVar.l, String.valueOf(bVar.j));
            }
        }
    }

    public final void y(View view) {
        this.m = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.n = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.o = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.p = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.q = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.r = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.s = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.t = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.u = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.m.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.f63756f.registerListener(this.y);
        this.f63756f.registerListener(this.z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: z */
    public void n(d.b.i0.i2.e.b bVar) {
        Context context;
        int i;
        String string;
        if (bVar == null) {
            this.m.setVisibility(8);
            return;
        }
        if (this.m.getVisibility() != 0) {
            this.m.setVisibility(0);
        }
        this.v = bVar;
        this.x = bVar.f57127e;
        this.n.setVisibility(bVar.f57129g ? 0 : 4);
        this.o.setVisibility(bVar.f57129g ? 0 : 4);
        this.n.setText(bVar.i);
        this.o.setText(bVar.f57130h);
        TextView textView = this.p;
        if (bVar.f57127e) {
            string = this.f63757g.getString(R.string.me);
        } else {
            if (bVar.f57128f == 2) {
                context = this.f63757g;
                i = R.string.she;
            } else {
                context = this.f63757g;
                i = R.string.he;
            }
            string = context.getString(i);
        }
        textView.setText(string);
        this.r.W(bVar.k, 10, false);
        String str = bVar.l;
        if (i0.b(str) > 10) {
            str = i0.k(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.s.setText(String.format(this.f63757g.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = StringHelper.numFormatOverWanNa(bVar.n);
        this.t.setText(bVar.f57127e ? String.format(this.f63757g.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, StringHelper.numFormatOverWanNa(bVar.o)) : String.format(this.f63757g.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (!bVar.m && !bVar.f57127e) {
            this.u.setVisibility(0);
            B(bVar.m);
            return;
        }
        this.u.setVisibility(8);
    }
}
