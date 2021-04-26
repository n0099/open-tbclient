package d.a.j0.t.d.c.h;

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
public class g implements d.a.j0.t.d.c.b {
    public static final int o = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds55);

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60641a;

    /* renamed from: b  reason: collision with root package name */
    public View f60642b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f60643c;

    /* renamed from: d  reason: collision with root package name */
    public View f60644d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60645e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f60646f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f60647g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f60648h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f60649i;
    public d.a.j0.t.d.a.a k;
    public SdkLiveInfoData l;
    public int j = 3;
    public int m = 0;
    public final View.OnClickListener n = new b();

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                g gVar = g.this;
                g.this.f60649i.setLayoutParams(new RelativeLayout.LayoutParams(gVar.g(gVar.f60649i.getLoadedHeight(), g.this.f60649i.getLoadedWidth()), g.o));
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
            if (d.a.j0.t.d.c.c.d(g.this.l)) {
                d.a.j0.t.d.c.c.j(g.this.f60641a, g.this.l);
            }
            if (g.this.k == null || !g.this.k.f60398f) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
            if (g.this.l != null) {
                statisticItem.param("tid", g.this.l.tid);
                statisticItem.param("fid", g.this.k.f60399g);
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 6);
            if (g.this.l != null && g.this.l.liveInfo != null) {
                int a2 = d.a.j0.t.d.c.c.a(g.this.l.liveInfo);
                if (g.this.l.liveInfo.yyExt != null) {
                    TiebaStaticHelper.addYYParam(statisticItem, d.a.j0.t.d.c.c.k(g.this.l.liveInfo.yyExt));
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
        this.f60641a = tbPageContext;
        h(tbPageContext);
    }

    @Override // d.a.j0.t.d.c.b
    public void a(d.a.j0.t.d.a.a aVar) {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        if (aVar != null && aVar.f60397e != null) {
            getView().setVisibility(0);
            this.k = aVar;
            this.l = aVar.f60397e;
            int k = l.k(this.f60642b.getContext());
            if (k != this.m) {
                ViewGroup.LayoutParams layoutParams = this.f60642b.getLayoutParams();
                int k2 = (l.k(this.f60642b.getContext()) - this.f60642b.getContext().getResources().getDimensionPixelSize(R.dimen.tbds20)) - (this.f60642b.getContext().getResources().getDimensionPixelSize(R.dimen.tbds34) * 2);
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(k2 / 2, -2);
                } else {
                    layoutParams.width = k2 / 2;
                    layoutParams.height = -2;
                }
                this.f60642b.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.f60643c.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(k2 / 2, (k2 / 32) * 9);
                } else {
                    layoutParams2.width = k2 / 2;
                    layoutParams2.height = (k2 / 32) * 9;
                }
                this.f60643c.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.f60644d.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new RelativeLayout.LayoutParams(k2 / 2, this.f60642b.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
                } else {
                    layoutParams3.width = k2 / 2;
                    layoutParams3.height = this.f60642b.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72);
                }
                this.f60644d.setLayoutParams(layoutParams3);
                this.m = k;
            }
            SdkLiveInfoData.AlaLiveInfo alaLiveInfo2 = this.l.liveInfo;
            if (alaLiveInfo2 != null) {
                if (!TextUtils.isEmpty(alaLiveInfo2.coverWide)) {
                    this.f60643c.V(this.l.liveInfo.coverWide, 10, false);
                }
                if (!TextUtils.isEmpty(this.l.liveAuthor.nameShow)) {
                    this.f60645e.setText(this.l.liveAuthor.nameShow);
                }
                this.f60646f.setText(StringHelper.numberUniformFormatExtraWithRound(this.l.liveInfo.audienceCount));
                if (!TextUtils.isEmpty(this.l.title)) {
                    this.f60647g.setText(this.l.title);
                }
                if (!TextUtils.isEmpty(this.l.liveInfo.showLabel)) {
                    this.f60648h.setText(this.l.liveInfo.showLabel);
                }
                if (!StringUtils.isNull(this.l.labelUrl)) {
                    this.f60649i.setVisibility(0);
                    this.f60649i.V(this.l.labelUrl, 10, false);
                    this.f60649i.setEvent(new a());
                } else {
                    this.f60649i.setVisibility(8);
                }
                if (aVar.f60398f) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_SHOW);
                    SdkLiveInfoData sdkLiveInfoData = this.l;
                    if (sdkLiveInfoData != null) {
                        statisticItem.param("tid", sdkLiveInfoData.tid);
                        statisticItem.param("fid", aVar.f60399g);
                    }
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_locate", 6);
                    SdkLiveInfoData sdkLiveInfoData2 = this.l;
                    if (sdkLiveInfoData2 != null && (alaLiveInfo = sdkLiveInfoData2.liveInfo) != null) {
                        int a2 = d.a.j0.t.d.c.c.a(alaLiveInfo);
                        SdkLiveInfoData.YYExt yYExt = this.l.liveInfo.yyExt;
                        if (yYExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem, d.a.j0.t.d.c.c.k(yYExt));
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
            onChangeSkinType(this.f60641a, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        getView().setVisibility(4);
    }

    public final int g(int i2, int i3) {
        return (int) (o * (i3 / i2));
    }

    @Override // d.a.j0.t.d.c.b
    public View getView() {
        return this.f60642b;
    }

    public final void h(TbPageContext<?> tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.yy_tab_live_item_view, (ViewGroup) null, false);
        this.f60642b = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.img_cover);
        this.f60643c = tbImageView;
        tbImageView.setDrawCorner(true);
        this.f60643c.setConrers(3);
        this.f60643c.setRadiusById(R.string.J_X13);
        this.f60643c.setPlaceHolder(2);
        this.f60644d = this.f60642b.findViewById(R.id.img_mask);
        this.f60645e = (TextView) this.f60642b.findViewById(R.id.text_name);
        this.f60646f = (EMTextView) this.f60642b.findViewById(R.id.text_audience_count);
        EMTextView eMTextView = (EMTextView) this.f60642b.findViewById(R.id.text_title);
        this.f60647g = eMTextView;
        d.a.i0.r.u.c.d(eMTextView).v(R.string.F_X02);
        this.f60648h = (EMTextView) this.f60642b.findViewById(R.id.text_label);
        this.f60642b.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        TbImageView tbImageView2 = (TbImageView) this.f60642b.findViewById(R.id.special_label);
        this.f60649i = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.f60649i.setConrers(1);
        this.f60649i.setRadius((int) tbPageContext.getResources().getDimension(R.dimen.tbds21));
        d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(this.f60642b);
        d2.j(0);
        d2.k(R.string.J_X05);
        d2.f(R.color.CAM_X0201);
        this.f60642b.setOnClickListener(this.n);
    }

    @Override // d.a.j0.t.d.c.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        if (this.j != i2) {
            SkinManager.setViewTextColor(this.f60645e, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60646f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60647g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60648h, R.color.CAM_X0109);
            d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(this.f60642b);
            d2.j(0);
            d2.k(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
            this.j = i2;
        }
    }
}
