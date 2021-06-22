package com.kwad.sdk.reward.b.b.b;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.utils.g;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f37173b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f37174c;

    /* renamed from: d  reason: collision with root package name */
    public g.a f37175d = new g.a() { // from class: com.kwad.sdk.reward.b.b.b.d.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            if (d.this.f37173b != null) {
                d.this.f37173b.post(new Runnable() { // from class: com.kwad.sdk.reward.b.b.b.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.f37173b.setSelected(false);
                        d.this.f37174c.a(false, false);
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f37176e = new f() { // from class: com.kwad.sdk.reward.b.b.b.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f37173b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        ImageView imageView;
        boolean z;
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f37299a;
        this.f37174c = aVar.f37056i;
        KsVideoPlayConfig ksVideoPlayConfig = aVar.f37050c;
        if (com.kwad.sdk.utils.b.a().b()) {
            imageView = this.f37173b;
            z = false;
        } else if (ksVideoPlayConfig != null) {
            this.f37173b.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.f37174c.a(this.f37176e);
            this.f37174c.a(this.f37175d);
        } else {
            imageView = this.f37173b;
            z = true;
        }
        imageView.setSelected(z);
        this.f37174c.a(this.f37176e);
        this.f37174c.a(this.f37175d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f37174c.b(this.f37176e);
        this.f37174c.b(this.f37175d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37173b = (ImageView) b(R.id.ksad_video_sound_switch);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.f37173b;
        if (view == imageView) {
            this.f37174c.a(!imageView.isSelected(), true);
            ImageView imageView2 = this.f37173b;
            imageView2.setSelected(!imageView2.isSelected());
        }
    }
}
