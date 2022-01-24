package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.x;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class d extends g implements View.OnClickListener, Observer {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f57637b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f57638c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f57639d;

    /* renamed from: e  reason: collision with root package name */
    public j.a f57640e = new j.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.d.1
        @Override // com.kwad.sdk.utils.j.a
        public void a() {
            if (d.this.f57637b == null || com.kwad.sdk.core.config.b.F()) {
                return;
            }
            d.this.f57637b.post(new Runnable() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.d.1.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.f57637b.setSelected(false);
                    d.this.f57639d.a(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.j.a
        public void b() {
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f57641f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f57637b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        ImageView imageView;
        boolean z;
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f57638c = aVar.f57252g;
        com.kwad.sdk.reward.c.a aVar2 = aVar.k;
        this.f57639d = aVar2;
        KsVideoPlayConfig ksVideoPlayConfig = aVar.f57249d;
        if (!aVar2.a() && com.kwad.sdk.utils.b.a(q()).a()) {
            imageView = this.f57637b;
            z = false;
        } else if (ksVideoPlayConfig != null) {
            this.f57637b.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.f57639d.a(this.f57641f);
            this.f57639d.a(this.f57640e);
            x.a().addObserver(this);
        } else {
            imageView = this.f57637b;
            z = true;
        }
        imageView.setSelected(z);
        this.f57639d.a(this.f57641f);
        this.f57639d.a(this.f57640e);
        x.a().addObserver(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        x.a().deleteObserver(this);
        this.f57639d.b(this.f57641f);
        this.f57639d.b(this.f57640e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57637b = (ImageView) a(R.id.ksad_video_sound_switch);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.f57637b;
        if (view == imageView) {
            this.f57639d.a(!imageView.isSelected(), true);
            ImageView imageView2 = this.f57637b;
            imageView2.setSelected(!imageView2.isSelected());
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        SceneImpl sceneImpl;
        SceneImpl sceneImpl2;
        if (observable.equals(x.a()) && (obj instanceof String)) {
            String str = (String) obj;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1891028138) {
                if (hashCode == 321925954 && str.equals("ACTION_APP_GO_TO_BACKGROUND")) {
                    c2 = 0;
                }
            } else if (str.equals("ACTION_APP_BACK_TO_FOREGROUND")) {
                c2 = 1;
            }
            if (c2 == 0) {
                AdTemplate adTemplate = this.f57638c;
                if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
                    this.f57639d.d();
                }
            } else if (c2 != 1) {
            } else {
                AdTemplate adTemplate2 = this.f57638c;
                if (adTemplate2.mXiaomiAppStoreDetailViewOpen && (sceneImpl2 = adTemplate2.mAdScene) != null && sceneImpl2.getAdStyle() == 2) {
                    this.f57639d.b();
                }
            }
        }
    }
}
