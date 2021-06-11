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
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    public static String f36971b = "RewardMiddleEndCardPresenter";

    /* renamed from: c  reason: collision with root package name */
    public View f36972c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f36973d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f36974e;

    /* renamed from: f  reason: collision with root package name */
    public DetailVideoView f36975f;

    /* renamed from: g  reason: collision with root package name */
    public View f36976g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f36977h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f36978i;
    public com.kwad.sdk.c.b j;
    public Animator k;
    public Animator l;
    public com.kwad.sdk.contentalliance.detail.video.e m = new f() { // from class: com.kwad.sdk.reward.b.b.1

        /* renamed from: b  reason: collision with root package name */
        public boolean f36980b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f36981c = -1;

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (this.f36981c <= 0) {
                this.f36981c = com.kwad.sdk.core.config.c.W();
            }
            int i2 = this.f36981c;
            if (i2 > 0) {
                int i3 = i2 * 1000;
                if (this.f36980b || j2 <= i3) {
                    return;
                }
                b.this.f();
                this.f36980b = true;
            }
        }
    };
    public a.b n = new a.b() { // from class: com.kwad.sdk.reward.b.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            ((com.kwad.sdk.reward.d) b.this).f37201a.f36951b.a();
        }
    };

    private int a(int i2) {
        return (int) ((ao.d(m()) - i2) + o().getResources().getDimensionPixelOffset(R.dimen.ksad_reward_middle_end_card_logo_view_height) + o().getResources().getDimensionPixelOffset(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    private Animator a(int i2, int i3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f36972c, "translationY", 0.0f, -i2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f36973d, "alpha", 0.0f, 255.0f);
        this.f36975f.getWidth();
        final ViewGroup.LayoutParams layoutParams = this.f36975f.getLayoutParams();
        final ViewGroup.LayoutParams layoutParams2 = this.f36974e.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f36975f.getHeight(), i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                int i4 = (int) (intValue / 1.7777778f);
                ViewGroup.LayoutParams layoutParams3 = layoutParams;
                if (layoutParams3 != null) {
                    layoutParams3.height = intValue;
                    layoutParams3.width = i4;
                    b.this.f36975f.setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams4 = layoutParams2;
                if (layoutParams4 != null) {
                    layoutParams4.height = intValue;
                    b.this.f36974e.setLayoutParams(layoutParams2);
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
        this.f36974e.setVisibility(0);
        ImageLoader.getInstance().displayImage(str, this.f36974e, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.b.b.2
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
        FrameLayout frameLayout = this.f36978i;
        if (frameLayout != null) {
            frameLayout.setVisibility(z ? 8 : 0);
        }
        FrameLayout frameLayout2 = this.f36977h;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(adInfo);
        return E.height > E.width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        boolean d2 = this.j.d();
        a(d2);
        if (!d2) {
            View p = p();
            this.f36978i.removeAllViews();
            this.f36978i.addView(p);
        }
        int h2 = h();
        int a2 = a(h2);
        Animator a3 = a(a2, h2);
        this.k = a3;
        a3.start();
        Animator g2 = g();
        this.l = g2;
        g2.start();
        ViewGroup.LayoutParams layoutParams = this.f36972c.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = a2;
            layoutParams2.bottomMargin = -a2;
            return;
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, a2);
        layoutParams3.height = a2;
        layoutParams3.bottomMargin = -a2;
        this.f36972c.setLayoutParams(layoutParams3);
    }

    private Animator g() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f36976g, "alpha", 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private int h() {
        return (int) ((ao.c(m()) * 9.0f) / 16.0f);
    }

    private View p() {
        AdInfo j = com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.reward.d) this).f37201a.f36955f);
        Context context = this.f36972c.getContext();
        int i2 = ((com.kwad.sdk.reward.d) this).f37201a.f36954e;
        boolean a2 = a(j);
        com.kwad.sdk.reward.widget.tailframe.a tailFramePortraitVertical = i2 == 0 ? a2 ? new TailFramePortraitVertical(context) : new TailFramePortraitHorizontal(context) : a2 ? new TailFrameLandscapeVertical(context) : new TailFrameLandscapeHorizontal(context);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f37201a;
        tailFramePortraitVertical.a(aVar.f36955f, aVar.f36953d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.b.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.q();
            }
        });
        return tailFramePortraitVertical.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f37201a;
        com.kwad.sdk.core.report.b.a(aVar.f36955f, 2, aVar.f36957h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f37201a.f36953d);
        ((com.kwad.sdk.reward.d) this).f37201a.f36951b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.d) this).f37201a.f36958i.a(this.m);
        com.kwad.sdk.c.b bVar = ((com.kwad.sdk.reward.d) this).f37201a.m;
        this.j = bVar;
        if (bVar != null) {
            bVar.a(e());
            AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f37201a.f36955f;
            this.j.a(this.n);
            com.kwad.sdk.c.b bVar2 = this.j;
            FrameLayout frameLayout = this.f36977h;
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f37201a;
            bVar2.a(frameLayout, aVar.f36957h, adTemplate, aVar.j, aVar.f36954e);
            this.j.a(((com.kwad.sdk.reward.d) this).f37201a.f36956g);
            this.j.g();
            if (adTemplate.adInfoList.size() > 0) {
                a(com.kwad.sdk.core.response.b.a.f(adTemplate.adInfoList.get(0)));
            }
        }
        this.f36973d.a(((com.kwad.sdk.reward.d) this).f37201a.f36955f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f37201a.f36958i.b(this.m);
        com.kwad.sdk.c.b bVar = this.j;
        if (bVar != null) {
            bVar.i();
        }
        Animator animator = this.l;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.k;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.l = null;
        this.k = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36972c = b(R.id.ksad_middle_end_card);
        this.f36975f = (DetailVideoView) b(R.id.ksad_video_player);
        this.f36973d = (KsLogoView) b(R.id.ksad_splash_logo_container);
        this.f36974e = (ImageView) b(R.id.ksad_blur_video_cover);
        this.f36976g = b(R.id.ksad_play_web_card_webView);
        this.f36977h = (FrameLayout) b(R.id.ksad_middle_end_card_webview_container);
        this.f36978i = (FrameLayout) b(R.id.ksad_middle_end_card_native);
    }

    public String e() {
        if (o() != null) {
            File f2 = com.kwad.sdk.core.config.c.f(o());
            if (f2.exists()) {
                return Uri.fromFile(f2).toString();
            }
            if (com.kwad.sdk.core.config.c.M() != null) {
                return com.kwad.sdk.core.config.c.M().h5Url;
            }
            return null;
        }
        return null;
    }
}
