package com.kwad.sdk.splashscreen.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends Presenter implements com.kwad.sdk.core.i.c {

    /* renamed from: a  reason: collision with root package name */
    protected com.kwad.sdk.splashscreen.c f7089a;
    private ImageView f;
    private volatile boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private g.a g = new g.a() { // from class: com.kwad.sdk.splashscreen.a.e.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            e.this.b = false;
            if (e.this.f != null) {
                e.this.f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.f7089a.e != null) {
                            e.this.f7089a.e.a(e.this.b, false);
                        }
                        if (e.this.f7089a != null) {
                            AdInfo j = com.kwad.sdk.core.response.b.c.j(e.this.f7089a.c);
                            String str = e.this.b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                e.this.f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(e.this.f, str, e.this.f7089a.c);
                            }
                            e.this.f.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
        }
    };
    private com.kwad.sdk.contentalliance.detail.video.e h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.splashscreen.a.e.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            if (e.this.f7089a.f7099a != null) {
                e.this.f7089a.f7099a.onAdShowEnd();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            if (e.this.f7089a.f7099a == null || e.this.e) {
                return;
            }
            e.this.f7089a.f7099a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            if (e.this.f7089a.e != null) {
                e.this.f7089a.e.a(e.this.b, false);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            if (e.this.c) {
                return;
            }
            e.this.e();
            if (e.this.f7089a.f7099a != null) {
                e.this.f7089a.f7099a.onAdShowStart();
                if (e.this.f7089a.e != null) {
                    e.this.f7089a.e.a(true);
                    e.this.f7089a.e.a(e.this.b, true);
                }
            }
            e.this.c = true;
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
        com.kwad.sdk.core.report.b.h(this.f7089a.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f7089a = (com.kwad.sdk.splashscreen.c) n();
        ((DetailVideoView) this.f7089a.d.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        if (this.f7089a.e != null) {
            this.f7089a.e.a(this.h);
        }
        this.f7089a.h.a(this);
        final AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f7089a.c);
        switch (j.adSplashInfo.mute) {
            case 2:
                this.b = true;
                break;
            case 3:
                this.b = ah.j(this.f7089a.d.getContext()) > 0;
                break;
            default:
                this.b = false;
                break;
        }
        if (com.kwad.sdk.utils.b.a().b()) {
            this.b = false;
        }
        if (this.f7089a.e != null) {
            this.f7089a.e.a(this.b, false);
            this.f7089a.e.a(this.g);
        }
        this.f = (ImageView) this.f7089a.d.findViewById(R.id.ksad_splash_sound);
        this.f.setVisibility(0);
        String str = this.b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
        if (TextUtils.isEmpty(str)) {
            this.f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
        } else {
            KSImageLoader.loadImage(this.f, str, this.f7089a.c);
        }
        this.f.setSelected(this.b);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.b = !e.this.b;
                String str2 = e.this.b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    e.this.f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(e.this.f, str2, e.this.f7089a.c);
                }
                e.this.f.setSelected(e.this.b);
                e.this.f7089a.e.a(e.this.b, true);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        if (this.f7089a.e != null) {
            this.f7089a.e.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f7089a.e != null) {
            this.f7089a.e.b(this.h);
            this.f7089a.e.b(this.g);
        }
        this.f7089a.h.b(this);
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        if (this.d) {
            return;
        }
        this.d = true;
        com.kwad.sdk.core.report.b.a(this.f7089a.c, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.e = true;
    }
}
