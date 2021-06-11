package d.a.n0.v.d.g.d;

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
import d.a.m0.r.q.a2;
import d.a.m0.z0.i0;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f65550b;

    /* renamed from: c  reason: collision with root package name */
    public c f65551c;

    /* renamed from: d  reason: collision with root package name */
    public View f65552d;

    /* renamed from: e  reason: collision with root package name */
    public int f65553e;

    /* renamed from: f  reason: collision with root package name */
    public String f65554f;

    /* renamed from: g  reason: collision with root package name */
    public a2 f65555g;

    /* renamed from: h  reason: collision with root package name */
    public f f65556h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65557i;

    /* renamed from: a  reason: collision with root package name */
    public int f65549a = 3;
    public View.OnClickListener j = new a();
    public View.OnClickListener k = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (e.this.f65555g == null || e.this.f65555g.s1() == null || e.this.f65556h == null) {
                    return;
                }
                e.this.f65556h.a(e.this.f65553e, e.this.f65554f, e.this.f65555g);
                return;
            }
            l.J(e.this.f65550b.getPageActivity(), e.this.f65550b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f65555g == null || e.this.f65555g.T() == null || StringUtils.isNull(e.this.f65555g.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(e.this.f65555g.T().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(e.this.f65550b.getPageActivity()).createNormalConfig(f2, f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.f65555g.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f65560a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f65561b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65562c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65563d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f65564e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f65565f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65566g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f65567h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f65568i;

        public c(e eVar, View view) {
            this.f65560a = view;
            this.f65561b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f65562c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f65563d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f65564e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f65565f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f65566g = (TextView) view.findViewById(R.id.tvUserName);
            this.f65567h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f65568i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f65561b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f65561b.setDrawerType(0);
            this.f65565f.setIsRound(true);
            this.f65565f.setDrawBorder(true);
            this.f65565f.setBorderColor(eVar.f65550b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f65565f.setBorderWidth(eVar.f65550b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f65565f.setIsGod(false);
            this.f65565f.setIsBigV(false);
            this.f65565f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65564e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f65564e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.f65550b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f65552d = inflate;
        this.f65551c = new c(this, inflate);
        this.f65557i = z;
    }

    public View g() {
        return this.f65552d;
    }

    public void h(d.a.n0.v.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f65130h) != null && a2Var.s1() != null) {
            g().setVisibility(0);
            this.f65555g = cVar.f65130h;
            this.f65553e = cVar.f65127e;
            this.f65554f = !TextUtils.isEmpty(cVar.f65129g) ? cVar.f65129g : cVar.f65128f;
            this.f65551c.f65561b.setDrawerType(0);
            this.f65551c.f65561b.setBorderSurroundContent(true);
            this.f65551c.f65561b.setDrawBorder(true);
            this.f65551c.f65561b.U(this.f65555g.s1().cover, 10, false);
            this.f65551c.f65563d.setText(this.f65550b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f65555g.s1().audience_count)));
            this.f65551c.f65565f.setData(this.f65555g, false);
            this.f65551c.f65567h.setText(this.f65555g.A1());
            if (this.f65555g.T() != null) {
                String name_show = this.f65555g.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f65551c.f65566g.setText(name_show);
            }
            String str = this.f65555g.s1().label_name;
            if (this.f65557i && !StringUtils.isNull(str)) {
                this.f65551c.f65562c.setText(str);
                this.f65551c.f65562c.setVisibility(0);
            } else {
                this.f65551c.f65562c.setVisibility(8);
            }
            if (cVar.f65131i) {
                this.f65551c.f65568i.setText(this.f65550b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f65555g.s1().distance / 1000.0d))));
                this.f65551c.f65568i.setVisibility(0);
            } else {
                this.f65551c.f65568i.setVisibility(8);
            }
            this.f65551c.f65566g.setOnClickListener(this.k);
            i(this.f65550b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        g().setVisibility(4);
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        if (this.f65549a != i2) {
            SkinManager.setBackgroundResource(this.f65551c.f65564e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f65551c.f65563d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65551c.f65566g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65551c.f65567h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f65551c.f65568i, R.color.CAM_X0109);
            this.f65549a = i2;
        }
    }

    public void j(f fVar) {
        this.f65556h = fVar;
    }
}
