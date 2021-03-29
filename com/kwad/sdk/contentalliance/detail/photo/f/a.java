package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public abstract class a<T extends View> extends com.kwad.sdk.contentalliance.detail.b implements d<T> {

    /* renamed from: b  reason: collision with root package name */
    public T f32359b = null;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f32360c;

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32360c = (LinearLayout) b(R.id.ksad_photo_detail_bottom_toolbar);
        this.f32360c.addView(f(), new LinearLayout.LayoutParams(-2, -2));
        this.f32360c.setVisibility(0);
    }

    public T f() {
        if (this.f32359b == null) {
            this.f32359b = g();
        }
        return this.f32359b;
    }
}
