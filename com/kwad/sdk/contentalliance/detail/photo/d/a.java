package com.kwad.sdk.contentalliance.detail.photo.d;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public abstract class a<T extends View> extends Presenter implements com.kwad.sdk.contentalliance.detail.photo.f.d<T> {

    /* renamed from: a  reason: collision with root package name */
    protected c f8754a = null;

    /* renamed from: b  reason: collision with root package name */
    protected T f8755b = null;

    private T f() {
        if (this.f8755b == null) {
            this.f8755b = g();
        }
        return this.f8755b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8754a = (c) n();
        this.f8755b.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8755b.setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        e();
    }

    protected void e() {
        ((ViewGroup) l()).addView(f());
    }
}
