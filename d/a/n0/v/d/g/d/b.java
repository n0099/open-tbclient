package d.a.n0.v.d.g.d;

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
import d.a.m0.r.q.a2;
import d.a.m0.z0.i0;
/* loaded from: classes4.dex */
public class b extends d.a.n0.z.b<d.a.n0.v.d.a.c> {
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
                if (b.this.q == null || b.this.q.s1() == null || b.this.p == null) {
                    return;
                }
                b.this.p.a(b.this.r, b.this.s, b.this.q);
                return;
            }
            l.J(b.this.n.getPageActivity(), b.this.n.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    /* renamed from: d.a.n0.v.d.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1714b implements View.OnClickListener {
        public View$OnClickListenerC1714b() {
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
        public View f65524a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f65525b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65526c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65527d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f65528e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f65529f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65530g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f65531h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f65532i;

        public c(b bVar, View view) {
            this.f65524a = view;
            this.f65525b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f65526c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f65527d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f65528e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f65529f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f65530g = (TextView) view.findViewById(R.id.tvUserName);
            this.f65531h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f65532i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f65525b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f65525b.setDrawerType(0);
            this.f65529f.setIsRound(true);
            this.f65529f.setDrawBorder(true);
            this.f65529f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f65529f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f65529f.setIsGod(false);
            this.f65529f.setIsBigV(false);
            this.f65529f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65528e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f65528e.setLayoutParams(layoutParams);
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.m = 3;
        this.t = false;
        this.u = new a();
        this.v = new View$OnClickListenerC1714b();
        this.n = tbPageContext;
        this.o = new c(this, m());
        this.t = z;
    }

    public void A(f fVar) {
        this.p = fVar;
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.ala_sub_list_game_item_view;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.m != i2) {
            SkinManager.setBackgroundResource(this.o.f65528e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.o.f65527d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o.f65530g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o.f65531h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.o.f65532i, R.color.CAM_X0109);
            this.m = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: z */
    public void n(d.a.n0.v.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f65130h) != null && a2Var.s1() != null) {
            m().setVisibility(0);
            this.q = cVar.f65130h;
            this.r = cVar.f65127e;
            this.s = !TextUtils.isEmpty(cVar.f65129g) ? cVar.f65129g : cVar.f65128f;
            this.o.f65525b.U(this.q.s1().cover, 10, false);
            this.o.f65527d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.s1().audience_count)));
            this.o.f65529f.setData(this.q, false);
            this.o.f65531h.setText(this.q.A1());
            if (this.q.T() != null) {
                String name_show = this.q.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.o.f65530g.setText(name_show);
            }
            String str = this.q.s1().label_name;
            if (this.t && !StringUtils.isNull(str)) {
                this.o.f65526c.setText(str);
                this.o.f65526c.setVisibility(0);
            } else {
                this.o.f65526c.setVisibility(8);
            }
            if (cVar.f65131i) {
                this.o.f65532i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.s1().distance / 1000.0d))));
                this.o.f65532i.setVisibility(0);
            } else {
                this.o.f65532i.setVisibility(8);
            }
            this.o.f65530g.setOnClickListener(this.v);
            o(this.n, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        m().setVisibility(4);
    }
}
