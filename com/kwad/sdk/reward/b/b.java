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
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.KsLogoView;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    public static String f34342b = "RewardMiddleEndCardPresenter";

    /* renamed from: c  reason: collision with root package name */
    public View f34343c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f34344d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f34345e;

    /* renamed from: f  reason: collision with root package name */
    public DetailVideoView f34346f;

    /* renamed from: g  reason: collision with root package name */
    public View f34347g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f34348h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f34349i;
    public com.kwad.sdk.c.b j;
    public Animator k;
    public Animator l;
    public com.kwad.sdk.contentalliance.detail.video.d m = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.b.1

        /* renamed from: b  reason: collision with root package name */
        public boolean f34351b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f34352c = -1;

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (this.f34352c <= 0) {
                this.f34352c = com.kwad.sdk.core.config.c.s();
            }
            int i2 = this.f34352c;
            if (i2 > 0) {
                int i3 = i2 * 1000;
                if (this.f34351b || j2 <= i3) {
                    return;
                }
                b.this.m();
                this.f34351b = true;
            }
        }
    };
    public a.b n = new a.b() { // from class: com.kwad.sdk.reward.b.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0386a c0386a) {
            ((com.kwad.sdk.reward.d) b.this).f34594a.f34317b.a();
        }
    };

    private Animator a(int i2, int i3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f34343c, "translationY", 0.0f, -i2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f34344d, "alpha", 0.0f, 255.0f);
        this.f34346f.getWidth();
        final ViewGroup.LayoutParams layoutParams = this.f34346f.getLayoutParams();
        final ViewGroup.LayoutParams layoutParams2 = this.f34345e.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f34346f.getHeight(), i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                int i4 = (int) (intValue / 1.7777778f);
                ViewGroup.LayoutParams layoutParams3 = layoutParams;
                if (layoutParams3 != null) {
                    layoutParams3.height = intValue;
                    layoutParams3.width = i4;
                    b.this.f34346f.setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams4 = layoutParams2;
                if (layoutParams4 != null) {
                    layoutParams4.height = intValue;
                    b.this.f34345e.setLayoutParams(layoutParams2);
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
        this.f34345e.setVisibility(0);
        ImageLoader.getInstance().displayImage(str, this.f34345e, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.b.b.2
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
        FrameLayout frameLayout = this.f34349i;
        if (frameLayout != null) {
            frameLayout.setVisibility(z ? 8 : 0);
        }
        FrameLayout frameLayout2 = this.f34348h;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(adInfo);
        return C.height > C.width;
    }

    private int b(int i2) {
        return (int) ((an.c(j()) - i2) + l().getResources().getDimensionPixelOffset(R.dimen.ksad_reward_middle_end_card_logo_view_height) + l().getResources().getDimensionPixelOffset(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        boolean d2 = this.j.d();
        a(d2);
        if (!d2) {
            View p = p();
            this.f34349i.removeAllViews();
            this.f34349i.addView(p);
        }
        int o = o();
        int b2 = b(o);
        Animator a2 = a(b2, o);
        this.k = a2;
        a2.start();
        Animator n = n();
        this.l = n;
        n.start();
        ViewGroup.LayoutParams layoutParams = this.f34343c.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = b2;
            layoutParams2.bottomMargin = -b2;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, b2);
            layoutParams3.height = b2;
            layoutParams3.bottomMargin = -b2;
            this.f34343c.setLayoutParams(layoutParams3);
        }
        ((com.kwad.sdk.reward.d) this).f34594a.t = true;
    }

    private Animator n() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f34347g, "alpha", 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private int o() {
        return (int) ((an.b(j()) * 9.0f) / 16.0f);
    }

    private View p() {
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(((com.kwad.sdk.reward.d) this).f34594a.f34321f);
        Context context = this.f34343c.getContext();
        int i2 = ((com.kwad.sdk.reward.d) this).f34594a.f34320e;
        boolean a2 = a(g2);
        com.kwad.sdk.reward.widget.tailframe.a tailFramePortraitVertical = i2 == 0 ? a2 ? new TailFramePortraitVertical(context) : new TailFramePortraitHorizontal(context) : a2 ? new TailFrameLandscapeVertical(context) : new TailFrameLandscapeHorizontal(context);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f34594a;
        tailFramePortraitVertical.a(aVar.f34321f, aVar.f34319d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.b.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.q();
            }
        });
        return tailFramePortraitVertical.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f34594a;
        com.kwad.sdk.core.report.b.a(aVar.f34321f, 2, aVar.f34323h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f34594a.f34319d);
        ((com.kwad.sdk.reward.d) this).f34594a.f34317b.a();
    }

    public String a(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.g(adTemplate));
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        com.kwad.sdk.c.b bVar;
        String e2;
        super.a();
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.a(this.m);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f34594a;
        com.kwad.sdk.c.b bVar2 = aVar.n;
        this.j = bVar2;
        if (bVar2 != null) {
            AdTemplate adTemplate = aVar.f34321f;
            boolean k = com.kwad.sdk.core.response.b.c.k(adTemplate);
            this.j.a(k);
            if (k) {
                bVar = this.j;
                e2 = a(adTemplate);
            } else {
                bVar = this.j;
                e2 = e();
            }
            bVar.a(e2);
            this.j.a(this.n);
            com.kwad.sdk.c.b bVar3 = this.j;
            FrameLayout frameLayout = this.f34348h;
            com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f34594a;
            bVar3.a(frameLayout, aVar2.f34323h, adTemplate, aVar2.j, aVar2.f34320e);
            this.j.a(((com.kwad.sdk.reward.d) this).f34594a.f34322g);
            this.j.c();
            if (adTemplate.adInfoList.size() > 0) {
                a(com.kwad.sdk.core.response.b.a.f(adTemplate.adInfoList.get(0)));
            }
        }
        this.f34344d.a(((com.kwad.sdk.reward.d) this).f34594a.f34321f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34343c = a(R.id.ksad_middle_end_card);
        this.f34346f = (DetailVideoView) a(R.id.ksad_video_player);
        this.f34344d = (KsLogoView) a(R.id.ksad_splash_logo_container);
        this.f34345e = (ImageView) a(R.id.ksad_blur_video_cover);
        this.f34347g = a(R.id.ksad_play_web_card_webView);
        this.f34348h = (FrameLayout) a(R.id.ksad_middle_end_card_webview_container);
        this.f34349i = (FrameLayout) a(R.id.ksad_middle_end_card_native);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.b(this.m);
        com.kwad.sdk.c.b bVar = this.j;
        if (bVar != null) {
            bVar.g();
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

    public String e() {
        if (l() != null) {
            File f2 = com.kwad.sdk.core.config.c.f(l());
            if (f2.exists()) {
                return Uri.fromFile(f2).toString();
            }
            if (com.kwad.sdk.core.config.c.o() != null) {
                return com.kwad.sdk.core.config.c.o().h5Url;
            }
            return null;
        }
        return null;
    }
}
