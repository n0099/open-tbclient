package com.kwad.sdk.contentalliance;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public abstract class b<T extends com.kwad.sdk.core.e.b> extends FrameLayout {
    public Presenter a;
    public T b;
    public ViewGroup c;

    public b(Context context) {
        super(context);
        this.c = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
    }

    public void a() {
        Presenter presenter = this.a;
        if (presenter != null) {
            presenter.k();
        }
        this.c = null;
    }

    public abstract T b();

    @NonNull
    public abstract Presenter c();

    @LayoutRes
    public abstract int getLayoutId();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = b();
        if (this.a == null) {
            Presenter c = c();
            this.a = c;
            c.c(this.c);
        }
        this.a.a(this.b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        T t = this.b;
        if (t != null) {
            t.a();
        }
        a();
    }
}
