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
    public ImageView f59856b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f59857c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f59858d;

    /* renamed from: e  reason: collision with root package name */
    public j.a f59859e = new j.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.d.1
        @Override // com.kwad.sdk.utils.j.a
        public void a() {
            if (d.this.f59856b == null || com.kwad.sdk.core.config.b.F()) {
                return;
            }
            d.this.f59856b.post(new Runnable() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.d.1.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.f59856b.setSelected(false);
                    d.this.f59858d.a(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.j.a
        public void b() {
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59860f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f59856b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        ImageView imageView;
        boolean z;
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f59857c = aVar.f59455g;
        com.kwad.sdk.reward.c.a aVar2 = aVar.f59459k;
        this.f59858d = aVar2;
        KsVideoPlayConfig ksVideoPlayConfig = aVar.f59452d;
        if (!aVar2.a() && com.kwad.sdk.utils.b.a(q()).a()) {
            imageView = this.f59856b;
            z = false;
        } else if (ksVideoPlayConfig != null) {
            this.f59856b.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.f59858d.a(this.f59860f);
            this.f59858d.a(this.f59859e);
            x.a().addObserver(this);
        } else {
            imageView = this.f59856b;
            z = true;
        }
        imageView.setSelected(z);
        this.f59858d.a(this.f59860f);
        this.f59858d.a(this.f59859e);
        x.a().addObserver(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        x.a().deleteObserver(this);
        this.f59858d.b(this.f59860f);
        this.f59858d.b(this.f59859e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59856b = (ImageView) a(R.id.ksad_video_sound_switch);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.f59856b;
        if (view == imageView) {
            this.f59858d.a(!imageView.isSelected(), true);
            ImageView imageView2 = this.f59856b;
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
                AdTemplate adTemplate = this.f59857c;
                if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
                    this.f59858d.d();
                }
            } else if (c2 != 1) {
            } else {
                AdTemplate adTemplate2 = this.f59857c;
                if (adTemplate2.mXiaomiAppStoreDetailViewOpen && (sceneImpl2 = adTemplate2.mAdScene) != null && sceneImpl2.getAdStyle() == 2) {
                    this.f59858d.b();
                }
            }
        }
    }
}
