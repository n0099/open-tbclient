package com.kwad.components.ad.reflux.kwai;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class a extends KSFrameLayout implements View.OnClickListener {
    public static int hE = 8;
    public ComplianceTextView bc;
    public DownloadProgressView dk;
    public TextView li;
    public TextView lj;
    public TextView lk;
    public ImageView ll;
    public ImageView lm;
    public KsLogoView ln;
    public com.kwad.components.ad.reflux.a lo;
    public b.InterfaceC0655b lp;

    public a(@NonNull Context context) {
        super(context);
        a(context, null, 0);
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        M(context);
        DownloadProgressView downloadProgressView = this.dk;
        if (downloadProgressView != null) {
            downloadProgressView.setOnClickListener(this);
        }
        setOnClickListener(this);
    }

    private void br() {
        b.InterfaceC0655b interfaceC0655b;
        com.kwad.components.ad.reflux.a aVar = this.lo;
        if (aVar == null) {
            return;
        }
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.mPvReported && (interfaceC0655b = this.lp) != null) {
            interfaceC0655b.onAdShow();
        }
        f fVar = new f();
        com.kwad.components.ad.reflux.a aVar2 = this.lo;
        if (aVar2 != null) {
            fVar.aO(aVar2.eQ());
        }
        com.kwad.components.core.m.c.ox().a(adTemplate, null, fVar);
    }

    private void c(int i, boolean z) {
        com.kwad.components.ad.reflux.a aVar = this.lo;
        if (aVar == null) {
            return;
        }
        final AdTemplate adTemplate = aVar.getAdTemplate();
        com.kwad.components.core.c.a.a.a(new a.C0631a(com.kwad.sdk.b.kwai.a.x(this)).L(adTemplate).b(this.lo.getApkDownloadHelper()).ae(i).aj(true).a(new a.b() { // from class: com.kwad.components.ad.reflux.kwai.a.1
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                a.this.k(adTemplate);
            }
        }));
    }

    public abstract void M(@NonNull Context context);

    public void a(com.kwad.components.ad.reflux.a aVar) {
        if (aVar == null) {
            return;
        }
        this.lo = aVar;
        if (this.li != null && aVar.getTitle() != null) {
            this.li.setText(aVar.getTitle());
        }
        if (this.lj != null && aVar.eM() != null) {
            this.lj.setText(aVar.eM());
        }
        if (this.lk != null && aVar.eN() != null) {
            this.lk.setText(aVar.eN());
        }
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (adTemplate != null) {
            if (this.ll != null && aVar.eL() != null) {
                KSImageLoader.loadAppIcon(this.ll, aVar.eL(), adTemplate, hE);
            }
            if (this.lm != null && aVar.eO() != null) {
                KSImageLoader.loadImage(this.lm, aVar.eO(), adTemplate);
            }
            KsLogoView ksLogoView = this.ln;
            if (ksLogoView != null) {
                ksLogoView.T(adTemplate);
            }
            ComplianceTextView complianceTextView = this.bc;
            if (complianceTextView != null) {
                complianceTextView.setAdTemplate(adTemplate);
            }
            DownloadProgressView downloadProgressView = this.dk;
            if (downloadProgressView != null) {
                downloadProgressView.F(adTemplate);
            }
            AdInfo bQ = d.bQ(adTemplate);
            DownloadProgressView downloadProgressView2 = this.dk;
            if (downloadProgressView2 != null) {
                downloadProgressView2.a(bQ, aVar.eS(), aVar.eT());
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void k(View view2) {
        super.k(view2);
        com.kwad.sdk.core.e.b.d("BaseRefluxCardView", "onFirstVisible: " + getClass().getSimpleName());
        br();
    }

    public final void k(AdTemplate adTemplate) {
        f b = new f().b(getTouchCoords());
        com.kwad.components.ad.reflux.a aVar = this.lo;
        if (aVar != null) {
            b.aO(aVar.eQ());
        }
        com.kwad.sdk.core.report.a.a(adTemplate, b, (JSONObject) null);
        b.InterfaceC0655b interfaceC0655b = this.lp;
        if (interfaceC0655b != null) {
            interfaceC0655b.onAdClicked();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.equals(this.dk)) {
            c(1, true);
        } else if (view2.equals(this)) {
            c(3, true);
        }
    }

    public void setAdClickListener(b.InterfaceC0655b interfaceC0655b) {
        this.lp = interfaceC0655b;
    }
}
