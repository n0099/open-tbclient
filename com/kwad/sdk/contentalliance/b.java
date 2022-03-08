package com.kwad.sdk.contentalliance;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes7.dex */
public abstract class b<T extends com.kwad.sdk.core.e.b> extends FrameLayout {
    public Presenter a;

    /* renamed from: b  reason: collision with root package name */
    public T f54114b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f54115c;

    public b(Context context) {
        super(context);
        this.f54115c = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
    }

    public void a() {
        Presenter presenter = this.a;
        if (presenter != null) {
            presenter.k();
        }
        this.f54115c = null;
    }

    public abstract T b();

    @NonNull
    public abstract Presenter c();

    @LayoutRes
    public abstract int getLayoutId();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f54114b = b();
        if (this.a == null) {
            Presenter c2 = c();
            this.a = c2;
            c2.c(this.f54115c);
        }
        this.a.a(this.f54114b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        T t = this.f54114b;
        if (t != null) {
            t.a();
        }
        a();
    }
}
