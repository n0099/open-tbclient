package d.a.n0.v.e.d;

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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.m0.z0.i0;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f61921f;

    /* renamed from: g  reason: collision with root package name */
    public C1661b f61922g;

    /* renamed from: h  reason: collision with root package name */
    public View f61923h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f61924i;
    public d.a.n0.v.c j;

    /* renamed from: e  reason: collision with root package name */
    public int f61920e = 3;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f61924i == null || b.this.f61924i.T() == null || StringUtils.isNull(b.this.f61924i.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(b.this.f61924i.T().getUserId(), 0L);
            boolean z = f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.a.n0.v.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(b.this.f61921f.getPageActivity()).createNormalConfig(f2, z, b.this.f61924i.T().isBigV())));
        }
    }

    /* renamed from: d.a.n0.v.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1661b {

        /* renamed from: a  reason: collision with root package name */
        public View f61926a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61927b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61928c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61929d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f61930e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f61931f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61932g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f61933h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f61934i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1661b(View view) {
            this.f61926a = view;
            this.f61927b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f61928c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f61929d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f61930e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f61931f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f61932g = (TextView) view.findViewById(R.id.tvUserName);
            this.f61934i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f61933h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f61933h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f61927b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61930e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f61934i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f61930e.setLayoutParams(layoutParams);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f61921f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f61923h = inflate;
        this.f61922g = new C1661b(inflate);
        c().setOnClickListener(this);
        this.f61921f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        return this.f61923h;
    }

    public void d(a2 a2Var) {
        if (a2Var == null) {
            c().setVisibility(4);
            return;
        }
        c().setVisibility(0);
        this.f61924i = a2Var;
        this.f61922g.f61927b.setDrawerType(0);
        this.f61922g.f61927b.setBorderSurroundContent(true);
        this.f61922g.f61927b.setDrawBorder(true);
        this.f61922g.f61927b.V(this.f61924i.r1().cover, 10, false);
        this.f61922g.f61929d.setText(this.f61921f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f61924i.r1().audience_count)));
        this.f61922g.f61931f.setData(this.f61924i);
        this.f61922g.f61931f.setIsRound(true);
        this.f61922g.f61931f.setBorderSurroundContent(true);
        this.f61922g.j.setText(this.f61924i.z1());
        if (this.f61924i.T() != null) {
            String name_show = this.f61924i.T().getName_show();
            if (i0.d(name_show) > 10) {
                name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.f61922g.f61932g.setText(name_show);
        }
        this.f61922g.l.setVisibility(0);
        this.f61922g.f61928c.setBackgroundResource(R.drawable.transparent_bg);
        this.f61922g.f61928c.setText(this.f61924i.r1().label_name);
        this.f61922g.f61928c.setVisibility(0);
        if (this.f61924i.T() != null && this.f61924i.T().getAlaUserData() != null && !k.isEmpty(this.f61924i.T().getAlaUserData().great_anchor_icon)) {
            this.f61922g.f61933h.setVisibility(0);
            this.f61922g.f61933h.V(this.f61924i.T().getAlaUserData().great_anchor_icon, 10, false);
        } else {
            this.f61922g.f61933h.setVisibility(8);
        }
        this.f61922g.f61932g.setOnClickListener(this.k);
        e(this.f61921f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        if (this.f61920e != i2) {
            SkinManager.setBackgroundResource(this.f61922g.f61930e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f61922g.f61928c, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f61922g.f61929d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61922g.f61932g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f61922g.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f61922g.m, R.color.CAM_X0101);
            this.f61920e = i2;
        }
    }

    public void f(String str) {
    }

    public void g(d.a.n0.v.c cVar) {
        this.j = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.z()) {
            l.J(this.f61921f.getPageActivity(), this.f61921f.getPageActivity().getString(R.string.no_network_guide));
            return;
        }
        a2 a2Var = this.f61924i;
        if (a2Var == null || a2Var.r1() == null) {
            return;
        }
        d.a.n0.v.c cVar = this.j;
        if (cVar != null) {
            cVar.a(this.f61924i);
        }
        d.a.n0.v.b.b().c();
        TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f61924i.r1().live_id));
    }
}
