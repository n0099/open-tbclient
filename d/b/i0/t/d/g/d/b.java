package d.b.i0.t.d.g.d;

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
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.z0.i0;
/* loaded from: classes4.dex */
public class b extends d.b.i0.x.b<d.b.i0.t.d.a.c> {
    public int m;
    public TbPageContext<?> n;
    public c o;
    public g p;
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
            l.I(b.this.n.getPageActivity(), b.this.n.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    /* renamed from: d.b.i0.t.d.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1556b implements View.OnClickListener {
        public View$OnClickListenerC1556b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.q == null || b.this.q.T() == null || StringUtils.isNull(b.this.q.T().getUserId())) {
                return;
            }
            long f2 = d.b.b.e.m.b.f(b.this.q.T().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(b.this.n.getPageActivity()).createNormalConfig(f2, f2 == d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), b.this.q.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f60629a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60630b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60631c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60632d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f60633e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f60634f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60635g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f60636h;
        public TextView i;

        public c(b bVar, View view) {
            this.f60629a = view;
            this.f60630b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f60631c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f60632d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f60633e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f60634f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f60635g = (TextView) view.findViewById(R.id.tvUserName);
            this.f60636h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f60630b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f60630b.setDrawerType(0);
            this.f60634f.setIsRound(true);
            this.f60634f.setDrawBorder(true);
            this.f60634f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f60634f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f60634f.setIsGod(false);
            this.f60634f.setIsBigV(false);
            this.f60634f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60633e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f60633e.setLayoutParams(layoutParams);
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.m = 3;
        this.t = false;
        this.u = new a();
        this.v = new View$OnClickListenerC1556b();
        this.n = tbPageContext;
        this.o = new c(this, m());
        this.t = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: A */
    public void n(d.b.i0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f60242h) != null && a2Var.q1() != null) {
            m().setVisibility(0);
            this.q = cVar.f60242h;
            this.r = cVar.f60239e;
            this.s = !TextUtils.isEmpty(cVar.f60241g) ? cVar.f60241g : cVar.f60240f;
            this.o.f60630b.W(this.q.q1().cover, 10, false);
            this.o.f60632d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.q1().audience_count)));
            this.o.f60634f.setData(this.q, false);
            this.o.f60636h.setText(this.q.x1());
            if (this.q.T() != null) {
                String name_show = this.q.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.o.f60635g.setText(name_show);
            }
            String str = this.q.q1().label_name;
            if (this.t && !StringUtils.isNull(str)) {
                this.o.f60631c.setText(str);
                this.o.f60631c.setVisibility(0);
            } else {
                this.o.f60631c.setVisibility(8);
            }
            if (cVar.i) {
                this.o.i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.q1().distance / 1000.0d))));
                this.o.i.setVisibility(0);
            } else {
                this.o.i.setVisibility(8);
            }
            this.o.f60635g.setOnClickListener(this.v);
            o(this.n, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        m().setVisibility(4);
    }

    public void B(g gVar) {
        this.p = gVar;
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.ala_sub_list_game_item_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.m != i) {
            SkinManager.setBackgroundResource(this.o.f60633e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.o.f60632d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o.f60635g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o.f60636h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.o.i, R.color.CAM_X0109);
            this.m = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
