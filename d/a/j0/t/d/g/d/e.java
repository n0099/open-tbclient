package d.a.j0.t.d.g.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class e {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f60823b;

    /* renamed from: c  reason: collision with root package name */
    public c f60824c;

    /* renamed from: d  reason: collision with root package name */
    public View f60825d;

    /* renamed from: e  reason: collision with root package name */
    public int f60826e;

    /* renamed from: f  reason: collision with root package name */
    public String f60827f;

    /* renamed from: g  reason: collision with root package name */
    public a2 f60828g;

    /* renamed from: h  reason: collision with root package name */
    public f f60829h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60830i;

    /* renamed from: a  reason: collision with root package name */
    public int f60822a = 3;
    public View.OnClickListener j = new a();
    public View.OnClickListener k = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (e.this.f60828g == null || e.this.f60828g.q1() == null || e.this.f60829h == null) {
                    return;
                }
                e.this.f60829h.a(e.this.f60826e, e.this.f60827f, e.this.f60828g);
                return;
            }
            l.J(e.this.f60823b.getPageActivity(), e.this.f60823b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f60828g == null || e.this.f60828g.T() == null || StringUtils.isNull(e.this.f60828g.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(e.this.f60828g.T().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(e.this.f60823b.getPageActivity()).createNormalConfig(f2, f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.f60828g.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f60833a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60834b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60835c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60836d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f60837e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f60838f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60839g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f60840h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f60841i;

        public c(e eVar, View view) {
            this.f60833a = view;
            this.f60834b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f60835c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f60836d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f60837e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f60838f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f60839g = (TextView) view.findViewById(R.id.tvUserName);
            this.f60840h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f60841i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f60834b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f60834b.setDrawerType(0);
            this.f60838f.setIsRound(true);
            this.f60838f.setDrawBorder(true);
            this.f60838f.setBorderColor(eVar.f60823b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f60838f.setBorderWidth(eVar.f60823b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f60838f.setIsGod(false);
            this.f60838f.setIsBigV(false);
            this.f60838f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60837e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f60837e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.f60823b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f60825d = inflate;
        this.f60824c = new c(this, inflate);
        this.f60830i = z;
    }

    public View g() {
        return this.f60825d;
    }

    public void h(d.a.j0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f60405h) != null && a2Var.q1() != null) {
            g().setVisibility(0);
            this.f60828g = cVar.f60405h;
            this.f60826e = cVar.f60402e;
            this.f60827f = !TextUtils.isEmpty(cVar.f60404g) ? cVar.f60404g : cVar.f60403f;
            this.f60824c.f60834b.setDrawerType(0);
            this.f60824c.f60834b.setBorderSurroundContent(true);
            this.f60824c.f60834b.setDrawBorder(true);
            this.f60824c.f60834b.V(this.f60828g.q1().cover, 10, false);
            this.f60824c.f60836d.setText(this.f60823b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f60828g.q1().audience_count)));
            this.f60824c.f60838f.setData(this.f60828g, false);
            this.f60824c.f60840h.setText(this.f60828g.x1());
            if (this.f60828g.T() != null) {
                String name_show = this.f60828g.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f60824c.f60839g.setText(name_show);
            }
            String str = this.f60828g.q1().label_name;
            if (this.f60830i && !StringUtils.isNull(str)) {
                this.f60824c.f60835c.setText(str);
                this.f60824c.f60835c.setVisibility(0);
            } else {
                this.f60824c.f60835c.setVisibility(8);
            }
            if (cVar.f60406i) {
                this.f60824c.f60841i.setText(this.f60823b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f60828g.q1().distance / 1000.0d))));
                this.f60824c.f60841i.setVisibility(0);
            } else {
                this.f60824c.f60841i.setVisibility(8);
            }
            this.f60824c.f60839g.setOnClickListener(this.k);
            i(this.f60823b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        g().setVisibility(4);
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        if (this.f60822a != i2) {
            SkinManager.setBackgroundResource(this.f60824c.f60837e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f60824c.f60836d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60824c.f60839g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60824c.f60840h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60824c.f60841i, R.color.CAM_X0109);
            this.f60822a = i2;
        }
    }

    public void j(f fVar) {
        this.f60829h = fVar;
    }
}
