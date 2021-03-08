package com.kwad.sdk.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.webview.jshandler.a;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.draw.a.a {
    private FrameLayout b;
    @Nullable
    private c c;
    private a.b d = new a.b() { // from class: com.kwad.sdk.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (b.this.f6403a.f6404a != null) {
                b.this.f6403a.f6404a.onAdClicked();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f6403a.g;
        if (this.c == null) {
            return;
        }
        this.c.a(this.d);
        this.c.a(this.b, this.f6403a.b, this.f6403a.c, this.f6403a.d);
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
        this.b = (FrameLayout) b(R.id.ksad_play_end_web_card_container);
    }
}
