package com.kwad.components.ad.splashscreen.f;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.f;
/* loaded from: classes10.dex */
public final class b implements com.kwad.sdk.widget.c {
    public a Ds;
    public ViewStub Fp;
    public ViewGroup Fq;
    public View Fr;
    public TextView Fs;
    public boolean Ft;
    @Nullable
    public e Fu;
    public f Fv;
    @NonNull
    public ViewGroup gS;
    @Nullable
    public AdInfo mAdInfo;
    @Nullable
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;

    public b(@NonNull ViewGroup viewGroup, ViewStub viewStub, boolean z, com.kwad.components.core.e.d.c cVar) {
        this.gS = viewGroup;
        this.Fp = viewStub;
        this.mApkDownloadHelper = cVar;
        this.Ft = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        TextView textView = this.Fs;
        if (textView != null && str != null) {
            textView.setText(str);
        }
    }

    private void a(com.kwad.components.ad.splashscreen.d dVar) {
        if (dVar == null) {
            return;
        }
        V(dVar.ks());
    }

    public final void ah(AdTemplate adTemplate) {
        a aVar;
        this.mAdTemplate = adTemplate;
        a aVar2 = this.Ds;
        if (aVar2 == null) {
            this.Ds = new a(this.gS.getContext(), this.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.f.b.1
                {
                    super(r3);
                }

                @Override // com.kwad.components.ad.splashscreen.f.a
                public final void k(int i, String str) {
                    b.this.V(str);
                }
            };
        } else {
            aVar2.setAdTemplate(adTemplate);
        }
        if (adTemplate != null) {
            this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        }
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null && (aVar = this.Ds) != null) {
            cVar.b(aVar);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (!this.Ft) {
            return;
        }
        i(false, view2.equals(this.Fr));
    }

    private void i(boolean z, boolean z2) {
        e eVar = this.Fu;
        if (eVar != null) {
            eVar.h(z, z2);
        }
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.Fr = viewGroup.findViewById(R.id.obfuscated_res_0x7f0914b0);
        this.Fs = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0914b3);
        this.Fv = new f(this.Fr.getContext(), this.Fr, this);
        a(com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, this.mApkDownloadHelper, 4));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        i(true, view2.equals(this.Fr));
    }

    public final void a(@Nullable e eVar) {
        this.Fu = eVar;
    }

    public final void lp() {
        com.kwad.sdk.core.e.c.d("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.Fp);
        if (this.Fq == null) {
            ViewStub viewStub = this.Fp;
            if (viewStub != null && viewStub.getParent() != null) {
                this.Fq = (ViewGroup) this.Fp.inflate();
            } else {
                this.Fq = (ViewGroup) this.gS.findViewById(R.id.obfuscated_res_0x7f0914b1);
            }
            g(this.Fq);
        }
        ViewGroup viewGroup = this.Fq;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public final void onUnbind() {
        a aVar;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null && (aVar = this.Ds) != null) {
            cVar.c(aVar);
        }
    }
}
