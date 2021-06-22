package d.a.o0.v.d.c.h;

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
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class f implements d.a.o0.v.d.c.b {
    public static final int v = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    public static final float w;
    public static final float[] x;
    public static final float[] y;
    public static final float[] z;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f65479c;

    /* renamed from: d  reason: collision with root package name */
    public View f65480d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f65481e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f65482f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f65483g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f65484h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f65485i;
    public TbImageView j;
    public TbImageView k;
    public d.a.o0.v.d.a.a l;
    public SdkLiveInfoData m;
    public String n;
    public AlphaAnimation p;
    public int t;

    /* renamed from: a  reason: collision with root package name */
    public int f65477a = 3;

    /* renamed from: b  reason: collision with root package name */
    public int[] f65478b = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
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
        public String f65487a;

        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z && f.this.o && !f.this.r) {
                if (StringUtils.isNull(this.f65487a) || !this.f65487a.equals(str)) {
                    f fVar = f.this;
                    fVar.f65481e.startAnimation(fVar.p);
                    this.f65487a = str;
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
                layoutParams.rightMargin = f.this.f65479c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
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
            String str3;
            boolean d2 = d.a.o0.v.d.c.c.d(f.this.m);
            String str4 = TiebaStatic.YYValues.YY_LIVE;
            if (d2) {
                if (f.this.l.f65248f) {
                    str3 = YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + f.this.t;
                } else {
                    str3 = YYLiveUtil.SOURCE_HOME_LIVE_TAB_CARD_ + f.this.t;
                }
                d.a.o0.v.d.c.c.j(f.this.f65479c, f.this.m, str3);
                if (!d.a.o0.v.d.c.c.d(f.this.m) || f.this.l == null) {
                    return;
                }
                if (f.this.l.f65248f) {
                    f.this.o();
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13557");
                statisticItem.param("obj_locate", f.this.l.f65251i);
                statisticItem.param("obj_param1", f.this.m.liveId);
                if (f.this.m.liveInfo != null) {
                    int a2 = d.a.o0.v.d.c.c.a(f.this.m.liveInfo);
                    if (f.this.m.liveInfo.yyExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem, d.a.o0.v.d.c.c.k(f.this.m.liveInfo.yyExt));
                    } else {
                        str4 = "";
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str4);
                }
                TiebaStatic.log(statisticItem);
            } else if (d.a.o0.v.d.c.c.c(f.this.m)) {
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
                d.a.o0.v.d.c.c.f(f.this.f65479c, f.this.m, str2);
            } else {
                d.a.o0.v.d.c.c.h(f.this.f65479c.getPageActivity(), f.this.m);
                if (f.this.l == null || f.this.m == null) {
                    return;
                }
                if (f.this.l.f65248f) {
                    StatisticItem statisticItem3 = new StatisticItem("c13611");
                    statisticItem3.param("obj_param1", f.this.m.liveId);
                    statisticItem3.param("fid", f.this.l.f65249g);
                    statisticItem3.param("fname", f.this.l.f65250h);
                    statisticItem3.param("obj_locate", f.this.l.f65251i);
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
                    int a3 = d.a.o0.v.d.c.c.a(f.this.m.liveInfo);
                    if (f.this.m.liveInfo.yyExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem4, d.a.o0.v.d.c.c.k(f.this.m.liveInfo.yyExt));
                    } else {
                        str4 = "";
                    }
                    statisticItem4.param(TiebaStatic.Params.OBJ_PARAM2, a3);
                    statisticItem4.param(TiebaStatic.Params.OBJ_PARAM3, str4);
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
        this.f65479c = tbPageContext;
        this.t = i2;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.f65480d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f65481e = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.f65481e.setDrawBorder(true);
        this.f65481e.setPlaceHolder(2);
        this.f65481e.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f65482f = (EMTextView) this.f65480d.findViewById(R.id.tvLiveCount);
        this.f65483g = (TextView) this.f65480d.findViewById(R.id.tvUserName);
        this.f65485i = (LinearLayout) this.f65480d.findViewById(R.id.tvInfoWrapper);
        this.j = (TbImageView) this.f65480d.findViewById(R.id.live_label);
        this.k = (TbImageView) this.f65480d.findViewById(R.id.live_status_label);
        this.f65484h = (EMTextView) this.f65480d.findViewById(R.id.tvLocation);
        this.f65480d.setOnClickListener(this.u);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a());
    }

    @Override // d.a.o0.v.d.c.b
    public void a(d.a.o0.v.d.a.a aVar) {
        p(aVar, -1);
    }

    @Override // d.a.o0.v.d.c.b
    public View getView() {
        return this.f65480d;
    }

    public final int m(int i2, int i3) {
        return (int) (v * (i3 / i2));
    }

    public final void n() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.f65479c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = this.f65479c.getResources().getDimensionPixelOffset(R.dimen.M_H_X002);
        this.f65484h.setGravity(16);
        this.f65484h.setLayoutParams(layoutParams);
    }

    public final void o() {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
        SdkLiveInfoData sdkLiveInfoData = this.m;
        if (sdkLiveInfoData != null) {
            statisticItem.param("tid", sdkLiveInfoData.tid);
            statisticItem.param("fid", this.l.f65249g);
        }
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", 6);
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

    @Override // d.a.o0.v.d.c.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        if (this.f65477a != i2) {
            SkinManager.setViewTextColor(this.f65482f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65483g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65484h, R.color.CAM_X0101);
            this.f65477a = i2;
        }
    }

    public void p(d.a.o0.v.d.a.a aVar, int i2) {
        String str;
        SdkLiveInfoData.UiTransParam uiTransParam;
        String str2;
        int k = l.k(this.f65480d.getContext());
        if (k != this.s) {
            ViewGroup.LayoutParams layoutParams = this.f65480d.getLayoutParams();
            int k2 = (l.k(this.f65480d.getContext()) - this.f65480d.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.f65480d.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                int i3 = k2 / 2;
                layoutParams = new ViewGroup.LayoutParams(i3, i3);
            } else {
                int i4 = k2 / 2;
                layoutParams.width = i4;
                layoutParams.height = i4;
            }
            this.f65480d.setLayoutParams(layoutParams);
            this.s = k;
        }
        if (aVar != null && aVar.f65247e != null) {
            getView().setVisibility(0);
            this.l = aVar;
            this.m = aVar.f65247e;
            Object tag = this.f65481e.getTag();
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
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f65478b);
            String str3 = this.m.liveInfo.cover;
            this.n = str3;
            this.f65481e.setTag(str3);
            if (aVar.j) {
                this.f65481e.setConrers(5);
                gradientDrawable.setCornerRadii(y);
                this.f65481e.setPlaceHolder(2);
            } else if (aVar.k) {
                this.f65481e.setConrers(10);
                gradientDrawable.setCornerRadii(z);
                this.f65481e.setPlaceHolder(2);
            } else if (aVar.l) {
                this.f65481e.setConrers(15);
                gradientDrawable.setCornerRadii(x);
                this.f65481e.setPlaceHolder(2);
            }
            this.f65481e.setRadius((int) w);
            this.f65481e.U(this.m.liveInfo.cover, 10, false);
            this.f65485i.setBackgroundDrawable(gradientDrawable);
            this.f65481e.setEvent(new b());
            long j = this.m.liveInfo.audienceCount;
            if (j <= 0) {
                this.f65482f.setVisibility(8);
                if (this.f65484h.getVisibility() == 0) {
                    q();
                }
            } else {
                String numberUniformFormatExtraWithRound = StringHelper.numberUniformFormatExtraWithRound(j);
                this.f65482f.setVisibility(0);
                this.f65482f.setText(numberUniformFormatExtraWithRound);
                n();
            }
            if (103 == this.t) {
                if (!StringUtils.isNull(this.m.title)) {
                    this.f65483g.setText(this.m.title);
                }
            } else if (!StringUtils.isNull(this.m.liveAuthor.nameShow)) {
                this.f65483g.setText(this.m.liveAuthor.nameShow);
            }
            if (!StringUtils.isNull(this.m.labelUrl)) {
                this.j.setVisibility(0);
                this.j.U(this.m.labelUrl, 10, false);
                this.j.setEvent(new c());
            } else {
                this.j.setVisibility(8);
            }
            if (!StringUtils.isNull(this.m.modeUrl)) {
                this.k.setVisibility(0);
                this.k.U(this.m.modeUrl, 10, false);
                this.k.setEvent(new d());
            } else {
                this.k.setVisibility(8);
            }
            if (!StringUtils.isNull(this.m.location)) {
                this.f65484h.setVisibility(0);
                if (this.m.location.length() <= 5) {
                    str2 = this.m.location;
                } else {
                    str2 = this.m.location.substring(0, 5) + StringHelper.STRING_MORE;
                }
                this.f65484h.setText(str2);
            } else {
                this.f65484h.setVisibility(8);
            }
            if (this.m != null) {
                if (i2 == 2) {
                    StatisticItem param = new StatisticItem("c12899").param("tid", this.m.tid);
                    TiebaStaticHelper.addYYParam(param);
                    TiebaStatic.log(param);
                } else if (i2 == 1) {
                    StatisticItem param2 = new StatisticItem("c12903").param("tid", this.m.tid);
                    TiebaStaticHelper.addYYParam(param2);
                    TiebaStatic.log(param2);
                }
            }
            onChangeSkinType(this.f65479c, TbadkCoreApplication.getInst().getSkinType());
            boolean z2 = aVar.f65248f;
            String str4 = TiebaStatic.YYValues.YY_LIVE;
            if (z2) {
                StatisticItem statisticItem = new StatisticItem("c13610");
                SdkLiveInfoData sdkLiveInfoData = this.m;
                statisticItem.param("obj_param1", sdkLiveInfoData != null ? sdkLiveInfoData.liveId : "");
                statisticItem.param("fid", aVar.f65249g);
                statisticItem.param("fname", aVar.f65250h);
                statisticItem.param("obj_locate", aVar.f65251i);
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
                    statisticItem2.param("fid", aVar.f65249g);
                }
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("obj_locate", 6);
                SdkLiveInfoData.AlaLiveInfo alaLiveInfo = this.m.liveInfo;
                if (alaLiveInfo != null) {
                    int a2 = d.a.o0.v.d.c.c.a(alaLiveInfo);
                    SdkLiveInfoData.YYExt yYExt = this.m.liveInfo.yyExt;
                    if (yYExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem2, d.a.o0.v.d.c.c.k(yYExt));
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
                if (d.a.o0.v.d.c.c.c(this.m)) {
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
                int a3 = d.a.o0.v.d.c.c.a(alaLiveInfo2);
                SdkLiveInfoData.YYExt yYExt2 = this.m.liveInfo.yyExt;
                if (yYExt2 != null) {
                    TiebaStaticHelper.addYYParam(statisticItem3, d.a.o0.v.d.c.c.k(yYExt2));
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
        layoutParams.rightMargin = this.f65479c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = 0;
        this.f65484h.setGravity(16);
        this.f65484h.setLayoutParams(layoutParams);
    }
}
