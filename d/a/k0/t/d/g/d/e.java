package d.a.k0.t.d.g.d;

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
import d.a.j0.r.q.a2;
import d.a.j0.z0.i0;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f61547b;

    /* renamed from: c  reason: collision with root package name */
    public c f61548c;

    /* renamed from: d  reason: collision with root package name */
    public View f61549d;

    /* renamed from: e  reason: collision with root package name */
    public int f61550e;

    /* renamed from: f  reason: collision with root package name */
    public String f61551f;

    /* renamed from: g  reason: collision with root package name */
    public a2 f61552g;

    /* renamed from: h  reason: collision with root package name */
    public f f61553h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61554i;

    /* renamed from: a  reason: collision with root package name */
    public int f61546a = 3;
    public View.OnClickListener j = new a();
    public View.OnClickListener k = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (e.this.f61552g == null || e.this.f61552g.q1() == null || e.this.f61553h == null) {
                    return;
                }
                e.this.f61553h.a(e.this.f61550e, e.this.f61551f, e.this.f61552g);
                return;
            }
            l.J(e.this.f61547b.getPageActivity(), e.this.f61547b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f61552g == null || e.this.f61552g.T() == null || StringUtils.isNull(e.this.f61552g.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(e.this.f61552g.T().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(e.this.f61547b.getPageActivity()).createNormalConfig(f2, f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.f61552g.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f61557a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61558b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61559c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61560d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f61561e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f61562f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61563g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f61564h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f61565i;

        public c(e eVar, View view) {
            this.f61557a = view;
            this.f61558b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f61559c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f61560d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f61561e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f61562f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f61563g = (TextView) view.findViewById(R.id.tvUserName);
            this.f61564h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f61565i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f61558b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f61558b.setDrawerType(0);
            this.f61562f.setIsRound(true);
            this.f61562f.setDrawBorder(true);
            this.f61562f.setBorderColor(eVar.f61547b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f61562f.setBorderWidth(eVar.f61547b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f61562f.setIsGod(false);
            this.f61562f.setIsBigV(false);
            this.f61562f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61561e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f61561e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.f61547b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f61549d = inflate;
        this.f61548c = new c(this, inflate);
        this.f61554i = z;
    }

    public View g() {
        return this.f61549d;
    }

    public void h(d.a.k0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f61129h) != null && a2Var.q1() != null) {
            g().setVisibility(0);
            this.f61552g = cVar.f61129h;
            this.f61550e = cVar.f61126e;
            this.f61551f = !TextUtils.isEmpty(cVar.f61128g) ? cVar.f61128g : cVar.f61127f;
            this.f61548c.f61558b.setDrawerType(0);
            this.f61548c.f61558b.setBorderSurroundContent(true);
            this.f61548c.f61558b.setDrawBorder(true);
            this.f61548c.f61558b.V(this.f61552g.q1().cover, 10, false);
            this.f61548c.f61560d.setText(this.f61547b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f61552g.q1().audience_count)));
            this.f61548c.f61562f.setData(this.f61552g, false);
            this.f61548c.f61564h.setText(this.f61552g.y1());
            if (this.f61552g.T() != null) {
                String name_show = this.f61552g.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f61548c.f61563g.setText(name_show);
            }
            String str = this.f61552g.q1().label_name;
            if (this.f61554i && !StringUtils.isNull(str)) {
                this.f61548c.f61559c.setText(str);
                this.f61548c.f61559c.setVisibility(0);
            } else {
                this.f61548c.f61559c.setVisibility(8);
            }
            if (cVar.f61130i) {
                this.f61548c.f61565i.setText(this.f61547b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f61552g.q1().distance / 1000.0d))));
                this.f61548c.f61565i.setVisibility(0);
            } else {
                this.f61548c.f61565i.setVisibility(8);
            }
            this.f61548c.f61563g.setOnClickListener(this.k);
            i(this.f61547b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        g().setVisibility(4);
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        if (this.f61546a != i2) {
            SkinManager.setBackgroundResource(this.f61548c.f61561e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f61548c.f61560d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61548c.f61563g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61548c.f61564h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f61548c.f61565i, R.color.CAM_X0109);
            this.f61546a = i2;
        }
    }

    public void j(f fVar) {
        this.f61553h = fVar;
    }
}
