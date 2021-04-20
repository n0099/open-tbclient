package com.kwad.sdk.splashscreen.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.g;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends Presenter implements com.kwad.sdk.core.i.c {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f36916a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f36921f;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f36917b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36918c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36919d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36920e = false;

    /* renamed from: g  reason: collision with root package name */
    public g.a f36922g = new g.a() { // from class: com.kwad.sdk.splashscreen.a.e.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            e.this.f36917b = false;
            if (e.this.f36921f != null) {
                e.this.f36921f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e eVar = e.this;
                        com.kwad.sdk.splashscreen.b.a aVar = eVar.f36916a.f36951e;
                        if (aVar != null) {
                            aVar.a(eVar.f36917b, false);
                        }
                        com.kwad.sdk.splashscreen.c cVar = e.this.f36916a;
                        if (cVar != null) {
                            AdInfo j = com.kwad.sdk.core.response.b.c.j(cVar.f36949c);
                            boolean z = e.this.f36917b;
                            AdInfo.AdSplashInfo adSplashInfo = j.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                e.this.f36921f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(e.this.f36921f, str, e.this.f36916a.f36949c);
                            }
                            e.this.f36921f.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f36923h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.splashscreen.a.e.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f36916a.f36947a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            e eVar = e.this;
            if (eVar.f36916a.f36947a == null || eVar.f36920e) {
                return;
            }
            e.this.f36916a.f36947a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            e eVar = e.this;
            com.kwad.sdk.splashscreen.b.a aVar = eVar.f36916a.f36951e;
            if (aVar != null) {
                aVar.a(eVar.f36917b, false);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            if (e.this.f36918c) {
                return;
            }
            e.this.e();
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f36916a.f36947a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
                com.kwad.sdk.splashscreen.b.a aVar = e.this.f36916a.f36951e;
                if (aVar != null) {
                    aVar.a(true);
                    e eVar = e.this;
                    eVar.f36916a.f36951e.a(eVar.f36917b, true);
                }
            }
            e.this.f36918c = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void e() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void f() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void g() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void h() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.h(this.f36916a.f36949c);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    @Override // com.kwad.sdk.mvp.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        com.kwad.sdk.splashscreen.b.a aVar;
        String str;
        super.a();
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
        this.f36916a = cVar;
        ((DetailVideoView) cVar.f36950d.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        com.kwad.sdk.splashscreen.b.a aVar2 = this.f36916a.f36951e;
        if (aVar2 != null) {
            aVar2.a(this.f36923h);
        }
        this.f36916a.f36954h.a(this);
        final AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f36916a.f36949c);
        int i = j.adSplashInfo.mute;
        boolean z = true;
        if (i != 2) {
            if (i != 3) {
                this.f36917b = false;
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f36917b = false;
                }
                aVar = this.f36916a.f36951e;
                if (aVar != null) {
                    aVar.a(this.f36917b, false);
                    this.f36916a.f36951e.a(this.f36922g);
                }
                ImageView imageView = (ImageView) this.f36916a.f36950d.findViewById(R.id.ksad_splash_sound);
                this.f36921f = imageView;
                imageView.setVisibility(0);
                str = !this.f36917b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str)) {
                    KSImageLoader.loadImage(this.f36921f, str, this.f36916a.f36949c);
                } else {
                    this.f36921f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                this.f36921f.setSelected(this.f36917b);
                this.f36921f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e eVar = e.this;
                        eVar.f36917b = !eVar.f36917b;
                        String str2 = e.this.f36917b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            e.this.f36921f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(e.this.f36921f, str2, e.this.f36916a.f36949c);
                        }
                        e.this.f36921f.setSelected(e.this.f36917b);
                        e eVar2 = e.this;
                        eVar2.f36916a.f36951e.a(eVar2.f36917b, true);
                    }
                });
            } else if (ah.j(this.f36916a.f36950d.getContext()) <= 0) {
                z = false;
            }
        }
        this.f36917b = z;
        if (com.kwad.sdk.utils.b.a().b()) {
        }
        aVar = this.f36916a.f36951e;
        if (aVar != null) {
        }
        ImageView imageView2 = (ImageView) this.f36916a.f36950d.findViewById(R.id.ksad_splash_sound);
        this.f36921f = imageView2;
        imageView2.setVisibility(0);
        if (!this.f36917b) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        this.f36921f.setSelected(this.f36917b);
        this.f36921f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = e.this;
                eVar.f36917b = !eVar.f36917b;
                String str2 = e.this.f36917b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    e.this.f36921f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(e.this.f36921f, str2, e.this.f36916a.f36949c);
                }
                e.this.f36921f.setSelected(e.this.f36917b);
                e eVar2 = e.this;
                eVar2.f36916a.f36951e.a(eVar2.f36917b, true);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        com.kwad.sdk.splashscreen.b.a aVar = this.f36916a.f36951e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.splashscreen.b.a aVar = this.f36916a.f36951e;
        if (aVar != null) {
            aVar.b(this.f36923h);
            this.f36916a.f36951e.b(this.f36922g);
        }
        this.f36916a.f36954h.b(this);
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        if (this.f36919d) {
            return;
        }
        this.f36919d = true;
        com.kwad.sdk.core.report.b.a(this.f36916a.f36949c, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f36920e = true;
    }
}
