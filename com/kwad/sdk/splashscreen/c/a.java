package com.kwad.sdk.splashscreen.c;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.splashscreen.e;
import com.kwad.sdk.splashscreen.f;
import com.kwad.sdk.widget.d;
/* loaded from: classes3.dex */
public class a implements d {
    public ViewStub a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f57854b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f57855c;

    /* renamed from: d  reason: collision with root package name */
    public View f57856d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f57857e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f57858f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57859g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57860h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public f f57861i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.widget.f f57862j;
    public b k;
    public com.kwad.sdk.splashscreen.a l;

    public a(ViewStub viewStub, KsAdWebView ksAdWebView, boolean z, b bVar) {
        this.a = viewStub;
        this.f57854b = ksAdWebView;
        this.k = bVar;
        this.f57860h = z;
    }

    private void a(ViewGroup viewGroup) {
        this.f57856d = viewGroup.findViewById(R.id.ksad_splash_actionbar_native);
        this.f57859g = (TextView) viewGroup.findViewById(R.id.ksad_splash_actionbar_text);
        this.f57862j = new com.kwad.sdk.widget.f(this.f57856d.getContext(), this.f57856d, this);
        a(e.a(this.f57857e, this.f57858f, this.k));
    }

    private void a(e eVar) {
        if (eVar == null) {
            return;
        }
        a(eVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        TextView textView = this.f57859g;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void a(boolean z, boolean z2) {
        f fVar = this.f57861i;
        if (fVar != null) {
            fVar.a(z, z2);
        }
    }

    public void a() {
        com.kwad.sdk.core.d.a.a("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.a + ", mSplashWebView: " + this.f57854b);
        ViewStub viewStub = this.a;
        if (viewStub == null || this.f57854b == null) {
            return;
        }
        if (this.f57855c == null) {
            ViewGroup viewGroup = (ViewGroup) viewStub.inflate();
            this.f57855c = viewGroup;
            a(viewGroup);
        }
        this.f57855c.setVisibility(0);
        this.f57854b.setVisibility(8);
    }

    public void a(AdTemplate adTemplate) {
        com.kwad.sdk.splashscreen.a aVar;
        this.f57857e = adTemplate;
        com.kwad.sdk.splashscreen.a aVar2 = this.l;
        if (aVar2 == null) {
            this.l = new com.kwad.sdk.splashscreen.a(adTemplate) { // from class: com.kwad.sdk.splashscreen.c.a.1
                @Override // com.kwad.sdk.splashscreen.a
                public void a(String str) {
                    a.this.a(str);
                }
            };
        } else {
            aVar2.a(adTemplate);
        }
        if (adTemplate != null) {
            this.f57858f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        }
        b bVar = this.k;
        if (bVar == null || (aVar = this.l) == null) {
            return;
        }
        bVar.a(aVar);
    }

    public void a(@Nullable f fVar) {
        this.f57861i = fVar;
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(true, view.equals(this.f57856d));
    }

    public void b() {
        com.kwad.sdk.splashscreen.a aVar;
        b bVar = this.k;
        if (bVar == null || (aVar = this.l) == null) {
            return;
        }
        bVar.b(aVar);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (this.f57860h) {
            a(false, view.equals(this.f57856d));
        }
    }
}
