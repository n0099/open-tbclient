package d.a.i0.z0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f50117f = false;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<WeakReference<Activity>> f50118a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<WeakReference<Activity>> f50119b;

    /* renamed from: c  reason: collision with root package name */
    public int f50120c;

    /* renamed from: d  reason: collision with root package name */
    public final CustomMessageListener f50121d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.i0.m.g f50122e;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int skinType;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer) || e.this.f50120c == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
                return;
            }
            e.this.f50120c = skinType;
            if (e.f50117f) {
                e.this.s();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.i0.m.g {
        public b() {
        }

        @Override // d.a.i0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            e.this.f50119b.add(new WeakReference(activity));
        }

        @Override // d.a.i0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Iterator it = e.this.f50119b.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() != null && weakReference.get() == activity) {
                    e.this.f50119b.remove(weakReference);
                    return;
                }
            }
        }

        @Override // d.a.i0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (e.f50117f) {
                e eVar = e.this;
                if (eVar.j(eVar.l(activity))) {
                    e.this.f50118a.add(new WeakReference(activity));
                }
            }
        }

        @Override // d.a.i0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (e.f50117f) {
                e eVar = e.this;
                if (eVar.u(eVar.l(activity))) {
                    Iterator it = e.this.f50118a.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (activity != null && activity == weakReference.get()) {
                            e.this.f50118a.remove(weakReference);
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.r(view.getContext());
            e.this.v(false);
            e.this.k();
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final e f50126a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static final e m() {
        return d.f50126a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    public final boolean j(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return false;
        }
        try {
            Object tag = frameLayout.getTag(R.id.tag_scheme_baidu_box_app_back_view);
            ViewGroup viewGroup = 0;
            ViewGroup viewGroup2 = tag instanceof ViewGroup ? (ViewGroup) tag : null;
            if (viewGroup2 == null || viewGroup2.getParent() == null) {
                viewGroup = viewGroup2;
            } else if (viewGroup2.getParent() == frameLayout) {
                return false;
            } else {
                frameLayout.setTag(R.id.tag_scheme_baidu_box_app_back_view, null);
            }
            if (viewGroup == null) {
                viewGroup = o(frameLayout.getContext());
            }
            if (viewGroup == null) {
                return false;
            }
            frameLayout.addView(viewGroup);
            frameLayout.setTag(R.id.tag_scheme_baidu_box_app_back_view, viewGroup);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds339), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds89));
            layoutParams.gravity = 83;
            layoutParams.bottomMargin = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds442) + UtilHelper.getNavigationBarHeight(frameLayout.getContext());
            viewGroup.setLayoutParams(layoutParams);
            c cVar = new c();
            viewGroup.setClickable(true);
            viewGroup.setOnClickListener(cVar);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void k() {
        BackBaiduBoxViewEvent backBaiduBoxViewEvent = new BackBaiduBoxViewEvent();
        backBaiduBoxViewEvent.isShow = f50117f;
        d.a.i0.f0.h.i(backBaiduBoxViewEvent);
    }

    public final FrameLayout l(Activity activity) {
        if (activity != null) {
            try {
                if (!activity.isFinishing() && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                    View decorView = activity.getWindow().getDecorView();
                    if (decorView instanceof FrameLayout) {
                        return (FrameLayout) decorView;
                    }
                    return null;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void n(boolean z) {
        FrameLayout l;
        if (f50117f && (l = l(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            try {
                Object tag = l.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                if (tag instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) tag;
                    if (z) {
                        viewGroup.bringToFront();
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds339), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds89));
                        layoutParams.gravity = 83;
                        layoutParams.bottomMargin = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds207);
                        viewGroup.setLayoutParams(layoutParams);
                    } else {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds339), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds89));
                        layoutParams2.gravity = 83;
                        layoutParams2.bottomMargin = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds442) + UtilHelper.getNavigationBarHeight(l.getContext());
                        viewGroup.setLayoutParams(layoutParams2);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final ViewGroup o(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_baiduboxapp_back_view, (ViewGroup) null);
        p(viewGroup, context);
        return viewGroup;
    }

    public final void p(ViewGroup viewGroup, Context context) {
        if (viewGroup == null || context == null) {
            return;
        }
        SkinManager.setViewTextColor((TextView) viewGroup.findViewById(R.id.tv_back_shoubai_text), R.color.CAM_X0101);
        float g2 = d.a.c.e.p.l.g(context, R.dimen.tbds424);
        TBSelector.makeDrawableSelector().setShape(0).setType(1).trRadius(g2).brRadius(g2).defaultColor(R.color.topic_disagree_des_color).into(viewGroup);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) viewGroup.findViewById(R.id.shoubai_back_icon), R.drawable.ic_icon_pure_list_arrow16_left_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange((ImageView) viewGroup.findViewById(R.id.shoubai_logo_icon), R.drawable.ic_icon_mask_home_backbtn_logo_n_svg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public final boolean q(View view) {
        IBinder windowToken;
        if (view == null || (windowToken = view.getWindowToken()) == null) {
            return false;
        }
        try {
            if (windowToken.isBinderAlive()) {
                return windowToken.pingBinder();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void r(Context context) {
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://donothing"));
            if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                context.startActivity(intent);
            } else {
                w();
            }
        } catch (Exception unused) {
            w();
        }
    }

    public final void s() {
        FrameLayout l;
        Iterator<WeakReference<Activity>> it = this.f50118a.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next != null && next.get() != null && !next.get().isFinishing() && (l = l(next.get())) != null) {
                Object tag = l.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                if (tag instanceof ViewGroup) {
                    p((ViewGroup) tag, l.getContext());
                }
            }
        }
    }

    public void t(Application application) {
        if (application == null) {
            return;
        }
        try {
            application.registerActivityLifecycleCallbacks(this.f50122e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean u(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return false;
        }
        try {
            Object tag = frameLayout.getTag(R.id.tag_scheme_baidu_box_app_back_view);
            ViewGroup viewGroup = tag instanceof ViewGroup ? (ViewGroup) tag : null;
            if (viewGroup != null && viewGroup.getParent() != null && viewGroup.getParent() == frameLayout && q(frameLayout) && q(viewGroup)) {
                frameLayout.removeView(viewGroup);
                frameLayout.setTag(R.id.tag_scheme_baidu_box_app_back_view, null);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void v(boolean z) {
        if (f50117f != z) {
            f50117f = z;
            if (z) {
                Iterator<WeakReference<Activity>> it = this.f50119b.iterator();
                while (it.hasNext()) {
                    WeakReference<Activity> next = it.next();
                    if (next.get() != null && !next.get().isFinishing()) {
                        Activity activity = next.get();
                        if (j(l(activity))) {
                            this.f50118a.add(new WeakReference<>(activity));
                        }
                    }
                }
                return;
            }
            Iterator<WeakReference<Activity>> it2 = this.f50119b.iterator();
            while (it2.hasNext()) {
                WeakReference<Activity> next2 = it2.next();
                if (next2.get() != null && !next2.get().isFinishing()) {
                    u(l(next2.get()));
                }
            }
            this.f50118a.clear();
        }
    }

    public final void w() {
        d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.not_install_baidu_box_app_tip);
    }

    public e() {
        this.f50118a = new ArrayList<>();
        this.f50119b = new ArrayList<>();
        this.f50120c = TbadkCoreApplication.getInst().getSkinType();
        this.f50121d = new a(2001304);
        this.f50122e = new b();
        MessageManager.getInstance().registerListener(this.f50121d);
    }
}
