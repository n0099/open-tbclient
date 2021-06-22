package d.a.o0.h0;

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
    public PopupWindow f59156a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f59157b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.e3.l0.a f59158c;

    /* renamed from: d  reason: collision with root package name */
    public ActivityLifeCycleListener f59159d;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f59160e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.e3.l0.c f59161f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f59162g;

    /* renamed from: d.a.o0.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1419a implements d.a.o0.e3.l0.c {
        public C1419a() {
        }

        @Override // d.a.o0.e3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            return a.this.f59158c != null && a.this.f59158c.b(a.this.f59160e, str, jsPromptResult);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f59157b.removeCallbacksAndMessages(null);
            a.this.e();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a.this.f59156a = null;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59166e;

        public d(String str) {
            this.f59166e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.h(this.f59166e);
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
            a.this.f59157b.removeCallbacksAndMessages(null);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BaseWebView.h {
        public f() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            a.this.f59157b.removeCallbacksAndMessages(null);
            a.this.e();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59170e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f59171f;

        public g(String str, String str2) {
            this.f59170e = str;
            this.f59171f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.i(this.f59170e, this.f59171f);
            } catch (Throwable unused) {
                a.this.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59173e;

        public h(String str) {
            this.f59173e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!k.isEmpty(this.f59173e) && (view.getContext() instanceof TbPageContextSupport)) {
                TiebaStatic.log(new StatisticItem("c13451").param("obj_type", 1));
                UrlManager.getInstance().dealOneLink(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{this.f59173e});
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
            a.this.f59157b.removeCallbacksAndMessages(null);
        }
    }

    /* loaded from: classes4.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public static a f59176a = new a(null);
    }

    public /* synthetic */ a(C1419a c1419a) {
        this();
    }

    public static a f() {
        return j.f59176a;
    }

    public void e() {
        PopupWindow popupWindow = this.f59156a;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        try {
            this.f59156a.dismiss();
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
            this.f59157b.postDelayed(new d(str), 1000L);
            return;
        }
        PopupWindow popupWindow = this.f59156a;
        if (popupWindow != null && popupWindow.isShowing()) {
            if (this.f59156a.getContentView() != null && this.f59156a.getContentView().getContext() == b2) {
                return;
            }
            e();
        }
        View inflate = LayoutInflater.from(b2).inflate(R.layout.easter_egg_dialog_h5_layout, (ViewGroup) null);
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BaseWebView baseWebView = (BaseWebView) inflate.findViewById(R.id.dialog_webview);
        this.f59160e = baseWebView;
        baseWebView.loadUrl(str);
        this.f59160e.setOnPageFinishedListener(new e());
        this.f59160e.setOnReceivedErrorListener(new f());
        this.f59160e.setBackgroundColor(0);
        this.f59160e.setOnJsPromptCallback(this.f59161f);
        j(b2, inflate);
    }

    public void i(String str, String str2) {
        Activity b2;
        if (k.isEmpty(str)) {
            return;
        }
        PopupWindow popupWindow = this.f59156a;
        if ((popupWindow == null || !popupWindow.isShowing()) && (b2 = d.a.c.a.b.f().b()) != null && PermissionUtil.checkWriteExternalStorage(b2)) {
            if (g(b2)) {
                this.f59157b.postDelayed(new g(str, str2), 1000L);
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
        this.f59156a = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.f59156a.setWidth(l.k(activity));
        this.f59156a.setHeight(l.i(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f59156a.setContentView(view);
        this.f59157b.removeCallbacksAndMessages(null);
        this.f59157b.postDelayed(this.f59162g, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null && !this.f59159d.isAdded()) {
            fragmentManager.beginTransaction().add(this.f59159d, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.f59156a.setOnDismissListener(new c());
        try {
            this.f59156a.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new StatisticItem("c13126"));
        } catch (Throwable unused) {
        }
    }

    public a() {
        this.f59157b = new Handler();
        this.f59161f = new C1419a();
        this.f59162g = new b();
        this.f59158c = new d.a.o0.e3.l0.a();
        this.f59158c.a(new EasterEggBridge());
        this.f59159d = new ActivityLifeCycleListener();
    }
}
