package d.b.i0.t.d.c.h;

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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class h {
    public static final int v = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    public static final float w;
    public static final float[] x;
    public static final float[] y;
    public static final float[] z;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f62033c;

    /* renamed from: d  reason: collision with root package name */
    public View f62034d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f62035e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f62036f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62037g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f62038h;
    public LinearLayout i;
    public TbImageView j;
    public TbImageView k;
    public d.b.i0.t.d.a.a l;
    public SdkLiveInfoData m;
    public String n;
    public AlphaAnimation p;
    public int t;

    /* renamed from: a  reason: collision with root package name */
    public int f62031a = 3;

    /* renamed from: b  reason: collision with root package name */
    public int[] f62032b = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
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
            h.this.r = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            h.this.r = true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbImageView.f {

        /* renamed from: a  reason: collision with root package name */
        public String f62040a;

        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z && h.this.o && !h.this.r) {
                if (StringUtils.isNull(this.f62040a) || !this.f62040a.equals(str)) {
                    h hVar = h.this;
                    hVar.f62035e.startAnimation(hVar.p);
                    this.f62040a = str;
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
                h hVar = h.this;
                h.this.j.setLayoutParams(new RelativeLayout.LayoutParams(hVar.k(hVar.j.getLoadedHeight(), h.this.j.getLoadedWidth()), h.v));
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
                h hVar = h.this;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(hVar.k(hVar.k.getLoadedHeight(), h.this.k.getLoadedWidth()), h.v);
                layoutParams.addRule(11);
                layoutParams.rightMargin = h.this.f62033c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                h.this.k.setLayoutParams(layoutParams);
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
            if (d.b.i0.t.d.c.c.b(h.this.m)) {
                if (103 == h.this.t) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_param1", h.this.m.liveId);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem);
                    str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
                } else {
                    str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                }
                d.b.i0.t.d.c.c.d(h.this.f62033c, h.this.m, str2);
                return;
            }
            d.b.i0.t.d.c.c.f(h.this.f62033c.getPageActivity(), h.this.m);
            if (h.this.l == null || h.this.m == null) {
                return;
            }
            if (h.this.l.f61800f) {
                StatisticItem statisticItem2 = new StatisticItem("c13611");
                statisticItem2.param("obj_param1", h.this.m.liveId);
                statisticItem2.param("fid", h.this.l.f61801g);
                statisticItem2.param("fname", h.this.l.f61802h);
                statisticItem2.param("obj_locate", h.this.l.i);
                if (h.this.m != null && h.this.m.uiTransParam != null) {
                    statisticItem2.param("ab_tag", h.this.m.uiTransParam.abTag);
                    statisticItem2.param(TiebaStatic.Params.STAR_ID, h.this.m.uiTransParam.starId);
                    statisticItem2.param("extra", h.this.m.uiTransParam.extra);
                    statisticItem2.param("source_from", h.this.m.uiTransParam.sourceFrom);
                }
                TiebaStatic.log(statisticItem2);
                return;
            }
            StatisticItem statisticItem3 = new StatisticItem("c13557");
            if (101 == h.this.t) {
                str = "推荐";
            } else if (102 == h.this.t) {
                str = "颜值";
            } else {
                str = 103 == h.this.t ? "交友" : "";
            }
            statisticItem3.param("obj_param1", h.this.m.liveId);
            statisticItem3.param(TiebaStatic.Params.ENTRY_NAME, str);
            TiebaStatic.log(statisticItem3);
        }
    }

    static {
        float dimension = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        w = dimension;
        x = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, dimension, dimension};
        y = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension};
        z = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, 0.0f, 0.0f};
    }

    public h(TbPageContext<?> tbPageContext, int i) {
        this.f62033c = tbPageContext;
        this.t = i;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.f62034d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f62035e = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.f62035e.setDrawBorder(true);
        this.f62035e.setPlaceHolder(2);
        this.f62035e.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f62036f = (EMTextView) this.f62034d.findViewById(R.id.tvLiveCount);
        this.f62037g = (TextView) this.f62034d.findViewById(R.id.tvUserName);
        this.i = (LinearLayout) this.f62034d.findViewById(R.id.tvInfoWrapper);
        this.j = (TbImageView) this.f62034d.findViewById(R.id.live_label);
        this.k = (TbImageView) this.f62034d.findViewById(R.id.live_status_label);
        this.f62038h = (EMTextView) this.f62034d.findViewById(R.id.tvLocation);
        this.f62034d.setOnClickListener(this.u);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a());
    }

    public final int k(int i, int i2) {
        return (int) (v * (i2 / i));
    }

    public View l() {
        return this.f62034d;
    }

    public final void m() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.f62033c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = this.f62033c.getResources().getDimensionPixelOffset(R.dimen.M_H_X002);
        this.f62038h.setGravity(16);
        this.f62038h.setLayoutParams(layoutParams);
    }

    public void n(d.b.i0.t.d.a.a aVar) {
        o(aVar, -1);
    }

    public void o(d.b.i0.t.d.a.a aVar, int i) {
        String str;
        SdkLiveInfoData.UiTransParam uiTransParam;
        String str2;
        int k = l.k(this.f62034d.getContext());
        if (k != this.s) {
            ViewGroup.LayoutParams layoutParams = this.f62034d.getLayoutParams();
            int k2 = (l.k(this.f62034d.getContext()) - this.f62034d.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.f62034d.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                int i2 = k2 / 2;
                layoutParams = new ViewGroup.LayoutParams(i2, i2);
            } else {
                int i3 = k2 / 2;
                layoutParams.width = i3;
                layoutParams.height = i3;
            }
            this.f62034d.setLayoutParams(layoutParams);
            this.s = k;
        }
        if (aVar != null && aVar.f61799e != null) {
            l().setVisibility(0);
            this.l = aVar;
            this.m = aVar.f61799e;
            Object tag = this.f62035e.getTag();
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
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f62032b);
            String str3 = this.m.liveInfo.cover;
            this.n = str3;
            this.f62035e.setTag(str3);
            if (aVar.j) {
                this.f62035e.setConrers(5);
                gradientDrawable.setCornerRadii(y);
                this.f62035e.setPlaceHolder(2);
            } else if (aVar.k) {
                this.f62035e.setConrers(10);
                gradientDrawable.setCornerRadii(z);
                this.f62035e.setPlaceHolder(2);
            } else if (aVar.l) {
                this.f62035e.setConrers(15);
                gradientDrawable.setCornerRadii(x);
                this.f62035e.setPlaceHolder(2);
            }
            this.f62035e.setRadius((int) w);
            this.f62035e.W(this.m.liveInfo.cover, 10, false);
            this.i.setBackgroundDrawable(gradientDrawable);
            this.f62035e.setEvent(new b());
            long j = this.m.liveInfo.audienceCount;
            if (j <= 0) {
                this.f62036f.setVisibility(8);
                if (this.f62038h.getVisibility() == 0) {
                    q();
                }
            } else {
                String numberUniformFormatExtraWithRound = StringHelper.numberUniformFormatExtraWithRound(j);
                this.f62036f.setVisibility(0);
                this.f62036f.setText(numberUniformFormatExtraWithRound);
                m();
            }
            if (103 == this.t) {
                if (!StringUtils.isNull(this.m.title)) {
                    this.f62037g.setText(this.m.title);
                }
            } else if (!StringUtils.isNull(this.m.liveAuthor.nameShow)) {
                this.f62037g.setText(this.m.liveAuthor.nameShow);
            }
            if (!StringUtils.isNull(this.m.labelUrl)) {
                this.j.setVisibility(0);
                this.j.W(this.m.labelUrl, 10, false);
                this.j.setEvent(new c());
            } else {
                this.j.setVisibility(8);
            }
            if (!StringUtils.isNull(this.m.modeUrl)) {
                this.k.setVisibility(0);
                this.k.W(this.m.modeUrl, 10, false);
                this.k.setEvent(new d());
            } else {
                this.k.setVisibility(8);
            }
            if (!StringUtils.isNull(this.m.location)) {
                this.f62038h.setVisibility(0);
                if (this.m.location.length() <= 5) {
                    str2 = this.m.location;
                } else {
                    str2 = this.m.location.substring(0, 5) + StringHelper.STRING_MORE;
                }
                this.f62038h.setText(str2);
            } else {
                this.f62038h.setVisibility(8);
            }
            if (this.m != null) {
                if (i == 2) {
                    TiebaStatic.log(new StatisticItem("c12899").param("tid", this.m.tid));
                } else if (i == 1) {
                    TiebaStatic.log(new StatisticItem("c12903").param("tid", this.m.tid));
                }
            }
            p(this.f62033c, TbadkCoreApplication.getInst().getSkinType());
            if (aVar.f61800f) {
                StatisticItem statisticItem = new StatisticItem("c13610");
                SdkLiveInfoData sdkLiveInfoData = this.m;
                statisticItem.param("obj_param1", sdkLiveInfoData != null ? sdkLiveInfoData.liveId : "");
                statisticItem.param("fid", aVar.f61801g);
                statisticItem.param("fname", aVar.f61802h);
                statisticItem.param("obj_locate", aVar.i);
                SdkLiveInfoData sdkLiveInfoData2 = this.m;
                if (sdkLiveInfoData2 != null && (uiTransParam = sdkLiveInfoData2.uiTransParam) != null) {
                    statisticItem.param("ab_tag", uiTransParam.abTag);
                    statisticItem.param(TiebaStatic.Params.STAR_ID, this.m.uiTransParam.starId);
                    statisticItem.param("extra", this.m.uiTransParam.extra);
                    statisticItem.param("source_from", this.m.uiTransParam.sourceFrom);
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13544");
            int i4 = this.t;
            if (101 == i4) {
                str = "推荐";
            } else if (102 == i4) {
                str = "颜值";
            } else if (103 == i4) {
                if (d.b.i0.t.d.c.c.b(this.m)) {
                    StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
                    statisticItem3.param("obj_locate", 3);
                    statisticItem3.param("obj_param1", this.m.liveId);
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem3);
                }
                str = "交友";
            } else {
                str = "";
            }
            SdkLiveInfoData sdkLiveInfoData3 = this.m;
            statisticItem2.param("obj_param1", sdkLiveInfoData3 != null ? sdkLiveInfoData3.liveId : "");
            statisticItem2.param(TiebaStatic.Params.ENTRY_NAME, str);
            TiebaStatic.log(statisticItem2);
            return;
        }
        l().setVisibility(4);
    }

    public void p(TbPageContext<?> tbPageContext, int i) {
        if (this.f62031a != i) {
            SkinManager.setViewTextColor(this.f62036f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f62037g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f62038h, R.color.CAM_X0101);
            this.f62031a = i;
        }
    }

    public final void q() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.f62033c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = 0;
        this.f62038h.setGravity(16);
        this.f62038h.setLayoutParams(layoutParams);
    }
}
