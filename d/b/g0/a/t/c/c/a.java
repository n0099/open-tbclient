package d.b.g0.a.t.c.c;

import android.app.Activity;
import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tbadk.core.util.StringHelper;
import d.b.g0.a.c1.a;
import d.b.g0.a.e0.l.c;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.g.k0.b;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class a {
    public static volatile a i;

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f45953a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f45954b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f45955c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.e0.l.c f45956d;

    /* renamed from: e  reason: collision with root package name */
    public ContentObserver f45957e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.o0.a f45958f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.g.k0.b f45959g;

    /* renamed from: h  reason: collision with root package name */
    public j f45960h;

    /* renamed from: d.b.g0.a.t.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0797a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f45961e;

        public View$OnClickListenerC0797a(ShowFavoriteGuideApi.GuideType guideType) {
            this.f45961e = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.k();
            if (a.this.f45960h != null) {
                a.this.f45960h.e(false);
            }
            ShowFavoriteGuideApi.y(this.f45961e, "flow_close_close", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f45963e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f45964f;

        /* renamed from: d.b.g0.a.t.c.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0798a implements a.j {
            public C0798a() {
            }

            @Override // d.b.g0.a.c1.a.j
            public void onFail() {
                if (a.this.f45960h != null) {
                    a.this.f45960h.e(false);
                }
                d.b.g0.a.c0.c.g("FavoriteGuideHelper", "add favorite result=false");
            }

            @Override // d.b.g0.a.c1.a.j
            public void onSuccess() {
                if (a.this.f45960h != null) {
                    a.this.f45960h.e(true);
                }
                d.b.g0.a.c0.c.g("FavoriteGuideHelper", "add favorite result=true");
            }
        }

        public b(ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
            this.f45963e = guideType;
            this.f45964f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.g0.a.c1.a.i(this.f45964f, new C0798a());
            a.this.k();
            if (a.this.f45954b != null) {
                a.this.f45954b.cancel();
            }
            ShowFavoriteGuideApi.GuideType guideType = this.f45963e;
            ShowFavoriteGuideApi.y(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f45967e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f45968f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.e f45969g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45970h;
        public final /* synthetic */ d.b.g0.a.r1.e i;

        public c(ViewTreeObserver viewTreeObserver, d.b.g0.a.e0.l.f fVar, d.b.g0.a.e0.l.e eVar, String str, d.b.g0.a.r1.e eVar2) {
            this.f45967e = viewTreeObserver;
            this.f45968f = fVar;
            this.f45969g = eVar;
            this.f45970h = str;
            this.i = eVar2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.b.g0.a.e0.l.e eVar;
            ViewTreeObserver viewTreeObserver;
            if (a.this.f45953a != null || (viewTreeObserver = this.f45967e) == null || !viewTreeObserver.isAlive()) {
                if (a.this.f45956d != this.f45968f.m() || (!((eVar = this.f45969g) == null || TextUtils.equals(this.f45970h, eVar.X2())) || (!this.i.i0() && h0.C()))) {
                    a.this.k();
                    ViewTreeObserver viewTreeObserver2 = this.f45967e;
                    if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                        return;
                    }
                    this.f45967e.removeOnGlobalLayoutListener(this);
                    return;
                }
                return;
            }
            this.f45967e.removeOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f45971e;

        public d(d.b.g0.a.r1.e eVar) {
            this.f45971e = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a.this.k();
            if (a.this.f45960h != null) {
                a.this.f45960h.e(d.b.g0.a.g0.c.a.n(this.f45971e.f45739f));
            }
            if (a.this.f45954b != null) {
                a.this.f45954b.cancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.a {
        public e() {
        }

        @Override // d.b.g0.g.k0.b.a
        public void a(int i) {
            if (i == 1) {
                a.this.k();
            }
        }

        @Override // d.b.g0.g.k0.b.a
        public void b() {
            a.this.k();
        }
    }

    /* loaded from: classes3.dex */
    public class f extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f45974a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f45975b;

        /* renamed from: d.b.g0.a.t.c.c.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0799a implements Runnable {
            public RunnableC0799a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.b.g0.a.g0.c.a.n(f.this.f45974a.f45739f)) {
                    f fVar = f.this;
                    if (fVar.f45975b == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.f45960h != null) {
                        a.this.f45960h.e(true);
                    }
                    a.this.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Handler handler, d.b.g0.a.r1.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
            super(handler);
            this.f45974a = eVar;
            this.f45975b = guideType;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            p.h().execute(new RunnableC0799a());
        }
    }

    /* loaded from: classes3.dex */
    public class g extends d.b.g0.a.o0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f45978a;

        public g(d.b.g0.a.r1.e eVar) {
            this.f45978a = eVar;
        }

        @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
        public void a() {
            if (a.this.f45953a == null || !a.this.f45953a.u()) {
                return;
            }
            a.this.k();
        }

        @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
        public void d() {
            d.b.g0.a.c0.c.g("FavoriteGuideHelper", "call onActivityDestroyed");
            a.this.k();
            if (a.this.f45955c == null || a.this.f45958f == null) {
                return;
            }
            a.this.f45955c.unregisterCallback(a.this.f45958f);
        }

        @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
        public void f() {
            super.f();
            d.b.g0.a.c0.c.g("FavoriteGuideHelper", "swanId=" + this.f45978a.f45739f + ", nowId=" + d.b.g0.a.r1.e.T());
            if (TextUtils.equals(this.f45978a.f45739f, d.b.g0.a.r1.e.T())) {
                return;
            }
            a.this.k();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements c.m {
        public h() {
        }

        @Override // d.b.g0.a.e0.l.c.m
        public void a() {
            a.this.k();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f45953a != null) {
                a.this.f45953a.n();
                a.this.f45953a = null;
            }
            if (a.this.f45957e != null) {
                AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.f45957e);
                a.this.f45957e = null;
            }
            if (a.this.f45955c != null && a.this.f45958f != null) {
                a.this.f45955c.unregisterCallback(a.this.f45958f);
            }
            if (a.this.f45956d != null) {
                a.this.f45956d.r2(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void e(boolean z);
    }

    public static a l() {
        if (i == null) {
            synchronized (a.class) {
                if (i == null) {
                    i = new a();
                }
            }
        }
        return i;
    }

    @AnyThread
    public final synchronized void k() {
        k0.X(new i());
    }

    public final void m() {
        if (this.f45959g == null) {
            d.b.g0.g.k0.b a2 = d.b.g0.g.k0.b.a();
            this.f45959g = a2;
            if (a2 != null) {
                a2.c(new e());
            }
        }
    }

    public boolean n(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }

    public final synchronized void o(@NonNull Activity activity, @NonNull d.b.g0.a.r1.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
        this.f45957e = new f(null, eVar, guideType);
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(d.b.g0.a.g0.c.a.d(), false, this.f45957e);
        if (activity instanceof SwanAppActivity) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
            this.f45955c = swanAppActivity;
            if (this.f45958f != null) {
                swanAppActivity.unregisterCallback(this.f45958f);
            }
            g gVar = new g(eVar);
            this.f45958f = gVar;
            this.f45955c.registerCallback(gVar);
        }
        d.b.g0.a.e0.l.f swanAppFragmentManager = this.f45955c.getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            return;
        }
        d.b.g0.a.e0.l.c m = swanAppFragmentManager.m();
        this.f45956d = m;
        if (m == null) {
            return;
        }
        m.r2(new h());
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull d.b.g0.a.r1.e eVar, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        d.b.g0.a.e0.l.f swanAppFragmentManager;
        String str3 = str;
        this.f45960h = jVar;
        k();
        if (eVar.i0()) {
            m();
            d.b.g0.g.k0.b bVar = this.f45959g;
            if (bVar != null) {
                bVar.d(0);
            }
        }
        o(activity, eVar, guideType);
        View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? d.b.g0.a.g.aiapps_favorite_guide_tips : d.b.g0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(d.b.g0.a.f.favorite_guide_content);
        if (textView != null && str3 != null) {
            if (guideType.limit != -1 && str.length() > guideType.limit) {
                str3 = str3.substring(0, guideType.limit - 1) + StringHelper.STRING_MORE;
            }
            textView.setText(str3);
        }
        View findViewById = activity.findViewById(d.b.g0.a.f.titlebar_right_menu_img);
        if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(d.b.g0.a.f.favorite_guide_container);
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            int i2 = guideType.showWidth4px;
            int f2 = h0.f(7.0f);
            int m = h0.m(null);
            int i3 = f2 * 2;
            if (m - i2 < i3) {
                i2 = m - i3;
            }
            layoutParams.width = i2;
            relativeLayout.setLayoutParams(layoutParams);
            k0.Q((ImageView) inflate.findViewById(d.b.g0.a.f.favorite_guide_icon), str2, d.b.g0.a.e.aiapps_default_grey_icon);
            ImageView imageView = (ImageView) inflate.findViewById(d.b.g0.a.f.favorite_guide_close);
            if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                imageView.setVisibility(8);
            } else {
                imageView.setOnClickListener(new View$OnClickListenerC0797a(guideType));
            }
            ((Button) inflate.findViewById(d.b.g0.a.f.favorite_guide_add_btn)).setOnClickListener(new b(guideType, activity));
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
            this.f45953a = popupWindow;
            popupWindow.J(16);
            this.f45953a.M(activity.getWindow().getDecorView(), 81, 0, (int) h0.g(50.0f));
        } else if (findViewById != null) {
            int[] iArr = new int[2];
            findViewById.getLocationOnScreen(iArr);
            inflate.findViewById(d.b.g0.a.f.favorite_guide_arrow).setPadding(0, 0, ((h0.m(null) - iArr[0]) - (findViewById.getWidth() / 2)) - h0.f(7.0f), 0);
            this.f45953a = new PopupWindow(inflate, -2, -2);
            SwanAppActivity swanAppActivity2 = this.f45955c;
            if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.f45955c.isDestroyed() && findViewById.isAttachedToWindow()) {
                try {
                    this.f45953a.L(findViewById, 0, -h0.f(3.0f));
                } catch (WindowManager.BadTokenException e2) {
                    if (k.f45050a) {
                        Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                        e2.printStackTrace();
                    }
                }
            }
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.f45955c) != null && (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) != null && findViewById != null) {
            d.b.g0.a.e0.l.e l = swanAppFragmentManager.l();
            String X2 = l == null ? "" : l.X2();
            ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new c(viewTreeObserver, swanAppFragmentManager, l, X2, eVar));
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
            Timer timer = this.f45954b;
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = new Timer();
            this.f45954b = timer2;
            timer2.schedule(new d(eVar), 1000 * j2);
        }
        ShowFavoriteGuideApi.y(guideType, "", "show");
    }
}
