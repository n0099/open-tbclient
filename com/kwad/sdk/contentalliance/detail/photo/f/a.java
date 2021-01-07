package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
/* loaded from: classes5.dex */
public abstract class a<T extends View> extends com.kwad.sdk.contentalliance.detail.b implements d<T> {

    /* renamed from: b  reason: collision with root package name */
    protected T f8814b = null;
    protected LinearLayout c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c = (LinearLayout) b(R.id.ksad_photo_detail_bottom_toolbar);
        this.c.addView(f(), new LinearLayout.LayoutParams(-2, -2));
        this.c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T f() {
        if (this.f8814b == null) {
            this.f8814b = g();
        }
        return this.f8814b;
    }
}
