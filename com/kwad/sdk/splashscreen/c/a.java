package com.kwad.sdk.splashscreen.c;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.splashscreen.e;
import com.kwad.sdk.splashscreen.f;
import com.kwad.sdk.widget.d;
/* loaded from: classes7.dex */
public class a implements d {
    public ViewStub a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f41313b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f41314c;

    /* renamed from: d  reason: collision with root package name */
    public View f41315d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f41316e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f41317f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41318g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41319h;
    @Nullable
    public f i;
    public com.kwad.sdk.widget.f j;
    public b k;
    public com.kwad.sdk.splashscreen.a l;

    public a(ViewStub viewStub, KsAdWebView ksAdWebView, boolean z, b bVar) {
        this.a = viewStub;
        this.f41313b = ksAdWebView;
        this.k = bVar;
        this.f41319h = z;
    }

    private void a(ViewGroup viewGroup) {
        this.f41315d = viewGroup.findViewById(R.id.obfuscated_res_0x7f09113e);
        this.f41318g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091140);
        this.j = new com.kwad.sdk.widget.f(this.f41315d.getContext(), this.f41315d, this);
        a(e.a(this.f41316e, this.f41317f, this.k));
    }

    private void a(e eVar) {
        if (eVar == null) {
            return;
        }
        a(eVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        TextView textView = this.f41318g;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void a(boolean z, boolean z2) {
        f fVar = this.i;
        if (fVar != null) {
            fVar.a(z, z2);
        }
    }

    public void a() {
        com.kwad.sdk.core.d.a.a("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.a + ", mSplashWebView: " + this.f41313b);
        ViewStub viewStub = this.a;
        if (viewStub == null || this.f41313b == null) {
            return;
        }
        if (this.f41314c == null) {
            ViewGroup viewGroup = (ViewGroup) viewStub.inflate();
            this.f41314c = viewGroup;
            a(viewGroup);
        }
        this.f41314c.setVisibility(0);
        this.f41313b.setVisibility(8);
    }

    public void a(AdTemplate adTemplate) {
        com.kwad.sdk.splashscreen.a aVar;
        this.f41316e = adTemplate;
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
            this.f41317f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        }
        b bVar = this.k;
        if (bVar == null || (aVar = this.l) == null) {
            return;
        }
        bVar.a(aVar);
    }

    public void a(@Nullable f fVar) {
        this.i = fVar;
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(true, view.equals(this.f41315d));
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
        if (this.f41319h) {
            a(false, view.equals(this.f41315d));
        }
    }
}
