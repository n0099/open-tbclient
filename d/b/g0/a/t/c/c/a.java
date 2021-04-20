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
/* loaded from: classes2.dex */
public class a {
    public static volatile a i;

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f46346a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f46347b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f46348c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.e0.l.c f46349d;

    /* renamed from: e  reason: collision with root package name */
    public ContentObserver f46350e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.o0.a f46351f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.g.k0.b f46352g;

    /* renamed from: h  reason: collision with root package name */
    public j f46353h;

    /* renamed from: d.b.g0.a.t.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0810a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f46354e;

        public View$OnClickListenerC0810a(ShowFavoriteGuideApi.GuideType guideType) {
            this.f46354e = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.k();
            if (a.this.f46353h != null) {
                a.this.f46353h.e(false);
            }
            ShowFavoriteGuideApi.y(this.f46354e, "flow_close_close", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f46356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f46357f;

        /* renamed from: d.b.g0.a.t.c.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0811a implements a.j {
            public C0811a() {
            }

            @Override // d.b.g0.a.c1.a.j
            public void onFail() {
                if (a.this.f46353h != null) {
                    a.this.f46353h.e(false);
                }
                d.b.g0.a.c0.c.g("FavoriteGuideHelper", "add favorite result=false");
            }

            @Override // d.b.g0.a.c1.a.j
            public void onSuccess() {
                if (a.this.f46353h != null) {
                    a.this.f46353h.e(true);
                }
                d.b.g0.a.c0.c.g("FavoriteGuideHelper", "add favorite result=true");
            }
        }

        public b(ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
            this.f46356e = guideType;
            this.f46357f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.g0.a.c1.a.i(this.f46357f, new C0811a());
            a.this.k();
            if (a.this.f46347b != null) {
                a.this.f46347b.cancel();
            }
            ShowFavoriteGuideApi.GuideType guideType = this.f46356e;
            ShowFavoriteGuideApi.y(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f46360e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46361f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.e f46362g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46363h;
        public final /* synthetic */ d.b.g0.a.r1.e i;

        public c(ViewTreeObserver viewTreeObserver, d.b.g0.a.e0.l.f fVar, d.b.g0.a.e0.l.e eVar, String str, d.b.g0.a.r1.e eVar2) {
            this.f46360e = viewTreeObserver;
            this.f46361f = fVar;
            this.f46362g = eVar;
            this.f46363h = str;
            this.i = eVar2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.b.g0.a.e0.l.e eVar;
            ViewTreeObserver viewTreeObserver;
            if (a.this.f46346a != null || (viewTreeObserver = this.f46360e) == null || !viewTreeObserver.isAlive()) {
                if (a.this.f46349d != this.f46361f.m() || (!((eVar = this.f46362g) == null || TextUtils.equals(this.f46363h, eVar.X2())) || (!this.i.i0() && h0.C()))) {
                    a.this.k();
                    ViewTreeObserver viewTreeObserver2 = this.f46360e;
                    if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                        return;
                    }
                    this.f46360e.removeOnGlobalLayoutListener(this);
                    return;
                }
                return;
            }
            this.f46360e.removeOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes2.dex */
    public class d extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46364e;

        public d(d.b.g0.a.r1.e eVar) {
            this.f46364e = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a.this.k();
            if (a.this.f46353h != null) {
                a.this.f46353h.e(d.b.g0.a.g0.c.a.n(this.f46364e.f46132f));
            }
            if (a.this.f46347b != null) {
                a.this.f46347b.cancel();
            }
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class f extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46367a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f46368b;

        /* renamed from: d.b.g0.a.t.c.c.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0812a implements Runnable {
            public RunnableC0812a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.b.g0.a.g0.c.a.n(f.this.f46367a.f46132f)) {
                    f fVar = f.this;
                    if (fVar.f46368b == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.f46353h != null) {
                        a.this.f46353h.e(true);
                    }
                    a.this.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Handler handler, d.b.g0.a.r1.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
            super(handler);
            this.f46367a = eVar;
            this.f46368b = guideType;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            p.h().execute(new RunnableC0812a());
        }
    }

    /* loaded from: classes2.dex */
    public class g extends d.b.g0.a.o0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46371a;

        public g(d.b.g0.a.r1.e eVar) {
            this.f46371a = eVar;
        }

        @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
        public void a() {
            if (a.this.f46346a == null || !a.this.f46346a.u()) {
                return;
            }
            a.this.k();
        }

        @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
        public void d() {
            d.b.g0.a.c0.c.g("FavoriteGuideHelper", "call onActivityDestroyed");
            a.this.k();
            if (a.this.f46348c == null || a.this.f46351f == null) {
                return;
            }
            a.this.f46348c.unregisterCallback(a.this.f46351f);
        }

        @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
        public void f() {
            super.f();
            d.b.g0.a.c0.c.g("FavoriteGuideHelper", "swanId=" + this.f46371a.f46132f + ", nowId=" + d.b.g0.a.r1.e.T());
            if (TextUtils.equals(this.f46371a.f46132f, d.b.g0.a.r1.e.T())) {
                return;
            }
            a.this.k();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements c.m {
        public h() {
        }

        @Override // d.b.g0.a.e0.l.c.m
        public void a() {
            a.this.k();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46346a != null) {
                a.this.f46346a.n();
                a.this.f46346a = null;
            }
            if (a.this.f46350e != null) {
                AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.f46350e);
                a.this.f46350e = null;
            }
            if (a.this.f46348c != null && a.this.f46351f != null) {
                a.this.f46348c.unregisterCallback(a.this.f46351f);
            }
            if (a.this.f46349d != null) {
                a.this.f46349d.r2(null);
            }
        }
    }

    /* loaded from: classes2.dex */
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
        if (this.f46352g == null) {
            d.b.g0.g.k0.b a2 = d.b.g0.g.k0.b.a();
            this.f46352g = a2;
            if (a2 != null) {
                a2.c(new e());
            }
        }
    }

    public boolean n(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }

    public final synchronized void o(@NonNull Activity activity, @NonNull d.b.g0.a.r1.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
        this.f46350e = new f(null, eVar, guideType);
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(d.b.g0.a.g0.c.a.d(), false, this.f46350e);
        if (activity instanceof SwanAppActivity) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
            this.f46348c = swanAppActivity;
            if (this.f46351f != null) {
                swanAppActivity.unregisterCallback(this.f46351f);
            }
            g gVar = new g(eVar);
            this.f46351f = gVar;
            this.f46348c.registerCallback(gVar);
        }
        d.b.g0.a.e0.l.f swanAppFragmentManager = this.f46348c.getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            return;
        }
        d.b.g0.a.e0.l.c m = swanAppFragmentManager.m();
        this.f46349d = m;
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
        this.f46353h = jVar;
        k();
        if (eVar.i0()) {
            m();
            d.b.g0.g.k0.b bVar = this.f46352g;
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
                imageView.setOnClickListener(new View$OnClickListenerC0810a(guideType));
            }
            ((Button) inflate.findViewById(d.b.g0.a.f.favorite_guide_add_btn)).setOnClickListener(new b(guideType, activity));
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
            this.f46346a = popupWindow;
            popupWindow.J(16);
            this.f46346a.M(activity.getWindow().getDecorView(), 81, 0, (int) h0.g(50.0f));
        } else if (findViewById != null) {
            int[] iArr = new int[2];
            findViewById.getLocationOnScreen(iArr);
            inflate.findViewById(d.b.g0.a.f.favorite_guide_arrow).setPadding(0, 0, ((h0.m(null) - iArr[0]) - (findViewById.getWidth() / 2)) - h0.f(7.0f), 0);
            this.f46346a = new PopupWindow(inflate, -2, -2);
            SwanAppActivity swanAppActivity2 = this.f46348c;
            if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.f46348c.isDestroyed() && findViewById.isAttachedToWindow()) {
                try {
                    this.f46346a.L(findViewById, 0, -h0.f(3.0f));
                } catch (WindowManager.BadTokenException e2) {
                    if (k.f45443a) {
                        Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                        e2.printStackTrace();
                    }
                }
            }
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.f46348c) != null && (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) != null && findViewById != null) {
            d.b.g0.a.e0.l.e l = swanAppFragmentManager.l();
            String X2 = l == null ? "" : l.X2();
            ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new c(viewTreeObserver, swanAppFragmentManager, l, X2, eVar));
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
            Timer timer = this.f46347b;
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = new Timer();
            this.f46347b = timer2;
            timer2.schedule(new d(eVar), 1000 * j2);
        }
        ShowFavoriteGuideApi.y(guideType, "", "show");
    }
}
