package com.kwad.components.ad.splashscreen;

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
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.m.o;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bd;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class c {
    public Context mContext;
    public ViewGroup uL;
    public boolean xA;
    public long xB;
    public boolean xC;
    public long xD;
    public boolean xE;
    public final WindowManager.LayoutParams xF = new WindowManager.LayoutParams();
    @Nullable
    public WindowManager xt;
    public ImageView xu;
    public com.kwad.components.ad.splashscreen.c.a xv;
    public KsSplashScreenAd.SplashScreenAdInteractionListener xw;
    public FrameLayout xx;
    public View xy;
    public ImageView xz;

    /* renamed from: com.kwad.components.ad.splashscreen.c$3  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        public final /* synthetic */ Rect xN;

        public AnonymousClass3(Rect rect) {
            this.xN = rect;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c.this.xF.x = this.xN.left - com.kwad.sdk.b.kwai.a.a(c.this.mContext, 6.0f);
            c.this.xF.y = this.xN.top - com.kwad.sdk.b.kwai.a.a(c.this.mContext, 6.0f);
            WindowManager.LayoutParams layoutParams = c.this.xF;
            Rect rect = this.xN;
            layoutParams.width = (rect.right - rect.left) + com.kwad.sdk.b.kwai.a.a(c.this.mContext, 12.0f);
            WindowManager.LayoutParams layoutParams2 = c.this.xF;
            Rect rect2 = this.xN;
            layoutParams2.height = (rect2.bottom - rect2.top) + com.kwad.sdk.b.kwai.a.a(c.this.mContext, 12.0f);
            c.this.xu.animate().cancel();
            c.this.xz.setImageDrawable(new BitmapDrawable(c.this.mContext.getResources(), c.this.xv.mBitmap));
            ViewParent parent = c.this.xv.ky().getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(c.this.xv.ky());
            }
            c.this.xx.addView(c.this.xv.ky(), new ViewGroup.MarginLayoutParams(-1, -1));
            if (c.this.xt != null) {
                try {
                    c.this.xt.addView(c.this.uL, c.this.xF);
                } catch (Exception e) {
                    com.kwad.components.core.b.a.b(e);
                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                }
            }
            c.this.xv.resume();
            c.this.xv.a(new com.kwad.components.core.video.g() { // from class: com.kwad.components.ad.splashscreen.c.3.1
                public boolean xO = false;

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayBufferingPaused() {
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayBufferingPlaying() {
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayCompleted() {
                    if (this.xO) {
                        return;
                    }
                    this.xO = true;
                    if (c.this.xw != null) {
                        c.this.xw.onAdShowEnd();
                    }
                    bd.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.3.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.this.xv.release();
                        }
                    }, 0L);
                    if (c.this.xt != null) {
                        try {
                            if (Build.VERSION.SDK_INT < 19) {
                                c.this.xt.removeView(c.this.uL);
                            } else if (c.this.uL.isAttachedToWindow()) {
                                c.this.xt.removeView(c.this.uL);
                            }
                        } catch (Exception e2) {
                            com.kwad.components.core.b.a.b(e2);
                        }
                    }
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayError(int i, int i2) {
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayPaused() {
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayProgress(long j, long j2) {
                    c.this.jq();
                    c.this.jr();
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayStart() {
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlaying() {
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPrepared() {
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPreparing() {
                }
            });
            c.this.xu.postDelayed(new o(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.3.2
                @Override // java.lang.Runnable
                public final void run() {
                    c.a(c.this, true);
                    c.this.jp();
                }
            }), 100L);
            c.this.xD = System.currentTimeMillis() + 100;
            c.this.xz.postDelayed(new o(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.3.3
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.xz.setVisibility(8);
                    c.b(c.this, true);
                }
            }), 200L);
            c.this.xB = System.currentTimeMillis() + 200;
        }
    }

    @RequiresApi(api = 21)
    /* loaded from: classes9.dex */
    public static class a extends ViewOutlineProvider {
        public float wm;

        public a(float f) {
            this.wm = f;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view2, Outline outline) {
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            float f = this.wm;
            int i = (int) f;
            int i2 = (int) f;
            outline.setRoundRect(new Rect(i, i2, (rect.right - rect.left) - i, (rect.bottom - rect.top) - i2), this.wm);
        }
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public c(Context context, String str, boolean z, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        if (context == null) {
            return;
        }
        Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(context);
        this.mContext = wrapContextIfNeed;
        this.xw = splashScreenAdInteractionListener;
        this.xE = z;
        this.xt = (WindowManager) wrapContextIfNeed.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        com.kwad.components.ad.splashscreen.c.a X = SplashPlayModuleCache.getInstance().X(str);
        this.xv = X;
        if (X == null || this.xt == null) {
            return;
        }
        ImageView imageView = new ImageView(this.mContext);
        this.xu = imageView;
        imageView.setImageDrawable(new BitmapDrawable(this.mContext.getResources(), this.xv.mBitmap));
        final AdTemplate adTemplate = this.xv.getAdTemplate();
        final com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(adTemplate);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d04db, (ViewGroup) null);
        this.uL = viewGroup;
        this.xz = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913d9);
        this.xx = (FrameLayout) this.uL.findViewById(R.id.obfuscated_res_0x7f0913e3);
        this.xy = this.uL.findViewById(R.id.obfuscated_res_0x7f0913d7);
        this.xx.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (c.this.xE) {
                    com.kwad.components.core.c.a.a.a(new a.C0641a(view2.getContext()).L(adTemplate).b(cVar).aj(false).ae(2).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.c.1.1
                        @Override // com.kwad.components.core.c.a.a.b
                        public final void onAdClicked() {
                            if (c.this.xw != null) {
                                c.this.xw.onAdClicked();
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("duration", c.this.xv.getCurrentPosition());
                            } catch (JSONException e) {
                                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                            }
                            com.kwad.sdk.core.report.a.a(adTemplate, 114, (aa.a) null, jSONObject);
                        }
                    }));
                    if (c.this.xt != null) {
                        try {
                            c.this.xt.removeView(c.this.uL);
                        } catch (Exception e) {
                            com.kwad.components.core.b.a.b(e);
                            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                        }
                    }
                }
            }
        });
        this.xx.setClickable(true);
        this.xx.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.splashscreen.c.2
            public float xK = 0.0f;
            public float xL = 0.0f;
            public float top = 0.0f;
            public float left = 0.0f;
            public long xM = 0;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                if (c.this.xF == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.xK = motionEvent.getRawX();
                    this.xL = motionEvent.getRawY();
                    this.left = c.this.xF.x;
                    this.top = c.this.xF.y;
                    this.xM = SystemClock.elapsedRealtime();
                    PrintStream printStream = System.out;
                    printStream.println(" actionDownX " + this.xK + " actionDownX " + this.xK);
                } else if (motionEvent.getActionMasked() == 2) {
                    float rawX = motionEvent.getRawX() - this.xK;
                    float rawY = motionEvent.getRawY() - this.xL;
                    if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                        c.this.xF.x = (int) (this.left + rawX);
                        c.this.xF.y = (int) (this.top + rawY);
                        if (c.this.xt != null) {
                            try {
                                c.this.xt.updateViewLayout(c.this.uL, c.this.xF);
                            } catch (Exception e) {
                                com.kwad.components.core.b.a.b(e);
                                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                            }
                        }
                    }
                    return true;
                } else if (motionEvent.getActionMasked() == 1) {
                    float rawX2 = motionEvent.getRawX() - this.xK;
                    float rawY2 = motionEvent.getRawY() - this.xL;
                    float elapsedRealtime = (float) (SystemClock.elapsedRealtime() - this.xM);
                    if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f) {
                        view2.performClick();
                    }
                }
                return true;
            }
        });
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.xC = true;
        return true;
    }

    public static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.xA = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jp() {
        try {
            this.xt.removeView(this.xu);
        } catch (Exception e) {
            com.kwad.components.core.b.a.b(e);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.xv.ky().setOutlineProvider(new a(com.kwad.sdk.b.kwai.a.a(this.mContext, 1.0f)));
            this.xv.ky().setClipToOutline(true);
            this.xz.setOutlineProvider(new a(com.kwad.sdk.b.kwai.a.a(this.mContext, 1.0f)));
            this.xz.setClipToOutline(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq() {
        if (this.xC || System.currentTimeMillis() <= this.xD) {
            return;
        }
        this.xC = true;
        jp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr() {
        if (this.xA || System.currentTimeMillis() <= this.xB) {
            return;
        }
        this.xA = true;
        this.xz.setVisibility(8);
    }

    @SuppressLint({"RtlHardcoded"})
    public final boolean a(Rect rect) {
        if (this.xv == null || this.xt == null) {
            return false;
        }
        Rect rect2 = new Rect();
        rect2.left = rect.left - com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f);
        rect2.right = rect.right - com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f);
        rect2.top = rect.top - com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f);
        rect2.bottom = rect.bottom + com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        WindowManager.LayoutParams layoutParams = this.xF;
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
        float f = (i3 - i4) / i;
        int i5 = rect2.bottom;
        int i6 = rect2.top;
        float f2 = (i5 - i6) / i2;
        float f3 = (i4 * i) / ((i4 + i) - i3);
        this.xu.setPivotX(f3);
        this.xu.setPivotY((i6 * i2) / ((i6 + i2) - i5));
        WindowManager windowManager = this.xt;
        if (windowManager != null) {
            try {
                windowManager.addView(this.xu, this.xF);
            } catch (Exception e) {
                com.kwad.components.core.b.a.b(e);
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
        this.xu.animate().scaleX(f).scaleY(f2).setDuration(600L).start();
        this.xu.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnonymousClass3(rect2));
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.xw;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
        com.kwad.sdk.core.report.a.c(this.xv.getAdTemplate(), 115, (JSONObject) null);
        this.xy.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (c.this.xt != null) {
                    try {
                        c.this.xt.removeView(c.this.uL);
                        c.this.xv.release();
                    } catch (Exception e2) {
                        com.kwad.components.core.b.a.b(e2);
                    }
                }
                if (c.this.xw != null) {
                    c.this.xw.onSkippedAd();
                }
                com.kwad.sdk.kwai.kwai.c.rd().rg();
                if (c.this.xv != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("duration", c.this.xv.getCurrentPosition());
                    } catch (JSONException e3) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(e3);
                    }
                    com.kwad.sdk.core.report.a.a(c.this.xv.getAdTemplate(), 1, jSONObject);
                }
            }
        });
        return true;
    }

    public final void jo() {
        ViewGroup viewGroup;
        WindowManager windowManager = this.xt;
        if (windowManager != null && (viewGroup = this.uL) != null) {
            windowManager.removeView(viewGroup);
        }
        com.kwad.components.ad.splashscreen.c.a aVar = this.xv;
        if (aVar != null) {
            aVar.release();
        }
    }
}
