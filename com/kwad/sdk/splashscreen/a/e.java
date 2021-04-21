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
    public com.kwad.sdk.splashscreen.c f37011a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f37016f;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f37012b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37013c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37014d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37015e = false;

    /* renamed from: g  reason: collision with root package name */
    public g.a f37017g = new g.a() { // from class: com.kwad.sdk.splashscreen.a.e.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            e.this.f37012b = false;
            if (e.this.f37016f != null) {
                e.this.f37016f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e eVar = e.this;
                        com.kwad.sdk.splashscreen.b.a aVar = eVar.f37011a.f37046e;
                        if (aVar != null) {
                            aVar.a(eVar.f37012b, false);
                        }
                        com.kwad.sdk.splashscreen.c cVar = e.this.f37011a;
                        if (cVar != null) {
                            AdInfo j = com.kwad.sdk.core.response.b.c.j(cVar.f37044c);
                            boolean z = e.this.f37012b;
                            AdInfo.AdSplashInfo adSplashInfo = j.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                e.this.f37016f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(e.this.f37016f, str, e.this.f37011a.f37044c);
                            }
                            e.this.f37016f.setSelected(false);
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
    public com.kwad.sdk.contentalliance.detail.video.e f37018h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.splashscreen.a.e.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f37011a.f37042a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            e eVar = e.this;
            if (eVar.f37011a.f37042a == null || eVar.f37015e) {
                return;
            }
            e.this.f37011a.f37042a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            e eVar = e.this;
            com.kwad.sdk.splashscreen.b.a aVar = eVar.f37011a.f37046e;
            if (aVar != null) {
                aVar.a(eVar.f37012b, false);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            if (e.this.f37013c) {
                return;
            }
            e.this.e();
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f37011a.f37042a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
                com.kwad.sdk.splashscreen.b.a aVar = e.this.f37011a.f37046e;
                if (aVar != null) {
                    aVar.a(true);
                    e eVar = e.this;
                    eVar.f37011a.f37046e.a(eVar.f37012b, true);
                }
            }
            e.this.f37013c = true;
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
        com.kwad.sdk.core.report.b.h(this.f37011a.f37044c);
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
        this.f37011a = cVar;
        ((DetailVideoView) cVar.f37045d.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        com.kwad.sdk.splashscreen.b.a aVar2 = this.f37011a.f37046e;
        if (aVar2 != null) {
            aVar2.a(this.f37018h);
        }
        this.f37011a.f37049h.a(this);
        final AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f37011a.f37044c);
        int i = j.adSplashInfo.mute;
        boolean z = true;
        if (i != 2) {
            if (i != 3) {
                this.f37012b = false;
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f37012b = false;
                }
                aVar = this.f37011a.f37046e;
                if (aVar != null) {
                    aVar.a(this.f37012b, false);
                    this.f37011a.f37046e.a(this.f37017g);
                }
                ImageView imageView = (ImageView) this.f37011a.f37045d.findViewById(R.id.ksad_splash_sound);
                this.f37016f = imageView;
                imageView.setVisibility(0);
                str = !this.f37012b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str)) {
                    KSImageLoader.loadImage(this.f37016f, str, this.f37011a.f37044c);
                } else {
                    this.f37016f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                this.f37016f.setSelected(this.f37012b);
                this.f37016f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e eVar = e.this;
                        eVar.f37012b = !eVar.f37012b;
                        String str2 = e.this.f37012b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            e.this.f37016f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(e.this.f37016f, str2, e.this.f37011a.f37044c);
                        }
                        e.this.f37016f.setSelected(e.this.f37012b);
                        e eVar2 = e.this;
                        eVar2.f37011a.f37046e.a(eVar2.f37012b, true);
                    }
                });
            } else if (ah.j(this.f37011a.f37045d.getContext()) <= 0) {
                z = false;
            }
        }
        this.f37012b = z;
        if (com.kwad.sdk.utils.b.a().b()) {
        }
        aVar = this.f37011a.f37046e;
        if (aVar != null) {
        }
        ImageView imageView2 = (ImageView) this.f37011a.f37045d.findViewById(R.id.ksad_splash_sound);
        this.f37016f = imageView2;
        imageView2.setVisibility(0);
        if (!this.f37012b) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        this.f37016f.setSelected(this.f37012b);
        this.f37016f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = e.this;
                eVar.f37012b = !eVar.f37012b;
                String str2 = e.this.f37012b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    e.this.f37016f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(e.this.f37016f, str2, e.this.f37011a.f37044c);
                }
                e.this.f37016f.setSelected(e.this.f37012b);
                e eVar2 = e.this;
                eVar2.f37011a.f37046e.a(eVar2.f37012b, true);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        com.kwad.sdk.splashscreen.b.a aVar = this.f37011a.f37046e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.splashscreen.b.a aVar = this.f37011a.f37046e;
        if (aVar != null) {
            aVar.b(this.f37018h);
            this.f37011a.f37046e.b(this.f37017g);
        }
        this.f37011a.f37049h.b(this);
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        if (this.f37014d) {
            return;
        }
        this.f37014d = true;
        com.kwad.sdk.core.report.b.a(this.f37011a.f37044c, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f37015e = true;
    }
}
