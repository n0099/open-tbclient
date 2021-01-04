package com.kwad.sdk.reward.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    private static String f10829b = "RewardMiddleEndCardPresenter";
    private View c;
    private KsLogoView d;
    private ImageView e;
    private DetailVideoView f;
    private View g;
    private FrameLayout h;
    private FrameLayout i;
    private com.kwad.sdk.c.b j;
    private Animator k;
    private Animator l;
    private com.kwad.sdk.contentalliance.detail.video.e m = new f() { // from class: com.kwad.sdk.reward.b.b.1

        /* renamed from: b  reason: collision with root package name */
        private boolean f10831b = false;
        private int c = -1;

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (this.c <= 0) {
                this.c = com.kwad.sdk.core.config.c.W();
            }
            if (this.c > 0) {
                int i = this.c * 1000;
                if (this.f10831b || j2 <= i) {
                    return;
                }
                b.this.f();
                this.f10831b = true;
            }
        }
    };
    private a.b n = new a.b() { // from class: com.kwad.sdk.reward.b.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            b.this.f10949a.f10824b.a();
        }
    };

    private int a(int i) {
        int dimensionPixelOffset = o().getResources().getDimensionPixelOffset(R.dimen.ksad_reward_middle_end_card_logo_view_height);
        return (int) (dimensionPixelOffset + (ao.d(m()) - i) + o().getResources().getDimensionPixelOffset(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    private Animator a(int i, int i2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "translationY", 0.0f, -i);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.d, "alpha", 0.0f, 255.0f);
        this.f.getWidth();
        final ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        final ViewGroup.LayoutParams layoutParams2 = this.e.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f.getHeight(), i2);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                int i3 = (int) (intValue / 1.7777778f);
                if (layoutParams != null) {
                    layoutParams.height = intValue;
                    layoutParams.width = i3;
                    b.this.f.setLayoutParams(layoutParams);
                }
                if (layoutParams2 != null) {
                    layoutParams2.height = intValue;
                    b.this.e.setLayoutParams(layoutParams2);
                }
            }
        });
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.setInterpolator(create);
        animatorSet.playTogether(ofFloat, ofFloat2, ofInt);
        return animatorSet;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e.setVisibility(0);
        ImageLoader.getInstance().displayImage(str, this.e, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.b.b.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }

    private void a(boolean z) {
        if (this.i != null) {
            this.i.setVisibility(z ? 8 : 0);
        }
        if (this.h != null) {
            this.h.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(adInfo);
        return E.height > E.width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        boolean d = this.j.d();
        a(d);
        if (!d) {
            View p = p();
            this.i.removeAllViews();
            this.i.addView(p);
        }
        int h = h();
        int a2 = a(h);
        this.k = a(a2, h);
        this.k.start();
        this.l = g();
        this.l.start();
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = a2;
            layoutParams2.bottomMargin = -a2;
            return;
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, a2);
        layoutParams3.height = a2;
        layoutParams3.bottomMargin = -a2;
        this.c.setLayoutParams(layoutParams3);
    }

    private Animator g() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.g, "alpha", 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private int h() {
        return (int) ((ao.c(m()) * 9.0f) / 16.0f);
    }

    private View p() {
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f10949a.f);
        Context context = this.c.getContext();
        com.kwad.sdk.reward.widget.tailframe.a tailFramePortraitVertical = this.f10949a.e == 0 ? a(j) ? new TailFramePortraitVertical(context) : new TailFramePortraitHorizontal(context) : a(j) ? new TailFrameLandscapeVertical(context) : new TailFrameLandscapeHorizontal(context);
        tailFramePortraitVertical.a(this.f10949a.f, this.f10949a.d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.b.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.q();
            }
        });
        return tailFramePortraitVertical.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.kwad.sdk.core.report.b.a(this.f10949a.f, 2, this.f10949a.h.getTouchCoords(), this.f10949a.d);
        this.f10949a.f10824b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f10949a.i.a(this.m);
        this.j = this.f10949a.m;
        if (this.j != null) {
            this.j.a(e());
            AdTemplate adTemplate = this.f10949a.f;
            this.j.a(this.n);
            this.j.a(this.h, this.f10949a.h, adTemplate, this.f10949a.j, this.f10949a.e);
            this.j.a(this.f10949a.g);
            this.j.g();
            if (adTemplate.adInfoList.size() > 0) {
                a(com.kwad.sdk.core.response.b.a.f(adTemplate.adInfoList.get(0)));
            }
        }
        this.d.a(this.f10949a.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f10949a.i.b(this.m);
        if (this.j != null) {
            this.j.i();
        }
        if (this.l != null) {
            this.l.cancel();
        }
        if (this.k != null) {
            this.k.cancel();
        }
        this.l = null;
        this.k = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c = b(R.id.ksad_middle_end_card);
        this.f = (DetailVideoView) b(R.id.ksad_video_player);
        this.d = (KsLogoView) b(R.id.ksad_splash_logo_container);
        this.e = (ImageView) b(R.id.ksad_blur_video_cover);
        this.g = b(R.id.ksad_play_web_card_webView);
        this.h = (FrameLayout) b(R.id.ksad_middle_end_card_webview_container);
        this.i = (FrameLayout) b(R.id.ksad_middle_end_card_native);
    }

    protected String e() {
        if (o() != null) {
            File f = com.kwad.sdk.core.config.c.f(o());
            if (f.exists()) {
                return Uri.fromFile(f).toString();
            }
            if (com.kwad.sdk.core.config.c.M() != null) {
                return com.kwad.sdk.core.config.c.M().h5Url;
            }
        }
        return null;
    }
}
