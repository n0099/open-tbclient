package d.a.o0.v.d.c.h;

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
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class g implements d.a.o0.v.d.c.b {
    public static final int s = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds55);

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f65492a;

    /* renamed from: b  reason: collision with root package name */
    public int f65493b;

    /* renamed from: c  reason: collision with root package name */
    public View f65494c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f65495d;

    /* renamed from: e  reason: collision with root package name */
    public View f65496e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f65497f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f65498g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f65499h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f65500i;
    public TbImageView j;
    public d.a.o0.v.d.a.a l;
    public SdkLiveInfoData m;
    public int k = 3;
    public int n = 0;
    public int o = 2;
    public int p = 6;
    public int q = 9;
    public final View.OnClickListener r = new b();

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                g gVar = g.this;
                g.this.j.setLayoutParams(new RelativeLayout.LayoutParams(gVar.i(gVar.j.getLoadedHeight(), g.this.j.getLoadedWidth()), g.s));
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
            String str2;
            if (d.a.o0.v.d.c.c.d(g.this.m)) {
                if (g.this.l.f65248f) {
                    str2 = YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + g.this.f65493b;
                } else {
                    str2 = YYLiveUtil.SOURCE_HOME_LIVE_TAB_CARD_ + g.this.f65493b;
                }
                d.a.o0.v.d.c.c.j(g.this.f65492a, g.this.m, str2);
            }
            if (g.this.l == null || !g.this.l.f65248f) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
            if (g.this.m != null) {
                statisticItem.param("tid", g.this.m.tid);
                statisticItem.param("fid", g.this.l.f65249g);
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", g.this.p);
            if (g.this.m != null && g.this.m.liveInfo != null) {
                int a2 = d.a.o0.v.d.c.c.a(g.this.m.liveInfo);
                if (g.this.m.liveInfo.yyExt != null) {
                    TiebaStaticHelper.addYYParam(statisticItem, d.a.o0.v.d.c.c.k(g.this.m.liveInfo.yyExt));
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
        this.f65492a = tbPageContext;
        this.f65493b = i2;
        j(tbPageContext);
    }

    @Override // d.a.o0.v.d.c.b
    public void a(d.a.o0.v.d.a.a aVar) {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        if (aVar != null && aVar.f65247e != null) {
            getView().setVisibility(0);
            this.l = aVar;
            this.m = aVar.f65247e;
            int k = l.k(this.f65494c.getContext());
            if (k != this.n) {
                ViewGroup.LayoutParams layoutParams = this.f65494c.getLayoutParams();
                int k2 = l.k(this.f65494c.getContext()) - this.f65494c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
                int dimensionPixelSize = this.f65494c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds34);
                int i2 = this.o;
                int i3 = k2 - (dimensionPixelSize * i2);
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(i3 / this.o, -2);
                } else {
                    layoutParams.width = i3 / i2;
                    layoutParams.height = -2;
                }
                this.f65494c.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.f65495d.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(i3 / this.o, (i3 / 32) * this.q);
                } else {
                    layoutParams2.width = i3 / this.o;
                    layoutParams2.height = (i3 / 32) * this.q;
                }
                this.f65495d.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.f65496e.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new RelativeLayout.LayoutParams(i3 / this.o, this.f65494c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
                } else {
                    layoutParams3.width = i3 / this.o;
                    layoutParams3.height = this.f65494c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72);
                }
                this.f65496e.setLayoutParams(layoutParams3);
                this.n = k;
            }
            SdkLiveInfoData.AlaLiveInfo alaLiveInfo2 = this.m.liveInfo;
            if (alaLiveInfo2 != null) {
                if (!TextUtils.isEmpty(alaLiveInfo2.coverWide)) {
                    this.f65495d.U(this.m.liveInfo.coverWide, 10, false);
                }
                if (!TextUtils.isEmpty(this.m.liveAuthor.nameShow)) {
                    this.f65497f.setText(this.m.liveAuthor.nameShow);
                }
                this.f65498g.setText(StringHelper.numberUniformFormatExtraWithRound(this.m.liveInfo.audienceCount));
                if (!TextUtils.isEmpty(this.m.title)) {
                    this.f65499h.setText(this.m.title);
                }
                if (!TextUtils.isEmpty(this.m.liveInfo.showLabel)) {
                    this.f65500i.setText(this.m.liveInfo.showLabel);
                }
                if (!StringUtils.isNull(this.m.labelUrl)) {
                    this.j.setVisibility(0);
                    this.j.U(this.m.labelUrl, 10, false);
                    this.j.setEvent(new a());
                } else {
                    this.j.setVisibility(8);
                }
                if (aVar.f65248f) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_SHOW);
                    SdkLiveInfoData sdkLiveInfoData = this.m;
                    if (sdkLiveInfoData != null) {
                        statisticItem.param("tid", sdkLiveInfoData.tid);
                        statisticItem.param("fid", aVar.f65249g);
                    }
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_locate", this.p);
                    SdkLiveInfoData sdkLiveInfoData2 = this.m;
                    if (sdkLiveInfoData2 != null && (alaLiveInfo = sdkLiveInfoData2.liveInfo) != null) {
                        int a2 = d.a.o0.v.d.c.c.a(alaLiveInfo);
                        SdkLiveInfoData.YYExt yYExt = this.m.liveInfo.yyExt;
                        if (yYExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem, d.a.o0.v.d.c.c.k(yYExt));
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
            onChangeSkinType(this.f65492a, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        getView().setVisibility(4);
    }

    @Override // d.a.o0.v.d.c.b
    public View getView() {
        return this.f65494c;
    }

    public final int i(int i2, int i3) {
        return (int) (s * (i3 / i2));
    }

    public final void j(TbPageContext<?> tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.yy_tab_live_item_view, (ViewGroup) null, false);
        this.f65494c = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.img_cover);
        this.f65495d = tbImageView;
        tbImageView.setDrawCorner(true);
        this.f65495d.setConrers(3);
        this.f65495d.setRadiusById(R.string.J_X13);
        this.f65495d.setPlaceHolder(2);
        this.f65496e = this.f65494c.findViewById(R.id.img_mask);
        this.f65497f = (TextView) this.f65494c.findViewById(R.id.text_name);
        this.f65498g = (EMTextView) this.f65494c.findViewById(R.id.text_audience_count);
        EMTextView eMTextView = (EMTextView) this.f65494c.findViewById(R.id.text_title);
        this.f65499h = eMTextView;
        d.a.n0.r.u.c.d(eMTextView).x(R.string.F_X02);
        this.f65500i = (EMTextView) this.f65494c.findViewById(R.id.text_label);
        this.f65494c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        TbImageView tbImageView2 = (TbImageView) this.f65494c.findViewById(R.id.special_label);
        this.j = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.j.setConrers(1);
        this.j.setRadius((int) tbPageContext.getResources().getDimension(R.dimen.tbds21));
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.f65494c);
        d2.l(0);
        d2.m(R.string.J_X05);
        d2.f(R.color.CAM_X0201);
        this.f65494c.setOnClickListener(this.r);
    }

    @Override // d.a.o0.v.d.c.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        if (this.k != i2) {
            SkinManager.setViewTextColor(this.f65497f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65498g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65499h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f65500i, R.color.CAM_X0109);
            d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.f65494c);
            d2.l(0);
            d2.m(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
            this.k = i2;
        }
    }
}
