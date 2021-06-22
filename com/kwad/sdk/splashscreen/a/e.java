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
/* loaded from: classes7.dex */
public class e extends Presenter implements com.kwad.sdk.core.i.c {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f37478a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f37483f;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f37479b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37480c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37481d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37482e = false;

    /* renamed from: g  reason: collision with root package name */
    public g.a f37484g = new g.a() { // from class: com.kwad.sdk.splashscreen.a.e.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            e.this.f37479b = false;
            if (e.this.f37483f != null) {
                e.this.f37483f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e eVar = e.this;
                        com.kwad.sdk.splashscreen.b.a aVar = eVar.f37478a.f37515e;
                        if (aVar != null) {
                            aVar.a(eVar.f37479b, false);
                        }
                        com.kwad.sdk.splashscreen.c cVar = e.this.f37478a;
                        if (cVar != null) {
                            AdInfo j = com.kwad.sdk.core.response.b.c.j(cVar.f37513c);
                            boolean z = e.this.f37479b;
                            AdInfo.AdSplashInfo adSplashInfo = j.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                e.this.f37483f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(e.this.f37483f, str, e.this.f37478a.f37513c);
                            }
                            e.this.f37483f.setSelected(false);
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
    public com.kwad.sdk.contentalliance.detail.video.e f37485h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.splashscreen.a.e.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f37478a.f37511a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i2, int i3) {
            e eVar = e.this;
            if (eVar.f37478a.f37511a == null || eVar.f37482e) {
                return;
            }
            e.this.f37478a.f37511a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            e eVar = e.this;
            com.kwad.sdk.splashscreen.b.a aVar = eVar.f37478a.f37515e;
            if (aVar != null) {
                aVar.a(eVar.f37479b, false);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            if (e.this.f37480c) {
                return;
            }
            e.this.e();
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f37478a.f37511a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
                com.kwad.sdk.splashscreen.b.a aVar = e.this.f37478a.f37515e;
                if (aVar != null) {
                    aVar.a(true);
                    e eVar = e.this;
                    eVar.f37478a.f37515e.a(eVar.f37479b, true);
                }
            }
            e.this.f37480c = true;
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
        com.kwad.sdk.core.report.b.h(this.f37478a.f37513c);
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
        this.f37478a = cVar;
        ((DetailVideoView) cVar.f37514d.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        com.kwad.sdk.splashscreen.b.a aVar2 = this.f37478a.f37515e;
        if (aVar2 != null) {
            aVar2.a(this.f37485h);
        }
        this.f37478a.f37518h.a(this);
        final AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f37478a.f37513c);
        int i2 = j.adSplashInfo.mute;
        boolean z = true;
        if (i2 != 2) {
            if (i2 != 3) {
                this.f37479b = false;
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f37479b = false;
                }
                aVar = this.f37478a.f37515e;
                if (aVar != null) {
                    aVar.a(this.f37479b, false);
                    this.f37478a.f37515e.a(this.f37484g);
                }
                ImageView imageView = (ImageView) this.f37478a.f37514d.findViewById(R.id.ksad_splash_sound);
                this.f37483f = imageView;
                imageView.setVisibility(0);
                str = !this.f37479b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str)) {
                    KSImageLoader.loadImage(this.f37483f, str, this.f37478a.f37513c);
                } else {
                    this.f37483f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                this.f37483f.setSelected(this.f37479b);
                this.f37483f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e eVar = e.this;
                        eVar.f37479b = !eVar.f37479b;
                        String str2 = e.this.f37479b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            e.this.f37483f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(e.this.f37483f, str2, e.this.f37478a.f37513c);
                        }
                        e.this.f37483f.setSelected(e.this.f37479b);
                        e eVar2 = e.this;
                        eVar2.f37478a.f37515e.a(eVar2.f37479b, true);
                    }
                });
            } else if (ah.j(this.f37478a.f37514d.getContext()) <= 0) {
                z = false;
            }
        }
        this.f37479b = z;
        if (com.kwad.sdk.utils.b.a().b()) {
        }
        aVar = this.f37478a.f37515e;
        if (aVar != null) {
        }
        ImageView imageView2 = (ImageView) this.f37478a.f37514d.findViewById(R.id.ksad_splash_sound);
        this.f37483f = imageView2;
        imageView2.setVisibility(0);
        if (!this.f37479b) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        this.f37483f.setSelected(this.f37479b);
        this.f37483f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = e.this;
                eVar.f37479b = !eVar.f37479b;
                String str2 = e.this.f37479b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    e.this.f37483f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(e.this.f37483f, str2, e.this.f37478a.f37513c);
                }
                e.this.f37483f.setSelected(e.this.f37479b);
                e eVar2 = e.this;
                eVar2.f37478a.f37515e.a(eVar2.f37479b, true);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        com.kwad.sdk.splashscreen.b.a aVar = this.f37478a.f37515e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.splashscreen.b.a aVar = this.f37478a.f37515e;
        if (aVar != null) {
            aVar.b(this.f37485h);
            this.f37478a.f37515e.b(this.f37484g);
        }
        this.f37478a.f37518h.b(this);
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        if (this.f37481d) {
            return;
        }
        this.f37481d = true;
        com.kwad.sdk.core.report.b.a(this.f37478a.f37513c, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f37482e = true;
    }
}
