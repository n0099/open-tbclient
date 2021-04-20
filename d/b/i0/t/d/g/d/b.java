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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
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
    public class View$OnClickListenerC1609b implements View.OnClickListener {
        public View$OnClickListenerC1609b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.q == null || b.this.q.T() == null || StringUtils.isNull(b.this.q.T().getUserId())) {
                return;
            }
            long f2 = d.b.c.e.m.b.f(b.this.q.T().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(b.this.n.getPageActivity()).createNormalConfig(f2, f2 == d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), b.this.q.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f62193a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62194b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62195c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62196d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f62197e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f62198f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f62199g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f62200h;
        public TextView i;

        public c(b bVar, View view) {
            this.f62193a = view;
            this.f62194b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f62195c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f62196d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f62197e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f62198f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f62199g = (TextView) view.findViewById(R.id.tvUserName);
            this.f62200h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f62194b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f62194b.setDrawerType(0);
            this.f62198f.setIsRound(true);
            this.f62198f.setDrawBorder(true);
            this.f62198f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f62198f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f62198f.setIsGod(false);
            this.f62198f.setIsBigV(false);
            this.f62198f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62197e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f62197e.setLayoutParams(layoutParams);
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.m = 3;
        this.t = false;
        this.u = new a();
        this.v = new View$OnClickListenerC1609b();
        this.n = tbPageContext;
        this.o = new c(this, m());
        this.t = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: A */
    public void n(d.b.i0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f61806h) != null && a2Var.q1() != null) {
            m().setVisibility(0);
            this.q = cVar.f61806h;
            this.r = cVar.f61803e;
            this.s = !TextUtils.isEmpty(cVar.f61805g) ? cVar.f61805g : cVar.f61804f;
            this.o.f62194b.W(this.q.q1().cover, 10, false);
            this.o.f62196d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.q1().audience_count)));
            this.o.f62198f.setData(this.q, false);
            this.o.f62200h.setText(this.q.x1());
            if (this.q.T() != null) {
                String name_show = this.q.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.o.f62199g.setText(name_show);
            }
            String str = this.q.q1().label_name;
            if (this.t && !StringUtils.isNull(str)) {
                this.o.f62195c.setText(str);
                this.o.f62195c.setVisibility(0);
            } else {
                this.o.f62195c.setVisibility(8);
            }
            if (cVar.i) {
                this.o.i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.q1().distance / 1000.0d))));
                this.o.i.setVisibility(0);
            } else {
                this.o.i.setVisibility(8);
            }
            this.o.f62199g.setOnClickListener(this.v);
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
            SkinManager.setBackgroundResource(this.o.f62197e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.o.f62196d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o.f62199g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o.f62200h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.o.i, R.color.CAM_X0109);
            this.m = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
