package d.b.i0.t.d.g.d;

import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.z0.i0;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f60652b;

    /* renamed from: c  reason: collision with root package name */
    public c f60653c;

    /* renamed from: d  reason: collision with root package name */
    public View f60654d;

    /* renamed from: e  reason: collision with root package name */
    public int f60655e;

    /* renamed from: f  reason: collision with root package name */
    public String f60656f;

    /* renamed from: g  reason: collision with root package name */
    public a2 f60657g;

    /* renamed from: h  reason: collision with root package name */
    public g f60658h;
    public boolean i;

    /* renamed from: a  reason: collision with root package name */
    public int f60651a = 3;
    public View.OnClickListener j = new a();
    public View.OnClickListener k = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (e.this.f60657g == null || e.this.f60657g.q1() == null || e.this.f60658h == null) {
                    return;
                }
                e.this.f60658h.a(e.this.f60655e, e.this.f60656f, e.this.f60657g);
                return;
            }
            l.I(e.this.f60652b.getPageActivity(), e.this.f60652b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f60657g == null || e.this.f60657g.T() == null || StringUtils.isNull(e.this.f60657g.T().getUserId())) {
                return;
            }
            long f2 = d.b.b.e.m.b.f(e.this.f60657g.T().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(e.this.f60652b.getPageActivity()).createNormalConfig(f2, f2 == d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.f60657g.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f60661a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60662b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60663c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60664d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f60665e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f60666f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60667g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f60668h;
        public TextView i;

        public c(e eVar, View view) {
            this.f60661a = view;
            this.f60662b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f60663c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f60664d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f60665e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f60666f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f60667g = (TextView) view.findViewById(R.id.tvUserName);
            this.f60668h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f60662b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f60662b.setDrawerType(0);
            this.f60666f.setIsRound(true);
            this.f60666f.setDrawBorder(true);
            this.f60666f.setBorderColor(eVar.f60652b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f60666f.setBorderWidth(eVar.f60652b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f60666f.setIsGod(false);
            this.f60666f.setIsBigV(false);
            this.f60666f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60665e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f60665e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.f60652b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f60654d = inflate;
        this.f60653c = new c(this, inflate);
        this.i = z;
    }

    public View g() {
        return this.f60654d;
    }

    public void h(d.b.i0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f60242h) != null && a2Var.q1() != null) {
            g().setVisibility(0);
            this.f60657g = cVar.f60242h;
            this.f60655e = cVar.f60239e;
            this.f60656f = !TextUtils.isEmpty(cVar.f60241g) ? cVar.f60241g : cVar.f60240f;
            this.f60653c.f60662b.setDrawerType(0);
            this.f60653c.f60662b.setBorderSurroundContent(true);
            this.f60653c.f60662b.setDrawBorder(true);
            this.f60653c.f60662b.W(this.f60657g.q1().cover, 10, false);
            this.f60653c.f60664d.setText(this.f60652b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f60657g.q1().audience_count)));
            this.f60653c.f60666f.setData(this.f60657g, false);
            this.f60653c.f60668h.setText(this.f60657g.x1());
            if (this.f60657g.T() != null) {
                String name_show = this.f60657g.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f60653c.f60667g.setText(name_show);
            }
            String str = this.f60657g.q1().label_name;
            if (this.i && !StringUtils.isNull(str)) {
                this.f60653c.f60663c.setText(str);
                this.f60653c.f60663c.setVisibility(0);
            } else {
                this.f60653c.f60663c.setVisibility(8);
            }
            if (cVar.i) {
                this.f60653c.i.setText(this.f60652b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f60657g.q1().distance / 1000.0d))));
                this.f60653c.i.setVisibility(0);
            } else {
                this.f60653c.i.setVisibility(8);
            }
            this.f60653c.f60667g.setOnClickListener(this.k);
            i(this.f60652b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        g().setVisibility(4);
    }

    public void i(TbPageContext<?> tbPageContext, int i) {
        if (this.f60651a != i) {
            SkinManager.setBackgroundResource(this.f60653c.f60665e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f60653c.f60664d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60653c.f60667g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60653c.f60668h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60653c.i, R.color.CAM_X0109);
            this.f60651a = i;
        }
    }

    public void j(g gVar) {
        this.f60658h = gVar;
    }
}
