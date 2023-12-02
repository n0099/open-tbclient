package com.kwad.components.core.page.splitLandingPage.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tieba.R;
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.e;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.m.l;
import java.io.PrintStream;
/* loaded from: classes10.dex */
public final class a {
    public ImageView IK;
    @Nullable
    public WindowManager PU;
    public com.kwad.components.core.page.splitLandingPage.a.a PV;
    public FrameLayout PW;
    public FrameLayout PX;
    public e PY;
    public final WindowManager.LayoutParams PZ = new WindowManager.LayoutParams();
    public InterfaceC0657a Qa;
    public ImageView eM;
    public com.kwad.sdk.core.video.videoview.a eN;
    public Context mContext;
    public ViewGroup yF;

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0657a {
        boolean pM();
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public a(Context context, com.kwad.components.core.page.splitLandingPage.a.a aVar) {
        if (context == null) {
            return;
        }
        Context wrapContextIfNeed = l.wrapContextIfNeed(context);
        this.mContext = wrapContextIfNeed;
        this.PV = aVar;
        WindowManager windowManager = (WindowManager) wrapContextIfNeed.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        this.PU = windowManager;
        if (windowManager == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d051c, (ViewGroup) null);
        this.yF = viewGroup;
        this.PW = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0914d5);
        this.PX = (FrameLayout) this.yF.findViewById(R.id.obfuscated_res_0x7f0914e8);
        this.eM = (ImageView) this.yF.findViewById(R.id.obfuscated_res_0x7f0914f8);
        this.IK = (ImageView) this.yF.findViewById(R.id.obfuscated_res_0x7f0914d4);
        this.PW.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.1
            public float Qb = 0.0f;
            public float Qc = 0.0f;
            public float top = 0.0f;
            public float left = 0.0f;
            public long Qd = 0;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                if (a.this.PZ == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.Qb = motionEvent.getRawX();
                    this.Qc = motionEvent.getRawY();
                    this.left = a.this.PZ.x;
                    this.top = a.this.PZ.y;
                    this.Qd = SystemClock.elapsedRealtime();
                    PrintStream printStream = System.out;
                    printStream.println(" actionDownX " + this.Qb + " actionDownX " + this.Qb);
                } else if (motionEvent.getActionMasked() == 2) {
                    float rawX = motionEvent.getRawX() - this.Qb;
                    float rawY = motionEvent.getRawY() - this.Qc;
                    if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                        a.this.PZ.x = (int) (this.left + rawX);
                        a.this.PZ.y = (int) (this.top + rawY);
                        if (a.this.PU != null) {
                            try {
                                a.this.PU.updateViewLayout(a.this.yF, a.this.PZ);
                            } catch (Exception e) {
                                com.kwad.components.core.d.a.b(e);
                                c.printStackTraceOnly(e);
                            }
                        }
                    }
                    return true;
                } else if (motionEvent.getActionMasked() == 1) {
                    float rawX2 = motionEvent.getRawX() - this.Qb;
                    float rawY2 = motionEvent.getRawY() - this.Qc;
                    float elapsedRealtime = (float) (SystemClock.elapsedRealtime() - this.Qd);
                    if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f && a.this.Qa != null && a.this.PV != null && com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dP(a.this.PV.getAdTemplate()))) {
                        a.this.Qa.pM();
                    }
                }
                return true;
            }
        });
    }

    public final Animator aG(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(n.h(this.yF, z), n.h(this.eM, z));
        return animatorSet;
    }

    private void b(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate = this.PV.getAdTemplate();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        String url = com.kwad.sdk.core.response.b.a.br(dP).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, adTemplate);
            this.eM.setVisibility(0);
        } else {
            this.eM.setVisibility(8);
        }
        String K = com.kwad.sdk.core.response.b.a.K(dP);
        if (TextUtils.isEmpty(K)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a eb = AdVideoPlayerViewCache.getInstance().eb(K);
        this.eN = eb;
        if (eb == null) {
            this.eN = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            com.kwad.sdk.core.response.b.a.ab(dP);
            this.eN.a(new b.a(adTemplate).a(adTemplate.mVideoPlayerStatus).cD(com.kwad.sdk.core.response.b.e.dR(adTemplate)).cE(h.b(com.kwad.sdk.core.response.b.e.dQ(adTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(adTemplate, System.currentTimeMillis())).Ah(), null);
            this.eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            e eVar = new e(this.mContext, adTemplate, this.eN, ksAdVideoPlayConfig);
            this.PY = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.eN.setController(this.PY);
            this.PY.setAutoRelease(false);
        } else {
            e eVar2 = (e) eb.getController();
            this.PY = eVar2;
            eVar2.setAutoRelease(false);
            this.PY.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.eN.getParent() != null) {
            ((ViewGroup) this.eN.getParent()).removeView(this.eN);
        }
        if (this.PX.getTag() != null) {
            FrameLayout frameLayout = this.PX;
            frameLayout.removeView((View) frameLayout.getTag());
            this.PX.setTag(null);
        }
        this.PX.addView(this.eN);
        this.PX.setTag(this.eN);
        this.PY.setAlpha(0.01f);
        this.PY.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.3
            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void e(long j) {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                a.this.pL();
                a.this.aG(false).start();
            }
        });
    }

    public final void a(InterfaceC0657a interfaceC0657a) {
        this.Qa = interfaceC0657a;
    }

    public final boolean isVisible() {
        if (this.yF.getAlpha() > 0.0f) {
            return true;
        }
        return false;
    }

    public final void pL() {
        this.PY.ad();
    }

    public final void pP() {
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null && !aVar.isPlaying()) {
            this.PY.ry();
        }
    }

    public final boolean pO() {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.PV != null && this.PU != null) {
            b(new KsAdVideoPlayConfig.Builder().videoSoundEnable(this.PV.getAdTemplate().mIsAudioEnable).build());
            AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.PV.getAdTemplate());
            int R = com.kwad.sdk.core.response.b.a.R(dP);
            int Q = com.kwad.sdk.core.response.b.a.Q(dP);
            Rect rect = new Rect();
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (R > Q) {
                int i5 = displayMetrics.widthPixels;
                rect.right = i5;
                rect.left = i5 - com.kwad.sdk.d.a.a.a(this.mContext, 86.0f);
                int a = displayMetrics.heightPixels - com.kwad.sdk.d.a.a.a(this.mContext, 252.0f);
                rect.bottom = a;
                rect.top = a - com.kwad.sdk.d.a.a.a(this.mContext, 154.0f);
            } else {
                int i6 = displayMetrics.widthPixels;
                rect.right = i6;
                rect.left = i6 - com.kwad.sdk.d.a.a.a(this.mContext, 154.0f);
                int a2 = displayMetrics.heightPixels - com.kwad.sdk.d.a.a.a(this.mContext, 252.0f);
                rect.bottom = a2;
                rect.top = a2 - com.kwad.sdk.d.a.a.a(this.mContext, 86.0f);
            }
            rect.left -= com.kwad.sdk.d.a.a.a(this.mContext, 12.0f);
            int a3 = rect.right - com.kwad.sdk.d.a.a.a(this.mContext, 12.0f);
            rect.right = a3;
            WindowManager.LayoutParams layoutParams = this.PZ;
            layoutParams.type = 1003;
            layoutParams.flags = 8;
            layoutParams.gravity = 51;
            layoutParams.format = 1;
            layoutParams.width = displayMetrics.widthPixels;
            layoutParams.height = displayMetrics.heightPixels;
            int i7 = rect.left;
            layoutParams.x = i7;
            layoutParams.y = rect.top;
            layoutParams.width = (a3 - i7) + com.kwad.sdk.d.a.a.a(this.mContext, 12.0f);
            this.PZ.height = (rect.bottom - rect.top) + com.kwad.sdk.d.a.a.a(this.mContext, 12.0f);
            float f = (rect.left * displayMetrics.widthPixels) / ((i + i2) - rect.right);
            this.yF.setPivotX(f);
            this.yF.setPivotY((rect.top * displayMetrics.heightPixels) / ((i3 + i4) - rect.bottom));
            this.yF.setAlpha(0.0f);
            if (this.PU != null) {
                try {
                    if (this.yF.getWindowToken() == null) {
                        this.PU.addView(this.yF, this.PZ);
                    }
                } catch (Exception e) {
                    com.kwad.components.core.d.a.b(e);
                    c.printStackTraceOnly(e);
                }
            }
            this.IK.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.this.pL();
                    a.this.aG(false).start();
                }
            });
            return true;
        }
        return false;
    }
}
