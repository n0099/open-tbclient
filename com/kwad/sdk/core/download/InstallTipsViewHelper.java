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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class InstallTipsViewHelper implements View.OnClickListener {
    public AdInfo a;
    public AdTemplate b;
    public InstallTipsData c;
    public View d;
    public View e;
    public ImageView f;
    public TextView g;
    public Button h;
    public int i = -1;
    public long j = 10000;
    public Context k;

    /* loaded from: classes5.dex */
    public static class InstallTipsData implements Serializable {
        public static final int ACTION_INSTALL = 1;
        public static final int ACTION_LAUNCH_APP = 2;
        public static int MAX_APP_NAME_LENGTH = 8;
        public static final long serialVersionUID = 5637398311569371631L;
        public int clickAction;
        public String displayContent;
        public String downloadId;
        public String iconUrl;

        public InstallTipsData(Context context, int i, AdTemplate adTemplate, int i2) {
            this.clickAction = 1;
            this.clickAction = i;
            this.iconUrl = com.kwad.sdk.core.response.a.d.o(adTemplate);
            this.downloadId = com.kwad.sdk.core.response.a.d.j(adTemplate).downloadId;
            String t = com.kwad.sdk.core.response.a.a.t(com.kwad.sdk.core.response.a.d.j(adTemplate));
            if (t.length() >= MAX_APP_NAME_LENGTH) {
                t = t.substring(0, MAX_APP_NAME_LENGTH - 1) + StringHelper.STRING_MORE;
            }
            this.displayContent = context.getString(i2, t);
        }

        public static InstallTipsData newInstallInstance(Context context, AdTemplate adTemplate) {
            return new InstallTipsData(context, 1, adTemplate, R.string.obfuscated_res_0x7f0f0997);
        }

        public static InstallTipsData newLaunchInstance(Context context, AdTemplate adTemplate) {
            return new InstallTipsData(context, 2, adTemplate, R.string.obfuscated_res_0x7f0f0998);
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
        this.b = adTemplate;
        this.c = z ? InstallTipsData.newInstallInstance(wrapContextIfNeed, adTemplate) : InstallTipsData.newLaunchInstance(wrapContextIfNeed, adTemplate);
        View inflate = LayoutInflater.from(this.k).inflate(R.layout.obfuscated_res_0x7f0d043f, (ViewGroup) null, false);
        this.d = inflate;
        a(this.k, inflate);
        InstallTipsData installTipsData = this.c;
        if (installTipsData != null) {
            a(this.k, installTipsData);
        }
    }

    @Nullable
    private Animator a(View view2) {
        int i = this.i;
        if (i < 0) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.TRANSLATE_Y, i, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        ofFloat.setDuration(260L);
        return ofFloat;
    }

    private Animator a(View view2, int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.TRANSLATE_Y, 0.0f, i);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        ofFloat.setDuration(300L);
        return ofFloat;
    }

    private void a(Context context, View view2) {
        String clickButtonText;
        ViewCompat.setElevation(view2, context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070362));
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f09108a);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09108c);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09108b);
        this.h = (Button) view2.findViewById(R.id.obfuscated_res_0x7f09108d);
        InstallTipsData installTipsData = this.c;
        if (installTipsData != null && (clickButtonText = installTipsData.getClickButtonText()) != null) {
            this.h.setText(clickButtonText);
        }
        this.e.setOnClickListener(this);
        this.h.setOnClickListener(this);
    }

    private void a(Context context, InstallTipsData installTipsData) {
        if (installTipsData.getIconUrl() != null) {
            KSImageLoader.loadAppIcon(this.f, com.kwad.sdk.core.response.a.a.au(this.a), this.b, 8);
        }
        this.g.setText(installTipsData.getDisplayContent());
    }

    private void d() {
        String str = this.a.downloadFilePath;
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.report.a.h(this.b);
            KsAdSDKImpl.get().getProxyForAdInstall().installApp(context, str);
            return;
        }
        com.kwad.sdk.core.d.a.e("InstallTipsViewHelper", "openApp fail appContext:" + context + "--filePath:" + str);
    }

    public View a() {
        return this.d;
    }

    public void a(FrameLayout frameLayout) {
        View a = a();
        if (a == null || this.k == null || a.getParent() != null) {
            return;
        }
        int dimensionPixelSize = this.k.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070363);
        int dimensionPixelSize2 = this.k.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070364);
        int i = dimensionPixelSize + dimensionPixelSize2;
        int i2 = -i;
        this.i = i + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams = a.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = dimensionPixelSize2;
        layoutParams2.rightMargin = dimensionPixelSize2;
        layoutParams2.topMargin = i2;
        frameLayout.addView(a, layoutParams2);
        a(a, this.i).start();
        a.postDelayed(new Runnable() { // from class: com.kwad.sdk.core.download.InstallTipsViewHelper.1
            @Override // java.lang.Runnable
            public void run() {
                InstallTipsViewHelper.this.b();
            }
        }, this.j);
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
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = -1;
        this.b = null;
        this.c = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        AdTemplate adTemplate;
        int i;
        InstallTipsData installTipsData = this.c;
        int clickAction = installTipsData != null ? installTipsData.getClickAction() : 1;
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f09108d) {
            b();
            if (clickAction == 1) {
                d();
                com.kwad.sdk.core.report.a.e(this.b, 45);
            } else if (clickAction != 2) {
                return;
            }
            if (ag.c(this.k, com.kwad.sdk.core.response.a.a.v(this.a))) {
                com.kwad.sdk.core.report.a.e(this.b);
            }
            adTemplate = this.b;
            i = 47;
        } else if (id != R.id.obfuscated_res_0x7f09108a) {
            return;
        } else {
            b();
            if (clickAction == 1) {
                com.kwad.sdk.core.report.a.e(this.b, 46);
            } else if (clickAction != 2) {
                return;
            }
            adTemplate = this.b;
            i = 48;
        }
        com.kwad.sdk.core.report.a.d(adTemplate, i);
    }
}
