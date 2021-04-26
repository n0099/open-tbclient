package com.kwad.sdk.reward.b.b.b;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.g;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34447b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f34448c;

    /* renamed from: d  reason: collision with root package name */
    public g.a f34449d = new g.a() { // from class: com.kwad.sdk.reward.b.b.b.d.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            if (d.this.f34447b != null) {
                d.this.f34447b.post(new Runnable() { // from class: com.kwad.sdk.reward.b.b.b.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.f34447b.setSelected(false);
                        d.this.f34448c.a(false, false);
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f34450e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.b.b.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f34447b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        ImageView imageView;
        boolean z;
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f34594a;
        this.f34448c = aVar.f34324i;
        KsVideoPlayConfig ksVideoPlayConfig = aVar.f34318c;
        if (com.kwad.sdk.utils.b.a().b()) {
            imageView = this.f34447b;
            z = false;
        } else if (ksVideoPlayConfig != null) {
            this.f34447b.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.f34448c.a(this.f34450e);
            this.f34448c.a(this.f34449d);
        } else {
            imageView = this.f34447b;
            z = true;
        }
        imageView.setSelected(z);
        this.f34448c.a(this.f34450e);
        this.f34448c.a(this.f34449d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34447b = (ImageView) a(R.id.ksad_video_sound_switch);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34448c.b(this.f34450e);
        this.f34448c.b(this.f34449d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.f34447b;
        if (view == imageView) {
            this.f34448c.a(!imageView.isSelected(), true);
            ImageView imageView2 = this.f34447b;
            imageView2.setSelected(!imageView2.isSelected());
        }
    }
}
