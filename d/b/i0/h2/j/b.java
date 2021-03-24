package d.b.i0.h2.j;

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
/* loaded from: classes5.dex */
public class b extends d.b.i0.x.b<d.b.i0.h2.e.b> {
    public View m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public BarImageView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public d.b.i0.h2.e.b v;
    public LikeModel w;
    public boolean x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes5.dex */
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
            if (data instanceof d.b.i0.c3.q0.e) {
                d.b.i0.c3.q0.e eVar = (d.b.i0.c3.q0.e) data;
                if (eVar.f53593a == b.this.v.j) {
                    if (eVar.f53594b) {
                        b.this.v.m = true;
                        b.this.u.setVisibility(0);
                        b.this.B(true);
                        d.b.b.e.p.l.K(b.this.f62181g, R.string.attention_success);
                    } else if (StringUtils.isNull(eVar.f53595c)) {
                        d.b.b.e.p.l.K(b.this.f62181g, R.string.attention_fail);
                    } else {
                        d.b.b.e.p.l.L(b.this.f62181g, eVar.f53595c);
                    }
                }
            }
        }
    }

    /* renamed from: d.b.i0.h2.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1276b extends CustomMessageListener {
        public C1276b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || b.this.x) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof d.b.i0.c3.q0.e) {
                d.b.i0.c3.q0.e eVar = (d.b.i0.c3.q0.e) data;
                if (eVar.f53593a == b.this.v.j) {
                    if (eVar.f53594b) {
                        b.this.v.m = false;
                        b.this.u.setVisibility(0);
                        b bVar = b.this;
                        bVar.B(bVar.v.m);
                        d.b.b.e.p.l.K(b.this.f62181g, R.string.unlike_success);
                        return;
                    }
                    d.b.b.e.p.l.K(b.this.f62181g, R.string.unlike_failure);
                }
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.y = new a(2001437);
        this.z = new C1276b(2001438);
        y(m());
    }

    public void A(LikeModel likeModel) {
        this.w = likeModel;
    }

    public final void B(boolean z) {
        if (z) {
            this.u.setText(this.f62181g.getString(R.string.relate_forum_is_followed));
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0110);
            SkinManager.setBackgroundResource(this.u, R.color.transparent);
            this.u.setClickable(false);
            return;
        }
        this.u.setText(this.f62181g.getString(R.string.focus_text));
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
        if (this.f62179e != i) {
            SkinManager.setBackgroundResource(this.m, R.drawable.item_person_header_attention_bg_selector);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0108, 1);
            d.b.i0.h2.e.b bVar = this.v;
            if (bVar != null) {
                B(bVar.m);
            }
        }
        this.f62179e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.m == view) {
            if (!this.x) {
                TiebaStatic.log(new StatisticItem("c11595"));
            }
            this.f62180f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f62181g).createNormalCfg(this.v.l, "")));
        } else if (this.u == view) {
            TiebaStatic.log(new StatisticItem("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(this.f62181g);
            } else if (d.b.b.e.p.k.isForumName(this.v.l)) {
                d.b.i0.h2.e.b bVar = this.v;
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
        this.f62180f.registerListener(this.y);
        this.f62180f.registerListener(this.z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: z */
    public void n(d.b.i0.h2.e.b bVar) {
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
        this.x = bVar.f55268e;
        this.n.setVisibility(bVar.f55270g ? 0 : 4);
        this.o.setVisibility(bVar.f55270g ? 0 : 4);
        this.n.setText(bVar.i);
        this.o.setText(bVar.f55271h);
        TextView textView = this.p;
        if (bVar.f55268e) {
            string = this.f62181g.getString(R.string.me);
        } else {
            if (bVar.f55269f == 2) {
                context = this.f62181g;
                i = R.string.she;
            } else {
                context = this.f62181g;
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
        this.s.setText(String.format(this.f62181g.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = StringHelper.numFormatOverWanNa(bVar.n);
        this.t.setText(bVar.f55268e ? String.format(this.f62181g.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, StringHelper.numFormatOverWanNa(bVar.o)) : String.format(this.f62181g.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (!bVar.m && !bVar.f55268e) {
            this.u.setVisibility(0);
            B(bVar.m);
            return;
        }
        this.u.setVisibility(8);
    }
}
