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
/* loaded from: classes5.dex */
public class j extends Presenter implements com.kwad.sdk.core.j.d {
    public com.kwad.sdk.splashscreen.g a;
    public ImageView f;
    public SkipView g;
    public AdInfo h;
    public volatile boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public j.a i = new j.a() { // from class: com.kwad.sdk.splashscreen.a.j.1
        @Override // com.kwad.sdk.utils.j.a
        public void a() {
            j.this.b = false;
            if (j.this.f != null) {
                j.this.f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.j.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j jVar = j.this;
                        com.kwad.sdk.splashscreen.b.a aVar = jVar.a.f;
                        if (aVar != null) {
                            aVar.a(jVar.b, false);
                        }
                        com.kwad.sdk.splashscreen.g gVar = j.this.a;
                        if (gVar != null) {
                            AdInfo j = com.kwad.sdk.core.response.a.d.j(gVar.d);
                            boolean z = j.this.b;
                            AdInfo.AdSplashInfo adSplashInfo = j.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                j.this.f.setImageDrawable(j.this.q().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cac));
                            } else {
                                KSImageLoader.loadImage(j.this.f, str, j.this.a.d);
                            }
                            j.this.f.setSelected(false);
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
        public boolean b = false;
        public int c = com.kwad.sdk.core.config.b.ao();
        public String d = com.kwad.sdk.core.config.b.am();
        public String e = com.kwad.sdk.core.config.b.at();
        public int f = com.kwad.sdk.core.config.b.as();

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i, int i2) {
            j jVar = j.this;
            if (jVar.a.a == null || jVar.e) {
                return;
            }
            j.this.a.a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, final long j2) {
            String str;
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
            int i = this.c;
            final boolean h = j.this.h();
            if (h) {
                str = this.d;
            } else {
                i = Math.min(this.f, ((int) j) / 1000);
                str = this.e;
            }
            final String str2 = str;
            final int i2 = i;
            j.this.g.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.j.2.1
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    int i3 = (int) (((i2 * 1000) - j2) / 1000);
                    if (i3 < 1) {
                        i3 = 1;
                    }
                    String str3 = str2 + i3;
                    if (h) {
                        j.this.g.setSkipText(str3);
                    } else {
                        j.this.g.a(str3);
                    }
                }
            });
            float f = ((float) j2) / 1000.0f;
            if (i <= 0 || f + 0.5d <= i - 1) {
                return;
            }
            com.kwad.sdk.splashscreen.g gVar = j.this.a;
            if (gVar.a != null) {
                if (!gVar.b) {
                    gVar.d();
                }
                com.kwad.sdk.splashscreen.g gVar2 = j.this.a;
                gVar2.b = true;
                if (this.b || (splashScreenAdInteractionListener = gVar2.a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.b = true;
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void b() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            j jVar = j.this;
            com.kwad.sdk.splashscreen.b.a aVar = jVar.a.f;
            if (aVar != null) {
                aVar.a(jVar.b, false);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            if (j.this.c) {
                return;
            }
            j.this.g();
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = j.this.a.a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowStart();
                com.kwad.sdk.splashscreen.b.a aVar = j.this.a.f;
                if (aVar != null) {
                    aVar.a(true);
                    j jVar = j.this;
                    jVar.a.f.a(jVar.b, true);
                }
            }
            j.this.c = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
            if (this.b || (splashScreenAdInteractionListener = j.this.a.a) == null) {
                return;
            }
            splashScreenAdInteractionListener.onAdShowEnd();
            this.b = true;
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
        com.kwad.sdk.core.report.a.i(this.a.d);
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
        this.h = com.kwad.sdk.core.response.a.d.j(gVar.d);
        ((DetailVideoView) this.a.e.findViewById(R.id.obfuscated_res_0x7f091145)).setVisibility(0);
        com.kwad.sdk.splashscreen.b.a aVar2 = this.a.f;
        if (aVar2 != null) {
            aVar2.a(this.j);
        }
        this.a.i.a(this);
        SkipView skipView = (SkipView) this.a.e.findViewById(R.id.obfuscated_res_0x7f091141);
        this.g = skipView;
        a(skipView, this.h);
        final AdInfo j = com.kwad.sdk.core.response.a.d.j(this.a.d);
        int i = j.adSplashInfo.mute;
        boolean z = true;
        if (i != 2) {
            if (i != 3) {
                this.b = false;
                if (com.kwad.sdk.utils.b.a(q()).a()) {
                    this.b = false;
                }
                aVar = this.a.f;
                if (aVar != null) {
                    aVar.a(this.b, false);
                    this.a.f.a(this.i);
                }
                ImageView imageView = (ImageView) this.a.e.findViewById(R.id.obfuscated_res_0x7f091142);
                this.f = imageView;
                imageView.setVisibility(0);
                str = !this.b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str)) {
                    KSImageLoader.loadImage(this.f, str, this.a.d);
                } else {
                    this.f.setImageDrawable(q().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cac));
                }
                this.f.setSelected(this.b);
                this.f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.j.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        j jVar = j.this;
                        jVar.b = !jVar.b;
                        String str2 = j.this.b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            j.this.f.setImageDrawable(j.this.q().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cac));
                        } else {
                            KSImageLoader.loadImage(j.this.f, str2, j.this.a.d);
                        }
                        j.this.f.setSelected(j.this.b);
                        j jVar2 = j.this;
                        jVar2.a.f.a(jVar2.b, true);
                    }
                });
            } else if (av.u(this.a.e.getContext()) <= 0) {
                z = false;
            }
        }
        this.b = z;
        if (com.kwad.sdk.utils.b.a(q()).a()) {
        }
        aVar = this.a.f;
        if (aVar != null) {
        }
        ImageView imageView2 = (ImageView) this.a.e.findViewById(R.id.obfuscated_res_0x7f091142);
        this.f = imageView2;
        imageView2.setVisibility(0);
        if (!this.b) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        this.f.setSelected(this.b);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j jVar = j.this;
                jVar.b = !jVar.b;
                String str2 = j.this.b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    j.this.f.setImageDrawable(j.this.q().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cac));
                } else {
                    KSImageLoader.loadImage(j.this.f, str2, j.this.a.d);
                }
                j.this.f.setSelected(j.this.b);
                j jVar2 = j.this;
                jVar2.a.f.a(jVar2.b, true);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.splashscreen.b.a aVar = this.a.f;
        if (aVar != null) {
            aVar.b(this.j);
            this.a.f.b(this.i);
        }
        if (this.g.getHandler() != null) {
            this.g.getHandler().removeCallbacksAndMessages(null);
        }
        this.a.i.b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        this.e = true;
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        if (this.d) {
            return;
        }
        this.d = true;
        com.kwad.sdk.core.report.a.a(this.a.d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar = this.a.f;
        if (aVar != null) {
            aVar.g();
        }
    }
}
