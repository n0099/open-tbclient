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
import d.b.b.e.p.j;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.z0.i0;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f60719f;

    /* renamed from: g  reason: collision with root package name */
    public b f60720g;

    /* renamed from: h  reason: collision with root package name */
    public View f60721h;
    public a2 i;
    public d.b.i0.t.c j;

    /* renamed from: e  reason: collision with root package name */
    public int f60718e = 3;
    public View.OnClickListener k = new View$OnClickListenerC1559a();

    /* renamed from: d.b.i0.t.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1559a implements View.OnClickListener {
        public View$OnClickListenerC1559a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i == null || a.this.i.T() == null || StringUtils.isNull(a.this.i.T().getUserId())) {
                return;
            }
            long f2 = d.b.b.e.m.b.f(a.this.i.T().getUserId(), 0L);
            boolean z = f2 == d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b.i0.t.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.f60719f.getPageActivity()).createNormalConfig(f2, z, a.this.i.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public View f60723a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60724b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60725c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60726d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f60727e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f60728f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60729g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f60730h;
        public RelativeLayout i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public b(View view) {
            this.f60723a = view;
            this.f60724b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f60725c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f60726d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f60727e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f60728f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f60729g = (TextView) view.findViewById(R.id.tvUserName);
            this.i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f60730h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f60730h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f60724b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60727e.getLayoutParams();
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
            this.f60727e.setLayoutParams(layoutParams);
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f60719f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f60721h = inflate;
        this.f60720g = new b(inflate);
        c().setOnClickListener(this);
        this.f60719f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        return this.f60721h;
    }

    public void d(a2 a2Var) {
        if (a2Var == null) {
            c().setVisibility(4);
            return;
        }
        c().setVisibility(0);
        this.i = a2Var;
        this.f60720g.f60724b.setDrawerType(0);
        this.f60720g.f60724b.setBorderSurroundContent(true);
        this.f60720g.f60724b.setDrawBorder(true);
        this.f60720g.f60724b.W(this.i.q1().cover, 10, false);
        this.f60720g.f60726d.setText(this.f60719f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.i.q1().audience_count)));
        this.f60720g.f60728f.setData(this.i);
        this.f60720g.f60728f.setIsRound(true);
        this.f60720g.f60728f.setBorderSurroundContent(true);
        this.f60720g.j.setText(this.i.x1());
        if (this.i.T() != null) {
            String name_show = this.i.T().getName_show();
            if (i0.d(name_show) > 10) {
                name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.f60720g.f60729g.setText(name_show);
        }
        this.f60720g.l.setVisibility(0);
        this.f60720g.f60725c.setBackgroundResource(R.drawable.transparent_bg);
        this.f60720g.f60725c.setText(this.i.q1().label_name);
        this.f60720g.f60725c.setVisibility(0);
        if (this.i.T() != null && this.i.T().getAlaUserData() != null && !k.isEmpty(this.i.T().getAlaUserData().great_anchor_icon)) {
            this.f60720g.f60730h.setVisibility(0);
            this.f60720g.f60730h.W(this.i.T().getAlaUserData().great_anchor_icon, 10, false);
        } else {
            this.f60720g.f60730h.setVisibility(8);
        }
        this.f60720g.f60729g.setOnClickListener(this.k);
        e(this.f60719f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        if (this.f60718e != i) {
            SkinManager.setBackgroundResource(this.f60720g.f60727e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f60720g.f60725c, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f60720g.f60726d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60720g.f60729g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f60720g.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60720g.m, R.color.CAM_X0101);
            this.f60718e = i;
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
            l.I(this.f60719f.getPageActivity(), this.f60719f.getPageActivity().getString(R.string.no_network_guide));
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
