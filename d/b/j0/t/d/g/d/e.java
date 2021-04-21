package d.b.j0.t.d.g.d;

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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import d.b.i0.z0.i0;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f62637b;

    /* renamed from: c  reason: collision with root package name */
    public c f62638c;

    /* renamed from: d  reason: collision with root package name */
    public View f62639d;

    /* renamed from: e  reason: collision with root package name */
    public int f62640e;

    /* renamed from: f  reason: collision with root package name */
    public String f62641f;

    /* renamed from: g  reason: collision with root package name */
    public a2 f62642g;

    /* renamed from: h  reason: collision with root package name */
    public g f62643h;
    public boolean i;

    /* renamed from: a  reason: collision with root package name */
    public int f62636a = 3;
    public View.OnClickListener j = new a();
    public View.OnClickListener k = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (e.this.f62642g == null || e.this.f62642g.q1() == null || e.this.f62643h == null) {
                    return;
                }
                e.this.f62643h.a(e.this.f62640e, e.this.f62641f, e.this.f62642g);
                return;
            }
            l.I(e.this.f62637b.getPageActivity(), e.this.f62637b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f62642g == null || e.this.f62642g.T() == null || StringUtils.isNull(e.this.f62642g.T().getUserId())) {
                return;
            }
            long f2 = d.b.c.e.m.b.f(e.this.f62642g.T().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(e.this.f62637b.getPageActivity()).createNormalConfig(f2, f2 == d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.f62642g.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f62646a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62647b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62648c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62649d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f62650e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f62651f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f62652g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f62653h;
        public TextView i;

        public c(e eVar, View view) {
            this.f62646a = view;
            this.f62647b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f62648c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f62649d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f62650e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f62651f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f62652g = (TextView) view.findViewById(R.id.tvUserName);
            this.f62653h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f62647b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f62647b.setDrawerType(0);
            this.f62651f.setIsRound(true);
            this.f62651f.setDrawBorder(true);
            this.f62651f.setBorderColor(eVar.f62637b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f62651f.setBorderWidth(eVar.f62637b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f62651f.setIsGod(false);
            this.f62651f.setIsBigV(false);
            this.f62651f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62650e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f62650e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.f62637b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f62639d = inflate;
        this.f62638c = new c(this, inflate);
        this.i = z;
    }

    public View g() {
        return this.f62639d;
    }

    public void h(d.b.j0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f62227h) != null && a2Var.q1() != null) {
            g().setVisibility(0);
            this.f62642g = cVar.f62227h;
            this.f62640e = cVar.f62224e;
            this.f62641f = !TextUtils.isEmpty(cVar.f62226g) ? cVar.f62226g : cVar.f62225f;
            this.f62638c.f62647b.setDrawerType(0);
            this.f62638c.f62647b.setBorderSurroundContent(true);
            this.f62638c.f62647b.setDrawBorder(true);
            this.f62638c.f62647b.W(this.f62642g.q1().cover, 10, false);
            this.f62638c.f62649d.setText(this.f62637b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f62642g.q1().audience_count)));
            this.f62638c.f62651f.setData(this.f62642g, false);
            this.f62638c.f62653h.setText(this.f62642g.x1());
            if (this.f62642g.T() != null) {
                String name_show = this.f62642g.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f62638c.f62652g.setText(name_show);
            }
            String str = this.f62642g.q1().label_name;
            if (this.i && !StringUtils.isNull(str)) {
                this.f62638c.f62648c.setText(str);
                this.f62638c.f62648c.setVisibility(0);
            } else {
                this.f62638c.f62648c.setVisibility(8);
            }
            if (cVar.i) {
                this.f62638c.i.setText(this.f62637b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f62642g.q1().distance / 1000.0d))));
                this.f62638c.i.setVisibility(0);
            } else {
                this.f62638c.i.setVisibility(8);
            }
            this.f62638c.f62652g.setOnClickListener(this.k);
            i(this.f62637b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        g().setVisibility(4);
    }

    public void i(TbPageContext<?> tbPageContext, int i) {
        if (this.f62636a != i) {
            SkinManager.setBackgroundResource(this.f62638c.f62650e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f62638c.f62649d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f62638c.f62652g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f62638c.f62653h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f62638c.i, R.color.CAM_X0109);
            this.f62636a = i;
        }
    }

    public void j(g gVar) {
        this.f62643h = gVar;
    }
}
