package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.R;
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
/* loaded from: classes8.dex */
public class j extends Presenter implements com.kwad.sdk.core.j.d {
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56371f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f56372g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f56373h;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f56367b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56368c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56369d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56370e = false;

    /* renamed from: i  reason: collision with root package name */
    public j.a f56374i = new j.a() { // from class: com.kwad.sdk.splashscreen.a.j.1
        @Override // com.kwad.sdk.utils.j.a
        public void a() {
            j.this.f56367b = false;
            if (j.this.f56371f != null) {
                j.this.f56371f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.j.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j jVar = j.this;
                        com.kwad.sdk.splashscreen.b.a aVar = jVar.a.f56439f;
                        if (aVar != null) {
                            aVar.a(jVar.f56367b, false);
                        }
                        com.kwad.sdk.splashscreen.g gVar = j.this.a;
                        if (gVar != null) {
                            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(gVar.f56437d);
                            boolean z = j.this.f56367b;
                            AdInfo.AdSplashInfo adSplashInfo = j2.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                j.this.f56371f.setImageDrawable(j.this.q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(j.this.f56371f, str, j.this.a.f56437d);
                            }
                            j.this.f56371f.setSelected(false);
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
    public com.kwad.sdk.contentalliance.detail.video.d f56375j = new com.kwad.sdk.contentalliance.detail.video.d() { // from class: com.kwad.sdk.splashscreen.a.j.2

        /* renamed from: b  reason: collision with root package name */
        public boolean f56376b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f56377c = com.kwad.sdk.core.config.b.ao();

        /* renamed from: d  reason: collision with root package name */
        public String f56378d = com.kwad.sdk.core.config.b.am();

        /* renamed from: e  reason: collision with root package name */
        public String f56379e = com.kwad.sdk.core.config.b.at();

        /* renamed from: f  reason: collision with root package name */
        public int f56380f = com.kwad.sdk.core.config.b.as();

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            j jVar = j.this;
            if (jVar.a.a == null || jVar.f56370e) {
                return;
            }
            j.this.a.a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, final long j3) {
            String str;
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
            int i2 = this.f56377c;
            final boolean h2 = j.this.h();
            if (h2) {
                str = this.f56378d;
            } else {
                i2 = Math.min(this.f56380f, ((int) j2) / 1000);
                str = this.f56379e;
            }
            final String str2 = str;
            final int i3 = i2;
            j.this.f56372g.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.j.2.1
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    int i4 = (int) (((i3 * 1000) - j3) / 1000);
                    if (i4 < 1) {
                        i4 = 1;
                    }
                    String str3 = str2 + i4;
                    if (h2) {
                        j.this.f56372g.setSkipText(str3);
                    } else {
                        j.this.f56372g.a(str3);
                    }
                }
            });
            float f2 = ((float) j3) / 1000.0f;
            if (i2 <= 0 || f2 + 0.5d <= i2 - 1) {
                return;
            }
            com.kwad.sdk.splashscreen.g gVar = j.this.a;
            if (gVar.a != null) {
                if (!gVar.f56435b) {
                    gVar.d();
                }
                com.kwad.sdk.splashscreen.g gVar2 = j.this.a;
                gVar2.f56435b = true;
                if (this.f56376b || (splashScreenAdInteractionListener = gVar2.a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f56376b = true;
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void b() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            j jVar = j.this;
            com.kwad.sdk.splashscreen.b.a aVar = jVar.a.f56439f;
            if (aVar != null) {
                aVar.a(jVar.f56367b, false);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            if (j.this.f56368c) {
                return;
            }
            j.this.g();
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = j.this.a.a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
                com.kwad.sdk.splashscreen.b.a aVar = j.this.a.f56439f;
                if (aVar != null) {
                    aVar.a(true);
                    j jVar = j.this;
                    jVar.a.f56439f.a(jVar.f56367b, true);
                }
            }
            j.this.f56368c = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
            if (this.f56376b || (splashScreenAdInteractionListener = j.this.a.a) == null) {
                return;
            }
            splashScreenAdInteractionListener.onAdShowEnd();
            this.f56376b = true;
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
        com.kwad.sdk.core.report.a.i(this.a.f56437d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        com.kwad.sdk.splashscreen.g gVar = this.a;
        return gVar != null && gVar.b() && com.kwad.sdk.core.config.b.ao() > 0 && !at.a(com.kwad.sdk.core.config.b.am());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c5  */
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
        this.f56373h = com.kwad.sdk.core.response.a.d.j(gVar.f56437d);
        ((DetailVideoView) this.a.f56438e.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        com.kwad.sdk.splashscreen.b.a aVar2 = this.a.f56439f;
        if (aVar2 != null) {
            aVar2.a(this.f56375j);
        }
        this.a.f56442i.a(this);
        SkipView skipView = (SkipView) this.a.f56438e.findViewById(R.id.ksad_splash_skip_view);
        this.f56372g = skipView;
        a(skipView, this.f56373h);
        final AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f56437d);
        int i2 = j2.adSplashInfo.mute;
        boolean z = true;
        if (i2 != 2) {
            if (i2 != 3) {
                this.f56367b = false;
                if (com.kwad.sdk.utils.b.a(q()).a()) {
                    this.f56367b = false;
                }
                aVar = this.a.f56439f;
                if (aVar != null) {
                    aVar.a(this.f56367b, false);
                    this.a.f56439f.a(this.f56374i);
                }
                ImageView imageView = (ImageView) this.a.f56438e.findViewById(R.id.ksad_splash_sound);
                this.f56371f = imageView;
                imageView.setVisibility(0);
                str = !this.f56367b ? j2.adSplashInfo.speakerIconUrl : j2.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str)) {
                    KSImageLoader.loadImage(this.f56371f, str, this.a.f56437d);
                } else {
                    this.f56371f.setImageDrawable(q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                this.f56371f.setSelected(this.f56367b);
                this.f56371f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.j.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        j jVar = j.this;
                        jVar.f56367b = !jVar.f56367b;
                        String str2 = j.this.f56367b ? j2.adSplashInfo.speakerIconUrl : j2.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            j.this.f56371f.setImageDrawable(j.this.q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(j.this.f56371f, str2, j.this.a.f56437d);
                        }
                        j.this.f56371f.setSelected(j.this.f56367b);
                        j jVar2 = j.this;
                        jVar2.a.f56439f.a(jVar2.f56367b, true);
                    }
                });
            } else if (av.u(this.a.f56438e.getContext()) <= 0) {
                z = false;
            }
        }
        this.f56367b = z;
        if (com.kwad.sdk.utils.b.a(q()).a()) {
        }
        aVar = this.a.f56439f;
        if (aVar != null) {
        }
        ImageView imageView2 = (ImageView) this.a.f56438e.findViewById(R.id.ksad_splash_sound);
        this.f56371f = imageView2;
        imageView2.setVisibility(0);
        if (!this.f56367b) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        this.f56371f.setSelected(this.f56367b);
        this.f56371f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j jVar = j.this;
                jVar.f56367b = !jVar.f56367b;
                String str2 = j.this.f56367b ? j2.adSplashInfo.speakerIconUrl : j2.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    j.this.f56371f.setImageDrawable(j.this.q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(j.this.f56371f, str2, j.this.a.f56437d);
                }
                j.this.f56371f.setSelected(j.this.f56367b);
                j jVar2 = j.this;
                jVar2.a.f56439f.a(jVar2.f56367b, true);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.splashscreen.b.a aVar = this.a.f56439f;
        if (aVar != null) {
            aVar.b(this.f56375j);
            this.a.f56439f.b(this.f56374i);
        }
        if (this.f56372g.getHandler() != null) {
            this.f56372g.getHandler().removeCallbacksAndMessages(null);
        }
        this.a.f56442i.b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        this.f56370e = true;
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        if (this.f56369d) {
            return;
        }
        this.f56369d = true;
        com.kwad.sdk.core.report.a.a(this.a.f56437d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar = this.a.f56439f;
        if (aVar != null) {
            aVar.g();
        }
    }
}
