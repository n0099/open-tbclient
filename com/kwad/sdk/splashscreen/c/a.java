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
/* loaded from: classes5.dex */
public class a implements d {
    public ViewStub a;
    public KsAdWebView b;
    public ViewGroup c;
    public View d;
    @Nullable
    public AdTemplate e;
    @Nullable
    public AdInfo f;
    public TextView g;
    public boolean h;
    @Nullable
    public f i;
    public com.kwad.sdk.widget.f j;
    public b k;
    public com.kwad.sdk.splashscreen.a l;

    public a(ViewStub viewStub, KsAdWebView ksAdWebView, boolean z, b bVar) {
        this.a = viewStub;
        this.b = ksAdWebView;
        this.k = bVar;
        this.h = z;
    }

    private void a(ViewGroup viewGroup) {
        this.d = viewGroup.findViewById(R.id.obfuscated_res_0x7f091137);
        this.g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091139);
        this.j = new com.kwad.sdk.widget.f(this.d.getContext(), this.d, this);
        a(e.a(this.e, this.f, this.k));
    }

    private void a(e eVar) {
        if (eVar == null) {
            return;
        }
        a(eVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        TextView textView = this.g;
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
        com.kwad.sdk.core.d.a.a("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.a + ", mSplashWebView: " + this.b);
        ViewStub viewStub = this.a;
        if (viewStub == null || this.b == null) {
            return;
        }
        if (this.c == null) {
            ViewGroup viewGroup = (ViewGroup) viewStub.inflate();
            this.c = viewGroup;
            a(viewGroup);
        }
        this.c.setVisibility(0);
        this.b.setVisibility(8);
    }

    public void a(AdTemplate adTemplate) {
        com.kwad.sdk.splashscreen.a aVar;
        this.e = adTemplate;
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
            this.f = com.kwad.sdk.core.response.a.d.j(adTemplate);
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
    public void a_(View view2) {
        a(true, view2.equals(this.d));
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
    public void b(View view2) {
        if (this.h) {
            a(false, view2.equals(this.d));
        }
    }
}
