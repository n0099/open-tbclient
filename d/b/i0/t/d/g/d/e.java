package d.b.i0.t.d.g.d;

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
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.z0.i0;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f60651b;

    /* renamed from: c  reason: collision with root package name */
    public c f60652c;

    /* renamed from: d  reason: collision with root package name */
    public View f60653d;

    /* renamed from: e  reason: collision with root package name */
    public int f60654e;

    /* renamed from: f  reason: collision with root package name */
    public String f60655f;

    /* renamed from: g  reason: collision with root package name */
    public a2 f60656g;

    /* renamed from: h  reason: collision with root package name */
    public g f60657h;
    public boolean i;

    /* renamed from: a  reason: collision with root package name */
    public int f60650a = 3;
    public View.OnClickListener j = new a();
    public View.OnClickListener k = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (e.this.f60656g == null || e.this.f60656g.q1() == null || e.this.f60657h == null) {
                    return;
                }
                e.this.f60657h.a(e.this.f60654e, e.this.f60655f, e.this.f60656g);
                return;
            }
            l.I(e.this.f60651b.getPageActivity(), e.this.f60651b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f60656g == null || e.this.f60656g.T() == null || StringUtils.isNull(e.this.f60656g.T().getUserId())) {
                return;
            }
            long f2 = d.b.b.e.m.b.f(e.this.f60656g.T().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(e.this.f60651b.getPageActivity()).createNormalConfig(f2, f2 == d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.f60656g.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f60660a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60661b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60662c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60663d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f60664e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f60665f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60666g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f60667h;
        public TextView i;

        public c(e eVar, View view) {
            this.f60660a = view;
            this.f60661b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f60662c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f60663d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f60664e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f60665f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f60666g = (TextView) view.findViewById(R.id.tvUserName);
            this.f60667h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f60661b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f60661b.setDrawerType(0);
            this.f60665f.setIsRound(true);
            this.f60665f.setDrawBorder(true);
            this.f60665f.setBorderColor(eVar.f60651b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f60665f.setBorderWidth(eVar.f60651b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f60665f.setIsGod(false);
            this.f60665f.setIsBigV(false);
            this.f60665f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60664e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f60664e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.f60651b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f60653d = inflate;
        this.f60652c = new c(this, inflate);
        this.i = z;
    }

    public View g() {
        return this.f60653d;
    }

    public void h(d.b.i0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f60241h) != null && a2Var.q1() != null) {
            g().setVisibility(0);
            this.f60656g = cVar.f60241h;
            this.f60654e = cVar.f60238e;
            this.f60655f = !TextUtils.isEmpty(cVar.f60240g) ? cVar.f60240g : cVar.f60239f;
            this.f60652c.f60661b.setDrawerType(0);
            this.f60652c.f60661b.setBorderSurroundContent(true);
            this.f60652c.f60661b.setDrawBorder(true);
            this.f60652c.f60661b.W(this.f60656g.q1().cover, 10, false);
            this.f60652c.f60663d.setText(this.f60651b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f60656g.q1().audience_count)));
            this.f60652c.f60665f.setData(this.f60656g, false);
            this.f60652c.f60667h.setText(this.f60656g.x1());
            if (this.f60656g.T() != null) {
                String name_show = this.f60656g.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f60652c.f60666g.setText(name_show);
            }
            String str = this.f60656g.q1().label_name;
            if (this.i && !StringUtils.isNull(str)) {
                this.f60652c.f60662c.setText(str);
                this.f60652c.f60662c.setVisibility(0);
            } else {
                this.f60652c.f60662c.setVisibility(8);
            }
            if (cVar.i) {
                this.f60652c.i.setText(this.f60651b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f60656g.q1().distance / 1000.0d))));
                this.f60652c.i.setVisibility(0);
            } else {
                this.f60652c.i.setVisibility(8);
            }
            this.f60652c.f60666g.setOnClickListener(this.k);
            i(this.f60651b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        g().setVisibility(4);
    }

    public void i(TbPageContext<?> tbPageContext, int i) {
        if (this.f60650a != i) {
            SkinManager.setBackgroundResource(this.f60652c.f60664e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f60652c.f60663d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60652c.f60666g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60652c.f60667h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60652c.i, R.color.CAM_X0109);
            this.f60650a = i;
        }
    }

    public void j(g gVar) {
        this.f60657h = gVar;
    }
}
