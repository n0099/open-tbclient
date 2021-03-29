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
    public com.kwad.sdk.splashscreen.c f36627a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f36632f;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f36628b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36629c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36630d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36631e = false;

    /* renamed from: g  reason: collision with root package name */
    public g.a f36633g = new g.a() { // from class: com.kwad.sdk.splashscreen.a.e.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            e.this.f36628b = false;
            if (e.this.f36632f != null) {
                e.this.f36632f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e eVar = e.this;
                        com.kwad.sdk.splashscreen.b.a aVar = eVar.f36627a.f36662e;
                        if (aVar != null) {
                            aVar.a(eVar.f36628b, false);
                        }
                        com.kwad.sdk.splashscreen.c cVar = e.this.f36627a;
                        if (cVar != null) {
                            AdInfo j = com.kwad.sdk.core.response.b.c.j(cVar.f36660c);
                            boolean z = e.this.f36628b;
                            AdInfo.AdSplashInfo adSplashInfo = j.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                e.this.f36632f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(e.this.f36632f, str, e.this.f36627a.f36660c);
                            }
                            e.this.f36632f.setSelected(false);
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
    public com.kwad.sdk.contentalliance.detail.video.e f36634h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.splashscreen.a.e.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f36627a.f36658a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            e eVar = e.this;
            if (eVar.f36627a.f36658a == null || eVar.f36631e) {
                return;
            }
            e.this.f36627a.f36658a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            e eVar = e.this;
            com.kwad.sdk.splashscreen.b.a aVar = eVar.f36627a.f36662e;
            if (aVar != null) {
                aVar.a(eVar.f36628b, false);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            if (e.this.f36629c) {
                return;
            }
            e.this.e();
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f36627a.f36658a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
                com.kwad.sdk.splashscreen.b.a aVar = e.this.f36627a.f36662e;
                if (aVar != null) {
                    aVar.a(true);
                    e eVar = e.this;
                    eVar.f36627a.f36662e.a(eVar.f36628b, true);
                }
            }
            e.this.f36629c = true;
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
        com.kwad.sdk.core.report.b.h(this.f36627a.f36660c);
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
        this.f36627a = cVar;
        ((DetailVideoView) cVar.f36661d.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        com.kwad.sdk.splashscreen.b.a aVar2 = this.f36627a.f36662e;
        if (aVar2 != null) {
            aVar2.a(this.f36634h);
        }
        this.f36627a.f36665h.a(this);
        final AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f36627a.f36660c);
        int i = j.adSplashInfo.mute;
        boolean z = true;
        if (i != 2) {
            if (i != 3) {
                this.f36628b = false;
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f36628b = false;
                }
                aVar = this.f36627a.f36662e;
                if (aVar != null) {
                    aVar.a(this.f36628b, false);
                    this.f36627a.f36662e.a(this.f36633g);
                }
                ImageView imageView = (ImageView) this.f36627a.f36661d.findViewById(R.id.ksad_splash_sound);
                this.f36632f = imageView;
                imageView.setVisibility(0);
                str = !this.f36628b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str)) {
                    KSImageLoader.loadImage(this.f36632f, str, this.f36627a.f36660c);
                } else {
                    this.f36632f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                this.f36632f.setSelected(this.f36628b);
                this.f36632f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e eVar = e.this;
                        eVar.f36628b = !eVar.f36628b;
                        String str2 = e.this.f36628b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            e.this.f36632f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(e.this.f36632f, str2, e.this.f36627a.f36660c);
                        }
                        e.this.f36632f.setSelected(e.this.f36628b);
                        e eVar2 = e.this;
                        eVar2.f36627a.f36662e.a(eVar2.f36628b, true);
                    }
                });
            } else if (ah.j(this.f36627a.f36661d.getContext()) <= 0) {
                z = false;
            }
        }
        this.f36628b = z;
        if (com.kwad.sdk.utils.b.a().b()) {
        }
        aVar = this.f36627a.f36662e;
        if (aVar != null) {
        }
        ImageView imageView2 = (ImageView) this.f36627a.f36661d.findViewById(R.id.ksad_splash_sound);
        this.f36632f = imageView2;
        imageView2.setVisibility(0);
        if (!this.f36628b) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        this.f36632f.setSelected(this.f36628b);
        this.f36632f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = e.this;
                eVar.f36628b = !eVar.f36628b;
                String str2 = e.this.f36628b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    e.this.f36632f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(e.this.f36632f, str2, e.this.f36627a.f36660c);
                }
                e.this.f36632f.setSelected(e.this.f36628b);
                e eVar2 = e.this;
                eVar2.f36627a.f36662e.a(eVar2.f36628b, true);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        com.kwad.sdk.splashscreen.b.a aVar = this.f36627a.f36662e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.splashscreen.b.a aVar = this.f36627a.f36662e;
        if (aVar != null) {
            aVar.b(this.f36634h);
            this.f36627a.f36662e.b(this.f36633g);
        }
        this.f36627a.f36665h.b(this);
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        if (this.f36630d) {
            return;
        }
        this.f36630d = true;
        com.kwad.sdk.core.report.b.a(this.f36627a.f36660c, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f36631e = true;
    }
}
