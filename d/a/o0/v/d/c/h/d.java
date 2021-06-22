package d.a.o0.v.d.c.h;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Build;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.l;
import d.a.n0.r.s.a;
import d.a.o0.v.d.c.e.h;
import d.a.o0.v.d.c.e.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.o0.z.b<i> {
    public LinearLayout A;
    public ImageView B;
    public TextView C;
    public ImageView D;
    public ImageView E;
    public ImageView F;
    public RotateAnimation G;
    public ObjectAnimator H;
    public int I;
    public List<h.a> J;
    public String K;
    public d.a.o0.m3.d L;
    public View m;
    public LinearLayout n;
    public HeadImageView o;
    public ImageView p;
    public TextView q;
    public LinearLayout r;
    public ImageView s;
    public TextView t;
    public LinearLayout u;
    public ImageView v;
    public TextView w;
    public LinearLayout x;
    public ImageView y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            d.this.u();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.n0.d.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaPersonCenterActivityConfig f65475a;

        public b(d dVar, AlaPersonCenterActivityConfig alaPersonCenterActivityConfig) {
            this.f65475a = alaPersonCenterActivityConfig;
        }

        @Override // d.a.n0.d.f
        public void onFail() {
            onSwitchGet(false);
        }

        @Override // d.a.n0.d.f
        public void onSwitchGet(boolean z) {
            if (z) {
                if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                    UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{UrlSchemaHelper.GO_TO_YY_PERSONAL_CENTER_PAGE});
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.f65475a));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c(d dVar) {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* renamed from: d.a.o0.v.d.c.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1711d implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f65476a;

        public C1711d(d dVar, TbPageContext tbPageContext) {
            this.f65476a = tbPageContext;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
            d.a.c.e.i.a.k().g(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.f65476a.getPageActivity(), null, "0", TbadkCoreApplication.getCurrentAccount(), null)));
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.I = -1;
        this.J = new ArrayList();
        v();
    }

    public final void A() {
        this.p.setVisibility(8);
        this.E.setVisibility(0);
        this.F.setVisibility(0);
        this.o.setVisibility(0);
        this.E.clearAnimation();
        RotateAnimation rotateAnimation = this.G;
        if (rotateAnimation != null) {
            this.E.startAnimation(rotateAnimation);
        }
        ObjectAnimator objectAnimator = this.H;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.H.cancel();
            }
            this.H.start();
        }
    }

    public final void B() {
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.o.setVisibility(8);
        this.E.clearAnimation();
        ObjectAnimator objectAnimator = this.H;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0202);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.z, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.C, R.color.CAM_X0107);
        SkinManager.setImageResource(this.s, R.drawable.super_entrance_ranklist_bg_selector);
        SkinManager.setImageResource(this.v, R.drawable.super_entrance_discuss_bg_selector);
        SkinManager.setImageResource(this.y, R.drawable.super_entrance_person_bg_selector);
        SkinManager.setImageResource(this.B, R.drawable.super_entrance_start_recorder_bg_selector);
        SkinManager.setImageResource(this.F, R.drawable.pic_live_tab_quan);
        if (8 == this.E.getVisibility()) {
            this.p.setVisibility(0);
            this.F.setVisibility(8);
            SkinManager.setBackgroundResource(this.p, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.n) {
            if (ViewHelper.checkUpIsLogin(this.f67285g)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveTabMyConcernActivityConfig(k().getPageActivity())));
            }
            StatisticItem statisticItem = new StatisticItem("c13552");
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        } else if (view == this.r) {
            if (StringUtils.isNull(this.K)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f67284f, new String[]{this.K});
            StatisticItem statisticItem2 = new StatisticItem("c13553");
            TiebaStaticHelper.addYYParam(statisticItem2);
            TiebaStatic.log(statisticItem2);
        } else if (view == this.u) {
            String str = "http://tieba.baidu.com/f?kw=百度直播";
            String p = d.a.n0.r.d0.b.j().p("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            if (!StringUtils.isNull(p) && p.startsWith("http")) {
                str = p;
            }
            if (!str.contains("?")) {
                str = str + "?default_tab_id=1&call_from=15";
            } else if (!str.contains("&default_tab_id=")) {
                str = str + "&default_tab_id=1&call_from=15";
            }
            UrlManager.getInstance().dealOneLink(this.f67284f, new String[]{str}, true);
            StatisticItem statisticItem3 = new StatisticItem("c13554");
            TiebaStaticHelper.addYYParam(statisticItem3);
            TiebaStatic.log(statisticItem3);
        } else if (view == this.x) {
            if (ViewHelper.checkUpIsLogin(this.f67285g)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new b(this, new AlaPersonCenterActivityConfig(this.f67284f.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true))));
            }
            StatisticItem statisticItem4 = new StatisticItem("c13555");
            TiebaStaticHelper.addYYParam(statisticItem4);
            TiebaStatic.log(statisticItem4);
        } else if (view == this.A) {
            z();
            TiebaStatic.log("c13617");
        }
    }

    public final void u() {
        if (this.o == null || ListUtils.isEmpty(this.J)) {
            return;
        }
        this.I++;
        int size = this.J.size();
        int i2 = this.I;
        if (size > i2) {
            this.o.U(this.J.get(i2).f65350a, 12, false);
        } else if (this.J.size() > 0) {
            this.I = 0;
            this.o.U(this.J.get(0).f65350a, 12, false);
        }
    }

    public final void v() {
        View m = m();
        this.m = m;
        this.n = (LinearLayout) m.findViewById(R.id.entrance_follow);
        this.r = (LinearLayout) this.m.findViewById(R.id.entrance_ranklist);
        this.u = (LinearLayout) this.m.findViewById(R.id.entrance_discuss);
        this.x = (LinearLayout) this.m.findViewById(R.id.entrance_person_center);
        this.E = (ImageView) this.m.findViewById(R.id.entrance_follow_img_diandian);
        this.A = (LinearLayout) this.m.findViewById(R.id.entrance_start_recorder);
        HeadImageView headImageView = (HeadImageView) this.m.findViewById(R.id.entrance_follow_img);
        this.o = headImageView;
        headImageView.setIsRound(true);
        this.o.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.o.setDefaultResource(17170445);
        this.o.setDefaultBgResource(17170445);
        this.F = (ImageView) this.m.findViewById(R.id.entrance_follow_circle);
        this.p = (ImageView) this.m.findViewById(R.id.entrance_follow_default_img);
        this.s = (ImageView) this.m.findViewById(R.id.entrance_ranklist_img);
        this.v = (ImageView) this.m.findViewById(R.id.entrance_discuss_img);
        this.y = (ImageView) this.m.findViewById(R.id.entrance_person_center_img);
        this.B = (ImageView) this.m.findViewById(R.id.entrance_start_recorder_img);
        this.q = (TextView) this.m.findViewById(R.id.entrance_follow_desc);
        this.t = (TextView) this.m.findViewById(R.id.entrance_ranklist_desc);
        this.w = (TextView) this.m.findViewById(R.id.entrance_discuss_desc);
        this.z = (TextView) this.m.findViewById(R.id.entrance_person_center_desc);
        this.C = (TextView) this.m.findViewById(R.id.entrance_start_recorder_desc);
        this.D = (ImageView) this.m.findViewById(R.id.entrance_publish_live_red);
        this.n.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.A.setOnClickListener(this);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.G = rotateAnimation;
        rotateAnimation.setDuration(6000L);
        this.G.setRepeatMode(1);
        this.G.setRepeatCount(-1);
        this.G.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.o, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.H = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        this.H.setTarget(this.o);
        this.H.setRepeatCount(-1);
        this.H.setRepeatMode(1);
        this.H.setDuration(2000L);
        this.H.addListener(new a());
        o(this.f67284f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void w(boolean z) {
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (z) {
            if (!d.a.n0.r.d0.b.j().g(d.a.n0.r.d0.b.n("square_live_publish_live_has_showed"), false)) {
                d.a.n0.r.d0.b.j().t(d.a.n0.r.d0.b.n("square_live_publish_live_has_showed"), true);
                this.D.setVisibility(0);
                return;
            }
            this.D.setVisibility(8);
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: x */
    public void n(i iVar) {
        this.x.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
        this.A.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
        this.A.setVisibility(TbSingleton.getInstance().isAuditPackageSwitchOn() ? 0 : 8);
        if (iVar != null && iVar.f65352e != null) {
            if (TbSingleton.getInstance().isShowStartLiveEntry()) {
                StatisticItem statisticItem = new StatisticItem("c13550");
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
            StatisticItem statisticItem2 = new StatisticItem("c13549");
            TiebaStaticHelper.addYYParam(statisticItem2);
            TiebaStatic.log(statisticItem2);
            StatisticItem statisticItem3 = new StatisticItem("c13547");
            TiebaStaticHelper.addYYParam(statisticItem3);
            TiebaStatic.log(statisticItem3);
            StatisticItem statisticItem4 = new StatisticItem("c13546");
            TiebaStaticHelper.addYYParam(statisticItem4);
            TiebaStatic.log(statisticItem4);
            h hVar = iVar.f65352e;
            this.K = hVar.f65349c;
            if (hVar.f65347a && !ListUtils.isEmpty(hVar.f65348b)) {
                ArrayList<h.a> arrayList = iVar.f65352e.f65348b;
                this.J = arrayList;
                if (ListUtils.isEmpty(arrayList)) {
                    return;
                }
                A();
                u();
                return;
            }
            B();
            return;
        }
        B();
    }

    public final void y(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new C1711d(this, tbPageContext));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public final void z() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(k().getPageActivity());
            aVar.setAutoNight(false);
            aVar.setTitle(R.string.prompt);
            aVar.setMessage(b().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.know, new c(this));
            aVar.create(k()).show();
        } else if (ViewHelper.checkUpIsLogin(k().getPageActivity())) {
            if (this.L == null) {
                this.L = new d.a.o0.m3.d(k());
            }
            if (this.L.d()) {
                return;
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                l.L(k().getPageActivity(), R.string.plugin_config_not_found);
                return;
            }
            d.a.n0.r.d0.b.j().t(d.a.n0.r.d0.b.n("square_live_publish_live_has_showed"), true);
            this.D.setVisibility(8);
            y(k());
        }
    }
}
