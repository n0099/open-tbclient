package com.kwad.sdk.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.webview.jshandler.a;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f10006b;
    @Nullable
    private c c;
    private a.b d = new a.b() { // from class: com.kwad.sdk.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (b.this.f9972a.f9973a != null) {
                b.this.f9972a.f9973a.onAdClicked();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f9972a.g;
        if (this.c == null) {
            return;
        }
        this.c.a(this.d);
        this.c.a(this.f10006b, this.f9972a.f9974b, this.f9972a.c, this.f9972a.d);
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
        this.f10006b = (FrameLayout) b(R.id.ksad_play_end_web_card_container);
    }
}
