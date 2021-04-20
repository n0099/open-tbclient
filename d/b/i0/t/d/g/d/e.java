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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.z0.i0;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f62216b;

    /* renamed from: c  reason: collision with root package name */
    public c f62217c;

    /* renamed from: d  reason: collision with root package name */
    public View f62218d;

    /* renamed from: e  reason: collision with root package name */
    public int f62219e;

    /* renamed from: f  reason: collision with root package name */
    public String f62220f;

    /* renamed from: g  reason: collision with root package name */
    public a2 f62221g;

    /* renamed from: h  reason: collision with root package name */
    public g f62222h;
    public boolean i;

    /* renamed from: a  reason: collision with root package name */
    public int f62215a = 3;
    public View.OnClickListener j = new a();
    public View.OnClickListener k = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (e.this.f62221g == null || e.this.f62221g.q1() == null || e.this.f62222h == null) {
                    return;
                }
                e.this.f62222h.a(e.this.f62219e, e.this.f62220f, e.this.f62221g);
                return;
            }
            l.I(e.this.f62216b.getPageActivity(), e.this.f62216b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f62221g == null || e.this.f62221g.T() == null || StringUtils.isNull(e.this.f62221g.T().getUserId())) {
                return;
            }
            long f2 = d.b.c.e.m.b.f(e.this.f62221g.T().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(e.this.f62216b.getPageActivity()).createNormalConfig(f2, f2 == d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.f62221g.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f62225a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62226b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62227c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62228d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f62229e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f62230f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f62231g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f62232h;
        public TextView i;

        public c(e eVar, View view) {
            this.f62225a = view;
            this.f62226b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f62227c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f62228d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f62229e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f62230f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f62231g = (TextView) view.findViewById(R.id.tvUserName);
            this.f62232h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f62226b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f62226b.setDrawerType(0);
            this.f62230f.setIsRound(true);
            this.f62230f.setDrawBorder(true);
            this.f62230f.setBorderColor(eVar.f62216b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f62230f.setBorderWidth(eVar.f62216b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f62230f.setIsGod(false);
            this.f62230f.setIsBigV(false);
            this.f62230f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62229e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f62229e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.f62216b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f62218d = inflate;
        this.f62217c = new c(this, inflate);
        this.i = z;
    }

    public View g() {
        return this.f62218d;
    }

    public void h(d.b.i0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f61806h) != null && a2Var.q1() != null) {
            g().setVisibility(0);
            this.f62221g = cVar.f61806h;
            this.f62219e = cVar.f61803e;
            this.f62220f = !TextUtils.isEmpty(cVar.f61805g) ? cVar.f61805g : cVar.f61804f;
            this.f62217c.f62226b.setDrawerType(0);
            this.f62217c.f62226b.setBorderSurroundContent(true);
            this.f62217c.f62226b.setDrawBorder(true);
            this.f62217c.f62226b.W(this.f62221g.q1().cover, 10, false);
            this.f62217c.f62228d.setText(this.f62216b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f62221g.q1().audience_count)));
            this.f62217c.f62230f.setData(this.f62221g, false);
            this.f62217c.f62232h.setText(this.f62221g.x1());
            if (this.f62221g.T() != null) {
                String name_show = this.f62221g.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f62217c.f62231g.setText(name_show);
            }
            String str = this.f62221g.q1().label_name;
            if (this.i && !StringUtils.isNull(str)) {
                this.f62217c.f62227c.setText(str);
                this.f62217c.f62227c.setVisibility(0);
            } else {
                this.f62217c.f62227c.setVisibility(8);
            }
            if (cVar.i) {
                this.f62217c.i.setText(this.f62216b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f62221g.q1().distance / 1000.0d))));
                this.f62217c.i.setVisibility(0);
            } else {
                this.f62217c.i.setVisibility(8);
            }
            this.f62217c.f62231g.setOnClickListener(this.k);
            i(this.f62216b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        g().setVisibility(4);
    }

    public void i(TbPageContext<?> tbPageContext, int i) {
        if (this.f62215a != i) {
            SkinManager.setBackgroundResource(this.f62217c.f62229e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f62217c.f62228d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f62217c.f62231g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f62217c.f62232h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f62217c.i, R.color.CAM_X0109);
            this.f62215a = i;
        }
    }

    public void j(g gVar) {
        this.f62222h = gVar;
    }
}
