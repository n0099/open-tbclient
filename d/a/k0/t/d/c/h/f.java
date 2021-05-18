package d.a.k0.t.d.c.h;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
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
public class f implements d.a.k0.t.d.c.b {
    public static final int v = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    public static final float w;
    public static final float[] x;
    public static final float[] y;
    public static final float[] z;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f61352c;

    /* renamed from: d  reason: collision with root package name */
    public View f61353d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f61354e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f61355f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61356g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f61357h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f61358i;
    public TbImageView j;
    public TbImageView k;
    public d.a.k0.t.d.a.a l;
    public SdkLiveInfoData m;
    public String n;
    public AlphaAnimation p;
    public int t;

    /* renamed from: a  reason: collision with root package name */
    public int f61350a = 3;

    /* renamed from: b  reason: collision with root package name */
    public int[] f61351b = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    public boolean o = false;
    public boolean q = true;
    public boolean r = false;
    public int s = 0;
    public View.OnClickListener u = new e();

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            f.this.r = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            f.this.r = true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbImageView.f {

        /* renamed from: a  reason: collision with root package name */
        public String f61360a;

        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z && f.this.o && !f.this.r) {
                if (StringUtils.isNull(this.f61360a) || !this.f61360a.equals(str)) {
                    f fVar = f.this;
                    fVar.f61354e.startAnimation(fVar.p);
                    this.f61360a = str;
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TbImageView.f {
        public c() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                f fVar = f.this;
                f.this.j.setLayoutParams(new RelativeLayout.LayoutParams(fVar.m(fVar.j.getLoadedHeight(), f.this.j.getLoadedWidth()), f.v));
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements TbImageView.f {
        public d() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                f fVar = f.this;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(fVar.m(fVar.k.getLoadedHeight(), f.this.k.getLoadedWidth()), f.v);
                layoutParams.addRule(11);
                layoutParams.rightMargin = f.this.f61352c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                f.this.k.setLayoutParams(layoutParams);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            boolean d2 = d.a.k0.t.d.c.c.d(f.this.m);
            String str3 = TiebaStatic.YYValues.YY_LIVE;
            if (d2) {
                d.a.k0.t.d.c.c.j(f.this.f61352c, f.this.m);
                if (!d.a.k0.t.d.c.c.d(f.this.m) || f.this.l == null) {
                    return;
                }
                if (f.this.l.f61122f) {
                    f.this.o();
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13557");
                statisticItem.param("obj_locate", f.this.l.f61125i);
                statisticItem.param("obj_param1", f.this.m.liveId);
                if (f.this.m.liveInfo != null) {
                    int a2 = d.a.k0.t.d.c.c.a(f.this.m.liveInfo);
                    if (f.this.m.liveInfo.yyExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem, d.a.k0.t.d.c.c.k(f.this.m.liveInfo.yyExt));
                    } else {
                        str3 = "";
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str3);
                }
                TiebaStatic.log(statisticItem);
            } else if (d.a.k0.t.d.c.c.c(f.this.m)) {
                if (103 == f.this.t) {
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
                    statisticItem2.param("obj_locate", 3);
                    statisticItem2.param("obj_param1", f.this.m.liveId);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem2);
                    str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
                } else {
                    str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                }
                d.a.k0.t.d.c.c.f(f.this.f61352c, f.this.m, str2);
            } else {
                d.a.k0.t.d.c.c.h(f.this.f61352c.getPageActivity(), f.this.m);
                if (f.this.l == null || f.this.m == null) {
                    return;
                }
                if (f.this.l.f61122f) {
                    StatisticItem statisticItem3 = new StatisticItem("c13611");
                    statisticItem3.param("obj_param1", f.this.m.liveId);
                    statisticItem3.param("fid", f.this.l.f61123g);
                    statisticItem3.param("fname", f.this.l.f61124h);
                    statisticItem3.param("obj_locate", f.this.l.f61125i);
                    if (f.this.m != null && f.this.m.uiTransParam != null) {
                        statisticItem3.param("ab_tag", f.this.m.uiTransParam.abTag);
                        statisticItem3.param(TiebaStatic.Params.STAR_ID, f.this.m.uiTransParam.starId);
                        statisticItem3.param("extra", f.this.m.uiTransParam.extra);
                        statisticItem3.param("source_from", f.this.m.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(statisticItem3);
                    f.this.o();
                    return;
                }
                StatisticItem statisticItem4 = new StatisticItem("c13557");
                if (101 == f.this.t) {
                    str = "推荐";
                } else if (102 == f.this.t) {
                    str = "颜值";
                } else {
                    str = 103 == f.this.t ? "交友" : "";
                }
                if (f.this.m.liveInfo != null) {
                    int a3 = d.a.k0.t.d.c.c.a(f.this.m.liveInfo);
                    if (f.this.m.liveInfo.yyExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem4, d.a.k0.t.d.c.c.k(f.this.m.liveInfo.yyExt));
                    } else {
                        str3 = "";
                    }
                    statisticItem4.param(TiebaStatic.Params.OBJ_PARAM2, a3);
                    statisticItem4.param(TiebaStatic.Params.OBJ_PARAM3, str3);
                }
                statisticItem4.param("obj_param1", f.this.m.liveId);
                statisticItem4.param(TiebaStatic.Params.ENTRY_NAME, str);
                TiebaStatic.log(statisticItem4);
            }
        }
    }

    static {
        float dimension = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        w = dimension;
        x = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, dimension, dimension};
        y = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension};
        z = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, 0.0f, 0.0f};
    }

    public f(TbPageContext<?> tbPageContext, int i2) {
        this.f61352c = tbPageContext;
        this.t = i2;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.f61353d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f61354e = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.f61354e.setDrawBorder(true);
        this.f61354e.setPlaceHolder(2);
        this.f61354e.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f61355f = (EMTextView) this.f61353d.findViewById(R.id.tvLiveCount);
        this.f61356g = (TextView) this.f61353d.findViewById(R.id.tvUserName);
        this.f61358i = (LinearLayout) this.f61353d.findViewById(R.id.tvInfoWrapper);
        this.j = (TbImageView) this.f61353d.findViewById(R.id.live_label);
        this.k = (TbImageView) this.f61353d.findViewById(R.id.live_status_label);
        this.f61357h = (EMTextView) this.f61353d.findViewById(R.id.tvLocation);
        this.f61353d.setOnClickListener(this.u);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a());
    }

    @Override // d.a.k0.t.d.c.b
    public void a(d.a.k0.t.d.a.a aVar) {
        p(aVar, -1);
    }

    @Override // d.a.k0.t.d.c.b
    public View getView() {
        return this.f61353d;
    }

    public final int m(int i2, int i3) {
        return (int) (v * (i3 / i2));
    }

    public final void n() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.f61352c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = this.f61352c.getResources().getDimensionPixelOffset(R.dimen.M_H_X002);
        this.f61357h.setGravity(16);
        this.f61357h.setLayoutParams(layoutParams);
    }

    public final void o() {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
        SdkLiveInfoData sdkLiveInfoData = this.m;
        if (sdkLiveInfoData != null) {
            statisticItem.param("tid", sdkLiveInfoData.tid);
            statisticItem.param("fid", this.l.f61123g);
        }
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", 6);
        SdkLiveInfoData sdkLiveInfoData2 = this.m;
        if (sdkLiveInfoData2 != null && (alaLiveInfo = sdkLiveInfoData2.liveInfo) != null) {
            int a2 = d.a.k0.t.d.c.c.a(alaLiveInfo);
            SdkLiveInfoData.YYExt yYExt = this.m.liveInfo.yyExt;
            if (yYExt != null) {
                TiebaStaticHelper.addYYParam(statisticItem, d.a.k0.t.d.c.c.k(yYExt));
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param("obj_param1", a2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        TiebaStatic.log(statisticItem);
    }

    @Override // d.a.k0.t.d.c.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        if (this.f61350a != i2) {
            SkinManager.setViewTextColor(this.f61355f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61356g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61357h, R.color.CAM_X0101);
            this.f61350a = i2;
        }
    }

    public void p(d.a.k0.t.d.a.a aVar, int i2) {
        String str;
        SdkLiveInfoData.UiTransParam uiTransParam;
        String str2;
        int k = l.k(this.f61353d.getContext());
        if (k != this.s) {
            ViewGroup.LayoutParams layoutParams = this.f61353d.getLayoutParams();
            int k2 = (l.k(this.f61353d.getContext()) - this.f61353d.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.f61353d.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                int i3 = k2 / 2;
                layoutParams = new ViewGroup.LayoutParams(i3, i3);
            } else {
                int i4 = k2 / 2;
                layoutParams.width = i4;
                layoutParams.height = i4;
            }
            this.f61353d.setLayoutParams(layoutParams);
            this.s = k;
        }
        if (aVar != null && aVar.f61121e != null) {
            getView().setVisibility(0);
            this.l = aVar;
            this.m = aVar.f61121e;
            Object tag = this.f61354e.getTag();
            if (this.q) {
                this.o = true;
                this.q = false;
            } else if ((tag instanceof String) && !StringUtils.isNull(this.m.liveInfo.cover) && !((String) tag).equals(this.m.liveInfo.cover)) {
                this.o = true;
            } else if (!StringUtils.isNull(this.n) && !StringUtils.isNull(this.m.liveInfo.cover) && !this.n.equals(this.m.liveInfo.cover)) {
                this.o = true;
            } else {
                this.o = false;
            }
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f61351b);
            String str3 = this.m.liveInfo.cover;
            this.n = str3;
            this.f61354e.setTag(str3);
            if (aVar.j) {
                this.f61354e.setConrers(5);
                gradientDrawable.setCornerRadii(y);
                this.f61354e.setPlaceHolder(2);
            } else if (aVar.k) {
                this.f61354e.setConrers(10);
                gradientDrawable.setCornerRadii(z);
                this.f61354e.setPlaceHolder(2);
            } else if (aVar.l) {
                this.f61354e.setConrers(15);
                gradientDrawable.setCornerRadii(x);
                this.f61354e.setPlaceHolder(2);
            }
            this.f61354e.setRadius((int) w);
            this.f61354e.V(this.m.liveInfo.cover, 10, false);
            this.f61358i.setBackgroundDrawable(gradientDrawable);
            this.f61354e.setEvent(new b());
            long j = this.m.liveInfo.audienceCount;
            if (j <= 0) {
                this.f61355f.setVisibility(8);
                if (this.f61357h.getVisibility() == 0) {
                    q();
                }
            } else {
                String numberUniformFormatExtraWithRound = StringHelper.numberUniformFormatExtraWithRound(j);
                this.f61355f.setVisibility(0);
                this.f61355f.setText(numberUniformFormatExtraWithRound);
                n();
            }
            if (103 == this.t) {
                if (!StringUtils.isNull(this.m.title)) {
                    this.f61356g.setText(this.m.title);
                }
            } else if (!StringUtils.isNull(this.m.liveAuthor.nameShow)) {
                this.f61356g.setText(this.m.liveAuthor.nameShow);
            }
            if (!StringUtils.isNull(this.m.labelUrl)) {
                this.j.setVisibility(0);
                this.j.V(this.m.labelUrl, 10, false);
                this.j.setEvent(new c());
            } else {
                this.j.setVisibility(8);
            }
            if (!StringUtils.isNull(this.m.modeUrl)) {
                this.k.setVisibility(0);
                this.k.V(this.m.modeUrl, 10, false);
                this.k.setEvent(new d());
            } else {
                this.k.setVisibility(8);
            }
            if (!StringUtils.isNull(this.m.location)) {
                this.f61357h.setVisibility(0);
                if (this.m.location.length() <= 5) {
                    str2 = this.m.location;
                } else {
                    str2 = this.m.location.substring(0, 5) + StringHelper.STRING_MORE;
                }
                this.f61357h.setText(str2);
            } else {
                this.f61357h.setVisibility(8);
            }
            if (this.m != null) {
                if (i2 == 2) {
                    TiebaStatic.log(new StatisticItem("c12899").param("tid", this.m.tid));
                } else if (i2 == 1) {
                    TiebaStatic.log(new StatisticItem("c12903").param("tid", this.m.tid));
                }
            }
            onChangeSkinType(this.f61352c, TbadkCoreApplication.getInst().getSkinType());
            boolean z2 = aVar.f61122f;
            String str4 = TiebaStatic.YYValues.YY_LIVE;
            if (z2) {
                StatisticItem statisticItem = new StatisticItem("c13610");
                SdkLiveInfoData sdkLiveInfoData = this.m;
                statisticItem.param("obj_param1", sdkLiveInfoData != null ? sdkLiveInfoData.liveId : "");
                statisticItem.param("fid", aVar.f61123g);
                statisticItem.param("fname", aVar.f61124h);
                statisticItem.param("obj_locate", aVar.f61125i);
                SdkLiveInfoData sdkLiveInfoData2 = this.m;
                if (sdkLiveInfoData2 != null && (uiTransParam = sdkLiveInfoData2.uiTransParam) != null) {
                    statisticItem.param("ab_tag", uiTransParam.abTag);
                    statisticItem.param(TiebaStatic.Params.STAR_ID, this.m.uiTransParam.starId);
                    statisticItem.param("extra", this.m.uiTransParam.extra);
                    statisticItem.param("source_from", this.m.uiTransParam.sourceFrom);
                }
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_SHOW);
                SdkLiveInfoData sdkLiveInfoData3 = this.m;
                if (sdkLiveInfoData3 != null) {
                    statisticItem2.param("tid", sdkLiveInfoData3.tid);
                    statisticItem2.param("fid", aVar.f61123g);
                }
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("obj_locate", 6);
                SdkLiveInfoData.AlaLiveInfo alaLiveInfo = this.m.liveInfo;
                if (alaLiveInfo != null) {
                    int a2 = d.a.k0.t.d.c.c.a(alaLiveInfo);
                    SdkLiveInfoData.YYExt yYExt = this.m.liveInfo.yyExt;
                    if (yYExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem2, d.a.k0.t.d.c.c.k(yYExt));
                    } else {
                        str4 = "";
                    }
                    statisticItem2.param("obj_param1", a2);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str4);
                }
                TiebaStatic.log(statisticItem2);
                return;
            }
            StatisticItem statisticItem3 = new StatisticItem("c13544");
            int i5 = this.t;
            if (101 == i5) {
                str = "推荐";
            } else if (102 == i5) {
                str = "颜值";
            } else if (103 == i5) {
                if (d.a.k0.t.d.c.c.c(this.m)) {
                    StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
                    statisticItem4.param("obj_locate", 3);
                    statisticItem4.param("obj_param1", this.m.liveId);
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem4);
                }
                str = "交友";
            } else {
                str = "";
            }
            SdkLiveInfoData.AlaLiveInfo alaLiveInfo2 = this.m.liveInfo;
            if (alaLiveInfo2 != null) {
                int a3 = d.a.k0.t.d.c.c.a(alaLiveInfo2);
                SdkLiveInfoData.YYExt yYExt2 = this.m.liveInfo.yyExt;
                if (yYExt2 != null) {
                    TiebaStaticHelper.addYYParam(statisticItem3, d.a.k0.t.d.c.c.k(yYExt2));
                } else {
                    str4 = "";
                }
                statisticItem3.param(TiebaStatic.Params.OBJ_PARAM2, a3);
                statisticItem3.param(TiebaStatic.Params.OBJ_PARAM3, str4);
            }
            SdkLiveInfoData sdkLiveInfoData4 = this.m;
            statisticItem3.param("obj_param1", sdkLiveInfoData4 != null ? sdkLiveInfoData4.liveId : "");
            statisticItem3.param(TiebaStatic.Params.ENTRY_NAME, str);
            TiebaStatic.log(statisticItem3);
            return;
        }
        getView().setVisibility(4);
    }

    public final void q() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.f61352c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = 0;
        this.f61357h.setGravity(16);
        this.f61357h.setLayoutParams(layoutParams);
    }
}
