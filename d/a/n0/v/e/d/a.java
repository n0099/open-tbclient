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
public class a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f65621f;

    /* renamed from: g  reason: collision with root package name */
    public b f65622g;

    /* renamed from: h  reason: collision with root package name */
    public View f65623h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f65624i;
    public d.a.n0.v.c j;

    /* renamed from: e  reason: collision with root package name */
    public int f65620e = 3;
    public View.OnClickListener k = new View$OnClickListenerC1717a();

    /* renamed from: d.a.n0.v.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1717a implements View.OnClickListener {
        public View$OnClickListenerC1717a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f65624i == null || a.this.f65624i.T() == null || StringUtils.isNull(a.this.f65624i.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(a.this.f65624i.T().getUserId(), 0L);
            boolean z = f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.a.n0.v.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.f65621f.getPageActivity()).createNormalConfig(f2, z, a.this.f65624i.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public View f65626a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f65627b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65628c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65629d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f65630e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f65631f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65632g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f65633h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f65634i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public b(View view) {
            this.f65626a = view;
            this.f65627b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f65628c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f65629d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f65630e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f65631f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f65632g = (TextView) view.findViewById(R.id.tvUserName);
            this.f65634i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f65633h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f65633h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f65627b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65630e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f65634i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f65630e.setLayoutParams(layoutParams);
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f65621f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f65623h = inflate;
        this.f65622g = new b(inflate);
        c().setOnClickListener(this);
        this.f65621f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        return this.f65623h;
    }

    public void d(a2 a2Var) {
        if (a2Var == null) {
            c().setVisibility(4);
            return;
        }
        c().setVisibility(0);
        this.f65624i = a2Var;
        this.f65622g.f65627b.setDrawerType(0);
        this.f65622g.f65627b.setBorderSurroundContent(true);
        this.f65622g.f65627b.setDrawBorder(true);
        this.f65622g.f65627b.U(this.f65624i.s1().cover, 10, false);
        this.f65622g.f65629d.setText(this.f65621f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f65624i.s1().audience_count)));
        this.f65622g.f65631f.setData(this.f65624i);
        this.f65622g.f65631f.setIsRound(true);
        this.f65622g.f65631f.setBorderSurroundContent(true);
        this.f65622g.j.setText(this.f65624i.A1());
        if (this.f65624i.T() != null) {
            String name_show = this.f65624i.T().getName_show();
            if (i0.d(name_show) > 10) {
                name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.f65622g.f65632g.setText(name_show);
        }
        this.f65622g.l.setVisibility(0);
        this.f65622g.f65628c.setBackgroundResource(R.drawable.transparent_bg);
        this.f65622g.f65628c.setText(this.f65624i.s1().label_name);
        this.f65622g.f65628c.setVisibility(0);
        if (this.f65624i.T() != null && this.f65624i.T().getAlaUserData() != null && !k.isEmpty(this.f65624i.T().getAlaUserData().great_anchor_icon)) {
            this.f65622g.f65633h.setVisibility(0);
            this.f65622g.f65633h.U(this.f65624i.T().getAlaUserData().great_anchor_icon, 10, false);
        } else {
            this.f65622g.f65633h.setVisibility(8);
        }
        this.f65622g.f65632g.setOnClickListener(this.k);
        e(this.f65621f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        if (this.f65620e != i2) {
            SkinManager.setBackgroundResource(this.f65622g.f65630e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f65622g.f65628c, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f65622g.f65629d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65622g.f65632g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f65622g.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f65622g.m, R.color.CAM_X0101);
            this.f65620e = i2;
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
            l.J(this.f65621f.getPageActivity(), this.f65621f.getPageActivity().getString(R.string.no_network_guide));
            return;
        }
        a2 a2Var = this.f65624i;
        if (a2Var == null || a2Var.s1() == null) {
            return;
        }
        d.a.n0.v.c cVar = this.j;
        if (cVar != null) {
            cVar.a(this.f65624i);
        }
        d.a.n0.v.b.b().c();
        TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f65624i.s1().live_id));
    }
}
