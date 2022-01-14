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
/* loaded from: classes3.dex */
public abstract class a extends KSFrameLayout implements View.OnClickListener {
    public static int k = 8;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57191b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57192c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f57193d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f57194e;

    /* renamed from: f  reason: collision with root package name */
    public KsLogoView f57195f;

    /* renamed from: g  reason: collision with root package name */
    public ComplianceTextView f57196g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadProgressView f57197h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.reflux.b f57198i;

    /* renamed from: j  reason: collision with root package name */
    public a.InterfaceC2127a f57199j;

    public a(@NonNull Context context) {
        super(context);
        b(context, null, 0);
    }

    private void b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        a(context, attributeSet, i2);
        DownloadProgressView downloadProgressView = this.f57197h;
        if (downloadProgressView != null) {
            downloadProgressView.setOnClickListener(this);
        }
        setOnClickListener(this);
    }

    public void a(int i2, boolean z) {
        com.kwad.sdk.reflux.b bVar = this.f57198i;
        if (bVar == null) {
            return;
        }
        final AdTemplate c2 = bVar.c();
        com.kwad.sdk.core.download.a.a.a(new a.C2100a(bb.a(this)).a(c2).a(this.f57198i.n()).a(i2).a(z).a(new a.b() { // from class: com.kwad.sdk.reflux.kwai.a.1
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                a.this.a(c2);
            }
        }));
    }

    public abstract void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2);

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.j
    public void a(View view) {
        super.a(view);
        com.kwai.sodler.lib.a.b("BaseRefluxCardView", "onFirstVisible: " + getClass().getSimpleName());
        c();
    }

    public void a(AdTemplate adTemplate) {
        p.a aVar = new p.a();
        aVar.f56066g = getTouchCoords();
        com.kwad.sdk.reflux.b bVar = this.f57198i;
        if (bVar != null) {
            aVar.z = bVar.j();
        }
        com.kwad.sdk.core.report.a.a(adTemplate, aVar, (JSONObject) null);
        a.InterfaceC2127a interfaceC2127a = this.f57199j;
        if (interfaceC2127a != null) {
            interfaceC2127a.a();
        }
    }

    public void a(com.kwad.sdk.reflux.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f57198i = bVar;
        if (this.a != null && bVar.d() != null) {
            this.a.setText(bVar.d());
        }
        if (this.f57191b != null && bVar.f() != null) {
            this.f57191b.setText(bVar.f());
        }
        if (this.f57192c != null && bVar.g() != null) {
            this.f57192c.setText(bVar.g());
        }
        AdTemplate c2 = bVar.c();
        if (c2 != null) {
            if (this.f57193d != null && bVar.e() != null) {
                KSImageLoader.loadAppIcon(this.f57193d, bVar.e(), c2, k);
            }
            if (this.f57194e != null && bVar.h() != null) {
                KSImageLoader.loadImage(this.f57194e, bVar.h(), c2);
            }
            KsLogoView ksLogoView = this.f57195f;
            if (ksLogoView != null) {
                ksLogoView.a(c2);
            }
            ComplianceTextView complianceTextView = this.f57196g;
            if (complianceTextView != null) {
                complianceTextView.setAdTemplate(c2);
            }
            DownloadProgressView downloadProgressView = this.f57197h;
            if (downloadProgressView != null) {
                downloadProgressView.a(c2);
            }
            AdInfo j2 = d.j(c2);
            DownloadProgressView downloadProgressView2 = this.f57197h;
            if (downloadProgressView2 != null) {
                downloadProgressView2.a(j2, bVar.l(), bVar.m());
            }
        }
    }

    public void c() {
        a.InterfaceC2127a interfaceC2127a;
        com.kwad.sdk.reflux.b bVar = this.f57198i;
        if (bVar == null) {
            return;
        }
        AdTemplate c2 = bVar.c();
        if (!c2.mPvReported && (interfaceC2127a = this.f57199j) != null) {
            interfaceC2127a.b();
        }
        p.a aVar = new p.a();
        com.kwad.sdk.reflux.b bVar2 = this.f57198i;
        if (bVar2 != null) {
            aVar.z = bVar2.j();
        }
        com.kwad.sdk.core.report.a.a(c2, (JSONObject) null, aVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.f57197h)) {
            a(1, true);
        } else if (view.equals(this)) {
            a(2, true);
        }
    }

    public void setAdClickListener(a.InterfaceC2127a interfaceC2127a) {
        this.f57199j = interfaceC2127a;
    }
}
