package d.a.n0.h0;

import android.animation.Animator;
import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.airbnb.lottie.RenderMode;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.easterEgg.ActivityLifeCycleListener;
import com.baidu.tieba.easterEgg.EasterEggBridge;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f59031a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f59032b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.e3.l0.a f59033c;

    /* renamed from: d  reason: collision with root package name */
    public ActivityLifeCycleListener f59034d;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f59035e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.e3.l0.c f59036f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f59037g;

    /* renamed from: d.a.n0.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1415a implements d.a.n0.e3.l0.c {
        public C1415a() {
        }

        @Override // d.a.n0.e3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            return a.this.f59033c != null && a.this.f59033c.b(a.this.f59035e, str, jsPromptResult);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f59032b.removeCallbacksAndMessages(null);
            a.this.e();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a.this.f59031a = null;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59041e;

        public d(String str) {
            this.f59041e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.h(this.f59041e);
            } catch (Throwable unused) {
                a.this.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BaseWebView.e {
        public e() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            a.this.f59032b.removeCallbacksAndMessages(null);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BaseWebView.h {
        public f() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            a.this.f59032b.removeCallbacksAndMessages(null);
            a.this.e();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59045e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f59046f;

        public g(String str, String str2) {
            this.f59045e = str;
            this.f59046f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.i(this.f59045e, this.f59046f);
            } catch (Throwable unused) {
                a.this.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59048e;

        public h(String str) {
            this.f59048e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!k.isEmpty(this.f59048e) && (view.getContext() instanceof TbPageContextSupport)) {
                TiebaStatic.log(new StatisticItem("c13451").param("obj_type", 1));
                UrlManager.getInstance().dealOneLink(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{this.f59048e});
                return;
            }
            TiebaStatic.log(new StatisticItem("c13451").param("obj_type", 2));
            a.this.e();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Animator.AnimatorListener {
        public i() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f59032b.removeCallbacksAndMessages(null);
        }
    }

    /* loaded from: classes4.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public static a f59051a = new a(null);
    }

    public /* synthetic */ a(C1415a c1415a) {
        this();
    }

    public static a f() {
        return j.f59051a;
    }

    public void e() {
        PopupWindow popupWindow = this.f59031a;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        try {
            this.f59031a.dismiss();
        } catch (Throwable unused) {
        }
    }

    public final boolean g(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }

    public void h(String str) {
        Activity b2;
        if (k.isEmpty(str) || (b2 = d.a.c.a.b.f().b()) == null || b2.getWindow() == null || b2.getWindow().getDecorView() == null) {
            return;
        }
        if (g(b2)) {
            this.f59032b.postDelayed(new d(str), 1000L);
            return;
        }
        PopupWindow popupWindow = this.f59031a;
        if (popupWindow != null && popupWindow.isShowing()) {
            if (this.f59031a.getContentView() != null && this.f59031a.getContentView().getContext() == b2) {
                return;
            }
            e();
        }
        View inflate = LayoutInflater.from(b2).inflate(R.layout.easter_egg_dialog_h5_layout, (ViewGroup) null);
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BaseWebView baseWebView = (BaseWebView) inflate.findViewById(R.id.dialog_webview);
        this.f59035e = baseWebView;
        baseWebView.loadUrl(str);
        this.f59035e.setOnPageFinishedListener(new e());
        this.f59035e.setOnReceivedErrorListener(new f());
        this.f59035e.setBackgroundColor(0);
        this.f59035e.setOnJsPromptCallback(this.f59036f);
        j(b2, inflate);
    }

    public void i(String str, String str2) {
        Activity b2;
        if (k.isEmpty(str)) {
            return;
        }
        PopupWindow popupWindow = this.f59031a;
        if ((popupWindow == null || !popupWindow.isShowing()) && (b2 = d.a.c.a.b.f().b()) != null && PermissionUtil.checkWriteExternalStorage(b2)) {
            if (g(b2)) {
                this.f59032b.postDelayed(new g(str, str2), 1000L);
                return;
            }
            View inflate = LayoutInflater.from(b2).inflate(R.layout.easter_egg_dialog_lottie_layout, (ViewGroup) null);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(R.id.easter_egg_lottie_view);
            tBLottieAnimationView.setBackgroundResource(R.color.transparent);
            tBLottieAnimationView.setAnimationUrl(str);
            tBLottieAnimationView.setRenderMode(RenderMode.HARDWARE);
            tBLottieAnimationView.enableMergePathsForKitKatAndAbove(true);
            tBLottieAnimationView.setOnClickListener(new h(str2));
            tBLottieAnimationView.addAnimatorListener(new i());
            tBLottieAnimationView.playAnimation();
            j(b2, inflate);
        }
    }

    public final void j(Activity activity, View view) {
        PopupWindow popupWindow = new PopupWindow(activity);
        this.f59031a = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.f59031a.setWidth(l.k(activity));
        this.f59031a.setHeight(l.i(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f59031a.setContentView(view);
        this.f59032b.removeCallbacksAndMessages(null);
        this.f59032b.postDelayed(this.f59037g, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null && !this.f59034d.isAdded()) {
            fragmentManager.beginTransaction().add(this.f59034d, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.f59031a.setOnDismissListener(new c());
        try {
            this.f59031a.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new StatisticItem("c13126"));
        } catch (Throwable unused) {
        }
    }

    public a() {
        this.f59032b = new Handler();
        this.f59036f = new C1415a();
        this.f59037g = new b();
        this.f59033c = new d.a.n0.e3.l0.a();
        this.f59033c.a(new EasterEggBridge());
        this.f59034d = new ActivityLifeCycleListener();
    }
}
