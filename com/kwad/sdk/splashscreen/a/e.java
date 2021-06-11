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
    public com.kwad.sdk.splashscreen.c f37380a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f37385f;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f37381b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37382c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37383d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37384e = false;

    /* renamed from: g  reason: collision with root package name */
    public g.a f37386g = new g.a() { // from class: com.kwad.sdk.splashscreen.a.e.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            e.this.f37381b = false;
            if (e.this.f37385f != null) {
                e.this.f37385f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e eVar = e.this;
                        com.kwad.sdk.splashscreen.b.a aVar = eVar.f37380a.f37417e;
                        if (aVar != null) {
                            aVar.a(eVar.f37381b, false);
                        }
                        com.kwad.sdk.splashscreen.c cVar = e.this.f37380a;
                        if (cVar != null) {
                            AdInfo j = com.kwad.sdk.core.response.b.c.j(cVar.f37415c);
                            boolean z = e.this.f37381b;
                            AdInfo.AdSplashInfo adSplashInfo = j.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                e.this.f37385f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(e.this.f37385f, str, e.this.f37380a.f37415c);
                            }
                            e.this.f37385f.setSelected(false);
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
    public com.kwad.sdk.contentalliance.detail.video.e f37387h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.splashscreen.a.e.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f37380a.f37413a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i2, int i3) {
            e eVar = e.this;
            if (eVar.f37380a.f37413a == null || eVar.f37384e) {
                return;
            }
            e.this.f37380a.f37413a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            e eVar = e.this;
            com.kwad.sdk.splashscreen.b.a aVar = eVar.f37380a.f37417e;
            if (aVar != null) {
                aVar.a(eVar.f37381b, false);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            if (e.this.f37382c) {
                return;
            }
            e.this.e();
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f37380a.f37413a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
                com.kwad.sdk.splashscreen.b.a aVar = e.this.f37380a.f37417e;
                if (aVar != null) {
                    aVar.a(true);
                    e eVar = e.this;
                    eVar.f37380a.f37417e.a(eVar.f37381b, true);
                }
            }
            e.this.f37382c = true;
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
        com.kwad.sdk.core.report.b.h(this.f37380a.f37415c);
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
        this.f37380a = cVar;
        ((DetailVideoView) cVar.f37416d.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        com.kwad.sdk.splashscreen.b.a aVar2 = this.f37380a.f37417e;
        if (aVar2 != null) {
            aVar2.a(this.f37387h);
        }
        this.f37380a.f37420h.a(this);
        final AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f37380a.f37415c);
        int i2 = j.adSplashInfo.mute;
        boolean z = true;
        if (i2 != 2) {
            if (i2 != 3) {
                this.f37381b = false;
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f37381b = false;
                }
                aVar = this.f37380a.f37417e;
                if (aVar != null) {
                    aVar.a(this.f37381b, false);
                    this.f37380a.f37417e.a(this.f37386g);
                }
                ImageView imageView = (ImageView) this.f37380a.f37416d.findViewById(R.id.ksad_splash_sound);
                this.f37385f = imageView;
                imageView.setVisibility(0);
                str = !this.f37381b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str)) {
                    KSImageLoader.loadImage(this.f37385f, str, this.f37380a.f37415c);
                } else {
                    this.f37385f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                this.f37385f.setSelected(this.f37381b);
                this.f37385f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e eVar = e.this;
                        eVar.f37381b = !eVar.f37381b;
                        String str2 = e.this.f37381b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            e.this.f37385f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(e.this.f37385f, str2, e.this.f37380a.f37415c);
                        }
                        e.this.f37385f.setSelected(e.this.f37381b);
                        e eVar2 = e.this;
                        eVar2.f37380a.f37417e.a(eVar2.f37381b, true);
                    }
                });
            } else if (ah.j(this.f37380a.f37416d.getContext()) <= 0) {
                z = false;
            }
        }
        this.f37381b = z;
        if (com.kwad.sdk.utils.b.a().b()) {
        }
        aVar = this.f37380a.f37417e;
        if (aVar != null) {
        }
        ImageView imageView2 = (ImageView) this.f37380a.f37416d.findViewById(R.id.ksad_splash_sound);
        this.f37385f = imageView2;
        imageView2.setVisibility(0);
        if (!this.f37381b) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        this.f37385f.setSelected(this.f37381b);
        this.f37385f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = e.this;
                eVar.f37381b = !eVar.f37381b;
                String str2 = e.this.f37381b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    e.this.f37385f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(e.this.f37385f, str2, e.this.f37380a.f37415c);
                }
                e.this.f37385f.setSelected(e.this.f37381b);
                e eVar2 = e.this;
                eVar2.f37380a.f37417e.a(eVar2.f37381b, true);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        com.kwad.sdk.splashscreen.b.a aVar = this.f37380a.f37417e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.splashscreen.b.a aVar = this.f37380a.f37417e;
        if (aVar != null) {
            aVar.b(this.f37387h);
            this.f37380a.f37417e.b(this.f37386g);
        }
        this.f37380a.f37420h.b(this);
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        if (this.f37383d) {
            return;
        }
        this.f37383d = true;
        com.kwad.sdk.core.report.b.a(this.f37380a.f37415c, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f37384e = true;
    }
}
