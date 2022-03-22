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
/* loaded from: classes7.dex */
public class b {
    public Context a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f41287b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f41288c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f41289d;

    /* renamed from: e  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f41290e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f41291f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f41292g;

    /* renamed from: h  reason: collision with root package name */
    public View f41293h;
    public ImageView i;
    public boolean j;
    public long k;
    public boolean l;
    public long m;
    public boolean n;
    public final WindowManager.LayoutParams o = new WindowManager.LayoutParams();

    /* renamed from: com.kwad.sdk.splashscreen.b$3  reason: invalid class name */
    /* loaded from: classes7.dex */
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
            b.this.f41288c.animate().cancel();
            b.this.i.setImageDrawable(new BitmapDrawable(b.this.a.getResources(), b.this.f41289d.a));
            ViewParent parent = b.this.f41289d.a().getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(b.this.f41289d.a());
            }
            b.this.f41292g.addView(b.this.f41289d.a(), new ViewGroup.MarginLayoutParams(-1, -1));
            if (b.this.f41287b != null) {
                try {
                    b.this.f41287b.addView(b.this.f41291f, b.this.o);
                } catch (Exception e2) {
                    com.kwad.sdk.core.kwai.a.a(e2);
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
            b.this.f41289d.d();
            b.this.f41289d.a(new com.kwad.sdk.contentalliance.detail.video.d() { // from class: com.kwad.sdk.splashscreen.b.3.1

                /* renamed from: b  reason: collision with root package name */
                public boolean f41302b = false;

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a() {
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i, int i2) {
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a(long j, long j2) {
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
                    if (this.f41302b) {
                        return;
                    }
                    this.f41302b = true;
                    if (b.this.f41290e != null) {
                        b.this.f41290e.onAdShowEnd();
                    }
                    ax.a(new Runnable() { // from class: com.kwad.sdk.splashscreen.b.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.f41289d.h();
                        }
                    }, 0L);
                    if (b.this.f41287b != null) {
                        try {
                            if (Build.VERSION.SDK_INT < 19) {
                                windowManager = b.this.f41287b;
                                viewGroup = b.this.f41291f;
                            } else if (!b.this.f41291f.isAttachedToWindow()) {
                                return;
                            } else {
                                windowManager = b.this.f41287b;
                                viewGroup = b.this.f41291f;
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
            b.this.f41288c.postDelayed(new bd(new Runnable() { // from class: com.kwad.sdk.splashscreen.b.3.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.l = true;
                    b.this.a();
                }
            }), 100L);
            b.this.m = System.currentTimeMillis() + 100;
            b.this.i.postDelayed(new bd(new Runnable() { // from class: com.kwad.sdk.splashscreen.b.3.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.i.setVisibility(8);
                    b.this.j = true;
                }
            }), 200L);
            b.this.k = System.currentTimeMillis() + 200;
        }
    }

    @RequiresApi(api = 21)
    /* loaded from: classes7.dex */
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
            int i = (int) f2;
            int i2 = (int) f2;
            outline.setRoundRect(new Rect(i, i2, (rect.right - rect.left) - i, (rect.bottom - rect.top) - i2), this.a);
        }
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public b(Context context, String str, boolean z, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        if (context == null) {
            return;
        }
        Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(context);
        this.a = wrapContextIfNeed;
        this.f41290e = splashScreenAdInteractionListener;
        this.n = z;
        this.f41287b = (WindowManager) wrapContextIfNeed.getSystemService("window");
        com.kwad.sdk.splashscreen.b.a a2 = SplashPlayModuleCache.a().a(str);
        this.f41289d = a2;
        if (a2 == null || this.f41287b == null) {
            return;
        }
        ImageView imageView = new ImageView(this.a);
        this.f41288c = imageView;
        imageView.setImageDrawable(new BitmapDrawable(this.a.getResources(), this.f41289d.a));
        final AdTemplate b2 = this.f41289d.b();
        final com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(b2);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0476, (ViewGroup) null);
        this.f41291f = viewGroup;
        this.i = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091144);
        this.f41292g = (FrameLayout) this.f41291f.findViewById(R.id.obfuscated_res_0x7f09114a);
        this.f41293h = this.f41291f.findViewById(R.id.obfuscated_res_0x7f091142);
        this.f41292g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.n) {
                    com.kwad.sdk.core.download.a.a.a(new a.C1956a(view.getContext()).a(b2).a(bVar).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.splashscreen.b.1.1
                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            if (b.this.f41290e != null) {
                                b.this.f41290e.onAdClicked();
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("duration", b.this.f41289d.c());
                            } catch (JSONException e2) {
                                com.kwad.sdk.core.d.a.b(e2);
                            }
                            com.kwad.sdk.core.report.a.a(b2, 114, (z.a) null, jSONObject);
                        }
                    }));
                    if (b.this.f41287b != null) {
                        try {
                            b.this.f41287b.removeView(b.this.f41291f);
                        } catch (Exception e2) {
                            com.kwad.sdk.core.kwai.a.a(e2);
                            com.kwad.sdk.core.d.a.b(e2);
                        }
                    }
                }
            }
        });
        this.f41292g.setClickable(true);
        this.f41292g.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.splashscreen.b.2
            public float a = 0.0f;

            /* renamed from: b  reason: collision with root package name */
            public float f41296b = 0.0f;

            /* renamed from: c  reason: collision with root package name */
            public float f41297c = 0.0f;

            /* renamed from: d  reason: collision with root package name */
            public float f41298d = 0.0f;

            /* renamed from: e  reason: collision with root package name */
            public float f41299e = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (b.this.o == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.a = motionEvent.getRawX();
                    this.f41296b = motionEvent.getRawY();
                    this.f41298d = b.this.o.x;
                    this.f41297c = b.this.o.y;
                    this.f41299e = (float) SystemClock.elapsedRealtime();
                    PrintStream printStream = System.out;
                    printStream.println(" actionDownX " + this.a + " actionDownX " + this.a);
                } else if (motionEvent.getActionMasked() == 2) {
                    float rawX = motionEvent.getRawX() - this.a;
                    float rawY = motionEvent.getRawY() - this.f41296b;
                    if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                        b.this.o.x = (int) (this.f41298d + rawX);
                        b.this.o.y = (int) (this.f41297c + rawY);
                        if (b.this.f41287b != null) {
                            try {
                                b.this.f41287b.updateViewLayout(b.this.f41291f, b.this.o);
                            } catch (Exception e2) {
                                com.kwad.sdk.core.kwai.a.a(e2);
                                com.kwad.sdk.core.d.a.b(e2);
                            }
                        }
                    }
                    return true;
                } else if (motionEvent.getActionMasked() == 1) {
                    float rawX2 = motionEvent.getRawX() - this.a;
                    float rawY2 = motionEvent.getRawY() - this.f41296b;
                    float elapsedRealtime = ((float) SystemClock.elapsedRealtime()) - this.f41299e;
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
            this.f41287b.removeView(this.f41288c);
        } catch (Exception e2) {
            com.kwad.sdk.core.kwai.a.a(e2);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f41289d.a().setOutlineProvider(new a(com.kwad.sdk.a.kwai.a.a(this.a, 1.0f)));
            this.f41289d.a().setClipToOutline(true);
            this.i.setOutlineProvider(new a(com.kwad.sdk.a.kwai.a.a(this.a, 1.0f)));
            this.i.setClipToOutline(true);
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
        if (this.j || System.currentTimeMillis() <= this.k) {
            return;
        }
        this.j = true;
        this.i.setVisibility(8);
    }

    @SuppressLint({"RtlHardcoded"})
    public boolean a(Rect rect) {
        if (this.f41289d == null || this.f41287b == null) {
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
        int i = displayMetrics.widthPixels;
        layoutParams.width = i;
        int i2 = displayMetrics.heightPixels;
        layoutParams.height = i2;
        layoutParams.x = 0;
        layoutParams.y = 0;
        int i3 = rect2.right;
        int i4 = rect2.left;
        float f2 = (i3 - i4) / i;
        int i5 = rect2.bottom;
        int i6 = rect2.top;
        float f3 = (i5 - i6) / i2;
        float f4 = (i4 * i) / ((i4 + i) - i3);
        this.f41288c.setPivotX(f4);
        this.f41288c.setPivotY((i6 * i2) / ((i6 + i2) - i5));
        WindowManager windowManager = this.f41287b;
        if (windowManager != null) {
            try {
                windowManager.addView(this.f41288c, this.o);
            } catch (Exception e2) {
                com.kwad.sdk.core.kwai.a.a(e2);
                com.kwad.sdk.core.d.a.b(e2);
            }
        }
        this.f41288c.animate().scaleX(f2).scaleY(f3).setDuration(600L).start();
        this.f41288c.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnonymousClass3(rect2));
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f41290e;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
        com.kwad.sdk.core.report.a.c(this.f41289d.b(), 115, null);
        this.f41293h.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f41287b != null) {
                    try {
                        b.this.f41287b.removeView(b.this.f41291f);
                        b.this.f41289d.h();
                    } catch (Exception e3) {
                        com.kwad.sdk.core.kwai.a.a(e3);
                    }
                }
                if (b.this.f41290e != null) {
                    b.this.f41290e.onSkippedAd();
                }
                if (b.this.f41289d != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("duration", b.this.f41289d.c());
                    } catch (JSONException e4) {
                        com.kwad.sdk.core.d.a.b(e4);
                    }
                    com.kwad.sdk.core.report.a.a(b.this.f41289d.b(), 1, jSONObject);
                }
            }
        });
        return true;
    }
}
