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
public class b implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f65761f;

    /* renamed from: g  reason: collision with root package name */
    public C1722b f65762g;

    /* renamed from: h  reason: collision with root package name */
    public View f65763h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f65764i;
    public d.a.o0.v.c j;

    /* renamed from: e  reason: collision with root package name */
    public int f65760e = 3;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f65764i == null || b.this.f65764i.T() == null || StringUtils.isNull(b.this.f65764i.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(b.this.f65764i.T().getUserId(), 0L);
            boolean z = f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.a.o0.v.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(b.this.f65761f.getPageActivity()).createNormalConfig(f2, z, b.this.f65764i.T().isBigV())));
        }
    }

    /* renamed from: d.a.o0.v.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1722b {

        /* renamed from: a  reason: collision with root package name */
        public View f65766a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f65767b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65768c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65769d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f65770e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f65771f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65772g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f65773h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f65774i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1722b(View view) {
            this.f65766a = view;
            this.f65767b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f65768c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f65769d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f65770e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f65771f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f65772g = (TextView) view.findViewById(R.id.tvUserName);
            this.f65774i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f65773h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f65773h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f65767b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65770e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f65774i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f65770e.setLayoutParams(layoutParams);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f65761f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f65763h = inflate;
        this.f65762g = new C1722b(inflate);
        c().setOnClickListener(this);
        this.f65761f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        return this.f65763h;
    }

    public void d(a2 a2Var) {
        if (a2Var == null) {
            c().setVisibility(4);
            return;
        }
        c().setVisibility(0);
        this.f65764i = a2Var;
        this.f65762g.f65767b.setDrawerType(0);
        this.f65762g.f65767b.setBorderSurroundContent(true);
        this.f65762g.f65767b.setDrawBorder(true);
        this.f65762g.f65767b.U(this.f65764i.s1().cover, 10, false);
        this.f65762g.f65769d.setText(this.f65761f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f65764i.s1().audience_count)));
        this.f65762g.f65771f.setData(this.f65764i);
        this.f65762g.f65771f.setIsRound(true);
        this.f65762g.f65771f.setBorderSurroundContent(true);
        this.f65762g.j.setText(this.f65764i.A1());
        if (this.f65764i.T() != null) {
            String name_show = this.f65764i.T().getName_show();
            if (i0.d(name_show) > 10) {
                name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.f65762g.f65772g.setText(name_show);
        }
        this.f65762g.l.setVisibility(0);
        this.f65762g.f65768c.setBackgroundResource(R.drawable.transparent_bg);
        this.f65762g.f65768c.setText(this.f65764i.s1().label_name);
        this.f65762g.f65768c.setVisibility(0);
        if (this.f65764i.T() != null && this.f65764i.T().getAlaUserData() != null && !k.isEmpty(this.f65764i.T().getAlaUserData().great_anchor_icon)) {
            this.f65762g.f65773h.setVisibility(0);
            this.f65762g.f65773h.U(this.f65764i.T().getAlaUserData().great_anchor_icon, 10, false);
        } else {
            this.f65762g.f65773h.setVisibility(8);
        }
        this.f65762g.f65772g.setOnClickListener(this.k);
        e(this.f65761f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        if (this.f65760e != i2) {
            SkinManager.setBackgroundResource(this.f65762g.f65770e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f65762g.f65768c, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f65762g.f65769d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65762g.f65772g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f65762g.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f65762g.m, R.color.CAM_X0101);
            this.f65760e = i2;
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
            l.J(this.f65761f.getPageActivity(), this.f65761f.getPageActivity().getString(R.string.no_network_guide));
            return;
        }
        a2 a2Var = this.f65764i;
        if (a2Var == null || a2Var.s1() == null) {
            return;
        }
        d.a.o0.v.c cVar = this.j;
        if (cVar != null) {
            cVar.a(this.f65764i);
        }
        d.a.o0.v.b.b().c();
        TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f65764i.s1().live_id));
    }
}
