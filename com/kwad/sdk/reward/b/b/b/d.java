package com.kwad.sdk.reward.b.b.b;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.utils.g;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f36337b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f36338c;

    /* renamed from: d  reason: collision with root package name */
    public g.a f36339d = new g.a() { // from class: com.kwad.sdk.reward.b.b.b.d.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            if (d.this.f36337b != null) {
                d.this.f36337b.post(new Runnable() { // from class: com.kwad.sdk.reward.b.b.b.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.f36337b.setSelected(false);
                        d.this.f36338c.a(false, false);
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f36340e = new f() { // from class: com.kwad.sdk.reward.b.b.b.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f36337b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        ImageView imageView;
        boolean z;
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36458a;
        this.f36338c = aVar.i;
        KsVideoPlayConfig ksVideoPlayConfig = aVar.f36219c;
        if (com.kwad.sdk.utils.b.a().b()) {
            imageView = this.f36337b;
            z = false;
        } else if (ksVideoPlayConfig != null) {
            this.f36337b.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.f36338c.a(this.f36340e);
            this.f36338c.a(this.f36339d);
        } else {
            imageView = this.f36337b;
            z = true;
        }
        imageView.setSelected(z);
        this.f36338c.a(this.f36340e);
        this.f36338c.a(this.f36339d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36338c.b(this.f36340e);
        this.f36338c.b(this.f36339d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36337b = (ImageView) b(R.id.ksad_video_sound_switch);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.f36337b;
        if (view == imageView) {
            this.f36338c.a(!imageView.isSelected(), true);
            ImageView imageView2 = this.f36337b;
            imageView2.setSelected(!imageView2.isSelected());
        }
    }
}
