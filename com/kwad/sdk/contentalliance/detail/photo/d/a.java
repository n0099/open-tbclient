package com.kwad.sdk.contentalliance.detail.photo.d;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public abstract class a<T extends View> extends Presenter implements com.kwad.sdk.contentalliance.detail.photo.f.d<T> {

    /* renamed from: a  reason: collision with root package name */
    public c f32924a = null;

    /* renamed from: b  reason: collision with root package name */
    public T f32925b = null;

    private T f() {
        if (this.f32925b == null) {
            this.f32925b = g();
        }
        return this.f32925b;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32924a = (c) n();
        this.f32925b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32925b.setOnClickListener(null);
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
