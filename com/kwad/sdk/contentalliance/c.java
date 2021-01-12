package com.kwad.sdk.contentalliance;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes4.dex */
public abstract class c<T extends com.kwad.sdk.core.e.b> extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    protected Presenter f8278a;

    /* renamed from: b  reason: collision with root package name */
    protected T f8279b;
    protected ViewGroup c;

    public c(Context context) {
        super(context);
        this.c = (ViewGroup) inflate(getContext(), getLayoutId(), this);
    }

    protected void a() {
        if (this.f8278a != null) {
            this.f8278a.j();
        }
        this.c = null;
    }

    protected abstract T b();

    @NonNull
    public abstract Presenter c();

    @LayoutRes
    protected abstract int getLayoutId();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8279b = b();
        if (this.f8278a == null) {
            this.f8278a = c();
            this.f8278a.a((View) this.c);
        }
        this.f8278a.a(this.f8279b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f8279b != null) {
            this.f8279b.a();
        }
        a();
    }
}
