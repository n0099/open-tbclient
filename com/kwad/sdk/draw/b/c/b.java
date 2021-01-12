package com.kwad.sdk.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.webview.jshandler.a;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f9707b;
    @Nullable
    private c c;
    private a.b d = new a.b() { // from class: com.kwad.sdk.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (b.this.f9673a.f9674a != null) {
                b.this.f9673a.f9674a.onAdClicked();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f9673a.g;
        if (this.c == null) {
            return;
        }
        this.c.a(this.d);
        this.c.a(this.f9707b, this.f9673a.f9675b, this.f9673a.c, this.f9673a.d);
        this.c.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.c != null) {
            this.c.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9707b = (FrameLayout) b(R.id.ksad_play_end_web_card_container);
    }
}
