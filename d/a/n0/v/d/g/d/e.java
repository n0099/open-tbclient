package d.a.n0.v.d.g.d;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.m0.z0.i0;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f61835b;

    /* renamed from: c  reason: collision with root package name */
    public c f61836c;

    /* renamed from: d  reason: collision with root package name */
    public View f61837d;

    /* renamed from: e  reason: collision with root package name */
    public int f61838e;

    /* renamed from: f  reason: collision with root package name */
    public String f61839f;

    /* renamed from: g  reason: collision with root package name */
    public a2 f61840g;

    /* renamed from: h  reason: collision with root package name */
    public f f61841h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61842i;

    /* renamed from: a  reason: collision with root package name */
    public int f61834a = 3;
    public View.OnClickListener j = new a();
    public View.OnClickListener k = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (e.this.f61840g == null || e.this.f61840g.r1() == null || e.this.f61841h == null) {
                    return;
                }
                e.this.f61841h.a(e.this.f61838e, e.this.f61839f, e.this.f61840g);
                return;
            }
            l.J(e.this.f61835b.getPageActivity(), e.this.f61835b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f61840g == null || e.this.f61840g.T() == null || StringUtils.isNull(e.this.f61840g.T().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(e.this.f61840g.T().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(e.this.f61835b.getPageActivity()).createNormalConfig(f2, f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.f61840g.T().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f61845a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61846b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61847c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61848d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f61849e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f61850f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61851g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f61852h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f61853i;

        public c(e eVar, View view) {
            this.f61845a = view;
            this.f61846b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f61847c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f61848d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f61849e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f61850f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f61851g = (TextView) view.findViewById(R.id.tvUserName);
            this.f61852h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f61853i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f61846b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f61846b.setDrawerType(0);
            this.f61850f.setIsRound(true);
            this.f61850f.setDrawBorder(true);
            this.f61850f.setBorderColor(eVar.f61835b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f61850f.setBorderWidth(eVar.f61835b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f61850f.setIsGod(false);
            this.f61850f.setIsBigV(false);
            this.f61850f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61849e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f61849e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.f61835b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f61837d = inflate;
        this.f61836c = new c(this, inflate);
        this.f61842i = z;
    }

    public View g() {
        return this.f61837d;
    }

    public void h(d.a.n0.v.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f61417h) != null && a2Var.r1() != null) {
            g().setVisibility(0);
            this.f61840g = cVar.f61417h;
            this.f61838e = cVar.f61414e;
            this.f61839f = !TextUtils.isEmpty(cVar.f61416g) ? cVar.f61416g : cVar.f61415f;
            this.f61836c.f61846b.setDrawerType(0);
            this.f61836c.f61846b.setBorderSurroundContent(true);
            this.f61836c.f61846b.setDrawBorder(true);
            this.f61836c.f61846b.V(this.f61840g.r1().cover, 10, false);
            this.f61836c.f61848d.setText(this.f61835b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f61840g.r1().audience_count)));
            this.f61836c.f61850f.setData(this.f61840g, false);
            this.f61836c.f61852h.setText(this.f61840g.z1());
            if (this.f61840g.T() != null) {
                String name_show = this.f61840g.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f61836c.f61851g.setText(name_show);
            }
            String str = this.f61840g.r1().label_name;
            if (this.f61842i && !StringUtils.isNull(str)) {
                this.f61836c.f61847c.setText(str);
                this.f61836c.f61847c.setVisibility(0);
            } else {
                this.f61836c.f61847c.setVisibility(8);
            }
            if (cVar.f61418i) {
                this.f61836c.f61853i.setText(this.f61835b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f61840g.r1().distance / 1000.0d))));
                this.f61836c.f61853i.setVisibility(0);
            } else {
                this.f61836c.f61853i.setVisibility(8);
            }
            this.f61836c.f61851g.setOnClickListener(this.k);
            i(this.f61835b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        g().setVisibility(4);
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        if (this.f61834a != i2) {
            SkinManager.setBackgroundResource(this.f61836c.f61849e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f61836c.f61848d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61836c.f61851g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61836c.f61852h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f61836c.f61853i, R.color.CAM_X0109);
            this.f61834a = i2;
        }
    }

    public void j(f fVar) {
        this.f61841h = fVar;
    }
}
