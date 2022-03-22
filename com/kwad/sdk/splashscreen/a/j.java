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
/* loaded from: classes7.dex */
public class j extends Presenter implements com.kwad.sdk.core.j.d {
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f41274f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f41275g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f41276h;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f41270b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41271c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41272d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41273e = false;
    public j.a i = new j.a() { // from class: com.kwad.sdk.splashscreen.a.j.1
        @Override // com.kwad.sdk.utils.j.a
        public void a() {
            j.this.f41270b = false;
            if (j.this.f41274f != null) {
                j.this.f41274f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.j.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j jVar = j.this;
                        com.kwad.sdk.splashscreen.b.a aVar = jVar.a.f41332f;
                        if (aVar != null) {
                            aVar.a(jVar.f41270b, false);
                        }
                        com.kwad.sdk.splashscreen.g gVar = j.this.a;
                        if (gVar != null) {
                            AdInfo j = com.kwad.sdk.core.response.a.d.j(gVar.f41330d);
                            boolean z = j.this.f41270b;
                            AdInfo.AdSplashInfo adSplashInfo = j.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                j.this.f41274f.setImageDrawable(j.this.q().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cab));
                            } else {
                                KSImageLoader.loadImage(j.this.f41274f, str, j.this.a.f41330d);
                            }
                            j.this.f41274f.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.j.a
        public void b() {
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d j = new com.kwad.sdk.contentalliance.detail.video.d() { // from class: com.kwad.sdk.splashscreen.a.j.2

        /* renamed from: b  reason: collision with root package name */
        public boolean f41277b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f41278c = com.kwad.sdk.core.config.b.ao();

        /* renamed from: d  reason: collision with root package name */
        public String f41279d = com.kwad.sdk.core.config.b.am();

        /* renamed from: e  reason: collision with root package name */
        public String f41280e = com.kwad.sdk.core.config.b.at();

        /* renamed from: f  reason: collision with root package name */
        public int f41281f = com.kwad.sdk.core.config.b.as();

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i, int i2) {
            j jVar = j.this;
            if (jVar.a.a == null || jVar.f41273e) {
                return;
            }
            j.this.a.a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, final long j2) {
            String str;
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
            int i = this.f41278c;
            final boolean h2 = j.this.h();
            if (h2) {
                str = this.f41279d;
            } else {
                i = Math.min(this.f41281f, ((int) j) / 1000);
                str = this.f41280e;
            }
            final String str2 = str;
            final int i2 = i;
            j.this.f41275g.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.j.2.1
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    int i3 = (int) (((i2 * 1000) - j2) / 1000);
                    if (i3 < 1) {
                        i3 = 1;
                    }
                    String str3 = str2 + i3;
                    if (h2) {
                        j.this.f41275g.setSkipText(str3);
                    } else {
                        j.this.f41275g.a(str3);
                    }
                }
            });
            float f2 = ((float) j2) / 1000.0f;
            if (i <= 0 || f2 + 0.5d <= i - 1) {
                return;
            }
            com.kwad.sdk.splashscreen.g gVar = j.this.a;
            if (gVar.a != null) {
                if (!gVar.f41328b) {
                    gVar.d();
                }
                com.kwad.sdk.splashscreen.g gVar2 = j.this.a;
                gVar2.f41328b = true;
                if (this.f41277b || (splashScreenAdInteractionListener = gVar2.a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f41277b = true;
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void b() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            j jVar = j.this;
            com.kwad.sdk.splashscreen.b.a aVar = jVar.a.f41332f;
            if (aVar != null) {
                aVar.a(jVar.f41270b, false);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            if (j.this.f41271c) {
                return;
            }
            j.this.g();
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = j.this.a.a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
                com.kwad.sdk.splashscreen.b.a aVar = j.this.a.f41332f;
                if (aVar != null) {
                    aVar.a(true);
                    j jVar = j.this;
                    jVar.a.f41332f.a(jVar.f41270b, true);
                }
            }
            j.this.f41271c = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
            if (this.f41277b || (splashScreenAdInteractionListener = j.this.a.a) == null) {
                return;
            }
            splashScreenAdInteractionListener.onAdShowEnd();
            this.f41277b = true;
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
        com.kwad.sdk.core.report.a.i(this.a.f41330d);
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
        this.f41276h = com.kwad.sdk.core.response.a.d.j(gVar.f41330d);
        ((DetailVideoView) this.a.f41331e.findViewById(R.id.obfuscated_res_0x7f09114c)).setVisibility(0);
        com.kwad.sdk.splashscreen.b.a aVar2 = this.a.f41332f;
        if (aVar2 != null) {
            aVar2.a(this.j);
        }
        this.a.i.a(this);
        SkipView skipView = (SkipView) this.a.f41331e.findViewById(R.id.obfuscated_res_0x7f091148);
        this.f41275g = skipView;
        a(skipView, this.f41276h);
        final AdInfo j = com.kwad.sdk.core.response.a.d.j(this.a.f41330d);
        int i = j.adSplashInfo.mute;
        boolean z = true;
        if (i != 2) {
            if (i != 3) {
                this.f41270b = false;
                if (com.kwad.sdk.utils.b.a(q()).a()) {
                    this.f41270b = false;
                }
                aVar = this.a.f41332f;
                if (aVar != null) {
                    aVar.a(this.f41270b, false);
                    this.a.f41332f.a(this.i);
                }
                ImageView imageView = (ImageView) this.a.f41331e.findViewById(R.id.obfuscated_res_0x7f091149);
                this.f41274f = imageView;
                imageView.setVisibility(0);
                str = !this.f41270b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str)) {
                    KSImageLoader.loadImage(this.f41274f, str, this.a.f41330d);
                } else {
                    this.f41274f.setImageDrawable(q().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cab));
                }
                this.f41274f.setSelected(this.f41270b);
                this.f41274f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.j.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        j jVar = j.this;
                        jVar.f41270b = !jVar.f41270b;
                        String str2 = j.this.f41270b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            j.this.f41274f.setImageDrawable(j.this.q().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cab));
                        } else {
                            KSImageLoader.loadImage(j.this.f41274f, str2, j.this.a.f41330d);
                        }
                        j.this.f41274f.setSelected(j.this.f41270b);
                        j jVar2 = j.this;
                        jVar2.a.f41332f.a(jVar2.f41270b, true);
                    }
                });
            } else if (av.u(this.a.f41331e.getContext()) <= 0) {
                z = false;
            }
        }
        this.f41270b = z;
        if (com.kwad.sdk.utils.b.a(q()).a()) {
        }
        aVar = this.a.f41332f;
        if (aVar != null) {
        }
        ImageView imageView2 = (ImageView) this.a.f41331e.findViewById(R.id.obfuscated_res_0x7f091149);
        this.f41274f = imageView2;
        imageView2.setVisibility(0);
        if (!this.f41270b) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        this.f41274f.setSelected(this.f41270b);
        this.f41274f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j jVar = j.this;
                jVar.f41270b = !jVar.f41270b;
                String str2 = j.this.f41270b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    j.this.f41274f.setImageDrawable(j.this.q().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cab));
                } else {
                    KSImageLoader.loadImage(j.this.f41274f, str2, j.this.a.f41330d);
                }
                j.this.f41274f.setSelected(j.this.f41270b);
                j jVar2 = j.this;
                jVar2.a.f41332f.a(jVar2.f41270b, true);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.splashscreen.b.a aVar = this.a.f41332f;
        if (aVar != null) {
            aVar.b(this.j);
            this.a.f41332f.b(this.i);
        }
        if (this.f41275g.getHandler() != null) {
            this.f41275g.getHandler().removeCallbacksAndMessages(null);
        }
        this.a.i.b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        this.f41273e = true;
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        if (this.f41272d) {
            return;
        }
        this.f41272d = true;
        com.kwad.sdk.core.report.a.a(this.a.f41330d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar = this.a.f41332f;
        if (aVar != null) {
            aVar.g();
        }
    }
}
