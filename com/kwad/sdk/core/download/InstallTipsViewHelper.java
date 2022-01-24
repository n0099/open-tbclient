package com.kwad.sdk.core.download;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class InstallTipsViewHelper implements View.OnClickListener {
    public AdInfo a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f55772b;

    /* renamed from: c  reason: collision with root package name */
    public InstallTipsData f55773c;

    /* renamed from: d  reason: collision with root package name */
    public View f55774d;

    /* renamed from: e  reason: collision with root package name */
    public View f55775e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f55776f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55777g;

    /* renamed from: h  reason: collision with root package name */
    public Button f55778h;

    /* renamed from: i  reason: collision with root package name */
    public int f55779i = -1;

    /* renamed from: j  reason: collision with root package name */
    public long f55780j = 10000;
    public Context k;

    /* loaded from: classes3.dex */
    public static class InstallTipsData implements Serializable {
        public static final int ACTION_INSTALL = 1;
        public static final int ACTION_LAUNCH_APP = 2;
        public static int MAX_APP_NAME_LENGTH = 8;
        public static final long serialVersionUID = 5637398311569371631L;
        public int clickAction;
        public String displayContent;
        public String downloadId;
        public String iconUrl;

        public InstallTipsData(Context context, int i2, AdTemplate adTemplate, int i3) {
            this.clickAction = 1;
            this.clickAction = i2;
            this.iconUrl = com.kwad.sdk.core.response.a.d.o(adTemplate);
            this.downloadId = com.kwad.sdk.core.response.a.d.j(adTemplate).downloadId;
            String t = com.kwad.sdk.core.response.a.a.t(com.kwad.sdk.core.response.a.d.j(adTemplate));
            if (t.length() >= MAX_APP_NAME_LENGTH) {
                t = t.substring(0, MAX_APP_NAME_LENGTH - 1) + "...";
            }
            this.displayContent = context.getString(i3, t);
        }

        public static InstallTipsData newInstallInstance(Context context, AdTemplate adTemplate) {
            return new InstallTipsData(context, 1, adTemplate, R.string.ksad_install_tips);
        }

        public static InstallTipsData newLaunchInstance(Context context, AdTemplate adTemplate) {
            return new InstallTipsData(context, 2, adTemplate, R.string.ksad_launch_tips);
        }

        public int getClickAction() {
            return this.clickAction;
        }

        public String getClickButtonText() {
            return this.clickAction == 2 ? "打开" : "安装";
        }

        public String getDisplayContent() {
            return this.displayContent;
        }

        public String getDownloadId() {
            return this.downloadId;
        }

        public String getIconUrl() {
            return this.iconUrl;
        }
    }

    public InstallTipsViewHelper(boolean z, AdInfo adInfo, AdTemplate adTemplate) {
        Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(KsAdSDKImpl.get().getContext());
        this.k = wrapContextIfNeed;
        if (wrapContextIfNeed == null) {
            return;
        }
        this.a = adInfo;
        this.f55772b = adTemplate;
        this.f55773c = z ? InstallTipsData.newInstallInstance(wrapContextIfNeed, adTemplate) : InstallTipsData.newLaunchInstance(wrapContextIfNeed, adTemplate);
        View inflate = LayoutInflater.from(this.k).inflate(R.layout.ksad_install_tips, (ViewGroup) null, false);
        this.f55774d = inflate;
        a(this.k, inflate);
        InstallTipsData installTipsData = this.f55773c;
        if (installTipsData != null) {
            a(this.k, installTipsData);
        }
    }

    @Nullable
    private Animator a(View view) {
        int i2 = this.f55779i;
        if (i2 < 0) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, i2, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        ofFloat.setDuration(260L);
        return ofFloat;
    }

    private Animator a(View view, int i2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, 0.0f, i2);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        ofFloat.setDuration(300L);
        return ofFloat;
    }

    private void a(Context context, View view) {
        String clickButtonText;
        ViewCompat.setElevation(view, context.getResources().getDimension(R.dimen.ksad_install_tips_card_elevation));
        this.f55775e = view.findViewById(R.id.ksad_install_tips_close);
        this.f55776f = (ImageView) view.findViewById(R.id.ksad_install_tips_icon);
        this.f55777g = (TextView) view.findViewById(R.id.ksad_install_tips_content);
        this.f55778h = (Button) view.findViewById(R.id.ksad_install_tips_install);
        InstallTipsData installTipsData = this.f55773c;
        if (installTipsData != null && (clickButtonText = installTipsData.getClickButtonText()) != null) {
            this.f55778h.setText(clickButtonText);
        }
        this.f55775e.setOnClickListener(this);
        this.f55778h.setOnClickListener(this);
    }

    private void a(Context context, InstallTipsData installTipsData) {
        if (installTipsData.getIconUrl() != null) {
            KSImageLoader.loadAppIcon(this.f55776f, com.kwad.sdk.core.response.a.a.au(this.a), this.f55772b, 8);
        }
        this.f55777g.setText(installTipsData.getDisplayContent());
    }

    private void d() {
        String str = this.a.downloadFilePath;
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.report.a.h(this.f55772b);
            KsAdSDKImpl.get().getProxyForAdInstall().installApp(context, str);
            return;
        }
        com.kwad.sdk.core.d.a.e("InstallTipsViewHelper", "openApp fail appContext:" + context + "--filePath:" + str);
    }

    public View a() {
        return this.f55774d;
    }

    public void a(FrameLayout frameLayout) {
        View a = a();
        if (a == null || this.k == null || a.getParent() != null) {
            return;
        }
        int dimensionPixelSize = this.k.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_height);
        int dimensionPixelSize2 = this.k.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_margin);
        int i2 = dimensionPixelSize + dimensionPixelSize2;
        int i3 = -i2;
        this.f55779i = i2 + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams = a.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = dimensionPixelSize2;
        layoutParams2.rightMargin = dimensionPixelSize2;
        layoutParams2.topMargin = i3;
        frameLayout.addView(a, layoutParams2);
        a(a, this.f55779i).start();
        a.postDelayed(new Runnable() { // from class: com.kwad.sdk.core.download.InstallTipsViewHelper.1
            @Override // java.lang.Runnable
            public void run() {
                InstallTipsViewHelper.this.b();
            }
        }, this.f55780j);
    }

    public void b() {
        if (a() == null || a().getParent() == null) {
            return;
        }
        final View a = a();
        final ViewGroup viewGroup = (ViewGroup) a.getParent();
        final Animator a2 = a(a);
        if (a2 == null) {
            viewGroup.removeView(a);
            return;
        }
        a2.start();
        a2.addListener(new Animator.AnimatorListener() { // from class: com.kwad.sdk.core.download.InstallTipsViewHelper.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewGroup.removeView(a);
                a2.removeListener(this);
                e.a().a(InstallTipsViewHelper.this);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    public void c() {
        this.f55774d = null;
        this.f55775e = null;
        this.f55776f = null;
        this.f55778h = null;
        this.f55779i = -1;
        this.f55772b = null;
        this.f55773c = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdTemplate adTemplate;
        int i2;
        InstallTipsData installTipsData = this.f55773c;
        int clickAction = installTipsData != null ? installTipsData.getClickAction() : 1;
        int id = view.getId();
        if (id == R.id.ksad_install_tips_install) {
            b();
            if (clickAction == 1) {
                d();
                com.kwad.sdk.core.report.a.e(this.f55772b, 45);
            } else if (clickAction != 2) {
                return;
            }
            if (ag.c(this.k, com.kwad.sdk.core.response.a.a.v(this.a))) {
                com.kwad.sdk.core.report.a.e(this.f55772b);
            }
            adTemplate = this.f55772b;
            i2 = 47;
        } else if (id != R.id.ksad_install_tips_close) {
            return;
        } else {
            b();
            if (clickAction == 1) {
                com.kwad.sdk.core.report.a.e(this.f55772b, 46);
            } else if (clickAction != 2) {
                return;
            }
            adTemplate = this.f55772b;
            i2 = 48;
        }
        com.kwad.sdk.core.report.a.d(adTemplate, i2);
    }
}
