package d.a.l0.a.u.e.d;

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
import d.a.l0.a.h0.g.d;
import d.a.l0.a.j1.a;
import d.a.l0.a.k;
import d.a.l0.a.u.e.d.a;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.q0;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f48549i;

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f48550a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f48551b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f48552c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.h0.g.d f48553d;

    /* renamed from: e  reason: collision with root package name */
    public ContentObserver f48554e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.t0.a f48555f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.a.u.e.d.a f48556g;

    /* renamed from: h  reason: collision with root package name */
    public j f48557h;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f48558e;

        public a(ShowFavoriteGuideApi.GuideType guideType) {
            this.f48558e = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.k();
            if (b.this.f48557h != null) {
                b.this.f48557h.e(false);
            }
            ShowFavoriteGuideApi.z(this.f48558e, "flow_close_close", PrefetchEvent.STATE_CLICK);
        }
    }

    /* renamed from: d.a.l0.a.u.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0893b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f48560e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f48561f;

        /* renamed from: d.a.l0.a.u.e.d.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements a.h {
            public a() {
            }

            @Override // d.a.l0.a.j1.a.h
            public void onFail() {
                if (b.this.f48557h != null) {
                    b.this.f48557h.e(false);
                }
                d.a.l0.a.e0.d.g("FavoriteGuideHelper", "add favorite result=false");
            }

            @Override // d.a.l0.a.j1.a.h
            public void onSuccess() {
                if (b.this.f48557h != null) {
                    b.this.f48557h.e(true);
                }
                d.a.l0.a.e0.d.g("FavoriteGuideHelper", "add favorite result=true");
            }
        }

        public View$OnClickListenerC0893b(ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
            this.f48560e = guideType;
            this.f48561f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.l0.a.j1.a.h(this.f48561f, new a());
            b.this.k();
            if (b.this.f48551b != null) {
                b.this.f48551b.cancel();
            }
            ShowFavoriteGuideApi.GuideType guideType = this.f48560e;
            ShowFavoriteGuideApi.z(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f48564e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.g.g f48565f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.g.f f48566g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48567h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f48568i;

        public c(ViewTreeObserver viewTreeObserver, d.a.l0.a.h0.g.g gVar, d.a.l0.a.h0.g.f fVar, String str, d.a.l0.a.a2.e eVar) {
            this.f48564e = viewTreeObserver;
            this.f48565f = gVar;
            this.f48566g = fVar;
            this.f48567h = str;
            this.f48568i = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.a.l0.a.h0.g.f fVar;
            ViewTreeObserver viewTreeObserver;
            if (b.this.f48550a != null || (viewTreeObserver = this.f48564e) == null || !viewTreeObserver.isAlive()) {
                if (b.this.f48553d != this.f48565f.m() || (!((fVar = this.f48566g) == null || TextUtils.equals(this.f48567h, fVar.g3())) || (!this.f48568i.m0() && n0.F()))) {
                    b.this.k();
                    ViewTreeObserver viewTreeObserver2 = this.f48564e;
                    if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                        return;
                    }
                    this.f48564e.removeOnGlobalLayoutListener(this);
                    return;
                }
                return;
            }
            this.f48564e.removeOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes2.dex */
    public class d extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f48569e;

        public d(d.a.l0.a.a2.e eVar) {
            this.f48569e = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b.this.k();
            if (b.this.f48557h != null) {
                b.this.f48557h.e(d.a.l0.a.j0.b.a.n(this.f48569e.f44425f));
            }
            if (b.this.f48551b != null) {
                b.this.f48551b.cancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements a.InterfaceC0892a {
        public e() {
        }

        @Override // d.a.l0.a.u.e.d.a.InterfaceC0892a
        public void a() {
            b.this.k();
        }

        @Override // d.a.l0.a.u.e.d.a.InterfaceC0892a
        public void b(int i2) {
            if (i2 == 1) {
                b.this.k();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f48572a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f48573b;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.a.l0.a.j0.b.a.n(f.this.f48572a.f44425f)) {
                    f fVar = f.this;
                    if (fVar.f48573b == ShowFavoriteGuideApi.GuideType.NORMAL && b.this.f48557h != null) {
                        b.this.f48557h.e(true);
                    }
                    b.this.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Handler handler, d.a.l0.a.a2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
            super(handler);
            this.f48572a = eVar;
            this.f48573b = guideType;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            q.g().execute(new a());
        }
    }

    /* loaded from: classes2.dex */
    public class g extends d.a.l0.a.t0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f48576a;

        public g(d.a.l0.a.a2.e eVar) {
            this.f48576a = eVar;
        }

        @Override // d.a.l0.a.t0.a, d.a.l0.a.t0.b
        public void a() {
            if (b.this.f48550a == null || !b.this.f48550a.x()) {
                return;
            }
            b.this.k();
        }

        @Override // d.a.l0.a.t0.a, d.a.l0.a.t0.b
        public void c() {
            d.a.l0.a.e0.d.g("FavoriteGuideHelper", "call onActivityDestroyed");
            b.this.k();
            if (b.this.f48552c == null || b.this.f48555f == null) {
                return;
            }
            b.this.f48552c.unregisterCallback(b.this.f48555f);
        }

        @Override // d.a.l0.a.t0.a, d.a.l0.a.t0.b
        public void e() {
            super.e();
            d.a.l0.a.e0.d.g("FavoriteGuideHelper", "swanId=" + this.f48576a.f44425f + ", nowId=" + d.a.l0.a.a2.e.V());
            if (TextUtils.equals(this.f48576a.f44425f, d.a.l0.a.a2.e.V())) {
                return;
            }
            b.this.k();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements d.m {
        public h() {
        }

        @Override // d.a.l0.a.h0.g.d.m
        public void a() {
            b.this.k();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f48550a != null) {
                b.this.f48550a.r();
                b.this.f48550a = null;
            }
            if (b.this.f48554e != null) {
                AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(b.this.f48554e);
                b.this.f48554e = null;
            }
            if (b.this.f48552c != null && b.this.f48555f != null) {
                b.this.f48552c.unregisterCallback(b.this.f48555f);
            }
            if (b.this.f48553d != null) {
                b.this.f48553d.w2(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface j {
        void e(boolean z);
    }

    public static b l() {
        if (f48549i == null) {
            synchronized (b.class) {
                if (f48549i == null) {
                    f48549i = new b();
                }
            }
        }
        return f48549i;
    }

    @AnyThread
    public final synchronized void k() {
        q0.b0(new i());
    }

    public final void m() {
        d.a.l0.a.p.b.a.i k;
        if (this.f48556g != null || (k = d.a.l0.a.c1.b.k()) == null) {
            return;
        }
        d.a.l0.a.u.e.d.a a2 = k.a();
        this.f48556g = a2;
        if (a2 != null) {
            a2.b(new e());
        }
    }

    public boolean n(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }

    public final synchronized void o(@NonNull Activity activity, @NonNull d.a.l0.a.a2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
        this.f48554e = new f(null, eVar, guideType);
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(d.a.l0.a.j0.b.a.d(), false, this.f48554e);
        if (activity instanceof SwanAppActivity) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
            this.f48552c = swanAppActivity;
            if (this.f48555f != null) {
                swanAppActivity.unregisterCallback(this.f48555f);
            }
            g gVar = new g(eVar);
            this.f48555f = gVar;
            this.f48552c.registerCallback(gVar);
        }
        d.a.l0.a.h0.g.g swanAppFragmentManager = this.f48552c.getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            return;
        }
        d.a.l0.a.h0.g.d m = swanAppFragmentManager.m();
        this.f48553d = m;
        if (m == null) {
            return;
        }
        m.w2(new h());
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull d.a.l0.a.a2.e eVar, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        d.a.l0.a.h0.g.g swanAppFragmentManager;
        String str3 = str;
        this.f48557h = jVar;
        k();
        if (eVar.m0()) {
            m();
            d.a.l0.a.u.e.d.a aVar = this.f48556g;
            if (aVar != null) {
                aVar.c(0);
            }
        }
        o(activity, eVar, guideType);
        View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? d.a.l0.a.g.aiapps_favorite_guide_tips : d.a.l0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(d.a.l0.a.f.favorite_guide_content);
        if (textView != null && str3 != null) {
            if (guideType.limit != -1 && str.length() > guideType.limit) {
                str3 = str3.substring(0, guideType.limit - 1) + StringHelper.STRING_MORE;
            }
            textView.setText(str3);
        }
        View findViewById = activity.findViewById(d.a.l0.a.f.titlebar_right_menu_img);
        if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(d.a.l0.a.f.favorite_guide_container);
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            int i2 = guideType.showWidth4px;
            int g2 = n0.g(7.0f);
            int o = n0.o(null);
            int i3 = g2 * 2;
            if (o - i2 < i3) {
                i2 = o - i3;
            }
            layoutParams.width = i2;
            relativeLayout.setLayoutParams(layoutParams);
            q0.U((ImageView) inflate.findViewById(d.a.l0.a.f.favorite_guide_icon), str2, d.a.l0.a.e.aiapps_default_grey_icon);
            ImageView imageView = (ImageView) inflate.findViewById(d.a.l0.a.f.favorite_guide_close);
            if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                imageView.setVisibility(8);
            } else {
                imageView.setOnClickListener(new a(guideType));
            }
            ((Button) inflate.findViewById(d.a.l0.a.f.favorite_guide_add_btn)).setOnClickListener(new View$OnClickListenerC0893b(guideType, activity));
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
            this.f48550a = popupWindow;
            popupWindow.N(16);
            this.f48550a.Q(activity.getWindow().getDecorView(), 81, 0, (int) n0.h(50.0f));
        } else if (findViewById != null) {
            int[] iArr = new int[2];
            findViewById.getLocationOnScreen(iArr);
            inflate.findViewById(d.a.l0.a.f.favorite_guide_arrow).setPadding(0, 0, ((n0.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - n0.g(7.0f), 0);
            this.f48550a = new PopupWindow(inflate, -2, -2);
            SwanAppActivity swanAppActivity2 = this.f48552c;
            if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.f48552c.isDestroyed() && findViewById.isAttachedToWindow()) {
                try {
                    this.f48550a.P(findViewById, 0, -n0.g(3.0f));
                } catch (WindowManager.BadTokenException e2) {
                    if (k.f46875a) {
                        Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                        e2.printStackTrace();
                    }
                }
            }
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.f48552c) != null && (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) != null && findViewById != null) {
            d.a.l0.a.h0.g.f l = swanAppFragmentManager.l();
            String g3 = l == null ? "" : l.g3();
            ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new c(viewTreeObserver, swanAppFragmentManager, l, g3, eVar));
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
            Timer timer = this.f48551b;
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = new Timer();
            this.f48551b = timer2;
            timer2.schedule(new d(eVar), 1000 * j2);
        }
        ShowFavoriteGuideApi.z(guideType, "", "show");
    }
}
