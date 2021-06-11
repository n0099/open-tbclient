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
    public TbPageContext<?> f65636f;

    /* renamed from: g  reason: collision with root package name */
    public C1718b f65637g;

    /* renamed from: h  reason: collision with root package name */
    public View f65638h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f65639i;
    public d.a.n0.v.c j;

    /* renamed from: e  reason: collision with root package name */
    public int f65635e = 3;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f65639i == null || b.this.f65639i.T() == null || StringUtils.isNull(b.this.f65639i.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(b.this.f65639i.T().getUserId(), 0L);
            boolean z = f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.a.n0.v.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(b.this.f65636f.getPageActivity()).createNormalConfig(f2, z, b.this.f65639i.T().isBigV())));
        }
    }

    /* renamed from: d.a.n0.v.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1718b {

        /* renamed from: a  reason: collision with root package name */
        public View f65641a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f65642b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65643c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65644d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f65645e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f65646f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65647g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f65648h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f65649i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1718b(View view) {
            this.f65641a = view;
            this.f65642b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f65643c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f65644d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f65645e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f65646f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f65647g = (TextView) view.findViewById(R.id.tvUserName);
            this.f65649i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f65648h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f65648h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f65642b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65645e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f65649i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f65645e.setLayoutParams(layoutParams);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f65636f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f65638h = inflate;
        this.f65637g = new C1718b(inflate);
        c().setOnClickListener(this);
        this.f65636f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        return this.f65638h;
    }

    public void d(a2 a2Var) {
        if (a2Var == null) {
            c().setVisibility(4);
            return;
        }
        c().setVisibility(0);
        this.f65639i = a2Var;
        this.f65637g.f65642b.setDrawerType(0);
        this.f65637g.f65642b.setBorderSurroundContent(true);
        this.f65637g.f65642b.setDrawBorder(true);
        this.f65637g.f65642b.U(this.f65639i.s1().cover, 10, false);
        this.f65637g.f65644d.setText(this.f65636f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f65639i.s1().audience_count)));
        this.f65637g.f65646f.setData(this.f65639i);
        this.f65637g.f65646f.setIsRound(true);
        this.f65637g.f65646f.setBorderSurroundContent(true);
        this.f65637g.j.setText(this.f65639i.A1());
        if (this.f65639i.T() != null) {
            String name_show = this.f65639i.T().getName_show();
            if (i0.d(name_show) > 10) {
                name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.f65637g.f65647g.setText(name_show);
        }
        this.f65637g.l.setVisibility(0);
        this.f65637g.f65643c.setBackgroundResource(R.drawable.transparent_bg);
        this.f65637g.f65643c.setText(this.f65639i.s1().label_name);
        this.f65637g.f65643c.setVisibility(0);
        if (this.f65639i.T() != null && this.f65639i.T().getAlaUserData() != null && !k.isEmpty(this.f65639i.T().getAlaUserData().great_anchor_icon)) {
            this.f65637g.f65648h.setVisibility(0);
            this.f65637g.f65648h.U(this.f65639i.T().getAlaUserData().great_anchor_icon, 10, false);
        } else {
            this.f65637g.f65648h.setVisibility(8);
        }
        this.f65637g.f65647g.setOnClickListener(this.k);
        e(this.f65636f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        if (this.f65635e != i2) {
            SkinManager.setBackgroundResource(this.f65637g.f65645e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f65637g.f65643c, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f65637g.f65644d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65637g.f65647g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f65637g.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f65637g.m, R.color.CAM_X0101);
            this.f65635e = i2;
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
            l.J(this.f65636f.getPageActivity(), this.f65636f.getPageActivity().getString(R.string.no_network_guide));
            return;
        }
        a2 a2Var = this.f65639i;
        if (a2Var == null || a2Var.s1() == null) {
            return;
        }
        d.a.n0.v.c cVar = this.j;
        if (cVar != null) {
            cVar.a(this.f65639i);
        }
        d.a.n0.v.b.b().c();
        TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f65639i.s1().live_id));
    }
}
