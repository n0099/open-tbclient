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
    public com.kwad.sdk.splashscreen.c f36626a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f36631f;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f36627b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36628c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36629d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36630e = false;

    /* renamed from: g  reason: collision with root package name */
    public g.a f36632g = new g.a() { // from class: com.kwad.sdk.splashscreen.a.e.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            e.this.f36627b = false;
            if (e.this.f36631f != null) {
                e.this.f36631f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e eVar = e.this;
                        com.kwad.sdk.splashscreen.b.a aVar = eVar.f36626a.f36661e;
                        if (aVar != null) {
                            aVar.a(eVar.f36627b, false);
                        }
                        com.kwad.sdk.splashscreen.c cVar = e.this.f36626a;
                        if (cVar != null) {
                            AdInfo j = com.kwad.sdk.core.response.b.c.j(cVar.f36659c);
                            boolean z = e.this.f36627b;
                            AdInfo.AdSplashInfo adSplashInfo = j.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                e.this.f36631f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(e.this.f36631f, str, e.this.f36626a.f36659c);
                            }
                            e.this.f36631f.setSelected(false);
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
    public com.kwad.sdk.contentalliance.detail.video.e f36633h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.splashscreen.a.e.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f36626a.f36657a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            e eVar = e.this;
            if (eVar.f36626a.f36657a == null || eVar.f36630e) {
                return;
            }
            e.this.f36626a.f36657a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            e eVar = e.this;
            com.kwad.sdk.splashscreen.b.a aVar = eVar.f36626a.f36661e;
            if (aVar != null) {
                aVar.a(eVar.f36627b, false);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            if (e.this.f36628c) {
                return;
            }
            e.this.e();
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f36626a.f36657a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
                com.kwad.sdk.splashscreen.b.a aVar = e.this.f36626a.f36661e;
                if (aVar != null) {
                    aVar.a(true);
                    e eVar = e.this;
                    eVar.f36626a.f36661e.a(eVar.f36627b, true);
                }
            }
            e.this.f36628c = true;
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
        com.kwad.sdk.core.report.b.h(this.f36626a.f36659c);
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
        this.f36626a = cVar;
        ((DetailVideoView) cVar.f36660d.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        com.kwad.sdk.splashscreen.b.a aVar2 = this.f36626a.f36661e;
        if (aVar2 != null) {
            aVar2.a(this.f36633h);
        }
        this.f36626a.f36664h.a(this);
        final AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f36626a.f36659c);
        int i = j.adSplashInfo.mute;
        boolean z = true;
        if (i != 2) {
            if (i != 3) {
                this.f36627b = false;
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f36627b = false;
                }
                aVar = this.f36626a.f36661e;
                if (aVar != null) {
                    aVar.a(this.f36627b, false);
                    this.f36626a.f36661e.a(this.f36632g);
                }
                ImageView imageView = (ImageView) this.f36626a.f36660d.findViewById(R.id.ksad_splash_sound);
                this.f36631f = imageView;
                imageView.setVisibility(0);
                str = !this.f36627b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str)) {
                    KSImageLoader.loadImage(this.f36631f, str, this.f36626a.f36659c);
                } else {
                    this.f36631f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                this.f36631f.setSelected(this.f36627b);
                this.f36631f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e eVar = e.this;
                        eVar.f36627b = !eVar.f36627b;
                        String str2 = e.this.f36627b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            e.this.f36631f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(e.this.f36631f, str2, e.this.f36626a.f36659c);
                        }
                        e.this.f36631f.setSelected(e.this.f36627b);
                        e eVar2 = e.this;
                        eVar2.f36626a.f36661e.a(eVar2.f36627b, true);
                    }
                });
            } else if (ah.j(this.f36626a.f36660d.getContext()) <= 0) {
                z = false;
            }
        }
        this.f36627b = z;
        if (com.kwad.sdk.utils.b.a().b()) {
        }
        aVar = this.f36626a.f36661e;
        if (aVar != null) {
        }
        ImageView imageView2 = (ImageView) this.f36626a.f36660d.findViewById(R.id.ksad_splash_sound);
        this.f36631f = imageView2;
        imageView2.setVisibility(0);
        if (!this.f36627b) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        this.f36631f.setSelected(this.f36627b);
        this.f36631f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = e.this;
                eVar.f36627b = !eVar.f36627b;
                String str2 = e.this.f36627b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    e.this.f36631f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(e.this.f36631f, str2, e.this.f36626a.f36659c);
                }
                e.this.f36631f.setSelected(e.this.f36627b);
                e eVar2 = e.this;
                eVar2.f36626a.f36661e.a(eVar2.f36627b, true);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        com.kwad.sdk.splashscreen.b.a aVar = this.f36626a.f36661e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.splashscreen.b.a aVar = this.f36626a.f36661e;
        if (aVar != null) {
            aVar.b(this.f36633h);
            this.f36626a.f36661e.b(this.f36632g);
        }
        this.f36626a.f36664h.b(this);
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        if (this.f36629d) {
            return;
        }
        this.f36629d = true;
        com.kwad.sdk.core.report.b.a(this.f36626a.f36659c, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f36630e = true;
    }
}
