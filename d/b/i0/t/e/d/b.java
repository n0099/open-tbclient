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
public class b implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f60731f;

    /* renamed from: g  reason: collision with root package name */
    public C1559b f60732g;

    /* renamed from: h  reason: collision with root package name */
    public View f60733h;
    public a2 i;
    public d.b.i0.t.c j;

    /* renamed from: e  reason: collision with root package name */
    public int f60730e = 3;
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
            long f2 = d.b.b.e.m.b.f(b.this.i.T().getUserId(), 0L);
            boolean z = f2 == d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b.i0.t.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(b.this.f60731f.getPageActivity()).createNormalConfig(f2, z, b.this.i.T().isBigV())));
        }
    }

    /* renamed from: d.b.i0.t.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1559b {

        /* renamed from: a  reason: collision with root package name */
        public View f60735a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60736b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60737c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60738d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f60739e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f60740f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60741g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f60742h;
        public RelativeLayout i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1559b(View view) {
            this.f60735a = view;
            this.f60736b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f60737c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f60738d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f60739e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f60740f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f60741g = (TextView) view.findViewById(R.id.tvUserName);
            this.i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f60742h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f60742h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f60736b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60739e.getLayoutParams();
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
            this.f60739e.setLayoutParams(layoutParams);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f60731f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f60733h = inflate;
        this.f60732g = new C1559b(inflate);
        c().setOnClickListener(this);
        this.f60731f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        return this.f60733h;
    }

    public void d(a2 a2Var) {
        if (a2Var == null) {
            c().setVisibility(4);
            return;
        }
        c().setVisibility(0);
        this.i = a2Var;
        this.f60732g.f60736b.setDrawerType(0);
        this.f60732g.f60736b.setBorderSurroundContent(true);
        this.f60732g.f60736b.setDrawBorder(true);
        this.f60732g.f60736b.W(this.i.q1().cover, 10, false);
        this.f60732g.f60738d.setText(this.f60731f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.i.q1().audience_count)));
        this.f60732g.f60740f.setData(this.i);
        this.f60732g.f60740f.setIsRound(true);
        this.f60732g.f60740f.setBorderSurroundContent(true);
        this.f60732g.j.setText(this.i.x1());
        if (this.i.T() != null) {
            String name_show = this.i.T().getName_show();
            if (i0.d(name_show) > 10) {
                name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.f60732g.f60741g.setText(name_show);
        }
        this.f60732g.l.setVisibility(0);
        this.f60732g.f60737c.setBackgroundResource(R.drawable.transparent_bg);
        this.f60732g.f60737c.setText(this.i.q1().label_name);
        this.f60732g.f60737c.setVisibility(0);
        if (this.i.T() != null && this.i.T().getAlaUserData() != null && !k.isEmpty(this.i.T().getAlaUserData().great_anchor_icon)) {
            this.f60732g.f60742h.setVisibility(0);
            this.f60732g.f60742h.W(this.i.T().getAlaUserData().great_anchor_icon, 10, false);
        } else {
            this.f60732g.f60742h.setVisibility(8);
        }
        this.f60732g.f60741g.setOnClickListener(this.k);
        e(this.f60731f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        if (this.f60730e != i) {
            SkinManager.setBackgroundResource(this.f60732g.f60739e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f60732g.f60737c, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f60732g.f60738d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60732g.f60741g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f60732g.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60732g.m, R.color.CAM_X0101);
            this.f60730e = i;
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
            l.I(this.f60731f.getPageActivity(), this.f60731f.getPageActivity().getString(R.string.no_network_guide));
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
