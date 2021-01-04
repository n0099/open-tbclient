package com.ss.android.downloadlib.guide.install;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.f.i;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.downloader.b.e;
import com.ss.android.socialbase.downloader.m.g;
import java.lang.ref.WeakReference;
import java.util.Locale;
/* loaded from: classes4.dex */
public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Activity> f13292a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13293b;
    private String c;
    private TextView e;
    private TextView f;
    private TextView g;
    private ViewStub h;
    private boolean i;
    private String j;
    private View k;
    private View m;
    private Handler n;
    private int o;
    private ClipImageView pVA;
    private Drawable pVB;
    private m pVC;

    static /* synthetic */ int g(a aVar) {
        int i = aVar.o;
        aVar.o = i - 1;
        return i;
    }

    public a(@NonNull Activity activity, int i, String str, Drawable drawable, String str2, long j, @NonNull m mVar) {
        super(activity);
        this.n = new Handler(Looper.getMainLooper());
        this.f13292a = new WeakReference<>(activity);
        this.f13293b = i;
        this.c = str;
        this.pVB = drawable;
        this.j = str2;
        this.pVC = mVar;
        this.o = (int) (j / 1000);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(a.c.ttdownloader_dialog_apk_install_guide);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(a.C1191a.ttdownloader_bg_transparent);
            window.setLayout(-1, -1);
            window.setGravity(80);
        }
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.m.getHeight() * (-1), 0);
        ofInt.setInterpolator(new b(0.22f, 1.0f, 0.36f, 1.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ss.android.downloadlib.guide.install.a.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.m.getLayoutParams();
                marginLayoutParams.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                a.this.m.setLayoutParams(marginLayoutParams);
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.ss.android.downloadlib.guide.install.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.g();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofInt.setDuration(450L);
        ofInt.start();
    }

    private void b() {
        this.pVA = (ClipImageView) findViewById(a.b.app_icon_iv);
        this.f = (TextView) findViewById(a.b.install_app_tv);
        this.g = (TextView) findViewById(a.b.app_name_tv);
        this.h = (ViewStub) findViewById(a.b.install_hijack_view);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.guide.install.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.c();
            }
        });
        this.g.setText(this.c);
        this.pVA.setClip(true);
        this.pVA.setRoundRadius(i.a(j.a(), 4.0f));
        Bitmap a2 = com.ss.android.socialbase.appdownloader.e.c.eGq().a(this.f13293b);
        if (a2 != null) {
            this.pVA.setImageBitmap(a2);
        } else if (this.pVB != null) {
            this.pVA.setImageDrawable(this.pVB);
        }
        this.f.setText(String.format(Locale.getDefault(), "立即安装 %d 秒", Integer.valueOf(this.o)));
        this.k = findViewById(a.b.local_install_hijack_layout);
        this.m = findViewById(a.b.content_ll);
        d();
        this.m.post(new Runnable() { // from class: com.ss.android.downloadlib.guide.install.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
            }
        });
        TextView textView = (TextView) findViewById(a.b.kllk_install_tv);
        if (textView != null) {
            textView.setText(e.f13372b + "应用商店安装");
        }
        this.e = (TextView) findViewById(a.b.install_dialog_description);
        String str = "安装页面点击“继续安装”即可快速安装";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FA2D6C")), 4, "点击“继续安装”".length() + 4, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan((int) ViewCompat.MEASURED_STATE_MASK), 0, 4, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan((int) ViewCompat.MEASURED_STATE_MASK), "点击“继续安装”".length() + 4, str.length(), 33);
        this.e.setText(spannableStringBuilder);
        ((LinearLayout) findViewById(a.b.install_dialog_click_layout)).setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.guide.install.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Activity activity = this.f13292a.get();
        if (activity != null && !activity.isFinishing()) {
            dismiss();
        } else if (this.pVC != null) {
            this.pVC.a();
            this.pVC = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (com.ss.android.socialbase.downloader.k.a.SR(this.f13293b).a("install_guide_back", 1) == 1) {
            super.onBackPressed();
            c();
        }
    }

    private void d() {
        if (!this.i) {
            this.i = true;
            int e = e();
            if (e != 0) {
                this.h.setLayoutResource(e);
                this.h.inflate();
            }
        }
    }

    private int e() {
        if (g.b()) {
            return a.c.ttdownloader_layout_install_hijack_xiaomi;
        }
        if (g.d()) {
            return a.c.ttdownloader_layout_install_hijack_kllk;
        }
        if (g.c()) {
            return a.c.ttdownloader_layout_install_hijack_vivo;
        }
        if (!g.a()) {
            return 0;
        }
        return a.c.ttdownloader_layout_install_hijack_huawei;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        f();
    }

    private void f() {
        Activity activity = this.f13292a.get();
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
        if (this.pVC != null) {
            this.pVC.a();
            this.pVC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.n.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.guide.install.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.pVC != null) {
                    Activity activity = (Activity) a.this.f13292a.get();
                    if (activity == null || !activity.isFinishing()) {
                        a.g(a.this);
                        if (a.this.o > 0) {
                            a.this.f.setText(String.format(Locale.getDefault(), "立即安装 %d 秒", Integer.valueOf(a.this.o)));
                            a.this.g();
                            return;
                        }
                        a.this.c();
                    }
                }
            }
        }, 1000L);
    }
}
