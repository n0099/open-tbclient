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
/* loaded from: classes5.dex */
public class e extends Presenter implements com.kwad.sdk.core.i.c {

    /* renamed from: a  reason: collision with root package name */
    protected com.kwad.sdk.splashscreen.c f11032a;
    private ImageView f;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f11033b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private g.a g = new g.a() { // from class: com.kwad.sdk.splashscreen.a.e.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            e.this.f11033b = false;
            if (e.this.f != null) {
                e.this.f.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.f11032a.e != null) {
                            e.this.f11032a.e.a(e.this.f11033b, false);
                        }
                        if (e.this.f11032a != null) {
                            AdInfo j = com.kwad.sdk.core.response.b.c.j(e.this.f11032a.c);
                            String str = e.this.f11033b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                e.this.f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(e.this.f, str, e.this.f11032a.c);
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
            if (e.this.f11032a.f11046a != null) {
                e.this.f11032a.f11046a.onAdShowEnd();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            if (e.this.f11032a.f11046a == null || e.this.e) {
                return;
            }
            e.this.f11032a.f11046a.onAdShowError(0, "onVideoPlayError");
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            if (e.this.f11032a.e != null) {
                e.this.f11032a.e.a(e.this.f11033b, false);
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
            if (e.this.f11032a.f11046a != null) {
                e.this.f11032a.f11046a.onAdShowStart();
                if (e.this.f11032a.e != null) {
                    e.this.f11032a.e.a(true);
                    e.this.f11032a.e.a(e.this.f11033b, true);
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
        com.kwad.sdk.core.report.b.h(this.f11032a.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f11032a = (com.kwad.sdk.splashscreen.c) n();
        ((DetailVideoView) this.f11032a.d.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        if (this.f11032a.e != null) {
            this.f11032a.e.a(this.h);
        }
        this.f11032a.h.a(this);
        final AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f11032a.c);
        switch (j.adSplashInfo.mute) {
            case 2:
                this.f11033b = true;
                break;
            case 3:
                this.f11033b = ah.j(this.f11032a.d.getContext()) > 0;
                break;
            default:
                this.f11033b = false;
                break;
        }
        if (com.kwad.sdk.utils.b.a().b()) {
            this.f11033b = false;
        }
        if (this.f11032a.e != null) {
            this.f11032a.e.a(this.f11033b, false);
            this.f11032a.e.a(this.g);
        }
        this.f = (ImageView) this.f11032a.d.findViewById(R.id.ksad_splash_sound);
        this.f.setVisibility(0);
        String str = this.f11033b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
        if (TextUtils.isEmpty(str)) {
            this.f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
        } else {
            KSImageLoader.loadImage(this.f, str, this.f11032a.c);
        }
        this.f.setSelected(this.f11033b);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.f11033b = !e.this.f11033b;
                String str2 = e.this.f11033b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    e.this.f.setImageDrawable(e.this.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(e.this.f, str2, e.this.f11032a.c);
                }
                e.this.f.setSelected(e.this.f11033b);
                e.this.f11032a.e.a(e.this.f11033b, true);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        if (this.f11032a.e != null) {
            this.f11032a.e.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f11032a.e != null) {
            this.f11032a.e.b(this.h);
            this.f11032a.e.b(this.g);
        }
        this.f11032a.h.b(this);
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        if (this.d) {
            return;
        }
        this.d = true;
        com.kwad.sdk.core.report.b.a(this.f11032a.c, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.e = true;
    }
}
