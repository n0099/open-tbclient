package com.kwad.sdk.reflux.kwai;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.a;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.KsLogoView;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a extends KSFrameLayout implements View.OnClickListener {
    public static int k = 8;
    public TextView a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public ImageView e;
    public KsLogoView f;
    public ComplianceTextView g;
    public DownloadProgressView h;
    public com.kwad.sdk.reflux.b i;
    public a.InterfaceC0322a j;

    public a(@NonNull Context context) {
        super(context);
        b(context, null, 0);
    }

    private void b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        a(context, attributeSet, i);
        DownloadProgressView downloadProgressView = this.h;
        if (downloadProgressView != null) {
            downloadProgressView.setOnClickListener(this);
        }
        setOnClickListener(this);
    }

    public void a(int i, boolean z) {
        com.kwad.sdk.reflux.b bVar = this.i;
        if (bVar == null) {
            return;
        }
        final AdTemplate c = bVar.c();
        com.kwad.sdk.core.download.a.a.a(new a.C0295a(bb.a(this)).a(c).a(this.i.n()).a(i).a(z).a(new a.b() { // from class: com.kwad.sdk.reflux.kwai.a.1
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                a.this.a(c);
            }
        }));
    }

    public abstract void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i);

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.j
    public void a(View view2) {
        super.a(view2);
        com.kwai.sodler.lib.a.b("BaseRefluxCardView", "onFirstVisible: " + getClass().getSimpleName());
        c();
    }

    public void a(AdTemplate adTemplate) {
        p.a aVar = new p.a();
        aVar.g = getTouchCoords();
        com.kwad.sdk.reflux.b bVar = this.i;
        if (bVar != null) {
            aVar.z = bVar.j();
        }
        com.kwad.sdk.core.report.a.a(adTemplate, aVar, (JSONObject) null);
        a.InterfaceC0322a interfaceC0322a = this.j;
        if (interfaceC0322a != null) {
            interfaceC0322a.a();
        }
    }

    public void a(com.kwad.sdk.reflux.b bVar) {
        if (bVar == null) {
            return;
        }
        this.i = bVar;
        if (this.a != null && bVar.d() != null) {
            this.a.setText(bVar.d());
        }
        if (this.b != null && bVar.f() != null) {
            this.b.setText(bVar.f());
        }
        if (this.c != null && bVar.g() != null) {
            this.c.setText(bVar.g());
        }
        AdTemplate c = bVar.c();
        if (c != null) {
            if (this.d != null && bVar.e() != null) {
                KSImageLoader.loadAppIcon(this.d, bVar.e(), c, k);
            }
            if (this.e != null && bVar.h() != null) {
                KSImageLoader.loadImage(this.e, bVar.h(), c);
            }
            KsLogoView ksLogoView = this.f;
            if (ksLogoView != null) {
                ksLogoView.a(c);
            }
            ComplianceTextView complianceTextView = this.g;
            if (complianceTextView != null) {
                complianceTextView.setAdTemplate(c);
            }
            DownloadProgressView downloadProgressView = this.h;
            if (downloadProgressView != null) {
                downloadProgressView.a(c);
            }
            AdInfo j = d.j(c);
            DownloadProgressView downloadProgressView2 = this.h;
            if (downloadProgressView2 != null) {
                downloadProgressView2.a(j, bVar.l(), bVar.m());
            }
        }
    }

    public void c() {
        a.InterfaceC0322a interfaceC0322a;
        com.kwad.sdk.reflux.b bVar = this.i;
        if (bVar == null) {
            return;
        }
        AdTemplate c = bVar.c();
        if (!c.mPvReported && (interfaceC0322a = this.j) != null) {
            interfaceC0322a.b();
        }
        p.a aVar = new p.a();
        com.kwad.sdk.reflux.b bVar2 = this.i;
        if (bVar2 != null) {
            aVar.z = bVar2.j();
        }
        com.kwad.sdk.core.report.a.a(c, (JSONObject) null, aVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.equals(this.h)) {
            a(1, true);
        } else if (view2.equals(this)) {
            a(2, true);
        }
    }

    public void setAdClickListener(a.InterfaceC0322a interfaceC0322a) {
        this.j = interfaceC0322a;
    }
}
