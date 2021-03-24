package com.kwad.sdk.contentalliance;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public abstract class c<T extends com.kwad.sdk.core.e.b> extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Presenter f31916a;

    /* renamed from: b  reason: collision with root package name */
    public T f31917b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f31918c;

    public c(Context context) {
        super(context);
        this.f31918c = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
    }

    public void a() {
        Presenter presenter = this.f31916a;
        if (presenter != null) {
            presenter.j();
        }
        this.f31918c = null;
    }

    public abstract T b();

    @NonNull
    public abstract Presenter c();

    @LayoutRes
    public abstract int getLayoutId();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f31917b = b();
        if (this.f31916a == null) {
            Presenter c2 = c();
            this.f31916a = c2;
            c2.a((View) this.f31918c);
        }
        this.f31916a.a(this.f31917b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        T t = this.f31917b;
        if (t != null) {
            t.a();
        }
        a();
    }
}
