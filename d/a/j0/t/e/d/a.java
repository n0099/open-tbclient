package d.a.j0.t.e.d;

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
import d.a.i0.r.q.a2;
import d.a.i0.z0.i0;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f60894f;

    /* renamed from: g  reason: collision with root package name */
    public b f60895g;

    /* renamed from: h  reason: collision with root package name */
    public View f60896h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f60897i;
    public d.a.j0.t.c j;

    /* renamed from: e  reason: collision with root package name */
    public int f60893e = 3;
    public View.OnClickListener k = new View$OnClickListenerC1575a();

    /* renamed from: d.a.j0.t.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1575a implements View.OnClickListener {
        public View$OnClickListenerC1575a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f60897i == null || a.this.f60897i.T() == null || StringUtils.isNull(a.this.f60897i.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(a.this.f60897i.T().getUserId(), 0L);
            boolean z = f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.a.j0.t.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.f60894f.getPageActivity()).createNormalConfig(f2, z, a.this.f60897i.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public View f60899a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60900b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60901c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60902d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f60903e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f60904f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60905g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f60906h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f60907i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public b(View view) {
            this.f60899a = view;
            this.f60900b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f60901c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f60902d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f60903e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f60904f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f60905g = (TextView) view.findViewById(R.id.tvUserName);
            this.f60907i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f60906h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f60906h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f60900b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60903e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f60907i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f60903e.setLayoutParams(layoutParams);
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f60894f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f60896h = inflate;
        this.f60895g = new b(inflate);
        c().setOnClickListener(this);
        this.f60894f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        return this.f60896h;
    }

    public void d(a2 a2Var) {
        if (a2Var == null) {
            c().setVisibility(4);
            return;
        }
        c().setVisibility(0);
        this.f60897i = a2Var;
        this.f60895g.f60900b.setDrawerType(0);
        this.f60895g.f60900b.setBorderSurroundContent(true);
        this.f60895g.f60900b.setDrawBorder(true);
        this.f60895g.f60900b.V(this.f60897i.q1().cover, 10, false);
        this.f60895g.f60902d.setText(this.f60894f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f60897i.q1().audience_count)));
        this.f60895g.f60904f.setData(this.f60897i);
        this.f60895g.f60904f.setIsRound(true);
        this.f60895g.f60904f.setBorderSurroundContent(true);
        this.f60895g.j.setText(this.f60897i.x1());
        if (this.f60897i.T() != null) {
            String name_show = this.f60897i.T().getName_show();
            if (i0.d(name_show) > 10) {
                name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.f60895g.f60905g.setText(name_show);
        }
        this.f60895g.l.setVisibility(0);
        this.f60895g.f60901c.setBackgroundResource(R.drawable.transparent_bg);
        this.f60895g.f60901c.setText(this.f60897i.q1().label_name);
        this.f60895g.f60901c.setVisibility(0);
        if (this.f60897i.T() != null && this.f60897i.T().getAlaUserData() != null && !k.isEmpty(this.f60897i.T().getAlaUserData().great_anchor_icon)) {
            this.f60895g.f60906h.setVisibility(0);
            this.f60895g.f60906h.V(this.f60897i.T().getAlaUserData().great_anchor_icon, 10, false);
        } else {
            this.f60895g.f60906h.setVisibility(8);
        }
        this.f60895g.f60905g.setOnClickListener(this.k);
        e(this.f60894f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        if (this.f60893e != i2) {
            SkinManager.setBackgroundResource(this.f60895g.f60903e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f60895g.f60901c, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f60895g.f60902d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60895g.f60905g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f60895g.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60895g.m, R.color.CAM_X0101);
            this.f60893e = i2;
        }
    }

    public void f(String str) {
    }

    public void g(d.a.j0.t.c cVar) {
        this.j = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.z()) {
            l.J(this.f60894f.getPageActivity(), this.f60894f.getPageActivity().getString(R.string.no_network_guide));
            return;
        }
        a2 a2Var = this.f60897i;
        if (a2Var == null || a2Var.q1() == null) {
            return;
        }
        d.a.j0.t.c cVar = this.j;
        if (cVar != null) {
            cVar.a(this.f60897i);
        }
        d.a.j0.t.b.b().c();
        TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f60897i.q1().live_id));
    }
}
