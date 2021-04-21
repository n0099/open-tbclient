package d.b.j0.t.d.c.h;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class g {
    public static final float w;
    public static final float[] x;
    public static final float[] y;
    public static final float[] z;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f62442c;

    /* renamed from: d  reason: collision with root package name */
    public View f62443d;

    /* renamed from: e  reason: collision with root package name */
    public View f62444e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f62445f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62446g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62447h;
    public TextView i;
    public ViewGroup j;
    public TbImageView k;
    public ImageView l;
    public d.b.j0.t.d.a.a m;
    public SdkLiveInfoData n;
    public String o;
    public AlphaAnimation q;

    /* renamed from: a  reason: collision with root package name */
    public int f62440a = 3;

    /* renamed from: b  reason: collision with root package name */
    public int[] f62441b = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    public boolean p = false;
    public boolean r = true;
    public boolean s = false;
    public int t = 0;
    public boolean u = false;
    public View.OnClickListener v = new c();

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            g.this.s = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            g.this.s = true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbImageView.f {

        /* renamed from: a  reason: collision with root package name */
        public String f62449a;

        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z && g.this.p && !g.this.s) {
                if (StringUtils.isNull(this.f62449a) || !this.f62449a.equals(str)) {
                    g gVar = g.this;
                    gVar.f62445f.startAnimation(gVar.q);
                    this.f62449a = str;
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.m == null || g.this.n == null) {
                return;
            }
            if (g.this.n.shouldJumpChushouLiveRoom()) {
                d.b.j0.t.d.c.c.c(g.this.f62442c, g.this.n.roomId, String.valueOf(g.this.n.liveInfo.liveType));
            } else {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = d.b.c.e.m.b.f(g.this.n.roomId, 0L);
                if (g.this.n.liveInfo != null) {
                    alaLiveInfoCoreData.hslUrl = g.this.n.liveInfo.hlsUrl;
                    alaLiveInfoCoreData.liveCover = g.this.n.liveInfo.cover;
                    alaLiveInfoCoreData.rtmpUrl = g.this.n.liveInfo.rtmpUrl;
                    alaLiveInfoCoreData.liveTitle = g.this.n.title;
                    alaLiveInfoCoreData.audienceCount = g.this.n.liveInfo.audienceCount;
                }
                String str = null;
                if (!g.this.u) {
                    str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                } else if (g.this.m != null) {
                    str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + g.this.m.f62222g;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(g.this.f62442c.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
            }
            if (g.this.m.f62221f) {
                StatisticItem statisticItem = new StatisticItem("c13611");
                statisticItem.param("obj_param1", g.this.n.roomId);
                statisticItem.param("fid", g.this.m.f62222g);
                statisticItem.param("fname", g.this.m.f62223h);
                statisticItem.param("obj_locate", g.this.m.i);
                if (g.this.n != null && g.this.n.uiTransParam != null) {
                    statisticItem.param("ab_tag", g.this.n.uiTransParam.abTag);
                    statisticItem.param(TiebaStatic.Params.STAR_ID, g.this.n.uiTransParam.starId);
                    statisticItem.param("extra", g.this.n.uiTransParam.extra);
                    statisticItem.param("source_from", g.this.n.uiTransParam.sourceFrom);
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13557");
            statisticItem2.param("obj_param1", g.this.n.roomId);
            statisticItem2.param(TiebaStatic.Params.ENTRY_NAME, "游戏");
            TiebaStatic.log(statisticItem2);
        }
    }

    static {
        float dimension = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        w = dimension;
        x = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, dimension, dimension};
        y = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension};
        z = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, 0.0f, 0.0f};
    }

    public g(TbPageContext<?> tbPageContext) {
        this.f62442c = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.f62443d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f62445f = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.f62445f.setDrawBorder(true);
        this.f62445f.setPlaceHolder(2);
        this.f62445f.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f62444e = this.f62443d.findViewById(R.id.rlSquareLivePanel);
        this.i = (TextView) this.f62443d.findViewById(R.id.live_title);
        this.f62446g = (TextView) this.f62443d.findViewById(R.id.tvLiveCount);
        this.f62447h = (TextView) this.f62443d.findViewById(R.id.tvUserName);
        this.j = (ViewGroup) this.f62443d.findViewById(R.id.tvUserNameWrapper);
        this.k = (TbImageView) this.f62443d.findViewById(R.id.live_label);
        this.l = (ImageView) this.f62443d.findViewById(R.id.live_redpacket_label);
        this.f62443d.setOnClickListener(this.v);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.q = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.q.setAnimationListener(new a());
    }

    public View i() {
        return this.f62443d;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0293  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(d.b.j0.t.d.a.a aVar) {
        String str;
        SdkLiveInfoData.UiTransParam uiTransParam;
        int k = l.k(this.f62443d.getContext());
        if (k != this.t) {
            ViewGroup.LayoutParams layoutParams = this.f62444e.getLayoutParams();
            int k2 = (int) (((l.k(this.f62443d.getContext()) - this.f62443d.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.f62443d.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2.0d);
            int i = (int) ((k2 * 9) / 16.0d);
            ViewGroup.LayoutParams layoutParams2 = this.f62443d.getLayoutParams();
            layoutParams2.width = k2;
            this.f62443d.setLayoutParams(layoutParams2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(k2, i);
            } else {
                layoutParams.width = k2;
                layoutParams.height = i;
            }
            this.f62444e.setLayoutParams(layoutParams);
            this.t = k;
        }
        if (aVar != null && aVar.f62220e != null) {
            i().setVisibility(0);
            this.m = aVar;
            this.n = aVar.f62220e;
            Object tag = this.f62445f.getTag();
            if (this.r) {
                this.p = true;
                this.r = false;
            } else if ((tag instanceof String) && !StringUtils.isNull(this.n.liveInfo.cover) && !((String) tag).equals(this.n.liveInfo.cover)) {
                this.p = true;
            } else if (!StringUtils.isNull(this.o) && !StringUtils.isNull(this.n.liveInfo.cover) && !this.o.equals(this.n.liveInfo.cover)) {
                this.p = true;
            } else {
                this.p = false;
            }
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f62441b);
            String str2 = this.n.liveInfo.cover;
            this.o = str2;
            this.f62445f.setTag(str2);
            if (aVar.j) {
                this.f62445f.setConrers(5);
                gradientDrawable.setCornerRadii(y);
                this.f62445f.setPlaceHolder(2);
            } else if (aVar.k) {
                this.f62445f.setConrers(10);
                gradientDrawable.setCornerRadii(z);
                this.f62445f.setPlaceHolder(2);
            } else if (aVar.l) {
                this.f62445f.setConrers(15);
                gradientDrawable.setCornerRadii(x);
                this.f62445f.setPlaceHolder(2);
            }
            this.f62445f.setRadius((int) w);
            this.f62445f.W(this.n.liveInfo.cover, 10, false);
            this.j.setBackgroundDrawable(gradientDrawable);
            this.f62445f.setEvent(new b());
            this.f62446g.setText(this.f62442c.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtraWithRound(this.n.liveInfo.audienceCount)));
            this.f62447h.setText(this.n.liveAuthor.name);
            this.i.setText(this.n.title);
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                str = this.n.recom_extra_img;
            } else {
                str = this.n.recom_extra_img_night;
            }
            if (!StringUtils.isNull(str)) {
                SdkLiveInfoData sdkLiveInfoData = this.n;
                if (sdkLiveInfoData.recom_extra_img_width > 0 && sdkLiveInfoData.recom_extra_img_height > 0) {
                    if (aVar.j) {
                        this.k.setConrers(1);
                    } else if (aVar.k) {
                        this.k.setConrers(0);
                    } else if (aVar.l) {
                        this.k.setConrers(1);
                    } else {
                        this.k.setConrers(0);
                    }
                    this.k.setRadius((int) w);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
                    if (layoutParams3 != null) {
                        int dimensionPixelSize = this.f62442c.getResources().getDimensionPixelSize(R.dimen.ds42);
                        SdkLiveInfoData sdkLiveInfoData2 = this.n;
                        float f2 = sdkLiveInfoData2.recom_extra_img_width / sdkLiveInfoData2.recom_extra_img_height;
                        layoutParams3.height = dimensionPixelSize;
                        layoutParams3.width = (int) (dimensionPixelSize * f2);
                        this.k.setLayoutParams(layoutParams3);
                    }
                    this.k.W(str, 10, false);
                    this.k.setVisibility(0);
                    this.l.setVisibility(8);
                    k(this.f62442c, TbadkCoreApplication.getInst().getSkinType());
                    if (!aVar.f62221f) {
                        StatisticItem statisticItem = new StatisticItem("c13610");
                        statisticItem.param("obj_param1", this.n.roomId);
                        statisticItem.param("fid", aVar.f62222g);
                        statisticItem.param("fname", aVar.f62223h);
                        statisticItem.param("obj_locate", aVar.i);
                        SdkLiveInfoData sdkLiveInfoData3 = this.n;
                        if (sdkLiveInfoData3 != null && (uiTransParam = sdkLiveInfoData3.uiTransParam) != null) {
                            statisticItem.param("ab_tag", uiTransParam.abTag);
                            statisticItem.param(TiebaStatic.Params.STAR_ID, this.n.uiTransParam.starId);
                            statisticItem.param("extra", this.n.uiTransParam.extra);
                            statisticItem.param("source_from", this.n.uiTransParam.sourceFrom);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13544");
                    statisticItem2.param("obj_param1", this.n.roomId);
                    statisticItem2.param(TiebaStatic.Params.ENTRY_NAME, "游戏");
                    TiebaStatic.log(statisticItem2);
                    return;
                }
            }
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            k(this.f62442c, TbadkCoreApplication.getInst().getSkinType());
            if (!aVar.f62221f) {
            }
        } else {
            i().setVisibility(4);
        }
    }

    public void k(TbPageContext<?> tbPageContext, int i) {
        if (this.f62440a != i) {
            SkinManager.setViewTextColor(this.f62446g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f62447h, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0105);
            Drawable drawable = SkinManager.getDrawable(this.f62442c.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.f62442c.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f62442c.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f62446g.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f62446g.setCompoundDrawablePadding(this.f62442c.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f62440a = i;
        }
    }

    public void l(boolean z2) {
        this.u = z2;
    }
}
