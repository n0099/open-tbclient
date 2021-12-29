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

    /* renamed from: k  reason: collision with root package name */
    public static int f59438k = 8;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59439b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59440c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59441d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f59442e;

    /* renamed from: f  reason: collision with root package name */
    public KsLogoView f59443f;

    /* renamed from: g  reason: collision with root package name */
    public ComplianceTextView f59444g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadProgressView f59445h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.reflux.b f59446i;

    /* renamed from: j  reason: collision with root package name */
    public a.InterfaceC2110a f59447j;

    public a(@NonNull Context context) {
        super(context);
        b(context, null, 0);
    }

    private void b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        a(context, attributeSet, i2);
        DownloadProgressView downloadProgressView = this.f59445h;
        if (downloadProgressView != null) {
            downloadProgressView.setOnClickListener(this);
        }
        setOnClickListener(this);
    }

    public void a(int i2, boolean z) {
        com.kwad.sdk.reflux.b bVar = this.f59446i;
        if (bVar == null) {
            return;
        }
        final AdTemplate c2 = bVar.c();
        com.kwad.sdk.core.download.a.a.a(new a.C2083a(bb.a(this)).a(c2).a(this.f59446i.n()).a(i2).a(z).a(new a.b() { // from class: com.kwad.sdk.reflux.kwai.a.1
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
        aVar.f58267g = getTouchCoords();
        com.kwad.sdk.reflux.b bVar = this.f59446i;
        if (bVar != null) {
            aVar.z = bVar.j();
        }
        com.kwad.sdk.core.report.a.a(adTemplate, aVar, (JSONObject) null);
        a.InterfaceC2110a interfaceC2110a = this.f59447j;
        if (interfaceC2110a != null) {
            interfaceC2110a.a();
        }
    }

    public void a(com.kwad.sdk.reflux.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f59446i = bVar;
        if (this.a != null && bVar.d() != null) {
            this.a.setText(bVar.d());
        }
        if (this.f59439b != null && bVar.f() != null) {
            this.f59439b.setText(bVar.f());
        }
        if (this.f59440c != null && bVar.g() != null) {
            this.f59440c.setText(bVar.g());
        }
        AdTemplate c2 = bVar.c();
        if (c2 != null) {
            if (this.f59441d != null && bVar.e() != null) {
                KSImageLoader.loadAppIcon(this.f59441d, bVar.e(), c2, f59438k);
            }
            if (this.f59442e != null && bVar.h() != null) {
                KSImageLoader.loadImage(this.f59442e, bVar.h(), c2);
            }
            KsLogoView ksLogoView = this.f59443f;
            if (ksLogoView != null) {
                ksLogoView.a(c2);
            }
            ComplianceTextView complianceTextView = this.f59444g;
            if (complianceTextView != null) {
                complianceTextView.setAdTemplate(c2);
            }
            DownloadProgressView downloadProgressView = this.f59445h;
            if (downloadProgressView != null) {
                downloadProgressView.a(c2);
            }
            AdInfo j2 = d.j(c2);
            DownloadProgressView downloadProgressView2 = this.f59445h;
            if (downloadProgressView2 != null) {
                downloadProgressView2.a(j2, bVar.l(), bVar.m());
            }
        }
    }

    public void c() {
        a.InterfaceC2110a interfaceC2110a;
        com.kwad.sdk.reflux.b bVar = this.f59446i;
        if (bVar == null) {
            return;
        }
        AdTemplate c2 = bVar.c();
        if (!c2.mPvReported && (interfaceC2110a = this.f59447j) != null) {
            interfaceC2110a.b();
        }
        p.a aVar = new p.a();
        com.kwad.sdk.reflux.b bVar2 = this.f59446i;
        if (bVar2 != null) {
            aVar.z = bVar2.j();
        }
        com.kwad.sdk.core.report.a.a(c2, (JSONObject) null, aVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.f59445h)) {
            a(1, true);
        } else if (view.equals(this)) {
            a(2, true);
        }
    }

    public void setAdClickListener(a.InterfaceC2110a interfaceC2110a) {
        this.f59447j = interfaceC2110a;
    }
}
