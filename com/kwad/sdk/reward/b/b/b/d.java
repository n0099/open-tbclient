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
    public ImageView f36626b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f36627c;

    /* renamed from: d  reason: collision with root package name */
    public g.a f36628d = new g.a() { // from class: com.kwad.sdk.reward.b.b.b.d.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            if (d.this.f36626b != null) {
                d.this.f36626b.post(new Runnable() { // from class: com.kwad.sdk.reward.b.b.b.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.f36626b.setSelected(false);
                        d.this.f36627c.a(false, false);
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f36629e = new f() { // from class: com.kwad.sdk.reward.b.b.b.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f36626b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        ImageView imageView;
        boolean z;
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36747a;
        this.f36627c = aVar.i;
        KsVideoPlayConfig ksVideoPlayConfig = aVar.f36508c;
        if (com.kwad.sdk.utils.b.a().b()) {
            imageView = this.f36626b;
            z = false;
        } else if (ksVideoPlayConfig != null) {
            this.f36626b.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.f36627c.a(this.f36629e);
            this.f36627c.a(this.f36628d);
        } else {
            imageView = this.f36626b;
            z = true;
        }
        imageView.setSelected(z);
        this.f36627c.a(this.f36629e);
        this.f36627c.a(this.f36628d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36627c.b(this.f36629e);
        this.f36627c.b(this.f36628d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36626b = (ImageView) b(R.id.ksad_video_sound_switch);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.f36626b;
        if (view == imageView) {
            this.f36627c.a(!imageView.isSelected(), true);
            ImageView imageView2 = this.f36626b;
            imageView2.setSelected(!imageView2.isSelected());
        }
    }
}
