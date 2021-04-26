package d.a.j0.t.d.g.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.i0.r.q.a2;
import d.a.i0.z0.i0;
/* loaded from: classes4.dex */
public class b extends d.a.j0.x.b<d.a.j0.t.d.a.c> {
    public int m;
    public TbPageContext<?> n;
    public c o;
    public f p;
    public a2 q;
    public int r;
    public String s;
    public boolean t;
    public View.OnClickListener u;
    public View.OnClickListener v;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (b.this.q == null || b.this.q.q1() == null || b.this.p == null) {
                    return;
                }
                b.this.p.a(b.this.r, b.this.s, b.this.q);
                return;
            }
            l.J(b.this.n.getPageActivity(), b.this.n.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    /* renamed from: d.a.j0.t.d.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1572b implements View.OnClickListener {
        public View$OnClickListenerC1572b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.q == null || b.this.q.T() == null || StringUtils.isNull(b.this.q.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(b.this.q.T().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(b.this.n.getPageActivity()).createNormalConfig(f2, f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), b.this.q.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f60797a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60798b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60799c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60800d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f60801e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f60802f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60803g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f60804h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f60805i;

        public c(b bVar, View view) {
            this.f60797a = view;
            this.f60798b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f60799c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f60800d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f60801e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f60802f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f60803g = (TextView) view.findViewById(R.id.tvUserName);
            this.f60804h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f60805i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f60798b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f60798b.setDrawerType(0);
            this.f60802f.setIsRound(true);
            this.f60802f.setDrawBorder(true);
            this.f60802f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f60802f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f60802f.setIsGod(false);
            this.f60802f.setIsBigV(false);
            this.f60802f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60801e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f60801e.setLayoutParams(layoutParams);
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.m = 3;
        this.t = false;
        this.u = new a();
        this.v = new View$OnClickListenerC1572b();
        this.n = tbPageContext;
        this.o = new c(this, l());
        this.t = z;
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.ala_sub_list_game_item_view;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.m != i2) {
            SkinManager.setBackgroundResource(this.o.f60801e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.o.f60800d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o.f60803g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o.f60804h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.o.f60805i, R.color.CAM_X0109);
            this.m = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: y */
    public void m(d.a.j0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f60405h) != null && a2Var.q1() != null) {
            l().setVisibility(0);
            this.q = cVar.f60405h;
            this.r = cVar.f60402e;
            this.s = !TextUtils.isEmpty(cVar.f60404g) ? cVar.f60404g : cVar.f60403f;
            this.o.f60798b.V(this.q.q1().cover, 10, false);
            this.o.f60800d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.q1().audience_count)));
            this.o.f60802f.setData(this.q, false);
            this.o.f60804h.setText(this.q.x1());
            if (this.q.T() != null) {
                String name_show = this.q.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.o.f60803g.setText(name_show);
            }
            String str = this.q.q1().label_name;
            if (this.t && !StringUtils.isNull(str)) {
                this.o.f60799c.setText(str);
                this.o.f60799c.setVisibility(0);
            } else {
                this.o.f60799c.setVisibility(8);
            }
            if (cVar.f60406i) {
                this.o.f60805i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.q1().distance / 1000.0d))));
                this.o.f60805i.setVisibility(0);
            } else {
                this.o.f60805i.setVisibility(8);
            }
            this.o.f60803g.setOnClickListener(this.v);
            n(this.n, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        l().setVisibility(4);
    }

    public void z(f fVar) {
        this.p = fVar;
    }
}
