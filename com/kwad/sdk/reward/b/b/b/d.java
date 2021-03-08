package com.kwad.sdk.reward.b.b.b;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.utils.g;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.reward.d implements View.OnClickListener {
    private ImageView b;
    @NonNull
    private com.kwad.sdk.reward.c.a c;
    private g.a d = new g.a() { // from class: com.kwad.sdk.reward.b.b.b.d.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            if (d.this.b != null) {
                d.this.b.post(new Runnable() { // from class: com.kwad.sdk.reward.b.b.b.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.b.setSelected(false);
                        d.this.c.a(false, false);
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
        }
    };
    private com.kwad.sdk.contentalliance.detail.video.e e = new f() { // from class: com.kwad.sdk.reward.b.b.b.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.b.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f7028a.i;
        KsVideoPlayConfig ksVideoPlayConfig = this.f7028a.c;
        if (com.kwad.sdk.utils.b.a().b()) {
            this.b.setSelected(false);
        } else if (ksVideoPlayConfig != null) {
            this.b.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.b.setSelected(true);
        }
        this.c.a(this.e);
        this.c.a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.c.b(this.e);
        this.c.b(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (ImageView) b(R.id.ksad_video_sound_switch);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b) {
            this.c.a(!this.b.isSelected(), true);
            this.b.setSelected(this.b.isSelected() ? false : true);
        }
    }
}
