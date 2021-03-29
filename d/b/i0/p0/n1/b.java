package d.b.i0.p0.n1;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.view.HotRankEntryView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.AdapterLinearLayout;
import d.b.b.j.e.n;
import d.b.h0.r.q.a0;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.k;
import d.b.h0.r.s.a;
import d.b.i0.c3.b0;
import d.b.i0.c3.i;
import d.b.i0.c3.p;
import d.b.i0.p0.m2.l;
import d.b.i0.p0.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import tbclient.SignActivityInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b extends d.b.i0.p0.q2.b {
    public View A0;
    public View B0;
    public final View C0;
    public final HeadImageView D0;
    public final TextView E0;
    public final View F0;
    public final ImageView G0;
    public final TextView H0;
    public HotRankEntryView I0;
    public List<n> J0;
    public d.b.i0.b0.e K0;
    public ScheduledExecutorService N0;
    public boolean O0;
    public boolean P0;
    public boolean Q0;
    public CountDownTimer R0;
    public RelativeLayout o0;
    public TextView p0;
    public TextView q0;
    public String r0;
    public y0 t0;
    public boolean u0;
    public View v0;
    public LinearLayout x0;
    public View y0;
    public View z0;
    public boolean w0 = false;
    public int L0 = -1;
    public long M0 = 1000;
    public ArrayList<TbImageView> s0 = new ArrayList<>();

    /* loaded from: classes4.dex */
    public class a implements y0 {
        public a() {
        }

        @Override // d.b.i0.p0.y0
        public void a(a2 a2Var) {
            l.d(b.this.f58431b, b.this.V, a2Var);
        }
    }

    /* renamed from: d.b.i0.p0.n1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1402b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsViewData f57937e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a0 f57938f;

        public View$OnClickListenerC1402b(FrsViewData frsViewData, a0 a0Var) {
            this.f57937e = frsViewData;
            this.f57938f = a0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f58430a != null) {
                FrsViewData frsViewData = this.f57937e;
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(this.f57937e.getForum().getId()) && this.f57937e.getActivityHeadData() != null && !TextUtils.isEmpty(this.f57937e.getActivityHeadData().b())) {
                    String id = this.f57937e.getForum().getId();
                    String b2 = this.f57937e.getActivityHeadData().b();
                    StatisticItem statisticItem = new StatisticItem("c13330");
                    statisticItem.param("fid", id);
                    statisticItem.param("obj_id", b2);
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("common_click");
                    statisticItem2.param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param("fid", id).param("obj_id", b2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.FIRST_DIR, this.f57937e.getForum().getFirst_class()).param(TiebaStatic.Params.SECOND_DIR, this.f57937e.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
                    }
                    d.b.i0.b3.c.g().c(b.this.f58431b.getUniqueId(), statisticItem2);
                }
                d.b.i0.p0.m2.h.b(b.this.f58430a, this.f57938f.f(), this.f57938f.e());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c(b bVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (b.this.f58430a == null || b.this.f58430a.getPageActivity() == null) {
                return;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.f58430a.getPageActivity(), b.this.d0, "exp_acce", 2);
            memberPayActivityConfig.setSceneId("4004001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f58430a == null || b.this.f58430a.getPageActivity() == null) {
                return;
            }
            d.b.b.e.m.g.d(b.this.L, b.this.f58430a.getPageActivity());
            b.this.f58431b.f15973g = false;
            d.b.h0.l.a.o(b.this.f58430a.getPageActivity(), b.this.f58430a.getResources().getString(R.string.experion_speed), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 4) {
                d.b.b.e.m.g.c(b.this.L);
                b.this.f58431b.f15973g = false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f57943a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(long j, long j2, String str) {
            super(j, j2);
            this.f57943a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            b.this.E = false;
            if (b.this.D != null) {
                b.this.D.setVisibility(8);
            }
            if (b.this.P == null || b.this.h()) {
                return;
            }
            b.this.P.q(b.this.E);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (b.this.D != null) {
                b.this.D.setVisibility(0);
                EMTextView eMTextView = b.this.D;
                eMTextView.setText(this.f57943a + (j / 1000) + "s");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57945e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.D != null) {
                    if (b.this.D.getVisibility() == 8) {
                        b.this.D.setVisibility(0);
                        b.this.D.setText(h.this.f57945e);
                        if (b.this.F != null) {
                            b bVar = b.this;
                            bVar.Q0(bVar.F.activity_msg, b.this.F.countdown_time.intValue());
                        }
                    } else if (b.this.D.getVisibility() == 0) {
                        b.this.H0();
                    }
                }
            }
        }

        public h(String str) {
            this.f57945e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.b.e.m.e.a().post(new a());
        }
    }

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.d0 = i;
        this.f58432c = new Handler();
        this.f58431b = frsFragment;
        this.f58430a = frsFragment.getPageContext();
        d.b.b.e.p.l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        d.b.b.e.p.l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        d.b.b.e.p.l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.R = str;
        this.S = str2;
        View I0 = I0();
        this.f58433d = I0;
        this.o0 = (RelativeLayout) I0.findViewById(R.id.container);
        this.u = (RelativeLayout) this.f58433d.findViewById(R.id.head_top_bg_container);
        this.v = (LinearGradientView) this.f58433d.findViewById(R.id.head_top_gradient_bg);
        TbImageView tbImageView = (TbImageView) this.f58433d.findViewById(R.id.head_top_bg_mask);
        this.w = tbImageView;
        tbImageView.setPageId(this.f58431b.getUniqueId());
        this.w.setDefaultBgResource(R.color.transparent);
        this.w.setDefaultResource(R.drawable.pic_frs_head_default);
        View findViewById = this.f58433d.findViewById(R.id.header_top_cover);
        this.v0 = findViewById;
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(findViewById);
        a2.h(R.string.J_X11);
        a2.l(R.array.Mask_X005);
        this.x0 = (LinearLayout) this.f58433d.findViewById(R.id.layout_banner_container);
        this.y0 = this.f58433d.findViewById(R.id.header_round_corner_layout);
        this.z0 = this.f58433d.findViewById(R.id.service_and_top_view_layout);
        this.A0 = this.f58433d.findViewById(R.id.banner_and_bottom_view_layout);
        this.x = (ServiceAreaView) this.f58433d.findViewById(R.id.service_area_view);
        this.y = (FrameLayout) this.f58433d.findViewById(R.id.frs_ad_banner);
        this.A = (FrsTopView) this.f58433d.findViewById(R.id.frs_topview);
        this.B0 = this.f58433d.findViewById(R.id.frs_top_divider_layout);
        this.B = this.f58433d.findViewById(R.id.frs_top_divider_line);
        this.C = this.f58433d.findViewById(R.id.service_topview_space);
        this.K = (ImageView) this.f58433d.findViewById(R.id.speed_icon);
        this.p0 = (TextView) this.f58433d.findViewById(R.id.member_image);
        this.q0 = (TextView) this.f58433d.findViewById(R.id.post_image);
        this.j = (TextView) this.f58433d.findViewById(R.id.level_name);
        this.s = (TextView) this.f58433d.findViewById(R.id.level);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f58433d.findViewById(R.id.tv_love);
        this.f58437h = tBSpecificationBtn;
        tBSpecificationBtn.setText(frsFragment.getResources().getString(R.string.attention));
        this.f58437h.setTextSize(R.dimen.T_X08);
        d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
        bVar.o(R.color.CAM_X0901, R.color.CAM_X0105);
        this.f58437h.setConfig(bVar);
        TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f58433d.findViewById(R.id.tv_sign);
        this.i = tBSpecificationBtn2;
        tBSpecificationBtn2.setTextSize(R.dimen.T_X08);
        d.b.h0.r.f0.m.b bVar2 = new d.b.h0.r.f0.m.b();
        bVar2.s(R.color.CAM_X0105);
        bVar2.g(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.i(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.i.setConfig(bVar2);
        this.i.setText(frsFragment.getResources().getString(R.string.sign));
        this.k = (ImageView) this.f58433d.findViewById(R.id.love_level_top);
        this.l = (ImageView) this.f58433d.findViewById(R.id.love_level_bg);
        this.f58434e = (TextView) this.f58433d.findViewById(R.id.member_num_text);
        this.f58435f = (TextView) this.f58433d.findViewById(R.id.post_num_text);
        this.n = (TextView) this.f58433d.findViewById(R.id.forum_name);
        this.o = (TextView) this.f58433d.findViewById(R.id.brand_label);
        BarImageView barImageView = (BarImageView) this.f58433d.findViewById(R.id.frs_image);
        this.M = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.M.setPageId(this.f58431b.getUniqueId());
        this.M.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.M.setStrokeWith(d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.M.setShowOval(true);
        this.M.setPlaceHolder(1);
        this.r = this.f58433d.findViewById(R.id.level_container);
        this.q = (RelativeLayout) this.f58433d.findViewById(R.id.has_focused_container);
        this.p = (RelativeLayout) this.f58433d.findViewById(R.id.not_focused_container);
        this.t = (RelativeLayout) this.f58433d.findViewById(R.id.head_content_container);
        this.C0 = this.f58433d.findViewById(R.id.frs_manager_info_layout);
        this.E0 = (TextView) this.f58433d.findViewById(R.id.frs_manager_name);
        HeadImageView headImageView = (HeadImageView) this.f58433d.findViewById(R.id.frs_manager_portrait);
        this.D0 = headImageView;
        headImageView.setIsRound(true);
        this.D0.setDrawBorder(true);
        this.D0.setDefaultResource(R.drawable.icon_default_avatar100);
        this.D0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.F0 = this.f58433d.findViewById(R.id.frs_manager_application_layout);
        this.G0 = (ImageView) this.f58433d.findViewById(R.id.frs_manager_application_icon);
        this.H0 = (TextView) this.f58433d.findViewById(R.id.frs_manager_application_desc);
        WebPManager.setPureDrawable(this.G0, R.drawable.icon_mask_frs_apply14, R.color.CAM_X0101, null);
        this.H = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.m = LayoutInflater.from(this.f58431b.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.I0 = (HotRankEntryView) this.f58433d.findViewById(R.id.frs_hot_rank_entry);
        this.m.setVisibility(8);
        new d.b.i0.p0.m2.b(this.f58430a);
        this.D = (EMTextView) this.f58433d.findViewById(R.id.count_down);
    }

    @Override // d.b.i0.p0.q2.b
    public void A(View.OnClickListener onClickListener) {
        this.M.setOnClickListener(onClickListener);
        this.n.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.f58437h.setOnClickListener(onClickListener);
        this.r.setOnClickListener(onClickListener);
        HotRankEntryView hotRankEntryView = this.I0;
        if (hotRankEntryView != null) {
            hotRankEntryView.setOnClickListener(onClickListener);
        }
        View view = this.C0;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        View view2 = this.F0;
        if (view2 != null) {
            view2.setOnClickListener(onClickListener);
        }
    }

    @Override // d.b.i0.p0.q2.b
    public void B(ForumData forumData, FrsViewData frsViewData) {
        if (forumData == null) {
            return;
        }
        this.R = forumData.getName();
        this.S = forumData.getId();
        this.Y = forumData.getMember_num();
        this.Z = forumData.getPost_num();
        forumData.getTag_color();
        this.r0 = forumData.getImage_url();
        this.T = forumData.getLevelName();
        this.X = forumData.getUser_level();
        if (forumData.getSignData() != null) {
            int i = forumData.getSignData().count_sign_num;
            this.a0 = forumData.getSignData().miss_sign_num;
        }
        this.b0 = forumData.getCurScore();
        this.c0 = forumData.getLevelupScore();
        this.O = forumData.getBadgeData();
        this.U = forumData.getAccelerateContent();
        this.i0 = forumData.isBrandForum;
        this.V = frsViewData;
        if (!StringUtils.isNull(this.S) && !StringUtils.isNull(this.R)) {
            this.f58433d.setVisibility(0);
        } else {
            this.f58433d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.V;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.V.getHotUserRankData().hot_user != null && this.V.getHotUserRankData().hot_user.size() >= 3) {
            this.x.setHasHotRankList(true);
        } else {
            this.x.setHasHotRankList(false);
        }
        FrsViewData frsViewData3 = this.V;
        if ((frsViewData3 != null && frsViewData3.serviceAreaData != null && !d.b.h0.c1.b.c.d()) || this.x.a()) {
            this.x.setVisibility(0);
            this.z0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.x;
            FrsViewData frsViewData4 = this.V;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.x.setVisibility(8);
            this.z0.setVisibility(8);
        }
        this.W = new a2();
        V0();
        P0();
        W0(forumData);
        if (frsViewData != null) {
            this.F = frsViewData.mSignActivityInfo;
            H0();
        }
    }

    public final void E0(boolean z, boolean z2) {
        int g2;
        RelativeLayout relativeLayout = this.u;
        if (relativeLayout == null || relativeLayout.getLayoutParams() == null) {
            return;
        }
        if (this.I0.getVisibility() == 0) {
            g2 = d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds704);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds384);
            int r = d.b.b.e.p.l.r(this.f58430a.getPageActivity());
            ((RelativeLayout.LayoutParams) this.I0.getLayoutParams()).topMargin = (d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds226) + r) - d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds72);
        } else {
            g2 = d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds600);
        }
        if (!z && !z2 && !this.u0) {
            g2 -= d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds80);
        } else if (this.u0) {
            int g3 = d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds782);
            int L0 = L0(z, z2);
            g2 = g3 + L0;
            ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).bottomMargin = L0;
            ((RelativeLayout.LayoutParams) this.v0.getLayoutParams()).bottomMargin = L0;
            if (L0 != 0) {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds782) - d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds282);
            } else {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds493);
            }
        }
        ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
        if (layoutParams.height != g2) {
            layoutParams.height = g2;
            this.u.setLayoutParams(layoutParams);
        }
    }

    public final void F0() {
        boolean M0 = M0();
        boolean N0 = N0();
        if (!TextUtils.isEmpty(this.R)) {
            d.b.i0.p0.l2.e c2 = d.b.i0.p0.l2.d.d().c(this.R);
            if (c2 == null) {
                c2 = new d.b.i0.p0.l2.e(this.w0, M0);
            } else {
                c2.d(this.w0);
                c2.e(M0);
            }
            d.b.i0.p0.l2.d.d().e(this.R, c2);
        }
        G0(M0, N0);
        E0(M0, N0);
    }

    public final void G0(boolean z, boolean z2) {
        if (this.f58431b.z2() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x0.getLayoutParams();
        if (!z && !z2) {
            this.x0.setVisibility(0);
            this.z0.setVisibility(8);
            this.A0.setVisibility(8);
            layoutParams.topMargin = d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds50);
        } else {
            this.x0.setVisibility(0);
            this.z0.setVisibility(0);
            layoutParams.topMargin = d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds55);
        }
        this.f58431b.z2().s(z, z2);
    }

    public final void H0() {
        if (this.F == null) {
            return;
        }
        CountDownTimer countDownTimer = this.R0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.R0.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        this.O0 = ((long) (this.F.activity_time.intValue() + this.F.activity_duration.intValue())) - currentTimeMillis < 0;
        this.P0 = ((long) this.F.activity_time.intValue()) - currentTimeMillis <= 0;
        this.Q0 = ((long) (this.F.activity_time.intValue() - this.F.countdown_time.intValue())) - currentTimeMillis <= 0;
        boolean z = this.O0;
        if (z) {
            this.D.setVisibility(8);
            return;
        }
        if (this.P0 && !z) {
            Z0(this.F.activity_msg, 1000 * ((this.F.activity_time.intValue() + this.F.activity_duration.intValue()) - currentTimeMillis), this.M0);
        }
        if (!this.P0 && this.Q0) {
            this.D.setVisibility(0);
            this.D.setText(this.F.countdown_msg);
            SignActivityInfo signActivityInfo = this.F;
            Q0(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (this.Q0) {
            return;
        }
        SignActivityInfo signActivityInfo2 = this.F;
        Q0(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.F.countdown_time.intValue()) - currentTimeMillis);
    }

    public View I0() {
        return LayoutInflater.from(this.f58431b.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    public final int[] J0(int i) {
        return i <= 3 ? new int[]{-8331843, -10499102} : i <= 9 ? new int[]{-10499102, -154262} : i <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818};
    }

    public final LinearGradientView K0() {
        FrsFragment frsFragment = this.f58431b;
        if (frsFragment != null && frsFragment.z2() != null) {
            View A = this.f58431b.z2().A();
            if (A instanceof LinearGradientView) {
                return (LinearGradientView) A;
            }
        }
        return null;
    }

    public final int L0(boolean z, boolean z2) {
        List<n> list;
        List<b0> list2;
        int i = 0;
        if (z2) {
            d.b.i0.c3.a0 a0Var = this.V.serviceAreaData;
            if (a0Var != null && (list2 = a0Var.f53316b) != null && list2.size() == 1) {
                i = 0 + d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds83);
            } else {
                i = 0 + d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds84);
            }
        }
        if (z && (list = this.J0) != null) {
            i += Math.min(list.size(), 2) * d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds83);
        }
        if (this.y.getVisibility() == 0) {
            i += d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds231);
        }
        return (z2 || z || this.y.getVisibility() == 0) ? i + d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds45) : i;
    }

    @Override // d.b.i0.p0.q2.b
    @SuppressLint({"ResourceAsColor"})
    public void M(View view, boolean z) {
        if (this.d0 == 0 && TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) == null || z) {
                return;
            }
            View inflate = LayoutInflater.from(this.f58430a.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0105, 1);
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f58430a.getPageActivity());
            aVar.setContentView(inflate);
            C(textView, textView2);
            if (!TextUtils.isEmpty(this.U) && !TextUtils.isEmpty(this.U.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.U);
            } else {
                textView3.setVisibility(8);
            }
            aVar.setButtonTextColor(R.color.CAM_X0305);
            S0(aVar);
            T0(aVar);
            aVar.create(this.f58430a);
            aVar.show();
            return;
        }
        this.f58432c.removeCallbacks(this.l0);
        if (this.G == null) {
            PopupWindow popupWindow = new PopupWindow(this.f58430a.getPageActivity());
            this.G = popupWindow;
            popupWindow.setContentView(this.H);
            this.G.setBackgroundDrawable(new BitmapDrawable());
            this.G.setOutsideTouchable(true);
            this.G.setFocusable(true);
            this.G.setWidth(this.f58430a.getResources().getDimensionPixelSize(R.dimen.ds228));
            this.G.setHeight(this.f58430a.getResources().getDimensionPixelSize(R.dimen.ds100));
        }
        this.I = (TextView) this.H.findViewById(R.id.cur_experience);
        this.J = (TextView) this.H.findViewById(R.id.levelup_experience);
        SkinManager.setBackgroundResource(this.H.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
        SkinManager.setViewTextColor((TextView) this.H.findViewById(R.id.experience), R.color.CAM_X0111, 1);
        SkinManager.setViewTextColor(this.I, R.color.common_color_10047, 1);
        SkinManager.setViewTextColor(this.J, R.color.CAM_X0111, 1);
        C(this.I, this.J);
        if (this.G.isShowing()) {
            d.b.b.e.m.g.d(this.G, this.f58430a.getPageActivity());
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr[1] - this.G.getHeight() <= 50) {
            d.b.b.e.m.g.d(this.G, this.f58430a.getPageActivity());
            return;
        }
        PopupWindow popupWindow2 = this.G;
        d.b.b.e.m.g.m(popupWindow2, this.f58433d, 0, iArr[0], iArr[1] - popupWindow2.getHeight());
        this.G.update();
        this.f58432c.postDelayed(this.l0, 2000L);
    }

    public final boolean M0() {
        FrsTopView frsTopView = this.A;
        return frsTopView != null && frsTopView.getVisibility() == 0;
    }

    @Override // d.b.i0.p0.q2.b
    public void N() {
        FrsViewData frsViewData;
        String string;
        String str;
        if (this.L0 == -1 || (frsViewData = this.V) == null || frsViewData.forumRule == null || frsViewData.getUserData() == null || this.A == null) {
            return;
        }
        if (this.V.getUserData().getIs_manager() == 1) {
            if (this.V.forumRule.has_forum_rule.intValue() == 1 || this.V.forumRule.audit_status.intValue() != 0) {
                return;
            }
            string = this.f58430a.getString(R.string.frs_top_forum_rules_setting);
            str = "key_forum_rule_first_show_frs_manager";
        } else {
            string = this.f58430a.getString(R.string.frs_top_forum_rules_setting_has_pass);
            str = "key_forum_rule_first_show_frs";
        }
        View view = null;
        if (this.A.getmTopViews() != null && this.A.getmTopViews().size() > 0 && (this.A.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
            AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.A.getmTopViews().get(0);
            if (this.L0 < adapterLinearLayout.getChildCount()) {
                view = adapterLinearLayout.getChildAt(this.L0);
            }
        }
        if (this.K0 != null || view == null) {
            return;
        }
        d.b.i0.b0.e eVar = new d.b.i0.b0.e(this.f58430a, view);
        this.K0 = eVar;
        eVar.c0(R.drawable.bg_tip_blue_up_left);
        this.K0.N(16);
        this.K0.T(true);
        this.K0.f0(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
        this.K0.g0(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
        this.K0.d0(true);
        this.K0.M(4000);
        if (this.K0.I() || this.f58431b.u2()) {
            return;
        }
        this.K0.i0(string, str);
    }

    public final boolean N0() {
        ServiceAreaView serviceAreaView = this.x;
        return serviceAreaView != null && serviceAreaView.getVisibility() == 0;
    }

    @Override // d.b.i0.p0.q2.b
    public void O() {
        View contentView;
        PopupWindow popupWindow = this.L;
        if (popupWindow == null) {
            this.L = new PopupWindow(this.f58430a.getPageActivity());
            contentView = LayoutInflater.from(this.f58430a.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.L.setContentView(contentView);
            contentView.setOnClickListener(new e());
            this.L.setWidth(this.f58430a.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.L.setHeight(this.f58430a.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.L.setBackgroundDrawable(new BitmapDrawable());
            this.L.setOutsideTouchable(true);
            this.L.setTouchInterceptor(new f());
        } else {
            contentView = popupWindow.getContentView();
        }
        SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.CAM_X0305, 1);
        SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.CAM_X0101, 1);
        int[] iArr = new int[2];
        this.K.getLocationOnScreen(iArr);
        PopupWindow popupWindow2 = this.L;
        d.b.b.e.m.g.m(popupWindow2, this.f58433d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.K.getWidth() / 2), iArr[1] + this.K.getWidth());
        this.L.update();
    }

    public final void O0(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        ThemeElement themeElement3;
        FrsViewData frsViewData = this.V;
        if (frsViewData == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || (themeElement = themeColorInfo.day) == null || (themeElement2 = themeColorInfo.night) == null || (themeElement3 = themeColorInfo.dark) == null) {
            return;
        }
        if (i == 4) {
            themeElement = themeElement3;
        } else if (i == 1) {
            themeElement = themeElement2;
        }
        if (!this.u0) {
            LinearGradientView K0 = K0();
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null && K0 != null) {
                ThemeElement themeElement4 = themeColorInfo.day;
                String str = themeElement4.light_color;
                String str2 = themeElement4.dark_color;
                ThemeElement themeElement5 = themeColorInfo.night;
                String str3 = themeElement5.light_color;
                String str4 = themeElement5.dark_color;
                ThemeElement themeElement6 = themeColorInfo.dark;
                linearGradientView.setGradientColor(str, str2, str3, str4, themeElement6.light_color, themeElement6.dark_color);
            }
            TbImageView tbImageView = this.w;
            if (tbImageView != null) {
                tbImageView.W(themeElement.pattern_image, 10, false);
            }
        }
        ServiceAreaView serviceAreaView = this.x;
        if (serviceAreaView != null) {
            serviceAreaView.setThemeFontColor(d.b.i0.i1.o.k.b.b(themeElement.common_color));
        }
        if (this.A != null) {
            this.A.setUrlAndColor(forum.getTopIcon(), d.b.i0.i1.o.k.b.b(themeElement.common_color));
        }
    }

    public void P0() {
        TextView textView = this.f58434e;
        if (textView != null) {
            textView.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.Y));
        }
        TextView textView2 = this.f58435f;
        if (textView2 != null) {
            textView2.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.Z));
        }
        ArrayList<k> arrayList = this.O;
        if (arrayList != null && arrayList.size() > 0) {
            this.R = UtilHelper.getFixedText(this.R, 7);
        } else if (this.i0) {
            this.R = UtilHelper.getFixedText(this.R, 6);
        }
        String str = this.R + this.f58430a.getString(R.string.forum);
        TextView textView3 = this.f58436g;
        if (textView3 != null) {
            textView3.setText(str);
        }
        TextView textView4 = this.n;
        if (textView4 != null) {
            textView4.setText(str);
        }
        R0();
        boolean Y0 = Y0();
        this.u0 = Y0;
        if (Y0) {
            this.v.setVisibility(8);
            this.v0.setVisibility(0);
        } else {
            this.v0.setVisibility(8);
            this.v.setVisibility(0);
            this.w.setOnClickListener(null);
        }
        x();
        O0(TbadkCoreApplication.getInst().getSkinType());
        F0();
    }

    @Override // d.b.i0.p0.q2.b
    public void Q() {
    }

    public final void Q0(String str, long j) {
        this.E = false;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.N0 = newScheduledThreadPool;
        newScheduledThreadPool.schedule(new h(str), j, TimeUnit.SECONDS);
    }

    public void R0() {
        this.M.W(this.r0, 10, false);
    }

    @Override // d.b.i0.p0.q2.b
    public void S() {
        if (this.d0 != 0) {
            SkinManager.setImageResource(this.K, R.drawable.icon_sml_speed_orange);
        } else {
            SkinManager.setImageResource(this.K, R.drawable.icon_sml_speed_gray);
        }
    }

    public void S0(d.b.h0.r.s.a aVar) {
        aVar.setNegativeButton(R.string.cancel, new c(this));
    }

    public void T0(d.b.h0.r.s.a aVar) {
        aVar.setPositiveButton(R.string.open_now, new d());
    }

    public void U0() {
        d.b.i0.p0.n2.f fVar = this.Q;
        if (fVar != null) {
            fVar.p();
        }
    }

    public void V0() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.r0);
        this.W.K0().add(mediaData);
    }

    public final void W0(ForumData forumData) {
        if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
            String str = forumData.getManagers().get(0).show_name;
            if (TextUtils.isEmpty(str)) {
                str = forumData.getManagers().get(0).name;
            }
            if (!TextUtils.isEmpty(str)) {
                this.E0.setText(str);
                this.D0.W(forumData.getManagers().get(0).portrait, 12, false);
                this.C0.setVisibility(0);
            } else {
                this.C0.setVisibility(8);
            }
            if (this.F0.getVisibility() == 0) {
                this.F0.setVisibility(8);
                return;
            }
            return;
        }
        if (this.C0.getVisibility() == 0) {
            this.C0.setVisibility(8);
        }
        if (this.F0.getVisibility() == 8) {
            this.F0.setVisibility(0);
        }
    }

    public final void X0(List<n> list, i iVar) {
        if (this.A == null) {
            return;
        }
        this.J0 = list;
        if (iVar != null) {
            this.z = new d.b.i0.p0.h1.g(this.f58430a.getPageActivity());
            this.y.setVisibility(0);
            this.y.addView(this.z.e());
            FrsViewData frsViewData = this.V;
            this.z.d(frsViewData != null ? frsViewData.getForum() : null, iVar);
        } else {
            this.y.setVisibility(8);
        }
        FrsFragment frsFragment = this.f58431b;
        if (frsFragment != null && frsFragment.O2()) {
            this.A.setVisibility(0);
            this.A.setFragmentUniqueId(this.f58431b.getUniqueId());
            FrsViewData frsViewData2 = this.V;
            ForumData forum = frsViewData2 != null ? frsViewData2.getForum() : null;
            FrsViewData frsViewData3 = this.V;
            this.A.setForum(this.S, this.R, forum, frsViewData3 != null ? frsViewData3.getUserData() : null, this.f58431b.q2());
            if (list.size() > 0 && (list.get(0) instanceof p)) {
                this.L0 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof p)) {
                this.L0 = 1;
            } else {
                this.L0 = -1;
            }
            this.A.setDatas(list, iVar);
            if (this.t0 == null) {
                this.t0 = new a();
            }
            this.A.setStatListener(this.t0);
            return;
        }
        this.A.setVisibility(8);
    }

    public final boolean Y0() {
        a0 a0Var;
        FrsViewData frsViewData = this.V;
        if (frsViewData == null) {
            return false;
        }
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
            a0Var = new a0();
            a0Var.l("");
            a0Var.k(frsViewData.getStar().a());
        } else {
            a0Var = (frsViewData.getActivityHeadData() == null || ListUtils.getCount(frsViewData.getActivityHeadData().a()) < 1) ? null : frsViewData.getActivityHeadData().a().get(0);
        }
        if (a0Var != null) {
            if (this.w != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().b())) {
                    StatisticItem statisticItem = new StatisticItem("c13326");
                    statisticItem.param("fid", frsViewData.getForum().getId());
                    statisticItem.param("obj_id", frsViewData.getActivityHeadData().b());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("common_exp");
                    statisticItem2.param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("fid", frsViewData.getForum().getId()).param("obj_id", frsViewData.getActivityHeadData().b()).param(TiebaStatic.Params.OBJ_AD_LOCATE, 1).param(TiebaStatic.Params.FIRST_DIR, frsViewData.getForum().getFirst_class()).param(TiebaStatic.Params.SECOND_DIR, frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
                    }
                    d.b.i0.b3.c.g().d(this.f58431b.getUniqueId(), d.b.i0.b3.a.c("", frsViewData.getActivityHeadData().b(), "", null), statisticItem2);
                }
                this.w.W(a0Var.d(), 10, false);
                if (!TextUtils.isEmpty(a0Var.e())) {
                    this.w.setOnClickListener(new View$OnClickListenerC1402b(frsViewData, a0Var));
                }
            }
            return true;
        }
        return false;
    }

    public final void Z0(String str, long j, long j2) {
        this.E = true;
        this.R0 = new g(j, j2, str).start();
        if (this.P == null || h()) {
            return;
        }
        this.P.q(this.E);
    }

    @Override // d.b.i0.p0.q2.b
    public void b() {
        this.o.setVisibility(0);
    }

    @Override // d.b.i0.p0.q2.b
    public void c(int i) {
        this.f58430a.getLayoutMode().k(i == 1);
        this.f58430a.getLayoutMode().j(this.f58433d);
        this.f58430a.getLayoutMode().j(this.H);
        this.f58430a.getLayoutMode().j(this.m);
        SkinManager.setBackgroundResource(this.k, R.drawable.frs_exp_progress);
        SkinManager.setBackgroundResource(this.y0, R.drawable.bg_frs_header_round_corner);
        SkinManager.setBackgroundColor(this.z0, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.A0, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.A, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.B, R.color.CAM_X0624);
        SkinManager.setBackgroundColor(this.B0, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.t, R.color.black_alpha0);
        SkinManager.setBackgroundColor(this.o0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.p0, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f58434e, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.q0, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f58435f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.E0, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.H0, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f58435f, R.color.CAM_X0101);
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.D);
        a2.s(R.string.F_X01);
        a2.n(R.color.CAM_X0101);
        BarImageView barImageView = this.M;
        if (barImageView != null) {
            barImageView.setBorderWidth(d.b.b.e.p.l.g(this.f58430a.getPageActivity(), R.dimen.tbds1));
            this.M.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
            this.M.setStrokeColorResId(R.color.CAM_X0201);
            this.M.setPlaceHolder(1);
            this.M.invalidate();
        }
        HeadImageView headImageView = this.D0;
        if (headImageView != null) {
            headImageView.invalidate();
        }
        UserIconBox userIconBox = this.N;
        if (userIconBox != null) {
            userIconBox.i(i);
        }
        LinearGradientView linearGradientView = this.v;
        if (linearGradientView != null) {
            linearGradientView.a(i);
        }
        Iterator<TbImageView> it = this.s0.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        S();
        F(this.g0 ? 1 : 0);
        U0();
        O0(i);
        E0(M0(), N0());
        ServiceAreaView serviceAreaView = this.x;
        if (serviceAreaView != null) {
            serviceAreaView.b(i);
        }
        FrsTopView frsTopView = this.A;
        if (frsTopView != null) {
            frsTopView.i(i);
        }
        d.b.i0.p0.h1.g gVar = this.z;
        if (gVar != null) {
            gVar.g(i);
        }
        HotRankEntryView hotRankEntryView = this.I0;
        if (hotRankEntryView != null) {
            hotRankEntryView.b(i);
        }
    }

    @Override // d.b.i0.p0.q2.b
    public String d() {
        SignActivityInfo signActivityInfo = this.F;
        if (signActivityInfo != null) {
            return String.valueOf(signActivityInfo.activity_id);
        }
        return null;
    }

    @Override // d.b.i0.p0.q2.b
    public SignActivityInfo j() {
        return this.F;
    }

    @Override // d.b.i0.p0.q2.b
    public void m() {
        d.b.i0.b0.e eVar = this.K0;
        if (eVar != null) {
            eVar.H();
            this.L0 = -1;
        }
    }

    @Override // d.b.i0.p0.q2.b
    public boolean p() {
        return this.E;
    }

    @Override // d.b.i0.p0.q2.b
    public void r() {
        super.r();
        Handler handler = this.f58432c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        PopupWindow popupWindow = this.L;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.L.dismiss();
        }
        m();
        d.b.i0.p0.h1.g gVar = this.z;
        if (gVar != null) {
            gVar.h();
        }
        CountDownTimer countDownTimer = this.R0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.R0 = null;
        }
    }

    @Override // d.b.i0.p0.q2.b
    public void s(boolean z) {
        super.s(z);
        d.b.i0.p0.h1.g gVar = this.z;
        if (gVar != null) {
            gVar.i(z);
        }
    }

    @Override // d.b.i0.p0.q2.b
    public void v(boolean z, float f2) {
        int i;
        this.h0 = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap == null || this.j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
            return;
        }
        if (this.h0) {
            this.j.setText(R.string.level_up);
            if (f2 >= 1.0f) {
                i = this.X;
            } else {
                i = this.X + 1;
            }
            FrsViewData S = this.f58431b.S();
            if (S != null && S.getForum() != null) {
                S.getForum().setUser_level(i);
            }
            this.s.setText(this.f58430a.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
        } else {
            this.j.setText(this.T);
            this.s.setText(this.f58430a.getResources().getString(R.string.lv_num, Integer.valueOf(this.X)));
        }
        this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, J0(this.X)));
        if (!this.h0) {
            R(this.k, this.j0, f2);
        } else if (f2 >= 1.0f) {
            R(this.k, this.j0, f2);
        } else {
            P(this.k, this.j0, f2);
        }
        this.j0 = f2;
    }

    @Override // d.b.i0.p0.q2.b
    public void w() {
        this.A.j(this.L0);
    }

    @Override // d.b.i0.p0.q2.b
    public void x() {
        FrsViewData frsViewData;
        if (this.f58431b == null || (frsViewData = this.V) == null) {
            return;
        }
        List<n> showTopThreadList = frsViewData.getShowTopThreadList();
        this.w0 = showTopThreadList.size() > 2;
        X0(showTopThreadList, this.V.getBusinessPromot());
    }

    @Override // d.b.i0.p0.q2.b
    public void y() {
        d.b.i0.p0.n2.g gVar = this.P;
        if (gVar != null) {
            gVar.o(this.a0);
        }
    }

    @Override // d.b.i0.p0.q2.b
    public void z() {
        d.b.i0.p0.n2.g gVar = this.P;
        if (gVar != null) {
            gVar.q(this.E);
        }
    }
}
