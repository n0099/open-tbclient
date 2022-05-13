package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.x;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes5.dex */
public class d extends g implements View.OnClickListener, Observer {
    public ImageView b;
    public AdTemplate c;
    @NonNull
    public com.kwad.sdk.reward.c.a d;
    public j.a e = new j.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.d.1
        @Override // com.kwad.sdk.utils.j.a
        public void a() {
            if (d.this.b == null || com.kwad.sdk.core.config.b.F()) {
                return;
            }
            d.this.b.post(new Runnable() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.d.1.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.b.setSelected(false);
                    d.this.d.a(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.j.a
        public void b() {
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        ImageView imageView;
        boolean z;
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.c = aVar.g;
        com.kwad.sdk.reward.c.a aVar2 = aVar.k;
        this.d = aVar2;
        KsVideoPlayConfig ksVideoPlayConfig = aVar.d;
        if (!aVar2.a() && com.kwad.sdk.utils.b.a(q()).a()) {
            imageView = this.b;
            z = false;
        } else if (ksVideoPlayConfig != null) {
            this.b.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.d.a(this.f);
            this.d.a(this.e);
            x.a().addObserver(this);
        } else {
            imageView = this.b;
            z = true;
        }
        imageView.setSelected(z);
        this.d.a(this.f);
        this.d.a(this.e);
        x.a().addObserver(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        x.a().deleteObserver(this);
        this.d.b(this.f);
        this.d.b(this.e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ImageView) a(R.id.obfuscated_res_0x7f091185);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ImageView imageView = this.b;
        if (view2 == imageView) {
            this.d.a(!imageView.isSelected(), true);
            ImageView imageView2 = this.b;
            imageView2.setSelected(!imageView2.isSelected());
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        SceneImpl sceneImpl;
        SceneImpl sceneImpl2;
        if (observable.equals(x.a()) && (obj instanceof String)) {
            String str = (String) obj;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1891028138) {
                if (hashCode == 321925954 && str.equals("ACTION_APP_GO_TO_BACKGROUND")) {
                    c = 0;
                }
            } else if (str.equals("ACTION_APP_BACK_TO_FOREGROUND")) {
                c = 1;
            }
            if (c == 0) {
                AdTemplate adTemplate = this.c;
                if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
                    this.d.d();
                }
            } else if (c != 1) {
            } else {
                AdTemplate adTemplate2 = this.c;
                if (adTemplate2.mXiaomiAppStoreDetailViewOpen && (sceneImpl2 = adTemplate2.mAdScene) != null && sceneImpl2.getAdStyle() == 2) {
                    this.d.b();
                }
            }
        }
    }
}
