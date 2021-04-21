package com.kwad.sdk.contentalliance.detail.photo.d;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public abstract class a<T extends View> extends Presenter implements com.kwad.sdk.contentalliance.detail.photo.f.d<T> {

    /* renamed from: a  reason: collision with root package name */
    public c f32642a = null;

    /* renamed from: b  reason: collision with root package name */
    public T f32643b = null;

    private T f() {
        if (this.f32643b == null) {
            this.f32643b = g();
        }
        return this.f32643b;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32642a = (c) n();
        this.f32643b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32643b.setOnClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        e();
    }

    public void e() {
        ((ViewGroup) l()).addView(f());
    }
}
