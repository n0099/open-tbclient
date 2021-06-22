package d.a.o0.v.e.d;

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
import d.a.n0.r.q.a2;
import d.a.n0.z0.i0;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f65746f;

    /* renamed from: g  reason: collision with root package name */
    public b f65747g;

    /* renamed from: h  reason: collision with root package name */
    public View f65748h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f65749i;
    public d.a.o0.v.c j;

    /* renamed from: e  reason: collision with root package name */
    public int f65745e = 3;
    public View.OnClickListener k = new View$OnClickListenerC1721a();

    /* renamed from: d.a.o0.v.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1721a implements View.OnClickListener {
        public View$OnClickListenerC1721a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f65749i == null || a.this.f65749i.T() == null || StringUtils.isNull(a.this.f65749i.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(a.this.f65749i.T().getUserId(), 0L);
            boolean z = f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.a.o0.v.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.f65746f.getPageActivity()).createNormalConfig(f2, z, a.this.f65749i.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public View f65751a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f65752b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65753c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65754d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f65755e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f65756f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65757g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f65758h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f65759i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public b(View view) {
            this.f65751a = view;
            this.f65752b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f65753c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f65754d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f65755e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f65756f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f65757g = (TextView) view.findViewById(R.id.tvUserName);
            this.f65759i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f65758h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f65758h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f65752b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65755e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f65759i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f65755e.setLayoutParams(layoutParams);
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f65746f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f65748h = inflate;
        this.f65747g = new b(inflate);
        c().setOnClickListener(this);
        this.f65746f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        return this.f65748h;
    }

    public void d(a2 a2Var) {
        if (a2Var == null) {
            c().setVisibility(4);
            return;
        }
        c().setVisibility(0);
        this.f65749i = a2Var;
        this.f65747g.f65752b.setDrawerType(0);
        this.f65747g.f65752b.setBorderSurroundContent(true);
        this.f65747g.f65752b.setDrawBorder(true);
        this.f65747g.f65752b.U(this.f65749i.s1().cover, 10, false);
        this.f65747g.f65754d.setText(this.f65746f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f65749i.s1().audience_count)));
        this.f65747g.f65756f.setData(this.f65749i);
        this.f65747g.f65756f.setIsRound(true);
        this.f65747g.f65756f.setBorderSurroundContent(true);
        this.f65747g.j.setText(this.f65749i.A1());
        if (this.f65749i.T() != null) {
            String name_show = this.f65749i.T().getName_show();
            if (i0.d(name_show) > 10) {
                name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.f65747g.f65757g.setText(name_show);
        }
        this.f65747g.l.setVisibility(0);
        this.f65747g.f65753c.setBackgroundResource(R.drawable.transparent_bg);
        this.f65747g.f65753c.setText(this.f65749i.s1().label_name);
        this.f65747g.f65753c.setVisibility(0);
        if (this.f65749i.T() != null && this.f65749i.T().getAlaUserData() != null && !k.isEmpty(this.f65749i.T().getAlaUserData().great_anchor_icon)) {
            this.f65747g.f65758h.setVisibility(0);
            this.f65747g.f65758h.U(this.f65749i.T().getAlaUserData().great_anchor_icon, 10, false);
        } else {
            this.f65747g.f65758h.setVisibility(8);
        }
        this.f65747g.f65757g.setOnClickListener(this.k);
        e(this.f65746f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        if (this.f65745e != i2) {
            SkinManager.setBackgroundResource(this.f65747g.f65755e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f65747g.f65753c, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f65747g.f65754d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65747g.f65757g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f65747g.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f65747g.m, R.color.CAM_X0101);
            this.f65745e = i2;
        }
    }

    public void f(String str) {
    }

    public void g(d.a.o0.v.c cVar) {
        this.j = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.z()) {
            l.J(this.f65746f.getPageActivity(), this.f65746f.getPageActivity().getString(R.string.no_network_guide));
            return;
        }
        a2 a2Var = this.f65749i;
        if (a2Var == null || a2Var.s1() == null) {
            return;
        }
        d.a.o0.v.c cVar = this.j;
        if (cVar != null) {
            cVar.a(this.f65749i);
        }
        d.a.o0.v.b.b().c();
        TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f65749i.s1().live_id));
    }
}
