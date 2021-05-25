package d.a.n0.v.d.c.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class g implements d.a.n0.v.d.c.b {
    public static final int r = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds55);

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f61653a;

    /* renamed from: b  reason: collision with root package name */
    public View f61654b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f61655c;

    /* renamed from: d  reason: collision with root package name */
    public View f61656d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61657e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f61658f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f61659g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f61660h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f61661i;
    public d.a.n0.v.d.a.a k;
    public SdkLiveInfoData l;
    public int j = 3;
    public int m = 0;
    public int n = 2;
    public int o = 6;
    public int p = 9;
    public final View.OnClickListener q = new b();

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                g gVar = g.this;
                g.this.f61661i.setLayoutParams(new RelativeLayout.LayoutParams(gVar.h(gVar.f61661i.getLoadedHeight(), g.this.f61661i.getLoadedWidth()), g.r));
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (d.a.n0.v.d.c.c.d(g.this.l)) {
                d.a.n0.v.d.c.c.j(g.this.f61653a, g.this.l);
            }
            if (g.this.k == null || !g.this.k.f61410f) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
            if (g.this.l != null) {
                statisticItem.param("tid", g.this.l.tid);
                statisticItem.param("fid", g.this.k.f61411g);
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", g.this.o);
            if (g.this.l != null && g.this.l.liveInfo != null) {
                int a2 = d.a.n0.v.d.c.c.a(g.this.l.liveInfo);
                if (g.this.l.liveInfo.yyExt != null) {
                    TiebaStaticHelper.addYYParam(statisticItem, d.a.n0.v.d.c.c.k(g.this.l.liveInfo.yyExt));
                    str = TiebaStatic.YYValues.YY_LIVE;
                } else {
                    str = "";
                }
                statisticItem.param("obj_param1", a2);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public g(TbPageContext<?> tbPageContext, int i2) {
        this.f61653a = tbPageContext;
        i(tbPageContext);
    }

    @Override // d.a.n0.v.d.c.b
    public void a(d.a.n0.v.d.a.a aVar) {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        if (aVar != null && aVar.f61409e != null) {
            getView().setVisibility(0);
            this.k = aVar;
            this.l = aVar.f61409e;
            int k = l.k(this.f61654b.getContext());
            if (k != this.m) {
                ViewGroup.LayoutParams layoutParams = this.f61654b.getLayoutParams();
                int k2 = l.k(this.f61654b.getContext()) - this.f61654b.getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
                int dimensionPixelSize = this.f61654b.getContext().getResources().getDimensionPixelSize(R.dimen.tbds34);
                int i2 = this.n;
                int i3 = k2 - (dimensionPixelSize * i2);
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(i3 / this.n, -2);
                } else {
                    layoutParams.width = i3 / i2;
                    layoutParams.height = -2;
                }
                this.f61654b.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.f61655c.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(i3 / this.n, (i3 / 32) * this.p);
                } else {
                    layoutParams2.width = i3 / this.n;
                    layoutParams2.height = (i3 / 32) * this.p;
                }
                this.f61655c.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.f61656d.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new RelativeLayout.LayoutParams(i3 / this.n, this.f61654b.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
                } else {
                    layoutParams3.width = i3 / this.n;
                    layoutParams3.height = this.f61654b.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72);
                }
                this.f61656d.setLayoutParams(layoutParams3);
                this.m = k;
            }
            SdkLiveInfoData.AlaLiveInfo alaLiveInfo2 = this.l.liveInfo;
            if (alaLiveInfo2 != null) {
                if (!TextUtils.isEmpty(alaLiveInfo2.coverWide)) {
                    this.f61655c.V(this.l.liveInfo.coverWide, 10, false);
                }
                if (!TextUtils.isEmpty(this.l.liveAuthor.nameShow)) {
                    this.f61657e.setText(this.l.liveAuthor.nameShow);
                }
                this.f61658f.setText(StringHelper.numberUniformFormatExtraWithRound(this.l.liveInfo.audienceCount));
                if (!TextUtils.isEmpty(this.l.title)) {
                    this.f61659g.setText(this.l.title);
                }
                if (!TextUtils.isEmpty(this.l.liveInfo.showLabel)) {
                    this.f61660h.setText(this.l.liveInfo.showLabel);
                }
                if (!StringUtils.isNull(this.l.labelUrl)) {
                    this.f61661i.setVisibility(0);
                    this.f61661i.V(this.l.labelUrl, 10, false);
                    this.f61661i.setEvent(new a());
                } else {
                    this.f61661i.setVisibility(8);
                }
                if (aVar.f61410f) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_SHOW);
                    SdkLiveInfoData sdkLiveInfoData = this.l;
                    if (sdkLiveInfoData != null) {
                        statisticItem.param("tid", sdkLiveInfoData.tid);
                        statisticItem.param("fid", aVar.f61411g);
                    }
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_locate", this.o);
                    SdkLiveInfoData sdkLiveInfoData2 = this.l;
                    if (sdkLiveInfoData2 != null && (alaLiveInfo = sdkLiveInfoData2.liveInfo) != null) {
                        int a2 = d.a.n0.v.d.c.c.a(alaLiveInfo);
                        SdkLiveInfoData.YYExt yYExt = this.l.liveInfo.yyExt;
                        if (yYExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem, d.a.n0.v.d.c.c.k(yYExt));
                            str = TiebaStatic.YYValues.YY_LIVE;
                        } else {
                            str = "";
                        }
                        statisticItem.param("obj_param1", a2);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    }
                    TiebaStatic.log(statisticItem);
                }
            }
            onChangeSkinType(this.f61653a, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        getView().setVisibility(4);
    }

    @Override // d.a.n0.v.d.c.b
    public View getView() {
        return this.f61654b;
    }

    public final int h(int i2, int i3) {
        return (int) (r * (i3 / i2));
    }

    public final void i(TbPageContext<?> tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.yy_tab_live_item_view, (ViewGroup) null, false);
        this.f61654b = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.img_cover);
        this.f61655c = tbImageView;
        tbImageView.setDrawCorner(true);
        this.f61655c.setConrers(3);
        this.f61655c.setRadiusById(R.string.J_X13);
        this.f61655c.setPlaceHolder(2);
        this.f61656d = this.f61654b.findViewById(R.id.img_mask);
        this.f61657e = (TextView) this.f61654b.findViewById(R.id.text_name);
        this.f61658f = (EMTextView) this.f61654b.findViewById(R.id.text_audience_count);
        EMTextView eMTextView = (EMTextView) this.f61654b.findViewById(R.id.text_title);
        this.f61659g = eMTextView;
        d.a.m0.r.u.c.d(eMTextView).x(R.string.F_X02);
        this.f61660h = (EMTextView) this.f61654b.findViewById(R.id.text_label);
        this.f61654b.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        TbImageView tbImageView2 = (TbImageView) this.f61654b.findViewById(R.id.special_label);
        this.f61661i = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.f61661i.setConrers(1);
        this.f61661i.setRadius((int) tbPageContext.getResources().getDimension(R.dimen.tbds21));
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.f61654b);
        d2.l(0);
        d2.m(R.string.J_X05);
        d2.f(R.color.CAM_X0201);
        this.f61654b.setOnClickListener(this.q);
    }

    @Override // d.a.n0.v.d.c.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        if (this.j != i2) {
            SkinManager.setViewTextColor(this.f61657e, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61658f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61659g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f61660h, R.color.CAM_X0109);
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.f61654b);
            d2.l(0);
            d2.m(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
            this.j = i2;
        }
    }
}
