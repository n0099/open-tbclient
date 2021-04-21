package d.b.j0.t.e.d;

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
import d.b.i0.r.q.a2;
import d.b.i0.z0.i0;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f62704f;

    /* renamed from: g  reason: collision with root package name */
    public b f62705g;

    /* renamed from: h  reason: collision with root package name */
    public View f62706h;
    public a2 i;
    public d.b.j0.t.c j;

    /* renamed from: e  reason: collision with root package name */
    public int f62703e = 3;
    public View.OnClickListener k = new View$OnClickListenerC1635a();

    /* renamed from: d.b.j0.t.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1635a implements View.OnClickListener {
        public View$OnClickListenerC1635a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i == null || a.this.i.T() == null || StringUtils.isNull(a.this.i.T().getUserId())) {
                return;
            }
            long f2 = d.b.c.e.m.b.f(a.this.i.T().getUserId(), 0L);
            boolean z = f2 == d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b.j0.t.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.f62704f.getPageActivity()).createNormalConfig(f2, z, a.this.i.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public View f62708a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62709b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62710c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62711d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f62712e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f62713f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f62714g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f62715h;
        public RelativeLayout i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public b(View view) {
            this.f62708a = view;
            this.f62709b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f62710c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f62711d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f62712e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f62713f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f62714g = (TextView) view.findViewById(R.id.tvUserName);
            this.i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f62715h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f62715h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f62709b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62712e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f62712e.setLayoutParams(layoutParams);
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f62704f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f62706h = inflate;
        this.f62705g = new b(inflate);
        c().setOnClickListener(this);
        this.f62704f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        return this.f62706h;
    }

    public void d(a2 a2Var) {
        if (a2Var == null) {
            c().setVisibility(4);
            return;
        }
        c().setVisibility(0);
        this.i = a2Var;
        this.f62705g.f62709b.setDrawerType(0);
        this.f62705g.f62709b.setBorderSurroundContent(true);
        this.f62705g.f62709b.setDrawBorder(true);
        this.f62705g.f62709b.W(this.i.q1().cover, 10, false);
        this.f62705g.f62711d.setText(this.f62704f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.i.q1().audience_count)));
        this.f62705g.f62713f.setData(this.i);
        this.f62705g.f62713f.setIsRound(true);
        this.f62705g.f62713f.setBorderSurroundContent(true);
        this.f62705g.j.setText(this.i.x1());
        if (this.i.T() != null) {
            String name_show = this.i.T().getName_show();
            if (i0.d(name_show) > 10) {
                name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.f62705g.f62714g.setText(name_show);
        }
        this.f62705g.l.setVisibility(0);
        this.f62705g.f62710c.setBackgroundResource(R.drawable.transparent_bg);
        this.f62705g.f62710c.setText(this.i.q1().label_name);
        this.f62705g.f62710c.setVisibility(0);
        if (this.i.T() != null && this.i.T().getAlaUserData() != null && !k.isEmpty(this.i.T().getAlaUserData().great_anchor_icon)) {
            this.f62705g.f62715h.setVisibility(0);
            this.f62705g.f62715h.W(this.i.T().getAlaUserData().great_anchor_icon, 10, false);
        } else {
            this.f62705g.f62715h.setVisibility(8);
        }
        this.f62705g.f62714g.setOnClickListener(this.k);
        e(this.f62704f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        if (this.f62703e != i) {
            SkinManager.setBackgroundResource(this.f62705g.f62712e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f62705g.f62710c, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f62705g.f62711d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f62705g.f62714g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f62705g.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f62705g.m, R.color.CAM_X0101);
            this.f62703e = i;
        }
    }

    public void f(String str) {
    }

    public void g(d.b.j0.t.c cVar) {
        this.j = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.z()) {
            l.I(this.f62704f.getPageActivity(), this.f62704f.getPageActivity().getString(R.string.no_network_guide));
            return;
        }
        a2 a2Var = this.i;
        if (a2Var == null || a2Var.q1() == null) {
            return;
        }
        d.b.j0.t.c cVar = this.j;
        if (cVar != null) {
            cVar.a(this.i);
        }
        d.b.j0.t.b.b().c();
        TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.i.q1().live_id));
    }
}
