package d.b.i0.t.e.d;

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
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.z0.i0;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f62296f;

    /* renamed from: g  reason: collision with root package name */
    public C1613b f62297g;

    /* renamed from: h  reason: collision with root package name */
    public View f62298h;
    public a2 i;
    public d.b.i0.t.c j;

    /* renamed from: e  reason: collision with root package name */
    public int f62295e = 3;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.i == null || b.this.i.T() == null || StringUtils.isNull(b.this.i.T().getUserId())) {
                return;
            }
            long f2 = d.b.c.e.m.b.f(b.this.i.T().getUserId(), 0L);
            boolean z = f2 == d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b.i0.t.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(b.this.f62296f.getPageActivity()).createNormalConfig(f2, z, b.this.i.T().isBigV())));
        }
    }

    /* renamed from: d.b.i0.t.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1613b {

        /* renamed from: a  reason: collision with root package name */
        public View f62300a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62301b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62302c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62303d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f62304e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f62305f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f62306g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f62307h;
        public RelativeLayout i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1613b(View view) {
            this.f62300a = view;
            this.f62301b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f62302c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f62303d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f62304e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f62305f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f62306g = (TextView) view.findViewById(R.id.tvUserName);
            this.i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f62307h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f62307h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f62301b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62304e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f62304e.setLayoutParams(layoutParams);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f62296f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f62298h = inflate;
        this.f62297g = new C1613b(inflate);
        c().setOnClickListener(this);
        this.f62296f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        return this.f62298h;
    }

    public void d(a2 a2Var) {
        if (a2Var == null) {
            c().setVisibility(4);
            return;
        }
        c().setVisibility(0);
        this.i = a2Var;
        this.f62297g.f62301b.setDrawerType(0);
        this.f62297g.f62301b.setBorderSurroundContent(true);
        this.f62297g.f62301b.setDrawBorder(true);
        this.f62297g.f62301b.W(this.i.q1().cover, 10, false);
        this.f62297g.f62303d.setText(this.f62296f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.i.q1().audience_count)));
        this.f62297g.f62305f.setData(this.i);
        this.f62297g.f62305f.setIsRound(true);
        this.f62297g.f62305f.setBorderSurroundContent(true);
        this.f62297g.j.setText(this.i.x1());
        if (this.i.T() != null) {
            String name_show = this.i.T().getName_show();
            if (i0.d(name_show) > 10) {
                name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.f62297g.f62306g.setText(name_show);
        }
        this.f62297g.l.setVisibility(0);
        this.f62297g.f62302c.setBackgroundResource(R.drawable.transparent_bg);
        this.f62297g.f62302c.setText(this.i.q1().label_name);
        this.f62297g.f62302c.setVisibility(0);
        if (this.i.T() != null && this.i.T().getAlaUserData() != null && !k.isEmpty(this.i.T().getAlaUserData().great_anchor_icon)) {
            this.f62297g.f62307h.setVisibility(0);
            this.f62297g.f62307h.W(this.i.T().getAlaUserData().great_anchor_icon, 10, false);
        } else {
            this.f62297g.f62307h.setVisibility(8);
        }
        this.f62297g.f62306g.setOnClickListener(this.k);
        e(this.f62296f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        if (this.f62295e != i) {
            SkinManager.setBackgroundResource(this.f62297g.f62304e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f62297g.f62302c, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f62297g.f62303d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f62297g.f62306g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f62297g.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f62297g.m, R.color.CAM_X0101);
            this.f62295e = i;
        }
    }

    public void f(String str) {
    }

    public void g(d.b.i0.t.c cVar) {
        this.j = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.z()) {
            l.I(this.f62296f.getPageActivity(), this.f62296f.getPageActivity().getString(R.string.no_network_guide));
            return;
        }
        a2 a2Var = this.i;
        if (a2Var == null || a2Var.q1() == null) {
            return;
        }
        d.b.i0.t.c cVar = this.j;
        if (cVar != null) {
            cVar.a(this.i);
        }
        d.b.i0.t.b.b().c();
        TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.i.q1().live_id));
    }
}
