package d.b.i0.t.d.c.h;

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
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.c.e.p.l;
import d.b.h0.r.s.a;
import d.b.i0.t.d.c.e.h;
import d.b.i0.t.d.c.e.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.b.i0.x.b<i> {
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
    public d.b.i0.l3.d L;
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
            d.this.v();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b(d dVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f62018a;

        public c(d dVar, TbPageContext tbPageContext) {
            this.f62018a = tbPageContext;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
            d.b.c.e.i.a.l().h(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.f62018a.getPageActivity(), null, "0", TbadkCoreApplication.getCurrentAccount(), null)));
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.I = -1;
        this.J = new ArrayList();
        w();
    }

    public final void A() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(l().getPageActivity());
            aVar.setAutoNight(false);
            aVar.setTitle(R.string.prompt);
            aVar.setMessage(b().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.know, new b(this));
            aVar.create(l()).show();
        } else if (ViewHelper.checkUpIsLogin(l().getPageActivity())) {
            if (this.L == null) {
                this.L = new d.b.i0.l3.d(l());
            }
            if (this.L.d()) {
                return;
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                l.K(l().getPageActivity(), R.string.plugin_config_not_found);
                return;
            }
            d.b.h0.r.d0.b.j().t(d.b.h0.r.d0.b.n("square_live_publish_live_has_showed"), true);
            this.D.setVisibility(8);
            z(l());
        }
    }

    public final void B() {
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

    public final void E() {
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.o.setVisibility(8);
        this.E.clearAnimation();
        ObjectAnimator objectAnimator = this.H;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.q, R.drawable.tab_super_entrance_txt_selecor);
        SkinManager.setViewTextColor(this.t, R.drawable.tab_super_entrance_txt_selecor);
        SkinManager.setViewTextColor(this.w, R.drawable.tab_super_entrance_txt_selecor);
        SkinManager.setViewTextColor(this.z, R.drawable.tab_super_entrance_txt_selecor);
        SkinManager.setViewTextColor(this.C, R.drawable.tab_super_entrance_txt_selecor);
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
            if (ViewHelper.checkUpIsLogin(this.f63757g)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveTabMyConcernActivityConfig(l().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.r) {
            if (StringUtils.isNull(this.K)) {
                return;
            }
            d.b.h0.l.a.r(this.f63757g.getApplicationContext(), b().getResources().getString(R.string.entrance_ranklist_tip), this.K, true, true, true, true, true, true, true);
            TiebaStatic.log("c13553");
        } else if (view == this.u) {
            String str = "http://tieba.baidu.com/f?kw=百度直播";
            String p = d.b.h0.r.d0.b.j().p("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            if (!StringUtils.isNull(p) && p.startsWith("http")) {
                str = p;
            }
            if (!str.contains("?")) {
                str = str + "?default_tab_id=1&call_from=15";
            } else if (!str.contains("&default_tab_id=")) {
                str = str + "&default_tab_id=1&call_from=15";
            }
            UrlManager.getInstance().dealOneLink(this.f63756f, new String[]{str}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.x) {
            if (ViewHelper.checkUpIsLogin(this.f63757g)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.f63756f.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.A) {
            A();
            TiebaStatic.log("c13617");
        }
    }

    public final void v() {
        if (this.o == null || ListUtils.isEmpty(this.J)) {
            return;
        }
        this.I++;
        int size = this.J.size();
        int i = this.I;
        if (size > i) {
            this.o.W(this.J.get(i).f61901a, 12, false);
        } else if (this.J.size() > 0) {
            this.I = 0;
            this.o.W(this.J.get(0).f61901a, 12, false);
        }
    }

    public final void w() {
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
        o(this.f63756f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void x(boolean z) {
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (z) {
            if (!d.b.h0.r.d0.b.j().g(d.b.h0.r.d0.b.n("square_live_publish_live_has_showed"), false)) {
                d.b.h0.r.d0.b.j().t(d.b.h0.r.d0.b.n("square_live_publish_live_has_showed"), true);
                this.D.setVisibility(0);
                return;
            }
            this.D.setVisibility(8);
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: y */
    public void n(i iVar) {
        if (iVar != null && iVar.f61903e != null) {
            TiebaStatic.log("c13550");
            TiebaStatic.log("c13549");
            TiebaStatic.log("c13547");
            TiebaStatic.log("c13546");
            d.b.i0.t.d.c.e.h hVar = iVar.f61903e;
            this.K = hVar.f61900c;
            if (hVar.f61898a && !ListUtils.isEmpty(hVar.f61899b)) {
                ArrayList<h.a> arrayList = iVar.f61903e.f61899b;
                this.J = arrayList;
                if (ListUtils.isEmpty(arrayList)) {
                    return;
                }
                B();
                v();
                return;
            }
            E();
            return;
        }
        E();
    }

    public final void z(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new c(this, tbPageContext));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }
}
