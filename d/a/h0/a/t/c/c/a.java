package d.a.h0.a.t.c.c;

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
import d.a.h0.a.c1.a;
import d.a.h0.a.e0.l.c;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
import d.a.h0.g.k0.b;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f44047i;

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f44048a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f44049b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f44050c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.e0.l.c f44051d;

    /* renamed from: e  reason: collision with root package name */
    public ContentObserver f44052e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.a.o0.a f44053f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.g.k0.b f44054g;

    /* renamed from: h  reason: collision with root package name */
    public j f44055h;

    /* renamed from: d.a.h0.a.t.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0769a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f44056e;

        public View$OnClickListenerC0769a(ShowFavoriteGuideApi.GuideType guideType) {
            this.f44056e = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.k();
            if (a.this.f44055h != null) {
                a.this.f44055h.d(false);
            }
            ShowFavoriteGuideApi.y(this.f44056e, "flow_close_close", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f44058e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f44059f;

        /* renamed from: d.a.h0.a.t.c.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0770a implements a.j {
            public C0770a() {
            }

            @Override // d.a.h0.a.c1.a.j
            public void onFail() {
                if (a.this.f44055h != null) {
                    a.this.f44055h.d(false);
                }
                d.a.h0.a.c0.c.g("FavoriteGuideHelper", "add favorite result=false");
            }

            @Override // d.a.h0.a.c1.a.j
            public void onSuccess() {
                if (a.this.f44055h != null) {
                    a.this.f44055h.d(true);
                }
                d.a.h0.a.c0.c.g("FavoriteGuideHelper", "add favorite result=true");
            }
        }

        public b(ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
            this.f44058e = guideType;
            this.f44059f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.h0.a.c1.a.i(this.f44059f, new C0770a());
            a.this.k();
            if (a.this.f44049b != null) {
                a.this.f44049b.cancel();
            }
            ShowFavoriteGuideApi.GuideType guideType = this.f44058e;
            ShowFavoriteGuideApi.y(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f44062e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.f f44063f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.e f44064g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44065h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44066i;

        public c(ViewTreeObserver viewTreeObserver, d.a.h0.a.e0.l.f fVar, d.a.h0.a.e0.l.e eVar, String str, d.a.h0.a.r1.e eVar2) {
            this.f44062e = viewTreeObserver;
            this.f44063f = fVar;
            this.f44064g = eVar;
            this.f44065h = str;
            this.f44066i = eVar2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.a.h0.a.e0.l.e eVar;
            ViewTreeObserver viewTreeObserver;
            if (a.this.f44048a != null || (viewTreeObserver = this.f44062e) == null || !viewTreeObserver.isAlive()) {
                if (a.this.f44051d != this.f44063f.m() || (!((eVar = this.f44064g) == null || TextUtils.equals(this.f44065h, eVar.W2())) || (!this.f44066i.i0() && h0.C()))) {
                    a.this.k();
                    ViewTreeObserver viewTreeObserver2 = this.f44062e;
                    if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                        return;
                    }
                    this.f44062e.removeOnGlobalLayoutListener(this);
                    return;
                }
                return;
            }
            this.f44062e.removeOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes2.dex */
    public class d extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44067e;

        public d(d.a.h0.a.r1.e eVar) {
            this.f44067e = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a.this.k();
            if (a.this.f44055h != null) {
                a.this.f44055h.d(d.a.h0.a.g0.c.a.n(this.f44067e.f43823f));
            }
            if (a.this.f44049b != null) {
                a.this.f44049b.cancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements b.a {
        public e() {
        }

        @Override // d.a.h0.g.k0.b.a
        public void a() {
            a.this.k();
        }

        @Override // d.a.h0.g.k0.b.a
        public void b(int i2) {
            if (i2 == 1) {
                a.this.k();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44070a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f44071b;

        /* renamed from: d.a.h0.a.t.c.c.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0771a implements Runnable {
            public RunnableC0771a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.a.h0.a.g0.c.a.n(f.this.f44070a.f43823f)) {
                    f fVar = f.this;
                    if (fVar.f44071b == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.f44055h != null) {
                        a.this.f44055h.d(true);
                    }
                    a.this.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Handler handler, d.a.h0.a.r1.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
            super(handler);
            this.f44070a = eVar;
            this.f44071b = guideType;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            p.h().execute(new RunnableC0771a());
        }
    }

    /* loaded from: classes2.dex */
    public class g extends d.a.h0.a.o0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44074a;

        public g(d.a.h0.a.r1.e eVar) {
            this.f44074a = eVar;
        }

        @Override // d.a.h0.a.o0.a, d.a.h0.a.o0.b
        public void a() {
            if (a.this.f44048a == null || !a.this.f44048a.t()) {
                return;
            }
            a.this.k();
        }

        @Override // d.a.h0.a.o0.a, d.a.h0.a.o0.b
        public void c() {
            d.a.h0.a.c0.c.g("FavoriteGuideHelper", "call onActivityDestroyed");
            a.this.k();
            if (a.this.f44050c == null || a.this.f44053f == null) {
                return;
            }
            a.this.f44050c.unregisterCallback(a.this.f44053f);
        }

        @Override // d.a.h0.a.o0.a, d.a.h0.a.o0.b
        public void e() {
            super.e();
            d.a.h0.a.c0.c.g("FavoriteGuideHelper", "swanId=" + this.f44074a.f43823f + ", nowId=" + d.a.h0.a.r1.e.T());
            if (TextUtils.equals(this.f44074a.f43823f, d.a.h0.a.r1.e.T())) {
                return;
            }
            a.this.k();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements c.m {
        public h() {
        }

        @Override // d.a.h0.a.e0.l.c.m
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
            if (a.this.f44048a != null) {
                a.this.f44048a.n();
                a.this.f44048a = null;
            }
            if (a.this.f44052e != null) {
                AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.f44052e);
                a.this.f44052e = null;
            }
            if (a.this.f44050c != null && a.this.f44053f != null) {
                a.this.f44050c.unregisterCallback(a.this.f44053f);
            }
            if (a.this.f44051d != null) {
                a.this.f44051d.q2(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface j {
        void d(boolean z);
    }

    public static a l() {
        if (f44047i == null) {
            synchronized (a.class) {
                if (f44047i == null) {
                    f44047i = new a();
                }
            }
        }
        return f44047i;
    }

    @AnyThread
    public final synchronized void k() {
        k0.X(new i());
    }

    public final void m() {
        if (this.f44054g == null) {
            d.a.h0.g.k0.b a2 = d.a.h0.g.k0.b.a();
            this.f44054g = a2;
            if (a2 != null) {
                a2.c(new e());
            }
        }
    }

    public boolean n(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }

    public final synchronized void o(@NonNull Activity activity, @NonNull d.a.h0.a.r1.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
        this.f44052e = new f(null, eVar, guideType);
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(d.a.h0.a.g0.c.a.d(), false, this.f44052e);
        if (activity instanceof SwanAppActivity) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
            this.f44050c = swanAppActivity;
            if (this.f44053f != null) {
                swanAppActivity.unregisterCallback(this.f44053f);
            }
            g gVar = new g(eVar);
            this.f44053f = gVar;
            this.f44050c.registerCallback(gVar);
        }
        d.a.h0.a.e0.l.f swanAppFragmentManager = this.f44050c.getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            return;
        }
        d.a.h0.a.e0.l.c m = swanAppFragmentManager.m();
        this.f44051d = m;
        if (m == null) {
            return;
        }
        m.q2(new h());
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull d.a.h0.a.r1.e eVar, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        d.a.h0.a.e0.l.f swanAppFragmentManager;
        String str3 = str;
        this.f44055h = jVar;
        k();
        if (eVar.i0()) {
            m();
            d.a.h0.g.k0.b bVar = this.f44054g;
            if (bVar != null) {
                bVar.d(0);
            }
        }
        o(activity, eVar, guideType);
        View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? d.a.h0.a.g.aiapps_favorite_guide_tips : d.a.h0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(d.a.h0.a.f.favorite_guide_content);
        if (textView != null && str3 != null) {
            if (guideType.limit != -1 && str.length() > guideType.limit) {
                str3 = str3.substring(0, guideType.limit - 1) + StringHelper.STRING_MORE;
            }
            textView.setText(str3);
        }
        View findViewById = activity.findViewById(d.a.h0.a.f.titlebar_right_menu_img);
        if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(d.a.h0.a.f.favorite_guide_container);
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
            k0.Q((ImageView) inflate.findViewById(d.a.h0.a.f.favorite_guide_icon), str2, d.a.h0.a.e.aiapps_default_grey_icon);
            ImageView imageView = (ImageView) inflate.findViewById(d.a.h0.a.f.favorite_guide_close);
            if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                imageView.setVisibility(8);
            } else {
                imageView.setOnClickListener(new View$OnClickListenerC0769a(guideType));
            }
            ((Button) inflate.findViewById(d.a.h0.a.f.favorite_guide_add_btn)).setOnClickListener(new b(guideType, activity));
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
            this.f44048a = popupWindow;
            popupWindow.I(16);
            this.f44048a.L(activity.getWindow().getDecorView(), 81, 0, (int) h0.g(50.0f));
        } else if (findViewById != null) {
            int[] iArr = new int[2];
            findViewById.getLocationOnScreen(iArr);
            inflate.findViewById(d.a.h0.a.f.favorite_guide_arrow).setPadding(0, 0, ((h0.m(null) - iArr[0]) - (findViewById.getWidth() / 2)) - h0.f(7.0f), 0);
            this.f44048a = new PopupWindow(inflate, -2, -2);
            SwanAppActivity swanAppActivity2 = this.f44050c;
            if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.f44050c.isDestroyed() && findViewById.isAttachedToWindow()) {
                try {
                    this.f44048a.K(findViewById, 0, -h0.f(3.0f));
                } catch (WindowManager.BadTokenException e2) {
                    if (k.f43101a) {
                        Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                        e2.printStackTrace();
                    }
                }
            }
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.f44050c) != null && (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) != null && findViewById != null) {
            d.a.h0.a.e0.l.e l = swanAppFragmentManager.l();
            String W2 = l == null ? "" : l.W2();
            ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new c(viewTreeObserver, swanAppFragmentManager, l, W2, eVar));
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
            Timer timer = this.f44049b;
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = new Timer();
            this.f44049b = timer2;
            timer2.schedule(new d(eVar), 1000 * j2);
        }
        ShowFavoriteGuideApi.y(guideType, "", "show");
    }
}
