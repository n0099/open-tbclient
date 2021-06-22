package d.a.o0.v.d.g.d;

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
import d.a.n0.r.q.a2;
import d.a.n0.z0.i0;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f65675b;

    /* renamed from: c  reason: collision with root package name */
    public c f65676c;

    /* renamed from: d  reason: collision with root package name */
    public View f65677d;

    /* renamed from: e  reason: collision with root package name */
    public int f65678e;

    /* renamed from: f  reason: collision with root package name */
    public String f65679f;

    /* renamed from: g  reason: collision with root package name */
    public a2 f65680g;

    /* renamed from: h  reason: collision with root package name */
    public f f65681h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65682i;

    /* renamed from: a  reason: collision with root package name */
    public int f65674a = 3;
    public View.OnClickListener j = new a();
    public View.OnClickListener k = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (e.this.f65680g == null || e.this.f65680g.s1() == null || e.this.f65681h == null) {
                    return;
                }
                e.this.f65681h.a(e.this.f65678e, e.this.f65679f, e.this.f65680g);
                return;
            }
            l.J(e.this.f65675b.getPageActivity(), e.this.f65675b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f65680g == null || e.this.f65680g.T() == null || StringUtils.isNull(e.this.f65680g.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(e.this.f65680g.T().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(e.this.f65675b.getPageActivity()).createNormalConfig(f2, f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.f65680g.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f65685a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f65686b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65687c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65688d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f65689e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f65690f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65691g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f65692h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f65693i;

        public c(e eVar, View view) {
            this.f65685a = view;
            this.f65686b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f65687c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f65688d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f65689e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f65690f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f65691g = (TextView) view.findViewById(R.id.tvUserName);
            this.f65692h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f65693i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f65686b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f65686b.setDrawerType(0);
            this.f65690f.setIsRound(true);
            this.f65690f.setDrawBorder(true);
            this.f65690f.setBorderColor(eVar.f65675b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f65690f.setBorderWidth(eVar.f65675b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f65690f.setIsGod(false);
            this.f65690f.setIsBigV(false);
            this.f65690f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65689e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f65689e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.f65675b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f65677d = inflate;
        this.f65676c = new c(this, inflate);
        this.f65682i = z;
    }

    public View g() {
        return this.f65677d;
    }

    public void h(d.a.o0.v.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f65255h) != null && a2Var.s1() != null) {
            g().setVisibility(0);
            this.f65680g = cVar.f65255h;
            this.f65678e = cVar.f65252e;
            this.f65679f = !TextUtils.isEmpty(cVar.f65254g) ? cVar.f65254g : cVar.f65253f;
            this.f65676c.f65686b.setDrawerType(0);
            this.f65676c.f65686b.setBorderSurroundContent(true);
            this.f65676c.f65686b.setDrawBorder(true);
            this.f65676c.f65686b.U(this.f65680g.s1().cover, 10, false);
            this.f65676c.f65688d.setText(this.f65675b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f65680g.s1().audience_count)));
            this.f65676c.f65690f.setData(this.f65680g, false);
            this.f65676c.f65692h.setText(this.f65680g.A1());
            if (this.f65680g.T() != null) {
                String name_show = this.f65680g.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f65676c.f65691g.setText(name_show);
            }
            String str = this.f65680g.s1().label_name;
            if (this.f65682i && !StringUtils.isNull(str)) {
                this.f65676c.f65687c.setText(str);
                this.f65676c.f65687c.setVisibility(0);
            } else {
                this.f65676c.f65687c.setVisibility(8);
            }
            if (cVar.f65256i) {
                this.f65676c.f65693i.setText(this.f65675b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f65680g.s1().distance / 1000.0d))));
                this.f65676c.f65693i.setVisibility(0);
            } else {
                this.f65676c.f65693i.setVisibility(8);
            }
            this.f65676c.f65691g.setOnClickListener(this.k);
            i(this.f65675b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        g().setVisibility(4);
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        if (this.f65674a != i2) {
            SkinManager.setBackgroundResource(this.f65676c.f65689e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f65676c.f65688d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65676c.f65691g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65676c.f65692h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f65676c.f65693i, R.color.CAM_X0109);
            this.f65674a = i2;
        }
    }

    public void j(f fVar) {
        this.f65681h = fVar;
    }
}
