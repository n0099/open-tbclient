package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.widget.SkipView;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j extends Presenter implements com.kwad.sdk.core.j.d {
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f58021f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f58022g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f58023h;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f58017b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58018c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58019d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58020e = false;

    /* renamed from: i  reason: collision with root package name */
    public j.a f58024i = new j.a() { // from class: com.kwad.sdk.splashscreen.a.j.1
        @Override // com.kwad.sdk.utils.j.a
        public void a() {
            j.this.f58017b = false;
            if (j.this.f58021f != null) {
                j.this.f58021f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.j.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j jVar = j.this;
                        com.kwad.sdk.splashscreen.b.a aVar = jVar.a.f58089f;
                        if (aVar != null) {
                            aVar.a(jVar.f58017b, false);
                        }
                        com.kwad.sdk.splashscreen.g gVar = j.this.a;
                        if (gVar != null) {
                            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(gVar.f58087d);
                            boolean z = j.this.f58017b;
                            AdInfo.AdSplashInfo adSplashInfo = j2.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                j.this.f58021f.setImageDrawable(j.this.q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(j.this.f58021f, str, j.this.a.f58087d);
                            }
                            j.this.f58021f.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.j.a
        public void b() {
        }
    };

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f58025j = new com.kwad.sdk.contentalliance.detail.video.d() { // from class: com.kwad.sdk.splashscreen.a.j.2

        /* renamed from: b  reason: collision with root package name */
        public boolean f58026b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f58027c = com.kwad.sdk.core.config.b.ao();

        /* renamed from: d  reason: collision with root package name */
        public String f58028d = com.kwad.sdk.core.config.b.am();

        /* renamed from: e  reason: collision with root package name */
        public String f58029e = com.kwad.sdk.core.config.b.at();

        /* renamed from: f  reason: collision with root package name */
        public int f58030f = com.kwad.sdk.core.config.b.as();

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            j jVar = j.this;
            if (jVar.a.a == null || jVar.f58020e) {
                return;
            }
            j.this.a.a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, final long j3) {
            String str;
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
            int i2 = this.f58027c;
            final boolean h2 = j.this.h();
            if (h2) {
                str = this.f58028d;
            } else {
                i2 = Math.min(this.f58030f, ((int) j2) / 1000);
                str = this.f58029e;
            }
            final String str2 = str;
            final int i3 = i2;
            j.this.f58022g.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.j.2.1
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    int i4 = (int) (((i3 * 1000) - j3) / 1000);
                    if (i4 < 1) {
                        i4 = 1;
                    }
                    String str3 = str2 + i4;
                    if (h2) {
                        j.this.f58022g.setSkipText(str3);
                    } else {
                        j.this.f58022g.a(str3);
                    }
                }
            });
            float f2 = ((float) j3) / 1000.0f;
            if (i2 <= 0 || f2 + 0.5d <= i2 - 1) {
                return;
            }
            com.kwad.sdk.splashscreen.g gVar = j.this.a;
            if (gVar.a != null) {
                if (!gVar.f58085b) {
                    gVar.d();
                }
                com.kwad.sdk.splashscreen.g gVar2 = j.this.a;
                gVar2.f58085b = true;
                if (this.f58026b || (splashScreenAdInteractionListener = gVar2.a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f58026b = true;
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void b() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            j jVar = j.this;
            com.kwad.sdk.splashscreen.b.a aVar = jVar.a.f58089f;
            if (aVar != null) {
                aVar.a(jVar.f58017b, false);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            if (j.this.f58018c) {
                return;
            }
            j.this.g();
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = j.this.a.a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
                com.kwad.sdk.splashscreen.b.a aVar = j.this.a.f58089f;
                if (aVar != null) {
                    aVar.a(true);
                    j jVar = j.this;
                    jVar.a.f58089f.a(jVar.f58017b, true);
                }
            }
            j.this.f58018c = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
            if (this.f58026b || (splashScreenAdInteractionListener = j.this.a.a) == null) {
                return;
            }
            splashScreenAdInteractionListener.onAdShowEnd();
            this.f58026b = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void g() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void h() {
        }
    };

    private void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(h() ? false : com.kwad.sdk.core.response.a.a.aw(adInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.a.i(this.a.f58087d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        com.kwad.sdk.splashscreen.g gVar = this.a;
        return gVar != null && gVar.b() && com.kwad.sdk.core.config.b.ao() > 0 && !at.a(com.kwad.sdk.core.config.b.am());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c2  */
    @Override // com.kwad.sdk.mvp.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        com.kwad.sdk.splashscreen.b.a aVar;
        String str;
        super.a();
        com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
        this.a = gVar;
        this.f58023h = com.kwad.sdk.core.response.a.d.j(gVar.f58087d);
        ((DetailVideoView) this.a.f58088e.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        com.kwad.sdk.splashscreen.b.a aVar2 = this.a.f58089f;
        if (aVar2 != null) {
            aVar2.a(this.f58025j);
        }
        this.a.f58092i.a(this);
        SkipView skipView = (SkipView) this.a.f58088e.findViewById(R.id.ksad_splash_skip_view);
        this.f58022g = skipView;
        a(skipView, this.f58023h);
        final AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f58087d);
        int i2 = j2.adSplashInfo.mute;
        boolean z = true;
        if (i2 != 2) {
            if (i2 != 3) {
                this.f58017b = false;
                if (com.kwad.sdk.utils.b.a(q()).a()) {
                    this.f58017b = false;
                }
                aVar = this.a.f58089f;
                if (aVar != null) {
                    aVar.a(this.f58017b, false);
                    this.a.f58089f.a(this.f58024i);
                }
                ImageView imageView = (ImageView) this.a.f58088e.findViewById(R.id.ksad_splash_sound);
                this.f58021f = imageView;
                imageView.setVisibility(0);
                str = !this.f58017b ? j2.adSplashInfo.speakerIconUrl : j2.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str)) {
                    KSImageLoader.loadImage(this.f58021f, str, this.a.f58087d);
                } else {
                    this.f58021f.setImageDrawable(q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                this.f58021f.setSelected(this.f58017b);
                this.f58021f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.j.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        j jVar = j.this;
                        jVar.f58017b = !jVar.f58017b;
                        String str2 = j.this.f58017b ? j2.adSplashInfo.speakerIconUrl : j2.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            j.this.f58021f.setImageDrawable(j.this.q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(j.this.f58021f, str2, j.this.a.f58087d);
                        }
                        j.this.f58021f.setSelected(j.this.f58017b);
                        j jVar2 = j.this;
                        jVar2.a.f58089f.a(jVar2.f58017b, true);
                    }
                });
            } else if (av.u(this.a.f58088e.getContext()) <= 0) {
                z = false;
            }
        }
        this.f58017b = z;
        if (com.kwad.sdk.utils.b.a(q()).a()) {
        }
        aVar = this.a.f58089f;
        if (aVar != null) {
        }
        ImageView imageView2 = (ImageView) this.a.f58088e.findViewById(R.id.ksad_splash_sound);
        this.f58021f = imageView2;
        imageView2.setVisibility(0);
        if (!this.f58017b) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        this.f58021f.setSelected(this.f58017b);
        this.f58021f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j jVar = j.this;
                jVar.f58017b = !jVar.f58017b;
                String str2 = j.this.f58017b ? j2.adSplashInfo.speakerIconUrl : j2.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    j.this.f58021f.setImageDrawable(j.this.q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(j.this.f58021f, str2, j.this.a.f58087d);
                }
                j.this.f58021f.setSelected(j.this.f58017b);
                j jVar2 = j.this;
                jVar2.a.f58089f.a(jVar2.f58017b, true);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.splashscreen.b.a aVar = this.a.f58089f;
        if (aVar != null) {
            aVar.b(this.f58025j);
            this.a.f58089f.b(this.f58024i);
        }
        if (this.f58022g.getHandler() != null) {
            this.f58022g.getHandler().removeCallbacksAndMessages(null);
        }
        this.a.f58092i.b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        this.f58020e = true;
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        if (this.f58019d) {
            return;
        }
        this.f58019d = true;
        com.kwad.sdk.core.report.a.a(this.a.f58087d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar = this.a.f58089f;
        if (aVar != null) {
            aVar.g();
        }
    }
}
