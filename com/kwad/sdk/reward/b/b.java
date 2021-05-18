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
    public static String f33587b = "RewardMiddleEndCardPresenter";

    /* renamed from: c  reason: collision with root package name */
    public View f33588c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f33589d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f33590e;

    /* renamed from: f  reason: collision with root package name */
    public DetailVideoView f33591f;

    /* renamed from: g  reason: collision with root package name */
    public View f33592g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f33593h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f33594i;
    public com.kwad.sdk.c.b j;
    public Animator k;
    public Animator l;
    public com.kwad.sdk.contentalliance.detail.video.d m = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.b.1

        /* renamed from: b  reason: collision with root package name */
        public boolean f33596b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f33597c = -1;

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (this.f33597c <= 0) {
                this.f33597c = com.kwad.sdk.core.config.c.s();
            }
            int i2 = this.f33597c;
            if (i2 > 0) {
                int i3 = i2 * 1000;
                if (this.f33596b || j2 <= i3) {
                    return;
                }
                b.this.m();
                this.f33596b = true;
            }
        }
    };
    public a.b n = new a.b() { // from class: com.kwad.sdk.reward.b.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0373a c0373a) {
            ((com.kwad.sdk.reward.d) b.this).f33839a.f33562b.a();
        }
    };

    private Animator a(int i2, int i3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f33588c, "translationY", 0.0f, -i2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f33589d, "alpha", 0.0f, 255.0f);
        this.f33591f.getWidth();
        final ViewGroup.LayoutParams layoutParams = this.f33591f.getLayoutParams();
        final ViewGroup.LayoutParams layoutParams2 = this.f33590e.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f33591f.getHeight(), i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                int i4 = (int) (intValue / 1.7777778f);
                ViewGroup.LayoutParams layoutParams3 = layoutParams;
                if (layoutParams3 != null) {
                    layoutParams3.height = intValue;
                    layoutParams3.width = i4;
                    b.this.f33591f.setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams4 = layoutParams2;
                if (layoutParams4 != null) {
                    layoutParams4.height = intValue;
                    b.this.f33590e.setLayoutParams(layoutParams2);
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
        this.f33590e.setVisibility(0);
        ImageLoader.getInstance().displayImage(str, this.f33590e, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.b.b.2
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
        FrameLayout frameLayout = this.f33594i;
        if (frameLayout != null) {
            frameLayout.setVisibility(z ? 8 : 0);
        }
        FrameLayout frameLayout2 = this.f33593h;
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
            this.f33594i.removeAllViews();
            this.f33594i.addView(p);
        }
        int o = o();
        int b2 = b(o);
        Animator a2 = a(b2, o);
        this.k = a2;
        a2.start();
        Animator n = n();
        this.l = n;
        n.start();
        ViewGroup.LayoutParams layoutParams = this.f33588c.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = b2;
            layoutParams2.bottomMargin = -b2;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, b2);
            layoutParams3.height = b2;
            layoutParams3.bottomMargin = -b2;
            this.f33588c.setLayoutParams(layoutParams3);
        }
        ((com.kwad.sdk.reward.d) this).f33839a.t = true;
    }

    private Animator n() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f33592g, "alpha", 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private int o() {
        return (int) ((an.b(j()) * 9.0f) / 16.0f);
    }

    private View p() {
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(((com.kwad.sdk.reward.d) this).f33839a.f33566f);
        Context context = this.f33588c.getContext();
        int i2 = ((com.kwad.sdk.reward.d) this).f33839a.f33565e;
        boolean a2 = a(g2);
        com.kwad.sdk.reward.widget.tailframe.a tailFramePortraitVertical = i2 == 0 ? a2 ? new TailFramePortraitVertical(context) : new TailFramePortraitHorizontal(context) : a2 ? new TailFrameLandscapeVertical(context) : new TailFrameLandscapeHorizontal(context);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33839a;
        tailFramePortraitVertical.a(aVar.f33566f, aVar.f33564d, new com.kwad.sdk.reward.widget.tailframe.b() { // from class: com.kwad.sdk.reward.b.b.4
            @Override // com.kwad.sdk.reward.widget.tailframe.b
            public void a() {
                b.this.q();
            }
        });
        return tailFramePortraitVertical.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33839a;
        com.kwad.sdk.core.report.b.a(aVar.f33566f, 2, aVar.f33568h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f33839a.f33564d);
        ((com.kwad.sdk.reward.d) this).f33839a.f33562b.a();
    }

    public String a(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.g(adTemplate));
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        com.kwad.sdk.c.b bVar;
        String e2;
        super.a();
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.a(this.m);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33839a;
        com.kwad.sdk.c.b bVar2 = aVar.n;
        this.j = bVar2;
        if (bVar2 != null) {
            AdTemplate adTemplate = aVar.f33566f;
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
            FrameLayout frameLayout = this.f33593h;
            com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f33839a;
            bVar3.a(frameLayout, aVar2.f33568h, adTemplate, aVar2.j, aVar2.f33565e);
            this.j.a(((com.kwad.sdk.reward.d) this).f33839a.f33567g);
            this.j.c();
            if (adTemplate.adInfoList.size() > 0) {
                a(com.kwad.sdk.core.response.b.a.f(adTemplate.adInfoList.get(0)));
            }
        }
        this.f33589d.a(((com.kwad.sdk.reward.d) this).f33839a.f33566f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33588c = a(R.id.ksad_middle_end_card);
        this.f33591f = (DetailVideoView) a(R.id.ksad_video_player);
        this.f33589d = (KsLogoView) a(R.id.ksad_splash_logo_container);
        this.f33590e = (ImageView) a(R.id.ksad_blur_video_cover);
        this.f33592g = a(R.id.ksad_play_web_card_webView);
        this.f33593h = (FrameLayout) a(R.id.ksad_middle_end_card_webview_container);
        this.f33594i = (FrameLayout) a(R.id.ksad_middle_end_card_native);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.b(this.m);
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
