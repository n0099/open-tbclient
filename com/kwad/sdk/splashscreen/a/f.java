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
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.g;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends Presenter implements com.kwad.sdk.core.i.c {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f34023a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f34028f;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f34024b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34025c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34026d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34027e = false;

    /* renamed from: g  reason: collision with root package name */
    public g.a f34029g = new g.a() { // from class: com.kwad.sdk.splashscreen.a.f.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            f.this.f34024b = false;
            if (f.this.f34028f != null) {
                f.this.f34028f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.f.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f fVar = f.this;
                        com.kwad.sdk.splashscreen.b.a aVar = fVar.f34023a.f34060e;
                        if (aVar != null) {
                            aVar.a(fVar.f34024b, false);
                        }
                        com.kwad.sdk.splashscreen.c cVar = f.this.f34023a;
                        if (cVar != null) {
                            AdInfo g2 = com.kwad.sdk.core.response.b.c.g(cVar.f34058c);
                            boolean z = f.this.f34024b;
                            AdInfo.AdSplashInfo adSplashInfo = g2.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                f.this.f34028f.setImageDrawable(f.this.l().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(f.this.f34028f, str, f.this.f34023a.f34058c);
                            }
                            f.this.f34028f.setSelected(false);
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
    public com.kwad.sdk.contentalliance.detail.video.d f34030h = new com.kwad.sdk.contentalliance.detail.video.d() { // from class: com.kwad.sdk.splashscreen.a.f.2
        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            f fVar = f.this;
            if (fVar.f34023a.f34056a == null || fVar.f34027e) {
                return;
            }
            f.this.f34023a.f34056a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void b() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            f fVar = f.this;
            com.kwad.sdk.splashscreen.b.a aVar = fVar.f34023a.f34060e;
            if (aVar != null) {
                aVar.a(fVar.f34024b, false);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            if (f.this.f34025c) {
                return;
            }
            f.this.m();
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = f.this.f34023a.f34056a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
                com.kwad.sdk.splashscreen.b.a aVar = f.this.f34023a.f34060e;
                if (aVar != null) {
                    aVar.a(true);
                    f fVar = f.this;
                    fVar.f34023a.f34060e.a(fVar.f34024b, true);
                }
            }
            f.this.f34025c = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = f.this.f34023a.f34056a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void g() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void h() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.kwad.sdk.core.report.b.h(this.f34023a.f34058c);
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
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) k();
        this.f34023a = cVar;
        ((DetailVideoView) cVar.f34059d.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        com.kwad.sdk.splashscreen.b.a aVar2 = this.f34023a.f34060e;
        if (aVar2 != null) {
            aVar2.a(this.f34030h);
        }
        this.f34023a.f34063h.a(this);
        final AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f34023a.f34058c);
        int i2 = g2.adSplashInfo.mute;
        boolean z = true;
        if (i2 != 2) {
            if (i2 != 3) {
                this.f34024b = false;
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f34024b = false;
                }
                aVar = this.f34023a.f34060e;
                if (aVar != null) {
                    aVar.a(this.f34024b, false);
                    this.f34023a.f34060e.a(this.f34029g);
                }
                ImageView imageView = (ImageView) this.f34023a.f34059d.findViewById(R.id.ksad_splash_sound);
                this.f34028f = imageView;
                imageView.setVisibility(0);
                str = !this.f34024b ? g2.adSplashInfo.speakerIconUrl : g2.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str)) {
                    KSImageLoader.loadImage(this.f34028f, str, this.f34023a.f34058c);
                } else {
                    this.f34028f.setImageDrawable(l().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                this.f34028f.setSelected(this.f34024b);
                this.f34028f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f fVar = f.this;
                        fVar.f34024b = !fVar.f34024b;
                        String str2 = f.this.f34024b ? g2.adSplashInfo.speakerIconUrl : g2.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            f.this.f34028f.setImageDrawable(f.this.l().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(f.this.f34028f, str2, f.this.f34023a.f34058c);
                        }
                        f.this.f34028f.setSelected(f.this.f34024b);
                        f fVar2 = f.this;
                        fVar2.f34023a.f34060e.a(fVar2.f34024b, true);
                    }
                });
            } else if (ai.l(this.f34023a.f34059d.getContext()) <= 0) {
                z = false;
            }
        }
        this.f34024b = z;
        if (com.kwad.sdk.utils.b.a().b()) {
        }
        aVar = this.f34023a.f34060e;
        if (aVar != null) {
        }
        ImageView imageView2 = (ImageView) this.f34023a.f34059d.findViewById(R.id.ksad_splash_sound);
        this.f34028f = imageView2;
        imageView2.setVisibility(0);
        if (!this.f34024b) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        this.f34028f.setSelected(this.f34024b);
        this.f34028f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f fVar = f.this;
                fVar.f34024b = !fVar.f34024b;
                String str2 = f.this.f34024b ? g2.adSplashInfo.speakerIconUrl : g2.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    f.this.f34028f.setImageDrawable(f.this.l().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(f.this.f34028f, str2, f.this.f34023a.f34058c);
                }
                f.this.f34028f.setSelected(f.this.f34024b);
                f fVar2 = f.this;
                fVar2.f34023a.f34060e.a(fVar2.f34024b, true);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void a_() {
        if (this.f34026d) {
            return;
        }
        this.f34026d = true;
        com.kwad.sdk.core.report.b.a(this.f34023a.f34058c, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.splashscreen.b.a aVar = this.f34023a.f34060e;
        if (aVar != null) {
            aVar.b(this.f34030h);
            this.f34023a.f34060e.b(this.f34029g);
        }
        this.f34023a.f34063h.b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f34027e = true;
    }

    @Override // com.kwad.sdk.core.i.c
    public void e() {
        com.kwad.sdk.splashscreen.b.a aVar = this.f34023a.f34060e;
        if (aVar != null) {
            aVar.d();
        }
    }
}
