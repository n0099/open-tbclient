package d.a.k0.t.e.d;

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
import d.a.j0.r.q.a2;
import d.a.j0.z0.i0;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f61633f;

    /* renamed from: g  reason: collision with root package name */
    public C1641b f61634g;

    /* renamed from: h  reason: collision with root package name */
    public View f61635h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f61636i;
    public d.a.k0.t.c j;

    /* renamed from: e  reason: collision with root package name */
    public int f61632e = 3;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f61636i == null || b.this.f61636i.T() == null || StringUtils.isNull(b.this.f61636i.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(b.this.f61636i.T().getUserId(), 0L);
            boolean z = f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.a.k0.t.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(b.this.f61633f.getPageActivity()).createNormalConfig(f2, z, b.this.f61636i.T().isBigV())));
        }
    }

    /* renamed from: d.a.k0.t.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1641b {

        /* renamed from: a  reason: collision with root package name */
        public View f61638a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61639b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61640c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61641d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f61642e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f61643f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61644g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f61645h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f61646i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1641b(View view) {
            this.f61638a = view;
            this.f61639b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f61640c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f61641d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f61642e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f61643f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f61644g = (TextView) view.findViewById(R.id.tvUserName);
            this.f61646i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f61645h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f61645h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f61639b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61642e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f61646i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f61642e.setLayoutParams(layoutParams);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f61633f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f61635h = inflate;
        this.f61634g = new C1641b(inflate);
        c().setOnClickListener(this);
        this.f61633f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        return this.f61635h;
    }

    public void d(a2 a2Var) {
        if (a2Var == null) {
            c().setVisibility(4);
            return;
        }
        c().setVisibility(0);
        this.f61636i = a2Var;
        this.f61634g.f61639b.setDrawerType(0);
        this.f61634g.f61639b.setBorderSurroundContent(true);
        this.f61634g.f61639b.setDrawBorder(true);
        this.f61634g.f61639b.V(this.f61636i.q1().cover, 10, false);
        this.f61634g.f61641d.setText(this.f61633f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f61636i.q1().audience_count)));
        this.f61634g.f61643f.setData(this.f61636i);
        this.f61634g.f61643f.setIsRound(true);
        this.f61634g.f61643f.setBorderSurroundContent(true);
        this.f61634g.j.setText(this.f61636i.y1());
        if (this.f61636i.T() != null) {
            String name_show = this.f61636i.T().getName_show();
            if (i0.d(name_show) > 10) {
                name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.f61634g.f61644g.setText(name_show);
        }
        this.f61634g.l.setVisibility(0);
        this.f61634g.f61640c.setBackgroundResource(R.drawable.transparent_bg);
        this.f61634g.f61640c.setText(this.f61636i.q1().label_name);
        this.f61634g.f61640c.setVisibility(0);
        if (this.f61636i.T() != null && this.f61636i.T().getAlaUserData() != null && !k.isEmpty(this.f61636i.T().getAlaUserData().great_anchor_icon)) {
            this.f61634g.f61645h.setVisibility(0);
            this.f61634g.f61645h.V(this.f61636i.T().getAlaUserData().great_anchor_icon, 10, false);
        } else {
            this.f61634g.f61645h.setVisibility(8);
        }
        this.f61634g.f61644g.setOnClickListener(this.k);
        e(this.f61633f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        if (this.f61632e != i2) {
            SkinManager.setBackgroundResource(this.f61634g.f61642e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f61634g.f61640c, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f61634g.f61641d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61634g.f61644g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f61634g.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f61634g.m, R.color.CAM_X0101);
            this.f61632e = i2;
        }
    }

    public void f(String str) {
    }

    public void g(d.a.k0.t.c cVar) {
        this.j = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.z()) {
            l.J(this.f61633f.getPageActivity(), this.f61633f.getPageActivity().getString(R.string.no_network_guide));
            return;
        }
        a2 a2Var = this.f61636i;
        if (a2Var == null || a2Var.q1() == null) {
            return;
        }
        d.a.k0.t.c cVar = this.j;
        if (cVar != null) {
            cVar.a(this.f61636i);
        }
        d.a.k0.t.b.b().c();
        TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f61636i.q1().live_id));
    }
}
