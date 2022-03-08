package com.kwad.sdk.splashscreen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.z;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public Context a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f56386b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f56387c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f56388d;

    /* renamed from: e  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f56389e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f56390f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f56391g;

    /* renamed from: h  reason: collision with root package name */
    public View f56392h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f56393i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f56394j;
    public long k;
    public boolean l;
    public long m;
    public boolean n;
    public final WindowManager.LayoutParams o = new WindowManager.LayoutParams();

    /* renamed from: com.kwad.sdk.splashscreen.b$3  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        public final /* synthetic */ Rect a;

        public AnonymousClass3(Rect rect) {
            this.a = rect;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            b.this.o.x = this.a.left - com.kwad.sdk.a.kwai.a.a(b.this.a, 6.0f);
            b.this.o.y = this.a.top - com.kwad.sdk.a.kwai.a.a(b.this.a, 6.0f);
            WindowManager.LayoutParams layoutParams = b.this.o;
            Rect rect = this.a;
            layoutParams.width = (rect.right - rect.left) + com.kwad.sdk.a.kwai.a.a(b.this.a, 12.0f);
            WindowManager.LayoutParams layoutParams2 = b.this.o;
            Rect rect2 = this.a;
            layoutParams2.height = (rect2.bottom - rect2.top) + com.kwad.sdk.a.kwai.a.a(b.this.a, 12.0f);
            b.this.f56387c.animate().cancel();
            b.this.f56393i.setImageDrawable(new BitmapDrawable(b.this.a.getResources(), b.this.f56388d.a));
            ViewParent parent = b.this.f56388d.a().getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(b.this.f56388d.a());
            }
            b.this.f56391g.addView(b.this.f56388d.a(), new ViewGroup.MarginLayoutParams(-1, -1));
            if (b.this.f56386b != null) {
                try {
                    b.this.f56386b.addView(b.this.f56390f, b.this.o);
                } catch (Exception e2) {
                    com.kwad.sdk.core.kwai.a.a(e2);
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
            b.this.f56388d.d();
            b.this.f56388d.a(new com.kwad.sdk.contentalliance.detail.video.d() { // from class: com.kwad.sdk.splashscreen.b.3.1

                /* renamed from: b  reason: collision with root package name */
                public boolean f56403b = false;

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a() {
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i2, int i3) {
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a(long j2, long j3) {
                    b.this.b();
                    b.this.c();
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void b() {
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void c() {
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void d() {
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void e() {
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void f() {
                    WindowManager windowManager;
                    ViewGroup viewGroup;
                    if (this.f56403b) {
                        return;
                    }
                    this.f56403b = true;
                    if (b.this.f56389e != null) {
                        b.this.f56389e.onAdShowEnd();
                    }
                    ax.a(new Runnable() { // from class: com.kwad.sdk.splashscreen.b.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.f56388d.h();
                        }
                    }, 0L);
                    if (b.this.f56386b != null) {
                        try {
                            if (Build.VERSION.SDK_INT < 19) {
                                windowManager = b.this.f56386b;
                                viewGroup = b.this.f56390f;
                            } else if (!b.this.f56390f.isAttachedToWindow()) {
                                return;
                            } else {
                                windowManager = b.this.f56386b;
                                viewGroup = b.this.f56390f;
                            }
                            windowManager.removeView(viewGroup);
                        } catch (Exception e3) {
                            com.kwad.sdk.core.kwai.a.a(e3);
                        }
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void g() {
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void h() {
                }
            });
            b.this.f56387c.postDelayed(new bd(new Runnable() { // from class: com.kwad.sdk.splashscreen.b.3.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.l = true;
                    b.this.a();
                }
            }), 100L);
            b.this.m = System.currentTimeMillis() + 100;
            b.this.f56393i.postDelayed(new bd(new Runnable() { // from class: com.kwad.sdk.splashscreen.b.3.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.f56393i.setVisibility(8);
                    b.this.f56394j = true;
                }
            }), 200L);
            b.this.k = System.currentTimeMillis() + 200;
        }
    }

    @RequiresApi(api = 21)
    /* loaded from: classes8.dex */
    public static class a extends ViewOutlineProvider {
        public float a;

        public a(float f2) {
            this.a = f2;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            float f2 = this.a;
            int i2 = (int) f2;
            int i3 = (int) f2;
            outline.setRoundRect(new Rect(i2, i3, (rect.right - rect.left) - i2, (rect.bottom - rect.top) - i3), this.a);
        }
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public b(Context context, String str, boolean z, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        if (context == null) {
            return;
        }
        Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(context);
        this.a = wrapContextIfNeed;
        this.f56389e = splashScreenAdInteractionListener;
        this.n = z;
        this.f56386b = (WindowManager) wrapContextIfNeed.getSystemService("window");
        com.kwad.sdk.splashscreen.b.a a2 = SplashPlayModuleCache.a().a(str);
        this.f56388d = a2;
        if (a2 == null || this.f56386b == null) {
            return;
        }
        ImageView imageView = new ImageView(this.a);
        this.f56387c = imageView;
        imageView.setImageDrawable(new BitmapDrawable(this.a.getResources(), this.f56388d.a));
        final AdTemplate b2 = this.f56388d.b();
        final com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(b2);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R.layout.ksad_splash_vplush, (ViewGroup) null);
        this.f56390f = viewGroup;
        this.f56393i = (ImageView) viewGroup.findViewById(R.id.ksad_splash_frame);
        this.f56391g = (FrameLayout) this.f56390f.findViewById(R.id.ksad_splash_texture);
        this.f56392h = this.f56390f.findViewById(R.id.ksad_splash_close_btn);
        this.f56391g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.n) {
                    com.kwad.sdk.core.download.a.a.a(new a.C2095a(view.getContext()).a(b2).a(bVar).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.splashscreen.b.1.1
                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            if (b.this.f56389e != null) {
                                b.this.f56389e.onAdClicked();
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("duration", b.this.f56388d.c());
                            } catch (JSONException e2) {
                                com.kwad.sdk.core.d.a.b(e2);
                            }
                            com.kwad.sdk.core.report.a.a(b2, 114, (z.a) null, jSONObject);
                        }
                    }));
                    if (b.this.f56386b != null) {
                        try {
                            b.this.f56386b.removeView(b.this.f56390f);
                        } catch (Exception e2) {
                            com.kwad.sdk.core.kwai.a.a(e2);
                            com.kwad.sdk.core.d.a.b(e2);
                        }
                    }
                }
            }
        });
        this.f56391g.setClickable(true);
        this.f56391g.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.splashscreen.b.2
            public float a = 0.0f;

            /* renamed from: b  reason: collision with root package name */
            public float f56397b = 0.0f;

            /* renamed from: c  reason: collision with root package name */
            public float f56398c = 0.0f;

            /* renamed from: d  reason: collision with root package name */
            public float f56399d = 0.0f;

            /* renamed from: e  reason: collision with root package name */
            public float f56400e = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (b.this.o == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.a = motionEvent.getRawX();
                    this.f56397b = motionEvent.getRawY();
                    this.f56399d = b.this.o.x;
                    this.f56398c = b.this.o.y;
                    this.f56400e = (float) SystemClock.elapsedRealtime();
                    PrintStream printStream = System.out;
                    printStream.println(" actionDownX " + this.a + " actionDownX " + this.a);
                } else if (motionEvent.getActionMasked() == 2) {
                    float rawX = motionEvent.getRawX() - this.a;
                    float rawY = motionEvent.getRawY() - this.f56397b;
                    if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                        b.this.o.x = (int) (this.f56399d + rawX);
                        b.this.o.y = (int) (this.f56398c + rawY);
                        if (b.this.f56386b != null) {
                            try {
                                b.this.f56386b.updateViewLayout(b.this.f56390f, b.this.o);
                            } catch (Exception e2) {
                                com.kwad.sdk.core.kwai.a.a(e2);
                                com.kwad.sdk.core.d.a.b(e2);
                            }
                        }
                    }
                    return true;
                } else if (motionEvent.getActionMasked() == 1) {
                    float rawX2 = motionEvent.getRawX() - this.a;
                    float rawY2 = motionEvent.getRawY() - this.f56397b;
                    float elapsedRealtime = ((float) SystemClock.elapsedRealtime()) - this.f56400e;
                    if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f) {
                        view.performClick();
                    }
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            this.f56386b.removeView(this.f56387c);
        } catch (Exception e2) {
            com.kwad.sdk.core.kwai.a.a(e2);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f56388d.a().setOutlineProvider(new a(com.kwad.sdk.a.kwai.a.a(this.a, 1.0f)));
            this.f56388d.a().setClipToOutline(true);
            this.f56393i.setOutlineProvider(new a(com.kwad.sdk.a.kwai.a.a(this.a, 1.0f)));
            this.f56393i.setClipToOutline(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.l || System.currentTimeMillis() <= this.m) {
            return;
        }
        this.l = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f56394j || System.currentTimeMillis() <= this.k) {
            return;
        }
        this.f56394j = true;
        this.f56393i.setVisibility(8);
    }

    @SuppressLint({"RtlHardcoded"})
    public boolean a(Rect rect) {
        if (this.f56388d == null || this.f56386b == null) {
            return false;
        }
        Rect rect2 = new Rect();
        rect2.left = rect.left - com.kwad.sdk.a.kwai.a.a(this.a, 6.0f);
        rect2.right = rect.right - com.kwad.sdk.a.kwai.a.a(this.a, 6.0f);
        rect2.top = rect.top - com.kwad.sdk.a.kwai.a.a(this.a, 6.0f);
        rect2.bottom = rect.bottom + com.kwad.sdk.a.kwai.a.a(this.a, 6.0f);
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        WindowManager.LayoutParams layoutParams = this.o;
        layoutParams.type = 1003;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.format = 1;
        int i2 = displayMetrics.widthPixels;
        layoutParams.width = i2;
        int i3 = displayMetrics.heightPixels;
        layoutParams.height = i3;
        layoutParams.x = 0;
        layoutParams.y = 0;
        int i4 = rect2.right;
        int i5 = rect2.left;
        float f2 = (i4 - i5) / i2;
        int i6 = rect2.bottom;
        int i7 = rect2.top;
        float f3 = (i6 - i7) / i3;
        float f4 = (i5 * i2) / ((i5 + i2) - i4);
        this.f56387c.setPivotX(f4);
        this.f56387c.setPivotY((i7 * i3) / ((i7 + i3) - i6));
        WindowManager windowManager = this.f56386b;
        if (windowManager != null) {
            try {
                windowManager.addView(this.f56387c, this.o);
            } catch (Exception e2) {
                com.kwad.sdk.core.kwai.a.a(e2);
                com.kwad.sdk.core.d.a.b(e2);
            }
        }
        this.f56387c.animate().scaleX(f2).scaleY(f3).setDuration(600L).start();
        this.f56387c.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnonymousClass3(rect2));
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f56389e;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
        com.kwad.sdk.core.report.a.c(this.f56388d.b(), 115, null);
        this.f56392h.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f56386b != null) {
                    try {
                        b.this.f56386b.removeView(b.this.f56390f);
                        b.this.f56388d.h();
                    } catch (Exception e3) {
                        com.kwad.sdk.core.kwai.a.a(e3);
                    }
                }
                if (b.this.f56389e != null) {
                    b.this.f56389e.onSkippedAd();
                }
                if (b.this.f56388d != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("duration", b.this.f56388d.c());
                    } catch (JSONException e4) {
                        com.kwad.sdk.core.d.a.b(e4);
                    }
                    com.kwad.sdk.core.report.a.a(b.this.f56388d.b(), 1, jSONObject);
                }
            }
        });
        return true;
    }
}
