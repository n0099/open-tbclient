package d.b.i0.g0;

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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f54876a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f54877b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.c3.l0.a f54878c;

    /* renamed from: d  reason: collision with root package name */
    public ActivityLifeCycleListener f54879d;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f54880e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.c3.l0.c f54881f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f54882g;

    /* renamed from: d.b.i0.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1255a implements d.b.i0.c3.l0.c {
        public C1255a() {
        }

        @Override // d.b.i0.c3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            return a.this.f54878c != null && a.this.f54878c.b(a.this.f54880e, str, jsPromptResult);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f54877b.removeCallbacksAndMessages(null);
            a.this.e();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a.this.f54876a = null;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54886e;

        public d(String str) {
            this.f54886e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.h(this.f54886e);
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
            a.this.f54877b.removeCallbacksAndMessages(null);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BaseWebView.h {
        public f() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            a.this.f54877b.removeCallbacksAndMessages(null);
            a.this.e();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54890e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f54891f;

        public g(String str, String str2) {
            this.f54890e = str;
            this.f54891f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.i(this.f54890e, this.f54891f);
            } catch (Throwable unused) {
                a.this.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54893e;

        public h(String str) {
            this.f54893e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!k.isEmpty(this.f54893e) && (view.getContext() instanceof TbPageContextSupport)) {
                TiebaStatic.log(new StatisticItem("c13451").param("obj_type", 1));
                UrlManager.getInstance().dealOneLink(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{this.f54893e});
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
            a.this.f54877b.removeCallbacksAndMessages(null);
        }
    }

    /* loaded from: classes4.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public static a f54896a = new a(null);
    }

    public /* synthetic */ a(C1255a c1255a) {
        this();
    }

    public static a f() {
        return j.f54896a;
    }

    public void e() {
        PopupWindow popupWindow = this.f54876a;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        try {
            this.f54876a.dismiss();
        } catch (Throwable unused) {
        }
    }

    public final boolean g(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }

    public void h(String str) {
        Activity b2;
        if (k.isEmpty(str) || (b2 = d.b.b.a.b.f().b()) == null || b2.getWindow() == null || b2.getWindow().getDecorView() == null) {
            return;
        }
        if (g(b2)) {
            this.f54877b.postDelayed(new d(str), 1000L);
            return;
        }
        PopupWindow popupWindow = this.f54876a;
        if (popupWindow != null && popupWindow.isShowing()) {
            if (this.f54876a.getContentView() != null && this.f54876a.getContentView().getContext() == b2) {
                return;
            }
            e();
        }
        View inflate = LayoutInflater.from(b2).inflate(R.layout.easter_egg_dialog_h5_layout, (ViewGroup) null);
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BaseWebView baseWebView = (BaseWebView) inflate.findViewById(R.id.dialog_webview);
        this.f54880e = baseWebView;
        baseWebView.loadUrl(str);
        this.f54880e.setOnPageFinishedListener(new e());
        this.f54880e.setOnReceivedErrorListener(new f());
        this.f54880e.setBackgroundColor(0);
        this.f54880e.setOnJsPromptCallback(this.f54881f);
        j(b2, inflate);
    }

    public void i(String str, String str2) {
        Activity b2;
        if (k.isEmpty(str)) {
            return;
        }
        PopupWindow popupWindow = this.f54876a;
        if ((popupWindow == null || !popupWindow.isShowing()) && (b2 = d.b.b.a.b.f().b()) != null && PermissionUtil.checkWriteExternalStorage(b2)) {
            if (g(b2)) {
                this.f54877b.postDelayed(new g(str, str2), 1000L);
                return;
            }
            View inflate = LayoutInflater.from(b2).inflate(R.layout.easter_egg_dialog_lottie_layout, (ViewGroup) null);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(R.id.easter_egg_lottie_view);
            tBLottieAnimationView.setBackgroundResource(R.color.transparent);
            tBLottieAnimationView.setAnimationUrl(str);
            tBLottieAnimationView.useHardwareAcceleration(true);
            tBLottieAnimationView.enableMergePathsForKitKatAndAbove(true);
            tBLottieAnimationView.setOnClickListener(new h(str2));
            tBLottieAnimationView.addAnimatorListener(new i());
            tBLottieAnimationView.playAnimation();
            j(b2, inflate);
        }
    }

    public final void j(Activity activity, View view) {
        PopupWindow popupWindow = new PopupWindow(activity);
        this.f54876a = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.f54876a.setWidth(l.k(activity));
        this.f54876a.setHeight(l.i(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f54876a.setContentView(view);
        this.f54877b.removeCallbacksAndMessages(null);
        this.f54877b.postDelayed(this.f54882g, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null && !this.f54879d.isAdded()) {
            fragmentManager.beginTransaction().add(this.f54879d, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.f54876a.setOnDismissListener(new c());
        try {
            this.f54876a.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new StatisticItem("c13126"));
        } catch (Throwable unused) {
        }
    }

    public a() {
        this.f54877b = new Handler();
        this.f54881f = new C1255a();
        this.f54882g = new b();
        this.f54878c = new d.b.i0.c3.l0.a();
        this.f54878c.a(new EasterEggBridge());
        this.f54879d = new ActivityLifeCycleListener();
    }
}
