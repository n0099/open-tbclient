package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public abstract class a<T extends View> extends com.kwad.sdk.contentalliance.detail.b implements d<T> {

    /* renamed from: b  reason: collision with root package name */
    public T f33029b = null;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f33030c;

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33030c = (LinearLayout) b(R.id.ksad_photo_detail_bottom_toolbar);
        this.f33030c.addView(f(), new LinearLayout.LayoutParams(-2, -2));
        this.f33030c.setVisibility(0);
    }

    public T f() {
        if (this.f33029b == null) {
            this.f33029b = g();
        }
        return this.f33029b;
    }
}
